package iih.pis.phk.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 预约取号返回的dto DTO数据 
 * 
 */
public class PisPhkRegResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 预约ID
	 * @return String
	 */
	public String getId_apt() {
		return ((String) getAttrVal("Id_apt"));
	}
	/**
	 * 预约ID
	 * @param Id_apt
	 */
	public void setId_apt(String Id_apt) {
		setAttrVal("Id_apt", Id_apt);
	}
	/**
	 * 就诊顺序号
	 * @return String
	 */
	public String getSequencenumber() {
		return ((String) getAttrVal("Sequencenumber"));
	}
	/**
	 * 就诊顺序号
	 * @param Sequencenumber
	 */
	public void setSequencenumber(String Sequencenumber) {
		setAttrVal("Sequencenumber", Sequencenumber);
	}
	/**
	 * 就诊次数
	 * @return String
	 */
	public String getTimes() {
		return ((String) getAttrVal("Times"));
	}
	/**
	 * 就诊次数
	 * @param Times
	 */
	public void setTimes(String Times) {
		setAttrVal("Times", Times);
	}
	/**
	 * 建议就诊时间
	 * @return String
	 */
	public String getVisitingtime() {
		return ((String) getAttrVal("Visitingtime"));
	}
	/**
	 * 建议就诊时间
	 * @param Visitingtime
	 */
	public void setVisitingtime(String Visitingtime) {
		setAttrVal("Visitingtime", Visitingtime);
	}
	/**
	 * 建议就诊时间差
	 * @return Integer
	 */
	public Integer getSuggestexmint() {
		return ((Integer) getAttrVal("Suggestexmint"));
	}
	/**
	 * 建议就诊时间差
	 * @param Suggestexmint
	 */
	public void setSuggestexmint(Integer Suggestexmint) {
		setAttrVal("Suggestexmint", Suggestexmint);
	}
	/**
	 * 就诊日期
	 * @return String
	 */
	public String getEntdate() {
		return ((String) getAttrVal("Entdate"));
	}
	/**
	 * 就诊日期
	 * @param Entdate
	 */
	public void setEntdate(String Entdate) {
		setAttrVal("Entdate", Entdate);
	}
	/**
	 * 门诊地点
	 * @return String
	 */
	public String getPlaceofvisit() {
		return ((String) getAttrVal("Placeofvisit"));
	}
	/**
	 * 门诊地点
	 * @param Placeofvisit
	 */
	public void setPlaceofvisit(String Placeofvisit) {
		setAttrVal("Placeofvisit", Placeofvisit);
	}
	/**
	 * 挂号是否成功标志及失败信息
	 * @return String
	 */
	public String getRegmsg() {
		return ((String) getAttrVal("Regmsg"));
	}
	/**
	 * 挂号是否成功标志及失败信息
	 * @param Regmsg
	 */
	public void setRegmsg(String Regmsg) {
		setAttrVal("Regmsg", Regmsg);
	}
}