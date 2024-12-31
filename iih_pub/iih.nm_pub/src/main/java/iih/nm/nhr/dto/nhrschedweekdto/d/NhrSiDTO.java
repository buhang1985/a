package iih.nm.nhr.dto.nhrschedweekdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 班次信息dto DTO数据 
 * 
 */
public class NhrSiDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 班次信息主键
	 * @return String
	 */
	public String getId_nhr_si() {
		return ((String) getAttrVal("Id_nhr_si"));
	}
	/**
	 * 班次信息主键
	 * @param Id_nhr_si
	 */
	public void setId_nhr_si(String Id_nhr_si) {
		setAttrVal("Id_nhr_si", Id_nhr_si);
	}
	/**
	 * 人员列表
	 * @return FArrayList
	 */
	public FArrayList getNurlist() {
		return ((FArrayList) getAttrVal("Nurlist"));
	}
	/**
	 * 人员列表
	 * @param Nurlist
	 */
	public void setNurlist(FArrayList Nurlist) {
		setAttrVal("Nurlist", Nurlist);
	}
	/**
	 * 班次名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 班次名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
}