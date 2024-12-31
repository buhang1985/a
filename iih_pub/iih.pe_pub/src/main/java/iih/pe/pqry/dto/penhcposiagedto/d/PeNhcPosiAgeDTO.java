package iih.pe.pqry.dto.penhcposiagedto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检上报_卫生局年龄统计 DTO数据 
 * 
 */
public class PeNhcPosiAgeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 体检年龄分组列表ID
	 * @return String
	 */
	public String getId_peagelist() {
		return ((String) getAttrVal("Id_peagelist"));
	}
	/**
	 * 体检年龄分组列表ID
	 * @param Id_peagelist
	 */
	public void setId_peagelist(String Id_peagelist) {
		setAttrVal("Id_peagelist", Id_peagelist);
	}
	/**
	 * 体检年龄分组ID
	 * @return String
	 */
	public String getId_peage() {
		return ((String) getAttrVal("Id_peage"));
	}
	/**
	 * 体检年龄分组ID
	 * @param Id_peage
	 */
	public void setId_peage(String Id_peage) {
		setAttrVal("Id_peage", Id_peage);
	}
	/**
	 * 年龄分组编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 年龄分组编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 分组统计数
	 * @return Integer
	 */
	public Integer getCnt() {
		return ((Integer) getAttrVal("Cnt"));
	}
	/**
	 * 分组统计数
	 * @param Cnt
	 */
	public void setCnt(Integer Cnt) {
		setAttrVal("Cnt", Cnt);
	}
}