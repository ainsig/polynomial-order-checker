public class InvalidPolynomialSyntax extends Throwable {

    String message;

    public InvalidPolynomialSyntax(String message){

        this.message = message;

    }

    public InvalidPolynomialSyntax(String message, Throwable cause) {
        super(message, cause);
    }
}
