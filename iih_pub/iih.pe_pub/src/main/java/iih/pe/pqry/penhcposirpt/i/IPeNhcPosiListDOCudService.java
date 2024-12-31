package iih.pe.pqry.penhcposirpt.i;

import xap.mw.core.data.BizException;
import iih.pe.pqry.penhcposirpt.d.PeNhcPosiListDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检上报报表_卫生局阳性统计数据维护服务
*/
public interface IPeNhcPosiListDOCudService {
	/**
	*  体检上报报表_卫生局阳性统计数据真删除
	*/
    public abstract void delete(PeNhcPosiListDO[] aggdos) throws BizException;
    
    /**
	*  体检上报报表_卫生局阳性统计数据插入保存
	*/
	public abstract PeNhcPosiListDO[] insert(PeNhcPosiListDO[] aggdos) throws BizException;
	
    /**
	*  体检上报报表_卫生局阳性统计数据保存
	*/
	public abstract PeNhcPosiListDO[] save(PeNhcPosiListDO[] aggdos) throws BizException;
	
    /**
	*  体检上报报表_卫生局阳性统计数据更新
	*/
	public abstract PeNhcPosiListDO[] update(PeNhcPosiListDO[] aggdos) throws BizException;
	
	/**
	*  体检上报报表_卫生局阳性统计数据逻辑删除
	*/
	public abstract void logicDelete(PeNhcPosiListDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeNhcPosiListDO[] enableWithoutFilter(PeNhcPosiListDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeNhcPosiListDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeNhcPosiListDO[] disableVOWithoutFilter(PeNhcPosiListDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeNhcPosiListDO[] aggdos) throws BizException ;
	
}
