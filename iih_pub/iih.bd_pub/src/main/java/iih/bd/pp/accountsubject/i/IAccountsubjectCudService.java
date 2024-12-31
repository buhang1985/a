package iih.bd.pp.accountsubject.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.accountsubject.d.AccountSubjectDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 核算科目数据维护服务
*/
public interface IAccountsubjectCudService {
	/**
	*  核算科目数据真删除
	*/
    public abstract void delete(AccountSubjectDO[] aggdos) throws BizException;
    
    /**
	*  核算科目数据插入保存
	*/
	public abstract AccountSubjectDO[] insert(AccountSubjectDO[] aggdos) throws BizException;
	
    /**
	*  核算科目数据保存
	*/
	public abstract AccountSubjectDO[] save(AccountSubjectDO[] aggdos) throws BizException;
	
    /**
	*  核算科目数据更新
	*/
	public abstract AccountSubjectDO[] update(AccountSubjectDO[] aggdos) throws BizException;
	
	/**
	*  核算科目数据逻辑删除
	*/
	public abstract void logicDelete(AccountSubjectDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public AccountSubjectDO[] enableWithoutFilter(AccountSubjectDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(AccountSubjectDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public AccountSubjectDO[] disableVOWithoutFilter(AccountSubjectDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(AccountSubjectDO[] dos) throws BizException ;
}
