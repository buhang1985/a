package iih.ci.ord.s.ems.ip.assi.cp.opr;

import iih.ci.ord.s.ems.base.BaseEmsAction;

public class CpOprAction  extends BaseEmsAction {
	
	public CpOprAction() {
		super();
		this.setEmsSaveBP(new CpOprSaveBP());
	}

}
