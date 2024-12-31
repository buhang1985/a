package iih.nm.nqm.nmnqmspcs.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nmnqmspcs.d.NmNqmSpcsKpiDo;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 护理管理_专科护理质量数据维护服务
*/
public interface INmNqmSpcsKpiDoCudService {
	/**
	*  护理管理_专科护理质量数据真删除
	*/
    public abstract void delete(NmNqmSpcsKpiDo[] aggdos) throws BizException;
    
    /**
	*  护理管理_专科护理质量数据插入保存
	*/
	public abstract NmNqmSpcsKpiDo[] insert(NmNqmSpcsKpiDo[] aggdos) throws BizException;
	
    /**
	*  护理管理_专科护理质量数据保存
	*/
	public abstract NmNqmSpcsKpiDo[] save(NmNqmSpcsKpiDo[] aggdos) throws BizException;
	
    /**
	*  护理管理_专科护理质量数据更新
	*/
	public abstract NmNqmSpcsKpiDo[] update(NmNqmSpcsKpiDo[] aggdos) throws BizException;
	
	/**
	*  护理管理_专科护理质量数据逻辑删除
	*/
	public abstract void logicDelete(NmNqmSpcsKpiDo[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNqmSpcsKpiDo[] enableWithoutFilter(NmNqmSpcsKpiDo[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNqmSpcsKpiDo[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNqmSpcsKpiDo[] disableVOWithoutFilter(NmNqmSpcsKpiDo[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNqmSpcsKpiDo[] aggdos) throws BizException ;
	
}
