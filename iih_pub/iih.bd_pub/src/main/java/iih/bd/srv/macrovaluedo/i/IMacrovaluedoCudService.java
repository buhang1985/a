package iih.bd.srv.macrovaluedo.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.macrovaluedo.d.MacroValueDo;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 宏元素自定义数据维护服务
*/
public interface IMacrovaluedoCudService {
	/**
	*  宏元素自定义数据真删除
	*/
    public abstract void delete(MacroValueDo[] aggdos) throws BizException;
    
    /**
	*  宏元素自定义数据插入保存
	*/
	public abstract MacroValueDo[] insert(MacroValueDo[] aggdos) throws BizException;
	
    /**
	*  宏元素自定义数据保存
	*/
	public abstract MacroValueDo[] save(MacroValueDo[] aggdos) throws BizException;
	
    /**
	*  宏元素自定义数据更新
	*/
	public abstract MacroValueDo[] update(MacroValueDo[] aggdos) throws BizException;
	
	/**
	*  宏元素自定义数据逻辑删除
	*/
	public abstract void logicDelete(MacroValueDo[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MacroValueDo[] enableWithoutFilter(MacroValueDo[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MacroValueDo[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MacroValueDo[] disableVOWithoutFilter(MacroValueDo[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MacroValueDo[] dos) throws BizException ;
}
