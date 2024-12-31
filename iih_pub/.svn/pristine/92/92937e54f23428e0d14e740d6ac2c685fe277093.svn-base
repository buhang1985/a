package iih.nmr.pkuf.nmrdocmobdg.i;

import xap.mw.core.data.BizException;
import iih.nmr.pkuf.nmrdocmobdg.d.NmrDocMobdgDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 移动数据集新版数据维护服务
*/
public interface INmrdocmobdgMDOCudService {
	/**
	*  移动数据集新版数据真删除
	*/
    public abstract void delete(NmrDocMobdgDO[] aggdos) throws BizException;
    
    /**
	*  移动数据集新版数据插入保存
	*/
	public abstract NmrDocMobdgDO[] insert(NmrDocMobdgDO[] aggdos) throws BizException;
	
    /**
	*  移动数据集新版数据保存
	*/
	public abstract NmrDocMobdgDO[] save(NmrDocMobdgDO[] aggdos) throws BizException;
	
    /**
	*  移动数据集新版数据更新
	*/
	public abstract NmrDocMobdgDO[] update(NmrDocMobdgDO[] aggdos) throws BizException;
	
	/**
	*  移动数据集新版数据逻辑删除
	*/
	public abstract void logicDelete(NmrDocMobdgDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmrDocMobdgDO[] enableWithoutFilter(NmrDocMobdgDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmrDocMobdgDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmrDocMobdgDO[] disableVOWithoutFilter(NmrDocMobdgDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmrDocMobdgDO[] aggdos) throws BizException ;
	
}
