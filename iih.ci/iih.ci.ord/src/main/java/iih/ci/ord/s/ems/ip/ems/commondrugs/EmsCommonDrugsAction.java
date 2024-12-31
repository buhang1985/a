package iih.ci.ord.s.ems.ip.ems.commondrugs;

import iih.ci.ord.s.ems.base.BaseEmsAction;
/**
 * 西药action
 * @author yzh
 *
 */
public class EmsCommonDrugsAction extends BaseEmsAction {
	public EmsCommonDrugsAction() {
		super();
		setEmsValidate(new EmsCommonDrugsValidate());
		setEmsCreateBP(new EmsCommonDrugsCreateBP());
		setEmsLoadBP(new EmsCommonDrugsLoadBP());
		setEmsSaveBP(new EmsCommonDrugsSaveBP());
	}
}
