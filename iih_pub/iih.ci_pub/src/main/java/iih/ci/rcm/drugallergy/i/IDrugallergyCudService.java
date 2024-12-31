package iih.ci.rcm.drugallergy.i;

import xap.mw.core.data.BizException;
import iih.ci.rcm.drugallergy.d.DrugallergyDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 药敏详情数据维护服务
*/
public interface IDrugallergyCudService {
	/**
	*  药敏详情数据真删除
	*/
    public abstract void delete(DrugallergyDO[] aggdos) throws BizException;
    
    /**
	*  药敏详情数据插入保存
	*/
	public abstract DrugallergyDO[] insert(DrugallergyDO[] aggdos) throws BizException;
	
    /**
	*  药敏详情数据保存
	*/
	public abstract DrugallergyDO[] save(DrugallergyDO[] aggdos) throws BizException;
	
    /**
	*  药敏详情数据更新
	*/
	public abstract DrugallergyDO[] update(DrugallergyDO[] aggdos) throws BizException;
	
	/**
	*  药敏详情数据逻辑删除
	*/
	public abstract void logicDelete(DrugallergyDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DrugallergyDO[] enableWithoutFilter(DrugallergyDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DrugallergyDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DrugallergyDO[] disableVOWithoutFilter(DrugallergyDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DrugallergyDO[] dos) throws BizException ;
}
