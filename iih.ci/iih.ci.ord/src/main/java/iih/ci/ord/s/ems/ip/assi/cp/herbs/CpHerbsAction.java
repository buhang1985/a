package iih.ci.ord.s.ems.ip.assi.cp.herbs;

import iih.ci.ord.s.ems.base.BaseEmsAction;
import iih.ci.ord.s.ems.ip.assi.cp.drugs.CpDrugsSaveBP;

/**
 * 临床路径草药执行器
 * @author wangqingzhu
 *
 */
public class CpHerbsAction extends BaseEmsAction {
	
	public CpHerbsAction() {
		super();
		setEmsSaveBP(new CpHerbsSaveBP());	
	}

}
