package iih.bd.pp.cust.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.cust.d.CustCaDO;
import iih.bd.pp.cust.d.CustAggDO;

/**
* 付款客户数据维护服务
*/
public interface ICustCudService {
	/**
	*  付款客户数据真删除
	*/
    public abstract void delete(CustAggDO[] aggdos) throws BizException;
    
    /**
	*  付款客户数据插入保存
	*/
	public abstract CustAggDO[] insert(CustAggDO[] aggdos) throws BizException;
	
    /**
	*  付款客户数据保存
	*/
	public abstract CustAggDO[] save(CustAggDO[] aggdos) throws BizException;
	
    /**
	*  付款客户数据更新
	*/
	public abstract CustAggDO[] update(CustAggDO[] aggdos) throws BizException;
	
	/**
	*  付款客户数据逻辑删除
	*/
	public abstract void logicDelete(CustAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对付款客户数据真删除
	 */
	public abstract void deleteByParentDO(CustCaDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对付款客户数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(CustCaDO[] mainDos) throws BizException;
}
