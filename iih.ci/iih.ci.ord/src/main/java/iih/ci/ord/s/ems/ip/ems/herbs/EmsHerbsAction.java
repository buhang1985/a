package iih.ci.ord.s.ems.ip.ems.herbs;

import iih.ci.ord.s.ems.base.BaseEmsAction;
/**
 * 西药action
 * @author yzh
 *
 */
public class EmsHerbsAction extends BaseEmsAction {
	public EmsHerbsAction() {
		super();
		setEmsValidate(new EmsHerbsValidate());
		setEmsCreateBP(new EmsHerbsCreateBP());
		setEmsLoadBP(new EmsHerbsLoadBP());
		setEmsSaveBP(new EmsHerbsSaveBP());
	}
}
