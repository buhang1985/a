package iih.mp.dg.opdrugdisp.i;

import xap.mw.core.data.BizException;
import iih.mp.dg.opdrugdisp.d.OpPresStatusDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 门诊发药相关实体数据维护服务
*/
public interface IOpdrugdispCudService {
	/**
	*  门诊发药相关实体数据真删除
	*/
    public abstract void delete(OpPresStatusDO[] aggdos) throws BizException;
    
    /**
	*  门诊发药相关实体数据插入保存
	*/
	public abstract OpPresStatusDO[] insert(OpPresStatusDO[] aggdos) throws BizException;
	
    /**
	*  门诊发药相关实体数据保存
	*/
	public abstract OpPresStatusDO[] save(OpPresStatusDO[] aggdos) throws BizException;
	
    /**
	*  门诊发药相关实体数据更新
	*/
	public abstract OpPresStatusDO[] update(OpPresStatusDO[] aggdos) throws BizException;
	
	/**
	*  门诊发药相关实体数据逻辑删除
	*/
	public abstract void logicDelete(OpPresStatusDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public OpPresStatusDO[] enableWithoutFilter(OpPresStatusDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(OpPresStatusDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public OpPresStatusDO[] disableVOWithoutFilter(OpPresStatusDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(OpPresStatusDO[] dos) throws BizException ;
}
