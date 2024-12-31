package iih.mc.itf.ws.d;

/**
 * 根据耗材唯一码查询医疗服务主键参数DTO
 * 
 * @author hao_wu 2018-11-23
 *
 */
public class FindSrvIdByBarCodeParamDTO {

	/**
	 * 耗材唯一码
	 */
	private String onlyCode;

	/**
	 * 获取耗材唯一码
	 * 
	 * @return
	 */
	public String getOnlyCode() {
		return onlyCode;
	}

	/**
	 * 设置耗材唯一码
	 * 
	 * @param onlyCode
	 */
	public void setOnlyCode(String onlyCode) {
		this.onlyCode = onlyCode;
	}
}
