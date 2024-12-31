package iih.bd.srv.oth.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.oth.d.desc.SrvDescCfgDODesc;
import java.math.BigDecimal;

/**
 * 医嘱服务描述配置信息 DO数据 
 * 
 */
public class SrvDescCfgDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID= "Id";
	public static final String ID_PARENT= "Id_parent";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String SRVREFFORMID= "Srvrefformid";
	public static final String SRVCACODE= "Srvcacode";
	public static final String COLNAME= "Colname";
	public static final String COLDESC= "Coldesc";
	public static final String REFRELTYPE= "Refreltype";
	public static final String REFRELTYPENAME= "Refreltypename";
	public static final String REFRELTYPESEQ= "Refreltypeseq";
	public static final String SEQ= "Seq";
	public static final String FG_CFGABLE= "Fg_cfgable";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId() {
		return ((String) getAttrVal("Id"));
	}	
	public void setId(String Id) {
		setAttrVal("Id", Id);
	}
	public String getId_parent() {
		return ((String) getAttrVal("Id_parent"));
	}	
	public void setId_parent(String Id_parent) {
		setAttrVal("Id_parent", Id_parent);
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
	public String getSrvrefformid() {
		return ((String) getAttrVal("Srvrefformid"));
	}	
	public void setSrvrefformid(String Srvrefformid) {
		setAttrVal("Srvrefformid", Srvrefformid);
	}
	public String getSrvcacode() {
		return ((String) getAttrVal("Srvcacode"));
	}	
	public void setSrvcacode(String Srvcacode) {
		setAttrVal("Srvcacode", Srvcacode);
	}
	public String getColname() {
		return ((String) getAttrVal("Colname"));
	}	
	public void setColname(String Colname) {
		setAttrVal("Colname", Colname);
	}
	public String getColdesc() {
		return ((String) getAttrVal("Coldesc"));
	}	
	public void setColdesc(String Coldesc) {
		setAttrVal("Coldesc", Coldesc);
	}
	public String getRefreltype() {
		return ((String) getAttrVal("Refreltype"));
	}	
	public void setRefreltype(String Refreltype) {
		setAttrVal("Refreltype", Refreltype);
	}
	public String getRefreltypename() {
		return ((String) getAttrVal("Refreltypename"));
	}	
	public void setRefreltypename(String Refreltypename) {
		setAttrVal("Refreltypename", Refreltypename);
	}
	public Integer getRefreltypeseq() {
		return ((Integer) getAttrVal("Refreltypeseq"));
	}	
	public void setRefreltypeseq(Integer Refreltypeseq) {
		setAttrVal("Refreltypeseq", Refreltypeseq);
	}
	public Integer getSeq() {
		return ((Integer) getAttrVal("Seq"));
	}	
	public void setSeq(Integer Seq) {
		setAttrVal("Seq", Seq);
	}
	public FBoolean getFg_cfgable() {
		return ((FBoolean) getAttrVal("Fg_cfgable"));
	}	
	public void setFg_cfgable(FBoolean Fg_cfgable) {
		setAttrVal("Fg_cfgable", Fg_cfgable);
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
		return "Id";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srvoth_desccfg";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SrvDescCfgDODesc.class);
	}
	
}