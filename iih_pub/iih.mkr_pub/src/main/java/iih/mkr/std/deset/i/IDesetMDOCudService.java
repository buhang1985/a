package iih.mkr.std.deset.i;

import xap.mw.core.data.BizException;
import iih.mkr.std.deset.d.DeDataSetDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 数据集数据维护服务
*/
public interface IDesetMDOCudService {
	/**
	*  数据集数据真删除
	*/
    public abstract void delete(DeDataSetDO[] aggdos) throws BizException;
    
    /**
	*  数据集数据插入保存
	*/
	public abstract DeDataSetDO[] insert(DeDataSetDO[] aggdos) throws BizException;
	
    /**
	*  数据集数据保存
	*/
	public abstract DeDataSetDO[] save(DeDataSetDO[] aggdos) throws BizException;
	
    /**
	*  数据集数据更新
	*/
	public abstract DeDataSetDO[] update(DeDataSetDO[] aggdos) throws BizException;
	
	/**
	*  数据集数据逻辑删除
	*/
	public abstract void logicDelete(DeDataSetDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DeDataSetDO[] enableWithoutFilter(DeDataSetDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DeDataSetDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DeDataSetDO[] disableVOWithoutFilter(DeDataSetDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DeDataSetDO[] aggdos) throws BizException ;
	
}