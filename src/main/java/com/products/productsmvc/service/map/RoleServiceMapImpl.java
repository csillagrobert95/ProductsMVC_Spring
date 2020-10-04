package com.products.productsmvc.service.map;

import com.products.productsmvc.domain.DomainObject;
import com.products.productsmvc.domain.security.Role;
import com.products.productsmvc.service.RoleService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class implements the methods for handling role data.
 */
@Service
@Profile("map")
public class RoleServiceMapImpl extends MapService implements RoleService{
    /**
     * Returns a list of all the available roles.
     * @return a list of all the roles.
     */
    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    /**
     * Returns the role with a given id.
     * @param id Id of role.
     * @return The role object with the given id.
     */
    @Override
    public Role getById(Integer id) {
        return (Role) super.getById(id);
    }

    /**
     * Save or update a role.
     * @param domainObject The role that has to be saved or updated.
     * @return The saved role object.
     */
    @Override
    public Role saveOrUpdate(Role domainObject) {
        return (Role) super.saveOrUpdate(domainObject);
    }

    /**
     * Delete a role.
     * @param id Id of role.
     */
    @Override
    public void delete(Integer id) {
        super.delete(id);
    }
}
