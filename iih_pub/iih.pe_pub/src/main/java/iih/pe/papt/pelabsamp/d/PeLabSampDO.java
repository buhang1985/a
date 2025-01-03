package iih.pe.papt.pelabsamp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.papt.pelabsamp.d.desc.PeLabSampDODesc;
import java.math.BigDecimal;

/**
 * 体检检验标本 DO数据 
 * 
 */
public class PeLabSampDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//检验标本主键
	public static final String ID_LABSAMP= "Id_labsamp";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//标本名称
	public static final String NAME_LAB= "Name_lab";
	//标本条码
	public static final String NO_BAR= "No_bar";
	//患者ID
	public static final String ID_PAT= "Id_pat";
	//就诊ID
	public static final String ID_ENT= "Id_ent";
	//就诊类型
	public static final String CODE_ENTP= "Code_entp";
	//服务类型
	public static final String SD_SRVTP= "Sd_srvtp";
	//标本类型ID
	public static final String ID_LABSAMPTP= "Id_labsamptp";
	//标本类型编码
	public static final String SD_LABSAMPTP= "Sd_labsamptp";
	//采集方法ID
	public static final String ID_COLLTP= "Id_colltp";
	//采集方法编码
	public static final String SD_COLLTP= "Sd_colltp";
	//容器类型ID
	public static final String ID_TUBETP= "Id_tubetp";
	//容器类型编码
	public static final String SD_TUBETP= "Sd_tubetp";
	//标本说明
	public static final String DES_LABSAMP= "Des_labsamp";
	//作废标识
	public static final String FG_INVALID= "Fg_invalid";
	//标本状态
	public static final String ID_LABSTA= "Id_labsta";
	//标本状态编码
	public static final String SD_LABSTA= "Sd_labsta";
	//需求量
	public static final String QUAN= "Quan";
	//需求量单位
	public static final String ID_UNIT_QUAN= "Id_unit_quan";
	//打印次数
	public static final String CT_PRN= "Ct_prn";
	//加急标识
	public static final String FG_URGENT= "Fg_urgent";
	//申请单号
	public static final String NO_APPLYFORM= "No_applyform";
	//计划执行时间
	public static final String DT_PLAN= "Dt_plan";
	//标本采集状态
	public static final String EU_STA= "Eu_sta";
	//执行科室
	public static final String ID_DEP_MP= "Id_dep_mp";
	//试管颜色
	public static final String COLOR= "Color";
	//扩展字段1
	public static final String DEF1= "Def1";
	//扩展字段2
	public static final String DEF2= "Def2";
	//扩展字段3
	public static final String DEF3= "Def3";
	//扩展字段4
	public static final String DEF4= "Def4";
	//扩展字段5
	public static final String DEF5= "Def5";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//标本体检名称
	public static final String NAME_LAB_PE= "Name_lab_pe";
	//客户姓名
	public static final String NAME_PSN= "Name_psn";
	//执行状态名称
	public static final String NAME_STA= "Name_sta";
	//执行科室名称
	public static final String NAME_DEP_MP= "Name_dep_mp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 检验标本主键
	 * @return String
	 */
	public String getId_labsamp() {
		return ((String) getAttrVal("Id_labsamp"));
	}	
	/**
	 * 检验标本主键
	 * @param Id_labsamp
	 */
	public void setId_labsamp(String Id_labsamp) {
		setAttrVal("Id_labsamp", Id_labsamp);
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
	 * 标本名称
	 * @return String
	 */
	public String getName_lab() {
		return ((String) getAttrVal("Name_lab"));
	}	
	/**
	 * 标本名称
	 * @param Name_lab
	 */
	public void setName_lab(String Name_lab) {
		setAttrVal("Name_lab", Name_lab);
	}
	/**
	 * 标本条码
	 * @return String
	 */
	public String getNo_bar() {
		return ((String) getAttrVal("No_bar"));
	}	
	/**
	 * 标本条码
	 * @param No_bar
	 */
	public void setNo_bar(String No_bar) {
		setAttrVal("No_bar", No_bar);
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
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	/**
	 * 就诊类型
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	/**
	 * 服务类型
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 标本类型ID
	 * @return String
	 */
	public String getId_labsamptp() {
		return ((String) getAttrVal("Id_labsamptp"));
	}	
	/**
	 * 标本类型ID
	 * @param Id_labsamptp
	 */
	public void setId_labsamptp(String Id_labsamptp) {
		setAttrVal("Id_labsamptp", Id_labsamptp);
	}
	/**
	 * 标本类型编码
	 * @return String
	 */
	public String getSd_labsamptp() {
		return ((String) getAttrVal("Sd_labsamptp"));
	}	
	/**
	 * 标本类型编码
	 * @param Sd_labsamptp
	 */
	public void setSd_labsamptp(String Sd_labsamptp) {
		setAttrVal("Sd_labsamptp", Sd_labsamptp);
	}
	/**
	 * 采集方法ID
	 * @return String
	 */
	public String getId_colltp() {
		return ((String) getAttrVal("Id_colltp"));
	}	
	/**
	 * 采集方法ID
	 * @param Id_colltp
	 */
	public void setId_colltp(String Id_colltp) {
		setAttrVal("Id_colltp", Id_colltp);
	}
	/**
	 * 采集方法编码
	 * @return String
	 */
	public String getSd_colltp() {
		return ((String) getAttrVal("Sd_colltp"));
	}	
	/**
	 * 采集方法编码
	 * @param Sd_colltp
	 */
	public void setSd_colltp(String Sd_colltp) {
		setAttrVal("Sd_colltp", Sd_colltp);
	}
	/**
	 * 容器类型ID
	 * @return String
	 */
	public String getId_tubetp() {
		return ((String) getAttrVal("Id_tubetp"));
	}	
	/**
	 * 容器类型ID
	 * @param Id_tubetp
	 */
	public void setId_tubetp(String Id_tubetp) {
		setAttrVal("Id_tubetp", Id_tubetp);
	}
	/**
	 * 容器类型编码
	 * @return String
	 */
	public String getSd_tubetp() {
		return ((String) getAttrVal("Sd_tubetp"));
	}	
	/**
	 * 容器类型编码
	 * @param Sd_tubetp
	 */
	public void setSd_tubetp(String Sd_tubetp) {
		setAttrVal("Sd_tubetp", Sd_tubetp);
	}
	/**
	 * 标本说明
	 * @return String
	 */
	public String getDes_labsamp() {
		return ((String) getAttrVal("Des_labsamp"));
	}	
	/**
	 * 标本说明
	 * @param Des_labsamp
	 */
	public void setDes_labsamp(String Des_labsamp) {
		setAttrVal("Des_labsamp", Des_labsamp);
	}
	/**
	 * 作废标识
	 * @return FBoolean
	 */
	public FBoolean getFg_invalid() {
		return ((FBoolean) getAttrVal("Fg_invalid"));
	}	
	/**
	 * 作废标识
	 * @param Fg_invalid
	 */
	public void setFg_invalid(FBoolean Fg_invalid) {
		setAttrVal("Fg_invalid", Fg_invalid);
	}
	/**
	 * 标本状态
	 * @return String
	 */
	public String getId_labsta() {
		return ((String) getAttrVal("Id_labsta"));
	}	
	/**
	 * 标本状态
	 * @param Id_labsta
	 */
	public void setId_labsta(String Id_labsta) {
		setAttrVal("Id_labsta", Id_labsta);
	}
	/**
	 * 标本状态编码
	 * @return String
	 */
	public String getSd_labsta() {
		return ((String) getAttrVal("Sd_labsta"));
	}	
	/**
	 * 标本状态编码
	 * @param Sd_labsta
	 */
	public void setSd_labsta(String Sd_labsta) {
		setAttrVal("Sd_labsta", Sd_labsta);
	}
	/**
	 * 需求量
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}	
	/**
	 * 需求量
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 需求量单位
	 * @return String
	 */
	public String getId_unit_quan() {
		return ((String) getAttrVal("Id_unit_quan"));
	}	
	/**
	 * 需求量单位
	 * @param Id_unit_quan
	 */
	public void setId_unit_quan(String Id_unit_quan) {
		setAttrVal("Id_unit_quan", Id_unit_quan);
	}
	/**
	 * 打印次数
	 * @return Integer
	 */
	public Integer getCt_prn() {
		return ((Integer) getAttrVal("Ct_prn"));
	}	
	/**
	 * 打印次数
	 * @param Ct_prn
	 */
	public void setCt_prn(Integer Ct_prn) {
		setAttrVal("Ct_prn", Ct_prn);
	}
	/**
	 * 加急标识
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}	
	/**
	 * 加急标识
	 * @param Fg_urgent
	 */
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}	
	/**
	 * 申请单号
	 * @param No_applyform
	 */
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	/**
	 * 计划执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_plan() {
		return ((FDateTime) getAttrVal("Dt_plan"));
	}	
	/**
	 * 计划执行时间
	 * @param Dt_plan
	 */
	public void setDt_plan(FDateTime Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}
	/**
	 * 标本采集状态
	 * @return Integer
	 */
	public Integer getEu_sta() {
		return ((Integer) getAttrVal("Eu_sta"));
	}	
	/**
	 * 标本采集状态
	 * @param Eu_sta
	 */
	public void setEu_sta(Integer Eu_sta) {
		setAttrVal("Eu_sta", Eu_sta);
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
	 * 试管颜色
	 * @return String
	 */
	public String getColor() {
		return ((String) getAttrVal("Color"));
	}	
	/**
	 * 试管颜色
	 * @param Color
	 */
	public void setColor(String Color) {
		setAttrVal("Color", Color);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * 扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	/**
	 * 扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	/**
	 * 扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
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
	 * 标本体检名称
	 * @return String
	 */
	public String getName_lab_pe() {
		return ((String) getAttrVal("Name_lab_pe"));
	}	
	/**
	 * 标本体检名称
	 * @param Name_lab_pe
	 */
	public void setName_lab_pe(String Name_lab_pe) {
		setAttrVal("Name_lab_pe", Name_lab_pe);
	}
	/**
	 * 客户姓名
	 * @return String
	 */
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}	
	/**
	 * 客户姓名
	 * @param Name_psn
	 */
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
	}
	/**
	 * 执行状态名称
	 * @return String
	 */
	public String getName_sta() {
		return ((String) getAttrVal("Name_sta"));
	}	
	/**
	 * 执行状态名称
	 * @param Name_sta
	 */
	public void setName_sta(String Name_sta) {
		setAttrVal("Name_sta", Name_sta);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}	
	/**
	 * 执行科室名称
	 * @param Name_dep_mp
	 */
	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
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
		return "Id_labsamp";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_apt_labsamp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeLabSampDODesc.class);
	}
	
}