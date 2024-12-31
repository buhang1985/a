package iih.ci.ord.s.ems.op.ems.herbs;

import iih.ci.ord.s.ems.base.BaseEmsAction;

public class EmsHerbsAction extends BaseEmsAction {

	public EmsHerbsAction() {
		super();
		setEmsCreateBP(new EmsHerbsCreateBP());
		setEmsLoadBP(new EmsHerbsLoadBP());
		setEmsSaveBP(new EmsHerbsSaveBP());
	}

	
}
