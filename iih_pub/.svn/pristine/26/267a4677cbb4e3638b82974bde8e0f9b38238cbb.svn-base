package iih.ci.mrm.cimrmsp.i;

import xap.mw.core.data.BizException;
import iih.ci.mrm.cimrmsp.d.CiMrmMailDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 病案邮寄数据维护服务
*/
public interface ICimrmspCudService {
	/**
	*  病案邮寄数据真删除
	*/
    public abstract void delete(CiMrmMailDO[] aggdos) throws BizException;
    
    /**
	*  病案邮寄数据插入保存
	*/
	public abstract CiMrmMailDO[] insert(CiMrmMailDO[] aggdos) throws BizException;
	
    /**
	*  病案邮寄数据保存
	*/
	public abstract CiMrmMailDO[] save(CiMrmMailDO[] aggdos) throws BizException;
	
    /**
	*  病案邮寄数据更新
	*/
	public abstract CiMrmMailDO[] update(CiMrmMailDO[] aggdos) throws BizException;
	
	/**
	*  病案邮寄数据逻辑删除
	*/
	public abstract void logicDelete(CiMrmMailDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiMrmMailDO[] enableWithoutFilter(CiMrmMailDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiMrmMailDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiMrmMailDO[] disableVOWithoutFilter(CiMrmMailDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiMrmMailDO[] dos) throws BizException ;
}
