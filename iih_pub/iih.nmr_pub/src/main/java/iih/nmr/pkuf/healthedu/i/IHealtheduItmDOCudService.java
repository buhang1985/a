package iih.nmr.pkuf.healthedu.i;

import xap.mw.core.data.BizException;
import iih.nmr.pkuf.healthedu.d.HealtheduItmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 健康教育计划执行单数据维护服务
*/
public interface IHealtheduItmDOCudService {
	/**
	*  健康教育计划执行单数据真删除
	*/
    public abstract void delete(HealtheduItmDO[] aggdos) throws BizException;
    
    /**
	*  健康教育计划执行单数据插入保存
	*/
	public abstract HealtheduItmDO[] insert(HealtheduItmDO[] aggdos) throws BizException;
	
    /**
	*  健康教育计划执行单数据保存
	*/
	public abstract HealtheduItmDO[] save(HealtheduItmDO[] aggdos) throws BizException;
	
    /**
	*  健康教育计划执行单数据更新
	*/
	public abstract HealtheduItmDO[] update(HealtheduItmDO[] aggdos) throws BizException;
	
	/**
	*  健康教育计划执行单数据逻辑删除
	*/
	public abstract void logicDelete(HealtheduItmDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HealtheduItmDO[] enableWithoutFilter(HealtheduItmDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HealtheduItmDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HealtheduItmDO[] disableVOWithoutFilter(HealtheduItmDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HealtheduItmDO[] aggdos) throws BizException ;
	
}
