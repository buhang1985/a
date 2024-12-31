package iih.bd.pp.hpdupitmpri.rule;

import iih.bd.pp.hpdupitmpri.bp.HpdupitmpriBp;
import iih.bd.pp.hpdupitmpri.d.HpDupItmPriDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

public class HpdupitmpriRule implements IRule<HpDupItmPriDO> {

	@Override
	public void process(HpDupItmPriDO... arg0) throws BizException {
		HpdupitmpriBp hpdupitmpriBp = new HpdupitmpriBp();
		for (HpDupItmPriDO hpDupItmPriDO : arg0) {
			hpdupitmpriBp.exe(hpDupItmPriDO);
		}
	}

}
