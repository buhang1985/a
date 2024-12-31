package iih.bl.inc.blincoep.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.inc.blincoep.d.desc.BlIncCgItmOepDesc;
import java.math.BigDecimal;

/**
 * 门急诊发票费用明细 DO数据 
 * 
 */
public class BlIncCgItmOep extends BaseDO {
	private static final long serialVersionUID = 1L;

	//发票费用明细主键
	public static final String ID_INCCGITMOEP= "Id_inccgitmoep";
	//发票
	public static final String ID_INCOEP= "Id_incoep";
	//记账明细
	public static final String ID_CGITMOEP= "Id_cgitmoep";
	//医嘱项目
	public static final String ID_ORSRV= "Id_orsrv";
	//医嘱
	public static final String ID_OR= "Id_or";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//患者ID
	public static final String ID_PAT= "Id_pat";
	//发票号码
	public static final String INCOEP_INCNO= "Incoep_incno";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 发票费用明细主键
	 * @return String
	 */
	public String getId_inccgitmoep() {
		return ((String) getAttrVal("Id_inccgitmoep"));
	}	
	/**
	 * 发票费用明细主键
	 * @param Id_inccgitmoep
	 */
	public void setId_inccgitmoep(String Id_inccgitmoep) {
		setAttrVal("Id_inccgitmoep", Id_inccgitmoep);
	}
	/**
	 * 发票
	 * @return String
	 */
	public String getId_incoep() {
		return ((String) getAttrVal("Id_incoep"));
	}	
	/**
	 * 发票
	 * @param Id_incoep
	 */
	public void setId_incoep(String Id_incoep) {
		setAttrVal("Id_incoep", Id_incoep);
	}
	/**
	 * 记账明细
	 * @return String
	 */
	public String getId_cgitmoep() {
		return ((String) getAttrVal("Id_cgitmoep"));
	}	
	/**
	 * 记账明细
	 * @param Id_cgitmoep
	 */
	public void setId_cgitmoep(String Id_cgitmoep) {
		setAttrVal("Id_cgitmoep", Id_cgitmoep);
	}
	/**
	 * 医嘱项目
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}	
	/**
	 * 医嘱项目
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 医嘱
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 医嘱
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 发票号码
	 * @return String
	 */
	public String getIncoep_incno() {
		return ((String) getAttrVal("Incoep_incno"));
	}	
	/**
	 * 发票号码
	 * @param Incoep_incno
	 */
	public void setIncoep_incno(String Incoep_incno) {
		setAttrVal("Incoep_incno", Incoep_incno);
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
		return "Id_inccgitmoep";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_inc_cg_itm_oep";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlIncCgItmOepDesc.class);
	}
	
}