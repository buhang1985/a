package iih.nm.nhr.nmnureval.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmnureval.d.NmNurEvalDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 护理人员评定数据维护服务
*/
public interface INmnurevalCudService {
	/**
	*  护理人员评定数据真删除
	*/
    public abstract void delete(NmNurEvalDO[] aggdos) throws BizException;
    
    /**
	*  护理人员评定数据插入保存
	*/
	public abstract NmNurEvalDO[] insert(NmNurEvalDO[] aggdos) throws BizException;
	
    /**
	*  护理人员评定数据保存
	*/
	public abstract NmNurEvalDO[] save(NmNurEvalDO[] aggdos) throws BizException;
	
    /**
	*  护理人员评定数据更新
	*/
	public abstract NmNurEvalDO[] update(NmNurEvalDO[] aggdos) throws BizException;
	
	/**
	*  护理人员评定数据逻辑删除
	*/
	public abstract void logicDelete(NmNurEvalDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNurEvalDO[] enableWithoutFilter(NmNurEvalDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNurEvalDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNurEvalDO[] disableVOWithoutFilter(NmNurEvalDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNurEvalDO[] dos) throws BizException ;
}
