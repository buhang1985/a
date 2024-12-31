package iih.sc.apt.scaptappl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.apt.scaptappl.d.desc.ScAptApplItmDODesc;
import java.math.BigDecimal;

/**
 * 计划排班_预约_申请单明细 DO数据 
 * 
 */
public class ScAptApplItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//申请单明细id
	public static final String ID_APTAPPLITM= "Id_aptapplitm";
	//预约申请id
	public static final String ID_APTAPPL= "Id_aptappl";
	//合单号
	public static final String APPLYNO_OR= "Applyno_or";
	//医嘱申请号
	public static final String APPLYNO= "Applyno";
	//预约申请描述
	public static final String DES= "Des";
	//医嘱
	public static final String ID_OR= "Id_or";
	//医嘱编号
	public static final String CODE_OR= "Code_or";
	//医嘱内容
	public static final String CONTENT_OR= "Content_or";
	//医疗服务id
	public static final String ID_SRV= "Id_srv";
	//紧急标志
	public static final String FG_URGENT= "Fg_urgent";
	//是否已付费
	public static final String FG_BL= "Fg_bl";
	//医嘱开始时间
	public static final String DT_EFFE_OR= "Dt_effe_or";
	//医保标志
	public static final String FG_HP= "Fg_hp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 申请单明细id
	 * @return String
	 */
	public String getId_aptapplitm() {
		return ((String) getAttrVal("Id_aptapplitm"));
	}	
	/**
	 * 申请单明细id
	 * @param Id_aptapplitm
	 */
	public void setId_aptapplitm(String Id_aptapplitm) {
		setAttrVal("Id_aptapplitm", Id_aptapplitm);
	}
	/**
	 * 预约申请id
	 * @return String
	 */
	public String getId_aptappl() {
		return ((String) getAttrVal("Id_aptappl"));
	}	
	/**
	 * 预约申请id
	 * @param Id_aptappl
	 */
	public void setId_aptappl(String Id_aptappl) {
		setAttrVal("Id_aptappl", Id_aptappl);
	}
	/**
	 * 合单号
	 * @return String
	 */
	public String getApplyno_or() {
		return ((String) getAttrVal("Applyno_or"));
	}	
	/**
	 * 合单号
	 * @param Applyno_or
	 */
	public void setApplyno_or(String Applyno_or) {
		setAttrVal("Applyno_or", Applyno_or);
	}
	/**
	 * 医嘱申请号
	 * @return String
	 */
	public String getApplyno() {
		return ((String) getAttrVal("Applyno"));
	}	
	/**
	 * 医嘱申请号
	 * @param Applyno
	 */
	public void setApplyno(String Applyno) {
		setAttrVal("Applyno", Applyno);
	}
	/**
	 * 预约申请描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 预约申请描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	 * 医嘱编号
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}	
	/**
	 * 医嘱编号
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getContent_or() {
		return ((String) getAttrVal("Content_or"));
	}	
	/**
	 * 医嘱内容
	 * @param Content_or
	 */
	public void setContent_or(String Content_or) {
		setAttrVal("Content_or", Content_or);
	}
	/**
	 * 医疗服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 医疗服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 紧急标志
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}	
	/**
	 * 紧急标志
	 * @param Fg_urgent
	 */
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	/**
	 * 是否已付费
	 * @return FBoolean
	 */
	public FBoolean getFg_bl() {
		return ((FBoolean) getAttrVal("Fg_bl"));
	}	
	/**
	 * 是否已付费
	 * @param Fg_bl
	 */
	public void setFg_bl(FBoolean Fg_bl) {
		setAttrVal("Fg_bl", Fg_bl);
	}
	/**
	 * 医嘱开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_effe_or() {
		return ((FDateTime) getAttrVal("Dt_effe_or"));
	}	
	/**
	 * 医嘱开始时间
	 * @param Dt_effe_or
	 */
	public void setDt_effe_or(FDateTime Dt_effe_or) {
		setAttrVal("Dt_effe_or", Dt_effe_or);
	}
	/**
	 * 医保标志
	 * @return FBoolean
	 */
	public FBoolean getFg_hp() {
		return ((FBoolean) getAttrVal("Fg_hp"));
	}	
	/**
	 * 医保标志
	 * @param Fg_hp
	 */
	public void setFg_hp(FBoolean Fg_hp) {
		setAttrVal("Fg_hp", Fg_hp);
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
		return "Id_aptapplitm";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_apt_appl_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScAptApplItmDODesc.class);
	}
	
}