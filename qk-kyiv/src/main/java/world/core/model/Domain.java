package world.core.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table (name="wcdomain")
public class Domain extends PanacheEntity {
    @Column(nullable=false, length = 3, unique = true)
    public String code;
    @Column(nullable=false, length = 50)
    public String domain;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Domain dom = (Domain) o;
        return code.equals(dom.code) &&
            domain.equals(dom.domain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code,domain);
    }
}