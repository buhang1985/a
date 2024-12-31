package iih.pe.por.pelogpsnbinfo.i;

import xap.mw.core.data.BizException;
import iih.pe.por.pelogpsnbinfo.d.PeLogPsnBInfoDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检日志客户基本资料数据维护服务
*/
public interface IPelogpsnbinfoCudService {
	/**
	*  体检日志客户基本资料数据真删除
	*/
    public abstract void delete(PeLogPsnBInfoDO[] aggdos) throws BizException;
    
    /**
	*  体检日志客户基本资料数据插入保存
	*/
	public abstract PeLogPsnBInfoDO[] insert(PeLogPsnBInfoDO[] aggdos) throws BizException;
	
    /**
	*  体检日志客户基本资料数据保存
	*/
	public abstract PeLogPsnBInfoDO[] save(PeLogPsnBInfoDO[] aggdos) throws BizException;
	
    /**
	*  体检日志客户基本资料数据更新
	*/
	public abstract PeLogPsnBInfoDO[] update(PeLogPsnBInfoDO[] aggdos) throws BizException;
	
	/**
	*  体检日志客户基本资料数据逻辑删除
	*/
	public abstract void logicDelete(PeLogPsnBInfoDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeLogPsnBInfoDO[] enableWithoutFilter(PeLogPsnBInfoDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeLogPsnBInfoDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeLogPsnBInfoDO[] disableVOWithoutFilter(PeLogPsnBInfoDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeLogPsnBInfoDO[] dos) throws BizException ;
}
