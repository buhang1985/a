package iih.nm.nhr.nhroverwork.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nhroverwork.d.NhrOverWorkDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 加班申请数据维护服务
*/
public interface INhroverworkCudService {
	/**
	*  加班申请数据真删除
	*/
    public abstract void delete(NhrOverWorkDO[] aggdos) throws BizException;
    
    /**
	*  加班申请数据插入保存
	*/
	public abstract NhrOverWorkDO[] insert(NhrOverWorkDO[] aggdos) throws BizException;
	
    /**
	*  加班申请数据保存
	*/
	public abstract NhrOverWorkDO[] save(NhrOverWorkDO[] aggdos) throws BizException;
	
    /**
	*  加班申请数据更新
	*/
	public abstract NhrOverWorkDO[] update(NhrOverWorkDO[] aggdos) throws BizException;
	
	/**
	*  加班申请数据逻辑删除
	*/
	public abstract void logicDelete(NhrOverWorkDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NhrOverWorkDO[] enableWithoutFilter(NhrOverWorkDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NhrOverWorkDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NhrOverWorkDO[] disableVOWithoutFilter(NhrOverWorkDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NhrOverWorkDO[] dos) throws BizException ;
}
