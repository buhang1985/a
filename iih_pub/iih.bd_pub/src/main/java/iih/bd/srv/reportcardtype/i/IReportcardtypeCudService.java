package iih.bd.srv.reportcardtype.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.reportcardtype.d.EmrReportCardTypeDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 报卡类型数据维护服务
*/
public interface IReportcardtypeCudService {
	/**
	*  报卡类型数据真删除
	*/
    public abstract void delete(EmrReportCardTypeDO[] aggdos) throws BizException;
    
    /**
	*  报卡类型数据插入保存
	*/
	public abstract EmrReportCardTypeDO[] insert(EmrReportCardTypeDO[] aggdos) throws BizException;
	
    /**
	*  报卡类型数据保存
	*/
	public abstract EmrReportCardTypeDO[] save(EmrReportCardTypeDO[] aggdos) throws BizException;
	
    /**
	*  报卡类型数据更新
	*/
	public abstract EmrReportCardTypeDO[] update(EmrReportCardTypeDO[] aggdos) throws BizException;
	
	/**
	*  报卡类型数据逻辑删除
	*/
	public abstract void logicDelete(EmrReportCardTypeDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EmrReportCardTypeDO[] enableWithoutFilter(EmrReportCardTypeDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EmrReportCardTypeDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EmrReportCardTypeDO[] disableVOWithoutFilter(EmrReportCardTypeDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EmrReportCardTypeDO[] dos) throws BizException ;
}
