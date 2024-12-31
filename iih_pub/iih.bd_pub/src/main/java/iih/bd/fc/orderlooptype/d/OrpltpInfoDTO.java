package iih.bd.fc.orderlooptype.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 闭环明细信息 DTO数据 
 * 
 */
public class OrpltpInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 闭环类型
	 * @return String
	 */
	public String getId_orpltp() {
		return ((String) getAttrVal("Id_orpltp"));
	}
	/**
	 * 闭环类型
	 * @param Id_orpltp
	 */
	public void setId_orpltp(String Id_orpltp) {
		setAttrVal("Id_orpltp", Id_orpltp);
	}
	/**
	 * 闭环描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}
	/**
	 * 闭环描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
}