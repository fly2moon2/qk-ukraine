package app.config.model;

import java.util.HashSet;
import java.util.Set;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import world.core.model.ActiveStatus;

@Entity
@Table (name="akprefcde", uniqueConstraints={@UniqueConstraint(name="uk_akprefcde01",columnNames={"code"})})
public class PreferenceCode extends PanacheEntity {
    @JsonbTransient
    @ManyToOne(fetch = FetchType.LAZY)
    public PreferenceCat cat;
    @Column(nullable=false, length = 5, unique = true)
    public String code;
    @Column(nullable=false, length = 50)
    public String dscrp;
    @Column(nullable=false, length = 1)
    @Enumerated(EnumType.STRING)
    public ActiveStatus actStatus;


    @OneToMany(
        mappedBy = "code",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    public Set<Preference> prefs=new HashSet<>();

    // findByCode - common use case, find from active codes (ActiveStatus.Active) only
    public static PreferenceCode findByCode(String code){
        return findByCode(code, ActiveStatus.A);
    }

    // findByCode - if status param. is null, find code from all records regardless of status
    public static PreferenceCode findByCode(String code, ActiveStatus status){
        return status != null ? find("code=?1 and actStatus=?2",code.toUpperCase(),status).firstResult()
        : find("code",code.toUpperCase()).firstResult();
    }
}
