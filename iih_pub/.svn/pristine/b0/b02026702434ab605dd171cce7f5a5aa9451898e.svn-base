package iih.sfda.aeh.evrptflow.d;

import iih.sfda.aeh.evrptflow.IAerEvFormInfoCtx;
import iih.sfda.aer.sfdaaerev.d.SfdaAerEvDO;

public class AerEvFormDO implements IAerEvFormInfoCtx {

	private static final long serialVersionUID = 1L;

	private SfdaAerEvDO sfdaAerEvDO;
	// 审批意见
	private String appropin;
	// 流程定义主键
	private String flowTypePk;
	// 流程实例状态字段名
	private String frmStateField;
	// 审批标题
	private String title;

	public AerEvFormDO(SfdaAerEvDO sfdaAerEvDO) {
		this.sfdaAerEvDO = sfdaAerEvDO;
	}

	/**
	 * 获取业务单据
	 */
	@Override
	public Object getDataInst() {
		return this.sfdaAerEvDO;
	}

	/**
	 * 设置审批意见
	 */
	@Override
	public void setAppropin(String appropin) {
		this.appropin = appropin;
	}

	/**
	 * 获取审批意见
	 */
	@Override
	public String getAppropin() {
		return this.appropin;
	}

	/**
	 * 设置流程定义主键值
	 */
	@Override
	public void setFlowTypePk(String flowTypePk) {
		this.flowTypePk = flowTypePk;
	}

	/**
	 * 获取流程定义主键值
	 */
	@Override
	public String getFlowTypePk() {
		return this.flowTypePk;
	}

	/**
	 * 获取业务主键值
	 */
	@Override
	public String getTaskPk() {
		Object obj = this.sfdaAerEvDO.getAttrVal(SfdaAerEvDO.ID_TASK);
		if (obj != null) {
			return obj.toString();
		} else {
			return null;
		}
	}

	/**
	 * 设置流程实例状态字段
	 */
	@Override
	public void setFrmStateField(String stateField) {
		this.frmStateField = stateField;
	}

	/**
	 * 设置审批标题
	 */
	@Override
	public void setTitleValue(String titleValue) {
		this.title = titleValue;
	}

	@Override
	public String getFrmStateField() {
		return this.frmStateField;
	}

	@Override
	public String getFrmTitileField() {
		return "Title";
	}

	@Override
	public String getFrmTaskPkField() {
		return SfdaAerEvDO.ID_TASK;
	}

	@Override
	public String getFrmInsPk() {
		return this.sfdaAerEvDO.getPkVal();
	}

	@Override
	public Object getAttributeValue(String paramString) {
		if ("Title".equals(paramString)) {
			return this.title;
		} else {
			return this.sfdaAerEvDO.getAttrVal(paramString);
		}
	}

	@Override
	public Object getAllLevelAttributeValue(String paramString1, String paramString2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAttributeValue(String paramString, Object paramObject) {
		if (paramString != null && paramObject != null) {
			this.sfdaAerEvDO.setAttrVal(paramString, paramObject);
		}
	}

	@Override
	public String[] getAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBillMakeDateField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBillMakeUserField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBillMakeNumbField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBillMakeDeptField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFrmAuditUserField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFrmAuditDateField() {
		// TODO Auto-generated method stub
		return null;
	}

}
