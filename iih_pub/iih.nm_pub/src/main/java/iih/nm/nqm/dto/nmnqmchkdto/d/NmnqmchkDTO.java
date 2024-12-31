package iih.nm.nqm.dto.nmnqmchkdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 检查任务带出内容 DTO数据 
 * 
 */
public class NmnqmchkDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 检查者
	 * @return String
	 */
	public String getId_chk_psn() {
		return ((String) getAttrVal("Id_chk_psn"));
	}
	/**
	 * 检查者
	 * @param Id_chk_psn
	 */
	public void setId_chk_psn(String Id_chk_psn) {
		setAttrVal("Id_chk_psn", Id_chk_psn);
	}
	/**
	 * 检查者姓名
	 * @return String
	 */
	public String getName_chk_psn() {
		return ((String) getAttrVal("Name_chk_psn"));
	}
	/**
	 * 检查者姓名
	 * @param Name_chk_psn
	 */
	public void setName_chk_psn(String Name_chk_psn) {
		setAttrVal("Name_chk_psn", Name_chk_psn);
	}
	/**
	 * 其他检查者
	 * @return String
	 */
	public String getId_chk_psn_oth() {
		return ((String) getAttrVal("Id_chk_psn_oth"));
	}
	/**
	 * 其他检查者
	 * @param Id_chk_psn_oth
	 */
	public void setId_chk_psn_oth(String Id_chk_psn_oth) {
		setAttrVal("Id_chk_psn_oth", Id_chk_psn_oth);
	}
	/**
	 * 其他检查者姓名
	 * @return String
	 */
	public String getName_chk_psn_oth() {
		return ((String) getAttrVal("Name_chk_psn_oth"));
	}
	/**
	 * 其他检查者姓名
	 * @param Name_chk_psn_oth
	 */
	public void setName_chk_psn_oth(String Name_chk_psn_oth) {
		setAttrVal("Name_chk_psn_oth", Name_chk_psn_oth);
	}
	/**
	 * 检查标准id集合
	 * @return FArrayList
	 */
	public FArrayList getCsids() {
		return ((FArrayList) getAttrVal("Csids"));
	}
	/**
	 * 检查标准id集合
	 * @param Csids
	 */
	public void setCsids(FArrayList Csids) {
		setAttrVal("Csids", Csids);
	}
	/**
	 * 检查模板id集合
	 * @return FArrayList
	 */
	public FArrayList getTmplids() {
		return ((FArrayList) getAttrVal("Tmplids"));
	}
	/**
	 * 检查模板id集合
	 * @param Tmplids
	 */
	public void setTmplids(FArrayList Tmplids) {
		setAttrVal("Tmplids", Tmplids);
	}
}