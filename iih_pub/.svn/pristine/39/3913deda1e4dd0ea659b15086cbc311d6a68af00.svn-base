package iih.bd.srv.usageselfcaitm.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.usageselfcaitm.d.UsageSelfCaItemDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 用法自定义分类项目数据维护服务
*/
public interface IUsageselfcaitmMDOCudService {
	/**
	*  用法自定义分类项目数据删除
	*/
    public abstract void delete(UsageSelfCaItemDO[] aggdos) throws BizException;
    
    /**
	*  用法自定义分类项目数据插入保存
	*/
	public abstract UsageSelfCaItemDO[] insert(UsageSelfCaItemDO[] aggdos) throws BizException;
	
    /**
	*  用法自定义分类项目数据保存
	*/
	public abstract UsageSelfCaItemDO[] save(UsageSelfCaItemDO[] aggdos) throws BizException;
	
    /**
	*  用法自定义分类项目数据更新
	*/
	public abstract UsageSelfCaItemDO[] update(UsageSelfCaItemDO[] aggdos) throws BizException;
	
	/**
	*  用法自定义分类项目数据真删
	*/
	public abstract void logicDelete(UsageSelfCaItemDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public UsageSelfCaItemDO[] enableWithoutFilter(UsageSelfCaItemDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(UsageSelfCaItemDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public UsageSelfCaItemDO[] disableVOWithoutFilter(UsageSelfCaItemDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(UsageSelfCaItemDO[] aggdos) throws BizException ;
	
}
