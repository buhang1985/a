package iih.mi.mibd.ic.i;

import xap.mw.core.data.BizException;
import iih.mi.mibd.ic.d.IcDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保平台_险种数据维护服务
*/
public interface IIcCudService {
	/**
	*  医保平台_险种数据真删除
	*/
    public abstract void delete(IcDO[] aggdos) throws BizException;
    
    /**
	*  医保平台_险种数据插入保存
	*/
	public abstract IcDO[] insert(IcDO[] aggdos) throws BizException;
	
    /**
	*  医保平台_险种数据保存
	*/
	public abstract IcDO[] save(IcDO[] aggdos) throws BizException;
	
    /**
	*  医保平台_险种数据更新
	*/
	public abstract IcDO[] update(IcDO[] aggdos) throws BizException;
	
	/**
	*  医保平台_险种数据逻辑删除
	*/
	public abstract void logicDelete(IcDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public IcDO[] enableWithoutFilter(IcDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(IcDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public IcDO[] disableVOWithoutFilter(IcDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(IcDO[] dos) throws BizException ;
}
