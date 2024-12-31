package iih.mi.bd.miudidoccomp.i;

import xap.mw.core.data.BizException;
import iih.mi.bd.miudidoccomp.d.MiUdidocCompDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保基础编码对照数据维护服务
*/
public interface IMiudidoccompCudService {
	/**
	*  医保基础编码对照数据真删除
	*/
    public abstract void delete(MiUdidocCompDO[] aggdos) throws BizException;
    
    /**
	*  医保基础编码对照数据插入保存
	*/
	public abstract MiUdidocCompDO[] insert(MiUdidocCompDO[] aggdos) throws BizException;
	
    /**
	*  医保基础编码对照数据保存
	*/
	public abstract MiUdidocCompDO[] save(MiUdidocCompDO[] aggdos) throws BizException;
	
    /**
	*  医保基础编码对照数据更新
	*/
	public abstract MiUdidocCompDO[] update(MiUdidocCompDO[] aggdos) throws BizException;
	
	/**
	*  医保基础编码对照数据逻辑删除
	*/
	public abstract void logicDelete(MiUdidocCompDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MiUdidocCompDO[] enableWithoutFilter(MiUdidocCompDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MiUdidocCompDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MiUdidocCompDO[] disableVOWithoutFilter(MiUdidocCompDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MiUdidocCompDO[] dos) throws BizException ;
}
