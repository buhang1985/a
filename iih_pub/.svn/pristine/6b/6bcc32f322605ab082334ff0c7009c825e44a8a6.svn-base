package iih.pe.pitm.pestdweight.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.pestdweight.d.desc.PeStdWeightDODesc;
import java.math.BigDecimal;

/**
 * 体检标准体重定义 DO数据 
 * 
 */
public class PeStdWeightDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PESTDWEIGHT= "Id_pestdweight";
	public static final String ID_PESTDWEIGHT_PAR= "Id_pestdweight_par";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String HEIGHT_BEGIN= "Height_begin";
	public static final String HEIGHT_END= "Height_end";
	public static final String SEXLIMIT= "Sexlimit";
	public static final String AGE_BEGIN= "Age_begin";
	public static final String AGE_END= "Age_end";
	public static final String STDWEIGHT= "Stdweight";
	public static final String SORTNO= "Sortno";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pestdweight() {
		return ((String) getAttrVal("Id_pestdweight"));
	}	
	public void setId_pestdweight(String Id_pestdweight) {
		setAttrVal("Id_pestdweight", Id_pestdweight);
	}
	public String getId_pestdweight_par() {
		return ((String) getAttrVal("Id_pestdweight_par"));
	}	
	public void setId_pestdweight_par(String Id_pestdweight_par) {
		setAttrVal("Id_pestdweight_par", Id_pestdweight_par);
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
	public String getHeight_begin() {
		return ((String) getAttrVal("Height_begin"));
	}	
	public void setHeight_begin(String Height_begin) {
		setAttrVal("Height_begin", Height_begin);
	}
	public Integer getHeight_end() {
		return ((Integer) getAttrVal("Height_end"));
	}	
	public void setHeight_end(Integer Height_end) {
		setAttrVal("Height_end", Height_end);
	}
	public Integer getSexlimit() {
		return ((Integer) getAttrVal("Sexlimit"));
	}	
	public void setSexlimit(Integer Sexlimit) {
		setAttrVal("Sexlimit", Sexlimit);
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
	public Integer getStdweight() {
		return ((Integer) getAttrVal("Stdweight"));
	}	
	public void setStdweight(Integer Stdweight) {
		setAttrVal("Stdweight", Stdweight);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
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
		return "Id_pestdweight";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_pestdweight";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeStdWeightDODesc.class);
	}
	
}