package iih.pe.por.peblacklist.i;

import xap.mw.core.data.BizException;
import iih.pe.por.peblacklist.d.PeBlacklistDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检客户黑名单数据维护服务
*/
public interface IPeblacklistCudService {
	/**
	*  体检客户黑名单数据真删除
	*/
    public abstract void delete(PeBlacklistDO[] aggdos) throws BizException;
    
    /**
	*  体检客户黑名单数据插入保存
	*/
	public abstract PeBlacklistDO[] insert(PeBlacklistDO[] aggdos) throws BizException;
	
    /**
	*  体检客户黑名单数据保存
	*/
	public abstract PeBlacklistDO[] save(PeBlacklistDO[] aggdos) throws BizException;
	
    /**
	*  体检客户黑名单数据更新
	*/
	public abstract PeBlacklistDO[] update(PeBlacklistDO[] aggdos) throws BizException;
	
	/**
	*  体检客户黑名单数据逻辑删除
	*/
	public abstract void logicDelete(PeBlacklistDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeBlacklistDO[] enableWithoutFilter(PeBlacklistDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeBlacklistDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeBlacklistDO[] disableVOWithoutFilter(PeBlacklistDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeBlacklistDO[] dos) throws BizException ;
}
