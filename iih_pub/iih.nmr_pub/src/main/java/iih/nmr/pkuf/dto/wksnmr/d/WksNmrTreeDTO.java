package iih.nmr.pkuf.dto.wksnmr.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 护士站文书树 DTO数据 
 * 
 */
public class WksNmrTreeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 文书基本信息
	 * @return String
	 */
	public String getId_nmr_doc() {
		return ((String) getAttrVal("Id_nmr_doc"));
	}
	/**
	 * 文书基本信息
	 * @param Id_nmr_doc
	 */
	public void setId_nmr_doc(String Id_nmr_doc) {
		setAttrVal("Id_nmr_doc", Id_nmr_doc);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 父级ID
	 * @return String
	 */
	public String getId_parent() {
		return ((String) getAttrVal("Id_parent"));
	}
	/**
	 * 父级ID
	 * @param Id_parent
	 */
	public void setId_parent(String Id_parent) {
		setAttrVal("Id_parent", Id_parent);
	}
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
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 内码
	 * @return String
	 */
	public String getInnercode() {
		return ((String) getAttrVal("Innercode"));
	}
	/**
	 * 内码
	 * @param Innercode
	 */
	public void setInnercode(String Innercode) {
		setAttrVal("Innercode", Innercode);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 数据集
	 * @return String
	 */
	public String getId_set() {
		return ((String) getAttrVal("Id_set"));
	}
	/**
	 * 数据集
	 * @param Id_set
	 */
	public void setId_set(String Id_set) {
		setAttrVal("Id_set", Id_set);
	}
	/**
	 * 功能编码
	 * @return String
	 */
	public String getFun_code() {
		return ((String) getAttrVal("Fun_code"));
	}
	/**
	 * 功能编码
	 * @param Fun_code
	 */
	public void setFun_code(String Fun_code) {
		setAttrVal("Fun_code", Fun_code);
	}
	/**
	 * 功能名称
	 * @return String
	 */
	public String getFun_name() {
		return ((String) getAttrVal("Fun_name"));
	}
	/**
	 * 功能名称
	 * @param Fun_name
	 */
	public void setFun_name(String Fun_name) {
		setAttrVal("Fun_name", Fun_name);
	}
	/**
	 * 是否功能
	 * @return FBoolean
	 */
	public FBoolean getFg_fun() {
		return ((FBoolean) getAttrVal("Fg_fun"));
	}
	/**
	 * 是否功能
	 * @param Fg_fun
	 */
	public void setFg_fun(FBoolean Fg_fun) {
		setAttrVal("Fg_fun", Fg_fun);
	}
}