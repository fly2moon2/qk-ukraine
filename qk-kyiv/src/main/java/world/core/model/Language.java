package world.core.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ElementCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.HashSet;
import java.util.Set;

import javax.json.bind.annotation.JsonbTransient;
import javax.json.bind.annotation.JsonbVisibility;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;

@Entity
@Table (name="wclang")
public class Language extends PanacheEntity {
    //public Long id;
    @Column(nullable=false, length = 3)
    public String code;
    @Column(nullable=false, length = 30)
    public String lang;

    
    @OneToMany(
        mappedBy = "lang",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    public Set<Locale> locales=new HashSet<>();
    //public List<Locale> locales = new ArrayList<>();
    
/* 
    @ElementCollection
    @CollectionTable(name="wclocale")
    @MapKeyColumn(name = "code")
    @Column(name = "locale")
    @org.hibernate.annotations.SortComparator(ReverseStringComparator.class)
    private SortedMap<String, String> locales = new TreeMap<>();
*/



    public static Language findByCode(String code){
        return find("code",code.toUpperCase()).firstResult();
    }

    public void addLocale(Locale locale) {
        locales.add(locale);
        locale.lang=this;
    }
 
    public void removeLocale(Locale locale) {
        locales.remove(locale);
        locale.lang=null;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Language lang = (Language) o;
      return code.equals(lang.code) &&
            this.lang.equals(lang.lang);
    }
  
    @Override
    public int hashCode() {
      return Objects.hash(code,this.lang);
    }
}
