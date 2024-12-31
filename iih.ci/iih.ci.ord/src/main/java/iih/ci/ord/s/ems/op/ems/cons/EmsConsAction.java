package iih.ci.ord.s.ems.op.ems.cons;

import iih.ci.ord.s.ems.base.BaseEmsAction;

public class EmsConsAction extends BaseEmsAction {

    public EmsConsAction() {
		super();
		// TODO Auto-generated constructor stub
		
		setEmsCreateBP(new EmsConsCreateBP());
		setEmsLoadBP(new EmsConsLoadBP());
		setEmsSaveBP(new EmsConsSaveBP());
	}

}
