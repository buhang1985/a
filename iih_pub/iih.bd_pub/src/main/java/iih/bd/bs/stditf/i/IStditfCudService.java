package iih.bd.bs.stditf.i;

import xap.mw.core.data.BizException;
import iih.bd.bs.stditf.d.BdStdItfDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 基础数据标准接口数据维护服务
*/
public interface IStditfCudService {
	/**
	*  基础数据标准接口数据真删除
	*/
    public abstract void delete(BdStdItfDO[] aggdos) throws BizException;
    
    /**
	*  基础数据标准接口数据插入保存
	*/
	public abstract BdStdItfDO[] insert(BdStdItfDO[] aggdos) throws BizException;
	
    /**
	*  基础数据标准接口数据保存
	*/
	public abstract BdStdItfDO[] save(BdStdItfDO[] aggdos) throws BizException;
	
    /**
	*  基础数据标准接口数据更新
	*/
	public abstract BdStdItfDO[] update(BdStdItfDO[] aggdos) throws BizException;
	
	/**
	*  基础数据标准接口数据逻辑删除
	*/
	public abstract void logicDelete(BdStdItfDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BdStdItfDO[] enableWithoutFilter(BdStdItfDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BdStdItfDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BdStdItfDO[] disableVOWithoutFilter(BdStdItfDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BdStdItfDO[] dos) throws BizException ;
}
