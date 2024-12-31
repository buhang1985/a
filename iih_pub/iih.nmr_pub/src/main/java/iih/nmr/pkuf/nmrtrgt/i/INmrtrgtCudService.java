package iih.nmr.pkuf.nmrtrgt.i;

import xap.mw.core.data.BizException;
import iih.nmr.pkuf.nmrtrgt.d.NmrTrgtDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 护理目标数据维护服务
*/
public interface INmrtrgtCudService {
	/**
	*  护理目标数据真删除
	*/
    public abstract void delete(NmrTrgtDO[] aggdos) throws BizException;
    
    /**
	*  护理目标数据插入保存
	*/
	public abstract NmrTrgtDO[] insert(NmrTrgtDO[] aggdos) throws BizException;
	
    /**
	*  护理目标数据保存
	*/
	public abstract NmrTrgtDO[] save(NmrTrgtDO[] aggdos) throws BizException;
	
    /**
	*  护理目标数据更新
	*/
	public abstract NmrTrgtDO[] update(NmrTrgtDO[] aggdos) throws BizException;
	
	/**
	*  护理目标数据逻辑删除
	*/
	public abstract void logicDelete(NmrTrgtDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmrTrgtDO[] enableWithoutFilter(NmrTrgtDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmrTrgtDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmrTrgtDO[] disableVOWithoutFilter(NmrTrgtDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmrTrgtDO[] dos) throws BizException ;
}
