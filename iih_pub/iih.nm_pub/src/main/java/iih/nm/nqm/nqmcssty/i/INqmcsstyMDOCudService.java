package iih.nm.nqm.nqmcssty.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nqmcssty.d.NqmCsStyDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 质量检查表样式数据维护服务
*/
public interface INqmcsstyMDOCudService {
	/**
	*  质量检查表样式数据真删除
	*/
    public abstract void delete(NqmCsStyDO[] aggdos) throws BizException;
    
    /**
	*  质量检查表样式数据插入保存
	*/
	public abstract NqmCsStyDO[] insert(NqmCsStyDO[] aggdos) throws BizException;
	
    /**
	*  质量检查表样式数据保存
	*/
	public abstract NqmCsStyDO[] save(NqmCsStyDO[] aggdos) throws BizException;
	
    /**
	*  质量检查表样式数据更新
	*/
	public abstract NqmCsStyDO[] update(NqmCsStyDO[] aggdos) throws BizException;
	
	/**
	*  质量检查表样式数据逻辑删除
	*/
	public abstract void logicDelete(NqmCsStyDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NqmCsStyDO[] enableWithoutFilter(NqmCsStyDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NqmCsStyDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NqmCsStyDO[] disableVOWithoutFilter(NqmCsStyDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NqmCsStyDO[] aggdos) throws BizException ;
	
}