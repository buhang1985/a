package iih.cssd.dpus.dfpisu.i;

import xap.mw.core.data.BizException;
import iih.cssd.dpus.dfpisu.d.DfpSendDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 消毒包发放数据维护服务
*/
public interface IDfpisuCudService {
	/**
	*  消毒包发放数据真删除
	*/
    public abstract void delete(DfpSendDO[] aggdos) throws BizException;
    
    /**
	*  消毒包发放数据插入保存
	*/
	public abstract DfpSendDO[] insert(DfpSendDO[] aggdos) throws BizException;
	
    /**
	*  消毒包发放数据保存
	*/
	public abstract DfpSendDO[] save(DfpSendDO[] aggdos) throws BizException;
	
    /**
	*  消毒包发放数据更新
	*/
	public abstract DfpSendDO[] update(DfpSendDO[] aggdos) throws BizException;
	
	/**
	*  消毒包发放数据逻辑删除
	*/
	public abstract void logicDelete(DfpSendDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DfpSendDO[] enableWithoutFilter(DfpSendDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DfpSendDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DfpSendDO[] disableVOWithoutFilter(DfpSendDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DfpSendDO[] dos) throws BizException ;
}
