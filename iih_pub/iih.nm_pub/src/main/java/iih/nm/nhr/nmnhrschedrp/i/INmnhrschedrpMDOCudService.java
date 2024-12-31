package iih.nm.nhr.nmnhrschedrp.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmnhrschedrp.d.NhrSchedRpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 替班申请数据维护服务
*/
public interface INmnhrschedrpMDOCudService {
	/**
	*  替班申请数据真删除
	*/
    public abstract void delete(NhrSchedRpDO[] aggdos) throws BizException;
    
    /**
	*  替班申请数据插入保存
	*/
	public abstract NhrSchedRpDO[] insert(NhrSchedRpDO[] aggdos) throws BizException;
	
    /**
	*  替班申请数据保存
	*/
	public abstract NhrSchedRpDO[] save(NhrSchedRpDO[] aggdos) throws BizException;
	
    /**
	*  替班申请数据更新
	*/
	public abstract NhrSchedRpDO[] update(NhrSchedRpDO[] aggdos) throws BizException;
	
	/**
	*  替班申请数据逻辑删除
	*/
	public abstract void logicDelete(NhrSchedRpDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NhrSchedRpDO[] enableWithoutFilter(NhrSchedRpDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NhrSchedRpDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NhrSchedRpDO[] disableVOWithoutFilter(NhrSchedRpDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NhrSchedRpDO[] aggdos) throws BizException ;
	
}
