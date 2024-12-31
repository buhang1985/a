package iih.nm.nit.nitpracgrppl.i;

import xap.mw.core.data.BizException;
import iih.nm.nit.nitpracgrppl.d.NitPracGrpPlPsnDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 小组计划数据维护服务
*/
public interface INitPracGrpPlPsnDOCudService {
	/**
	*  小组计划数据真删除
	*/
    public abstract void delete(NitPracGrpPlPsnDO[] aggdos) throws BizException;
    
    /**
	*  小组计划数据插入保存
	*/
	public abstract NitPracGrpPlPsnDO[] insert(NitPracGrpPlPsnDO[] aggdos) throws BizException;
	
    /**
	*  小组计划数据保存
	*/
	public abstract NitPracGrpPlPsnDO[] save(NitPracGrpPlPsnDO[] aggdos) throws BizException;
	
    /**
	*  小组计划数据更新
	*/
	public abstract NitPracGrpPlPsnDO[] update(NitPracGrpPlPsnDO[] aggdos) throws BizException;
	
	/**
	*  小组计划数据逻辑删除
	*/
	public abstract void logicDelete(NitPracGrpPlPsnDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NitPracGrpPlPsnDO[] enableWithoutFilter(NitPracGrpPlPsnDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NitPracGrpPlPsnDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NitPracGrpPlPsnDO[] disableVOWithoutFilter(NitPracGrpPlPsnDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NitPracGrpPlPsnDO[] aggdos) throws BizException ;
	
}
