package iih.bd.srv.reportcardtplstream.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.reportcardtplstream.d.Reportcardtplstream;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 报卡模板流数据维护服务
*/
public interface IReportcardtplstreamCudService {
	/**
	*  报卡模板流数据真删除
	*/
    public abstract void delete(Reportcardtplstream[] aggdos) throws BizException;
    
    /**
	*  报卡模板流数据插入保存
	*/
	public abstract Reportcardtplstream[] insert(Reportcardtplstream[] aggdos) throws BizException;
	
    /**
	*  报卡模板流数据保存
	*/
	public abstract Reportcardtplstream[] save(Reportcardtplstream[] aggdos) throws BizException;
	
    /**
	*  报卡模板流数据更新
	*/
	public abstract Reportcardtplstream[] update(Reportcardtplstream[] aggdos) throws BizException;
	
	/**
	*  报卡模板流数据逻辑删除
	*/
	public abstract void logicDelete(Reportcardtplstream[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public Reportcardtplstream[] enableWithoutFilter(Reportcardtplstream[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(Reportcardtplstream[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public Reportcardtplstream[] disableVOWithoutFilter(Reportcardtplstream[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(Reportcardtplstream[] dos) throws BizException ;
}
