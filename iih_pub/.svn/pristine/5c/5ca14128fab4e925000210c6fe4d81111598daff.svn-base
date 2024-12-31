package iih.bd.srv.oth.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.oth.d.desc.MedSrvWordFreqDODesc;
import java.math.BigDecimal;

/**
 * 医疗服务词频统计 DO数据 
 * 
 */
public class MedSrvWordFreqDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_WORDFREQ= "Id_wordfreq";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_DEPT= "Id_dept";
	public static final String ID_EMP= "Id_emp";
	public static final String BIZ_CLASSTYPE= "Biz_classtype";
	public static final String ID_BIZ= "Id_biz";
	public static final String CNT= "Cnt";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_wordfreq() {
		return ((String) getAttrVal("Id_wordfreq"));
	}	
	public void setId_wordfreq(String Id_wordfreq) {
		setAttrVal("Id_wordfreq", Id_wordfreq);
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
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}	
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	public String getBiz_classtype() {
		return ((String) getAttrVal("Biz_classtype"));
	}	
	public void setBiz_classtype(String Biz_classtype) {
		setAttrVal("Biz_classtype", Biz_classtype);
	}
	public String getId_biz() {
		return ((String) getAttrVal("Id_biz"));
	}	
	public void setId_biz(String Id_biz) {
		setAttrVal("Id_biz", Id_biz);
	}
	public Integer getCnt() {
		return ((Integer) getAttrVal("Cnt"));
	}	
	public void setCnt(Integer Cnt) {
		setAttrVal("Cnt", Cnt);
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
		return "Id_wordfreq";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srvoth_wordfreq";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MedSrvWordFreqDODesc.class);
	}
	
}