package iih.bd.pp.srvspecround.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.srvspecround.d.SrvSpecRoundDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 项目计费特殊取整方式数据维护服务
*/
public interface ISrvspecroundCudService {
	/**
	*  项目计费特殊取整方式数据真删除
	*/
    public abstract void delete(SrvSpecRoundDO[] aggdos) throws BizException;
    
    /**
	*  项目计费特殊取整方式数据插入保存
	*/
	public abstract SrvSpecRoundDO[] insert(SrvSpecRoundDO[] aggdos) throws BizException;
	
    /**
	*  项目计费特殊取整方式数据保存
	*/
	public abstract SrvSpecRoundDO[] save(SrvSpecRoundDO[] aggdos) throws BizException;
	
    /**
	*  项目计费特殊取整方式数据更新
	*/
	public abstract SrvSpecRoundDO[] update(SrvSpecRoundDO[] aggdos) throws BizException;
	
	/**
	*  项目计费特殊取整方式数据逻辑删除
	*/
	public abstract void logicDelete(SrvSpecRoundDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SrvSpecRoundDO[] enableWithoutFilter(SrvSpecRoundDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SrvSpecRoundDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SrvSpecRoundDO[] disableVOWithoutFilter(SrvSpecRoundDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SrvSpecRoundDO[] dos) throws BizException ;
}
