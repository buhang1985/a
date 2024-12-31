package iih.ci.ord.s.ems.ip.ems.pathgy;

import iih.ci.ord.s.ems.base.BaseEmsAction;

public class EmsPathgyAction extends BaseEmsAction {
	public EmsPathgyAction(){
		super();
		setEmsValidate(new EmsPathgyValidate());
		setEmsCreateBP(new EmsPathgyCreateBP());
		setEmsLoadBP(new EmsPathgyLoadBP());
		setEmsSaveBP(new EmsPathgySaveBP());		
	}
}
