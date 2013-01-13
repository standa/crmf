package cz.crmf.rest;

/**
 * List of all possible results the REST API can return.
 * 
 * @author standa
 */
public enum ResultCode {
    
    OK(200, "OK"),
    ACCESS_DENIED(403, "Access to the resource denied."),
    NOT_FOUND(404, "The resource you were looking for does not exist."),
    ERROR(400, "General error occured.");
    

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
