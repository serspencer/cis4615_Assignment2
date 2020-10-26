//Wrong Methond

BigInteger x - new BigInteger("530500452766");
byte[] byteArray = x.toByteArray();
String s = new String(byteArray);
byteArray = s.getBytes();
x = new BigInteger(byteArray);

//Correct Method
BigInteger x - new BigInteger("530500452766");
String s - x.toString(); //Valid charater data
byte[] byteArray = s.getBytes();
String ns = new String(byteArray);
x = newBigInteger(ns);