package iih.nm.nit.nitnureval.i;

import xap.mw.core.data.BizException;
import iih.nm.nit.nitnureval.d.NitNurEvalDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 实习生评定数据维护服务
*/
public interface INitnurevalCudService {
	/**
	*  实习生评定数据真删除
	*/
    public abstract void delete(NitNurEvalDO[] aggdos) throws BizException;
    
    /**
	*  实习生评定数据插入保存
	*/
	public abstract NitNurEvalDO[] insert(NitNurEvalDO[] aggdos) throws BizException;
	
    /**
	*  实习生评定数据保存
	*/
	public abstract NitNurEvalDO[] save(NitNurEvalDO[] aggdos) throws BizException;
	
    /**
	*  实习生评定数据更新
	*/
	public abstract NitNurEvalDO[] update(NitNurEvalDO[] aggdos) throws BizException;
	
	/**
	*  实习生评定数据逻辑删除
	*/
	public abstract void logicDelete(NitNurEvalDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NitNurEvalDO[] enableWithoutFilter(NitNurEvalDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NitNurEvalDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NitNurEvalDO[] disableVOWithoutFilter(NitNurEvalDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NitNurEvalDO[] dos) throws BizException ;
}
