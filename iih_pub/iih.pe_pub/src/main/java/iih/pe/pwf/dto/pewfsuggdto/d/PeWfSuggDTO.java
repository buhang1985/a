package iih.pe.pwf.dto.pewfsuggdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检分检建议选择列表 DTO数据 
 * 
 */
public class PeWfSuggDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 体检建议ID
	 * @return String
	 */
	public String getId_perstsuggdef() {
		return ((String) getAttrVal("Id_perstsuggdef"));
	}
	/**
	 * 体检建议ID
	 * @param Id_perstsuggdef
	 */
	public void setId_perstsuggdef(String Id_perstsuggdef) {
		setAttrVal("Id_perstsuggdef", Id_perstsuggdef);
	}
	/**
	 * 建议编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 建议编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 建议名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 建议名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 英文建议
	 * @return String
	 */
	public String getEname() {
		return ((String) getAttrVal("Ename"));
	}
	/**
	 * 英文建议
	 * @param Ename
	 */
	public void setEname(String Ename) {
		setAttrVal("Ename", Ename);
	}
	/**
	 * 次序
	 * @return String
	 */
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}
	/**
	 * 次序
	 * @param Sortno
	 */
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 复查标识
	 * @return FBoolean
	 */
	public FBoolean getFg_recheck() {
		return ((FBoolean) getAttrVal("Fg_recheck"));
	}
	/**
	 * 复查标识
	 * @param Fg_recheck
	 */
	public void setFg_recheck(FBoolean Fg_recheck) {
		setAttrVal("Fg_recheck", Fg_recheck);
	}
	/**
	 * 拼音
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}
	/**
	 * 拼音
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 建议分类ID
	 * @return String
	 */
	public String getId_perstsuggtp() {
		return ((String) getAttrVal("Id_perstsuggtp"));
	}
	/**
	 * 建议分类ID
	 * @param Id_perstsuggtp
	 */
	public void setId_perstsuggtp(String Id_perstsuggtp) {
		setAttrVal("Id_perstsuggtp", Id_perstsuggtp);
	}
	/**
	 * 分类编码
	 * @return String
	 */
	public String getCode_tp() {
		return ((String) getAttrVal("Code_tp"));
	}
	/**
	 * 分类编码
	 * @param Code_tp
	 */
	public void setCode_tp(String Code_tp) {
		setAttrVal("Code_tp", Code_tp);
	}
	/**
	 * 分类名称
	 * @return String
	 */
	public String getName_tp() {
		return ((String) getAttrVal("Name_tp"));
	}
	/**
	 * 分类名称
	 * @param Name_tp
	 */
	public void setName_tp(String Name_tp) {
		setAttrVal("Name_tp", Name_tp);
	}
}