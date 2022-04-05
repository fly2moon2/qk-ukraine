package world.core.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name="wcreltyp")
public class RelationType extends PanacheEntity {
 
    @Column(nullable=false, length = 3)
    public String code;
    @Column(nullable=false, length = 30)
    public String relTyp;
    @Column(length = 50)
    public String dscrp;


    public static Locale findByCode(String code){
        return find("code",code).firstResult();
    }


@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RelationType relTyp = (RelationType) o;
    return code.equals(relTyp.code) &&
        this.relTyp.equals(relTyp.relTyp);
    }

@Override
public int hashCode() {
    return Objects.hash(code,this.relTyp);
    }
}
