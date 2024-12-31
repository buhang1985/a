package iih.ei.std.d.v1.sc.mtscdbsrv.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医技诊疗项目字典 DTO数据 
 * 
 */
public class MtScDbSrvDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 项目id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 项目id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 项目编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}	
	/**
	 * 项目编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 项目名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	/**
	 * 项目名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 五笔码
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	/**
	 * 五笔码
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 分类id
	 * @return String
	 */
	public String getId_scca() {
		return ((String) getAttrVal("Id_scca"));
	}	
	/**
	 * 分类id
	 * @param Id_scca
	 */
	public void setId_scca(String Id_scca) {
		setAttrVal("Id_scca", Id_scca);
	}
	/**
	 * 分类名称
	 * @return String
	 */
	public String getName_scca() {
		return ((String) getAttrVal("Name_scca"));
	}	
	/**
	 * 分类名称
	 * @param Name_scca
	 */
	public void setName_scca(String Name_scca) {
		setAttrVal("Name_scca", Name_scca);
	}
	/**
	 * 标准价格
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}	
	/**
	 * 标准价格
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
}