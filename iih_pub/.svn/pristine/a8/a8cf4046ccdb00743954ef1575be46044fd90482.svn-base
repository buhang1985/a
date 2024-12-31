package iih.bd.srv.emrimg.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.emrimg.d.EmrImageDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医疗记录图片库管理数据维护服务
*/
public interface IEmrimgMDOCudService {
	/**
	*  医疗记录图片库管理数据真删除
	*/
    public abstract void delete(EmrImageDO[] aggdos) throws BizException;
    
    /**
	*  医疗记录图片库管理数据插入保存
	*/
	public abstract EmrImageDO[] insert(EmrImageDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录图片库管理数据保存
	*/
	public abstract EmrImageDO[] save(EmrImageDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录图片库管理数据更新
	*/
	public abstract EmrImageDO[] update(EmrImageDO[] aggdos) throws BizException;
	
	/**
	*  医疗记录图片库管理数据逻辑删除
	*/
	public abstract void logicDelete(EmrImageDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EmrImageDO[] enableWithoutFilter(EmrImageDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EmrImageDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EmrImageDO[] disableVOWithoutFilter(EmrImageDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EmrImageDO[] aggdos) throws BizException ;
	
}
