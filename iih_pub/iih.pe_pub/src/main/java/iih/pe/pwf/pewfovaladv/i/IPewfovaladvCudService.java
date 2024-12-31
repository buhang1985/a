package iih.pe.pwf.pewfovaladv.i;

import xap.mw.core.data.BizException;
import iih.pe.pwf.pewfovaladv.d.PeWfOvalAdvDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检总检指导建议数据维护服务
*/
public interface IPewfovaladvCudService {
	/**
	*  体检总检指导建议数据真删除
	*/
    public abstract void delete(PeWfOvalAdvDO[] aggdos) throws BizException;
    
    /**
	*  体检总检指导建议数据插入保存
	*/
	public abstract PeWfOvalAdvDO[] insert(PeWfOvalAdvDO[] aggdos) throws BizException;
	
    /**
	*  体检总检指导建议数据保存
	*/
	public abstract PeWfOvalAdvDO[] save(PeWfOvalAdvDO[] aggdos) throws BizException;
	
    /**
	*  体检总检指导建议数据更新
	*/
	public abstract PeWfOvalAdvDO[] update(PeWfOvalAdvDO[] aggdos) throws BizException;
	
	/**
	*  体检总检指导建议数据逻辑删除
	*/
	public abstract void logicDelete(PeWfOvalAdvDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeWfOvalAdvDO[] enableWithoutFilter(PeWfOvalAdvDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeWfOvalAdvDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeWfOvalAdvDO[] disableVOWithoutFilter(PeWfOvalAdvDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeWfOvalAdvDO[] dos) throws BizException ;
}
