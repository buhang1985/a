package iih.pe.papt.pelabsamp.i;

import xap.mw.core.data.BizException;
import iih.pe.papt.pelabsamp.d.PeLabSampDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检检验标本数据维护服务
*/
public interface IPelabsampCudService {
	/**
	*  体检检验标本数据真删除
	*/
    public abstract void delete(PeLabSampDO[] aggdos) throws BizException;
    
    /**
	*  体检检验标本数据插入保存
	*/
	public abstract PeLabSampDO[] insert(PeLabSampDO[] aggdos) throws BizException;
	
    /**
	*  体检检验标本数据保存
	*/
	public abstract PeLabSampDO[] save(PeLabSampDO[] aggdos) throws BizException;
	
    /**
	*  体检检验标本数据更新
	*/
	public abstract PeLabSampDO[] update(PeLabSampDO[] aggdos) throws BizException;
	
	/**
	*  体检检验标本数据逻辑删除
	*/
	public abstract void logicDelete(PeLabSampDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeLabSampDO[] enableWithoutFilter(PeLabSampDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeLabSampDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeLabSampDO[] disableVOWithoutFilter(PeLabSampDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeLabSampDO[] dos) throws BizException ;
}
