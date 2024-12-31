package iih.bd.srv.condi.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.condi.d.ConDiDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 传染病对应诊断数据维护服务
*/
public interface ICondiCudService {
	/**
	*  传染病对应诊断数据真删除
	*/
    public abstract void delete(ConDiDO[] aggdos) throws BizException;
    
    /**
	*  传染病对应诊断数据插入保存
	*/
	public abstract ConDiDO[] insert(ConDiDO[] aggdos) throws BizException;
	
    /**
	*  传染病对应诊断数据保存
	*/
	public abstract ConDiDO[] save(ConDiDO[] aggdos) throws BizException;
	
    /**
	*  传染病对应诊断数据更新
	*/
	public abstract ConDiDO[] update(ConDiDO[] aggdos) throws BizException;
	
	/**
	*  传染病对应诊断数据逻辑删除
	*/
	public abstract void logicDelete(ConDiDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ConDiDO[] enableWithoutFilter(ConDiDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ConDiDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ConDiDO[] disableVOWithoutFilter(ConDiDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ConDiDO[] dos) throws BizException ;
}
