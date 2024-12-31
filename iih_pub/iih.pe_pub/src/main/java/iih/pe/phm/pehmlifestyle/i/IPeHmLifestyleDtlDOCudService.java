package iih.pe.phm.pehmlifestyle.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.pehmlifestyle.d.PeHmLifestyleDtlDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 健康生活方式评估数据维护服务
*/
public interface IPeHmLifestyleDtlDOCudService {
	/**
	*  健康生活方式评估数据真删除
	*/
    public abstract void delete(PeHmLifestyleDtlDO[] aggdos) throws BizException;
    
    /**
	*  健康生活方式评估数据插入保存
	*/
	public abstract PeHmLifestyleDtlDO[] insert(PeHmLifestyleDtlDO[] aggdos) throws BizException;
	
    /**
	*  健康生活方式评估数据保存
	*/
	public abstract PeHmLifestyleDtlDO[] save(PeHmLifestyleDtlDO[] aggdos) throws BizException;
	
    /**
	*  健康生活方式评估数据更新
	*/
	public abstract PeHmLifestyleDtlDO[] update(PeHmLifestyleDtlDO[] aggdos) throws BizException;
	
	/**
	*  健康生活方式评估数据逻辑删除
	*/
	public abstract void logicDelete(PeHmLifestyleDtlDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeHmLifestyleDtlDO[] enableWithoutFilter(PeHmLifestyleDtlDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeHmLifestyleDtlDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeHmLifestyleDtlDO[] disableVOWithoutFilter(PeHmLifestyleDtlDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeHmLifestyleDtlDO[] aggdos) throws BizException ;
	
}
