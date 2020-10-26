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
} while ( validFlag != true);  //This alwows for waiting until a proper file is found.  Otherwise the program would just end with and have to be restarted.
//  THis is Rule 07 for Eception Behavior
//  Specifically Do not suppress or ignore checked exceptions
