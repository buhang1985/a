package iih.nmr.pkuf.nmrdocmbdg.i;

import xap.mw.core.data.BizException;
import iih.nmr.pkuf.nmrdocmbdg.d.NmrDocMbdeDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 文书_移动_数据组数据维护服务
*/
public interface INmrDocMbdeDOCudService {
	/**
	*  文书_移动_数据组数据真删除
	*/
    public abstract void delete(NmrDocMbdeDO[] aggdos) throws BizException;
    
    /**
	*  文书_移动_数据组数据插入保存
	*/
	public abstract NmrDocMbdeDO[] insert(NmrDocMbdeDO[] aggdos) throws BizException;
	
    /**
	*  文书_移动_数据组数据保存
	*/
	public abstract NmrDocMbdeDO[] save(NmrDocMbdeDO[] aggdos) throws BizException;
	
    /**
	*  文书_移动_数据组数据更新
	*/
	public abstract NmrDocMbdeDO[] update(NmrDocMbdeDO[] aggdos) throws BizException;
	
	/**
	*  文书_移动_数据组数据逻辑删除
	*/
	public abstract void logicDelete(NmrDocMbdeDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmrDocMbdeDO[] enableWithoutFilter(NmrDocMbdeDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmrDocMbdeDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmrDocMbdeDO[] disableVOWithoutFilter(NmrDocMbdeDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmrDocMbdeDO[] aggdos) throws BizException ;
	
}