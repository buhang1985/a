package iih.mi.mibd.drugdircomp.i;

import iih.mi.mibd.drugdircomp.d.DrugdircompDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保平台_药品对照数据维护服务
* @author hexx
*/
public interface IDrugdircompCudService {
	/**
	*  医保平台_药品对照数据真删除
	*/
    public abstract void delete(DrugdircompDO[] aggdos) throws BizException;
    
    /**
	*  医保平台_药品对照数据插入保存
	*/
	public abstract DrugdircompDO[] insert(DrugdircompDO[] aggdos) throws BizException;
	
    /**
	*  医保平台_药品对照数据保存
	*/
	public abstract DrugdircompDO[] save(DrugdircompDO[] aggdos) throws BizException;
	
    /**
	*  医保平台_药品对照数据更新
	*/
	public abstract DrugdircompDO[] update(DrugdircompDO[] aggdos) throws BizException;
	
	/**
	*  医保平台_药品对照数据逻辑删除
	*/
	public abstract void logicDelete(DrugdircompDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DrugdircompDO[] enableWithoutFilter(DrugdircompDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DrugdircompDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DrugdircompDO[] disableVOWithoutFilter(DrugdircompDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DrugdircompDO[] dos) throws BizException ;
}
