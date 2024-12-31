package iih.mi.device.insurances.ruralcooperinsure;
/**
 * 服务上下文
 * @author LIM
 *
 */
public class InsureServiceContext {
	/**
	 * 新农合平台webservice调用地址
	 */
	protected String url;
	/**
	 * webservice调用用户名
	 */
	protected String userName;
	/**
	 * 密码
	 */
	protected String password;
	/**
	 * 医院编码
	 */
	protected String hospCode;
	/**
	 * 就医地地区编码
	 */
	protected String jyAreaCode;
	/**
	 *  数据来源
	 */
	protected String sourceCode;
	/**
	 * 数据目标
	 */
	protected String targetCode;
	/**
	 * 数据来源类型
	 */
	protected String sourceType;
	/**
	 * 新农合平台webservice调用地址
	 * @return
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 新农合平台webservice调用地址
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * webservice调用用户名
	 * @return
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * webservice调用用户名
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 密码
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 密码
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 医院编码
	 * @return
	 */
	public String getHospCode() {
		return hospCode;
	}
	/**
	 * 医院编码
	 * @param hospCode
	 */
	public void setHospCode(String hospCode) {
		this.hospCode = hospCode;
	}
	/**
	 * 就医地地区编码
	 * @return
	 */
	public String getJyAreaCode() {
		return jyAreaCode;
	}
	/**
	 * 就医地地区编码
	 * @param jyAreaCode
	 */
	public void setJyAreaCode(String jyAreaCode) {
		this.jyAreaCode = jyAreaCode;
	}
	/**
	 * 数据来源
	 * @return
	 */
	public String getSourceCode() {
		return sourceCode;
	}
	/**
	 * 数据来源
	 * @param sourceCode
	 */
	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}
	/**
	 * 数据目标
	 * @return
	 */
	public String getTargetCode() {
		return targetCode;
	}
	/**
	 * 数据目标
	 * @param targetCode
	 */
	public void setTargetCode(String targetCode) {
		this.targetCode = targetCode;
	}
	/**
	 * 数据来源类型
	 * @return
	 */
	public String getSourceType() {
		return sourceType;
	}
	/**
	 * 数据来源类型
	 * @param sourceType
	 */
	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}
}
