package iih.en.pv.enres.i;

import xap.mw.core.data.BizException;
import iih.en.pv.enres.d.EnExtDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 患者就诊_扩展数据维护服务
*/
public interface IEnextCudService {
	/**
	*  患者就诊_扩展数据真删除
	*/
    public abstract void delete(EnExtDO[] aggdos) throws BizException;
    
    /**
	*  患者就诊_扩展数据插入保存
	*/
	public abstract EnExtDO[] insert(EnExtDO[] aggdos) throws BizException;
	
    /**
	*  患者就诊_扩展数据保存
	*/
	public abstract EnExtDO[] save(EnExtDO[] aggdos) throws BizException;
	
    /**
	*  患者就诊_扩展数据更新
	*/
	public abstract EnExtDO[] update(EnExtDO[] aggdos) throws BizException;
	
	/**
	*  患者就诊_扩展数据逻辑删除
	*/
	public abstract void logicDelete(EnExtDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EnExtDO[] enableWithoutFilter(EnExtDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EnExtDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EnExtDO[] disableVOWithoutFilter(EnExtDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EnExtDO[] dos) throws BizException ;
}
