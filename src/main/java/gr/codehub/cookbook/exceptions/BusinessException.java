package gr.codehub.cookbook.exceptions;

public class BusinessException extends Exception {

    private final String message;
    private  int id;

    public BusinessException(int id, String message) {

        this.id = id;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
