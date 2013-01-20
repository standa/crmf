package cz.crmf.service.iface;

import cz.crmf.model.dao.GenericDao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Fields common to all the services.
 * 
 * @author standa
 */
public abstract class AbstractDataAccessService {
        
    @Autowired
    protected GenericDao genericDao;
    
    protected ModelMapper modelMapper = new ModelMapper();
    
    public void setGenericDao(GenericDao genericDao) {
        this.genericDao = genericDao;
    }

    public GenericDao getGenericDao() {
        return genericDao;
    }    
    
    public ModelMapper getModelMapper() {
        return modelMapper;
    }
}