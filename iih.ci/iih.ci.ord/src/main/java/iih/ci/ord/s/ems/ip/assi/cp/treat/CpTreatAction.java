package iih.ci.ord.s.ems.ip.assi.cp.treat;

import iih.ci.ord.s.ems.base.BaseEmsAction;

/**
 * 
 *
 */
public class CpTreatAction extends BaseEmsAction {
	
	public CpTreatAction() {
		super();
		setEmsSaveBP(new CpTreatSaveBP());	
	}

}
