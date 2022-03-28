package app.shadow.model;

import java.time.LocalDate;

public class AppLog {

    public Severity severityLevel;
    public Long tranId;
    public AppLayer retAppLayer;

    public String payLoad;

    public ModelEntityFamily relEntityA;
    public Long relEntityAId;
    public ModelEntityFamily relEntityB;
    public Long relEntityBId;
    public LocalDate crtdOn;

    public Severity getSeverityLevel(){
        return severityLevel;
    }

    public void setSeverityLevel(Severity _severityLevel){
        severityLevel=_severityLevel;
    }

    public Long getTranId(){
        return tranId;
    }

    public void setTranId(Long _tranId){
        tranId=_tranId;
    }

    public AppLayer getRetAppLayer(){
        return retAppLayer;
    }

    public void setRetAppLayer(AppLayer _retAppLayer){
        retAppLayer=_retAppLayer;
    }

    public String getPayLoad(){
        return payLoad;
    }

    public void setPayLoad(String _payLoad){
        payLoad=_payLoad;
    }

    public ModelEntityFamily getRelEntityA(){
        return relEntityA;
    }

    public void setRetEntityA(ModelEntityFamily _relEntityA){
        relEntityA=_relEntityA;
    }

    public Long getRelEntityAId(){
        return relEntityAId;
    }

    public void setRelEntityAId(Long _relEntityAId){
        relEntityAId=_relEntityAId;
    }
    
    public ModelEntityFamily getRelEntityB(){
        return relEntityB;
    }

    public void setRetEntityB(ModelEntityFamily _relEntityB){
        relEntityB=_relEntityB;
    }

    public Long getRelEntityBId(){
        return relEntityBId;
    }

    public void setRelEntityBId(Long _relEntityBId){
        relEntityBId=_relEntityBId;
    }

}