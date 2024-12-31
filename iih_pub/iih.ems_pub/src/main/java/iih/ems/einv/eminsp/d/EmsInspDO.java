package iih.ems.einv.eminsp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ems.einv.eminsp.d.desc.EmsInspDODesc;
import java.math.BigDecimal;

/**
 * 大型设备验收 DO数据 
 * 
 */
public class EmsInspDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//验收单主键
	public static final String ID_INSP= "Id_insp";
	//编码
	public static final String CODE= "Code";
	//验收单名称
	public static final String NAME= "Name";
	//使用科室
	public static final String ID_DEPT= "Id_dept";
	//仓库
	public static final String ID_WH= "Id_wh";
	//启用日期
	public static final String DT_STRAT= "Dt_strat";
	//开箱日期
	public static final String DT_OUTBOX= "Dt_outbox";
	//验收登记信息
	public static final String REG_INFO= "Reg_info";
	//技术资料
	public static final String TECH_DATA= "Tech_data";
	//备注
	public static final String DES= "Des";
	//验收人员
	public static final String ID_INSP_OPER= "Id_insp_oper";
	//验收日期
	public static final String DT_INSP= "Dt_insp";
	//是否启用
	public static final String FG_ACTIVE= "Fg_active";
	//审核人员
	public static final String ID_CONF_OPER= "Id_conf_oper";
	//审核时间
	public static final String DT_CONF= "Dt_conf";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//供应商
	public static final String ID_SUP= "Id_sup";
	//采购单主键
	public static final String ID_OP= "Id_op";
	//采购单号
	public static final String CODE_OP= "Code_op";
	//验收单状态
	public static final String ID_STU= "Id_stu";
	//验收单状态编码
	public static final String SD_STU= "Sd_stu";
	//审核意见
	public static final String OPINION= "Opinion";
	//编码
	public static final String CODE_DEPT= "Code_dept";
	//名称
	public static final String NAME_DEPT= "Name_dept";
	//仓库名称
	public static final String NAME_WH= "Name_wh";
	//仓库编码
	public static final String CODE_WH= "Code_wh";
	//姓名
	public static final String NAME_INSP= "Name_insp";
	//姓名
	public static final String NAME_CONF= "Name_conf";
	//供应商与厂商名称
	public static final String NAME_SUP= "Name_sup";
	//编码
	public static final String CODE_STTU= "Code_sttu";
	//名称
	public static final String NAME_STTU= "Name_sttu";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 验收单主键
	 * @return String
	 */
	public String getId_insp() {
		return ((String) getAttrVal("Id_insp"));
	}	
	/**
	 * 验收单主键
	 * @param Id_insp
	 */
	public void setId_insp(String Id_insp) {
		setAttrVal("Id_insp", Id_insp);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 验收单名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 验收单名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 使用科室
	 * @return String
	 */
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}	
	/**
	 * 使用科室
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	/**
	 * 仓库
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	/**
	 * 仓库
	 * @param Id_wh
	 */
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	/**
	 * 启用日期
	 * @return FDate
	 */
	public FDate getDt_strat() {
		return ((FDate) getAttrVal("Dt_strat"));
	}	
	/**
	 * 启用日期
	 * @param Dt_strat
	 */
	public void setDt_strat(FDate Dt_strat) {
		setAttrVal("Dt_strat", Dt_strat);
	}
	/**
	 * 开箱日期
	 * @return FDate
	 */
	public FDate getDt_outbox() {
		return ((FDate) getAttrVal("Dt_outbox"));
	}	
	/**
	 * 开箱日期
	 * @param Dt_outbox
	 */
	public void setDt_outbox(FDate Dt_outbox) {
		setAttrVal("Dt_outbox", Dt_outbox);
	}
	/**
	 * 验收登记信息
	 * @return String
	 */
	public String getReg_info() {
		return ((String) getAttrVal("Reg_info"));
	}	
	/**
	 * 验收登记信息
	 * @param Reg_info
	 */
	public void setReg_info(String Reg_info) {
		setAttrVal("Reg_info", Reg_info);
	}
	/**
	 * 技术资料
	 * @return String
	 */
	public String getTech_data() {
		return ((String) getAttrVal("Tech_data"));
	}	
	/**
	 * 技术资料
	 * @param Tech_data
	 */
	public void setTech_data(String Tech_data) {
		setAttrVal("Tech_data", Tech_data);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 备注
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 验收人员
	 * @return String
	 */
	public String getId_insp_oper() {
		return ((String) getAttrVal("Id_insp_oper"));
	}	
	/**
	 * 验收人员
	 * @param Id_insp_oper
	 */
	public void setId_insp_oper(String Id_insp_oper) {
		setAttrVal("Id_insp_oper", Id_insp_oper);
	}
	/**
	 * 验收日期
	 * @return FDateTime
	 */
	public FDateTime getDt_insp() {
		return ((FDateTime) getAttrVal("Dt_insp"));
	}	
	/**
	 * 验收日期
	 * @param Dt_insp
	 */
	public void setDt_insp(FDateTime Dt_insp) {
		setAttrVal("Dt_insp", Dt_insp);
	}
	/**
	 * 是否启用
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 是否启用
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 审核人员
	 * @return String
	 */
	public String getId_conf_oper() {
		return ((String) getAttrVal("Id_conf_oper"));
	}	
	/**
	 * 审核人员
	 * @param Id_conf_oper
	 */
	public void setId_conf_oper(String Id_conf_oper) {
		setAttrVal("Id_conf_oper", Id_conf_oper);
	}
	/**
	 * 审核时间
	 * @return FDateTime
	 */
	public FDateTime getDt_conf() {
		return ((FDateTime) getAttrVal("Dt_conf"));
	}	
	/**
	 * 审核时间
	 * @param Dt_conf
	 */
	public void setDt_conf(FDateTime Dt_conf) {
		setAttrVal("Dt_conf", Dt_conf);
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
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
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
	 * 供应商
	 * @return String
	 */
	public String getId_sup() {
		return ((String) getAttrVal("Id_sup"));
	}	
	/**
	 * 供应商
	 * @param Id_sup
	 */
	public void setId_sup(String Id_sup) {
		setAttrVal("Id_sup", Id_sup);
	}
	/**
	 * 采购单主键
	 * @return String
	 */
	public String getId_op() {
		return ((String) getAttrVal("Id_op"));
	}	
	/**
	 * 采购单主键
	 * @param Id_op
	 */
	public void setId_op(String Id_op) {
		setAttrVal("Id_op", Id_op);
	}
	/**
	 * 采购单号
	 * @return String
	 */
	public String getCode_op() {
		return ((String) getAttrVal("Code_op"));
	}	
	/**
	 * 采购单号
	 * @param Code_op
	 */
	public void setCode_op(String Code_op) {
		setAttrVal("Code_op", Code_op);
	}
	/**
	 * 验收单状态
	 * @return String
	 */
	public String getId_stu() {
		return ((String) getAttrVal("Id_stu"));
	}	
	/**
	 * 验收单状态
	 * @param Id_stu
	 */
	public void setId_stu(String Id_stu) {
		setAttrVal("Id_stu", Id_stu);
	}
	/**
	 * 验收单状态编码
	 * @return String
	 */
	public String getSd_stu() {
		return ((String) getAttrVal("Sd_stu"));
	}	
	/**
	 * 验收单状态编码
	 * @param Sd_stu
	 */
	public void setSd_stu(String Sd_stu) {
		setAttrVal("Sd_stu", Sd_stu);
	}
	/**
	 * 审核意见
	 * @return String
	 */
	public String getOpinion() {
		return ((String) getAttrVal("Opinion"));
	}	
	/**
	 * 审核意见
	 * @param Opinion
	 */
	public void setOpinion(String Opinion) {
		setAttrVal("Opinion", Opinion);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_dept() {
		return ((String) getAttrVal("Code_dept"));
	}	
	/**
	 * 编码
	 * @param Code_dept
	 */
	public void setCode_dept(String Code_dept) {
		setAttrVal("Code_dept", Code_dept);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}	
	/**
	 * 名称
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	/**
	 * 仓库名称
	 * @return String
	 */
	public String getName_wh() {
		return ((String) getAttrVal("Name_wh"));
	}	
	/**
	 * 仓库名称
	 * @param Name_wh
	 */
	public void setName_wh(String Name_wh) {
		setAttrVal("Name_wh", Name_wh);
	}
	/**
	 * 仓库编码
	 * @return String
	 */
	public String getCode_wh() {
		return ((String) getAttrVal("Code_wh"));
	}	
	/**
	 * 仓库编码
	 * @param Code_wh
	 */
	public void setCode_wh(String Code_wh) {
		setAttrVal("Code_wh", Code_wh);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_insp() {
		return ((String) getAttrVal("Name_insp"));
	}	
	/**
	 * 姓名
	 * @param Name_insp
	 */
	public void setName_insp(String Name_insp) {
		setAttrVal("Name_insp", Name_insp);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_conf() {
		return ((String) getAttrVal("Name_conf"));
	}	
	/**
	 * 姓名
	 * @param Name_conf
	 */
	public void setName_conf(String Name_conf) {
		setAttrVal("Name_conf", Name_conf);
	}
	/**
	 * 供应商与厂商名称
	 * @return String
	 */
	public String getName_sup() {
		return ((String) getAttrVal("Name_sup"));
	}	
	/**
	 * 供应商与厂商名称
	 * @param Name_sup
	 */
	public void setName_sup(String Name_sup) {
		setAttrVal("Name_sup", Name_sup);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_sttu() {
		return ((String) getAttrVal("Code_sttu"));
	}	
	/**
	 * 编码
	 * @param Code_sttu
	 */
	public void setCode_sttu(String Code_sttu) {
		setAttrVal("Code_sttu", Code_sttu);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_sttu() {
		return ((String) getAttrVal("Name_sttu"));
	}	
	/**
	 * 名称
	 * @param Name_sttu
	 */
	public void setName_sttu(String Name_sttu) {
		setAttrVal("Name_sttu", Name_sttu);
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
		return "Id_insp";
	}
	
	@Override
	public String getTableName() {	  
		return "ems_insp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmsInspDODesc.class);
	}
	
}