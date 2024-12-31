package iih.ci.ord.s.ems.op.ems.pathgy;

import iih.ci.ord.s.ems.base.BaseEmsAction;

public class EmsPathgyAction extends BaseEmsAction {
	
	public EmsPathgyAction() {
		super();
		
		setEmsCreateBP(new EmsPathgyCreateBP());
		setEmsLoadBP(new EmsPathgyLoadBP());
		setEmsSaveBP(new EmsPathgySaveBP());
	}


}
