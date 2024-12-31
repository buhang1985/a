package iih.mp.mpbd.kb.i;

import xap.mw.core.data.BizException;
import iih.mp.mpbd.kb.d.KbDO;
import iih.mp.mpbd.kb.d.KbAggDO;

/**
* 移动键盘数据维护服务
*/
public interface IKbCudService {
	/**
	*  移动键盘数据真删除
	*/
    public abstract void delete(KbAggDO[] aggdos) throws BizException;
    
    /**
	*  移动键盘数据插入保存
	*/
	public abstract KbAggDO[] insert(KbAggDO[] aggdos) throws BizException;
	
    /**
	*  移动键盘数据保存
	*/
	public abstract KbAggDO[] save(KbAggDO[] aggdos) throws BizException;
	
    /**
	*  移动键盘数据更新
	*/
	public abstract KbAggDO[] update(KbAggDO[] aggdos) throws BizException;
	
	/**
	*  移动键盘数据逻辑删除
	*/
	public abstract void logicDelete(KbAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对移动键盘数据真删除
	 */
	public abstract void deleteByParentDO(KbDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对移动键盘数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(KbDO[] mainDos) throws BizException;
}
