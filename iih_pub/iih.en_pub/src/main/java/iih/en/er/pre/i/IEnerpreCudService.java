package iih.en.er.pre.i;

import xap.mw.core.data.BizException;
import iih.en.er.pre.d.EnErPreDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 急诊预检数据维护服务
*/
public interface IEnerpreCudService {
	/**
	*  急诊预检数据真删除
	*/
    public abstract void delete(EnErPreDO[] aggdos) throws BizException;
    
    /**
	*  急诊预检数据插入保存
	*/
	public abstract EnErPreDO[] insert(EnErPreDO[] aggdos) throws BizException;
	
    /**
	*  急诊预检数据保存
	*/
	public abstract EnErPreDO[] save(EnErPreDO[] aggdos) throws BizException;
	
    /**
	*  急诊预检数据更新
	*/
	public abstract EnErPreDO[] update(EnErPreDO[] aggdos) throws BizException;
	
	/**
	*  急诊预检数据逻辑删除
	*/
	public abstract void logicDelete(EnErPreDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EnErPreDO[] enableWithoutFilter(EnErPreDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EnErPreDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EnErPreDO[] disableVOWithoutFilter(EnErPreDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EnErPreDO[] dos) throws BizException ;
}
