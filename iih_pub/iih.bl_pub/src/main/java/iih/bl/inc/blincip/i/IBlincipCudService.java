package iih.bl.inc.blincip.i;

import xap.mw.core.data.BizException;
import iih.bl.inc.blincip.d.BlIncIpDO;
import iih.bl.inc.blincip.d.BlincipAggDO;

/**
* 住院发票数据维护服务
*/
public interface IBlincipCudService {
	/**
	*  住院发票数据真删除
	*/
    public abstract void delete(BlincipAggDO[] aggdos) throws BizException;
    
    /**
	*  住院发票数据插入保存
	*/
	public abstract BlincipAggDO[] insert(BlincipAggDO[] aggdos) throws BizException;
	
    /**
	*  住院发票数据保存
	*/
	public abstract BlincipAggDO[] save(BlincipAggDO[] aggdos) throws BizException;
	
    /**
	*  住院发票数据更新
	*/
	public abstract BlincipAggDO[] update(BlincipAggDO[] aggdos) throws BizException;
	
	/**
	*  住院发票数据逻辑删除
	*/
	public abstract void logicDelete(BlincipAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对住院发票数据真删除
	 */
	public abstract void deleteByParentDO(BlIncIpDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对住院发票数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(BlIncIpDO[] mainDos) throws BizException;
}
