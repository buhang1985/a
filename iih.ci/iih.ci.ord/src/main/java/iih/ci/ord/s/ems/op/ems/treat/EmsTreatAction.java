package iih.ci.ord.s.ems.op.ems.treat;

import iih.ci.ord.s.ems.op.base.OpBaseEmsSetAction;

/**
 * 治疗医疗单逻辑执行器
 * 
 * @author wangqingzhu
 *
 */
public class EmsTreatAction extends OpBaseEmsSetAction {

	public EmsTreatAction() {
		setEmsCreateBP(new EmsTreatCreateBP());
		setEmsLoadBP(new EmsTreatLoadBP());
		setEmsSaveBP(new EmsTreatSaveBP());
	}

}
