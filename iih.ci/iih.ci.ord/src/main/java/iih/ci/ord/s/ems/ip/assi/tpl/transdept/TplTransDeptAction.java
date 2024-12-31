package iih.ci.ord.s.ems.ip.assi.tpl.transdept;

import iih.ci.ord.s.ems.base.BaseEmsAction;

public class TplTransDeptAction extends BaseEmsAction  {
	public TplTransDeptAction(){
		super();
		setEmsSaveBP(new TplTransDeptSaveBP());		
	}
}
