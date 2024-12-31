package iih.ci.ord.s.ems.op.ems.lis;

import iih.ci.ord.s.ems.base.BaseEmsAction;

public class EmsLisAction extends BaseEmsAction {
	
	
	public EmsLisAction() {
		super();
		setEmsCreateBP(new EmsLisCreateBP());
		setEmsLoadBP(new EmsLisLoadBP());
		setEmsSaveBP(new EmsLisSaveBP());
	}


}
