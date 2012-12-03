/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.model.service;

import cz.crmf.model.dao.GenericDao;
import cz.crmf.model.dao.GenericHibernateJpaDao;

/**
 *
 * @author mickapa1
 */
public abstract class AbstractDataAccessService {
    
//  no-spring work-around    
    public AbstractDataAccessService() {
        genericDao = new GenericHibernateJpaDao();
    }
    
//    @Autowired
    protected GenericDao genericDao;
    public void setGenericDao(GenericDao genericDao) {
        this.genericDao = genericDao;
    }

    public GenericDao getGenericDao() {
        return genericDao;
    }    
}