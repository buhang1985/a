package iih.mp.mb.keyboard.i;

import xap.mw.core.data.BizException;
import iih.mp.mb.keyboard.d.KeyBoardDO;
import iih.mp.mb.keyboard.d.KeyboardAggDO;

/**
* 移动护理键盘数据维护服务
*/
public interface IKeyboardCudService {
	/**
	*  移动护理键盘数据真删除
	*/
    public abstract void delete(KeyboardAggDO[] aggdos) throws BizException;
    
    /**
	*  移动护理键盘数据插入保存
	*/
	public abstract KeyboardAggDO[] insert(KeyboardAggDO[] aggdos) throws BizException;
	
    /**
	*  移动护理键盘数据保存
	*/
	public abstract KeyboardAggDO[] save(KeyboardAggDO[] aggdos) throws BizException;
	
    /**
	*  移动护理键盘数据更新
	*/
	public abstract KeyboardAggDO[] update(KeyboardAggDO[] aggdos) throws BizException;
	
	/**
	*  移动护理键盘数据逻辑删除
	*/
	public abstract void logicDelete(KeyboardAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对移动护理键盘数据真删除
	 */
	public abstract void deleteByParentDO(KeyBoardDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对移动护理键盘数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(KeyBoardDO[] mainDos) throws BizException;
}
