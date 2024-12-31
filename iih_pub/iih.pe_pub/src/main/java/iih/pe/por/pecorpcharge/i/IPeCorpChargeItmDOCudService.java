package iih.pe.por.pecorpcharge.i;

import xap.mw.core.data.BizException;
import iih.pe.por.pecorpcharge.d.PeCorpChargeItmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检团体账单数据维护服务
*/
public interface IPeCorpChargeItmDOCudService {
	/**
	*  体检团体账单数据真删除
	*/
    public abstract void delete(PeCorpChargeItmDO[] aggdos) throws BizException;
    
    /**
	*  体检团体账单数据插入保存
	*/
	public abstract PeCorpChargeItmDO[] insert(PeCorpChargeItmDO[] aggdos) throws BizException;
	
    /**
	*  体检团体账单数据保存
	*/
	public abstract PeCorpChargeItmDO[] save(PeCorpChargeItmDO[] aggdos) throws BizException;
	
    /**
	*  体检团体账单数据更新
	*/
	public abstract PeCorpChargeItmDO[] update(PeCorpChargeItmDO[] aggdos) throws BizException;
	
	/**
	*  体检团体账单数据逻辑删除
	*/
	public abstract void logicDelete(PeCorpChargeItmDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeCorpChargeItmDO[] enableWithoutFilter(PeCorpChargeItmDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeCorpChargeItmDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeCorpChargeItmDO[] disableVOWithoutFilter(PeCorpChargeItmDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeCorpChargeItmDO[] aggdos) throws BizException ;
	
}
