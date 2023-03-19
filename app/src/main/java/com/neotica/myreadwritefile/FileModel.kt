package com.neotica.myreadwritefile

//Step 3: Create a data class to contain the data from the input
data class FileModel(
    var filename: String? = null,
    var data: String? = null
)