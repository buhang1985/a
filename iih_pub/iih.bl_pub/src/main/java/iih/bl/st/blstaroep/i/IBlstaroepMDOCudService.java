package iih.bl.st.blstaroep.i;

import xap.mw.core.data.BizException;
import iih.bl.st.blstaroep.d.BlStArOepDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 结算应收_门急体数据维护服务
*/
public interface IBlstaroepMDOCudService {
	/**
	*  结算应收_门急体数据删除
	*/
    public abstract void delete(BlStArOepDO[] aggdos) throws BizException;
    
    /**
	*  结算应收_门急体数据插入保存
	*/
	public abstract BlStArOepDO[] insert(BlStArOepDO[] aggdos) throws BizException;
	
    /**
	*  结算应收_门急体数据保存
	*/
	public abstract BlStArOepDO[] save(BlStArOepDO[] aggdos) throws BizException;
	
    /**
	*  结算应收_门急体数据更新
	*/
	public abstract BlStArOepDO[] update(BlStArOepDO[] aggdos) throws BizException;
	
	/**
	*  结算应收_门急体数据逻辑删除
	*/
	public abstract void logicDelete(BlStArOepDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlStArOepDO[] enableWithoutFilter(BlStArOepDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlStArOepDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlStArOepDO[] disableVOWithoutFilter(BlStArOepDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlStArOepDO[] aggdos) throws BizException ;
	
}
