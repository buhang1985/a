package iih.bd.pp.hpsrvorca.s.rule;

import iih.bd.pp.hpsrvorca.bp.BuildHpSrvCtlBySrvOrCaBp;
import iih.bd.pp.hpsrvorca.bp.HpSrvorcaDeleteBp;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 生成医保计划_控制策略数据
 * @author guoyang
 *
 */
public class HpsrvcaAddRule implements IRule<HPSrvorcaDO> {

	@Override
	public void process(HPSrvorcaDO... arg0) throws BizException {
		HpSrvorcaDeleteBp hpSrvorcaDeleteBp = new HpSrvorcaDeleteBp();
		hpSrvorcaDeleteBp.exec(arg0);
		BuildHpSrvCtlBySrvOrCaBp buildHpSrvCtlBySrvOrCaBp = new BuildHpSrvCtlBySrvOrCaBp();
		buildHpSrvCtlBySrvOrCaBp.exec(arg0);
	}

}
