package iih.ci.preop.ems.ris;

import iih.ci.sdk.action.BaseEmsAction;

/**
 * 门诊预住院检查申请业务处理响应action
 * @author wangqingzhu
 *
 */
public class EmsRisAction extends BaseEmsAction {

	public EmsRisAction() {
		this.setEmsCreateBP(new EmsRisCreateBP());
		this.setEmsLoadBP(new EmsRisLoadBP());
		this.setEmsSaveBP(new EmsRisSaveBP());
	}
}
