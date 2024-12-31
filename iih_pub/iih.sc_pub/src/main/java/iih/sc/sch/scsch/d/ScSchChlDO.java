package iih.sc.sch.scsch.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.sch.scsch.d.desc.ScSchChlDODesc;
import java.math.BigDecimal;

/**
 * 计划排班_排班_渠道 DO数据 
 * 
 */
public class ScSchChlDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//排班渠道ID
	public static final String ID_SCHCHL= "Id_schchl";
	//排班
	public static final String ID_SCH= "Id_sch";
	//渠道
	public static final String ID_SCCHL= "Id_scchl";
	//对应号源池编号
	public static final String SCPOLCN= "Scpolcn";
	//授权科室
	public static final String IDS_DEP_SPEC= "Ids_dep_spec";
	//授权医生
	public static final String IDS_EMP_SPEC= "Ids_emp_spec";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//开放标识
	public static final String FG_ACTIVE= "Fg_active";
	//开放时长
	public static final String QUAN_APPT_TIME= "Quan_appt_time";
	//已使用时长
	public static final String QUAN_USED_TIME= "Quan_used_time";
	//就诊类型
	public static final String ID_ENTP= "Id_entp";
	//数量_号源池0_可预约
	public static final String QUAN_APPT= "Quan_appt";
	//数量_号源池0_已用
	public static final String QUAN_USED= "Quan_used";
	//预约渠道名称
	public static final String NAME_SCCHL= "Name_scchl";
	//预约渠道编码
	public static final String CODE_SCCHL= "Code_scchl";
	//名称
	public static final String NAME_DEP_SPEC= "Name_dep_spec";
	//姓名
	public static final String NAME_EMP_SPEC= "Name_emp_spec";
	//就诊类型编码
	public static final String CODE_ENTP= "Code_entp";
	//就诊类型名称
	public static final String NAME_ENTP= "Name_entp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 排班渠道ID
	 * @return String
	 */
	public String getId_schchl() {
		return ((String) getAttrVal("Id_schchl"));
	}	
	/**
	 * 排班渠道ID
	 * @param Id_schchl
	 */
	public void setId_schchl(String Id_schchl) {
		setAttrVal("Id_schchl", Id_schchl);
	}
	/**
	 * 排班
	 * @return String
	 */
	public String getId_sch() {
		return ((String) getAttrVal("Id_sch"));
	}	
	/**
	 * 排班
	 * @param Id_sch
	 */
	public void setId_sch(String Id_sch) {
		setAttrVal("Id_sch", Id_sch);
	}
	/**
	 * 渠道
	 * @return String
	 */
	public String getId_scchl() {
		return ((String) getAttrVal("Id_scchl"));
	}	
	/**
	 * 渠道
	 * @param Id_scchl
	 */
	public void setId_scchl(String Id_scchl) {
		setAttrVal("Id_scchl", Id_scchl);
	}
	/**
	 * 对应号源池编号
	 * @return Integer
	 */
	public Integer getScpolcn() {
		return ((Integer) getAttrVal("Scpolcn"));
	}	
	/**
	 * 对应号源池编号
	 * @param Scpolcn
	 */
	public void setScpolcn(Integer Scpolcn) {
		setAttrVal("Scpolcn", Scpolcn);
	}
	/**
	 * 授权科室
	 * @return String
	 */
	public String getIds_dep_spec() {
		return ((String) getAttrVal("Ids_dep_spec"));
	}	
	/**
	 * 授权科室
	 * @param Ids_dep_spec
	 */
	public void setIds_dep_spec(String Ids_dep_spec) {
		setAttrVal("Ids_dep_spec", Ids_dep_spec);
	}
	/**
	 * 授权医生
	 * @return String
	 */
	public String getIds_emp_spec() {
		return ((String) getAttrVal("Ids_emp_spec"));
	}	
	/**
	 * 授权医生
	 * @param Ids_emp_spec
	 */
	public void setIds_emp_spec(String Ids_emp_spec) {
		setAttrVal("Ids_emp_spec", Ids_emp_spec);
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
	 * 开放标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 开放标识
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 开放时长
	 * @return FTime
	 */
	public FTime getQuan_appt_time() {
		return ((FTime) getAttrVal("Quan_appt_time"));
	}	
	/**
	 * 开放时长
	 * @param Quan_appt_time
	 */
	public void setQuan_appt_time(FTime Quan_appt_time) {
		setAttrVal("Quan_appt_time", Quan_appt_time);
	}
	/**
	 * 已使用时长
	 * @return FTime
	 */
	public FTime getQuan_used_time() {
		return ((FTime) getAttrVal("Quan_used_time"));
	}	
	/**
	 * 已使用时长
	 * @param Quan_used_time
	 */
	public void setQuan_used_time(FTime Quan_used_time) {
		setAttrVal("Quan_used_time", Quan_used_time);
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
	 * 数量_号源池0_可预约
	 * @return Integer
	 */
	public Integer getQuan_appt() {
		return ((Integer) getAttrVal("Quan_appt"));
	}	
	/**
	 * 数量_号源池0_可预约
	 * @param Quan_appt
	 */
	public void setQuan_appt(Integer Quan_appt) {
		setAttrVal("Quan_appt", Quan_appt);
	}
	/**
	 * 数量_号源池0_已用
	 * @return Integer
	 */
	public Integer getQuan_used() {
		return ((Integer) getAttrVal("Quan_used"));
	}	
	/**
	 * 数量_号源池0_已用
	 * @param Quan_used
	 */
	public void setQuan_used(Integer Quan_used) {
		setAttrVal("Quan_used", Quan_used);
	}
	/**
	 * 预约渠道名称
	 * @return String
	 */
	public String getName_scchl() {
		return ((String) getAttrVal("Name_scchl"));
	}	
	/**
	 * 预约渠道名称
	 * @param Name_scchl
	 */
	public void setName_scchl(String Name_scchl) {
		setAttrVal("Name_scchl", Name_scchl);
	}
	/**
	 * 预约渠道编码
	 * @return String
	 */
	public String getCode_scchl() {
		return ((String) getAttrVal("Code_scchl"));
	}	
	/**
	 * 预约渠道编码
	 * @param Code_scchl
	 */
	public void setCode_scchl(String Code_scchl) {
		setAttrVal("Code_scchl", Code_scchl);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dep_spec() {
		return ((String) getAttrVal("Name_dep_spec"));
	}	
	/**
	 * 名称
	 * @param Name_dep_spec
	 */
	public void setName_dep_spec(String Name_dep_spec) {
		setAttrVal("Name_dep_spec", Name_dep_spec);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_emp_spec() {
		return ((String) getAttrVal("Name_emp_spec"));
	}	
	/**
	 * 姓名
	 * @param Name_emp_spec
	 */
	public void setName_emp_spec(String Name_emp_spec) {
		setAttrVal("Name_emp_spec", Name_emp_spec);
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
	 * 就诊类型名称
	 * @return String
	 */
	public String getName_entp() {
		return ((String) getAttrVal("Name_entp"));
	}	
	/**
	 * 就诊类型名称
	 * @param Name_entp
	 */
	public void setName_entp(String Name_entp) {
		setAttrVal("Name_entp", Name_entp);
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
		return "Id_schchl";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_sch_chl";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScSchChlDODesc.class);
	}
	
}