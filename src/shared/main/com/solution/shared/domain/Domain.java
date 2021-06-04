package com.solution.shared.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashMap;

public abstract class Domain  {
    protected  DomainCreatedBy createdBy;
    protected  DomainCreatedDate createdDate;
    protected  DomainLastModifiedBy lastModifiedBy;
    protected  DomainLastModifiedDate lastModifiedDate;

    public Domain() {
        createdBy = null;
        createdDate = null;
        lastModifiedBy = null;
        lastModifiedDate = null;
    }
    protected Domain(DomainCreatedBy createdBy) {
        this.createdBy = createdBy;
        this.lastModifiedBy = new DomainLastModifiedBy(createdBy.value());
        this.createdDate = new DomainCreatedDate(Instant.now());
        this.lastModifiedDate = new DomainLastModifiedDate(Instant.now());
    }
    public abstract HashMap<String, Serializable> toPrimitives();

    public DomainCreatedBy createdBy() {
        return createdBy;
    }

    public DomainCreatedDate createdDate() {
        return createdDate;
    }

    public DomainLastModifiedBy lastModifiedBy() {
        return lastModifiedBy;
    }

    public DomainLastModifiedDate lastModifiedDate() {
        return lastModifiedDate;
    }

    public Domain(DomainCreatedBy createdBy, DomainCreatedDate createdDate, DomainLastModifiedBy lastModifiedBy, DomainLastModifiedDate lastModifiedDate) {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
    }
}
