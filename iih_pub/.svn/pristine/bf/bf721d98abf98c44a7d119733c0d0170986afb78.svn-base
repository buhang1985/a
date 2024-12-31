package iih.nmr.pkuf.heduplan.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.pkuf.heduplan.d.desc.HeduPlanItemDODesc;
import java.math.BigDecimal;

/**
 * 健康教育计划明细 DO数据 
 * 
 */
public class HeduPlanItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//健康教育明细
	public static final String ID_PKUF_HEDUPLANITM= "Id_pkuf_heduplanitm";
	//健康教育计划单
	public static final String ID_PKUF_HEDUPLAN= "Id_pkuf_heduplan";
	//序号
	public static final String SORTNO= "Sortno";
	//教育内容
	public static final String EDU_CON= "Edu_con";
	//患者
	public static final String PAT= "Pat";
	//家属
	public static final String FA_ME= "Fa_me";
	//教育日期
	public static final String DT_EDU= "Dt_edu";
	//评价效果内容
	public static final String ID_EVA_CON= "Id_eva_con";
	//评价效果内容编码
	public static final String SD_EVA_CON= "Sd_eva_con";
	//护士签名
	public static final String ID_SIGN_NU= "Id_sign_nu";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//评价效果内容名称
	public static final String NAME_EVA_CON= "Name_eva_con";
	//护士签名姓名
	public static final String NAME_SIGN_NU= "Name_sign_nu";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 健康教育明细
	 * @return String
	 */
	public String getId_pkuf_heduplanitm() {
		return ((String) getAttrVal("Id_pkuf_heduplanitm"));
	}	
	/**
	 * 健康教育明细
	 * @param Id_pkuf_heduplanitm
	 */
	public void setId_pkuf_heduplanitm(String Id_pkuf_heduplanitm) {
		setAttrVal("Id_pkuf_heduplanitm", Id_pkuf_heduplanitm);
	}
	/**
	 * 健康教育计划单
	 * @return String
	 */
	public String getId_pkuf_heduplan() {
		return ((String) getAttrVal("Id_pkuf_heduplan"));
	}	
	/**
	 * 健康教育计划单
	 * @param Id_pkuf_heduplan
	 */
	public void setId_pkuf_heduplan(String Id_pkuf_heduplan) {
		setAttrVal("Id_pkuf_heduplan", Id_pkuf_heduplan);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 教育内容
	 * @return String
	 */
	public String getEdu_con() {
		return ((String) getAttrVal("Edu_con"));
	}	
	/**
	 * 教育内容
	 * @param Edu_con
	 */
	public void setEdu_con(String Edu_con) {
		setAttrVal("Edu_con", Edu_con);
	}
	/**
	 * 患者
	 * @return FBoolean
	 */
	public FBoolean getPat() {
		return ((FBoolean) getAttrVal("Pat"));
	}	
	/**
	 * 患者
	 * @param Pat
	 */
	public void setPat(FBoolean Pat) {
		setAttrVal("Pat", Pat);
	}
	/**
	 * 家属
	 * @return FBoolean
	 */
	public FBoolean getFa_me() {
		return ((FBoolean) getAttrVal("Fa_me"));
	}	
	/**
	 * 家属
	 * @param Fa_me
	 */
	public void setFa_me(FBoolean Fa_me) {
		setAttrVal("Fa_me", Fa_me);
	}
	/**
	 * 教育日期
	 * @return FDate
	 */
	public FDate getDt_edu() {
		return ((FDate) getAttrVal("Dt_edu"));
	}	
	/**
	 * 教育日期
	 * @param Dt_edu
	 */
	public void setDt_edu(FDate Dt_edu) {
		setAttrVal("Dt_edu", Dt_edu);
	}
	/**
	 * 评价效果内容
	 * @return String
	 */
	public String getId_eva_con() {
		return ((String) getAttrVal("Id_eva_con"));
	}	
	/**
	 * 评价效果内容
	 * @param Id_eva_con
	 */
	public void setId_eva_con(String Id_eva_con) {
		setAttrVal("Id_eva_con", Id_eva_con);
	}
	/**
	 * 评价效果内容编码
	 * @return String
	 */
	public String getSd_eva_con() {
		return ((String) getAttrVal("Sd_eva_con"));
	}	
	/**
	 * 评价效果内容编码
	 * @param Sd_eva_con
	 */
	public void setSd_eva_con(String Sd_eva_con) {
		setAttrVal("Sd_eva_con", Sd_eva_con);
	}
	/**
	 * 护士签名
	 * @return String
	 */
	public String getId_sign_nu() {
		return ((String) getAttrVal("Id_sign_nu"));
	}	
	/**
	 * 护士签名
	 * @param Id_sign_nu
	 */
	public void setId_sign_nu(String Id_sign_nu) {
		setAttrVal("Id_sign_nu", Id_sign_nu);
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
	 * 评价效果内容名称
	 * @return String
	 */
	public String getName_eva_con() {
		return ((String) getAttrVal("Name_eva_con"));
	}	
	/**
	 * 评价效果内容名称
	 * @param Name_eva_con
	 */
	public void setName_eva_con(String Name_eva_con) {
		setAttrVal("Name_eva_con", Name_eva_con);
	}
	/**
	 * 护士签名姓名
	 * @return String
	 */
	public String getName_sign_nu() {
		return ((String) getAttrVal("Name_sign_nu"));
	}	
	/**
	 * 护士签名姓名
	 * @param Name_sign_nu
	 */
	public void setName_sign_nu(String Name_sign_nu) {
		setAttrVal("Name_sign_nu", Name_sign_nu);
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
		return "Id_pkuf_heduplanitm";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_PKUF_HEDUPLAN_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HeduPlanItemDODesc.class);
	}
	
}