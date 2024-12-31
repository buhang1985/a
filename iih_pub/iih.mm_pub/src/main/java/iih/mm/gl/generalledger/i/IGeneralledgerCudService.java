package iih.mm.gl.generalledger.i;

import xap.mw.core.data.BizException;
import iih.mm.gl.generalledger.d.GeneralLedgerDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 总账数据维护服务
*/
public interface IGeneralledgerCudService {
	/**
	*  总账数据删除
	*/
    public abstract void logicDelete(GeneralLedgerDO[] aggdos) throws BizException;
    
    /**
	*  总账数据插入保存
	*/
	public abstract GeneralLedgerDO[] insert(GeneralLedgerDO[] aggdos) throws BizException;
	
    /**
	*  总账数据保存
	*/
	public abstract GeneralLedgerDO[] save(GeneralLedgerDO[] aggdos) throws BizException;
	
    /**
	*  总账数据更新
	*/
	public abstract GeneralLedgerDO[] update(GeneralLedgerDO[] aggdos) throws BizException;
	
	/**
	*  总账数据真删
	*/
	public abstract void delete(GeneralLedgerDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public GeneralLedgerDO[] enableWithoutFilter(GeneralLedgerDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(GeneralLedgerDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public GeneralLedgerDO[] disableVOWithoutFilter(GeneralLedgerDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(GeneralLedgerDO[] aggdos) throws BizException ;
}
