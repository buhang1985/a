package iih.mp.mpbd.prnca.i;

import xap.mw.core.data.BizException;
import iih.mp.mpbd.prnca.d.MpOrPrnDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 病区执行打印单据分类数据维护服务
*/
public interface IMpOrPrnDOCudService {
	/**
	*  病区执行打印单据分类数据真删除
	*/
    public abstract void delete(MpOrPrnDO[] aggdos) throws BizException;
    
    /**
	*  病区执行打印单据分类数据插入保存
	*/
	public abstract MpOrPrnDO[] insert(MpOrPrnDO[] aggdos) throws BizException;
	
    /**
	*  病区执行打印单据分类数据保存
	*/
	public abstract MpOrPrnDO[] save(MpOrPrnDO[] aggdos) throws BizException;
	
    /**
	*  病区执行打印单据分类数据更新
	*/
	public abstract MpOrPrnDO[] update(MpOrPrnDO[] aggdos) throws BizException;
	
	/**
	*  病区执行打印单据分类数据逻辑删除
	*/
	public abstract void logicDelete(MpOrPrnDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MpOrPrnDO[] enableWithoutFilter(MpOrPrnDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MpOrPrnDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MpOrPrnDO[] disableVOWithoutFilter(MpOrPrnDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MpOrPrnDO[] aggdos) throws BizException ;
	
}
