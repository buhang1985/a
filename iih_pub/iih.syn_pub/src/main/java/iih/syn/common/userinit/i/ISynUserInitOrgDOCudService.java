package iih.syn.common.userinit.i;

import xap.mw.core.data.BizException;
import iih.syn.common.userinit.d.SynUserInitOrgDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 用户同步初始化数据维护服务
*/
public interface ISynUserInitOrgDOCudService {
	/**
	*  用户同步初始化数据真删除
	*/
    public abstract void delete(SynUserInitOrgDO[] aggdos) throws BizException;
    
    /**
	*  用户同步初始化数据插入保存
	*/
	public abstract SynUserInitOrgDO[] insert(SynUserInitOrgDO[] aggdos) throws BizException;
	
    /**
	*  用户同步初始化数据保存
	*/
	public abstract SynUserInitOrgDO[] save(SynUserInitOrgDO[] aggdos) throws BizException;
	
    /**
	*  用户同步初始化数据更新
	*/
	public abstract SynUserInitOrgDO[] update(SynUserInitOrgDO[] aggdos) throws BizException;
	
	/**
	*  用户同步初始化数据逻辑删除
	*/
	public abstract void logicDelete(SynUserInitOrgDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SynUserInitOrgDO[] enableWithoutFilter(SynUserInitOrgDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SynUserInitOrgDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SynUserInitOrgDO[] disableVOWithoutFilter(SynUserInitOrgDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SynUserInitOrgDO[] aggdos) throws BizException ;
	
}
