package iih.mp.dg.opdrugdisp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.dg.opdrugdisp.d.desc.OpPresStatusDODesc;
import java.math.BigDecimal;

/**
 * 处方执行状态 DO数据 
 * 
 */
public class OpPresStatusDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//处方执行状态主键
	public static final String ID_DGPRESST= "Id_dgpresst";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//药品处方ID
	public static final String ID_PRES= "Id_pres";
	//处方号
	public static final String CODE_PRES= "Code_pres";
	//摆药状态
	public static final String EN_DISP= "En_disp";
	//发药状态
	public static final String EU_SU_MPDGOP= "Eu_su_mpdgop";
	//上屏标志
	public static final String FG_SCREEN= "Fg_screen";
	//患者
	public static final String ID_PAT= "Id_pat";
	//就诊id
	public static final String ID_ENT= "Id_ent";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//签到标识
	public static final String FG_PUNCH= "Fg_punch";
	//签到时间
	public static final String DT_PUNCH= "Dt_punch";
	//刷卡标识
	public static final String FG_SWIPE= "Fg_swipe";
	//刷卡人
	public static final String ID_SWIPE= "Id_swipe";
	//刷卡时间
	public static final String DT_SWIPE= "Dt_swipe";
	//配送信息
	public static final String ID_HERBDELVR= "Id_herbdelvr";
	//是否需要审核
	public static final String FG_NEED_CHK= "Fg_need_chk";
	//审核状态
	public static final String SD_CHK= "Sd_chk";
	//审核员
	public static final String ID_EMP_CHK= "Id_emp_chk";
	//审核日期
	public static final String DT_CHK= "Dt_chk";
	//拒绝原因
	public static final String CHK_NOTE= "Chk_note";
	//打印标识
	public static final String FG_PRINT= "Fg_print";
	//审核人员
	public static final String EMP_CHK_NAME= "Emp_chk_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 处方执行状态主键
	 * @return String
	 */
	public String getId_dgpresst() {
		return ((String) getAttrVal("Id_dgpresst"));
	}	
	/**
	 * 处方执行状态主键
	 * @param Id_dgpresst
	 */
	public void setId_dgpresst(String Id_dgpresst) {
		setAttrVal("Id_dgpresst", Id_dgpresst);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 机构
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 机构
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 药品处方ID
	 * @return String
	 */
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}	
	/**
	 * 药品处方ID
	 * @param Id_pres
	 */
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
	}
	/**
	 * 处方号
	 * @return String
	 */
	public String getCode_pres() {
		return ((String) getAttrVal("Code_pres"));
	}	
	/**
	 * 处方号
	 * @param Code_pres
	 */
	public void setCode_pres(String Code_pres) {
		setAttrVal("Code_pres", Code_pres);
	}
	/**
	 * 摆药状态
	 * @return Integer
	 */
	public Integer getEn_disp() {
		return ((Integer) getAttrVal("En_disp"));
	}	
	/**
	 * 摆药状态
	 * @param En_disp
	 */
	public void setEn_disp(Integer En_disp) {
		setAttrVal("En_disp", En_disp);
	}
	/**
	 * 发药状态
	 * @return Integer
	 */
	public Integer getEu_su_mpdgop() {
		return ((Integer) getAttrVal("Eu_su_mpdgop"));
	}	
	/**
	 * 发药状态
	 * @param Eu_su_mpdgop
	 */
	public void setEu_su_mpdgop(Integer Eu_su_mpdgop) {
		setAttrVal("Eu_su_mpdgop", Eu_su_mpdgop);
	}
	/**
	 * 上屏标志
	 * @return FBoolean
	 */
	public FBoolean getFg_screen() {
		return ((FBoolean) getAttrVal("Fg_screen"));
	}	
	/**
	 * 上屏标志
	 * @param Fg_screen
	 */
	public void setFg_screen(FBoolean Fg_screen) {
		setAttrVal("Fg_screen", Fg_screen);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 签到标识
	 * @return FBoolean
	 */
	public FBoolean getFg_punch() {
		return ((FBoolean) getAttrVal("Fg_punch"));
	}	
	/**
	 * 签到标识
	 * @param Fg_punch
	 */
	public void setFg_punch(FBoolean Fg_punch) {
		setAttrVal("Fg_punch", Fg_punch);
	}
	/**
	 * 签到时间
	 * @return FDateTime
	 */
	public FDateTime getDt_punch() {
		return ((FDateTime) getAttrVal("Dt_punch"));
	}	
	/**
	 * 签到时间
	 * @param Dt_punch
	 */
	public void setDt_punch(FDateTime Dt_punch) {
		setAttrVal("Dt_punch", Dt_punch);
	}
	/**
	 * 刷卡标识
	 * @return FBoolean
	 */
	public FBoolean getFg_swipe() {
		return ((FBoolean) getAttrVal("Fg_swipe"));
	}	
	/**
	 * 刷卡标识
	 * @param Fg_swipe
	 */
	public void setFg_swipe(FBoolean Fg_swipe) {
		setAttrVal("Fg_swipe", Fg_swipe);
	}
	/**
	 * 刷卡人
	 * @return String
	 */
	public String getId_swipe() {
		return ((String) getAttrVal("Id_swipe"));
	}	
	/**
	 * 刷卡人
	 * @param Id_swipe
	 */
	public void setId_swipe(String Id_swipe) {
		setAttrVal("Id_swipe", Id_swipe);
	}
	/**
	 * 刷卡时间
	 * @return FDateTime
	 */
	public FDateTime getDt_swipe() {
		return ((FDateTime) getAttrVal("Dt_swipe"));
	}	
	/**
	 * 刷卡时间
	 * @param Dt_swipe
	 */
	public void setDt_swipe(FDateTime Dt_swipe) {
		setAttrVal("Dt_swipe", Dt_swipe);
	}
	/**
	 * 配送信息
	 * @return String
	 */
	public String getId_herbdelvr() {
		return ((String) getAttrVal("Id_herbdelvr"));
	}	
	/**
	 * 配送信息
	 * @param Id_herbdelvr
	 */
	public void setId_herbdelvr(String Id_herbdelvr) {
		setAttrVal("Id_herbdelvr", Id_herbdelvr);
	}
	/**
	 * 是否需要审核
	 * @return FBoolean
	 */
	public FBoolean getFg_need_chk() {
		return ((FBoolean) getAttrVal("Fg_need_chk"));
	}	
	/**
	 * 是否需要审核
	 * @param Fg_need_chk
	 */
	public void setFg_need_chk(FBoolean Fg_need_chk) {
		setAttrVal("Fg_need_chk", Fg_need_chk);
	}
	/**
	 * 审核状态
	 * @return Integer
	 */
	public Integer getSd_chk() {
		return ((Integer) getAttrVal("Sd_chk"));
	}	
	/**
	 * 审核状态
	 * @param Sd_chk
	 */
	public void setSd_chk(Integer Sd_chk) {
		setAttrVal("Sd_chk", Sd_chk);
	}
	/**
	 * 审核员
	 * @return String
	 */
	public String getId_emp_chk() {
		return ((String) getAttrVal("Id_emp_chk"));
	}	
	/**
	 * 审核员
	 * @param Id_emp_chk
	 */
	public void setId_emp_chk(String Id_emp_chk) {
		setAttrVal("Id_emp_chk", Id_emp_chk);
	}
	/**
	 * 审核日期
	 * @return FDateTime
	 */
	public FDateTime getDt_chk() {
		return ((FDateTime) getAttrVal("Dt_chk"));
	}	
	/**
	 * 审核日期
	 * @param Dt_chk
	 */
	public void setDt_chk(FDateTime Dt_chk) {
		setAttrVal("Dt_chk", Dt_chk);
	}
	/**
	 * 拒绝原因
	 * @return String
	 */
	public String getChk_note() {
		return ((String) getAttrVal("Chk_note"));
	}	
	/**
	 * 拒绝原因
	 * @param Chk_note
	 */
	public void setChk_note(String Chk_note) {
		setAttrVal("Chk_note", Chk_note);
	}
	/**
	 * 打印标识
	 * @return FBoolean
	 */
	public FBoolean getFg_print() {
		return ((FBoolean) getAttrVal("Fg_print"));
	}	
	/**
	 * 打印标识
	 * @param Fg_print
	 */
	public void setFg_print(FBoolean Fg_print) {
		setAttrVal("Fg_print", Fg_print);
	}
	/**
	 * 审核人员
	 * @return String
	 */
	public String getEmp_chk_name() {
		return ((String) getAttrVal("Emp_chk_name"));
	}	
	/**
	 * 审核人员
	 * @param Emp_chk_name
	 */
	public void setEmp_chk_name(String Emp_chk_name) {
		setAttrVal("Emp_chk_name", Emp_chk_name);
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
		return "Id_dgpresst";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_DG_PRESST";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OpPresStatusDODesc.class);
	}
	
}