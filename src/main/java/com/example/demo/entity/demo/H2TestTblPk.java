package com.example.demo.entity.demo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Embeddable
public class H2TestTblPk implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "TEST_ID", length = 9, nullable = false)
    private Integer testId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        H2TestTblPk that = (H2TestTblPk) o;
        return Objects.equals(testId, that.testId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(testId);
    }
}
