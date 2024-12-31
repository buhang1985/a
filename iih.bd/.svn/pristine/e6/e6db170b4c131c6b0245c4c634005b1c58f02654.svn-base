package iih.bd.mm.supplierprotocol.s.rule;

import iih.bd.mm.supplierprotocol.d.SupplierprotocolAggDO;
import iih.bd.mm.supplierprotocol.s.bp.SupproCuAfterBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

public class SupproAggAfterInsertOrUpdateRule implements IRule<SupplierprotocolAggDO> {

	@Override
	public void process(SupplierprotocolAggDO... supproAggDOS) throws BizException {
		
		SupproCuAfterBp bp = new SupproCuAfterBp();

		bp.exec(supproAggDOS);
	}
}
