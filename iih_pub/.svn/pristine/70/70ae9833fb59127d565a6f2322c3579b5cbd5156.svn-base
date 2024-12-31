package iih.bd.mm.supplierprotocol.i;

import xap.mw.core.data.BizException;
import iih.bd.mm.supplierprotocol.d.SuppierProtocolDO;
import iih.bd.mm.supplierprotocol.d.SupplierprotocolAggDO;

/**
* 供应商关系及协议数据维护服务
*/
public interface ISupplierprotocolCudService {
	/**
	*  供应商关系及协议数据真删除
	*/
    public abstract void delete(SupplierprotocolAggDO[] aggdos) throws BizException;
    
    /**
	*  供应商关系及协议数据插入保存
	*/
	public abstract SupplierprotocolAggDO[] insert(SupplierprotocolAggDO[] aggdos) throws BizException;
	
    /**
	*  供应商关系及协议数据保存
	*/
	public abstract SupplierprotocolAggDO[] save(SupplierprotocolAggDO[] aggdos) throws BizException;
	
    /**
	*  供应商关系及协议数据更新
	*/
	public abstract SupplierprotocolAggDO[] update(SupplierprotocolAggDO[] aggdos) throws BizException;
	
	/**
	*  供应商关系及协议数据逻辑删除
	*/
	public abstract void logicDelete(SupplierprotocolAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对供应商关系及协议数据真删除
	 */
	public abstract void deleteByParentDO(SuppierProtocolDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对供应商关系及协议数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(SuppierProtocolDO[] mainDos) throws BizException;
}
