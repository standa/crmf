/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.model.service;

import cz.crmf.model.dao.GenericDao;

/**
 *
 * @author mickapa1
 */
public abstract class AbstractDataAccessService {
//    @Autowired
    protected GenericDao genericDao;
    public void setGenericDao(GenericDao genericDao) {
        this.genericDao = genericDao;
    }

    public GenericDao getGenericDao() {
        return genericDao;
    }    
}