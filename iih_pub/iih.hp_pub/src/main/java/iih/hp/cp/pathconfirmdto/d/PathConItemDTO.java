package iih.hp.cp.pathconfirmdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 入径标准数据 DTO数据 
 * 
 */
public class PathConItemDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 元素ID
	 * @return String
	 */
	public String getId_ele() {
		return ((String) getAttrVal("Id_ele"));
	}
	/**
	 * 元素ID
	 * @param Id_ele
	 */
	public void setId_ele(String Id_ele) {
		setAttrVal("Id_ele", Id_ele);
	}
	/**
	 * 诊疗计划ID
	 * @return String
	 */
	public String getId_cp() {
		return ((String) getAttrVal("Id_cp"));
	}
	/**
	 * 诊疗计划ID
	 * @param Id_cp
	 */
	public void setId_cp(String Id_cp) {
		setAttrVal("Id_cp", Id_cp);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getNo() {
		return ((Integer) getAttrVal("No"));
	}
	/**
	 * 序号
	 * @param No
	 */
	public void setNo(Integer No) {
		setAttrVal("No", No);
	}
	/**
	 * 元素编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 元素编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 元素名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 元素名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 父元素ID
	 * @return String
	 */
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}
	/**
	 * 父元素ID
	 * @param Id_par
	 */
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
	}
	/**
	 * 符合类型
	 * @return String
	 */
	public String getSd_confirm() {
		return ((String) getAttrVal("Sd_confirm"));
	}
	/**
	 * 符合类型
	 * @param Sd_confirm
	 */
	public void setSd_confirm(String Sd_confirm) {
		setAttrVal("Sd_confirm", Sd_confirm);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}
	/**
	 * 备注
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 内部编码
	 * @return String
	 */
	public String getInnercode() {
		return ((String) getAttrVal("Innercode"));
	}
	/**
	 * 内部编码
	 * @param Innercode
	 */
	public void setInnercode(String Innercode) {
		setAttrVal("Innercode", Innercode);
	}
}