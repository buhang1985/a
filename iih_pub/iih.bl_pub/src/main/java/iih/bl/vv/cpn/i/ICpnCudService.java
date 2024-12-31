package iih.bl.vv.cpn.i;

import xap.mw.core.data.BizException;
import iih.bl.vv.cpn.d.BlCpnDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 优惠券数据维护服务
*/
public interface ICpnCudService {
	/**
	*  优惠券数据真删除
	*/
    public abstract void delete(BlCpnDO[] aggdos) throws BizException;
    
    /**
	*  优惠券数据插入保存
	*/
	public abstract BlCpnDO[] insert(BlCpnDO[] aggdos) throws BizException;
	
    /**
	*  优惠券数据保存
	*/
	public abstract BlCpnDO[] save(BlCpnDO[] aggdos) throws BizException;
	
    /**
	*  优惠券数据更新
	*/
	public abstract BlCpnDO[] update(BlCpnDO[] aggdos) throws BizException;
	
	/**
	*  优惠券数据逻辑删除
	*/
	public abstract void logicDelete(BlCpnDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlCpnDO[] enableWithoutFilter(BlCpnDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlCpnDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlCpnDO[] disableVOWithoutFilter(BlCpnDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlCpnDO[] dos) throws BizException ;
}
