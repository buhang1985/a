package iih.ci.rcm.reportcarddocfs.i;

import iih.ci.rcm.reportcarddoc.d.ReportCardDocDo;
import iih.ci.rcm.reportcarddocfs.d.ReportCardDocFsDo;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 报卡文书流表数据维护服务
*/
public interface IReportcarddocfsCudService {
	/**
	*  报卡文书流表数据真删除
	*/
    public abstract void delete(ReportCardDocFsDo[] aggdos) throws BizException;
    
    /**
	*  报卡文书流表数据插入保存
	*/
	public abstract ReportCardDocFsDo[] insert(ReportCardDocFsDo[] aggdos) throws BizException;
	
    /**
	*  报卡文书流表数据保存
	*/
	public abstract ReportCardDocFsDo[] save(ReportCardDocFsDo[] aggdos) throws BizException;
	
    /**
	*  报卡文书流表数据更新
	*/
	public abstract ReportCardDocFsDo[] update(ReportCardDocFsDo[] aggdos) throws BizException;
	
	/**
	*  报卡文书流表数据逻辑删除
	*/
	public abstract void logicDelete(ReportCardDocFsDo[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ReportCardDocFsDo[] enableWithoutFilter(ReportCardDocFsDo[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ReportCardDocFsDo[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ReportCardDocFsDo[] disableVOWithoutFilter(ReportCardDocFsDo[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ReportCardDocFsDo[] dos) throws BizException ;
	
	
	


}
