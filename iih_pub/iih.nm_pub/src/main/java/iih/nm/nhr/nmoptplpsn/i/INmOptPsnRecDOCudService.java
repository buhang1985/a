package iih.nm.nhr.nmoptplpsn.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmoptplpsn.d.NmOptPsnRecDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 实习计划_参与人员数据维护服务
*/
public interface INmOptPsnRecDOCudService {
	/**
	*  实习计划_参与人员数据真删除
	*/
    public abstract void delete(NmOptPsnRecDO[] aggdos) throws BizException;
    
    /**
	*  实习计划_参与人员数据插入保存
	*/
	public abstract NmOptPsnRecDO[] insert(NmOptPsnRecDO[] aggdos) throws BizException;
	
    /**
	*  实习计划_参与人员数据保存
	*/
	public abstract NmOptPsnRecDO[] save(NmOptPsnRecDO[] aggdos) throws BizException;
	
    /**
	*  实习计划_参与人员数据更新
	*/
	public abstract NmOptPsnRecDO[] update(NmOptPsnRecDO[] aggdos) throws BizException;
	
	/**
	*  实习计划_参与人员数据逻辑删除
	*/
	public abstract void logicDelete(NmOptPsnRecDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmOptPsnRecDO[] enableWithoutFilter(NmOptPsnRecDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmOptPsnRecDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmOptPsnRecDO[] disableVOWithoutFilter(NmOptPsnRecDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmOptPsnRecDO[] aggdos) throws BizException ;
	
}
