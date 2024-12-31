package iih.bd.pp.hpsrvorca.s.rule;

import iih.bd.pp.hpsrvorca.bp.HpSrvCtrDiDeleteBp;
import iih.bd.pp.hpsrvorca.bp.HpSrvorcaDeleteBp;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 删除医保计划_控制策略数据规则
 * @author guoyang
 *
 */
public class HpsrvcaDeleteRule implements IRule<HPSrvorcaDO> {

	@Override
	public void process(HPSrvorcaDO... arg0) throws BizException {
		HpSrvorcaDeleteBp hpSrvorcaDeleteBp = new HpSrvorcaDeleteBp();
		hpSrvorcaDeleteBp.exec(arg0);
		HpSrvCtrDiDeleteBp hpSrvCtrDiDeleteBp = new HpSrvCtrDiDeleteBp();
		hpSrvCtrDiDeleteBp.exec(arg0);
	}

}
