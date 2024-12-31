package iih.mp.dg.pharmacysignin.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;

/**
 * 药房签到结果DTO DTO数据 
 * 
 */
public class OpPharmacySignInResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 窗口号
	 * @return String
	 */
	public String getCode_win() {
		return ((String) getAttrVal("Code_win"));
	}
	/**
	 * 窗口号
	 * @param Code_win
	 */
	public void setCode_win(String Code_win) {
		setAttrVal("Code_win", Code_win);
	}
	/**
	 * 顺序号
	 * @return Integer
	 */
	public Integer getNo_sort() {
		return ((Integer) getAttrVal("No_sort"));
	}
	/**
	 * 顺序号
	 * @param No_sort
	 */
	public void setNo_sort(Integer No_sort) {
		setAttrVal("No_sort", No_sort);
	}
	/**
	 * 等待人数
	 * @return Integer
	 */
	public Integer getQuan_wait() {
		return ((Integer) getAttrVal("Quan_wait"));
	}
	/**
	 * 等待人数
	 * @param Quan_wait
	 */
	public void setQuan_wait(Integer Quan_wait) {
		setAttrVal("Quan_wait", Quan_wait);
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
	public String getCode_encard() {
		return ((String) getAttrVal("Code_encard"));
	}
	/**
	 * 就诊卡号
	 * @param Code_encard
	 */
	public void setCode_encard(String Code_encard) {
		setAttrVal("Code_encard", Code_encard);
	}
	/**
	 * 账户余额
	 * @return FDouble
	 */
	public FDouble getAmt_account() {
		return ((FDouble) getAttrVal("Amt_account"));
	}
	/**
	 * 账户余额
	 * @param Amt_account
	 */
	public void setAmt_account(FDouble Amt_account) {
		setAttrVal("Amt_account", Amt_account);
	}
	/**
	 * 花费金额
	 * @return FDouble
	 */
	public FDouble getAmt_cost() {
		return ((FDouble) getAttrVal("Amt_cost"));
	}
	/**
	 * 花费金额
	 * @param Amt_cost
	 */
	public void setAmt_cost(FDouble Amt_cost) {
		setAttrVal("Amt_cost", Amt_cost);
	}
	/**
	 * 已签到标识
	 * @return FBoolean
	 */
	public FBoolean getFg_signin() {
		return ((FBoolean) getAttrVal("Fg_signin"));
	}
	/**
	 * 已签到标识
	 * @param Fg_signin
	 */
	public void setFg_signin(FBoolean Fg_signin) {
		setAttrVal("Fg_signin", Fg_signin);
	}
	/**
	 * 异常主信息
	 * @return String
	 */
	public String getEx_mainmsg() {
		return ((String) getAttrVal("Ex_mainmsg"));
	}
	/**
	 * 异常主信息
	 * @param Ex_mainmsg
	 */
	public void setEx_mainmsg(String Ex_mainmsg) {
		setAttrVal("Ex_mainmsg", Ex_mainmsg);
	}
	/**
	 * 异常明细信息
	 * @return String
	 */
	public String getEx_detailmsg() {
		return ((String) getAttrVal("Ex_detailmsg"));
	}
	/**
	 * 异常明细信息
	 * @param Ex_detailmsg
	 */
	public void setEx_detailmsg(String Ex_detailmsg) {
		setAttrVal("Ex_detailmsg", Ex_detailmsg);
	}
	/**
	 * 窗口主键
	 * @return String
	 */
	public String getId_win() {
		return ((String) getAttrVal("Id_win"));
	}
	/**
	 * 窗口主键
	 * @param Id_win
	 */
	public void setId_win(String Id_win) {
		setAttrVal("Id_win", Id_win);
	}
	/**
	 * 药房名称
	 * @return String
	 */
	public String getPharmname() {
		return ((String) getAttrVal("Pharmname"));
	}
	/**
	 * 药房名称
	 * @param Pharmname
	 */
	public void setPharmname(String Pharmname) {
		setAttrVal("Pharmname", Pharmname);
	}
}