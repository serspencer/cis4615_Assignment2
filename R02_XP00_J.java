//Wrong Methond
public void delteFile() {
    File someFile = new File("someFileName.txt");
    // Do something with file
    someFile.delete();
}

//Corect Method
public void delteFile(){
    File someFile = new File("someFileNaME.txt");
    // Do somehting with file
    if (!someFile.delete()) {
        //Handle Failure
    }
}