package iih.nm.nqm.nmnqmsuper.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nmnqmsuper.d.NmNqmSuperDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 护理管理_督导项数据维护服务
*/
public interface INmnqmsuperMDOCudService {
	/**
	*  护理管理_督导项数据真删除
	*/
    public abstract void delete(NmNqmSuperDO[] aggdos) throws BizException;
    
    /**
	*  护理管理_督导项数据插入保存
	*/
	public abstract NmNqmSuperDO[] insert(NmNqmSuperDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_督导项数据保存
	*/
	public abstract NmNqmSuperDO[] save(NmNqmSuperDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_督导项数据更新
	*/
	public abstract NmNqmSuperDO[] update(NmNqmSuperDO[] aggdos) throws BizException;
	
	/**
	*  护理管理_督导项数据逻辑删除
	*/
	public abstract void logicDelete(NmNqmSuperDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNqmSuperDO[] enableWithoutFilter(NmNqmSuperDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNqmSuperDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNqmSuperDO[] disableVOWithoutFilter(NmNqmSuperDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNqmSuperDO[] aggdos) throws BizException ;
	
}
