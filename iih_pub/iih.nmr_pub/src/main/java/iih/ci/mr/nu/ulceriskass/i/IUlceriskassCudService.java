package iih.ci.mr.nu.ulceriskass.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.ulceriskass.d.PulceriskAssDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* Braden压疮风险评定单数据维护服务
*/
public interface IUlceriskassCudService {
	/**
	*  Braden压疮风险评定单数据真删除
	*/
    public abstract void delete(PulceriskAssDO[] aggdos) throws BizException;
    
    /**
	*  Braden压疮风险评定单数据插入保存
	*/
	public abstract PulceriskAssDO[] insert(PulceriskAssDO[] aggdos) throws BizException;
	
    /**
	*  Braden压疮风险评定单数据保存
	*/
	public abstract PulceriskAssDO[] save(PulceriskAssDO[] aggdos) throws BizException;
	
    /**
	*  Braden压疮风险评定单数据更新
	*/
	public abstract PulceriskAssDO[] update(PulceriskAssDO[] aggdos) throws BizException;
	
	/**
	*  Braden压疮风险评定单数据逻辑删除
	*/
	public abstract void logicDelete(PulceriskAssDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PulceriskAssDO[] enableWithoutFilter(PulceriskAssDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PulceriskAssDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PulceriskAssDO[] disableVOWithoutFilter(PulceriskAssDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PulceriskAssDO[] dos) throws BizException ;
}
