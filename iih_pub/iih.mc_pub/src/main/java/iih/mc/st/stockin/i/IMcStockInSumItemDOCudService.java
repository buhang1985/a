package iih.mc.st.stockin.i;

import xap.mw.core.data.BizException;
import iih.mc.st.stockin.d.McStockInSumItemDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 耗材入库单数据维护服务
*/
public interface IMcStockInSumItemDOCudService {
	/**
	*  耗材入库单数据真删除
	*/
    public abstract void delete(McStockInSumItemDO[] aggdos) throws BizException;
    
    /**
	*  耗材入库单数据插入保存
	*/
	public abstract McStockInSumItemDO[] insert(McStockInSumItemDO[] aggdos) throws BizException;
	
    /**
	*  耗材入库单数据保存
	*/
	public abstract McStockInSumItemDO[] save(McStockInSumItemDO[] aggdos) throws BizException;
	
    /**
	*  耗材入库单数据更新
	*/
	public abstract McStockInSumItemDO[] update(McStockInSumItemDO[] aggdos) throws BizException;
	
	/**
	*  耗材入库单数据逻辑删除
	*/
	public abstract void logicDelete(McStockInSumItemDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public McStockInSumItemDO[] enableWithoutFilter(McStockInSumItemDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(McStockInSumItemDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public McStockInSumItemDO[] disableVOWithoutFilter(McStockInSumItemDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(McStockInSumItemDO[] aggdos) throws BizException ;
	
}
