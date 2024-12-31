package iih.bd.pp.hp.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.hp.d.HpDepDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医保计划数据维护服务
*/
public interface IHpDepDOCudService {
	/**
	*  医保计划数据真删除
	*/
    public abstract void delete(HpDepDO[] aggdos) throws BizException;
    
    /**
	*  医保计划数据插入保存
	*/
	public abstract HpDepDO[] insert(HpDepDO[] aggdos) throws BizException;
	
    /**
	*  医保计划数据保存
	*/
	public abstract HpDepDO[] save(HpDepDO[] aggdos) throws BizException;
	
    /**
	*  医保计划数据更新
	*/
	public abstract HpDepDO[] update(HpDepDO[] aggdos) throws BizException;
	
	/**
	*  医保计划数据逻辑删除
	*/
	public abstract void logicDelete(HpDepDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpDepDO[] enableWithoutFilter(HpDepDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpDepDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpDepDO[] disableVOWithoutFilter(HpDepDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpDepDO[] aggdos) throws BizException ;
	
}
