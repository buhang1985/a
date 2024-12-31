package iih.bd.mm.supplierprotocol.s.rule;

import iih.bd.mm.supplierprotocol.d.SupplierprotocolAggDO;
import iih.bd.mm.supplierprotocol.s.bp.SupproDeAfterBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

public class SupproAggAfterDeleteRule implements IRule<SupplierprotocolAggDO> {

	@Override
	public void process(SupplierprotocolAggDO... supproAggDOS) throws BizException {
		
		SupproDeAfterBp bp = new SupproDeAfterBp();

		bp.exec(supproAggDOS);
	}
}
