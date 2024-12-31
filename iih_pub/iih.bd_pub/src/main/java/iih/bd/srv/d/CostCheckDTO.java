package iih.bd.srv.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 费用反查 DTO数据 
 * 
 */
public class CostCheckDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 节点名称
	 * @return String
	 */
	public String getNode_name() {
		return ((String) getAttrVal("Node_name"));
	}
	/**
	 * 节点名称
	 * @param Node_name
	 */
	public void setNode_name(String Node_name) {
		setAttrVal("Node_name", Node_name);
	}
	/**
	 * 树分类
	 * @return String
	 */
	public String getName_tree() {
		return ((String) getAttrVal("Name_tree"));
	}
	/**
	 * 树分类
	 * @param Name_tree
	 */
	public void setName_tree(String Name_tree) {
		setAttrVal("Name_tree", Name_tree);
	}
	/**
	 * 类型
	 * @return String
	 */
	public String getType() {
		return ((String) getAttrVal("Type"));
	}
	/**
	 * 类型
	 * @param Type
	 */
	public void setType(String Type) {
		setAttrVal("Type", Type);
	}
	/**
	 * 服务
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 服务
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
}