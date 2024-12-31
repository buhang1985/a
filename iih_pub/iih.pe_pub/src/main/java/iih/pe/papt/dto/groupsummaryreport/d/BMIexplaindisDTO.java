package iih.pe.papt.dto.groupsummaryreport.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class BMIexplaindisDTO extends BaseDTO {

	// 年龄段编码
	@RPCField(id = 1)
	private String code;
	// 年龄段内超重人数(女)
	@RPCField(id = 10)
	private Integer woman_overweight;
	// 年龄段内肥胖人数(女)
	@RPCField(id = 11)
	private Integer woman_obesity;
	// 年龄段内总人数(女)
	@RPCField(id = 12)
	private Integer woman_count;
	// 年龄段
	@RPCField(id = 2)
	private String agesegment;
	// 年龄段内消瘦人数(男)
	@RPCField(id = 3)
	private Integer man_emaciation;
	// 年龄段内正常人数(男)
	@RPCField(id = 4)
	private Integer man_normal;
	// 年龄段内超重人数(男)
	@RPCField(id = 5)
	private Integer man_overweight;
	// 年龄段内肥胖人数(男)
	@RPCField(id = 6)
	private Integer man_obesity;
	// 年龄段内总人数(男)
	@RPCField(id = 7)
	private Integer man_count;
	// 年龄段内消瘦人数(女)
	@RPCField(id = 8)
	private Integer woman_emaciation;
	// 年龄段内正常人数(女)
	@RPCField(id = 9)
	private Integer woman_normal;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getWoman_overweight() {
		return woman_overweight;
	}

	public void setWoman_overweight(Integer woman_overweight) {
		this.woman_overweight = woman_overweight;
	}

	public Integer getWoman_obesity() {
		return woman_obesity;
	}

	public void setWoman_obesity(Integer woman_obesity) {
		this.woman_obesity = woman_obesity;
	}

	public Integer getWoman_count() {
		return woman_count;
	}

	public void setWoman_count(Integer woman_count) {
		this.woman_count = woman_count;
	}

	public String getAgesegment() {
		return agesegment;
	}

	public void setAgesegment(String agesegment) {
		this.agesegment = agesegment;
	}

	public Integer getMan_emaciation() {
		return man_emaciation;
	}

	public void setMan_emaciation(Integer man_emaciation) {
		this.man_emaciation = man_emaciation;
	}

	public Integer getMan_normal() {
		return man_normal;
	}

	public void setMan_normal(Integer man_normal) {
		this.man_normal = man_normal;
	}

	public Integer getMan_overweight() {
		return man_overweight;
	}

	public void setMan_overweight(Integer man_overweight) {
		this.man_overweight = man_overweight;
	}

	public Integer getMan_obesity() {
		return man_obesity;
	}

	public void setMan_obesity(Integer man_obesity) {
		this.man_obesity = man_obesity;
	}

	public Integer getMan_count() {
		return man_count;
	}

	public void setMan_count(Integer man_count) {
		this.man_count = man_count;
	}

	public Integer getWoman_emaciation() {
		return woman_emaciation;
	}

	public void setWoman_emaciation(Integer woman_emaciation) {
		this.woman_emaciation = woman_emaciation;
	}

	public Integer getWoman_normal() {
		return woman_normal;
	}

	public void setWoman_normal(Integer woman_normal) {
		this.woman_normal = woman_normal;
	}

}
