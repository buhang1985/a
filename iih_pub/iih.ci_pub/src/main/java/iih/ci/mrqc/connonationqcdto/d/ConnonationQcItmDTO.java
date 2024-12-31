package iih.ci.mrqc.connonationqcdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 内涵质控项目DTO DTO数据 
 * 
 */
public class ConnonationQcItmDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 内涵质控项目主键
	 * @return String
	 */
	public String getId_conno_req_item() {
		return ((String) getAttrVal("Id_conno_req_item"));
	}
	/**
	 * 内涵质控项目主键
	 * @param Id_conno_req_item
	 */
	public void setId_conno_req_item(String Id_conno_req_item) {
		setAttrVal("Id_conno_req_item", Id_conno_req_item);
	}
	/**
	 * 是否单否项
	 * @return FBoolean
	 */
	public FBoolean getFg_none() {
		return ((FBoolean) getAttrVal("Fg_none"));
	}
	/**
	 * 是否单否项
	 * @param Fg_none
	 */
	public void setFg_none(FBoolean Fg_none) {
		setAttrVal("Fg_none", Fg_none);
	}
	/**
	 * 项目印象评价主键
	 * @return String
	 */
	public String getId_req_assess() {
		return ((String) getAttrVal("Id_req_assess"));
	}
	/**
	 * 项目印象评价主键
	 * @param Id_req_assess
	 */
	public void setId_req_assess(String Id_req_assess) {
		setAttrVal("Id_req_assess", Id_req_assess);
	}
	/**
	 * 项目印象评价code
	 * @return String
	 */
	public String getSd_req_assess() {
		return ((String) getAttrVal("Sd_req_assess"));
	}
	/**
	 * 项目印象评价code
	 * @param Sd_req_assess
	 */
	public void setSd_req_assess(String Sd_req_assess) {
		setAttrVal("Sd_req_assess", Sd_req_assess);
	}
	/**
	 * 项目印象评价
	 * @return String
	 */
	public String getName_req_assess() {
		return ((String) getAttrVal("Name_req_assess"));
	}
	/**
	 * 项目印象评价
	 * @param Name_req_assess
	 */
	public void setName_req_assess(String Name_req_assess) {
		setAttrVal("Name_req_assess", Name_req_assess);
	}
	/**
	 * 质控项目
	 * @return String
	 */
	public String getReq_conno() {
		return ((String) getAttrVal("Req_conno"));
	}
	/**
	 * 质控项目
	 * @param Req_conno
	 */
	public void setReq_conno(String Req_conno) {
		setAttrVal("Req_conno", Req_conno);
	}
	/**
	 * 质控项目要求
	 * @return String
	 */
	public String getReq_conno_txt() {
		return ((String) getAttrVal("Req_conno_txt"));
	}
	/**
	 * 质控项目要求
	 * @param Req_conno_txt
	 */
	public void setReq_conno_txt(String Req_conno_txt) {
		setAttrVal("Req_conno_txt", Req_conno_txt);
	}
	/**
	 * 总体印象评价主键
	 * @return String
	 */
	public String getId_total_assess() {
		return ((String) getAttrVal("Id_total_assess"));
	}
	/**
	 * 总体印象评价主键
	 * @param Id_total_assess
	 */
	public void setId_total_assess(String Id_total_assess) {
		setAttrVal("Id_total_assess", Id_total_assess);
	}
	/**
	 * 总体印象评价code
	 * @return String
	 */
	public String getSd_total_assess() {
		return ((String) getAttrVal("Sd_total_assess"));
	}
	/**
	 * 总体印象评价code
	 * @param Sd_total_assess
	 */
	public void setSd_total_assess(String Sd_total_assess) {
		setAttrVal("Sd_total_assess", Sd_total_assess);
	}
	/**
	 * 总体印象评价
	 * @return String
	 */
	public String getName_total_assess() {
		return ((String) getAttrVal("Name_total_assess"));
	}
	/**
	 * 总体印象评价
	 * @param Name_total_assess
	 */
	public void setName_total_assess(String Name_total_assess) {
		setAttrVal("Name_total_assess", Name_total_assess);
	}
	/**
	 * 是否推荐
	 * @return FBoolean
	 */
	public FBoolean getFg_recommend() {
		return ((FBoolean) getAttrVal("Fg_recommend"));
	}
	/**
	 * 是否推荐
	 * @param Fg_recommend
	 */
	public void setFg_recommend(FBoolean Fg_recommend) {
		setAttrVal("Fg_recommend", Fg_recommend);
	}
	/**
	 * 优点评价
	 * @return String
	 */
	public String getDes_recommend() {
		return ((String) getAttrVal("Des_recommend"));
	}
	/**
	 * 优点评价
	 * @param Des_recommend
	 */
	public void setDes_recommend(String Des_recommend) {
		setAttrVal("Des_recommend", Des_recommend);
	}
	/**
	 * 问题评价
	 * @return String
	 */
	public String getDes_problem() {
		return ((String) getAttrVal("Des_problem"));
	}
	/**
	 * 问题评价
	 * @param Des_problem
	 */
	public void setDes_problem(String Des_problem) {
		setAttrVal("Des_problem", Des_problem);
	}
}