package iih.bl.st.blpaypatoep.i;

import xap.mw.core.data.BizException;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 组件数据维护服务
*/
public interface IBlPayItmPatOepDOCudService {
	/**
	*  组件数据真删除
	*/
    public abstract void delete(BlPayItmPatOepDO[] aggdos) throws BizException;
    
    /**
	*  组件数据插入保存
	*/
	public abstract BlPayItmPatOepDO[] insert(BlPayItmPatOepDO[] aggdos) throws BizException;
	
    /**
	*  组件数据保存
	*/
	public abstract BlPayItmPatOepDO[] save(BlPayItmPatOepDO[] aggdos) throws BizException;
	
    /**
	*  组件数据更新
	*/
	public abstract BlPayItmPatOepDO[] update(BlPayItmPatOepDO[] aggdos) throws BizException;
	
	/**
	*  组件数据逻辑删除
	*/
	public abstract void logicDelete(BlPayItmPatOepDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlPayItmPatOepDO[] enableWithoutFilter(BlPayItmPatOepDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlPayItmPatOepDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlPayItmPatOepDO[] disableVOWithoutFilter(BlPayItmPatOepDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlPayItmPatOepDO[] aggdos) throws BizException ;
	
}
