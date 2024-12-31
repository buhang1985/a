package iih.nm.nqm.nmnqmnchkdet.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nmnqmnchkdet.d.NmNqmNchkDetDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 护理管理_夜查房_检查病区22数据维护服务
*/
public interface INmnqmnchkdetMDOCudService {
	/**
	*  护理管理_夜查房_检查病区22数据真删除
	*/
    public abstract void delete(NmNqmNchkDetDO[] aggdos) throws BizException;
    
    /**
	*  护理管理_夜查房_检查病区22数据保存
	*/
	public abstract NmNqmNchkDetDO[] save(NmNqmNchkDetDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_夜查房_检查病区22数据更新
	*/
	public abstract NmNqmNchkDetDO[] update(NmNqmNchkDetDO[] aggdos) throws BizException;
	
	/**
	*  护理管理_夜查房_检查病区22数据逻辑删除
	*/
	public abstract void logicDelete(NmNqmNchkDetDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNqmNchkDetDO[] enableWithoutFilter(NmNqmNchkDetDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNqmNchkDetDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNqmNchkDetDO[] disableVOWithoutFilter(NmNqmNchkDetDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNqmNchkDetDO[] aggdos) throws BizException ;
	
}
