package iih.en.pv.outpatient.dto.d;
/**
 * 分诊结果DTO
 * @author yank
 *
 */
public class ArriveResultBean {
	// 分诊位置
	private String siteName;
	// 返回值 0正常 1出错
	private String code;
	// 错误信息
	private String errMsg;

	/**
	 * 获取标志
	 * 
	 * @return
	 */
	public String getSiteName() {
		return siteName;
	}

	/**
	 * 设置标志
	 * 
	 * @param flag
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	/**
	 * 获取消息
	 * 
	 * @return
	 */
	public String getErrMsg() {
		return errMsg;
	}

	/**
	 * 设置消息
	 * 
	 * @param errorMsg
	 */
	public void setErrMsg(String errorMsg) {
		this.errMsg = errorMsg;
	}

	/**
	 * 返回值
	 * 
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 返回值
	 * 
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}
		
}
