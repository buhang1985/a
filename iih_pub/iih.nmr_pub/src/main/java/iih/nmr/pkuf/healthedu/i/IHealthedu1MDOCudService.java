package iih.nmr.pkuf.healthedu.i;

import xap.mw.core.data.BizException;
import iih.nmr.pkuf.healthedu.d.HealtheduDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 健康教育计划执行单数据维护服务
*/
public interface IHealthedu1MDOCudService {
	/**
	*  健康教育计划执行单数据真删除
	*/
    public abstract void delete(HealtheduDO[] aggdos) throws BizException;
    
    /**
	*  健康教育计划执行单数据插入保存
	*/
	public abstract HealtheduDO[] insert(HealtheduDO[] aggdos) throws BizException;
	
    /**
	*  健康教育计划执行单数据保存
	*/
	public abstract HealtheduDO[] save(HealtheduDO[] aggdos) throws BizException;
	
    /**
	*  健康教育计划执行单数据更新
	*/
	public abstract HealtheduDO[] update(HealtheduDO[] aggdos) throws BizException;
	
	/**
	*  健康教育计划执行单数据逻辑删除
	*/
	public abstract void logicDelete(HealtheduDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HealtheduDO[] enableWithoutFilter(HealtheduDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HealtheduDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HealtheduDO[] disableVOWithoutFilter(HealtheduDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HealtheduDO[] aggdos) throws BizException ;
	
}
