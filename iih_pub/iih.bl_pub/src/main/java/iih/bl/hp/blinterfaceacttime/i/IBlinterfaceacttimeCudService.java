package iih.bl.hp.blinterfaceacttime.i;

import xap.mw.core.data.BizException;
import iih.bl.hp.blinterfaceacttime.d.BlInterfaceActTimeDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 接口业务时间数据维护服务
*/
public interface IBlinterfaceacttimeCudService {
	/**
	*  接口业务时间数据真删除
	*/
    public abstract void delete(BlInterfaceActTimeDO[] aggdos) throws BizException;
    
    /**
	*  接口业务时间数据插入保存
	*/
	public abstract BlInterfaceActTimeDO[] insert(BlInterfaceActTimeDO[] aggdos) throws BizException;
	
    /**
	*  接口业务时间数据保存
	*/
	public abstract BlInterfaceActTimeDO[] save(BlInterfaceActTimeDO[] aggdos) throws BizException;
	
    /**
	*  接口业务时间数据更新
	*/
	public abstract BlInterfaceActTimeDO[] update(BlInterfaceActTimeDO[] aggdos) throws BizException;
	
	/**
	*  接口业务时间数据逻辑删除
	*/
	public abstract void logicDelete(BlInterfaceActTimeDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlInterfaceActTimeDO[] enableWithoutFilter(BlInterfaceActTimeDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlInterfaceActTimeDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlInterfaceActTimeDO[] disableVOWithoutFilter(BlInterfaceActTimeDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlInterfaceActTimeDO[] dos) throws BizException ;
}
