package iih.pe.papt.dto.groupsummaryreport.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class BloodFatdisDTO extends BaseDTO {

	// 指标名称
	@RPCField(id = 1)
	private String name;
	// 该指标正常人数(男)
	@RPCField(id = 2)
	private Integer man_normal;
	// 该指标异常人数(男)
	@RPCField(id = 3)
	private Integer man_abnormal;
	// 该指标正常人数(女)
	@RPCField(id = 4)
	private Integer woman_normal;
	// 该指标异常人数(女)
	@RPCField(id = 5)
	private Integer woman_abnormal;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMan_normal() {
		return man_normal;
	}

	public void setMan_normal(Integer man_normal) {
		this.man_normal = man_normal;
	}

	public Integer getMan_abnormal() {
		return man_abnormal;
	}

	public void setMan_abnormal(Integer man_abnormal) {
		this.man_abnormal = man_abnormal;
	}

	public Integer getWoman_normal() {
		return woman_normal;
	}

	public void setWoman_normal(Integer woman_normal) {
		this.woman_normal = woman_normal;
	}

	public Integer getWoman_abnormal() {
		return woman_abnormal;
	}

	public void setWoman_abnormal(Integer woman_abnormal) {
		this.woman_abnormal = woman_abnormal;
	}

}
