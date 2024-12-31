package iih.mp.mpbd.mprs.i;

import xap.mw.core.data.BizException;
import iih.mp.mpbd.mprs.d.MpRsDepDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 护士站滚屏数据维护服务
*/
public interface IMpRsDepDOCudService {
	/**
	*  护士站滚屏数据真删除
	*/
    public abstract void delete(MpRsDepDO[] aggdos) throws BizException;
    
    /**
	*  护士站滚屏数据插入保存
	*/
	public abstract MpRsDepDO[] insert(MpRsDepDO[] aggdos) throws BizException;
	
    /**
	*  护士站滚屏数据保存
	*/
	public abstract MpRsDepDO[] save(MpRsDepDO[] aggdos) throws BizException;
	
    /**
	*  护士站滚屏数据更新
	*/
	public abstract MpRsDepDO[] update(MpRsDepDO[] aggdos) throws BizException;
	
	/**
	*  护士站滚屏数据逻辑删除
	*/
	public abstract void logicDelete(MpRsDepDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MpRsDepDO[] enableWithoutFilter(MpRsDepDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MpRsDepDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MpRsDepDO[] disableVOWithoutFilter(MpRsDepDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MpRsDepDO[] aggdos) throws BizException ;
	
}
