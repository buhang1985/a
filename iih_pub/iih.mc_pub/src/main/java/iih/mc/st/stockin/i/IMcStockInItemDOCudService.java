package iih.mc.st.stockin.i;

import xap.mw.core.data.BizException;
import iih.mc.st.stockin.d.McStockInItemDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 耗材入库单数据维护服务
*/
public interface IMcStockInItemDOCudService {
	/**
	*  耗材入库单数据真删除
	*/
    public abstract void delete(McStockInItemDO[] aggdos) throws BizException;
    
    /**
	*  耗材入库单数据插入保存
	*/
	public abstract McStockInItemDO[] insert(McStockInItemDO[] aggdos) throws BizException;
	
    /**
	*  耗材入库单数据保存
	*/
	public abstract McStockInItemDO[] save(McStockInItemDO[] aggdos) throws BizException;
	
    /**
	*  耗材入库单数据更新
	*/
	public abstract McStockInItemDO[] update(McStockInItemDO[] aggdos) throws BizException;
	
	/**
	*  耗材入库单数据逻辑删除
	*/
	public abstract void logicDelete(McStockInItemDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public McStockInItemDO[] enableWithoutFilter(McStockInItemDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(McStockInItemDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public McStockInItemDO[] disableVOWithoutFilter(McStockInItemDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(McStockInItemDO[] aggdos) throws BizException ;
	
}
