package iih.bl.hp.insurecard.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 北京医保卡信息 DTO数据 
 * 
 */
public class CardPersonInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 社保卡卡号
	 * @return String
	 */
	public String getCard_code() {
		return ((String) getAttrVal("Card_code"));
	}
	/**
	 * 社保卡卡号
	 * @param Card_code
	 */
	public void setCard_code(String Card_code) {
		setAttrVal("Card_code", Card_code);
	}
	/**
	 * 医保应用号
	 * @return String
	 */
	public String getIc_code() {
		return ((String) getAttrVal("Ic_code"));
	}
	/**
	 * 医保应用号
	 * @param Ic_code
	 */
	public void setIc_code(String Ic_code) {
		setAttrVal("Ic_code", Ic_code);
	}
	/**
	 * 公民身份号码
	 * @return String
	 */
	public String getId_no() {
		return ((String) getAttrVal("Id_no"));
	}
	/**
	 * 公民身份号码
	 * @param Id_no
	 */
	public void setId_no(String Id_no) {
		setAttrVal("Id_no", Id_no);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getPersonname() {
		return ((String) getAttrVal("Personname"));
	}
	/**
	 * 姓名
	 * @param Personname
	 */
	public void setPersonname(String Personname) {
		setAttrVal("Personname", Personname);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getSex() {
		return ((String) getAttrVal("Sex"));
	}
	/**
	 * 性别
	 * @param Sex
	 */
	public void setSex(String Sex) {
		setAttrVal("Sex", Sex);
	}
	/**
	 * 出生日期
	 * @return FDateTime
	 */
	public FDateTime getBirthday() {
		return ((FDateTime) getAttrVal("Birthday"));
	}
	/**
	 * 出生日期
	 * @param Birthday
	 */
	public void setBirthday(FDateTime Birthday) {
		setAttrVal("Birthday", Birthday);
	}
	/**
	 * 转诊医院编码
	 * @return String
	 */
	public String getFromhosp() {
		return ((String) getAttrVal("Fromhosp"));
	}
	/**
	 * 转诊医院编码
	 * @param Fromhosp
	 */
	public void setFromhosp(String Fromhosp) {
		setAttrVal("Fromhosp", Fromhosp);
	}
	/**
	 * 转诊时限
	 * @return String
	 */
	public String getFromhospdate() {
		return ((String) getAttrVal("Fromhospdate"));
	}
	/**
	 * 转诊时限
	 * @param Fromhospdate
	 */
	public void setFromhospdate(String Fromhospdate) {
		setAttrVal("Fromhospdate", Fromhospdate);
	}
	/**
	 * 险种类型:老少,居民,职工,公疗
	 * @return String
	 */
	public String getFundtype() {
		return ((String) getAttrVal("Fundtype"));
	}
	/**
	 * 险种类型:老少,居民,职工,公疗
	 * @param Fundtype
	 */
	public void setFundtype(String Fundtype) {
		setAttrVal("Fundtype", Fundtype);
	}
	/**
	 * 险种类型编号
	 * @return String
	 */
	public String getId_fundtype() {
		return ((String) getAttrVal("Id_fundtype"));
	}
	/**
	 * 险种类型编号
	 * @param Id_fundtype
	 */
	public void setId_fundtype(String Id_fundtype) {
		setAttrVal("Id_fundtype", Id_fundtype);
	}
	/**
	 * 预提人员标示
	 * @return String
	 */
	public String getIsyt() {
		return ((String) getAttrVal("Isyt"));
	}
	/**
	 * 预提人员标示
	 * @param Isyt
	 */
	public void setIsyt(String Isyt) {
		setAttrVal("Isyt", Isyt);
	}
	/**
	 * 军残等级
	 * @return String
	 */
	public String getJclevel() {
		return ((String) getAttrVal("Jclevel"));
	}
	/**
	 * 军残等级
	 * @param Jclevel
	 */
	public void setJclevel(String Jclevel) {
		setAttrVal("Jclevel", Jclevel);
	}
	/**
	 * 在院标示
	 * @return String
	 */
	public String getHospflag() {
		return ((String) getAttrVal("Hospflag"));
	}
	/**
	 * 在院标示
	 * @param Hospflag
	 */
	public void setHospflag(String Hospflag) {
		setAttrVal("Hospflag", Hospflag);
	}
	/**
	 * 参保人员类别
	 * @return String
	 */
	public String getPersontype() {
		return ((String) getAttrVal("Persontype"));
	}
	/**
	 * 参保人员类别
	 * @param Persontype
	 */
	public void setPersontype(String Persontype) {
		setAttrVal("Persontype", Persontype);
	}
	/**
	 * 医保身份编号
	 * @return String
	 */
	public String getId_persontype() {
		return ((String) getAttrVal("Id_persontype"));
	}
	/**
	 * 医保身份编号
	 * @param Id_persontype
	 */
	public void setId_persontype(String Id_persontype) {
		setAttrVal("Id_persontype", Id_persontype);
	}
	/**
	 * 是否在红名单
	 * @return String
	 */
	public String getIsinredlist() {
		return ((String) getAttrVal("Isinredlist"));
	}
	/**
	 * 是否在红名单
	 * @param Isinredlist
	 */
	public void setIsinredlist(String Isinredlist) {
		setAttrVal("Isinredlist", Isinredlist);
	}
	/**
	 * 本人定点医院状态 0:本地红名单，默认为本人定点医院； 1：是本人定点医院、A类医院、专科医院、中医医院；2：不是本人定点医院 3：转诊
	 * @return String
	 */
	public String getIsspecifiedhosp() {
		return ((String) getAttrVal("Isspecifiedhosp"));
	}
	/**
	 * 本人定点医院状态 0:本地红名单，默认为本人定点医院； 1：是本人定点医院、A类医院、专科医院、中医医院；2：不是本人定点医院 3：转诊
	 * @param Isspecifiedhosp
	 */
	public void setIsspecifiedhosp(String Isspecifiedhosp) {
		setAttrVal("Isspecifiedhosp", Isspecifiedhosp);
	}
	/**
	 * 是否本人慢病定点医院
	 * @return String
	 */
	public String getIschronichosp() {
		return ((String) getAttrVal("Ischronichosp"));
	}
	/**
	 * 是否本人慢病定点医院
	 * @param Ischronichosp
	 */
	public void setIschronichosp(String Ischronichosp) {
		setAttrVal("Ischronichosp", Ischronichosp);
	}
	/**
	 * 个人帐户余额
	 * @return String
	 */
	public String getPersoncount() {
		return ((String) getAttrVal("Personcount"));
	}
	/**
	 * 个人帐户余额
	 * @param Personcount
	 */
	public void setPersoncount(String Personcount) {
		setAttrVal("Personcount", Personcount);
	}
	/**
	 * 慢病编码
	 * @return String
	 */
	public String getChroniccode() {
		return ((String) getAttrVal("Chroniccode"));
	}
	/**
	 * 慢病编码
	 * @param Chroniccode
	 */
	public void setChroniccode(String Chroniccode) {
		setAttrVal("Chroniccode", Chroniccode);
	}
}