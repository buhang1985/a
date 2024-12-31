package iih.en.pv.outpatient.dto.d;

/**
 * 渠道排班统计信息
 * @author yank
 *
 */
public class ChlSchStatsDTO {
	
	private String id_sch;
	//渠道类型
	private String chlType;
	//号源总数
	private Integer total;
	//已使用数
	private Integer used;
	//可用号源数
	private Integer available;
	//取消预约数量
	private Integer cancNum;
	/**
	 * @return 渠道类型
	 */
	public String getChlType() {
		return chlType;
	}
	/**
	 * 设置渠道类型
	 * @param chlType 渠道类型
	 */
	public void setChlType(String chlType) {
		this.chlType = chlType;
	}
	/**
	 * 获取号源总数
	 * @return 号源总数
	 */
	public Integer getTotal() {
		return total;
	}
	/**
	 * 设置号源总数
	 * @param total the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getUsed() {
		return used;
	}

	public void setUsed(Integer used) {
		this.used = used;
	}

	public Integer getAvailable() {
		return available;
	}

	public void setAvailable(Integer available) {
		this.available = available;
	}
	public Integer getCancNum() {
		return cancNum;
	}
	public void setCancNum(Integer cancNum) {
		this.cancNum = cancNum;
	}
	public String getId_sch() {
		return id_sch;
	}
	public void setId_sch(String id_sch) {
		this.id_sch = id_sch;
	}
	

}
