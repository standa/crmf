package cz.crmf.rest;

import java.io.Serializable;

/**
 * The object that will later be serialized in the REST API.
 * @author standa
 */
public class Result {
    
    boolean ok = true;
    ResultCode code = ResultCode.OK;
    Serializable data;

    public ResultCode getCode() {
        return code;
    }

    public void setCode(ResultCode code) {
        this.code = code;
    }

    public Serializable getData() {
        return data;
    }

    public void setData(Serializable data) {
        this.data = data;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }
    
    /**
     * if everything is alright and you just want to let the users know
     */
    public Result() {
        
    }
    
    /**
     * all ok and add some external data to the result
     * @param data 
     */
    public Result(Serializable data) {
        this.data = data;
    }
    
    /**
     * 
     * @param ok if the request processed ok / or not
     * @param code the result code
     */
    public Result(boolean ok, ResultCode code) {
        this.ok = ok;
        this.code = code;
    }
    
}
