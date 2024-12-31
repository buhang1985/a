package iih.nm.nhr.nmnurwkexp.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmnurwkexp.d.NmNurWkexpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 护理人员_工作经历数据维护服务
*/
public interface INmnurwkexpCudService {
	/**
	*  护理人员_工作经历数据真删除
	*/
    public abstract void delete(NmNurWkexpDO[] aggdos) throws BizException;
    
    /**
	*  护理人员_工作经历数据插入保存
	*/
	public abstract NmNurWkexpDO[] insert(NmNurWkexpDO[] aggdos) throws BizException;
	
    /**
	*  护理人员_工作经历数据保存
	*/
	public abstract NmNurWkexpDO[] save(NmNurWkexpDO[] aggdos) throws BizException;
	
    /**
	*  护理人员_工作经历数据更新
	*/
	public abstract NmNurWkexpDO[] update(NmNurWkexpDO[] aggdos) throws BizException;
	
	/**
	*  护理人员_工作经历数据逻辑删除
	*/
	public abstract void logicDelete(NmNurWkexpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNurWkexpDO[] enableWithoutFilter(NmNurWkexpDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNurWkexpDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNurWkexpDO[] disableVOWithoutFilter(NmNurWkexpDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNurWkexpDO[] dos) throws BizException ;
}
