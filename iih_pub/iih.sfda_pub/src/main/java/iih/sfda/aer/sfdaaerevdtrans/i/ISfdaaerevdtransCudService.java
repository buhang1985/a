package iih.sfda.aer.sfdaaerevdtrans.i;

import xap.mw.core.data.BizException;
import iih.sfda.aer.sfdaaerevdtrans.d.SfdaAerEvDtransDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 传输过程错误(运送)数据维护服务
*/
public interface ISfdaaerevdtransCudService {
	/**
	*  传输过程错误(运送)数据真删除
	*/
    public abstract void delete(SfdaAerEvDtransDO[] aggdos) throws BizException;
    
    /**
	*  传输过程错误(运送)数据插入保存
	*/
	public abstract SfdaAerEvDtransDO[] insert(SfdaAerEvDtransDO[] aggdos) throws BizException;
	
    /**
	*  传输过程错误(运送)数据保存
	*/
	public abstract SfdaAerEvDtransDO[] save(SfdaAerEvDtransDO[] aggdos) throws BizException;
	
    /**
	*  传输过程错误(运送)数据更新
	*/
	public abstract SfdaAerEvDtransDO[] update(SfdaAerEvDtransDO[] aggdos) throws BizException;
	
	/**
	*  传输过程错误(运送)数据逻辑删除
	*/
	public abstract void logicDelete(SfdaAerEvDtransDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SfdaAerEvDtransDO[] enableWithoutFilter(SfdaAerEvDtransDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SfdaAerEvDtransDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SfdaAerEvDtransDO[] disableVOWithoutFilter(SfdaAerEvDtransDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SfdaAerEvDtransDO[] dos) throws BizException ;
}
