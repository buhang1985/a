package iih.bd.mm.drugcombctl.i;

import xap.mw.core.data.BizException;
import iih.bd.mm.drugcombctl.d.DrugCombCtlDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 联合用药限制数据维护服务
*/
public interface IDrugcombctlCudService {
	/**
	*  联合用药限制数据真删除
	*/
    public abstract void delete(DrugCombCtlDO[] aggdos) throws BizException;
    
    /**
	*  联合用药限制数据插入保存
	*/
	public abstract DrugCombCtlDO[] insert(DrugCombCtlDO[] aggdos) throws BizException;
	
    /**
	*  联合用药限制数据保存
	*/
	public abstract DrugCombCtlDO[] save(DrugCombCtlDO[] aggdos) throws BizException;
	
    /**
	*  联合用药限制数据更新
	*/
	public abstract DrugCombCtlDO[] update(DrugCombCtlDO[] aggdos) throws BizException;
	
	/**
	*  联合用药限制数据逻辑删除
	*/
	public abstract void logicDelete(DrugCombCtlDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DrugCombCtlDO[] enableWithoutFilter(DrugCombCtlDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DrugCombCtlDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DrugCombCtlDO[] disableVOWithoutFilter(DrugCombCtlDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DrugCombCtlDO[] dos) throws BizException ;
}
