package iih.ci.ord.cirptobshis.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.cirptobshis.d.CiRptObsHisDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 检查报告历史数据数据维护服务
*/
public interface ICirptobshisCudService {
	/**
	*  检查报告历史数据数据真删除
	*/
    public abstract void delete(CiRptObsHisDO[] aggdos) throws BizException;
    
    /**
	*  检查报告历史数据数据插入保存
	*/
	public abstract CiRptObsHisDO[] insert(CiRptObsHisDO[] aggdos) throws BizException;
	
    /**
	*  检查报告历史数据数据保存
	*/
	public abstract CiRptObsHisDO[] save(CiRptObsHisDO[] aggdos) throws BizException;
	
    /**
	*  检查报告历史数据数据更新
	*/
	public abstract CiRptObsHisDO[] update(CiRptObsHisDO[] aggdos) throws BizException;
	
	/**
	*  检查报告历史数据数据逻辑删除
	*/
	public abstract void logicDelete(CiRptObsHisDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiRptObsHisDO[] enableWithoutFilter(CiRptObsHisDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiRptObsHisDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiRptObsHisDO[] disableVOWithoutFilter(CiRptObsHisDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiRptObsHisDO[] dos) throws BizException ;
}
