package com.products.productsmvc.service;

import com.products.productsmvc.domain.DomainObject;

import java.util.*;

/**
 * This abstract class provides the methods for handling domain object data.
 */
public abstract class AbstractMapService {

    /**
     * The map to store domain objects.
     * The key is the id, the value is the domain object.
     */
    protected Map<Integer, DomainObject> domainMap;

    /**
     * Public Constructor.
     */
    public AbstractMapService() {
        domainMap = new HashMap<>();
        loadDomainObjects();
    }

    /**
     * Returns a list of the available domain objects.
     * @return a list of all the domain objects.
     */
    public List<DomainObject> listAll() {
        return new ArrayList<>(domainMap.values());
    }

    /**
     * Returns the domain object with a given id.
     * @param id Id of domain object.
     * @return The domain object with the given id.
     */
    public DomainObject getById(Integer id) {
        return domainMap.get(id);
    }

    /**
     * Save or update a domain object.
     * @param domainObject The domain object that has to be saved or updated.
     * @return The saved domain object.
     */
    public DomainObject saveOrUpdate(DomainObject domainObject) {
        if (domainObject != null){

            if (domainObject.getId() == null){
                domainObject.setId(getNextKey());
            }
            domainMap.put(domainObject.getId(), domainObject);

            return domainObject;
        } else {
            throw new RuntimeException("Object Can't be null");
        }
    }

    /**
     * Delete a domain object.
     * @param id Id of domain object.
     */
    public void delete(Integer id) {
        domainMap.remove(id);
    }

    /**
     * Calculates the next key in the keySet. Increments the last one by 1.
     * @return The next key in the keySet
     */
    private Integer getNextKey(){
        return Collections.max(domainMap.keySet()) + 1;
    }

    /**
     * Load the domain objects into a HashMap.
     */
    protected abstract void loadDomainObjects();
}
