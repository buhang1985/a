package iih.bd.mm.supplierprotocol.s.rule;

import iih.bd.mm.supplierprotocol.d.SuppierProtocolDO;
import iih.bd.mm.supplierprotocol.s.bp.SupproCuAfterBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

public class SupproMDOAfterInsertOrUpdateRule implements IRule<SuppierProtocolDO> {

	@Override
	public void process(SuppierProtocolDO... supproDOS) throws BizException {
		
		SupproCuAfterBp bp = new SupproCuAfterBp();

		bp.exec(supproDOS);
	}

}
