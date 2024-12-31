package iih.mc.st.mcstockaplrel.i;

import xap.mw.core.data.BizException;
import iih.mc.st.mcstockaplrel.d.McStockAplRelDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 耗材出库申请关联数据维护服务
*/
public interface IMcstockaplrelCudService {
	/**
	*  耗材出库申请关联数据真删除
	*/
    public abstract void delete(McStockAplRelDO[] aggdos) throws BizException;
    
    /**
	*  耗材出库申请关联数据插入保存
	*/
	public abstract McStockAplRelDO[] insert(McStockAplRelDO[] aggdos) throws BizException;
	
    /**
	*  耗材出库申请关联数据保存
	*/
	public abstract McStockAplRelDO[] save(McStockAplRelDO[] aggdos) throws BizException;
	
    /**
	*  耗材出库申请关联数据更新
	*/
	public abstract McStockAplRelDO[] update(McStockAplRelDO[] aggdos) throws BizException;
	
	/**
	*  耗材出库申请关联数据逻辑删除
	*/
	public abstract void logicDelete(McStockAplRelDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public McStockAplRelDO[] enableWithoutFilter(McStockAplRelDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(McStockAplRelDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public McStockAplRelDO[] disableVOWithoutFilter(McStockAplRelDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(McStockAplRelDO[] dos) throws BizException ;
}
