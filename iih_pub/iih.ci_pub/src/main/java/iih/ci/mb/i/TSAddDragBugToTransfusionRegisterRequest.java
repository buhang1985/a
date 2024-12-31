package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import xap.sys.mb.i.ArrayOfString;

public class TSAddDragBugToTransfusionRegisterRequest
{
    @JsonProperty(value = "registerID")
    private String registerID;
    @JsonProperty(value = "addPrescriptionIDs")
    private ArrayOfString addPrescriptionIDs;
    @JsonProperty(value = "addDrugBagList")
    private ArrayOfTSDrugBag addDrugBagList;

    public void setRegisterID(String registerID)
    {
        this.registerID = registerID;
    }
    public String getRegisterID()
    {
        return this.registerID;
    }
    public void setAddPrescriptionIDs(ArrayOfString addPrescriptionIDs)
    {
        this.addPrescriptionIDs = addPrescriptionIDs;
    }
    public ArrayOfString getAddPrescriptionIDs()
    {
        return this.addPrescriptionIDs;
    }
    public void setAddDrugBagList(ArrayOfTSDrugBag addDrugBagList)
    {
        this.addDrugBagList = addDrugBagList;
    }
    public ArrayOfTSDrugBag getAddDrugBagList()
    {
        return this.addDrugBagList;
    }
}
