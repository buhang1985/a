package iih.nm.nit.nitpracgrppl.i;

import xap.mw.core.data.BizException;
import iih.nm.nit.nitpracgrppl.d.NitPracgrpPlDepDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 小组计划数据维护服务
*/
public interface INitPracgrpPlDepDOCudService {
	/**
	*  小组计划数据真删除
	*/
    public abstract void delete(NitPracgrpPlDepDO[] aggdos) throws BizException;
    
    /**
	*  小组计划数据插入保存
	*/
	public abstract NitPracgrpPlDepDO[] insert(NitPracgrpPlDepDO[] aggdos) throws BizException;
	
    /**
	*  小组计划数据保存
	*/
	public abstract NitPracgrpPlDepDO[] save(NitPracgrpPlDepDO[] aggdos) throws BizException;
	
    /**
	*  小组计划数据更新
	*/
	public abstract NitPracgrpPlDepDO[] update(NitPracgrpPlDepDO[] aggdos) throws BizException;
	
	/**
	*  小组计划数据逻辑删除
	*/
	public abstract void logicDelete(NitPracgrpPlDepDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NitPracgrpPlDepDO[] enableWithoutFilter(NitPracgrpPlDepDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NitPracgrpPlDepDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NitPracgrpPlDepDO[] disableVOWithoutFilter(NitPracgrpPlDepDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NitPracgrpPlDepDO[] aggdos) throws BizException ;
	
}
