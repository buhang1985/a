package iih.nm.nqm.nmnqmtaskdep.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nmnqmtaskdep.d.NmNqmTaskDepDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 护理管理_检查任务明细数据维护服务
*/
public interface INmnqmtaskdepMDOCudService {
	/**
	*  护理管理_检查任务明细数据真删除
	*/
    public abstract void delete(NmNqmTaskDepDO[] aggdos) throws BizException;
    
    /**
	*  护理管理_检查任务明细数据插入保存
	*/
	public abstract NmNqmTaskDepDO[] insert(NmNqmTaskDepDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_检查任务明细数据保存
	*/
	public abstract NmNqmTaskDepDO[] save(NmNqmTaskDepDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_检查任务明细数据更新
	*/
	public abstract NmNqmTaskDepDO[] update(NmNqmTaskDepDO[] aggdos) throws BizException;
	
	/**
	*  护理管理_检查任务明细数据逻辑删除
	*/
	public abstract void logicDelete(NmNqmTaskDepDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNqmTaskDepDO[] enableWithoutFilter(NmNqmTaskDepDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNqmTaskDepDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNqmTaskDepDO[] disableVOWithoutFilter(NmNqmTaskDepDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNqmTaskDepDO[] aggdos) throws BizException ;
	
}