package iih.mp.nr.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱未执行状态统计查询 DTO数据 
 * 
 */
public class PeStaCountDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 医技未执行数
	 * @return Integer
	 */
	public Integer getTech_num() {
		return ((Integer) getAttrVal("Tech_num"));
	}
	/**
	 * 医技未执行数
	 * @param Tech_num
	 */
	public void setTech_num(Integer Tech_num) {
		setAttrVal("Tech_num", Tech_num);
	}
	/**
	 * 非医技未执行数
	 * @return Integer
	 */
	public Integer getOther_num() {
		return ((Integer) getAttrVal("Other_num"));
	}
	/**
	 * 非医技未执行数
	 * @param Other_num
	 */
	public void setOther_num(Integer Other_num) {
		setAttrVal("Other_num", Other_num);
	}
}