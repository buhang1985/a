package iih.ci.ord.s.ems.op.ems.opr;

import iih.ci.ord.s.ems.base.BaseEmsAction;

/**
 * 手术医疗单业务逻辑执行器
 * @author wangqingzhu
 *
 */
public class EmsOprAction extends BaseEmsAction {


	public EmsOprAction() {
		super();
		
		setEmsCreateBP(new EmsOprCreateBP());
		setEmsLoadBP(new EmsOprLoadBP());
		setEmsSaveBP(new EmsOprSaveBP());
	}

	
}
