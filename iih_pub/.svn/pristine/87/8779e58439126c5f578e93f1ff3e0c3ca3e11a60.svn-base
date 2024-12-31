package iih.mi.mibd.stdsrvtp.i;

import xap.mw.core.data.BizException;
import iih.mi.mibd.stdsrvtp.d.HpsrvtpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保计划下医保目录等级对照数据维护服务
*/
public interface IStdsrvtpCudService {
	/**
	*  医保计划下医保目录等级对照数据真删除
	*/
    public abstract void delete(HpsrvtpDO[] aggdos) throws BizException;
    
    /**
	*  医保计划下医保目录等级对照数据插入保存
	*/
	public abstract HpsrvtpDO[] insert(HpsrvtpDO[] aggdos) throws BizException;
	
    /**
	*  医保计划下医保目录等级对照数据保存
	*/
	public abstract HpsrvtpDO[] save(HpsrvtpDO[] aggdos) throws BizException;
	
    /**
	*  医保计划下医保目录等级对照数据更新
	*/
	public abstract HpsrvtpDO[] update(HpsrvtpDO[] aggdos) throws BizException;
	
	/**
	*  医保计划下医保目录等级对照数据逻辑删除
	*/
	public abstract void logicDelete(HpsrvtpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpsrvtpDO[] enableWithoutFilter(HpsrvtpDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpsrvtpDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpsrvtpDO[] disableVOWithoutFilter(HpsrvtpDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpsrvtpDO[] dos) throws BizException ;
}
