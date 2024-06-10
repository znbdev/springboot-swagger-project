package com.example.demo.entity.demo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@MappedSuperclass
public class AbstractEntity implements Serializable {

    private Timestamp createDate;

    private String creatorCd;

    private Timestamp updateDate;

    private String operatorCd;

    private String operator;

    @Column(nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    public Timestamp timeStamp;

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
