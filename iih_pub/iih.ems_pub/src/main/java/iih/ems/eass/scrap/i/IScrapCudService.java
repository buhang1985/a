package iih.ems.eass.scrap.i;

import xap.mw.core.data.BizException;
import iih.ems.eass.scrap.d.EmsScrapDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 资产报废数据维护服务
*/
public interface IScrapCudService {
	/**
	*  资产报废数据真删除
	*/
    public abstract void delete(EmsScrapDO[] aggdos) throws BizException;
    
    /**
	*  资产报废数据插入保存
	*/
	public abstract EmsScrapDO[] insert(EmsScrapDO[] aggdos) throws BizException;
	
    /**
	*  资产报废数据保存
	*/
	public abstract EmsScrapDO[] save(EmsScrapDO[] aggdos) throws BizException;
	
    /**
	*  资产报废数据更新
	*/
	public abstract EmsScrapDO[] update(EmsScrapDO[] aggdos) throws BizException;
	
	/**
	*  资产报废数据逻辑删除
	*/
	public abstract void logicDelete(EmsScrapDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EmsScrapDO[] enableWithoutFilter(EmsScrapDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EmsScrapDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EmsScrapDO[] disableVOWithoutFilter(EmsScrapDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EmsScrapDO[] dos) throws BizException ;
}
