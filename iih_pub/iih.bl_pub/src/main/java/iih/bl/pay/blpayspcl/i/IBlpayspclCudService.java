package iih.bl.pay.blpayspcl.i;

import xap.mw.core.data.BizException;
import iih.bl.pay.blpayspcl.d.BlPaySpclDO;
import iih.bl.pay.blpayspcl.d.BlpayspclAggDO;

/**
* 收付款_专用款数据维护服务
*/
public interface IBlpayspclCudService {
	/**
	*  收付款_专用款数据真删除
	*/
    public abstract void delete(BlpayspclAggDO[] aggdos) throws BizException;
    
    /**
	*  收付款_专用款数据插入保存
	*/
	public abstract BlpayspclAggDO[] insert(BlpayspclAggDO[] aggdos) throws BizException;
	
    /**
	*  收付款_专用款数据保存
	*/
	public abstract BlpayspclAggDO[] save(BlpayspclAggDO[] aggdos) throws BizException;
	
    /**
	*  收付款_专用款数据更新
	*/
	public abstract BlpayspclAggDO[] update(BlpayspclAggDO[] aggdos) throws BizException;
	
	/**
	*  收付款_专用款数据逻辑删除
	*/
	public abstract void logicDelete(BlpayspclAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对收付款_专用款数据真删除
	 */
	public abstract void deleteByParentDO(BlPaySpclDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对收付款_专用款数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(BlPaySpclDO[] mainDos) throws BizException;
}
