package iih.pi.concern.concern.i;

import xap.mw.core.data.BizException;
import iih.pi.concern.concern.d.PiPatIndDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 患者关注指标数据维护服务
*/
public interface IConcernCudService {
	/**
	*  患者关注指标数据删除
	*/
    public abstract void logicDelete(PiPatIndDO[] aggdos) throws BizException;
    
    /**
	*  患者关注指标数据插入保存
	*/
	public abstract PiPatIndDO[] insert(PiPatIndDO[] aggdos) throws BizException;
	
    /**
	*  患者关注指标数据保存
	*/
	public abstract PiPatIndDO[] save(PiPatIndDO[] aggdos) throws BizException;
	
    /**
	*  患者关注指标数据更新
	*/
	public abstract PiPatIndDO[] update(PiPatIndDO[] aggdos) throws BizException;
	
	/**
	*  患者关注指标数据真删
	*/
	public abstract void delete(PiPatIndDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PiPatIndDO[] enableWithoutFilter(PiPatIndDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PiPatIndDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PiPatIndDO[] disableVOWithoutFilter(PiPatIndDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PiPatIndDO[] aggdos) throws BizException ;
}
