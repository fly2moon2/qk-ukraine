package world.core.model;

import java.util.Objects;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

//@Embeddable
@Entity
@Table (name="wclocale")
public class Locale extends PanacheEntity {
    @Column(nullable=false, length = 5)
    public String code;
    @Column(nullable=false, length = 30)
    public String locale;


    // @JosonbTransient for this field is necessary to address
    // the jsonb error of unable to serialize the property.
    // This happens when trying to serialize the parent (language)
    // via REST API into json, in which case the children collection
    // (locale) is retrieved.  At this field (lang) in the child class (locale)
    // points back to the parent (lang), it causes a circular reference.
    // By using @JsonbTransient this circular reference is avoid. 
    // 
    // honor to: https://github.com/OpenLiberty/open-liberty/issues/15845
    @JsonbTransient
    // in searching solution for the above isssue on unable to serialize
    // the property when accessing REST API in json, it is found that
    // lazy fetching would cause problem.  However, it is later found that
    // circular reference is the root cause. @JsonbTransient is applied to
    // solve the issue.  Given the transient nature, no need to manipulate the
    // fetchtype (to EAGER)
    //@ManyToOne(fetch = FetchType.EAGER)
    @ManyToOne(fetch = FetchType.LAZY)
    public Language lang;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locale loc = (Locale) o;
        return code.equals(loc.code) &&
            locale.equals(loc.locale) &&
            lang.equals(loc.lang);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(code,locale);
    }

}