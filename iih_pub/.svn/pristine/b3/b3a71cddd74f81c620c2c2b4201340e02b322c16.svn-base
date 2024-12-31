package iih.mp.mpbd.mprs.i;

import xap.mw.core.data.BizException;
import iih.mp.mpbd.mprs.d.MpRsDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 护士站滚屏数据维护服务
*/
public interface IMprsMDOCudService {
	/**
	*  护士站滚屏数据真删除
	*/
    public abstract void delete(MpRsDO[] aggdos) throws BizException;
    
    /**
	*  护士站滚屏数据插入保存
	*/
	public abstract MpRsDO[] insert(MpRsDO[] aggdos) throws BizException;
	
    /**
	*  护士站滚屏数据保存
	*/
	public abstract MpRsDO[] save(MpRsDO[] aggdos) throws BizException;
	
    /**
	*  护士站滚屏数据更新
	*/
	public abstract MpRsDO[] update(MpRsDO[] aggdos) throws BizException;
	
	/**
	*  护士站滚屏数据逻辑删除
	*/
	public abstract void logicDelete(MpRsDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MpRsDO[] enableWithoutFilter(MpRsDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MpRsDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MpRsDO[] disableVOWithoutFilter(MpRsDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MpRsDO[] aggdos) throws BizException ;
	
}
