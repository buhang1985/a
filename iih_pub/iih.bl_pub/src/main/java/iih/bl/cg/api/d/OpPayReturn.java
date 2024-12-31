package iih.bl.cg.api.d;

/**
 * 类说明：门诊患者缴费接口返回值
 * 
 * @author 作者 :Liwq
 * @author yankan
 * @version 创建时间：2017年5月22日 下午5:00:19 * Company: Copyright 2017 by PKU
 *          healthcare IT Co.,Ltd.
 */
public class OpPayReturn {

	/**
	 * 成功返回0，失败返回1
	 */
	private String resultCode;
	/**
	 * 返回具体错误
	 */
	private String resultMsg;
	/**
	 * 发药窗口
	 */
	private String dispenseWindow;
	
	private String code_st;
	/**
	 * 记账id 挂号收费需要返回
	 */
	private String[] id_cgoep;
	/**
	 * 成功返回0，失败返回1
	 * 
	 * @return
	 */
	public String getResultCode() {
		return resultCode;
	}

	/**
	 * 成功返回0，失败返回1
	 * 
	 * @param code
	 */
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	/**
	 * 结算
	 * 
	 * @return
	 */
	public String getCodeSt() {
		return code_st;
	}

	/**
	 * 结算号
	 * 
	 * @param code_st
	 */
	public void setCodeSt(String code_st) {
		this.code_st = code_st;
	}
	/**
	 * 返回错误信息 
	 * 场景1，需付费处方不存在应返回错误信息：病人无交费记录！
	 * 场景2，支付金额错误应返回错误信息：输入金额错误！
	 * 场景3，第三方支付订单号重复应返回错误信息：该订单号无效！ 
	 * 场景4，成功缴费应返回信息：操作成功！
	 * 
	 * @return
	 */
	public String getResultMsg() {
		return resultMsg;
	}

	/**
	 * 返回错误信息 
	 * 场景1，需付费处方不存在应返回错误信息：病人无交费记录！ 
	 * 场景2，支付金额错误应返回错误信息：输入金额错误！
	 * 场景3，第三方支付订单号重复应返回错误信息：该订单号无效！ 
	 * 场景4，成功缴费应返回信息：操作成功！
	 * 
	 * @param result
	 */
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	/**
	 * 发药窗口
	 * 
	 * @return
	 */
	public String getDispenseWindow() {
		return dispenseWindow;
	}

	/**
	 * 发药窗口
	 * 
	 * @param dispenseWindow
	 */
	public void setDispenseWindow(String dispenseWindow) {
		this.dispenseWindow = dispenseWindow;
	}
	/**
	 * 获取记账id集合
	 * @return the id_cgoep
	 */
	public String[] getIdCgOepArray() {
		return id_cgoep;
	}
	/**
	 * 设置记账id集合
	 * @param id_cgoep the id_cgoep to set
	 */
	public void setIdCgOepArray(String[] id_cgoep) {
		this.id_cgoep = id_cgoep;
	}
}
