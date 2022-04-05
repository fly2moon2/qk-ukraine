package app.config.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import world.core.model.ActiveStatus;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;


@Entity
//@Table (name="akpref")
@Table (name="akpref", uniqueConstraints={@UniqueConstraint(name="uk_akpref01",columnNames={"code_id","prefscope","forobjid"})})
//@Inheritance(strategy = InheritanceType.JOINED)
public class Preference extends PanacheEntity {
    //@ElementCollection
    //@CollectionTable(name="akprefscope")
    //public Set<PreferenceScope> scope=new HashSet<>();
    //public PreferenceCode prefCode;
    @JsonbTransient
    @ManyToOne(fetch = FetchType.LAZY)
    public PreferenceCode code;
    @Column(nullable=false, length = 5)
    @Enumerated(EnumType.STRING)
    public PreferenceScope prefScope;
    public Long forObjId;
/*     // true/false, no need to change to custom type, 'Y'/'N'
    // @org.hibernate.annotations.Type(type = "yes_no")
    @Column(nullable=false)
    public Boolean onoff; */
    @Column(nullable=false, length = 1)
    @Enumerated(EnumType.STRING)
    public ActiveStatus actStatus;
    public Float minVal;
    public Float maxVal;
    public String parm;
    @CreationTimestamp
    public LocalDate crtdOn;
    @UpdateTimestamp
    public LocalDateTime lastUpdOn;
    

    public static Preference findByCode(PreferenceCode code){
        return find("code",code).firstResult();
    }


    public static Preference findByCodeScopeObj(PreferenceCode code, PreferenceScope scope, Long forObjId){
        return find("code=?1 and prefScope=?2 and forObjId=?3",code,scope,forObjId).firstResult();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Preference pref = (Preference) o;
        return code.equals(pref.code) &&
            prefScope.equals(pref.prefScope) &&
            forObjId.equals(pref.forObjId);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(code,prefScope,forObjId);
    }
}
