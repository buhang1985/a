package iih.mp.dg.oepmanu.i;

import xap.mw.core.data.BizException;
import iih.mp.dg.oepmanu.d.OepManuPrepDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 手工预摆药数据维护服务
*/
public interface IOepmanuCudService {
	/**
	*  手工预摆药数据真删除
	*/
    public abstract void delete(OepManuPrepDO[] aggdos) throws BizException;
    
    /**
	*  手工预摆药数据插入保存
	*/
	public abstract OepManuPrepDO[] insert(OepManuPrepDO[] aggdos) throws BizException;
	
    /**
	*  手工预摆药数据保存
	*/
	public abstract OepManuPrepDO[] save(OepManuPrepDO[] aggdos) throws BizException;
	
    /**
	*  手工预摆药数据更新
	*/
	public abstract OepManuPrepDO[] update(OepManuPrepDO[] aggdos) throws BizException;
	
	/**
	*  手工预摆药数据逻辑删除
	*/
	public abstract void logicDelete(OepManuPrepDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public OepManuPrepDO[] enableWithoutFilter(OepManuPrepDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(OepManuPrepDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public OepManuPrepDO[] disableVOWithoutFilter(OepManuPrepDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(OepManuPrepDO[] dos) throws BizException ;
}
