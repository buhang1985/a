package iih.mc.mc.stockperinit.i;

import xap.mw.core.data.BizException;
import iih.mc.mc.stockperinit.d.McStockPerInitDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 耗材库存期初数据维护服务
*/
public interface IStockperinitMDOCudService {
	/**
	*  耗材库存期初数据真删除
	*/
    public abstract void delete(McStockPerInitDO[] aggdos) throws BizException;
    
    /**
	*  耗材库存期初数据插入保存
	*/
	public abstract McStockPerInitDO[] insert(McStockPerInitDO[] aggdos) throws BizException;
	
    /**
	*  耗材库存期初数据保存
	*/
	public abstract McStockPerInitDO[] save(McStockPerInitDO[] aggdos) throws BizException;
	
    /**
	*  耗材库存期初数据更新
	*/
	public abstract McStockPerInitDO[] update(McStockPerInitDO[] aggdos) throws BizException;
	
	/**
	*  耗材库存期初数据逻辑删除
	*/
	public abstract void logicDelete(McStockPerInitDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public McStockPerInitDO[] enableWithoutFilter(McStockPerInitDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(McStockPerInitDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public McStockPerInitDO[] disableVOWithoutFilter(McStockPerInitDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(McStockPerInitDO[] aggdos) throws BizException ;
	
}
