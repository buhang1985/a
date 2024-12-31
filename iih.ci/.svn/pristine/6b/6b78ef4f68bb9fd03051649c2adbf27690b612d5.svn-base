package iih.ci.ord.s.ems.op.ems.apbt;

import iih.ci.ord.s.ems.base.BaseEmsAction;

/**
 * 备血医疗单逻辑执行器
 * @author wangqingzhu
 *
 */
public class EmsApBtAction extends BaseEmsAction {
	
	public EmsApBtAction() {
		setEmsCreateBP(new EmsApBtCreateBP());
		setEmsLoadBP(new EmsApBtLoadBP());
		setEmsSaveBP(new EmsApBtSaveBP(new EmsApBtValidate()));
	}

}
