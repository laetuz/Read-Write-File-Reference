package com.neotica.myreadwritefile

import android.content.Context

//Step 5: Change the class into internal object
internal object FileHelper {
    //Step 6: Create a function to write the file
    //Step 6.1 Define a parameter that calls FileModel, and one parameter that refers to the context
    fun writeToFile(fileModel: FileModel, context: Context) {
        //Step 6.2: Output the file by using Context.
        context.openFileOutput(fileModel.filename, Context.MODE_PRIVATE).use {
            //Step 6.3: Use the .use keyword so the data won't leak.
            //Step 6.4: Reference to FileOutputStream
            it.write(
                //Step 6.5: Write to fileModel.data and convert to Byte Array
                fileModel.data?.toByteArray()
            )
        }
    }

    //Step 7: Create a function to read the file
    //Step 7.1: Define a parameter that refers to the context and the filename to be read
    fun readFromFile(context: Context, fileName: String): FileModel {
        //Step 7.2: Define the FileModel() class as variable
        val fileModel = FileModel()
        //Step 7.3: Call from the parameter and Call filename from FileModel.
        fileModel.filename = fileName
        //Step 7.4: For the data, refer from the context and open file input. Inside the parameter, insert fileName
        fileModel.data = context.openFileInput(fileName)
            //Step 7.5: Use buffered reader to read the input stream
            .bufferedReader()
            //Step 7.6: use .useLines to read the contents of a file
            .useLines { lines ->
                //Step 7.7: Use .fold to concatenate all the lines into a single string
                lines.fold("") { some, text ->
                    "$some\n$text"
                }
            }
        //Step 7.8 return to fileModel
        return fileModel
    }
}