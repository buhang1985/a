package iih.en.pv.deptrans.i;

import xap.mw.core.data.BizException;
import iih.en.pv.deptrans.d.EnDepTransDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 就诊转科数据维护服务
*/
public interface IEndeptransCudService {
	/**
	*  就诊转科数据真删除
	*/
    public abstract void delete(EnDepTransDO[] aggdos) throws BizException;
    
    /**
	*  就诊转科数据插入保存
	*/
	public abstract EnDepTransDO[] insert(EnDepTransDO[] aggdos) throws BizException;
	
    /**
	*  就诊转科数据保存
	*/
	public abstract EnDepTransDO[] save(EnDepTransDO[] aggdos) throws BizException;
	
    /**
	*  就诊转科数据更新
	*/
	public abstract EnDepTransDO[] update(EnDepTransDO[] aggdos) throws BizException;
	
	/**
	*  就诊转科数据逻辑删除
	*/
	public abstract void logicDelete(EnDepTransDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EnDepTransDO[] enableWithoutFilter(EnDepTransDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EnDepTransDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EnDepTransDO[] disableVOWithoutFilter(EnDepTransDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EnDepTransDO[] dos) throws BizException ;
}
