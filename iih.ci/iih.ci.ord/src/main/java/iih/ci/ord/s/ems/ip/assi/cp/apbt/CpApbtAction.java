package iih.ci.ord.s.ems.ip.assi.cp.apbt;

import iih.ci.ord.s.ems.base.BaseEmsAction;

public class CpApbtAction extends BaseEmsAction {

	public CpApbtAction() {
		super();
		this.setEmsSaveBP(new CpApbtSaveBP());
	}

	
}
