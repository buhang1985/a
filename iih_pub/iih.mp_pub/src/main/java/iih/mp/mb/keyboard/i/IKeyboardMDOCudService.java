package iih.mp.mb.keyboard.i;

import xap.mw.core.data.BizException;
import iih.mp.mb.keyboard.d.KeyBoardDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 移动护理键盘数据维护服务
*/
public interface IKeyboardMDOCudService {
	/**
	*  移动护理键盘数据真删除
	*/
    public abstract void delete(KeyBoardDO[] aggdos) throws BizException;
    
    /**
	*  移动护理键盘数据插入保存
	*/
	public abstract KeyBoardDO[] insert(KeyBoardDO[] aggdos) throws BizException;
	
    /**
	*  移动护理键盘数据保存
	*/
	public abstract KeyBoardDO[] save(KeyBoardDO[] aggdos) throws BizException;
	
    /**
	*  移动护理键盘数据更新
	*/
	public abstract KeyBoardDO[] update(KeyBoardDO[] aggdos) throws BizException;
	
	/**
	*  移动护理键盘数据逻辑删除
	*/
	public abstract void logicDelete(KeyBoardDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public KeyBoardDO[] enableWithoutFilter(KeyBoardDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(KeyBoardDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public KeyBoardDO[] disableVOWithoutFilter(KeyBoardDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(KeyBoardDO[] aggdos) throws BizException ;
	
}
