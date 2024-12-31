package iih.bd.pp.hp.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.hp.d.BdHpPrestpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医保计划数据维护服务
*/
public interface IBdHpPrestpDOCudService {
	/**
	*  医保计划数据真删除
	*/
    public abstract void delete(BdHpPrestpDO[] aggdos) throws BizException;
    
    /**
	*  医保计划数据插入保存
	*/
	public abstract BdHpPrestpDO[] insert(BdHpPrestpDO[] aggdos) throws BizException;
	
    /**
	*  医保计划数据保存
	*/
	public abstract BdHpPrestpDO[] save(BdHpPrestpDO[] aggdos) throws BizException;
	
    /**
	*  医保计划数据更新
	*/
	public abstract BdHpPrestpDO[] update(BdHpPrestpDO[] aggdos) throws BizException;
	
	/**
	*  医保计划数据逻辑删除
	*/
	public abstract void logicDelete(BdHpPrestpDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BdHpPrestpDO[] enableWithoutFilter(BdHpPrestpDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BdHpPrestpDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BdHpPrestpDO[] disableVOWithoutFilter(BdHpPrestpDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BdHpPrestpDO[] aggdos) throws BizException ;
	
}
