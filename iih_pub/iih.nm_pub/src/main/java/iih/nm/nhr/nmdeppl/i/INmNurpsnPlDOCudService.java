package iih.nm.nhr.nmdeppl.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmdeppl.d.NmNurpsnPlDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 实习科室轮转计划数据维护服务
*/
public interface INmNurpsnPlDOCudService {
	/**
	*  实习科室轮转计划数据真删除
	*/
    public abstract void delete(NmNurpsnPlDO[] aggdos) throws BizException;
    
    /**
	*  实习科室轮转计划数据插入保存
	*/
	public abstract NmNurpsnPlDO[] insert(NmNurpsnPlDO[] aggdos) throws BizException;
	
    /**
	*  实习科室轮转计划数据保存
	*/
	public abstract NmNurpsnPlDO[] save(NmNurpsnPlDO[] aggdos) throws BizException;
	
    /**
	*  实习科室轮转计划数据更新
	*/
	public abstract NmNurpsnPlDO[] update(NmNurpsnPlDO[] aggdos) throws BizException;
	
	/**
	*  实习科室轮转计划数据逻辑删除
	*/
	public abstract void logicDelete(NmNurpsnPlDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNurpsnPlDO[] enableWithoutFilter(NmNurpsnPlDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNurpsnPlDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNurpsnPlDO[] disableVOWithoutFilter(NmNurpsnPlDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNurpsnPlDO[] aggdos) throws BizException ;
	
}
