package iih.bd.mm.supplier.s.bp;

import iih.bd.mm.supplier.d.SupplierDO;
import xap.mw.core.data.BizException;

public class SupplierCuBeforeBp {
	
	public void exec(SupplierDO[] vos, SupplierDO[] originVOs) throws BizException {
		
		// ■ 参数校验
		this.validaPara(vos, originVOs);
		
		// ■ 校验供应商、生产厂商标志是否允许修改
		this.checkCanUpdate(vos, originVOs);
	}

	private void validaPara(SupplierDO[] vos, SupplierDO[] originVOs) throws BizException {
		
		if(vos == null || vos.length <= 0) {
			
			throw new BizException("传入供应商厂商字典数据为空。");
		}
		
		if(originVOs == null || originVOs.length <= 0) {
			
			throw new BizException("传入供应商厂商字典数据为空。");
		}
	}
	
	private void checkCanUpdate(SupplierDO[] vos, SupplierDO[] originVOs) throws BizException {
		
		int index = 0;
		IsSupplierRefedBp bp = new IsSupplierRefedBp();
		for(SupplierDO supplierDO : vos) {
			
			SupplierDO originVO = originVOs[index];
			//供应商标志是否允许修改
			if(supplierDO.getFg_sup().booleanValue() != originVO.getFg_sup().booleanValue() &&
					!supplierDO.getFg_sup().booleanValue()) {
				
				//是否作为供应商被引用
				bp.isRefAsSupplier(supplierDO);
			}
			
			//生产厂商标志是否允许修改
			if(supplierDO.getFg_fac().booleanValue() != originVO.getFg_fac().booleanValue() &&
					!supplierDO.getFg_fac().booleanValue()) {
				
				//是否作为生产商被引用
				bp.isRefAsFactory(supplierDO);
			}
		}
	}
}
