package iih.bd.mm.supplier.s.bp;

import iih.bd.mm.supplier.d.SupplierDO;
import xap.mw.core.data.BizException;

public class SupplierDeBeforeBp {
	
	public void exec(SupplierDO[] suppliers) throws BizException {
		
		if(suppliers == null || suppliers.length <= 0) {
			
			return;
		}
		
		// ■ 验证供应商生产厂商字典是否允许删除
		this.checkCanDelete(suppliers);
	}

	private void checkCanDelete(SupplierDO[] suppliers) throws BizException {
		
		IsSupplierRefedBp bp = new IsSupplierRefedBp();
		for(SupplierDO supplierDO : suppliers) {
			
			//是否作为供应商被引用
			bp.isRefAsSupplier(supplierDO);
			
			//是否作为生产商被引用
			bp.isRefAsFactory(supplierDO);
		}
	}
}
