package iih.ci.ord.s.ems.op.tmpl.apbt;

import iih.ci.ord.s.ems.base.BaseEmsAction;

/**
 * 备血医疗单逻辑执行器
 * @author wangqingzhu
 *
 */
public class TmplApBtAction extends BaseEmsAction {
	
	public TmplApBtAction() {
		
//		setEmsLoadBP(new TmplApBtLoadBP());
		setEmsSaveBP(new TmplApBtSaveBP(new TmplApBtValidate()));
	}

}
