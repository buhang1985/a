package iih.ci.ord.s.ems.ip.assi.tpl.dead;

import iih.ci.ord.s.ems.base.BaseEmsAction;

public class TplDeadAction extends BaseEmsAction  {
	public TplDeadAction(){
		super();
		setEmsSaveBP(new TplDeadSaveBP());		
	}
}
