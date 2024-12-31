package iih.bd.srv.ems.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.ems.d.EmsIndexDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医疗单注册数据维护服务
*/
public interface IEmsIndexDOCudService {
	/**
	*  医疗单注册数据真删除
	*/
    public abstract void delete(EmsIndexDO[] aggdos) throws BizException;
    
    /**
	*  医疗单注册数据插入保存
	*/
	public abstract EmsIndexDO[] insert(EmsIndexDO[] aggdos) throws BizException;
	
    /**
	*  医疗单注册数据保存
	*/
	public abstract EmsIndexDO[] save(EmsIndexDO[] aggdos) throws BizException;
	
    /**
	*  医疗单注册数据更新
	*/
	public abstract EmsIndexDO[] update(EmsIndexDO[] aggdos) throws BizException;
	
	/**
	*  医疗单注册数据逻辑删除
	*/
	public abstract void logicDelete(EmsIndexDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EmsIndexDO[] enableWithoutFilter(EmsIndexDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EmsIndexDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EmsIndexDO[] disableVOWithoutFilter(EmsIndexDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EmsIndexDO[] aggdos) throws BizException ;
	
}
