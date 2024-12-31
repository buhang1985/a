package iih.mi.bd.miudidoclist.i;

import xap.mw.core.data.BizException;
import iih.mi.bd.miudidoclist.d.MiUdidoclistDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保档案类型数据维护服务
*/
public interface IMiudidoclistCudService {
	/**
	*  医保档案类型数据真删除
	*/
    public abstract void delete(MiUdidoclistDO[] aggdos) throws BizException;
    
    /**
	*  医保档案类型数据插入保存
	*/
	public abstract MiUdidoclistDO[] insert(MiUdidoclistDO[] aggdos) throws BizException;
	
    /**
	*  医保档案类型数据保存
	*/
	public abstract MiUdidoclistDO[] save(MiUdidoclistDO[] aggdos) throws BizException;
	
    /**
	*  医保档案类型数据更新
	*/
	public abstract MiUdidoclistDO[] update(MiUdidoclistDO[] aggdos) throws BizException;
	
	/**
	*  医保档案类型数据逻辑删除
	*/
	public abstract void logicDelete(MiUdidoclistDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MiUdidoclistDO[] enableWithoutFilter(MiUdidoclistDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MiUdidoclistDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MiUdidoclistDO[] disableVOWithoutFilter(MiUdidoclistDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MiUdidoclistDO[] dos) throws BizException ;
}
