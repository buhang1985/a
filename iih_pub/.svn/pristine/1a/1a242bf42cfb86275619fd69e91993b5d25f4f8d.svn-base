package iih.mp.mpbd.kb.i;

import xap.mw.core.data.BizException;
import iih.mp.mpbd.kb.d.KbItemDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 移动键盘数据维护服务
*/
public interface IKbItemDOCudService {
	/**
	*  移动键盘数据真删除
	*/
    public abstract void delete(KbItemDO[] aggdos) throws BizException;
    
    /**
	*  移动键盘数据插入保存
	*/
	public abstract KbItemDO[] insert(KbItemDO[] aggdos) throws BizException;
	
    /**
	*  移动键盘数据保存
	*/
	public abstract KbItemDO[] save(KbItemDO[] aggdos) throws BizException;
	
    /**
	*  移动键盘数据更新
	*/
	public abstract KbItemDO[] update(KbItemDO[] aggdos) throws BizException;
	
	/**
	*  移动键盘数据逻辑删除
	*/
	public abstract void logicDelete(KbItemDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public KbItemDO[] enableWithoutFilter(KbItemDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(KbItemDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public KbItemDO[] disableVOWithoutFilter(KbItemDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(KbItemDO[] aggdos) throws BizException ;
	
}
