package iih.mc.st.stockcheck.i;

import xap.mw.core.data.BizException;
import iih.mc.st.stockcheck.d.McStockCaspItemDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 库存盘点数据维护服务
*/
public interface IMcStockCaspItemDOCudService {
	/**
	*  库存盘点数据真删除
	*/
    public abstract void delete(McStockCaspItemDO[] aggdos) throws BizException;
    
    /**
	*  库存盘点数据插入保存
	*/
	public abstract McStockCaspItemDO[] insert(McStockCaspItemDO[] aggdos) throws BizException;
	
    /**
	*  库存盘点数据保存
	*/
	public abstract McStockCaspItemDO[] save(McStockCaspItemDO[] aggdos) throws BizException;
	
    /**
	*  库存盘点数据更新
	*/
	public abstract McStockCaspItemDO[] update(McStockCaspItemDO[] aggdos) throws BizException;
	
	/**
	*  库存盘点数据逻辑删除
	*/
	public abstract void logicDelete(McStockCaspItemDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public McStockCaspItemDO[] enableWithoutFilter(McStockCaspItemDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(McStockCaspItemDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public McStockCaspItemDO[] disableVOWithoutFilter(McStockCaspItemDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(McStockCaspItemDO[] aggdos) throws BizException ;
	
}
