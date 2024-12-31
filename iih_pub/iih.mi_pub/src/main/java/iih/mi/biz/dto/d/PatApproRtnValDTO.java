package iih.mi.biz.dto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDateTime;

/**
 * 患者审批信息 DTO数据 
 * 
 */
public class PatApproRtnValDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPatname() {
		return ((String) getAttrVal("Patname"));
	}
	/**
	 * 患者姓名
	 * @param Patname
	 */
	public void setPatname(String Patname) {
		setAttrVal("Patname", Patname);
	}
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}
	/**
	 * 开始时间
	 * @param Dt_b
	 */
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 结束日期
	 * @return FDateTime
	 */
	public FDateTime getDt_e() {
		return ((FDateTime) getAttrVal("Dt_e"));
	}
	/**
	 * 结束日期
	 * @param Dt_e
	 */
	public void setDt_e(FDateTime Dt_e) {
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
	 * 就医地统筹编码
	 * @return String
	 */
	public String getJyregioncode() {
		return ((String) getAttrVal("Jyregioncode"));
	}
	/**
	 * 就医地统筹编码
	 * @param Jyregioncode
	 */
	public void setJyregioncode(String Jyregioncode) {
		setAttrVal("Jyregioncode", Jyregioncode);
	}
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
	 * 审批编号
	 * @return String
	 */
	public String getApplycode() {
		return ((String) getAttrVal("Applycode"));
	}
	/**
	 * 审批编号
	 * @param Applycode
	 */
	public void setApplycode(String Applycode) {
		setAttrVal("Applycode", Applycode);
	}
	/**
	 * 项目编号
	 * @return String
	 */
	public String getProjectcode() {
		return ((String) getAttrVal("Projectcode"));
	}
	/**
	 * 项目编号
	 * @param Projectcode
	 */
	public void setProjectcode(String Projectcode) {
		setAttrVal("Projectcode", Projectcode);
	}
	/**
	 * 项目名称
	 * @return String
	 */
	public String getProjectname() {
		return ((String) getAttrVal("Projectname"));
	}
	/**
	 * 项目名称
	 * @param Projectname
	 */
	public void setProjectname(String Projectname) {
		setAttrVal("Projectname", Projectname);
	}
	/**
	 * 审批集合
	 * @return FArrayList
	 */
	public FArrayList getApparrays() {
		return ((FArrayList) getAttrVal("Apparrays"));
	}
	/**
	 * 审批集合
	 * @param Apparrays
	 */
	public void setApparrays(FArrayList Apparrays) {
		setAttrVal("Apparrays", Apparrays);
	}
}