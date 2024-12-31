package iih.ci.ord.cior.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cior.d.desc.OrdApOpDODesc;
import java.math.BigDecimal;

/**
 * 手术申请 DO数据 
 * 
 */
public class OrdApOpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医嘱手术申请主键标识
	public static final String ID_APOP= "Id_apop";
	//医嘱
	public static final String ID_OR= "Id_or";
	//临床诊断
	public static final String ID_DI= "Id_di";
	//临床诊断明细
	public static final String STR_ID_DIITM= "Str_id_diitm";
	//诊断编码拼接
	public static final String STR_CODE_DI= "Str_code_di";
	//诊断名称拼接
	public static final String STR_NAME_DI= "Str_name_di";
	//手术申请单号
	public static final String NO_APPLYFORM= "No_applyform";
	//计划手术时间
	public static final String DT_PLAN= "Dt_plan";
	//计划手术时长
	public static final String SUGPLANTIME= "Sugplantime";
	//手术级别
	public static final String ID_LVLSUG= "Id_lvlsug";
	//手术级别编码
	public static final String SD_LVLSUG= "Sd_lvlsug";
	//麻醉方法
	public static final String ID_ANESTP= "Id_anestp";
	//麻醉方法编码
	public static final String SD_ANESTP= "Sd_anestp";
	//切口愈合分级
	public static final String ID_INCITP= "Id_incitp";
	//切口愈合分级编码
	public static final String SD_INCITP= "Sd_incitp";
	//药物过敏标识
	public static final String FG_ALLERGY= "Fg_allergy";
	//冰冻病理标识
	public static final String FG_PATHO= "Fg_patho";
	//手术申请状态
	public static final String ID_SU_OP= "Id_su_op";
	//手术申请状态编码
	public static final String SD_SU_OP= "Sd_su_op";
	//注意事项
	public static final String ANNOUNCEMENTS= "Announcements";
	//手术名称
	public static final String ID_SRV= "Id_srv";
	//手术编码
	public static final String ID_SRV_CODE= "Id_srv_code";
	//预期输血量
	public static final String QUAN_BT_PALN= "Quan_bt_paln";
	//主刀医生
	public static final String ID_EMP_OPERATE= "Id_emp_operate";
	//第一助手
	public static final String ID_EMP_HELPER= "Id_emp_helper";
	//体位id
	public static final String ID_SUGBODY= "Id_sugbody";
	// 体位编码
	public static final String SD_SUGBODY= "Sd_sugbody";
	//特殊用物
	public static final String SPECIALREQ= "Specialreq";
	//特殊仪器
	public static final String SPECIALINSTRUMENT= "Specialinstrument";
	//特殊准备
	public static final String SPECIALDES= "Specialdes";
	//急症手术
	public static final String FG_ER_SUG= "Fg_er_sug";
	//限期手术
	public static final String FG_XQ_SUG= "Fg_xq_sug";
	//择期手术
	public static final String FG_ZQ_SUG= "Fg_zq_sug";
	//是否新开手术
	public static final String FG_NEW_SUG= "Fg_new_sug";
	//诊断名称
	public static final String NAME_DIAG= "Name_diag";
	//诊断子项目id
	public static final String ID_DIITM= "Id_diitm";
	//打印标识
	public static final String FG_PRN= "Fg_prn";
	//打印次数
	public static final String CNT_PRN= "Cnt_prn";
	//手术所归类的标准诊断
	public static final String ID_DIDEF_RELSTD= "Id_didef_relstd";
	//手术名称描述信息
	public static final String NAME_DES= "Name_des";
	//日间手术标识
	public static final String FG_DAYSUG= "Fg_daysug";
	//手术期限
	public static final String ID_DATELIMITTYPE= "Id_datelimittype";
	//手术期限编码
	public static final String SD_DATELIMITTYPE= "Sd_datelimittype";
	//手术部位id
	public static final String ID_SURGICAL_SITE= "Id_surgical_site";
	//手术部位编码
	public static final String SD_SURGICAL_SITE= "Sd_surgical_site";
	//特殊用物id
	public static final String ID_SPECIALREQ= "Id_specialreq";
	//特殊用物编码
	public static final String SD_SPECIALREQ= "Sd_specialreq";
	//特殊仪器Id
	public static final String ID_SPECIALINSTRUMENT= "Id_specialinstrument";
	//特殊仪器编码
	public static final String SD_SPECIALINSTRUMENT= "Sd_specialinstrument";
	//手术要求
	public static final String SUG_REQUIRE= "Sug_require";
	//感染手术标志
	public static final String FG_INFECTION_SUG= "Fg_infection_sug";
	//感染手术分类
	public static final String SD_INFECTIONCA_SUG= "Sd_infectionca_sug";
	//感染手术分类名称
	public static final String NAME_INFECTIONCA_SUG= "Name_infectionca_sug";
	//药物过敏记录
	public static final String DES_ALLERGY= "Des_allergy";
	//麻醉风险评分id
	public static final String ID_ASA= "Id_asa";
	//麻醉风险评分sd
	public static final String SD_ASA= "Sd_asa";
	//麻醉风险评分
	public static final String NAME_ASA= "Name_asa";
	//诊断
	public static final String ID_DIDEF_DIS= "Id_didef_dis";
	//诊断名称
	public static final String NAME_DIDEF_DIS= "Name_didef_dis";
	//名称
	public static final String NAME_LVLSUG= "Name_lvlsug";
	//名称
	public static final String NAME_ANESTP= "Name_anestp";
	//名称
	public static final String NAME_INCITP= "Name_incitp";
	//服务名称
	public static final String NAME_OP= "Name_op";
	//服务编码
	public static final String CODE_OP= "Code_op";
	//姓名
	public static final String NAME_OPERATE= "Name_operate";
	//姓名
	public static final String NAME_HELPER= "Name_helper";
	//名称
	public static final String NAME_SUGBODY= "Name_sugbody";
	//名称
	public static final String NAME_DATELIMITTP= "Name_datelimittp";
	//手术部位名称
	public static final String NAME_SURGICAL_SITE= "Name_surgical_site";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医嘱手术申请主键标识
	 * @return String
	 */
	public String getId_apop() {
		return ((String) getAttrVal("Id_apop"));
	}	
	/**
	 * 医嘱手术申请主键标识
	 * @param Id_apop
	 */
	public void setId_apop(String Id_apop) {
		setAttrVal("Id_apop", Id_apop);
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
	 * 临床诊断
	 * @return String
	 */
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}	
	/**
	 * 临床诊断
	 * @param Id_di
	 */
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	/**
	 * 临床诊断明细
	 * @return String
	 */
	public String getStr_id_diitm() {
		return ((String) getAttrVal("Str_id_diitm"));
	}	
	/**
	 * 临床诊断明细
	 * @param Str_id_diitm
	 */
	public void setStr_id_diitm(String Str_id_diitm) {
		setAttrVal("Str_id_diitm", Str_id_diitm);
	}
	/**
	 * 诊断编码拼接
	 * @return String
	 */
	public String getStr_code_di() {
		return ((String) getAttrVal("Str_code_di"));
	}	
	/**
	 * 诊断编码拼接
	 * @param Str_code_di
	 */
	public void setStr_code_di(String Str_code_di) {
		setAttrVal("Str_code_di", Str_code_di);
	}
	/**
	 * 诊断名称拼接
	 * @return String
	 */
	public String getStr_name_di() {
		return ((String) getAttrVal("Str_name_di"));
	}	
	/**
	 * 诊断名称拼接
	 * @param Str_name_di
	 */
	public void setStr_name_di(String Str_name_di) {
		setAttrVal("Str_name_di", Str_name_di);
	}
	/**
	 * 手术申请单号
	 * @return String
	 */
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}	
	/**
	 * 手术申请单号
	 * @param No_applyform
	 */
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	/**
	 * 计划手术时间
	 * @return FDateTime
	 */
	public FDateTime getDt_plan() {
		return ((FDateTime) getAttrVal("Dt_plan"));
	}	
	/**
	 * 计划手术时间
	 * @param Dt_plan
	 */
	public void setDt_plan(FDateTime Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}
	/**
	 * 计划手术时长
	 * @return FDouble
	 */
	public FDouble getSugplantime() {
		return ((FDouble) getAttrVal("Sugplantime"));
	}	
	/**
	 * 计划手术时长
	 * @param Sugplantime
	 */
	public void setSugplantime(FDouble Sugplantime) {
		setAttrVal("Sugplantime", Sugplantime);
	}
	/**
	 * 手术级别
	 * @return String
	 */
	public String getId_lvlsug() {
		return ((String) getAttrVal("Id_lvlsug"));
	}	
	/**
	 * 手术级别
	 * @param Id_lvlsug
	 */
	public void setId_lvlsug(String Id_lvlsug) {
		setAttrVal("Id_lvlsug", Id_lvlsug);
	}
	/**
	 * 手术级别编码
	 * @return String
	 */
	public String getSd_lvlsug() {
		return ((String) getAttrVal("Sd_lvlsug"));
	}	
	/**
	 * 手术级别编码
	 * @param Sd_lvlsug
	 */
	public void setSd_lvlsug(String Sd_lvlsug) {
		setAttrVal("Sd_lvlsug", Sd_lvlsug);
	}
	/**
	 * 麻醉方法
	 * @return String
	 */
	public String getId_anestp() {
		return ((String) getAttrVal("Id_anestp"));
	}	
	/**
	 * 麻醉方法
	 * @param Id_anestp
	 */
	public void setId_anestp(String Id_anestp) {
		setAttrVal("Id_anestp", Id_anestp);
	}
	/**
	 * 麻醉方法编码
	 * @return String
	 */
	public String getSd_anestp() {
		return ((String) getAttrVal("Sd_anestp"));
	}	
	/**
	 * 麻醉方法编码
	 * @param Sd_anestp
	 */
	public void setSd_anestp(String Sd_anestp) {
		setAttrVal("Sd_anestp", Sd_anestp);
	}
	/**
	 * 切口愈合分级
	 * @return String
	 */
	public String getId_incitp() {
		return ((String) getAttrVal("Id_incitp"));
	}	
	/**
	 * 切口愈合分级
	 * @param Id_incitp
	 */
	public void setId_incitp(String Id_incitp) {
		setAttrVal("Id_incitp", Id_incitp);
	}
	/**
	 * 切口愈合分级编码
	 * @return String
	 */
	public String getSd_incitp() {
		return ((String) getAttrVal("Sd_incitp"));
	}	
	/**
	 * 切口愈合分级编码
	 * @param Sd_incitp
	 */
	public void setSd_incitp(String Sd_incitp) {
		setAttrVal("Sd_incitp", Sd_incitp);
	}
	/**
	 * 药物过敏标识
	 * @return FBoolean
	 */
	public FBoolean getFg_allergy() {
		return ((FBoolean) getAttrVal("Fg_allergy"));
	}	
	/**
	 * 药物过敏标识
	 * @param Fg_allergy
	 */
	public void setFg_allergy(FBoolean Fg_allergy) {
		setAttrVal("Fg_allergy", Fg_allergy);
	}
	/**
	 * 冰冻病理标识
	 * @return FBoolean
	 */
	public FBoolean getFg_patho() {
		return ((FBoolean) getAttrVal("Fg_patho"));
	}	
	/**
	 * 冰冻病理标识
	 * @param Fg_patho
	 */
	public void setFg_patho(FBoolean Fg_patho) {
		setAttrVal("Fg_patho", Fg_patho);
	}
	/**
	 * 手术申请状态
	 * @return String
	 */
	public String getId_su_op() {
		return ((String) getAttrVal("Id_su_op"));
	}	
	/**
	 * 手术申请状态
	 * @param Id_su_op
	 */
	public void setId_su_op(String Id_su_op) {
		setAttrVal("Id_su_op", Id_su_op);
	}
	/**
	 * 手术申请状态编码
	 * @return String
	 */
	public String getSd_su_op() {
		return ((String) getAttrVal("Sd_su_op"));
	}	
	/**
	 * 手术申请状态编码
	 * @param Sd_su_op
	 */
	public void setSd_su_op(String Sd_su_op) {
		setAttrVal("Sd_su_op", Sd_su_op);
	}
	/**
	 * 注意事项
	 * @return String
	 */
	public String getAnnouncements() {
		return ((String) getAttrVal("Announcements"));
	}	
	/**
	 * 注意事项
	 * @param Announcements
	 */
	public void setAnnouncements(String Announcements) {
		setAttrVal("Announcements", Announcements);
	}
	/**
	 * 手术名称
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 手术名称
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 手术编码
	 * @return String
	 */
	public String getId_srv_code() {
		return ((String) getAttrVal("Id_srv_code"));
	}	
	/**
	 * 手术编码
	 * @param Id_srv_code
	 */
	public void setId_srv_code(String Id_srv_code) {
		setAttrVal("Id_srv_code", Id_srv_code);
	}
	/**
	 * 预期输血量
	 * @return FDouble
	 */
	public FDouble getQuan_bt_paln() {
		return ((FDouble) getAttrVal("Quan_bt_paln"));
	}	
	/**
	 * 预期输血量
	 * @param Quan_bt_paln
	 */
	public void setQuan_bt_paln(FDouble Quan_bt_paln) {
		setAttrVal("Quan_bt_paln", Quan_bt_paln);
	}
	/**
	 * 主刀医生
	 * @return String
	 */
	public String getId_emp_operate() {
		return ((String) getAttrVal("Id_emp_operate"));
	}	
	/**
	 * 主刀医生
	 * @param Id_emp_operate
	 */
	public void setId_emp_operate(String Id_emp_operate) {
		setAttrVal("Id_emp_operate", Id_emp_operate);
	}
	/**
	 * 第一助手
	 * @return String
	 */
	public String getId_emp_helper() {
		return ((String) getAttrVal("Id_emp_helper"));
	}	
	/**
	 * 第一助手
	 * @param Id_emp_helper
	 */
	public void setId_emp_helper(String Id_emp_helper) {
		setAttrVal("Id_emp_helper", Id_emp_helper);
	}
	/**
	 * 体位id
	 * @return String
	 */
	public String getId_sugbody() {
		return ((String) getAttrVal("Id_sugbody"));
	}	
	/**
	 * 体位id
	 * @param Id_sugbody
	 */
	public void setId_sugbody(String Id_sugbody) {
		setAttrVal("Id_sugbody", Id_sugbody);
	}
	/**
	 *  体位编码
	 * @return String
	 */
	public String getSd_sugbody() {
		return ((String) getAttrVal("Sd_sugbody"));
	}	
	/**
	 *  体位编码
	 * @param Sd_sugbody
	 */
	public void setSd_sugbody(String Sd_sugbody) {
		setAttrVal("Sd_sugbody", Sd_sugbody);
	}
	/**
	 * 特殊用物
	 * @return String
	 */
	public String getSpecialreq() {
		return ((String) getAttrVal("Specialreq"));
	}	
	/**
	 * 特殊用物
	 * @param Specialreq
	 */
	public void setSpecialreq(String Specialreq) {
		setAttrVal("Specialreq", Specialreq);
	}
	/**
	 * 特殊仪器
	 * @return String
	 */
	public String getSpecialinstrument() {
		return ((String) getAttrVal("Specialinstrument"));
	}	
	/**
	 * 特殊仪器
	 * @param Specialinstrument
	 */
	public void setSpecialinstrument(String Specialinstrument) {
		setAttrVal("Specialinstrument", Specialinstrument);
	}
	/**
	 * 特殊准备
	 * @return String
	 */
	public String getSpecialdes() {
		return ((String) getAttrVal("Specialdes"));
	}	
	/**
	 * 特殊准备
	 * @param Specialdes
	 */
	public void setSpecialdes(String Specialdes) {
		setAttrVal("Specialdes", Specialdes);
	}
	/**
	 * 急症手术
	 * @return FBoolean
	 */
	public FBoolean getFg_er_sug() {
		return ((FBoolean) getAttrVal("Fg_er_sug"));
	}	
	/**
	 * 急症手术
	 * @param Fg_er_sug
	 */
	public void setFg_er_sug(FBoolean Fg_er_sug) {
		setAttrVal("Fg_er_sug", Fg_er_sug);
	}
	/**
	 * 限期手术
	 * @return FBoolean
	 */
	public FBoolean getFg_xq_sug() {
		return ((FBoolean) getAttrVal("Fg_xq_sug"));
	}	
	/**
	 * 限期手术
	 * @param Fg_xq_sug
	 */
	public void setFg_xq_sug(FBoolean Fg_xq_sug) {
		setAttrVal("Fg_xq_sug", Fg_xq_sug);
	}
	/**
	 * 择期手术
	 * @return FBoolean
	 */
	public FBoolean getFg_zq_sug() {
		return ((FBoolean) getAttrVal("Fg_zq_sug"));
	}	
	/**
	 * 择期手术
	 * @param Fg_zq_sug
	 */
	public void setFg_zq_sug(FBoolean Fg_zq_sug) {
		setAttrVal("Fg_zq_sug", Fg_zq_sug);
	}
	/**
	 * 是否新开手术
	 * @return FBoolean
	 */
	public FBoolean getFg_new_sug() {
		return ((FBoolean) getAttrVal("Fg_new_sug"));
	}	
	/**
	 * 是否新开手术
	 * @param Fg_new_sug
	 */
	public void setFg_new_sug(FBoolean Fg_new_sug) {
		setAttrVal("Fg_new_sug", Fg_new_sug);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName_diag() {
		return ((String) getAttrVal("Name_diag"));
	}	
	/**
	 * 诊断名称
	 * @param Name_diag
	 */
	public void setName_diag(String Name_diag) {
		setAttrVal("Name_diag", Name_diag);
	}
	/**
	 * 诊断子项目id
	 * @return String
	 */
	public String getId_diitm() {
		return ((String) getAttrVal("Id_diitm"));
	}	
	/**
	 * 诊断子项目id
	 * @param Id_diitm
	 */
	public void setId_diitm(String Id_diitm) {
		setAttrVal("Id_diitm", Id_diitm);
	}
	/**
	 * 打印标识
	 * @return FBoolean
	 */
	public FBoolean getFg_prn() {
		return ((FBoolean) getAttrVal("Fg_prn"));
	}	
	/**
	 * 打印标识
	 * @param Fg_prn
	 */
	public void setFg_prn(FBoolean Fg_prn) {
		setAttrVal("Fg_prn", Fg_prn);
	}
	/**
	 * 打印次数
	 * @return Integer
	 */
	public Integer getCnt_prn() {
		return ((Integer) getAttrVal("Cnt_prn"));
	}	
	/**
	 * 打印次数
	 * @param Cnt_prn
	 */
	public void setCnt_prn(Integer Cnt_prn) {
		setAttrVal("Cnt_prn", Cnt_prn);
	}
	/**
	 * 手术所归类的标准诊断
	 * @return String
	 */
	public String getId_didef_relstd() {
		return ((String) getAttrVal("Id_didef_relstd"));
	}	
	/**
	 * 手术所归类的标准诊断
	 * @param Id_didef_relstd
	 */
	public void setId_didef_relstd(String Id_didef_relstd) {
		setAttrVal("Id_didef_relstd", Id_didef_relstd);
	}
	/**
	 * 手术名称描述信息
	 * @return String
	 */
	public String getName_des() {
		return ((String) getAttrVal("Name_des"));
	}	
	/**
	 * 手术名称描述信息
	 * @param Name_des
	 */
	public void setName_des(String Name_des) {
		setAttrVal("Name_des", Name_des);
	}
	/**
	 * 日间手术标识
	 * @return FBoolean
	 */
	public FBoolean getFg_daysug() {
		return ((FBoolean) getAttrVal("Fg_daysug"));
	}	
	/**
	 * 日间手术标识
	 * @param Fg_daysug
	 */
	public void setFg_daysug(FBoolean Fg_daysug) {
		setAttrVal("Fg_daysug", Fg_daysug);
	}
	/**
	 * 手术期限
	 * @return String
	 */
	public String getId_datelimittype() {
		return ((String) getAttrVal("Id_datelimittype"));
	}	
	/**
	 * 手术期限
	 * @param Id_datelimittype
	 */
	public void setId_datelimittype(String Id_datelimittype) {
		setAttrVal("Id_datelimittype", Id_datelimittype);
	}
	/**
	 * 手术期限编码
	 * @return String
	 */
	public String getSd_datelimittype() {
		return ((String) getAttrVal("Sd_datelimittype"));
	}	
	/**
	 * 手术期限编码
	 * @param Sd_datelimittype
	 */
	public void setSd_datelimittype(String Sd_datelimittype) {
		setAttrVal("Sd_datelimittype", Sd_datelimittype);
	}
	/**
	 * 手术部位id
	 * @return String
	 */
	public String getId_surgical_site() {
		return ((String) getAttrVal("Id_surgical_site"));
	}	
	/**
	 * 手术部位id
	 * @param Id_surgical_site
	 */
	public void setId_surgical_site(String Id_surgical_site) {
		setAttrVal("Id_surgical_site", Id_surgical_site);
	}
	/**
	 * 手术部位编码
	 * @return String
	 */
	public String getSd_surgical_site() {
		return ((String) getAttrVal("Sd_surgical_site"));
	}	
	/**
	 * 手术部位编码
	 * @param Sd_surgical_site
	 */
	public void setSd_surgical_site(String Sd_surgical_site) {
		setAttrVal("Sd_surgical_site", Sd_surgical_site);
	}
	/**
	 * 特殊用物id
	 * @return String
	 */
	public String getId_specialreq() {
		return ((String) getAttrVal("Id_specialreq"));
	}	
	/**
	 * 特殊用物id
	 * @param Id_specialreq
	 */
	public void setId_specialreq(String Id_specialreq) {
		setAttrVal("Id_specialreq", Id_specialreq);
	}
	/**
	 * 特殊用物编码
	 * @return String
	 */
	public String getSd_specialreq() {
		return ((String) getAttrVal("Sd_specialreq"));
	}	
	/**
	 * 特殊用物编码
	 * @param Sd_specialreq
	 */
	public void setSd_specialreq(String Sd_specialreq) {
		setAttrVal("Sd_specialreq", Sd_specialreq);
	}
	/**
	 * 特殊仪器Id
	 * @return String
	 */
	public String getId_specialinstrument() {
		return ((String) getAttrVal("Id_specialinstrument"));
	}	
	/**
	 * 特殊仪器Id
	 * @param Id_specialinstrument
	 */
	public void setId_specialinstrument(String Id_specialinstrument) {
		setAttrVal("Id_specialinstrument", Id_specialinstrument);
	}
	/**
	 * 特殊仪器编码
	 * @return String
	 */
	public String getSd_specialinstrument() {
		return ((String) getAttrVal("Sd_specialinstrument"));
	}	
	/**
	 * 特殊仪器编码
	 * @param Sd_specialinstrument
	 */
	public void setSd_specialinstrument(String Sd_specialinstrument) {
		setAttrVal("Sd_specialinstrument", Sd_specialinstrument);
	}
	/**
	 * 手术要求
	 * @return String
	 */
	public String getSug_require() {
		return ((String) getAttrVal("Sug_require"));
	}	
	/**
	 * 手术要求
	 * @param Sug_require
	 */
	public void setSug_require(String Sug_require) {
		setAttrVal("Sug_require", Sug_require);
	}
	/**
	 * 感染手术标志
	 * @return FBoolean
	 */
	public FBoolean getFg_infection_sug() {
		return ((FBoolean) getAttrVal("Fg_infection_sug"));
	}	
	/**
	 * 感染手术标志
	 * @param Fg_infection_sug
	 */
	public void setFg_infection_sug(FBoolean Fg_infection_sug) {
		setAttrVal("Fg_infection_sug", Fg_infection_sug);
	}
	/**
	 * 感染手术分类
	 * @return String
	 */
	public String getSd_infectionca_sug() {
		return ((String) getAttrVal("Sd_infectionca_sug"));
	}	
	/**
	 * 感染手术分类
	 * @param Sd_infectionca_sug
	 */
	public void setSd_infectionca_sug(String Sd_infectionca_sug) {
		setAttrVal("Sd_infectionca_sug", Sd_infectionca_sug);
	}
	/**
	 * 感染手术分类名称
	 * @return String
	 */
	public String getName_infectionca_sug() {
		return ((String) getAttrVal("Name_infectionca_sug"));
	}	
	/**
	 * 感染手术分类名称
	 * @param Name_infectionca_sug
	 */
	public void setName_infectionca_sug(String Name_infectionca_sug) {
		setAttrVal("Name_infectionca_sug", Name_infectionca_sug);
	}
	/**
	 * 药物过敏记录
	 * @return String
	 */
	public String getDes_allergy() {
		return ((String) getAttrVal("Des_allergy"));
	}	
	/**
	 * 药物过敏记录
	 * @param Des_allergy
	 */
	public void setDes_allergy(String Des_allergy) {
		setAttrVal("Des_allergy", Des_allergy);
	}
	/**
	 * 麻醉风险评分id
	 * @return String
	 */
	public String getId_asa() {
		return ((String) getAttrVal("Id_asa"));
	}	
	/**
	 * 麻醉风险评分id
	 * @param Id_asa
	 */
	public void setId_asa(String Id_asa) {
		setAttrVal("Id_asa", Id_asa);
	}
	/**
	 * 麻醉风险评分sd
	 * @return String
	 */
	public String getSd_asa() {
		return ((String) getAttrVal("Sd_asa"));
	}	
	/**
	 * 麻醉风险评分sd
	 * @param Sd_asa
	 */
	public void setSd_asa(String Sd_asa) {
		setAttrVal("Sd_asa", Sd_asa);
	}
	/**
	 * 麻醉风险评分
	 * @return String
	 */
	public String getName_asa() {
		return ((String) getAttrVal("Name_asa"));
	}	
	/**
	 * 麻醉风险评分
	 * @param Name_asa
	 */
	public void setName_asa(String Name_asa) {
		setAttrVal("Name_asa", Name_asa);
	}
	/**
	 * 诊断
	 * @return String
	 */
	public String getId_didef_dis() {
		return ((String) getAttrVal("Id_didef_dis"));
	}	
	/**
	 * 诊断
	 * @param Id_didef_dis
	 */
	public void setId_didef_dis(String Id_didef_dis) {
		setAttrVal("Id_didef_dis", Id_didef_dis);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName_didef_dis() {
		return ((String) getAttrVal("Name_didef_dis"));
	}	
	/**
	 * 诊断名称
	 * @param Name_didef_dis
	 */
	public void setName_didef_dis(String Name_didef_dis) {
		setAttrVal("Name_didef_dis", Name_didef_dis);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_lvlsug() {
		return ((String) getAttrVal("Name_lvlsug"));
	}	
	/**
	 * 名称
	 * @param Name_lvlsug
	 */
	public void setName_lvlsug(String Name_lvlsug) {
		setAttrVal("Name_lvlsug", Name_lvlsug);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_anestp() {
		return ((String) getAttrVal("Name_anestp"));
	}	
	/**
	 * 名称
	 * @param Name_anestp
	 */
	public void setName_anestp(String Name_anestp) {
		setAttrVal("Name_anestp", Name_anestp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_incitp() {
		return ((String) getAttrVal("Name_incitp"));
	}	
	/**
	 * 名称
	 * @param Name_incitp
	 */
	public void setName_incitp(String Name_incitp) {
		setAttrVal("Name_incitp", Name_incitp);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_op() {
		return ((String) getAttrVal("Name_op"));
	}	
	/**
	 * 服务名称
	 * @param Name_op
	 */
	public void setName_op(String Name_op) {
		setAttrVal("Name_op", Name_op);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getCode_op() {
		return ((String) getAttrVal("Code_op"));
	}	
	/**
	 * 服务编码
	 * @param Code_op
	 */
	public void setCode_op(String Code_op) {
		setAttrVal("Code_op", Code_op);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_operate() {
		return ((String) getAttrVal("Name_operate"));
	}	
	/**
	 * 姓名
	 * @param Name_operate
	 */
	public void setName_operate(String Name_operate) {
		setAttrVal("Name_operate", Name_operate);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_helper() {
		return ((String) getAttrVal("Name_helper"));
	}	
	/**
	 * 姓名
	 * @param Name_helper
	 */
	public void setName_helper(String Name_helper) {
		setAttrVal("Name_helper", Name_helper);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_sugbody() {
		return ((String) getAttrVal("Name_sugbody"));
	}	
	/**
	 * 名称
	 * @param Name_sugbody
	 */
	public void setName_sugbody(String Name_sugbody) {
		setAttrVal("Name_sugbody", Name_sugbody);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_datelimittp() {
		return ((String) getAttrVal("Name_datelimittp"));
	}	
	/**
	 * 名称
	 * @param Name_datelimittp
	 */
	public void setName_datelimittp(String Name_datelimittp) {
		setAttrVal("Name_datelimittp", Name_datelimittp);
	}
	/**
	 * 手术部位名称
	 * @return String
	 */
	public String getName_surgical_site() {
		return ((String) getAttrVal("Name_surgical_site"));
	}	
	/**
	 * 手术部位名称
	 * @param Name_surgical_site
	 */
	public void setName_surgical_site(String Name_surgical_site) {
		setAttrVal("Name_surgical_site", Name_surgical_site);
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
	public String getEu_anesca() {
		return ((String) getAttrVal("Eu_anesca"));
	}
	public void setEu_anesca(String Eu_anesca) {
		setAttrVal("Eu_anesca", Eu_anesca);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_apop";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_ap_sug";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrdApOpDODesc.class);
	}
	
}