package com.products.productsmvc.service.map;

import com.products.productsmvc.domain.DomainObject;
import com.products.productsmvc.domain.User;
import com.products.productsmvc.service.UserService;

import java.util.List;

/**
 * This class implements the methods for handling user data.
 */
public class UserServiceMapImpl extends MapService implements UserService {
    /**
     * Returns a list of all the available users.
     * @return a list of all the users.
     */
    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    /**
     * Returns the user with a given id.
     * @param id Id of user.
     * @return The user object with the given id.
     */
    @Override
    public User getById(Integer id) {
        return (User) super.getById(id);
    }

    /**
     * Save or update a user.
     * @param domainObject The user that has to be saved or updated.
     * @return The saved user object.
     */
    @Override
    public User saveOrUpdate(User domainObject) {
        return (User) super.saveOrUpdate(domainObject);
    }

    /**
     * Delete a user.
     * @param id Id of user.
     */
    @Override
    public void delete(Integer id) {
        super.delete(id);
    }
}
