package iih.bd.mm.supplierprotocol.i.ds;

import iih.bd.mm.supplierprotocol.d.SupplierprotocolAggDO;
import xap.mw.core.data.BizException;

public interface ISupplierProFlowService {
	
	/**
	 * 提交供应商物品协议
	 */
	public SupplierprotocolAggDO[] submitSupplierPro(String[] ids) throws BizException;
	
	/**
	 * 提交供应商物品协议
	 */
	public SupplierprotocolAggDO acceptSupplierPro(SupplierprotocolAggDO supplierProAggDO) throws BizException;
	
	/**
	 * 提交供应商物品协议
	 */
	public SupplierprotocolAggDO rejectSupplierPro(SupplierprotocolAggDO supplierProAggDO) throws BizException;
}
