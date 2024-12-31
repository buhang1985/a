package iih.ci.ord.s.ems.op.tmpl.opr;

import iih.ci.ord.s.ems.base.BaseEmsAction;

/**
 * 手术医疗单业务逻辑执行器
 * @author wangqingzhu
 *
 */
public class TmplOprAction extends BaseEmsAction {


	public TmplOprAction() {
		
//		setEmsLoadBP(new TmplOprLoadBP());
		setEmsSaveBP(new TmplOprSaveBP(new TmplOprValidate()));
	}

	
}
