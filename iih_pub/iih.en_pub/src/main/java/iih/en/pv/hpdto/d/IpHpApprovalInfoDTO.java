package iih.en.pv.hpdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医保审批信息 DTO数据 
 * 
 */
public class IpHpApprovalInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 卡号
	 * @return String
	 */
	public String getCard() {
		return ((String) getAttrVal("Card"));
	}
	/**
	 * 卡号
	 * @param Card
	 */
	public void setCard(String Card) {
		setAttrVal("Card", Card);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 开始时间
	 * @return FDate
	 */
	public FDate getDt_b() {
		return ((FDate) getAttrVal("Dt_b"));
	}
	/**
	 * 开始时间
	 * @param Dt_b
	 */
	public void setDt_b(FDate Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 结束时间
	 * @return FDate
	 */
	public FDate getDt_e() {
		return ((FDate) getAttrVal("Dt_e"));
	}
	/**
	 * 结束时间
	 * @param Dt_e
	 */
	public void setDt_e(FDate Dt_e) {
		setAttrVal("Dt_e", Dt_e);
	}
	/**
	 * 参合地统筹区编号
	 * @return String
	 */
	public String getChregioncode() {
		return ((String) getAttrVal("Chregioncode"));
	}
	/**
	 * 参合地统筹区编号
	 * @param Chregioncode
	 */
	public void setChregioncode(String Chregioncode) {
		setAttrVal("Chregioncode", Chregioncode);
	}
	/**
	 * 参合地统筹区
	 * @return String
	 */
	public String getChregionname() {
		return ((String) getAttrVal("Chregionname"));
	}
	/**
	 * 参合地统筹区
	 * @param Chregionname
	 */
	public void setChregionname(String Chregionname) {
		setAttrVal("Chregionname", Chregionname);
	}
	/**
	 * 就医地统筹区编码
	 * @return String
	 */
	public String getJyregioncode() {
		return ((String) getAttrVal("Jyregioncode"));
	}
	/**
	 * 就医地统筹区编码
	 * @param Jyregioncode
	 */
	public void setJyregioncode(String Jyregioncode) {
		setAttrVal("Jyregioncode", Jyregioncode);
	}
	/**
	 * 就医地统筹区
	 * @return String
	 */
	public String getJyregionname() {
		return ((String) getAttrVal("Jyregionname"));
	}
	/**
	 * 就医地统筹区
	 * @param Jyregionname
	 */
	public void setJyregionname(String Jyregionname) {
		setAttrVal("Jyregionname", Jyregionname);
	}
}