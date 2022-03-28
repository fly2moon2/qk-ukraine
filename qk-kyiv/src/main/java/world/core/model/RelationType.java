package world.core.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

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
}
