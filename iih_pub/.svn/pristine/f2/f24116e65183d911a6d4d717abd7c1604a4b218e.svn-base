package iih.sc.apt.scapt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.apt.scapt.d.desc.AptExChlDODesc;
import java.math.BigDecimal;

/**
 * 预约外部渠道 DO数据 
 * 
 */
public class AptExChlDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_APTEXCHL= "Id_aptexchl";
	public static final String ID_APT= "Id_apt";
	public static final String CODE_APT= "Code_apt";
	public static final String CODE_PAT= "Code_pat";
	public static final String CODE_PAT_PROXY= "Code_pat_proxy";
	public static final String EX_SEQNO= "Ex_seqno";
	public static final String CODE_DEP= "Code_dep";
	public static final String CODE_EMP_PHY= "Code_emp_phy";
	public static final String D_SC= "D_sc";
	public static final String AMPM= "Ampm";
	public static final String NAME_ORG_APPLY= "Name_org_apply";
	public static final String FG_TRANF= "Fg_tranf";
	public static final String CTRL1= "Ctrl1";
	public static final String CTRL2= "Ctrl2";
	public static final String CTRL3= "Ctrl3";
	public static final String CTRL4= "Ctrl4";
	public static final String CTRL5= "Ctrl5";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_aptexchl() {
		return ((String) getAttrVal("Id_aptexchl"));
	}	
	public void setId_aptexchl(String Id_aptexchl) {
		setAttrVal("Id_aptexchl", Id_aptexchl);
	}
	public String getId_apt() {
		return ((String) getAttrVal("Id_apt"));
	}	
	public void setId_apt(String Id_apt) {
		setAttrVal("Id_apt", Id_apt);
	}
	public String getCode_apt() {
		return ((String) getAttrVal("Code_apt"));
	}	
	public void setCode_apt(String Code_apt) {
		setAttrVal("Code_apt", Code_apt);
	}
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	public String getCode_pat_proxy() {
		return ((String) getAttrVal("Code_pat_proxy"));
	}	
	public void setCode_pat_proxy(String Code_pat_proxy) {
		setAttrVal("Code_pat_proxy", Code_pat_proxy);
	}
	public Integer getEx_seqno() {
		return ((Integer) getAttrVal("Ex_seqno"));
	}	
	public void setEx_seqno(Integer Ex_seqno) {
		setAttrVal("Ex_seqno", Ex_seqno);
	}
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	public String getCode_emp_phy() {
		return ((String) getAttrVal("Code_emp_phy"));
	}	
	public void setCode_emp_phy(String Code_emp_phy) {
		setAttrVal("Code_emp_phy", Code_emp_phy);
	}
	public FDate getD_sc() {
		return ((FDate) getAttrVal("D_sc"));
	}	
	public void setD_sc(FDate D_sc) {
		setAttrVal("D_sc", D_sc);
	}
	public String getAmpm() {
		return ((String) getAttrVal("Ampm"));
	}	
	public void setAmpm(String Ampm) {
		setAttrVal("Ampm", Ampm);
	}
	public String getName_org_apply() {
		return ((String) getAttrVal("Name_org_apply"));
	}	
	public void setName_org_apply(String Name_org_apply) {
		setAttrVal("Name_org_apply", Name_org_apply);
	}
	public FBoolean getFg_tranf() {
		return ((FBoolean) getAttrVal("Fg_tranf"));
	}	
	public void setFg_tranf(FBoolean Fg_tranf) {
		setAttrVal("Fg_tranf", Fg_tranf);
	}
	public String getCtrl1() {
		return ((String) getAttrVal("Ctrl1"));
	}	
	public void setCtrl1(String Ctrl1) {
		setAttrVal("Ctrl1", Ctrl1);
	}
	public String getCtrl2() {
		return ((String) getAttrVal("Ctrl2"));
	}	
	public void setCtrl2(String Ctrl2) {
		setAttrVal("Ctrl2", Ctrl2);
	}
	public String getCtrl3() {
		return ((String) getAttrVal("Ctrl3"));
	}	
	public void setCtrl3(String Ctrl3) {
		setAttrVal("Ctrl3", Ctrl3);
	}
	public String getCtrl4() {
		return ((String) getAttrVal("Ctrl4"));
	}	
	public void setCtrl4(String Ctrl4) {
		setAttrVal("Ctrl4", Ctrl4);
	}
	public String getCtrl5() {
		return ((String) getAttrVal("Ctrl5"));
	}	
	public void setCtrl5(String Ctrl5) {
		setAttrVal("Ctrl5", Ctrl5);
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
		return "Id_aptexchl";
	}
	
	@Override
	public String getTableName() {	  
		return "SC_APT_EXCHL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AptExChlDODesc.class);
	}
	
}