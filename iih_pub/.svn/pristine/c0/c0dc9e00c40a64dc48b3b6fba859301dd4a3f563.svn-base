package iih.mp.nr.tmpchartprnt.i;

import xap.mw.core.data.BizException;
import iih.mp.nr.tmpchartprnt.d.TmpChartPrntDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体温单打印记录数据维护服务
*/
public interface ITmpchartprntCudService {
	/**
	*  体温单打印记录数据真删除
	*/
    public abstract void delete(TmpChartPrntDO[] aggdos) throws BizException;
    
    /**
	*  体温单打印记录数据插入保存
	*/
	public abstract TmpChartPrntDO[] insert(TmpChartPrntDO[] aggdos) throws BizException;
	
    /**
	*  体温单打印记录数据保存
	*/
	public abstract TmpChartPrntDO[] save(TmpChartPrntDO[] aggdos) throws BizException;
	
    /**
	*  体温单打印记录数据更新
	*/
	public abstract TmpChartPrntDO[] update(TmpChartPrntDO[] aggdos) throws BizException;
	
	/**
	*  体温单打印记录数据逻辑删除
	*/
	public abstract void logicDelete(TmpChartPrntDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public TmpChartPrntDO[] enableWithoutFilter(TmpChartPrntDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(TmpChartPrntDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public TmpChartPrntDO[] disableVOWithoutFilter(TmpChartPrntDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(TmpChartPrntDO[] dos) throws BizException ;
}
