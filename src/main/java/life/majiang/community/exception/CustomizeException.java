package life.majiang.community.exception;

/**
 * @author c_sir
 * @create 2020-03-25 15:17
 */
public class CustomizeException extends RuntimeException {
    private String message;

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.message = errorCode.getMessage();
    }
    public CustomizeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
