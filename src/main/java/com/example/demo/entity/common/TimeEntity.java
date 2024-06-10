package com.example.demo.entity.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@MappedSuperclass
public class TimeEntity implements Serializable {

//    @ApiModelProperty(dataType = "java.lang.Long", example = "20240610192830")
//    @ApiModelProperty(dataType = "java.lang.Long")
    @Column(name = "create_date", nullable = false, updatable = false)
    private LocalDateTime createDate;

//    @ApiModelProperty(dataType = "java.lang.Long")
    @Column(name = "update_date", nullable = false)
    private LocalDateTime updateDate;

    @PrePersist
    public void onPrePersist() {
        setCreateDate(LocalDateTime.now());
        setUpdateDate(LocalDateTime.now());
    }

    @PreUpdate
    public void onPreUpdate() {
        setUpdateDate(LocalDateTime.now());
    }
}
