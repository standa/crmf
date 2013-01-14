package cz.crmf.rest;

/**
 * List of all possible results the REST API can return.
 * 
 * @author standa
 */
public enum ResultCode {
    
    OK(200, "OK"),
    ERROR(400, "General error occured."),
    UNAUTHORIZED(401, "Unauthorized access."),
    PAYMENT_REQUIRED(402, "Payment required."),
    FORBIDDEN(403, "Access to the resource denied."),
    NOT_FOUND(404, "The resource you were looking for does not exist."),
    NOT_ACCEPTABLE(406, "The request composition is not acceptable."),
    CONFLICT(409, "The request could not be completed due to a conflict with the current state of the resource."),
    GONE(410, "The requested resource is no longer available at the server.");
    

    int code;
    String message;

    private ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
    
    public int getCode() {
        return code;
    }
    
    public String getMessage() {
        return message;
    }
    
    @Override
    public String toString() {
        return getCode()+" "+getMessage();
    }
      
}
