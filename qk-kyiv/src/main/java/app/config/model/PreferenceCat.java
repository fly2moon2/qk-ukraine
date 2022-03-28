package app.config.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import io.quarkus.hibernate.orm.panache.PanacheEntity;


@Entity
@Table (name="akprefcat", uniqueConstraints={@UniqueConstraint(name="uk_akprefcat01",columnNames={"code"})})
public class PreferenceCat extends PanacheEntity {
    @Column(nullable=false, length = 5, unique = true)
    public String code;
    @Column(nullable=false, length = 50)
    public String dscrp;

    @OneToMany(
        mappedBy = "cat",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    public Set<PreferenceCode> prefcdes=new HashSet<>();

    public static PreferenceCat findByCode(String code){
        return find("code",code.toUpperCase()).firstResult();
    }
}
