package iih.ci.ord.s.ems.op.ems.ris;

import iih.ci.ord.s.ems.base.BaseEmsAction;

public class EmsRisAction extends BaseEmsAction {
	
	public EmsRisAction() {
		super();
		
		setEmsCreateBP(new EmsRisCreateBP());
		setEmsLoadBP(new EmsRisLoadBP());
		setEmsSaveBP(new EmsRisSaveBP());
	}


	
}
