package iih.bd.srv.oth.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.oth.d.MedSrvWordFreqDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医疗服务词频统计数据维护服务
*/
public interface IOthCudService {
	/**
	*  医疗服务词频统计数据真删除
	*/
    public abstract void delete(MedSrvWordFreqDO[] aggdos) throws BizException;
    
    /**
	*  医疗服务词频统计数据插入保存
	*/
	public abstract MedSrvWordFreqDO[] insert(MedSrvWordFreqDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务词频统计数据保存
	*/
	public abstract MedSrvWordFreqDO[] save(MedSrvWordFreqDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务词频统计数据更新
	*/
	public abstract MedSrvWordFreqDO[] update(MedSrvWordFreqDO[] aggdos) throws BizException;
	
	/**
	*  医疗服务词频统计数据逻辑删除
	*/
	public abstract void logicDelete(MedSrvWordFreqDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MedSrvWordFreqDO[] enableWithoutFilter(MedSrvWordFreqDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MedSrvWordFreqDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MedSrvWordFreqDO[] disableVOWithoutFilter(MedSrvWordFreqDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MedSrvWordFreqDO[] dos) throws BizException ;
}
