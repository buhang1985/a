package iih.nm.nqm.nqmchk.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nqmchk.d.NmNqmChkItmextDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 护理管理_护理质量检查明细扩展信息数据维护服务
*/
public interface INmnqmchkitmextCudService {
	/**
	*  护理管理_护理质量检查明细扩展信息数据真删除
	*/
    public abstract void delete(NmNqmChkItmextDO[] aggdos) throws BizException;
    
    /**
	*  护理管理_护理质量检查明细扩展信息数据插入保存
	*/
	public abstract NmNqmChkItmextDO[] insert(NmNqmChkItmextDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_护理质量检查明细扩展信息数据保存
	*/
	public abstract NmNqmChkItmextDO[] save(NmNqmChkItmextDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_护理质量检查明细扩展信息数据更新
	*/
	public abstract NmNqmChkItmextDO[] update(NmNqmChkItmextDO[] aggdos) throws BizException;
	
	/**
	*  护理管理_护理质量检查明细扩展信息数据逻辑删除
	*/
	public abstract void logicDelete(NmNqmChkItmextDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNqmChkItmextDO[] enableWithoutFilter(NmNqmChkItmextDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNqmChkItmextDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNqmChkItmextDO[] disableVOWithoutFilter(NmNqmChkItmextDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNqmChkItmextDO[] dos) throws BizException ;
}
