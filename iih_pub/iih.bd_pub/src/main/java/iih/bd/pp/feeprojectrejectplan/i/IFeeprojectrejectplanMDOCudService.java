package iih.bd.pp.feeprojectrejectplan.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.feeprojectrejectplan.d.ExclusiveMasterDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 收费项目排斥方案数据维护服务
*/
public interface IFeeprojectrejectplanMDOCudService {
	/**
	*  收费项目排斥方案数据真删除
	*/
    public abstract void delete(ExclusiveMasterDO[] aggdos) throws BizException;
    
    /**
	*  收费项目排斥方案数据插入保存
	*/
	public abstract ExclusiveMasterDO[] insert(ExclusiveMasterDO[] aggdos) throws BizException;
	
    /**
	*  收费项目排斥方案数据保存
	*/
	public abstract ExclusiveMasterDO[] save(ExclusiveMasterDO[] aggdos) throws BizException;
	
    /**
	*  收费项目排斥方案数据更新
	*/
	public abstract ExclusiveMasterDO[] update(ExclusiveMasterDO[] aggdos) throws BizException;
	
	/**
	*  收费项目排斥方案数据逻辑删除
	*/
	public abstract void logicDelete(ExclusiveMasterDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ExclusiveMasterDO[] enableWithoutFilter(ExclusiveMasterDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ExclusiveMasterDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ExclusiveMasterDO[] disableVOWithoutFilter(ExclusiveMasterDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ExclusiveMasterDO[] aggdos) throws BizException ;
	
}
