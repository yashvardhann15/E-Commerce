package com.example.product.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    private long id;
    private Date createdAt;
    private Date lastModifiedAt;
    private boolean isDeleted;
}
