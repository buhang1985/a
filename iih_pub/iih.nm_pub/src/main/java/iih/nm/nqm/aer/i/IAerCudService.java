package iih.nm.nqm.aer.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.aer.d.NmAerDO;
import iih.nm.nqm.aer.d.AerAggDO;

/**
* 不良事件上报数据维护服务
*/
public interface IAerCudService {
	/**
	*  不良事件上报数据真删除
	*/
    public abstract void delete(AerAggDO[] aggdos) throws BizException;
    
    /**
	*  不良事件上报数据插入保存
	*/
	public abstract AerAggDO[] insert(AerAggDO[] aggdos) throws BizException;
	
    /**
	*  不良事件上报数据保存
	*/
	public abstract AerAggDO[] save(AerAggDO[] aggdos) throws BizException;
	
    /**
	*  不良事件上报数据更新
	*/
	public abstract AerAggDO[] update(AerAggDO[] aggdos) throws BizException;
	
	/**
	*  不良事件上报数据逻辑删除
	*/
	public abstract void logicDelete(AerAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对不良事件上报数据真删除
	 */
	public abstract void deleteByParentDO(NmAerDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对不良事件上报数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NmAerDO[] mainDos) throws BizException;
}
