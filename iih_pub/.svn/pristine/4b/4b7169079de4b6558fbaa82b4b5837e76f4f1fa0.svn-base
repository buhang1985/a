package iih.pi.reg.pat.i;

import xap.mw.core.data.BizException;
import iih.pi.reg.pat.d.PiPatCardDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 患者基本信息数据维护服务
*/
public interface IPiPatCardDOCudService {
	/**
	*  患者基本信息数据真删除
	*/
    public abstract void delete(PiPatCardDO[] aggdos) throws BizException;
    
    /**
	*  患者基本信息数据插入保存
	*/
	public abstract PiPatCardDO[] insert(PiPatCardDO[] aggdos) throws BizException;
	
    /**
	*  患者基本信息数据保存
	*/
	public abstract PiPatCardDO[] save(PiPatCardDO[] aggdos) throws BizException;
	
    /**
	*  患者基本信息数据更新
	*/
	public abstract PiPatCardDO[] update(PiPatCardDO[] aggdos) throws BizException;
	
	/**
	*  患者基本信息数据逻辑删除
	*/
	public abstract void logicDelete(PiPatCardDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PiPatCardDO[] enableWithoutFilter(PiPatCardDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PiPatCardDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PiPatCardDO[] disableVOWithoutFilter(PiPatCardDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PiPatCardDO[] aggdos) throws BizException ;
	
}
