package iih.ci.ord.s.ems.ip.assi.tpl.pathgy;

import iih.ci.ord.s.ems.base.BaseEmsAction;

public class TplPathgyAction extends BaseEmsAction  {
	public TplPathgyAction(){
		super();
		setEmsSaveBP(new TplPathgySaveBP());		
	}
}
