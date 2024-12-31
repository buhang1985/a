package iih.mkr.std.dedg.i;

import xap.mw.core.data.BizException;
import iih.mkr.std.dedg.d.DgDeDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 数据组数据维护服务
*/
public interface IDgDeDOCudService {
	/**
	*  数据组数据真删除
	*/
    public abstract void delete(DgDeDO[] aggdos) throws BizException;
    
    /**
	*  数据组数据插入保存
	*/
	public abstract DgDeDO[] insert(DgDeDO[] aggdos) throws BizException;
	
    /**
	*  数据组数据保存
	*/
	public abstract DgDeDO[] save(DgDeDO[] aggdos) throws BizException;
	
    /**
	*  数据组数据更新
	*/
	public abstract DgDeDO[] update(DgDeDO[] aggdos) throws BizException;
	
	/**
	*  数据组数据逻辑删除
	*/
	public abstract void logicDelete(DgDeDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DgDeDO[] enableWithoutFilter(DgDeDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DgDeDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DgDeDO[] disableVOWithoutFilter(DgDeDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DgDeDO[] aggdos) throws BizException ;
	
}
