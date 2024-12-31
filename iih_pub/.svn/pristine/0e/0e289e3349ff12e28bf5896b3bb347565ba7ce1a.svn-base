package iih.bd.mhi.hptreatdircomp.i;

import xap.mw.core.data.BizException;
import iih.bd.mhi.hptreatdircomp.d.HpTreatDirCompDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保产品_诊疗对照数据维护服务
*/
public interface IHptreatdircompCudService {
	/**
	*  医保产品_诊疗对照数据真删除
	*/
    public abstract void delete(HpTreatDirCompDO[] aggdos) throws BizException;
    
    /**
	*  医保产品_诊疗对照数据插入保存
	*/
	public abstract HpTreatDirCompDO[] insert(HpTreatDirCompDO[] aggdos) throws BizException;
	
    /**
	*  医保产品_诊疗对照数据保存
	*/
	public abstract HpTreatDirCompDO[] save(HpTreatDirCompDO[] aggdos) throws BizException;
	
    /**
	*  医保产品_诊疗对照数据更新
	*/
	public abstract HpTreatDirCompDO[] update(HpTreatDirCompDO[] aggdos) throws BizException;
	
	/**
	*  医保产品_诊疗对照数据逻辑删除
	*/
	public abstract void logicDelete(HpTreatDirCompDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpTreatDirCompDO[] enableWithoutFilter(HpTreatDirCompDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpTreatDirCompDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpTreatDirCompDO[] disableVOWithoutFilter(HpTreatDirCompDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpTreatDirCompDO[] dos) throws BizException ;
}
