package iih.ci.ord.i.external.provide.meta.bl;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/**
 * 手术信息DTO
 * @author Young
 *
 */
public class OrdOperInfo4BlDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱主键
	 * @return
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 医嘱编码
	 * @return
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}	
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 备注
	 * @return
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}	
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}
	/**
	 * 医嘱内容
	 * @return
	 */
	public String getCount_or() {
		return ((String) getAttrVal("Count_or"));
	}	
	public void setCount_or(String Count_or) {
		setAttrVal("Count_or", Count_or);
	}
	/**
	 * 医嘱名称（手术）
	 * @return
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}	
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
	/**
	 * 签署医生
	 * @return
	 */
	public String getId_emp_sign() {
		return ((String) getAttrVal("Id_emp_sign"));
	}	
	public void setId_emp_sign(String Id_emp_sign) {
		setAttrVal("Id_emp_sign", Id_emp_sign);
	}
	/**
	 * 签署医生编码
	 * @return
	 */
	public String getCode_emp_sign() {
		return ((String) getAttrVal("Code_emp_sign"));
	}	
	public void setCode_emp_sign(String Code_emp_sign) {
		setAttrVal("Code_emp_sign", Code_emp_sign);
	}
	/**
	 * 签署医生姓名
	 * @return
	 */
	public String getName_emp_sign() {
		return ((String) getAttrVal("Name_emp_sign"));
	}	
	public void setName_emp_sign(String Name_emp_sign) {
		setAttrVal("Name_emp_sign", Name_emp_sign);
	}
	/**
	 * 医嘱生效日期
	 * @return
	 */
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}	
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	/**
	 * 医嘱结束时间
	 * @return
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	
	/**
	 * 服务项目（手术）
	 * @return
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 手术服务编码
	 * @return
	 */
	public String getId_srv_code() {
		return ((String) getAttrVal("Id_srv_code"));
	}	
	public void setId_srv_code(String Id_srv_code) {
		setAttrVal("Id_srv_code", Id_srv_code);
	}
	/**
	 * 手术所归类的标准诊断
	 * @return
	 */
	public String getId_didef_relstd() {
		return ((String) getAttrVal("Id_didef_relstd"));
	}	
	public void setId_didef_relstd(String Id_didef_relstd) {
		setAttrVal("Id_didef_relstd", Id_didef_relstd);
	}
	/**
	 * 手术所归类的标准诊断编码
	 * @return
	 */
	public String getSd_didef_relstd() {
		return ((String) getAttrVal("Sd_didef_relstd"));
	}	
	public void setSd_didef_relstd(String Sd_didef_relstd) {
		setAttrVal("Sd_didef_relstd", Sd_didef_relstd);
	}
	/**
	 * 手术所归类的标准诊断名称
	 * @return
	 */
	public String getName_didef_relstd() {
		return ((String) getAttrVal("Name_didef_relstd"));
	}	
	public void setName_didef_relstd(String Name_didef_relstd) {
		setAttrVal("Name_didef_relstd", Name_didef_relstd);
	}
	/**
	 * 临床诊断
	 * @return
	 */
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}	
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	/**
	 * 临床诊断编码
	 * @return
	 */
	public String getSd_di() {
		return ((String) getAttrVal("Sd_di"));
	}	
	public void setSd_di(String Sd_di) {
		setAttrVal("Sd_di", Sd_di);
	}
	/**
	 * 临床诊断名称
	 * @return
	 */
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}	
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
	}
	/**
	 * 手术申请单号
	 * @return
	 */
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}	
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	/**
	 * 计划手术时间
	 * @return
	 */
	public FDateTime getDt_plan() {
		return ((FDateTime) getAttrVal("Dt_plan"));
	}	
	public void setDt_plan(FDateTime Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}
	/**
	 * 手术级别
	 * @return
	 */
	public String getId_lvlsug() {
		return ((String) getAttrVal("Id_lvlsug"));
	}	
	public void setId_lvlsug(String Id_lvlsug) {
		setAttrVal("Id_lvlsug", Id_lvlsug);
	}
	/**
	 * 手术级别编码
	 * @return
	 */
	public String getSd_lvlsug() {
		return ((String) getAttrVal("Sd_lvlsug"));
	}	
	public void setSd_lvlsug(String Sd_lvlsug) {
		setAttrVal("Sd_lvlsug", Sd_lvlsug);
	}
	/**
	 * 手术级别名称
	 * @return
	 */
	public String getName_lvlsug() {
		return ((String) getAttrVal("Name_lvlsug"));
	}	
	public void setName_lvlsug(String Name_lvlsug) {
		setAttrVal("Name_lvlsug", Name_lvlsug);
	}
	/**
	 * 麻醉方法
	 * @return
	 */
	public String getId_anestp() {
		return ((String) getAttrVal("Id_anestp"));
	}	
	public void setId_anestp(String Id_anestp) {
		setAttrVal("Id_anestp", Id_anestp);
	}
	/**
	 * 麻醉方法编码
	 * @return
	 */
	public String getSd_anestp() {
		return ((String) getAttrVal("Sd_anestp"));
	}	
	public void setSd_anestp(String Sd_anestp) {
		setAttrVal("Sd_anestp", Sd_anestp);
	}
	/**
	 * 麻醉方法名称
	 * @return
	 */
	public String getName_anestp() {
		return ((String) getAttrVal("Name_anestp"));
	}	
	public void setName_anestp(String Name_anestp) {
		setAttrVal("Name_anestp", Name_anestp);
	}
	/**
	 * 药物过敏标识
	 * @return
	 */
	public FBoolean getFg_allergy() {
		return ((FBoolean) getAttrVal("Fg_allergy"));
	}	
	public void setFg_allergy(FBoolean Fg_allergy) {
		setAttrVal("Fg_allergy", Fg_allergy);
	}
	/**
	 * 冰冻病理标识
	 * @return
	 */
	public FBoolean getFg_patho() {
		return ((FBoolean) getAttrVal("Fg_patho"));
	}	
	public void setFg_patho(FBoolean Fg_patho) {
		setAttrVal("Fg_patho", Fg_patho);
	}
	/**
	 * 手术申请状态
	 * @return
	 */
	public String getId_su_op() {
		return ((String) getAttrVal("Id_su_op"));
	}	
	public void setId_su_op(String Id_su_op) {
		setAttrVal("Id_su_op", Id_su_op);
	}
	/**
	 * 手术申请状态编码
	 * @return
	 */
	public String getSd_su_op() {
		return ((String) getAttrVal("Sd_su_op"));
	}	
	public void setSd_su_op(String Sd_su_op) {
		setAttrVal("Sd_su_op", Sd_su_op);
	}
	/**
	 * 手术申请状态名称
	 * @return
	 */
	public String getName_su_op() {
		return ((String) getAttrVal("Name_su_op"));
	}	
	public void setName_su_op(String Name_su_op) {
		setAttrVal("Name_su_op", Name_su_op);
	}
	/**
	 * 注意事项
	 * @return
	 */
	public String getAnnouncements() {
		return ((String) getAttrVal("Announcements"));
	}	
	public void setAnnouncements(String Announcements) {
		setAttrVal("Announcements", Announcements);
	}
	/**
	 * 预期输血量
	 * @return
	 */
	public FDouble getQuan_bt_paln() {
		return ((FDouble) getAttrVal("Quan_bt_paln"));
	}	
	public void setQuan_bt_paln(FDouble Quan_bt_paln) {
		setAttrVal("Quan_bt_paln", Quan_bt_paln);
	}
	/**
	 * 主刀医生
	 * @return
	 */
	public String getId_emp_operate() {
		return ((String) getAttrVal("Id_emp_operate"));
	}	
	public void setId_emp_operate(String Id_emp_operate) {
		setAttrVal("Id_emp_operate", Id_emp_operate);
	}
	/**
	 * 主刀医生编码
	 * @return
	 */
	public String getSd_emp_operate() {
		return ((String) getAttrVal("Sd_emp_operate"));
	}	
	public void setSd_emp_operate(String Sd_emp_operate) {
		setAttrVal("Sd_emp_operate", Sd_emp_operate);
	}
	/**
	 * 主刀医生名称
	 * @return
	 */
	public String getName_emp_operate() {
		return ((String) getAttrVal("Name_emp_operate"));
	}	
	public void setName_emp_operate(String Name_emp_operate) {
		setAttrVal("Name_emp_operate", Name_emp_operate);
	}
	/**
	 * 第一助手
	 * @return
	 */
	public String getId_emp_helper() {
		return ((String) getAttrVal("Id_emp_helper"));
	}	
	public void setId_emp_helper(String Id_emp_helper) {
		setAttrVal("Id_emp_helper", Id_emp_helper);
	}
	/**
	 * 第一助手编码
	 * @return
	 */
	public String getSd_emp_helper() {
		return ((String) getAttrVal("Sd_emp_helper"));
	}	
	public void setSd_emp_helper(String Sd_emp_helper) {
		setAttrVal("Sd_emp_helper", Sd_emp_helper);
	}
	/**
	 * 第一助手名称
	 * @return
	 */
	public String getName_emp_helper() {
		return ((String) getAttrVal("Name_emp_helper"));
	}	
	public void setName_emp_helper(String Name_emp_helper) {
		setAttrVal("Name_emp_helper", Name_emp_helper);
	}
	/**
	 * 体位id
	 * @return
	 */
	public String getId_sugbody() {
		return ((String) getAttrVal("Id_sugbody"));
	}	
	public void setId_sugbody(String Id_sugbody) {
		setAttrVal("Id_sugbody", Id_sugbody);
	}
	/**
	 * 体位编码
	 * @return
	 */
	public String getSd_sugbody() {
		return ((String) getAttrVal("Sd_sugbody"));
	}	
	public void setSd_sugbody(String Sd_sugbody) {
		setAttrVal("Sd_sugbody", Sd_sugbody);
	}
	/**
	 * 体位名称
	 * @return
	 */
	public String getName_sugbody() {
		return ((String) getAttrVal("Name_sugbody"));
	}	
	public void setName_sugbody(String Name_sugbody) {
		setAttrVal("Name_sugbody", Name_sugbody);
	}
	/**
	 * 特殊用物
	 * @return
	 */
	public String getSpecialreq() {
		return ((String) getAttrVal("Specialreq"));
	}	
	public void setSpecialreq(String Specialreq) {
		setAttrVal("Specialreq", Specialreq);
	}
	/**
	 * 特殊仪器
	 * @return
	 */
	public String getSpecialinstrument() {
		return ((String) getAttrVal("Specialinstrument"));
	}	
	public void setSpecialinstrument(String Specialinstrument) {
		setAttrVal("Specialinstrument", Specialinstrument);
	}
	/**
	 * 特殊准备
	 * @return
	 */
	public String getSpecialdes() {
		return ((String) getAttrVal("Specialdes"));
	}	
	public void setSpecialdes(String Specialdes) {
		setAttrVal("Specialdes", Specialdes);
	}
	/**
	 * 是否新开手术
	 * @return
	 */
	public FBoolean getFg_new_sug() {
		return ((FBoolean) getAttrVal("Fg_new_sug"));
	}	
	public void setFg_new_sug(FBoolean Fg_new_sug) {
		setAttrVal("Fg_new_sug", Fg_new_sug);
	}
	/**
	 * 日间手术
	 * @return
	 */
	public FBoolean getFg_daysug() {
		return ((FBoolean) getAttrVal("Fg_daysug"));
	}	
	public void setFg_daysug(FBoolean Fg_daysug) {
		setAttrVal("Fg_daysug", Fg_daysug);
	}
	/**
	 * 手术时限（急症手术）
	 * @return
	 */
	public FBoolean getFg_er_sug() {
		return ((FBoolean) getAttrVal("Fg_er_sug"));
	}	
	public void setFg_er_sug(FBoolean Fg_er_sug) {
		setAttrVal("Fg_er_sug", Fg_er_sug);
	}
	/**
	 * 手术时限（限期手术）
	 * @return
	 */
	public FBoolean getFg_xq_sug() {
		return ((FBoolean) getAttrVal("Fg_xq_sug"));
	}	
	public void setFg_xq_sug(FBoolean Fg_xq_sug) {
		setAttrVal("Fg_xq_sug", Fg_xq_sug);
	}
	/**
	 * 手术时限（择期手术）
	 * @return
	 */
	public FBoolean getFg_zq_sug() {
		return ((FBoolean) getAttrVal("Fg_zq_sug"));
	}	
	public void setFg_zq_sug(FBoolean Fg_zq_sug) {
		setAttrVal("Fg_zq_sug", Fg_zq_sug);
	}
}
