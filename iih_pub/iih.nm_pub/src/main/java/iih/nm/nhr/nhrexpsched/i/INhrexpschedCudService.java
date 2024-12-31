package iih.nm.nhr.nhrexpsched.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nhrexpsched.d.NhrExpSchedDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 期望排班数据维护服务
*/
public interface INhrexpschedCudService {
	/**
	*  期望排班数据真删除
	*/
    public abstract void delete(NhrExpSchedDO[] aggdos) throws BizException;
    
    /**
	*  期望排班数据插入保存
	*/
	public abstract NhrExpSchedDO[] insert(NhrExpSchedDO[] aggdos) throws BizException;
	
    /**
	*  期望排班数据保存
	*/
	public abstract NhrExpSchedDO[] save(NhrExpSchedDO[] aggdos) throws BizException;
	
    /**
	*  期望排班数据更新
	*/
	public abstract NhrExpSchedDO[] update(NhrExpSchedDO[] aggdos) throws BizException;
	
	/**
	*  期望排班数据逻辑删除
	*/
	public abstract void logicDelete(NhrExpSchedDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NhrExpSchedDO[] enableWithoutFilter(NhrExpSchedDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NhrExpSchedDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NhrExpSchedDO[] disableVOWithoutFilter(NhrExpSchedDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NhrExpSchedDO[] dos) throws BizException ;
}
