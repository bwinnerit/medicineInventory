public class InvalidEmailAddressException extends Exception
{
    InvalidEmailAddressException(String emailAddress, String errorMessage)
    {
        System.out.println("ERROR :: The e-mail '" + emailAddress+"' is invalid --> " + errorMessage);
    }
}