package iih.nm.nqm.nqmcssty.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nqmcssty.d.NqmCsStyItmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 质量检查表样式数据维护服务
*/
public interface INqmCsStyItmDOCudService {
	/**
	*  质量检查表样式数据真删除
	*/
    public abstract void delete(NqmCsStyItmDO[] aggdos) throws BizException;
    
    /**
	*  质量检查表样式数据插入保存
	*/
	public abstract NqmCsStyItmDO[] insert(NqmCsStyItmDO[] aggdos) throws BizException;
	
    /**
	*  质量检查表样式数据保存
	*/
	public abstract NqmCsStyItmDO[] save(NqmCsStyItmDO[] aggdos) throws BizException;
	
    /**
	*  质量检查表样式数据更新
	*/
	public abstract NqmCsStyItmDO[] update(NqmCsStyItmDO[] aggdos) throws BizException;
	
	/**
	*  质量检查表样式数据逻辑删除
	*/
	public abstract void logicDelete(NqmCsStyItmDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NqmCsStyItmDO[] enableWithoutFilter(NqmCsStyItmDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NqmCsStyItmDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NqmCsStyItmDO[] disableVOWithoutFilter(NqmCsStyItmDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NqmCsStyItmDO[] aggdos) throws BizException ;
	
}
