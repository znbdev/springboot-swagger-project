package com.example.demo.entity.demo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
//@Table(schema = "test_db", name = "H2_TEST_TBL")
@Table(name = "H2_TEST_TBL")
public class H2TestTbl extends AbstractEntity {

    @EmbeddedId
    private H2TestTblPk h2TestTblPk;

    @Column(name = "NAME")
    private String name;
    @Column(name = "TEST_TIMESTAMP")
    private Timestamp testTimestamp;
    @Column(name = "TEST_LOCAL_DATE_TIME")
    private LocalDateTime testLocalDateTime;
    @Column(name = "TEST_ZONED_DATE_TIME")
    private ZonedDateTime testZonedDateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        H2TestTbl h2TestTbl = (H2TestTbl) o;
        return Objects.equals(h2TestTblPk, h2TestTbl.h2TestTblPk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(h2TestTblPk);
    }
}
