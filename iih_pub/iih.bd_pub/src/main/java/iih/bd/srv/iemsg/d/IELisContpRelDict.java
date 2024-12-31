package iih.bd.srv.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IELIS检验项目与容器关系字典DTO DTO数据 
 * 
 */
public class IELisContpRelDict extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IELIS检验项目与容器关系字典主键
	 * @return String
	 */
	public String getId_ieliscontpreldict() {
		return ((String) getAttrVal("Id_ieliscontpreldict"));
	}
	/**
	 * IELIS检验项目与容器关系字典主键
	 * @param Id_ieliscontpreldict
	 */
	public void setId_ieliscontpreldict(String Id_ieliscontpreldict) {
		setAttrVal("Id_ieliscontpreldict", Id_ieliscontpreldict);
	}
	/**
	 * 操作类型
	 * @return String
	 */
	public String getAction() {
		return ((String) getAttrVal("Action"));
	}
	/**
	 * 操作类型
	 * @param Action
	 */
	public void setAction(String Action) {
		setAttrVal("Action", Action);
	}
	/**
	 * 项目内码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 项目内码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 容器编码
	 * @return String
	 */
	public String getContainercode() {
		return ((String) getAttrVal("Containercode"));
	}
	/**
	 * 容器编码
	 * @param Containercode
	 */
	public void setContainercode(String Containercode) {
		setAttrVal("Containercode", Containercode);
	}
}