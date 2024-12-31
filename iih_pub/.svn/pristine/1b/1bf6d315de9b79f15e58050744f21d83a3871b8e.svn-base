package iih.pe.phm.pehmlifestyle.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.pehmlifestyle.d.PeHmLifestyleDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 健康生活方式评估数据维护服务
*/
public interface IPehmlifestyleMDOCudService {
	/**
	*  健康生活方式评估数据真删除
	*/
    public abstract void delete(PeHmLifestyleDO[] aggdos) throws BizException;
    
    /**
	*  健康生活方式评估数据插入保存
	*/
	public abstract PeHmLifestyleDO[] insert(PeHmLifestyleDO[] aggdos) throws BizException;
	
    /**
	*  健康生活方式评估数据保存
	*/
	public abstract PeHmLifestyleDO[] save(PeHmLifestyleDO[] aggdos) throws BizException;
	
    /**
	*  健康生活方式评估数据更新
	*/
	public abstract PeHmLifestyleDO[] update(PeHmLifestyleDO[] aggdos) throws BizException;
	
	/**
	*  健康生活方式评估数据逻辑删除
	*/
	public abstract void logicDelete(PeHmLifestyleDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeHmLifestyleDO[] enableWithoutFilter(PeHmLifestyleDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeHmLifestyleDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeHmLifestyleDO[] disableVOWithoutFilter(PeHmLifestyleDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeHmLifestyleDO[] aggdos) throws BizException ;
	
}
