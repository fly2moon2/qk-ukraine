package app.log.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import app.core.AppLayer;
import app.core.ModelEntityFamily;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table (name="agapplog")
//@Table (name="akpref", uniqueConstraints={@UniqueConstraint(name="uk_akpref01",columnNames={"code_id","prefscope","forobjid"})})
//@Inheritance(strategy = InheritanceType.JOINED)
public class AppLog extends PanacheEntity {
    // severity of the event whether error, critical etc.
    @Column(nullable=false, length = 5)
    @Enumerated(EnumType.STRING)
    public Severity severityLevel;
    // trans. id of the app., an attempt to group log entries related to a given trans.
    public Long tranId;
    // applayer which returns the event/error code
    @Column(length = 5)
    @Enumerated(EnumType.STRING)
    public AppLayer retAppLayer;
    @Column(length = 5)
    public String retCode;
    // payload
    @Column(length = 100)
    public String payLoad;
    // key related entities (at most 2) and the instance id (applicable to 1 instance only)
    @Column(length = 5)
    public ModelEntityFamily relEntityA;
    public Long relEntityAId;
    @Column(length = 5)
    public ModelEntityFamily relEntityB;
    public Long relEntityBId;
    @CreationTimestamp
    public LocalDate crtdOn;

    public static AppLog findByTranId(Long tranId){
        return find("tranId",tranId).firstResult();
    }

    @Override
    public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppLog appLog = (AppLog) o;
        return tranId.equals(appLog.tranId) &&
        crtdOn.equals(appLog.crtdOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tranId, crtdOn);
    }

}