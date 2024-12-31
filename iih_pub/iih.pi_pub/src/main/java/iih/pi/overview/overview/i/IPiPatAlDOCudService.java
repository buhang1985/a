package iih.pi.overview.overview.i;

import xap.mw.core.data.BizException;
import iih.pi.overview.overview.d.PiPatAlDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 患者临床摘要数据维护服务
*/
public interface IPiPatAlDOCudService {
	/**
	*  患者临床摘要数据真删除
	*/
    public abstract void delete(PiPatAlDO[] aggdos) throws BizException;
    
    /**
	*  患者临床摘要数据插入保存
	*/
	public abstract PiPatAlDO[] insert(PiPatAlDO[] aggdos) throws BizException;
	
    /**
	*  患者临床摘要数据保存
	*/
	public abstract PiPatAlDO[] save(PiPatAlDO[] aggdos) throws BizException;
	
    /**
	*  患者临床摘要数据更新
	*/
	public abstract PiPatAlDO[] update(PiPatAlDO[] aggdos) throws BizException;
	
	/**
	*  患者临床摘要数据逻辑删除
	*/
	public abstract void logicDelete(PiPatAlDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PiPatAlDO[] enableWithoutFilter(PiPatAlDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PiPatAlDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PiPatAlDO[] disableVOWithoutFilter(PiPatAlDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PiPatAlDO[] aggdos) throws BizException ;
	
}
