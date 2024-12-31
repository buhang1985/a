package iih.pi.acc.piaccbank.i;

import xap.mw.core.data.BizException;
import iih.pi.acc.piaccbank.d.PiPatCredBankDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 组件数据维护服务
*/
public interface IPiaccbankCudService {
	/**
	*  组件数据删除
	*/
    public abstract void logicDelete(PiPatCredBankDO[] aggdos) throws BizException;
    
    /**
	*  组件数据插入保存
	*/
	public abstract PiPatCredBankDO[] insert(PiPatCredBankDO[] aggdos) throws BizException;
	
    /**
	*  组件数据保存
	*/
	public abstract PiPatCredBankDO[] save(PiPatCredBankDO[] aggdos) throws BizException;
	
    /**
	*  组件数据更新
	*/
	public abstract PiPatCredBankDO[] update(PiPatCredBankDO[] aggdos) throws BizException;
	
	/**
	*  组件数据真删
	*/
	public abstract void delete(PiPatCredBankDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PiPatCredBankDO[] enableWithoutFilter(PiPatCredBankDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PiPatCredBankDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PiPatCredBankDO[] disableVOWithoutFilter(PiPatCredBankDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PiPatCredBankDO[] aggdos) throws BizException ;
}
