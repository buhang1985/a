package iih.pe.pwf.peregquery.i;

import xap.mw.core.data.BizException;
import iih.pe.pwf.peregquery.d.PeRegQueryDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检登记名单检索数据维护服务
*/
public interface IPeregqueryCudService {
	/**
	*  体检登记名单检索数据真删除
	*/
    public abstract void delete(PeRegQueryDO[] aggdos) throws BizException;
    
    /**
	*  体检登记名单检索数据插入保存
	*/
	public abstract PeRegQueryDO[] insert(PeRegQueryDO[] aggdos) throws BizException;
	
    /**
	*  体检登记名单检索数据保存
	*/
	public abstract PeRegQueryDO[] save(PeRegQueryDO[] aggdos) throws BizException;
	
    /**
	*  体检登记名单检索数据更新
	*/
	public abstract PeRegQueryDO[] update(PeRegQueryDO[] aggdos) throws BizException;
	
	/**
	*  体检登记名单检索数据逻辑删除
	*/
	public abstract void logicDelete(PeRegQueryDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeRegQueryDO[] enableWithoutFilter(PeRegQueryDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeRegQueryDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeRegQueryDO[] disableVOWithoutFilter(PeRegQueryDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeRegQueryDO[] dos) throws BizException ;
}
