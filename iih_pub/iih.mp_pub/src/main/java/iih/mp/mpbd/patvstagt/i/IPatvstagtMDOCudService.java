package iih.mp.mpbd.patvstagt.i;

import xap.mw.core.data.BizException;
import iih.mp.mpbd.patvstagt.d.PatVsTagtDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 患者体征采集指标数据维护服务
*/
public interface IPatvstagtMDOCudService {
	/**
	*  患者体征采集指标数据真删除
	*/
    public abstract void delete(PatVsTagtDO[] aggdos) throws BizException;
    
    /**
	*  患者体征采集指标数据插入保存
	*/
	public abstract PatVsTagtDO[] insert(PatVsTagtDO[] aggdos) throws BizException;
	
    /**
	*  患者体征采集指标数据保存
	*/
	public abstract PatVsTagtDO[] save(PatVsTagtDO[] aggdos) throws BizException;
	
    /**
	*  患者体征采集指标数据更新
	*/
	public abstract PatVsTagtDO[] update(PatVsTagtDO[] aggdos) throws BizException;
	
	/**
	*  患者体征采集指标数据逻辑删除
	*/
	public abstract void logicDelete(PatVsTagtDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PatVsTagtDO[] enableWithoutFilter(PatVsTagtDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PatVsTagtDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PatVsTagtDO[] disableVOWithoutFilter(PatVsTagtDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PatVsTagtDO[] aggdos) throws BizException ;
	
}
