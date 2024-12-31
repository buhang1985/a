package iih.nm.nhr.nhrresignrec.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nhrresignrec.d.NhrResignRecDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 人员辞职记录数据维护服务
*/
public interface INhrresignrecCudService {
	/**
	*  人员辞职记录数据真删除
	*/
    public abstract void delete(NhrResignRecDO[] aggdos) throws BizException;
    
    /**
	*  人员辞职记录数据插入保存
	*/
	public abstract NhrResignRecDO[] insert(NhrResignRecDO[] aggdos) throws BizException;
	
    /**
	*  人员辞职记录数据保存
	*/
	public abstract NhrResignRecDO[] save(NhrResignRecDO[] aggdos) throws BizException;
	
    /**
	*  人员辞职记录数据更新
	*/
	public abstract NhrResignRecDO[] update(NhrResignRecDO[] aggdos) throws BizException;
	
	/**
	*  人员辞职记录数据逻辑删除
	*/
	public abstract void logicDelete(NhrResignRecDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NhrResignRecDO[] enableWithoutFilter(NhrResignRecDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NhrResignRecDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NhrResignRecDO[] disableVOWithoutFilter(NhrResignRecDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NhrResignRecDO[] dos) throws BizException ;
}
