package iih.pis.ivx.dto.pisivxnoticedto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 微信服务-通知DTO DTO数据 
 * 
 */
public class PisivxNoticeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 微信通知主键标识
	 * @return String
	 */
	public String getId_pisivxnotice() {
		return ((String) getAttrVal("Id_pisivxnotice"));
	}
	/**
	 * 微信通知主键标识
	 * @param Id_pisivxnotice
	 */
	public void setId_pisivxnotice(String Id_pisivxnotice) {
		setAttrVal("Id_pisivxnotice", Id_pisivxnotice);
	}
	/**
	 * 微信服务通知类型ID
	 * @return String
	 */
	public String getId_noticeswitch() {
		return ((String) getAttrVal("Id_noticeswitch"));
	}
	/**
	 * 微信服务通知类型ID
	 * @param Id_noticeswitch
	 */
	public void setId_noticeswitch(String Id_noticeswitch) {
		setAttrVal("Id_noticeswitch", Id_noticeswitch);
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
	 * 患者编码
	 * @return String
	 */
	public String getPatcode() {
		return ((String) getAttrVal("Patcode"));
	}
	/**
	 * 患者编码
	 * @param Patcode
	 */
	public void setPatcode(String Patcode) {
		setAttrVal("Patcode", Patcode);
	}
	/**
	 * 通知内容
	 * @return String
	 */
	public String getNotice() {
		return ((String) getAttrVal("Notice"));
	}
	/**
	 * 通知内容
	 * @param Notice
	 */
	public void setNotice(String Notice) {
		setAttrVal("Notice", Notice);
	}
	/**
	 * 通知时间
	 * @return FDateTime
	 */
	public FDateTime getTm_notice() {
		return ((FDateTime) getAttrVal("Tm_notice"));
	}
	/**
	 * 通知时间
	 * @param Tm_notice
	 */
	public void setTm_notice(FDateTime Tm_notice) {
		setAttrVal("Tm_notice", Tm_notice);
	}
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊编码
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 就诊次数
	 * @return Integer
	 */
	public Integer getTimes() {
		return ((Integer) getAttrVal("Times"));
	}
	/**
	 * 就诊次数
	 * @param Times
	 */
	public void setTimes(Integer Times) {
		setAttrVal("Times", Times);
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
	 * 就诊卡号
	 * @return String
	 */
	public String getCardcode() {
		return ((String) getAttrVal("Cardcode"));
	}
	/**
	 * 就诊卡号
	 * @param Cardcode
	 */
	public void setCardcode(String Cardcode) {
		setAttrVal("Cardcode", Cardcode);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getIpcode() {
		return ((String) getAttrVal("Ipcode"));
	}
	/**
	 * 住院号
	 * @param Ipcode
	 */
	public void setIpcode(String Ipcode) {
		setAttrVal("Ipcode", Ipcode);
	}
	/**
	 * 微信ID
	 * @return String
	 */
	public String getOpenid() {
		return ((String) getAttrVal("Openid"));
	}
	/**
	 * 微信ID
	 * @param Openid
	 */
	public void setOpenid(String Openid) {
		setAttrVal("Openid", Openid);
	}
	/**
	 * 通知类型名称
	 * @return String
	 */
	public String getName_notice() {
		return ((String) getAttrVal("Name_notice"));
	}
	/**
	 * 通知类型名称
	 * @param Name_notice
	 */
	public void setName_notice(String Name_notice) {
		setAttrVal("Name_notice", Name_notice);
	}
	/**
	 * 通知模板ID
	 * @return String
	 */
	public String getTemplate_id() {
		return ((String) getAttrVal("Template_id"));
	}
	/**
	 * 通知模板ID
	 * @param Template_id
	 */
	public void setTemplate_id(String Template_id) {
		setAttrVal("Template_id", Template_id);
	}
	/**
	 * url地址
	 * @return String
	 */
	public String getUrl() {
		return ((String) getAttrVal("Url"));
	}
	/**
	 * url地址
	 * @param Url
	 */
	public void setUrl(String Url) {
		setAttrVal("Url", Url);
	}
}