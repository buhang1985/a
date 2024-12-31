package iih.bd.pp.hp.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.hp.d.HpFreqDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医保计划数据维护服务
*/
public interface IHpFreqDOCudService {
	/**
	*  医保计划数据真删除
	*/
    public abstract void delete(HpFreqDO[] aggdos) throws BizException;
    
    /**
	*  医保计划数据插入保存
	*/
	public abstract HpFreqDO[] insert(HpFreqDO[] aggdos) throws BizException;
	
    /**
	*  医保计划数据保存
	*/
	public abstract HpFreqDO[] save(HpFreqDO[] aggdos) throws BizException;
	
    /**
	*  医保计划数据更新
	*/
	public abstract HpFreqDO[] update(HpFreqDO[] aggdos) throws BizException;
	
	/**
	*  医保计划数据逻辑删除
	*/
	public abstract void logicDelete(HpFreqDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpFreqDO[] enableWithoutFilter(HpFreqDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpFreqDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpFreqDO[] disableVOWithoutFilter(HpFreqDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpFreqDO[] aggdos) throws BizException ;
	
}
