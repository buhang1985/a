package iih.mp.mpbd.patvstagt.i;

import xap.mw.core.data.BizException;
import iih.mp.mpbd.patvstagt.d.PatVsTagtTimeDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 患者体征采集指标数据维护服务
*/
public interface IPatVsTagtTimeDOCudService {
	/**
	*  患者体征采集指标数据真删除
	*/
    public abstract void delete(PatVsTagtTimeDO[] aggdos) throws BizException;
    
    /**
	*  患者体征采集指标数据插入保存
	*/
	public abstract PatVsTagtTimeDO[] insert(PatVsTagtTimeDO[] aggdos) throws BizException;
	
    /**
	*  患者体征采集指标数据保存
	*/
	public abstract PatVsTagtTimeDO[] save(PatVsTagtTimeDO[] aggdos) throws BizException;
	
    /**
	*  患者体征采集指标数据更新
	*/
	public abstract PatVsTagtTimeDO[] update(PatVsTagtTimeDO[] aggdos) throws BizException;
	
	/**
	*  患者体征采集指标数据逻辑删除
	*/
	public abstract void logicDelete(PatVsTagtTimeDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PatVsTagtTimeDO[] enableWithoutFilter(PatVsTagtTimeDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PatVsTagtTimeDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PatVsTagtTimeDO[] disableVOWithoutFilter(PatVsTagtTimeDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PatVsTagtTimeDO[] aggdos) throws BizException ;
	
}
