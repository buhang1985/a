package iih.sc.scbd.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 打印模板dto DTO数据 
 * 
 */
public class ScPrtTmplDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 预约打印模板id
	 * @return String
	 */
	public String getId_prttmpl() {
		return ((String) getAttrVal("Id_prttmpl"));
	}
	/**
	 * 预约打印模板id
	 * @param Id_prttmpl
	 */
	public void setId_prttmpl(String Id_prttmpl) {
		setAttrVal("Id_prttmpl", Id_prttmpl);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
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
	 * 模板路径
	 * @return String
	 */
	public String getPath() {
		return ((String) getAttrVal("Path"));
	}
	/**
	 * 模板路径
	 * @param Path
	 */
	public void setPath(String Path) {
		setAttrVal("Path", Path);
	}
	/**
	 * 排班分类
	 * @return String
	 */
	public String getId_scca() {
		return ((String) getAttrVal("Id_scca"));
	}
	/**
	 * 排班分类
	 * @param Id_scca
	 */
	public void setId_scca(String Id_scca) {
		setAttrVal("Id_scca", Id_scca);
	}
	/**
	 * 预约打印类型id
	 * @return String
	 */
	public String getId_rpttp() {
		return ((String) getAttrVal("Id_rpttp"));
	}
	/**
	 * 预约打印类型id
	 * @param Id_rpttp
	 */
	public void setId_rpttp(String Id_rpttp) {
		setAttrVal("Id_rpttp", Id_rpttp);
	}
	/**
	 * 预约打印类型
	 * @return String
	 */
	public String getSd_rpttp() {
		return ((String) getAttrVal("Sd_rpttp"));
	}
	/**
	 * 预约打印类型
	 * @param Sd_rpttp
	 */
	public void setSd_rpttp(String Sd_rpttp) {
		setAttrVal("Sd_rpttp", Sd_rpttp);
	}
}