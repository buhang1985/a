package iih.pi.acc.account.i;

import xap.mw.core.data.BizException;
import iih.pi.acc.account.d.PiPatAccActDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 患者账户数据维护服务
*/
public interface IPiPatAccActDOCudService {
	/**
	*  患者账户数据真删除
	*/
    public abstract void delete(PiPatAccActDO[] aggdos) throws BizException;
    
    /**
	*  患者账户数据插入保存
	*/
	public abstract PiPatAccActDO[] insert(PiPatAccActDO[] aggdos) throws BizException;
	
    /**
	*  患者账户数据保存
	*/
	public abstract PiPatAccActDO[] save(PiPatAccActDO[] aggdos) throws BizException;
	
    /**
	*  患者账户数据更新
	*/
	public abstract PiPatAccActDO[] update(PiPatAccActDO[] aggdos) throws BizException;
	
	/**
	*  患者账户数据逻辑删除
	*/
	public abstract void logicDelete(PiPatAccActDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PiPatAccActDO[] enableWithoutFilter(PiPatAccActDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PiPatAccActDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PiPatAccActDO[] disableVOWithoutFilter(PiPatAccActDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PiPatAccActDO[] aggdos) throws BizException ;
	
}
