package iih.ci.ord.s.ems.ip.assi.tpl.commondrugs;

import iih.ci.ord.s.ems.base.BaseEmsAction;

public class TplDrugsAction extends BaseEmsAction  {
	public TplDrugsAction(){
		super();
		setEmsSaveBP(new TplDrugsSaveBP());		
	}
}
