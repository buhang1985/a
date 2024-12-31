package iih.mp.dg.ws.op.d;

/**
 * 开始发药参数DTO DTO数据
 * 
 */
public class BeginDispDrugParamDTO {
	/**
	 * 患者主键
	 */
	private String id_Pat;

	/**
	 * 就诊卡号
	 */
	private String code_EnCard;

	/**
	 * 处方主键集合
	 */
	private String[] presIds;

	/**
	 * 获取患者主键
	 * 
	 * @return
	 */
	public String getId_Pat() {
		return id_Pat;
	}

	/**
	 * 设置患者主键
	 * 
	 * @param id_Pat
	 */
	public void setId_Pat(String id_Pat) {
		this.id_Pat = id_Pat;
	}

	/**
	 * 获取就诊卡号
	 * 
	 * @return
	 */
	public String getCode_EnCard() {
		return code_EnCard;
	}

	/**
	 * 设置就诊卡号
	 * 
	 * @param code_EnCard
	 */
	public void setCode_EnCard(String code_EnCard) {
		this.code_EnCard = code_EnCard;
	}

	/**
	 * 获取处方主键集合
	 * 
	 * @return
	 */
	public String[] getPresIds() {
		return presIds;
	}

	/**
	 * 设置处方主键集合
	 * 
	 * @param presIds
	 */
	public void setPresIds(String[] presIds) {
		this.presIds = presIds;
	}
}