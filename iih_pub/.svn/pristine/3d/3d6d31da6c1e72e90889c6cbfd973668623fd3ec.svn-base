package iih.pe.por.pecorpcharge.i;

import xap.mw.core.data.BizException;
import iih.pe.por.pecorpcharge.d.PeCorpChargeSumDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检团体账单数据维护服务
*/
public interface IPeCorpChargeSumDOCudService {
	/**
	*  体检团体账单数据真删除
	*/
    public abstract void delete(PeCorpChargeSumDO[] aggdos) throws BizException;
    
    /**
	*  体检团体账单数据插入保存
	*/
	public abstract PeCorpChargeSumDO[] insert(PeCorpChargeSumDO[] aggdos) throws BizException;
	
    /**
	*  体检团体账单数据保存
	*/
	public abstract PeCorpChargeSumDO[] save(PeCorpChargeSumDO[] aggdos) throws BizException;
	
    /**
	*  体检团体账单数据更新
	*/
	public abstract PeCorpChargeSumDO[] update(PeCorpChargeSumDO[] aggdos) throws BizException;
	
	/**
	*  体检团体账单数据逻辑删除
	*/
	public abstract void logicDelete(PeCorpChargeSumDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeCorpChargeSumDO[] enableWithoutFilter(PeCorpChargeSumDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeCorpChargeSumDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeCorpChargeSumDO[] disableVOWithoutFilter(PeCorpChargeSumDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeCorpChargeSumDO[] aggdos) throws BizException ;
	
}
