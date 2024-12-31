package iih.mp.dg.ws.op.d;

/**
 * 发药完成结果DTO DTO数据
 * 
 */
public class DispDrugFinishResultDTO {
	/**
	 * 处方主键
	 */
	private String id_Pres;

	/**
	 * 结果值
	 */
	private Integer eu_Result;

	/**
	 * 错误消息
	 */
	private String msg_Err;

	/**
	 * 获取处方主键
	 * 
	 * @return
	 */
	public String getId_Pres() {
		return id_Pres;
	}

	/**
	 * 设置处方主键
	 * 
	 * @param id_Pres
	 */
	public void setId_Pres(String id_Pres) {
		this.id_Pres = id_Pres;
	}

	/**
	 * 获取结果值
	 * 
	 * @return
	 */
	public Integer getEu_Result() {
		return eu_Result;
	}

	/**
	 * 设置结果值
	 * 
	 * @param eu_Result
	 */
	public void setEu_Result(Integer eu_Result) {
		this.eu_Result = eu_Result;
	}

	/**
	 * 获取错误消息
	 * 
	 * @return
	 */
	public String getMsg_Err() {
		return msg_Err;
	}

	/**
	 * 设置错误消息
	 * 
	 * @param msg_Err
	 */
	public void setMsg_Err(String msg_Err) {
		this.msg_Err = msg_Err;
	}
}