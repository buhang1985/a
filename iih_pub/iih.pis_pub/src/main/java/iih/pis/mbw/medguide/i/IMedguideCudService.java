package iih.pis.mbw.medguide.i;

import xap.mw.core.data.BizException;
import iih.pis.mbw.medguide.d.MedGuideDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 就医指南数据维护服务
*/
public interface IMedguideCudService {
	/**
	*  就医指南数据真删除
	*/
    public abstract void delete(MedGuideDO[] aggdos) throws BizException;
    
    /**
	*  就医指南数据插入保存
	*/
	public abstract MedGuideDO[] insert(MedGuideDO[] aggdos) throws BizException;
	
    /**
	*  就医指南数据保存
	*/
	public abstract MedGuideDO[] save(MedGuideDO[] aggdos) throws BizException;
	
    /**
	*  就医指南数据更新
	*/
	public abstract MedGuideDO[] update(MedGuideDO[] aggdos) throws BizException;
	
	/**
	*  就医指南数据逻辑删除
	*/
	public abstract void logicDelete(MedGuideDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MedGuideDO[] enableWithoutFilter(MedGuideDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MedGuideDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MedGuideDO[] disableVOWithoutFilter(MedGuideDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MedGuideDO[] dos) throws BizException ;
}
