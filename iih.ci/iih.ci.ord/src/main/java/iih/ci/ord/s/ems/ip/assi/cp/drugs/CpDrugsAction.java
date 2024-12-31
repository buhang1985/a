package iih.ci.ord.s.ems.ip.assi.cp.drugs;

import iih.ci.ord.s.ems.base.BaseEmsAction;

public class CpDrugsAction extends BaseEmsAction{

	public CpDrugsAction() {
		super();
		setEmsSaveBP(new CpDrugsSaveBP());	
	}

	
}
