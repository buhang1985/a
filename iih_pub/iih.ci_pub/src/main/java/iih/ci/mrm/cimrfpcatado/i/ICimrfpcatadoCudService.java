package iih.ci.mrm.cimrfpcatado.i;

import xap.mw.core.data.BizException;
import iih.ci.mrm.cimrfpcatado.d.CiMrFpCataDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 病案编目主表数据维护服务
*/
public interface ICimrfpcatadoCudService {
	/**
	*  病案编目主表数据真删除
	*/
    public abstract void delete(CiMrFpCataDO[] aggdos) throws BizException;
    
    /**
	*  病案编目主表数据插入保存
	*/
	public abstract CiMrFpCataDO[] insert(CiMrFpCataDO[] aggdos) throws BizException;
	
    /**
	*  病案编目主表数据保存
	*/
	public abstract CiMrFpCataDO[] save(CiMrFpCataDO[] aggdos) throws BizException;
	
    /**
	*  病案编目主表数据更新
	*/
	public abstract CiMrFpCataDO[] update(CiMrFpCataDO[] aggdos) throws BizException;
	
	/**
	*  病案编目主表数据逻辑删除
	*/
	public abstract void logicDelete(CiMrFpCataDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiMrFpCataDO[] enableWithoutFilter(CiMrFpCataDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiMrFpCataDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiMrFpCataDO[] disableVOWithoutFilter(CiMrFpCataDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiMrFpCataDO[] dos) throws BizException ;
}
