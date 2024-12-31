package iih.nm.nbd.dto.wftaskdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 流程任务信息 DTO数据 
 * 
 */
public class WfTaskDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 流程任务主键
	 * @return String
	 */
	public String getId_task() {
		return ((String) getAttrVal("Id_task"));
	}
	/**
	 * 流程任务主键
	 * @param Id_task
	 */
	public void setId_task(String Id_task) {
		setAttrVal("Id_task", Id_task);
	}
	/**
	 * 流程单据标识
	 * @return String
	 */
	public String getId_frmins() {
		return ((String) getAttrVal("Id_frmins"));
	}
	/**
	 * 流程单据标识
	 * @param Id_frmins
	 */
	public void setId_frmins(String Id_frmins) {
		setAttrVal("Id_frmins", Id_frmins);
	}
	/**
	 * 任务所属者标识
	 * @return String
	 */
	public String getId_owner() {
		return ((String) getAttrVal("Id_owner"));
	}
	/**
	 * 任务所属者标识
	 * @param Id_owner
	 */
	public void setId_owner(String Id_owner) {
		setAttrVal("Id_owner", Id_owner);
	}
	/**
	 * 流程类型标识
	 * @return String
	 */
	public String getId_flowtype() {
		return ((String) getAttrVal("Id_flowtype"));
	}
	/**
	 * 流程类型标识
	 * @param Id_flowtype
	 */
	public void setId_flowtype(String Id_flowtype) {
		setAttrVal("Id_flowtype", Id_flowtype);
	}
	/**
	 * 任务状态
	 * @return String
	 */
	public String getState() {
		return ((String) getAttrVal("State"));
	}
	/**
	 * 任务状态
	 * @param State
	 */
	public void setState(String State) {
		setAttrVal("State", State);
	}
}