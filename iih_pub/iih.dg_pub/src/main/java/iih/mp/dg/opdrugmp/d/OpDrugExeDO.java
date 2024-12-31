package iih.mp.dg.opdrugmp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.dg.opdrugmp.d.desc.OpDrugExeDODesc;
import java.math.BigDecimal;

/**
 * 门诊药品执行 DO数据 
 * 
 */
public class OpDrugExeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//门诊药品执行主键标识
	public static final String ID_DGOP= "Id_dgop";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//患者
	public static final String ID_PAT= "Id_pat";
	//就诊
	public static final String ID_ENT= "Id_ent";
	//就诊类型
	public static final String ID_ENTP= "Id_entp";
	//就诊类型编码
	public static final String CODE_ENTP= "Code_entp";
	//执行类型
	public static final String ID_MPDGTP= "Id_mpdgtp";
	//执行类型编码
	public static final String SD_MPDGTP= "Sd_mpdgtp";
	//发药状态
	public static final String EU_SU_MP= "Eu_su_mp";
	//出库单号
	public static final String ID_OUT= "Id_out";
	//处方
	public static final String ID_PRES= "Id_pres";
	//执行人
	public static final String ID_EMP_DP= "Id_emp_dp";
	//执行时间
	public static final String DT_DP= "Dt_dp";
	//医嘱付数
	public static final String ORDERS= "Orders";
	//代煎标志
	public static final String FG_BOIL= "Fg_boil";
	//代煎付数
	public static final String ORDERS_BOIL= "Orders_boil";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//退药原因其他
	public static final String DES_RETREAT= "Des_retreat";
	//执行科室
	public static final String ID_DEP_MP= "Id_dep_mp";
	//退药原因
	public static final String ID_RTNREA= "Id_rtnrea";
	//退药原因编码
	public static final String SD_RTNREA= "Sd_rtnrea";
	//取消退药标志
	public static final String FG_CANCBK= "Fg_cancbk";
	//退药原因名称
	public static final String NAME_RTNREA= "Name_rtnrea";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 门诊药品执行主键标识
	 * @return String
	 */
	public String getId_dgop() {
		return ((String) getAttrVal("Id_dgop"));
	}	
	/**
	 * 门诊药品执行主键标识
	 * @param Id_dgop
	 */
	public void setId_dgop(String Id_dgop) {
		setAttrVal("Id_dgop", Id_dgop);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
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
	 * 就诊
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	/**
	 * 就诊类型
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	/**
	 * 就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 执行类型
	 * @return String
	 */
	public String getId_mpdgtp() {
		return ((String) getAttrVal("Id_mpdgtp"));
	}	
	/**
	 * 执行类型
	 * @param Id_mpdgtp
	 */
	public void setId_mpdgtp(String Id_mpdgtp) {
		setAttrVal("Id_mpdgtp", Id_mpdgtp);
	}
	/**
	 * 执行类型编码
	 * @return String
	 */
	public String getSd_mpdgtp() {
		return ((String) getAttrVal("Sd_mpdgtp"));
	}	
	/**
	 * 执行类型编码
	 * @param Sd_mpdgtp
	 */
	public void setSd_mpdgtp(String Sd_mpdgtp) {
		setAttrVal("Sd_mpdgtp", Sd_mpdgtp);
	}
	/**
	 * 发药状态
	 * @return Integer
	 */
	public Integer getEu_su_mp() {
		return ((Integer) getAttrVal("Eu_su_mp"));
	}	
	/**
	 * 发药状态
	 * @param Eu_su_mp
	 */
	public void setEu_su_mp(Integer Eu_su_mp) {
		setAttrVal("Eu_su_mp", Eu_su_mp);
	}
	/**
	 * 出库单号
	 * @return String
	 */
	public String getId_out() {
		return ((String) getAttrVal("Id_out"));
	}	
	/**
	 * 出库单号
	 * @param Id_out
	 */
	public void setId_out(String Id_out) {
		setAttrVal("Id_out", Id_out);
	}
	/**
	 * 处方
	 * @return String
	 */
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}	
	/**
	 * 处方
	 * @param Id_pres
	 */
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
	}
	/**
	 * 执行人
	 * @return String
	 */
	public String getId_emp_dp() {
		return ((String) getAttrVal("Id_emp_dp"));
	}	
	/**
	 * 执行人
	 * @param Id_emp_dp
	 */
	public void setId_emp_dp(String Id_emp_dp) {
		setAttrVal("Id_emp_dp", Id_emp_dp);
	}
	/**
	 * 执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_dp() {
		return ((FDateTime) getAttrVal("Dt_dp"));
	}	
	/**
	 * 执行时间
	 * @param Dt_dp
	 */
	public void setDt_dp(FDateTime Dt_dp) {
		setAttrVal("Dt_dp", Dt_dp);
	}
	/**
	 * 医嘱付数
	 * @return Integer
	 */
	public Integer getOrders() {
		return ((Integer) getAttrVal("Orders"));
	}	
	/**
	 * 医嘱付数
	 * @param Orders
	 */
	public void setOrders(Integer Orders) {
		setAttrVal("Orders", Orders);
	}
	/**
	 * 代煎标志
	 * @return FBoolean
	 */
	public FBoolean getFg_boil() {
		return ((FBoolean) getAttrVal("Fg_boil"));
	}	
	/**
	 * 代煎标志
	 * @param Fg_boil
	 */
	public void setFg_boil(FBoolean Fg_boil) {
		setAttrVal("Fg_boil", Fg_boil);
	}
	/**
	 * 代煎付数
	 * @return Integer
	 */
	public Integer getOrders_boil() {
		return ((Integer) getAttrVal("Orders_boil"));
	}	
	/**
	 * 代煎付数
	 * @param Orders_boil
	 */
	public void setOrders_boil(Integer Orders_boil) {
		setAttrVal("Orders_boil", Orders_boil);
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
	 * 退药原因其他
	 * @return String
	 */
	public String getDes_retreat() {
		return ((String) getAttrVal("Des_retreat"));
	}	
	/**
	 * 退药原因其他
	 * @param Des_retreat
	 */
	public void setDes_retreat(String Des_retreat) {
		setAttrVal("Des_retreat", Des_retreat);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}	
	/**
	 * 执行科室
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 退药原因
	 * @return String
	 */
	public String getId_rtnrea() {
		return ((String) getAttrVal("Id_rtnrea"));
	}	
	/**
	 * 退药原因
	 * @param Id_rtnrea
	 */
	public void setId_rtnrea(String Id_rtnrea) {
		setAttrVal("Id_rtnrea", Id_rtnrea);
	}
	/**
	 * 退药原因编码
	 * @return String
	 */
	public String getSd_rtnrea() {
		return ((String) getAttrVal("Sd_rtnrea"));
	}	
	/**
	 * 退药原因编码
	 * @param Sd_rtnrea
	 */
	public void setSd_rtnrea(String Sd_rtnrea) {
		setAttrVal("Sd_rtnrea", Sd_rtnrea);
	}
	/**
	 * 取消退药标志
	 * @return FBoolean
	 */
	public FBoolean getFg_cancbk() {
		return ((FBoolean) getAttrVal("Fg_cancbk"));
	}	
	/**
	 * 取消退药标志
	 * @param Fg_cancbk
	 */
	public void setFg_cancbk(FBoolean Fg_cancbk) {
		setAttrVal("Fg_cancbk", Fg_cancbk);
	}
	/**
	 * 退药原因名称
	 * @return String
	 */
	public String getName_rtnrea() {
		return ((String) getAttrVal("Name_rtnrea"));
	}	
	/**
	 * 退药原因名称
	 * @param Name_rtnrea
	 */
	public void setName_rtnrea(String Name_rtnrea) {
		setAttrVal("Name_rtnrea", Name_rtnrea);
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
		return "Id_dgop";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_dg_op";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OpDrugExeDODesc.class);
	}
	
}