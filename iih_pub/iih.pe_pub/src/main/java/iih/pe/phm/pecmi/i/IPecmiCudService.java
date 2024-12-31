package iih.pe.phm.pecmi.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.pecmi.d.PeCmiDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检康奈尔医学指数数据维护服务
*/
public interface IPecmiCudService {
	/**
	*  体检康奈尔医学指数数据真删除
	*/
    public abstract void delete(PeCmiDO[] aggdos) throws BizException;
    
    /**
	*  体检康奈尔医学指数数据插入保存
	*/
	public abstract PeCmiDO[] insert(PeCmiDO[] aggdos) throws BizException;
	
    /**
	*  体检康奈尔医学指数数据保存
	*/
	public abstract PeCmiDO[] save(PeCmiDO[] aggdos) throws BizException;
	
    /**
	*  体检康奈尔医学指数数据更新
	*/
	public abstract PeCmiDO[] update(PeCmiDO[] aggdos) throws BizException;
	
	/**
	*  体检康奈尔医学指数数据逻辑删除
	*/
	public abstract void logicDelete(PeCmiDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeCmiDO[] enableWithoutFilter(PeCmiDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeCmiDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeCmiDO[] disableVOWithoutFilter(PeCmiDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeCmiDO[] dos) throws BizException ;
}
