package iih.cssd.dpp.dfpcanc.i;

import xap.mw.core.data.BizException;
import iih.cssd.dpp.dfpcanc.d.DfpCancDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 消毒包撤销数据维护服务
*/
public interface IDfpcancCudService {
	/**
	*  消毒包撤销数据真删除
	*/
    public abstract void delete(DfpCancDO[] aggdos) throws BizException;
    
    /**
	*  消毒包撤销数据插入保存
	*/
	public abstract DfpCancDO[] insert(DfpCancDO[] aggdos) throws BizException;
	
    /**
	*  消毒包撤销数据保存
	*/
	public abstract DfpCancDO[] save(DfpCancDO[] aggdos) throws BizException;
	
    /**
	*  消毒包撤销数据更新
	*/
	public abstract DfpCancDO[] update(DfpCancDO[] aggdos) throws BizException;
	
	/**
	*  消毒包撤销数据逻辑删除
	*/
	public abstract void logicDelete(DfpCancDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DfpCancDO[] enableWithoutFilter(DfpCancDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DfpCancDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DfpCancDO[] disableVOWithoutFilter(DfpCancDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DfpCancDO[] dos) throws BizException ;
}
