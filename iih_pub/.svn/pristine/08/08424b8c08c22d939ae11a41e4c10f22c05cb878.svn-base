package iih.bd.pp.accountsrv.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.accountsrv.d.AccountSrvDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 核算科目与收费项目的关联关系数据维护服务
*/
public interface IAccountsrvCudService {
	/**
	*  核算科目与收费项目的关联关系数据真删除
	*/
    public abstract void delete(AccountSrvDO[] aggdos) throws BizException;
    
    /**
	*  核算科目与收费项目的关联关系数据插入保存
	*/
	public abstract AccountSrvDO[] insert(AccountSrvDO[] aggdos) throws BizException;
	
    /**
	*  核算科目与收费项目的关联关系数据保存
	*/
	public abstract AccountSrvDO[] save(AccountSrvDO[] aggdos) throws BizException;
	
    /**
	*  核算科目与收费项目的关联关系数据更新
	*/
	public abstract AccountSrvDO[] update(AccountSrvDO[] aggdos) throws BizException;
	
	/**
	*  核算科目与收费项目的关联关系数据逻辑删除
	*/
	public abstract void logicDelete(AccountSrvDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public AccountSrvDO[] enableWithoutFilter(AccountSrvDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(AccountSrvDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public AccountSrvDO[] disableVOWithoutFilter(AccountSrvDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(AccountSrvDO[] dos) throws BizException ;
}
