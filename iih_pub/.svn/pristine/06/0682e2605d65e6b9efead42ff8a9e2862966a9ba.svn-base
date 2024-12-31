package iih.bl.inc.blincoep.i;

import xap.mw.core.data.BizException;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;

/**
* 组件数据维护服务
*/
public interface IBlincoepCudService {
	/**
	*  组件数据真删除
	*/
    public abstract void delete(BlincoepAggDO[] aggdos) throws BizException;
    
    /**
	*  组件数据插入保存
	*/
	public abstract BlincoepAggDO[] insert(BlincoepAggDO[] aggdos) throws BizException;
	
    /**
	*  组件数据保存
	*/
	public abstract BlincoepAggDO[] save(BlincoepAggDO[] aggdos) throws BizException;
	
    /**
	*  组件数据更新
	*/
	public abstract BlincoepAggDO[] update(BlincoepAggDO[] aggdos) throws BizException;
	
	/**
	*  组件数据逻辑删除
	*/
	public abstract void logicDelete(BlincoepAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对组件数据真删除
	 */
	public abstract void deleteByParentDO(BlIncOepDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对组件数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(BlIncOepDO[] mainDos) throws BizException;
}
