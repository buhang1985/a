package iih.bd.mm.supplierprotocol.s.bp;

import iih.bd.mm.supplierprotocol.d.SupplierprotocolAggDO;
import iih.bd.mm.supplierprotocol.s.ds.SupplierProtocolCache;
import xap.mw.core.data.BizException;

public class SupproDeAfterBp {

	public void exec(SupplierprotocolAggDO[] supproAggDOS) throws BizException {
		
		// ■ 参数校验
		this.validaPara(supproAggDOS);
		
		// ■ 本地缓存信息更新
		this.updateCache(supproAggDOS);
	}
	
	private void validaPara(SupplierprotocolAggDO[] supproAggDOS) throws BizException {
		
		if(supproAggDOS == null || supproAggDOS.length <= 0) {
			
			throw new BizException("传入供应商与物品协议信息为空。");
		}
	}
	
	private void updateCache(SupplierprotocolAggDO[] supproAggDOS) throws BizException {
		
		SupplierProtocolCache.getInstance().deleteCache(supproAggDOS);
	}
}
