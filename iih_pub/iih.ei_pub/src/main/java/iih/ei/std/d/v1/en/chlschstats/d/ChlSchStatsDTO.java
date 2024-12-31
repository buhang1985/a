package iih.ei.std.d.v1.en.chlschstats.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 渠道预约统计信息 DTO数据 
 * 
 */
public class ChlSchStatsDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 渠道类型编码
	 * @return String
	 */
	public String getCode_chltp() {
		return ((String) getAttrVal("Code_chltp"));
	}	
	/**
	 * 渠道类型编码
	 * @param Code_chltp
	 */
	public void setCode_chltp(String Code_chltp) {
		setAttrVal("Code_chltp", Code_chltp);
	}
	/**
	 * 预约未支付
	 * @return Integer
	 */
	public Integer getNum_aprnotfee() {
		return ((Integer) getAttrVal("Num_aprnotfee"));
	}	
	/**
	 * 预约未支付
	 * @param Num_aprnotfee
	 */
	public void setNum_aprnotfee(Integer Num_aprnotfee) {
		setAttrVal("Num_aprnotfee", Num_aprnotfee);
	}
	/**
	 * 预约且支付
	 * @return Integer
	 */
	public Integer getNum_aptwithfee() {
		return ((Integer) getAttrVal("Num_aptwithfee"));
	}	
	/**
	 * 预约且支付
	 * @param Num_aptwithfee
	 */
	public void setNum_aptwithfee(Integer Num_aptwithfee) {
		setAttrVal("Num_aptwithfee", Num_aptwithfee);
	}
	/**
	 * 预约取号
	 * @return Integer
	 */
	public Integer getNum_aptcfm() {
		return ((Integer) getAttrVal("Num_aptcfm"));
	}	
	/**
	 * 预约取号
	 * @param Num_aptcfm
	 */
	public void setNum_aptcfm(Integer Num_aptcfm) {
		setAttrVal("Num_aptcfm", Num_aptcfm);
	}
	/**
	 * 退号
	 * @return Integer
	 */
	public Integer getNum_aptcfmcanc() {
		return ((Integer) getAttrVal("Num_aptcfmcanc"));
	}	
	/**
	 * 退号
	 * @param Num_aptcfmcanc
	 */
	public void setNum_aptcfmcanc(Integer Num_aptcfmcanc) {
		setAttrVal("Num_aptcfmcanc", Num_aptcfmcanc);
	}
	/**
	 * 取消预约
	 * @return Integer
	 */
	public Integer getNum_aptcanc() {
		return ((Integer) getAttrVal("Num_aptcanc"));
	}	
	/**
	 * 取消预约
	 * @param Num_aptcanc
	 */
	public void setNum_aptcanc(Integer Num_aptcanc) {
		setAttrVal("Num_aptcanc", Num_aptcanc);
	}
	/**
	 * 取号后未到诊的数量
	 * @return Integer
	 */
	public Integer getNum_aptcfmabsent() {
		return ((Integer) getAttrVal("Num_aptcfmabsent"));
	}	
	/**
	 * 取号后未到诊的数量
	 * @param Num_aptcfmabsent
	 */
	public void setNum_aptcfmabsent(Integer Num_aptcfmabsent) {
		setAttrVal("Num_aptcfmabsent", Num_aptcfmabsent);
	}
	/**
	 * 总号源数
	 * @return Integer
	 */
	public Integer getTotal_ticket() {
		return ((Integer) getAttrVal("Total_ticket"));
	}	
	/**
	 * 总号源数
	 * @param Total_ticket
	 */
	public void setTotal_ticket(Integer Total_ticket) {
		setAttrVal("Total_ticket", Total_ticket);
	}
	/**
	 * 已使用数
	 * @return Integer
	 */
	public Integer getUsed_ticket() {
		return ((Integer) getAttrVal("Used_ticket"));
	}	
	/**
	 * 已使用数
	 * @param Used_ticket
	 */
	public void setUsed_ticket(Integer Used_ticket) {
		setAttrVal("Used_ticket", Used_ticket);
	}
	/**
	 * 可用号源数
	 * @return Integer
	 */
	public Integer getValid_ticket() {
		return ((Integer) getAttrVal("Valid_ticket"));
	}	
	/**
	 * 可用号源数
	 * @param Valid_ticket
	 */
	public void setValid_ticket(Integer Valid_ticket) {
		setAttrVal("Valid_ticket", Valid_ticket);
	}
}