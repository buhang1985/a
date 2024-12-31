package iih.mp.dg.dto.prints.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 输液卡体 DTO数据 
 * 
 */
public class InfuCardItemDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 药品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}
	/**
	 * 药品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 用量
	 * @return FDouble
	 */
	public FDouble getQuan_med() {
		return ((FDouble) getAttrVal("Quan_med"));
	}
	/**
	 * 用量
	 * @param Quan_med
	 */
	public void setQuan_med(FDouble Quan_med) {
		setAttrVal("Quan_med", Quan_med);
	}
	/**
	 * 频次
	 * @return String
	 */
	public String getFreq() {
		return ((String) getAttrVal("Freq"));
	}
	/**
	 * 频次
	 * @param Freq
	 */
	public void setFreq(String Freq) {
		setAttrVal("Freq", Freq);
	}
	/**
	 * 执行时间
	 * @return FDateTime
	 */
	public FDateTime getDate() {
		return ((FDateTime) getAttrVal("Date"));
	}
	/**
	 * 执行时间
	 * @param Date
	 */
	public void setDate(FDateTime Date) {
		setAttrVal("Date", Date);
	}
	/**
	 * 护士签名
	 * @return String
	 */
	public String getSign() {
		return ((String) getAttrVal("Sign"));
	}
	/**
	 * 护士签名
	 * @param Sign
	 */
	public void setSign(String Sign) {
		setAttrVal("Sign", Sign);
	}
}