/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.model.dao;

import cz.crmf.model.bo.AbstractBusinessObject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Implementuje (hibernatem) akce GenericDao zpusobem obvyklym pro
 * prumerne dao.
 * 
 * Tato implementace je postavena nad JPA + rozsirenimi frameworku Hibernate
 * 
 * @author Pavel Micka (mickapa1@fel.cvut.cz)
 */
//@Component("genericDao")
public class GenericHibernateJpaDao implements GenericDao {

//    @Autowired
    protected EntityManagerFactory entityManagerfactory;

    /**
     * Get entity manager for the current transaction
     * @return
     */
    protected EntityManager getEntityManager() {
        return entityManagerfactory.createEntityManager();
//        return EntityManagerFactoryUtils.getTransactionalEntityManager(entityManagerfactory); //entity manager with @Transactional support
    }

    /**
     * Vrati vsechny objekty dane tridy
     *
     * @return vsechny objekty tridy, jez je injektovana jako clazz, serazene
     *         dle id sestupne
     */
    @Override
    public <ENTITY> List<ENTITY> getAll(Class<ENTITY> clazz) {
        return getEntityManager().createQuery("SELECT e FROM " + clazz.getSimpleName() + " e").getResultList();
    }

    /**
     * Vrati vsechny objekty serazene sestupne dle dane property
     *
     * @param property
     * @return
     */
    @Override
    public <ENTITY> List<ENTITY> getAllOrderedDesc(String property, Class<ENTITY> clazz) {
        throw new IllegalStateException("Not implemented yet");
    }

    /**
     * Vrati vsechny objekty serazene vzestupne dle dane property
     *
     * @param property
     * @return
     */
    @Override
    public <ENTITY> List<ENTITY> getAllOrderedAsc(String property, Class<ENTITY> clazz) {
        throw new IllegalStateException("Not implemented yet");
    }

    /**
     * Vrati objekty dane tridy, jejichz property se rovna objektu predanemu v
     * parametru, serazene dle id sestupne
     *
     * @param property
     *            property, kterou porovnavame
     * @param value
     *            hodnota, se kterou porovnavame
     * @return vsechny vyhovujici zaznamy
     */
    @Override
    public <ENTITY> List<ENTITY> getByProperty(String property, Object value, Class<ENTITY> clazz) {
        String queryString = "SELECT e FROM " + clazz.getSimpleName() + " e WHERE e." + property + " = :value";
        return getEntityManager().createQuery(queryString).setParameter("value", value).getResultList();
    }

    /**
     * Smaze objekt dle daneho ID
     *
     * @param id id objektu je smazani
     */
    @Override
    public <ENTITY extends AbstractBusinessObject> void removeById(long id, Class<ENTITY> clazz) {
        ENTITY e = getEntityManager().find(clazz, id);
        if (e != null) {
            getEntityManager().remove(e);
        }
    }

    /**
     * smaze danou entitu
     *
     * @param o
     *            entita ke smazani
     */
    @Override
    public <ENTITY extends AbstractBusinessObject> void remove(ENTITY o) {
        getEntityManager().remove(o);
    }

    /**
     * Vrati objekt (pomoci get) dane tridy dle ID
     *
     * @param id
     * id objektu k vraceni
     * @return objekt identifikovany id, @null pokud neexistuje
     */
    @SuppressWarnings("unchecked")
    @Override
    public <ENTITY> ENTITY getById(Long id, Class<ENTITY> clazz) {
        return getEntityManager().find(clazz, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <ENTITY> ENTITY loadById(long id, Class<ENTITY> clazz) {
        throw new IllegalStateException("Not implemented yet");
//        return (ENTITY) ((Session) getEntityManager().getDelegate()).load(clazz, id);
    }

    @Override
    public <ENTITY extends AbstractBusinessObject> ENTITY saveOrUpdate(ENTITY o) {
        throw new IllegalStateException("Not implemented yet");
//        if (o.getId() == null) {
//            getEntityManager().persist(o);
//        } else {
//            getEntityManager().merge(o);
//        }
//        return o;
    }

    @Override
    public <ENTITY> ENTITY getByPropertyUnique(String property, Object value, Class<ENTITY> clazz) {
        ENTITY e;
        if (value == null) {
            e = clazz.cast(getEntityManager().createQuery("FROM " + clazz.getSimpleName() + " WHERE " + property + " IS NULL" ).getSingleResult());
        } else {
            e = clazz.cast(getEntityManager().createQuery("FROM " + clazz.getSimpleName() + " WHERE " + property + " = :value" ).setParameter("value", value).getSingleResult());
        }
        return e;
    }

    @Override
    public Long getCount(Class clazz) {
        throw new IllegalStateException("Not implemented yet");
    }

    @Override
    public <ENTITY> List<ENTITY> getPage(int from, int maxResults, Class<ENTITY> clazz) {
        throw new IllegalStateException("Not implemented yet");
    }

    @Override
    public <ENTITY> List<ENTITY> getPage(int first, int rows, String sortBy, boolean ascending, Class<ENTITY> clazz) {
        throw new IllegalStateException("Not implemented yet");
    }

    public void merge(Object o) {
        throw new IllegalStateException("Not implemented yet");
    }
}