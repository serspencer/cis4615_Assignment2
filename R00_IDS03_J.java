//Wrong Code
if (loginSuccessful) {
    logger.severe("User login succed for: " + username);
}   else {
    logger.severe("User login failed for: " + username);
}

//Correct Code

if (loginSuccessful) {
    logger.severe("User login succeeded for: " + sanitizeUser(username));
} else {
    logger.severe("User login failed for: " + sanitizeUser(username));
}

public String sanitizeUser(String username) {
    return Patter. mathces("[A-Za-z0-9_]+", username)) ? username : "unauthorized user";
}