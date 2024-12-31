package iih.bd.pp.anhuiinsur.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.anhuiinsur.d.BdHpFwssOrginalDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 安徽医保服务设施目录数据维护服务
*/
public interface IBdhpfwssorginalCudService {
	/**
	*  安徽医保服务设施目录数据真删除
	*/
    public abstract void delete(BdHpFwssOrginalDO[] aggdos) throws BizException;
    
    /**
	*  安徽医保服务设施目录数据插入保存
	*/
	public abstract BdHpFwssOrginalDO[] insert(BdHpFwssOrginalDO[] aggdos) throws BizException;
	
    /**
	*  安徽医保服务设施目录数据保存
	*/
	public abstract BdHpFwssOrginalDO[] save(BdHpFwssOrginalDO[] aggdos) throws BizException;
	
    /**
	*  安徽医保服务设施目录数据更新
	*/
	public abstract BdHpFwssOrginalDO[] update(BdHpFwssOrginalDO[] aggdos) throws BizException;
	
	/**
	*  安徽医保服务设施目录数据逻辑删除
	*/
	public abstract void logicDelete(BdHpFwssOrginalDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BdHpFwssOrginalDO[] enableWithoutFilter(BdHpFwssOrginalDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BdHpFwssOrginalDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BdHpFwssOrginalDO[] disableVOWithoutFilter(BdHpFwssOrginalDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BdHpFwssOrginalDO[] dos) throws BizException ;
}
