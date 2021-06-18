package com.solution.shared.domain;



import lombok.Data;

import java.time.Instant;




public abstract class Domain  {
    protected   String createdBy;
    protected   Instant createdDate;
    protected    String   lastModifiedBy;
    protected   Instant lastModifiedDate;


}
