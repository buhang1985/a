package iih.bd.mm.supplier.s.rule;

import iih.bd.mm.supplier.d.SupplierDO;
import iih.bd.mm.supplier.s.bp.SupplierCuBeforeBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.ICompareRule;

/**
 * 供应商与厂商新增和更新规则
 * 
 * @author hao_wu
 *
 */
public class SupplierBeforeInsertOrUpdateRule implements ICompareRule<SupplierDO> {

	@Override
	public void process(SupplierDO[] vos, SupplierDO[] originVOs) throws BizException {
		SupplierCuBeforeBp bp = new SupplierCuBeforeBp();

		bp.exec(vos, originVOs);
	}

}
