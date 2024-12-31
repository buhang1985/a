package iih.bd.mm.supplier.s.rule;

import iih.bd.mm.supplier.d.SupplierDO;
import iih.bd.mm.supplier.s.bp.SupplierCuAfterBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.ICompareRule;

public class SupplierAfterInsertOrUpdateRule implements ICompareRule<SupplierDO> {

	@Override
	public void process(SupplierDO[] vos, SupplierDO[] originVOs) throws BizException {
		SupplierCuAfterBp bp = new SupplierCuAfterBp();

		bp.exec(vos, originVOs);
	}
}
