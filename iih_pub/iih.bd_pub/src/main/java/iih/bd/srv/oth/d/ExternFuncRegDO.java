package iih.bd.srv.oth.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.oth.d.desc.ExternFuncRegDODesc;
import java.math.BigDecimal;

/**
 * 外挂函数注册 DO数据 
 * 
 */
public class ExternFuncRegDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_EXTERNFUN= "Id_externfun";
	public static final String FULLCLASSNAME= "Fullclassname";
	public static final String DISPLAYNAME= "Displayname";
	public static final String CNT_PARAM= "Cnt_param";
	public static final String PARAMSSTR= "Paramsstr";
	public static final String RETURNTYPE= "Returntype";
	public static final String DES_EXTERNFUN= "Des_externfun";
	public static final String DES_PARAMS= "Des_params";
	public static final String NOTE= "Note";
	public static final String ID_EXTERNFUNTP= "Id_externfuntp";
	public static final String SD_EXTERNFUNTP= "Sd_externfuntp";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_externfun() {
		return ((String) getAttrVal("Id_externfun"));
	}	
	public void setId_externfun(String Id_externfun) {
		setAttrVal("Id_externfun", Id_externfun);
	}
	public String getFullclassname() {
		return ((String) getAttrVal("Fullclassname"));
	}	
	public void setFullclassname(String Fullclassname) {
		setAttrVal("Fullclassname", Fullclassname);
	}
	public String getDisplayname() {
		return ((String) getAttrVal("Displayname"));
	}	
	public void setDisplayname(String Displayname) {
		setAttrVal("Displayname", Displayname);
	}
	public Integer getCnt_param() {
		return ((Integer) getAttrVal("Cnt_param"));
	}	
	public void setCnt_param(Integer Cnt_param) {
		setAttrVal("Cnt_param", Cnt_param);
	}
	public String getParamsstr() {
		return ((String) getAttrVal("Paramsstr"));
	}	
	public void setParamsstr(String Paramsstr) {
		setAttrVal("Paramsstr", Paramsstr);
	}
	public String getReturntype() {
		return ((String) getAttrVal("Returntype"));
	}	
	public void setReturntype(String Returntype) {
		setAttrVal("Returntype", Returntype);
	}
	public String getDes_externfun() {
		return ((String) getAttrVal("Des_externfun"));
	}	
	public void setDes_externfun(String Des_externfun) {
		setAttrVal("Des_externfun", Des_externfun);
	}
	public String getDes_params() {
		return ((String) getAttrVal("Des_params"));
	}	
	public void setDes_params(String Des_params) {
		setAttrVal("Des_params", Des_params);
	}
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	public String getId_externfuntp() {
		return ((String) getAttrVal("Id_externfuntp"));
	}	
	public void setId_externfuntp(String Id_externfuntp) {
		setAttrVal("Id_externfuntp", Id_externfuntp);
	}
	public String getSd_externfuntp() {
		return ((String) getAttrVal("Sd_externfuntp"));
	}	
	public void setSd_externfuntp(String Sd_externfuntp) {
		setAttrVal("Sd_externfuntp", Sd_externfuntp);
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
		return "Id_externfun";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_extern_fun";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ExternFuncRegDODesc.class);
	}
	
}