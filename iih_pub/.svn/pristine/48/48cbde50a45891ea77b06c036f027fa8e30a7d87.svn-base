package iih.mm.po.purchase.d;

import xap.wf.af.server.WfFormInfoCtx;

public class PurchaseFormAggDO extends PurchaseAggDO implements WfFormInfoCtx {
	private final String TITLE_FIELD = "test_title";

	@Override
	public Object getAllLevelAttributeValue(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getAttributeValue(String arg0) {
		if(TITLE_FIELD.equalsIgnoreCase(arg0)){
			String poName = this.getParentDO().getName();
			String createUser = this.getParentDO().getCreatedby();
			StringBuffer title = new StringBuffer();
			title.append("用户[" + createUser + "]提交了采购单[" + poName + "]");
			return title.toString();
		}
		return this.getParentDO().getAttrVal(arg0);
	}

	@Override
	public String getBillMakeDateField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBillMakeDeptField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBillMakeNumbField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBillMakeUserField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFrmAuditDateField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFrmAuditUserField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFrmInsPk() {
		return this.getParentDO().getPkVal();
	}

	@Override
	public String getFrmStateField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFrmTitileField() {
		return TITLE_FIELD;
	}

//	@Override
//	public String getTaskId() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public void setAttributeValue(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		this.getParentDO().setAttrVal(arg0, arg1);
	}

	@Override
	public String getFrmTaskPkField() {
		// TODO Auto-generated method stub
		return null;
	}

}
