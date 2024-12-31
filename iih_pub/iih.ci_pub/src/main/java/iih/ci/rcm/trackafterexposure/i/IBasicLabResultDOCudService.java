package iih.ci.rcm.trackafterexposure.i;

import xap.mw.core.data.BizException;
import iih.ci.rcm.trackafterexposure.d.BasicLabResultDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 暴露后追踪记录登记表数据维护服务
*/
public interface IBasicLabResultDOCudService {
	/**
	*  暴露后追踪记录登记表数据真删除
	*/
    public abstract void delete(BasicLabResultDO[] aggdos) throws BizException;
    
    /**
	*  暴露后追踪记录登记表数据插入保存
	*/
	public abstract BasicLabResultDO[] insert(BasicLabResultDO[] aggdos) throws BizException;
	
    /**
	*  暴露后追踪记录登记表数据保存
	*/
	public abstract BasicLabResultDO[] save(BasicLabResultDO[] aggdos) throws BizException;
	
    /**
	*  暴露后追踪记录登记表数据更新
	*/
	public abstract BasicLabResultDO[] update(BasicLabResultDO[] aggdos) throws BizException;
	
	/**
	*  暴露后追踪记录登记表数据逻辑删除
	*/
	public abstract void logicDelete(BasicLabResultDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BasicLabResultDO[] enableWithoutFilter(BasicLabResultDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BasicLabResultDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BasicLabResultDO[] disableVOWithoutFilter(BasicLabResultDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BasicLabResultDO[] aggdos) throws BizException ;
	
}
