package iih.mc.pl.mcstockplan.i;

import xap.mw.core.data.BizException;
import iih.mc.pl.mcstockplan.d.McStockPlanDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 耗材库存计划数据维护服务
*/
public interface IMcstockplanMDOCudService {
	/**
	*  耗材库存计划数据真删除
	*/
    public abstract void delete(McStockPlanDO[] aggdos) throws BizException;
    
    /**
	*  耗材库存计划数据插入保存
	*/
	public abstract McStockPlanDO[] insert(McStockPlanDO[] aggdos) throws BizException;
	
    /**
	*  耗材库存计划数据保存
	*/
	public abstract McStockPlanDO[] save(McStockPlanDO[] aggdos) throws BizException;
	
    /**
	*  耗材库存计划数据更新
	*/
	public abstract McStockPlanDO[] update(McStockPlanDO[] aggdos) throws BizException;
	
	/**
	*  耗材库存计划数据逻辑删除
	*/
	public abstract void logicDelete(McStockPlanDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public McStockPlanDO[] enableWithoutFilter(McStockPlanDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(McStockPlanDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public McStockPlanDO[] disableVOWithoutFilter(McStockPlanDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(McStockPlanDO[] aggdos) throws BizException ;
	
}
