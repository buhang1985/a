package iih.ci.ord.s.ems.op.tmpl.pathgy;

import iih.ci.ord.s.ems.base.BaseEmsAction;

public class TmplPathgyAction extends BaseEmsAction {
	
	public TmplPathgyAction() {
		
//		setEmsLoadBP(new TmplPathgyLoadBP());
		setEmsSaveBP(new TmplPathgySaveBP(new TmplPathgyValidate()));
	}


}
