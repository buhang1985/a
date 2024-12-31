package iih.pe.phm.perstrisks.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.perstrisks.d.PeRstRisksDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 健康危险因素汇总数据维护服务
*/
public interface IPerstrisksCudService {
	/**
	*  健康危险因素汇总数据真删除
	*/
    public abstract void delete(PeRstRisksDO[] aggdos) throws BizException;
    
    /**
	*  健康危险因素汇总数据插入保存
	*/
	public abstract PeRstRisksDO[] insert(PeRstRisksDO[] aggdos) throws BizException;
	
    /**
	*  健康危险因素汇总数据保存
	*/
	public abstract PeRstRisksDO[] save(PeRstRisksDO[] aggdos) throws BizException;
	
    /**
	*  健康危险因素汇总数据更新
	*/
	public abstract PeRstRisksDO[] update(PeRstRisksDO[] aggdos) throws BizException;
	
	/**
	*  健康危险因素汇总数据逻辑删除
	*/
	public abstract void logicDelete(PeRstRisksDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeRstRisksDO[] enableWithoutFilter(PeRstRisksDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeRstRisksDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeRstRisksDO[] disableVOWithoutFilter(PeRstRisksDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeRstRisksDO[] dos) throws BizException ;
}
