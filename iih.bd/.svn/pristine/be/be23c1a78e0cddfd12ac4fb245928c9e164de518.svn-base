package iih.bd.mm.supplier.s.rule;

import iih.bd.mm.supplier.d.SupplierDO;
import iih.bd.mm.supplier.s.bp.SupplierDeBeforeBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 供应商与厂商删除前规则
 * 
 * @author hao_wu
 *
 */
public class SupplierBeforeDeleteRule implements IRule<SupplierDO> {

	@Override
	public void process(SupplierDO... suppliers) throws BizException {
		SupplierDeBeforeBp bp = new SupplierDeBeforeBp();

		bp.exec(suppliers);
	}
}
