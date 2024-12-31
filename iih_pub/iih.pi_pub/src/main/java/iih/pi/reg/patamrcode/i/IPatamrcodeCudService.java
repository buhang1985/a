package iih.pi.reg.patamrcode.i;

import xap.mw.core.data.BizException;
import iih.pi.reg.patamrcode.d.PiPatAmrCodeDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 患者病案编码数据维护服务
*/
public interface IPatamrcodeCudService {
	/**
	*  患者病案编码数据真删除
	*/
    public abstract void delete(PiPatAmrCodeDO[] aggdos) throws BizException;
    
    /**
	*  患者病案编码数据插入保存
	*/
	public abstract PiPatAmrCodeDO[] insert(PiPatAmrCodeDO[] aggdos) throws BizException;
	
    /**
	*  患者病案编码数据保存
	*/
	public abstract PiPatAmrCodeDO[] save(PiPatAmrCodeDO[] aggdos) throws BizException;
	
    /**
	*  患者病案编码数据更新
	*/
	public abstract PiPatAmrCodeDO[] update(PiPatAmrCodeDO[] aggdos) throws BizException;
	
	/**
	*  患者病案编码数据逻辑删除
	*/
	public abstract void logicDelete(PiPatAmrCodeDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PiPatAmrCodeDO[] enableWithoutFilter(PiPatAmrCodeDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PiPatAmrCodeDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PiPatAmrCodeDO[] disableVOWithoutFilter(PiPatAmrCodeDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PiPatAmrCodeDO[] dos) throws BizException ;
}
