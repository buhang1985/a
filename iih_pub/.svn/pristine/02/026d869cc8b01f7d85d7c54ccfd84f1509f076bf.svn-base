package iih.nm.nit.nitpracfb.i;

import xap.mw.core.data.BizException;
import iih.nm.nit.nitpracfb.d.NitPracfbItmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 实习反馈数据维护服务
*/
public interface INitPracfbItmDOCudService {
	/**
	*  实习反馈数据真删除
	*/
    public abstract void delete(NitPracfbItmDO[] aggdos) throws BizException;
    
    /**
	*  实习反馈数据插入保存
	*/
	public abstract NitPracfbItmDO[] insert(NitPracfbItmDO[] aggdos) throws BizException;
	
    /**
	*  实习反馈数据保存
	*/
	public abstract NitPracfbItmDO[] save(NitPracfbItmDO[] aggdos) throws BizException;
	
    /**
	*  实习反馈数据更新
	*/
	public abstract NitPracfbItmDO[] update(NitPracfbItmDO[] aggdos) throws BizException;
	
	/**
	*  实习反馈数据逻辑删除
	*/
	public abstract void logicDelete(NitPracfbItmDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NitPracfbItmDO[] enableWithoutFilter(NitPracfbItmDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NitPracfbItmDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NitPracfbItmDO[] disableVOWithoutFilter(NitPracfbItmDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NitPracfbItmDO[] aggdos) throws BizException ;
	
}
