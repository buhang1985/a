package iih.en.pv.enfee.i;

import xap.mw.core.data.BizException;
import iih.en.pv.enfee.d.EnPeCmpyACCDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 团检账户数据维护服务
*/
public interface IEnpecmpyaccCudService {
	/**
	*  团检账户数据真删除
	*/
    public abstract void delete(EnPeCmpyACCDO[] aggdos) throws BizException;
    
    /**
	*  团检账户数据插入保存
	*/
	public abstract EnPeCmpyACCDO[] insert(EnPeCmpyACCDO[] aggdos) throws BizException;
	
    /**
	*  团检账户数据保存
	*/
	public abstract EnPeCmpyACCDO[] save(EnPeCmpyACCDO[] aggdos) throws BizException;
	
    /**
	*  团检账户数据更新
	*/
	public abstract EnPeCmpyACCDO[] update(EnPeCmpyACCDO[] aggdos) throws BizException;
	
	/**
	*  团检账户数据逻辑删除
	*/
	public abstract void logicDelete(EnPeCmpyACCDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EnPeCmpyACCDO[] enableWithoutFilter(EnPeCmpyACCDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EnPeCmpyACCDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EnPeCmpyACCDO[] disableVOWithoutFilter(EnPeCmpyACCDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EnPeCmpyACCDO[] dos) throws BizException ;
}
