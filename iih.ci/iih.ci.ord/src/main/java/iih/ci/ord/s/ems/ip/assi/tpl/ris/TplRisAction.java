package iih.ci.ord.s.ems.ip.assi.tpl.ris;

import iih.ci.ord.s.ems.base.BaseEmsAction;

public class TplRisAction extends BaseEmsAction  {
	public TplRisAction(){
		super();
		setEmsSaveBP(new TplRisSaveBP());		
	}
}
