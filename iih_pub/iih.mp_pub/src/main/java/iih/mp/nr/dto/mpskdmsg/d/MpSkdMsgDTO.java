package iih.mp.nr.dto.mpskdmsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 护理任务DTO DTO数据 
 * 
 */
public class MpSkdMsgDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 任务消息id
	 * @return String
	 */
	public String getId_skd_msg() {
		return ((String) getAttrVal("Id_skd_msg"));
	}
	/**
	 * 任务消息id
	 * @param Id_skd_msg
	 */
	public void setId_skd_msg(String Id_skd_msg) {
		setAttrVal("Id_skd_msg", Id_skd_msg);
	}
	/**
	 * 患者Id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者Id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者姓名 
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名 
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 事件内容
	 * @return String
	 */
	public String getMsg() {
		return ((String) getAttrVal("Msg"));
	}
	/**
	 * 事件内容
	 * @param Msg
	 */
	public void setMsg(String Msg) {
		setAttrVal("Msg", Msg);
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
	 * 任务参数Id
	 * @return String
	 */
	public String getParam_id() {
		return ((String) getAttrVal("Param_id"));
	}
	/**
	 * 任务参数Id
	 * @param Param_id
	 */
	public void setParam_id(String Param_id) {
		setAttrVal("Param_id", Param_id);
	}
	/**
	 * 功能编码
	 * @return String
	 */
	public String getFun_code() {
		return ((String) getAttrVal("Fun_code"));
	}
	/**
	 * 功能编码
	 * @param Fun_code
	 */
	public void setFun_code(String Fun_code) {
		setAttrVal("Fun_code", Fun_code);
	}
	/**
	 * 功能类名
	 * @return String
	 */
	public String getName_class() {
		return ((String) getAttrVal("Name_class"));
	}
	/**
	 * 功能类名
	 * @param Name_class
	 */
	public void setName_class(String Name_class) {
		setAttrVal("Name_class", Name_class);
	}
	/**
	 * 任务产生源类型
	 * @return String
	 */
	public String getSd_skdtp() {
		return ((String) getAttrVal("Sd_skdtp"));
	}
	/**
	 * 任务产生源类型
	 * @param Sd_skdtp
	 */
	public void setSd_skdtp(String Sd_skdtp) {
		setAttrVal("Sd_skdtp", Sd_skdtp);
	}
	/**
	 * 任务产生源类型sd
	 * @return String
	 */
	public String getId_skdtp() {
		return ((String) getAttrVal("Id_skdtp"));
	}
	/**
	 * 任务产生源类型sd
	 * @param Id_skdtp
	 */
	public void setId_skdtp(String Id_skdtp) {
		setAttrVal("Id_skdtp", Id_skdtp);
	}
	/**
	 * 任务等级id
	 * @return String
	 */
	public String getId_level() {
		return ((String) getAttrVal("Id_level"));
	}
	/**
	 * 任务等级id
	 * @param Id_level
	 */
	public void setId_level(String Id_level) {
		setAttrVal("Id_level", Id_level);
	}
	/**
	 * 任务等级编码
	 * @return String
	 */
	public String getSd_level() {
		return ((String) getAttrVal("Sd_level"));
	}
	/**
	 * 任务等级编码
	 * @param Sd_level
	 */
	public void setSd_level(String Sd_level) {
		setAttrVal("Sd_level", Sd_level);
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
	 * 在院标志
	 * @return String
	 */
	public String getFg_ip() {
		return ((String) getAttrVal("Fg_ip"));
	}
	/**
	 * 在院标志
	 * @param Fg_ip
	 */
	public void setFg_ip(String Fg_ip) {
		setAttrVal("Fg_ip", Fg_ip);
	}
}