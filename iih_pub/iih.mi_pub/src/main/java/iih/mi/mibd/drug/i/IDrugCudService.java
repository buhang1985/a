package iih.mi.mibd.drug.i;

import xap.mw.core.data.BizException;
import iih.mi.mibd.drug.d.DrugDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保平台_药品数据维护服务
* 
* @author hexx
*/
public interface IDrugCudService {
	/**
	*  医保平台_药品数据真删除
	*/
    public abstract void delete(DrugDO[] aggdos) throws BizException;
    
    /**
	*  医保平台_药品数据插入保存
	*/
	public abstract DrugDO[] insert(DrugDO[] aggdos) throws BizException;
	
    /**
	*  医保平台_药品数据保存
	*/
	public abstract DrugDO[] save(DrugDO[] aggdos) throws BizException;
	
    /**
	*  医保平台_药品数据更新
	*/
	public abstract DrugDO[] update(DrugDO[] aggdos) throws BizException;
	
	/**
	*  医保平台_药品数据逻辑删除
	*/
	public abstract void logicDelete(DrugDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DrugDO[] enableWithoutFilter(DrugDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DrugDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DrugDO[] disableVOWithoutFilter(DrugDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DrugDO[] dos) throws BizException ;
}
