package com.products.productsmvc.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Superclass for domain entities
 */
@MappedSuperclass
public class AbstractDomainClass implements DomainObject {
    /** The id of the domain entity. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    /** The version of the domain entity. */
    @Version
    private Integer version;

    /** The date of creation in the database. */
    private Date dateCreated;

    /** The date of the last update in the database. */
    private Date lastUpdated;

    /**
     * Returns the id of the domain entity as an Integer.
     * @return The id of the domain entity.
     */
    @Override
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of the cartDetail to the value of the id parameter.
     * @param id The id to set.
     */
    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Returns the version of the domain entity as an Integer.
     * @return The version of the domain entity.
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * Sets the version of the cartDetail to the value of the version parameter.
     * @param version The version to set.
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * Returns the creation date of the domain entity as a Date.
     * @return The creation date of the domain entity.
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * Returns the last update of the domain entity as a Date.
     * @return The last update of the domain entity.
     */
    public Date getLastUpdated() {
        return lastUpdated;
    }


    /**
     * Update the timestamps on saving to the database.
     */
    @PreUpdate
    @PrePersist
    public void updateTimeStamps() {
        lastUpdated = new Date();
        if (dateCreated==null) {
            dateCreated = new Date();
        }
    }
}
