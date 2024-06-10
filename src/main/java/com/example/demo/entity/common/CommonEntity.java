package com.example.demo.entity.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.sql.Timestamp;

@Setter
@Getter
@MappedSuperclass
public class CommonEntity implements Serializable {

    @ApiModelProperty(dataType = "java.lang.Long", example = "20240610192830")
//    @ApiModelProperty(dataType = "java.lang.Long")
    @Column(name = "create_date", nullable = false, updatable = false)
    private Timestamp createDate;

    @ApiModelProperty(dataType = "java.lang.Long")
    @Column(name = "update_date", nullable = false)
    private Timestamp updateDate;

    @PrePersist
    public void onPrePersist() {
        setCreateDate(new Timestamp(System.currentTimeMillis()));
        setUpdateDate(new Timestamp(System.currentTimeMillis()));
    }

    @PreUpdate
    public void onPreUpdate() {
        setUpdateDate(new Timestamp(System.currentTimeMillis()));
    }
}
