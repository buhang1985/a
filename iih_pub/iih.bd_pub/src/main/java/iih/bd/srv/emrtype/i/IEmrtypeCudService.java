package iih.bd.srv.emrtype.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.emrtype.d.MrTpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医疗记录类型数据维护服务
*/
public interface IEmrtypeCudService {
	/**
	*  医疗记录类型数据真删除
	*/
    public abstract void delete(MrTpDO[] aggdos) throws BizException;
    
    /**
	*  医疗记录类型数据插入保存
	*/
	public abstract MrTpDO[] insert(MrTpDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录类型数据保存
	*/
	public abstract MrTpDO[] save(MrTpDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录类型数据更新
	*/
	public abstract MrTpDO[] update(MrTpDO[] aggdos) throws BizException;
	
	/**
	*  医疗记录类型数据逻辑删除
	*/
	public abstract void logicDelete(MrTpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MrTpDO[] enableWithoutFilter(MrTpDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MrTpDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MrTpDO[] disableVOWithoutFilter(MrTpDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MrTpDO[] dos) throws BizException ;
}
