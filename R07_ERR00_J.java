//Incorrect Method
try {
    /// Your Statement
} catch (IOException ioe) {
    ioe.printStackTrace();
}

//Correct Method

boolean validFlag = flase;
do {
    try {
        //...
        // If requested file does not exist, throws FileNotFoundException
        // If requested file exists, sets validFlag to true
    } catch (FileNotFoundException e ) {
        //Ask for a different file name
    }
} while ( validFlag != true);
