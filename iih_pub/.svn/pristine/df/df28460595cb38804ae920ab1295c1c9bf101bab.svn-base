package iih.bd.srv.mrtplsec.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.mrtplsec.d.MrTplSegFsDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医疗记录模板片段流数据数据维护服务
*/
public interface IMrtplsecCudService {
	/**
	*  医疗记录模板片段流数据数据真删除
	*/
    public abstract void delete(MrTplSegFsDO[] aggdos) throws BizException;
    
    /**
	*  医疗记录模板片段流数据数据插入保存
	*/
	public abstract MrTplSegFsDO[] insert(MrTplSegFsDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录模板片段流数据数据保存
	*/
	public abstract MrTplSegFsDO[] save(MrTplSegFsDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录模板片段流数据数据更新
	*/
	public abstract MrTplSegFsDO[] update(MrTplSegFsDO[] aggdos) throws BizException;
	
	/**
	*  医疗记录模板片段流数据数据逻辑删除
	*/
	public abstract void logicDelete(MrTplSegFsDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MrTplSegFsDO[] enableWithoutFilter(MrTplSegFsDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MrTplSegFsDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MrTplSegFsDO[] disableVOWithoutFilter(MrTplSegFsDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MrTplSegFsDO[] dos) throws BizException ;
}
