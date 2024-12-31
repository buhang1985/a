package iih.bd.mhi.hpopepermapply.i;

import xap.mw.core.data.BizException;
import iih.bd.mhi.hpopepermapply.d.HpOpePermApplyDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 权限申请_操作员权限维护数据维护服务
*/
public interface IHpopepermapplyCudService {
	/**
	*  权限申请_操作员权限维护数据真删除
	*/
    public abstract void delete(HpOpePermApplyDO[] aggdos) throws BizException;
    
    /**
	*  权限申请_操作员权限维护数据插入保存
	*/
	public abstract HpOpePermApplyDO[] insert(HpOpePermApplyDO[] aggdos) throws BizException;
	
    /**
	*  权限申请_操作员权限维护数据保存
	*/
	public abstract HpOpePermApplyDO[] save(HpOpePermApplyDO[] aggdos) throws BizException;
	
    /**
	*  权限申请_操作员权限维护数据更新
	*/
	public abstract HpOpePermApplyDO[] update(HpOpePermApplyDO[] aggdos) throws BizException;
	
	/**
	*  权限申请_操作员权限维护数据逻辑删除
	*/
	public abstract void logicDelete(HpOpePermApplyDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpOpePermApplyDO[] enableWithoutFilter(HpOpePermApplyDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpOpePermApplyDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpOpePermApplyDO[] disableVOWithoutFilter(HpOpePermApplyDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpOpePermApplyDO[] dos) throws BizException ;
}
