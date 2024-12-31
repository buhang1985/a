package iih.mkr.std.datasetde.i;

import xap.mw.core.data.BizException;
import iih.mkr.std.datasetde.d.DataSetDeDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 数据集下数据元数据维护服务
*/
public interface IDatasetdeCudService {
	/**
	*  数据集下数据元数据真删除
	*/
    public abstract void delete(DataSetDeDO[] aggdos) throws BizException;
    
    /**
	*  数据集下数据元数据插入保存
	*/
	public abstract DataSetDeDO[] insert(DataSetDeDO[] aggdos) throws BizException;
	
    /**
	*  数据集下数据元数据保存
	*/
	public abstract DataSetDeDO[] save(DataSetDeDO[] aggdos) throws BizException;
	
    /**
	*  数据集下数据元数据更新
	*/
	public abstract DataSetDeDO[] update(DataSetDeDO[] aggdos) throws BizException;
	
	/**
	*  数据集下数据元数据逻辑删除
	*/
	public abstract void logicDelete(DataSetDeDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DataSetDeDO[] enableWithoutFilter(DataSetDeDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DataSetDeDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DataSetDeDO[] disableVOWithoutFilter(DataSetDeDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DataSetDeDO[] dos) throws BizException ;
}
