package iih.ci.ord.s.ems.ip.ems.opr;

import iih.ci.ord.s.ems.base.BaseEmsAction;

public class EmsOprAction extends BaseEmsAction {
	public EmsOprAction(){
		super();
		setEmsValidate(new EmsOprValidate());
		setEmsCreateBP(new EmsOprCreateBP());
		setEmsLoadBP(new EmsOprLoadBP());
		setEmsSaveBP(new EmsOprSaveBP());		
	}

}
