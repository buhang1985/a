package iih.nm.nit.nitpsncyc.i;

import xap.mw.core.data.BizException;
import iih.nm.nit.nitpsncyc.d.NitPsnCycDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 科室轮转数据维护服务
*/
public interface INitpsncycCudService {
	/**
	*  科室轮转数据真删除
	*/
    public abstract void delete(NitPsnCycDO[] aggdos) throws BizException;
    
    /**
	*  科室轮转数据插入保存
	*/
	public abstract NitPsnCycDO[] insert(NitPsnCycDO[] aggdos) throws BizException;
	
    /**
	*  科室轮转数据保存
	*/
	public abstract NitPsnCycDO[] save(NitPsnCycDO[] aggdos) throws BizException;
	
    /**
	*  科室轮转数据更新
	*/
	public abstract NitPsnCycDO[] update(NitPsnCycDO[] aggdos) throws BizException;
	
	/**
	*  科室轮转数据逻辑删除
	*/
	public abstract void logicDelete(NitPsnCycDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NitPsnCycDO[] enableWithoutFilter(NitPsnCycDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NitPsnCycDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NitPsnCycDO[] disableVOWithoutFilter(NitPsnCycDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NitPsnCycDO[] dos) throws BizException ;
}
