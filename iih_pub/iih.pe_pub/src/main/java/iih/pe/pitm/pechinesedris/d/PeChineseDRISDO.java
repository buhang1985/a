package iih.pe.pitm.pechinesedris.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.pechinesedris.d.desc.PeChineseDRISDODesc;
import java.math.BigDecimal;

/**
 * 体检中国居民膳食营养素参考日摄入量 DO数据 
 * 
 */
public class PeChineseDRISDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PECHINESEDRIS= "Id_pechinesedris";
	public static final String ID_PECHINESEDRIS_PAR= "Id_pechinesedris_par";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String AGE_BEGIN= "Age_begin";
	public static final String AGE_END= "Age_end";
	public static final String SEXLIMIT= "Sexlimit";
	public static final String LABOURCA= "Labourca";
	public static final String WEIGHT= "Weight";
	public static final String ENERGY= "Energy";
	public static final String PROTEIN= "Protein";
	public static final String FAT= "Fat";
	public static final String CARBOHYDRATE= "Carbohydrate";
	public static final String CA= "Ca";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pechinesedris() {
		return ((String) getAttrVal("Id_pechinesedris"));
	}	
	public void setId_pechinesedris(String Id_pechinesedris) {
		setAttrVal("Id_pechinesedris", Id_pechinesedris);
	}
	public String getId_pechinesedris_par() {
		return ((String) getAttrVal("Id_pechinesedris_par"));
	}	
	public void setId_pechinesedris_par(String Id_pechinesedris_par) {
		setAttrVal("Id_pechinesedris_par", Id_pechinesedris_par);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public Integer getAge_begin() {
		return ((Integer) getAttrVal("Age_begin"));
	}	
	public void setAge_begin(Integer Age_begin) {
		setAttrVal("Age_begin", Age_begin);
	}
	public Integer getAge_end() {
		return ((Integer) getAttrVal("Age_end"));
	}	
	public void setAge_end(Integer Age_end) {
		setAttrVal("Age_end", Age_end);
	}
	public Integer getSexlimit() {
		return ((Integer) getAttrVal("Sexlimit"));
	}	
	public void setSexlimit(Integer Sexlimit) {
		setAttrVal("Sexlimit", Sexlimit);
	}
	public Integer getLabourca() {
		return ((Integer) getAttrVal("Labourca"));
	}	
	public void setLabourca(Integer Labourca) {
		setAttrVal("Labourca", Labourca);
	}
	public FDouble getWeight() {
		return ((FDouble) getAttrVal("Weight"));
	}	
	public void setWeight(FDouble Weight) {
		setAttrVal("Weight", Weight);
	}
	public FDouble getEnergy() {
		return ((FDouble) getAttrVal("Energy"));
	}	
	public void setEnergy(FDouble Energy) {
		setAttrVal("Energy", Energy);
	}
	public FDouble getProtein() {
		return ((FDouble) getAttrVal("Protein"));
	}	
	public void setProtein(FDouble Protein) {
		setAttrVal("Protein", Protein);
	}
	public FDouble getFat() {
		return ((FDouble) getAttrVal("Fat"));
	}	
	public void setFat(FDouble Fat) {
		setAttrVal("Fat", Fat);
	}
	public FDouble getCarbohydrate() {
		return ((FDouble) getAttrVal("Carbohydrate"));
	}	
	public void setCarbohydrate(FDouble Carbohydrate) {
		setAttrVal("Carbohydrate", Carbohydrate);
	}
	public FDouble getCa() {
		return ((FDouble) getAttrVal("Ca"));
	}	
	public void setCa(FDouble Ca) {
		setAttrVal("Ca", Ca);
	}
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_pechinesedris";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_pechinesedris";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeChineseDRISDODesc.class);
	}
	
}