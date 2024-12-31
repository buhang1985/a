package iih.ci.ord.s.ems.ip.assi.tpl.transdept;

import iih.ci.ord.s.ems.base.BaseEmsDriver;

public class TplTransDeptDriver extends BaseEmsDriver {
	public TplTransDeptDriver(){
		this.setEmsAction(new TplTransDeptAction());
	}
}
