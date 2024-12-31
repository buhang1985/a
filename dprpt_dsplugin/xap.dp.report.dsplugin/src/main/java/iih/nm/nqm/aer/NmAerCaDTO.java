package iih.nm.nqm.aer;
/**
 * @author 作者 :huang_junhao
 * @version 创建时间：2017年6月7日 下午5:18:38
 * 类说明：
 * Company: Copyright 2017 by PKU healthcare IT Co.,Ltd.
 */
public class NmAerCaDTO {

	private String sd_evt_ca;//事件分类编码

	private String name_other;//事件分类其他
	
	public String getSd_evt_ca() {
		return sd_evt_ca;
	}

	public void setSd_evt_ca(String sd_evt_ca) {
		this.sd_evt_ca = sd_evt_ca;
	}

	public String getName_other() {
		return name_other;
	}

	public void setName_other(String name_other) {
		this.name_other = name_other;
	}
	
}
