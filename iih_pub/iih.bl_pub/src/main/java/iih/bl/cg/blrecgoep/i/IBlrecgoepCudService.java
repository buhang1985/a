package iih.bl.cg.blrecgoep.i;

import xap.mw.core.data.BizException;
import iih.bl.cg.blrecgoep.d.BlRecgOepDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 门急诊重划价数据维护服务
*/
public interface IBlrecgoepCudService {
	/**
	*  门急诊重划价数据真删除
	*/
    public abstract void delete(BlRecgOepDO[] aggdos) throws BizException;
    
    /**
	*  门急诊重划价数据插入保存
	*/
	public abstract BlRecgOepDO[] insert(BlRecgOepDO[] aggdos) throws BizException;
	
    /**
	*  门急诊重划价数据保存
	*/
	public abstract BlRecgOepDO[] save(BlRecgOepDO[] aggdos) throws BizException;
	
    /**
	*  门急诊重划价数据更新
	*/
	public abstract BlRecgOepDO[] update(BlRecgOepDO[] aggdos) throws BizException;
	
	/**
	*  门急诊重划价数据逻辑删除
	*/
	public abstract void logicDelete(BlRecgOepDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlRecgOepDO[] enableWithoutFilter(BlRecgOepDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlRecgOepDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlRecgOepDO[] disableVOWithoutFilter(BlRecgOepDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlRecgOepDO[] dos) throws BizException ;
}
