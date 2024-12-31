package iih.ci.mr.nu.dvtriskass.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.dvtriskass.d.DvtriskasslistDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* DVT风险评估单数据维护服务
*/
public interface IDvtriskasslistDOCudService {
	/**
	*  DVT风险评估单数据真删除
	*/
    public abstract void delete(DvtriskasslistDO[] aggdos) throws BizException;
    
    /**
	*  DVT风险评估单数据插入保存
	*/
	public abstract DvtriskasslistDO[] insert(DvtriskasslistDO[] aggdos) throws BizException;
	
    /**
	*  DVT风险评估单数据保存
	*/
	public abstract DvtriskasslistDO[] save(DvtriskasslistDO[] aggdos) throws BizException;
	
    /**
	*  DVT风险评估单数据更新
	*/
	public abstract DvtriskasslistDO[] update(DvtriskasslistDO[] aggdos) throws BizException;
	
	/**
	*  DVT风险评估单数据逻辑删除
	*/
	public abstract void logicDelete(DvtriskasslistDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DvtriskasslistDO[] enableWithoutFilter(DvtriskasslistDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DvtriskasslistDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DvtriskasslistDO[] disableVOWithoutFilter(DvtriskasslistDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DvtriskasslistDO[] aggdos) throws BizException ;
	
}
