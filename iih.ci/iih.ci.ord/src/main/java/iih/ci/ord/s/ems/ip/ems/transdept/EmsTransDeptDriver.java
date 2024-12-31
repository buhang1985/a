package iih.ci.ord.s.ems.ip.ems.transdept;

import iih.ci.ord.s.ems.base.BaseEmsDriver;

public class EmsTransDeptDriver extends BaseEmsDriver {

	public EmsTransDeptDriver(){
		this.setEmsAction(new EmsTransDeptAction());
	}
}
