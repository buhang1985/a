package iih.pis.ivx.pisivxcurriculum.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 微信培训课程表 DTO数据 
 * 
 */
public class PisivxCurriculumDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 培训课题标识
	 * @return String
	 */
	public String getId_net_trainmgr_crs() {
		return ((String) getAttrVal("Id_net_trainmgr_crs"));
	}
	/**
	 * 培训课题标识
	 * @param Id_net_trainmgr_crs
	 */
	public void setId_net_trainmgr_crs(String Id_net_trainmgr_crs) {
		setAttrVal("Id_net_trainmgr_crs", Id_net_trainmgr_crs);
	}
	/**
	 * 课程分类标识
	 * @return String
	 */
	public String getId_net_crs_ca() {
		return ((String) getAttrVal("Id_net_crs_ca"));
	}
	/**
	 * 课程分类标识
	 * @param Id_net_crs_ca
	 */
	public void setId_net_crs_ca(String Id_net_crs_ca) {
		setAttrVal("Id_net_crs_ca", Id_net_crs_ca);
	}
	/**
	 * 课程分类
	 * @return String
	 */
	public String getName_ca() {
		return ((String) getAttrVal("Name_ca"));
	}
	/**
	 * 课程分类
	 * @param Name_ca
	 */
	public void setName_ca(String Name_ca) {
		setAttrVal("Name_ca", Name_ca);
	}
	/**
	 * 课程标识
	 * @return String
	 */
	public String getId_net_crs() {
		return ((String) getAttrVal("Id_net_crs"));
	}
	/**
	 * 课程标识
	 * @param Id_net_crs
	 */
	public void setId_net_crs(String Id_net_crs) {
		setAttrVal("Id_net_crs", Id_net_crs);
	}
	/**
	 * 课程名称
	 * @return String
	 */
	public String getName_crs() {
		return ((String) getAttrVal("Name_crs"));
	}
	/**
	 * 课程名称
	 * @param Name_crs
	 */
	public void setName_crs(String Name_crs) {
		setAttrVal("Name_crs", Name_crs);
	}
	/**
	 * 课题
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 课题
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 课程内容
	 * @return String
	 */
	public String getContent() {
		return ((String) getAttrVal("Content"));
	}
	/**
	 * 课程内容
	 * @param Content
	 */
	public void setContent(String Content) {
		setAttrVal("Content", Content);
	}
	/**
	 * 讲师
	 * @return String
	 */
	public String getLecturer() {
		return ((String) getAttrVal("Lecturer"));
	}
	/**
	 * 讲师
	 * @param Lecturer
	 */
	public void setLecturer(String Lecturer) {
		setAttrVal("Lecturer", Lecturer);
	}
	/**
	 * 时长
	 * @return FDouble
	 */
	public FDouble getDurtime() {
		return ((FDouble) getAttrVal("Durtime"));
	}
	/**
	 * 时长
	 * @param Durtime
	 */
	public void setDurtime(FDouble Durtime) {
		setAttrVal("Durtime", Durtime);
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
	 * 培训安排
	 * @return String
	 */
	public String getId_net_trainmgr() {
		return ((String) getAttrVal("Id_net_trainmgr"));
	}
	/**
	 * 培训安排
	 * @param Id_net_trainmgr
	 */
	public void setId_net_trainmgr(String Id_net_trainmgr) {
		setAttrVal("Id_net_trainmgr", Id_net_trainmgr);
	}
	/**
	 * 开始时间
	 * @return String
	 */
	public String getDt_begin() {
		return ((String) getAttrVal("Dt_begin"));
	}
	/**
	 * 开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(String Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 结束时间
	 * @return String
	 */
	public String getDt_end() {
		return ((String) getAttrVal("Dt_end"));
	}
	/**
	 * 结束时间
	 * @param Dt_end
	 */
	public void setDt_end(String Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 入场二维码
	 * @return String
	 */
	public String getQr_code() {
		return ((String) getAttrVal("Qr_code"));
	}
	/**
	 * 入场二维码
	 * @param Qr_code
	 */
	public void setQr_code(String Qr_code) {
		setAttrVal("Qr_code", Qr_code);
	}
	/**
	 * 面向人群
	 * @return String
	 */
	public String getForcrowd() {
		return ((String) getAttrVal("Forcrowd"));
	}
	/**
	 * 面向人群
	 * @param Forcrowd
	 */
	public void setForcrowd(String Forcrowd) {
		setAttrVal("Forcrowd", Forcrowd);
	}
	/**
	 * 结束标识
	 * @return String
	 */
	public String getFg_end() {
		return ((String) getAttrVal("Fg_end"));
	}
	/**
	 * 结束标识
	 * @param Fg_end
	 */
	public void setFg_end(String Fg_end) {
		setAttrVal("Fg_end", Fg_end);
	}
	/**
	 * 培训地点
	 * @return String
	 */
	public String getPlace() {
		return ((String) getAttrVal("Place"));
	}
	/**
	 * 培训地点
	 * @param Place
	 */
	public void setPlace(String Place) {
		setAttrVal("Place", Place);
	}
}