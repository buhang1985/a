package iih.nmr.ha.tcho.tchopulceriskass.i;

import xap.mw.core.data.BizException;
import iih.nmr.ha.tcho.tchopulceriskass.d.TchoPulceriskAssDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 压疮风险评分单数据维护服务
*/
public interface ITchopulceriskassCudService {
	/**
	*  压疮风险评分单数据真删除
	*/
    public abstract void delete(TchoPulceriskAssDO[] aggdos) throws BizException;
    
    /**
	*  压疮风险评分单数据插入保存
	*/
	public abstract TchoPulceriskAssDO[] insert(TchoPulceriskAssDO[] aggdos) throws BizException;
	
    /**
	*  压疮风险评分单数据保存
	*/
	public abstract TchoPulceriskAssDO[] save(TchoPulceriskAssDO[] aggdos) throws BizException;
	
    /**
	*  压疮风险评分单数据更新
	*/
	public abstract TchoPulceriskAssDO[] update(TchoPulceriskAssDO[] aggdos) throws BizException;
	
	/**
	*  压疮风险评分单数据逻辑删除
	*/
	public abstract void logicDelete(TchoPulceriskAssDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public TchoPulceriskAssDO[] enableWithoutFilter(TchoPulceriskAssDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(TchoPulceriskAssDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public TchoPulceriskAssDO[] disableVOWithoutFilter(TchoPulceriskAssDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(TchoPulceriskAssDO[] dos) throws BizException ;
}
