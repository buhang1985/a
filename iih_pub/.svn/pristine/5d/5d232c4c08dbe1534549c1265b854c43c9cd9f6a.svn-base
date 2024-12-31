package iih.bd.pp.bdpripmpttpdo.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.bdpripmpttpdo.d.BdPriPmPtTpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 终端可用付款方式数据维护服务
*/
public interface IBdpripmpttpdoCudService {
	/**
	*  终端可用付款方式数据真删除
	*/
    public abstract void delete(BdPriPmPtTpDO[] aggdos) throws BizException;
    
    /**
	*  终端可用付款方式数据插入保存
	*/
	public abstract BdPriPmPtTpDO[] insert(BdPriPmPtTpDO[] aggdos) throws BizException;
	
    /**
	*  终端可用付款方式数据保存
	*/
	public abstract BdPriPmPtTpDO[] save(BdPriPmPtTpDO[] aggdos) throws BizException;
	
    /**
	*  终端可用付款方式数据更新
	*/
	public abstract BdPriPmPtTpDO[] update(BdPriPmPtTpDO[] aggdos) throws BizException;
	
	/**
	*  终端可用付款方式数据逻辑删除
	*/
	public abstract void logicDelete(BdPriPmPtTpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BdPriPmPtTpDO[] enableWithoutFilter(BdPriPmPtTpDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BdPriPmPtTpDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BdPriPmPtTpDO[] disableVOWithoutFilter(BdPriPmPtTpDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BdPriPmPtTpDO[] dos) throws BizException ;
}
