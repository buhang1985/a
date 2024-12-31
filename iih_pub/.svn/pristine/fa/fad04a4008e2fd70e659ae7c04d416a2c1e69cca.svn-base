package iih.pe.pitm.pesrvrstnormtxt.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.pesrvrstnormtxt.d.PeSrvRstNormTxtDtlDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检结果正常时报告内容数据维护服务
*/
public interface IPeSrvRstNormTxtDtlDOCudService {
	/**
	*  体检结果正常时报告内容数据真删除
	*/
    public abstract void delete(PeSrvRstNormTxtDtlDO[] aggdos) throws BizException;
    
    /**
	*  体检结果正常时报告内容数据插入保存
	*/
	public abstract PeSrvRstNormTxtDtlDO[] insert(PeSrvRstNormTxtDtlDO[] aggdos) throws BizException;
	
    /**
	*  体检结果正常时报告内容数据保存
	*/
	public abstract PeSrvRstNormTxtDtlDO[] save(PeSrvRstNormTxtDtlDO[] aggdos) throws BizException;
	
    /**
	*  体检结果正常时报告内容数据更新
	*/
	public abstract PeSrvRstNormTxtDtlDO[] update(PeSrvRstNormTxtDtlDO[] aggdos) throws BizException;
	
	/**
	*  体检结果正常时报告内容数据逻辑删除
	*/
	public abstract void logicDelete(PeSrvRstNormTxtDtlDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeSrvRstNormTxtDtlDO[] enableWithoutFilter(PeSrvRstNormTxtDtlDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeSrvRstNormTxtDtlDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeSrvRstNormTxtDtlDO[] disableVOWithoutFilter(PeSrvRstNormTxtDtlDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeSrvRstNormTxtDtlDO[] aggdos) throws BizException ;
	
}
