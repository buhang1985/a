package iih.ci.ord.s.ems.ip.assi.cp.lis;

import iih.ci.ord.s.ems.base.BaseEmsAction;

/**
 * 
 *
 */
public class CpLisAction extends BaseEmsAction {
	
	public CpLisAction() {
		super();
		setEmsSaveBP(new CpLisSaveBP());	
	}


}
