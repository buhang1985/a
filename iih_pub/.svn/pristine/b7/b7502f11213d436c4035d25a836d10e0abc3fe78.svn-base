package iih.bl.prop.blproparoep.i;

import xap.mw.core.data.BizException;
import iih.bl.prop.blproparoep.d.BlPropArItmOepDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 组件数据维护服务
*/
public interface IBlPropArItmOepDOCudService {
	/**
	*  组件数据真删除
	*/
    public abstract void delete(BlPropArItmOepDO[] aggdos) throws BizException;
    
    /**
	*  组件数据插入保存
	*/
	public abstract BlPropArItmOepDO[] insert(BlPropArItmOepDO[] aggdos) throws BizException;
	
    /**
	*  组件数据保存
	*/
	public abstract BlPropArItmOepDO[] save(BlPropArItmOepDO[] aggdos) throws BizException;
	
    /**
	*  组件数据更新
	*/
	public abstract BlPropArItmOepDO[] update(BlPropArItmOepDO[] aggdos) throws BizException;
	
	/**
	*  组件数据逻辑删除
	*/
	public abstract void logicDelete(BlPropArItmOepDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlPropArItmOepDO[] enableWithoutFilter(BlPropArItmOepDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlPropArItmOepDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlPropArItmOepDO[] disableVOWithoutFilter(BlPropArItmOepDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlPropArItmOepDO[] aggdos) throws BizException ;
	
}
