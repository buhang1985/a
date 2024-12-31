package iih.mp.mpbd.dto.patvstagttreedto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者体征指标树表示 DTO数据 
 * 
 */
public class PatVsTagtTreeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 树id
	 * @return String
	 */
	public String getId_tree() {
		return ((String) getAttrVal("Id_tree"));
	}
	/**
	 * 树id
	 * @param Id_tree
	 */
	public void setId_tree(String Id_tree) {
		setAttrVal("Id_tree", Id_tree);
	}
	/**
	 * 树名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 树名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 父级id
	 * @return String
	 */
	public String getId_parent() {
		return ((String) getAttrVal("Id_parent"));
	}
	/**
	 * 父级id
	 * @param Id_parent
	 */
	public void setId_parent(String Id_parent) {
		setAttrVal("Id_parent", Id_parent);
	}
	/**
	 * 功能节点编码
	 * @return String
	 */
	public String getCode_tree() {
		return ((String) getAttrVal("Code_tree"));
	}
	/**
	 * 功能节点编码
	 * @param Code_tree
	 */
	public void setCode_tree(String Code_tree) {
		setAttrVal("Code_tree", Code_tree);
	}
}