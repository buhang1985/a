package iih.bd.pp.dto.accsrvrelat.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 核算分类医疗服务关系dto DTO数据 
 * 
 */
public class AccSrvRelatDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 核算分类编码
	 * @return String
	 */
	public String getCode_acc() {
		return ((String) getAttrVal("Code_acc"));
	}
	/**
	 * 核算分类编码
	 * @param Code_acc
	 */
	public void setCode_acc(String Code_acc) {
		setAttrVal("Code_acc", Code_acc);
	}
	/**
	 * 核算分类名称
	 * @return String
	 */
	public String getName_acc() {
		return ((String) getAttrVal("Name_acc"));
	}
	/**
	 * 核算分类名称
	 * @param Name_acc
	 */
	public void setName_acc(String Name_acc) {
		setAttrVal("Name_acc", Name_acc);
	}
}