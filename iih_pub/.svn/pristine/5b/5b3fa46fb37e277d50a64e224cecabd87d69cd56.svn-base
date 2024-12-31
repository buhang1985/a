package iih.bl.inc.blincoeppaper.i;

import xap.mw.core.data.BizException;
import iih.bl.inc.blincoeppaper.d.BlIncOepPaperDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 门急诊纸质发票数据维护服务
*/
public interface IBlincoeppaperCudService {
	/**
	*  门急诊纸质发票数据真删除
	*/
    public abstract void delete(BlIncOepPaperDO[] aggdos) throws BizException;
    
    /**
	*  门急诊纸质发票数据插入保存
	*/
	public abstract BlIncOepPaperDO[] insert(BlIncOepPaperDO[] aggdos) throws BizException;
	
    /**
	*  门急诊纸质发票数据保存
	*/
	public abstract BlIncOepPaperDO[] save(BlIncOepPaperDO[] aggdos) throws BizException;
	
    /**
	*  门急诊纸质发票数据更新
	*/
	public abstract BlIncOepPaperDO[] update(BlIncOepPaperDO[] aggdos) throws BizException;
	
	/**
	*  门急诊纸质发票数据逻辑删除
	*/
	public abstract void logicDelete(BlIncOepPaperDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlIncOepPaperDO[] enableWithoutFilter(BlIncOepPaperDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlIncOepPaperDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlIncOepPaperDO[] disableVOWithoutFilter(BlIncOepPaperDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlIncOepPaperDO[] dos) throws BizException ;
}
