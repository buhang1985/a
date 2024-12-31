package iih.pe.pbd.pewfcarddef.i;

import xap.mw.core.data.BizException;
import iih.pe.pbd.pewfcarddef.d.PeWfCardDefDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 流程卡设定数据维护服务
*/
public interface IPewfcarddefCudService {
	/**
	*  流程卡设定数据真删除
	*/
    public abstract void delete(PeWfCardDefDO[] aggdos) throws BizException;
    
    /**
	*  流程卡设定数据插入保存
	*/
	public abstract PeWfCardDefDO[] insert(PeWfCardDefDO[] aggdos) throws BizException;
	
    /**
	*  流程卡设定数据保存
	*/
	public abstract PeWfCardDefDO[] save(PeWfCardDefDO[] aggdos) throws BizException;
	
    /**
	*  流程卡设定数据更新
	*/
	public abstract PeWfCardDefDO[] update(PeWfCardDefDO[] aggdos) throws BizException;
	
	/**
	*  流程卡设定数据逻辑删除
	*/
	public abstract void logicDelete(PeWfCardDefDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeWfCardDefDO[] enableWithoutFilter(PeWfCardDefDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeWfCardDefDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeWfCardDefDO[] disableVOWithoutFilter(PeWfCardDefDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeWfCardDefDO[] dos) throws BizException ;
}
