package iih.pe.pwf.pedwsquery.i;

import xap.mw.core.data.BizException;
import iih.pe.pwf.pedwsquery.d.PeDwsQueryDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检分检检索数据维护服务
*/
public interface IPedwsqueryCudService {
	/**
	*  体检分检检索数据真删除
	*/
    public abstract void delete(PeDwsQueryDO[] aggdos) throws BizException;
    
    /**
	*  体检分检检索数据插入保存
	*/
	public abstract PeDwsQueryDO[] insert(PeDwsQueryDO[] aggdos) throws BizException;
	
    /**
	*  体检分检检索数据保存
	*/
	public abstract PeDwsQueryDO[] save(PeDwsQueryDO[] aggdos) throws BizException;
	
    /**
	*  体检分检检索数据更新
	*/
	public abstract PeDwsQueryDO[] update(PeDwsQueryDO[] aggdos) throws BizException;
	
	/**
	*  体检分检检索数据逻辑删除
	*/
	public abstract void logicDelete(PeDwsQueryDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeDwsQueryDO[] enableWithoutFilter(PeDwsQueryDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeDwsQueryDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeDwsQueryDO[] disableVOWithoutFilter(PeDwsQueryDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeDwsQueryDO[] dos) throws BizException ;
}
