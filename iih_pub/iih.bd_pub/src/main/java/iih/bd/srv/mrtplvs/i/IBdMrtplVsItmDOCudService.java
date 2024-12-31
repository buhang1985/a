package iih.bd.srv.mrtplvs.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.mrtplvs.d.BdMrtplVsItmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 生命体征项数据维护服务
*/
public interface IBdMrtplVsItmDOCudService {
	/**
	*  生命体征项数据真删除
	*/
    public abstract void delete(BdMrtplVsItmDO[] aggdos) throws BizException;
    
    /**
	*  生命体征项数据插入保存
	*/
	public abstract BdMrtplVsItmDO[] insert(BdMrtplVsItmDO[] aggdos) throws BizException;
	
    /**
	*  生命体征项数据保存
	*/
	public abstract BdMrtplVsItmDO[] save(BdMrtplVsItmDO[] aggdos) throws BizException;
	
    /**
	*  生命体征项数据更新
	*/
	public abstract BdMrtplVsItmDO[] update(BdMrtplVsItmDO[] aggdos) throws BizException;
	
	/**
	*  生命体征项数据逻辑删除
	*/
	public abstract void logicDelete(BdMrtplVsItmDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BdMrtplVsItmDO[] enableWithoutFilter(BdMrtplVsItmDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BdMrtplVsItmDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BdMrtplVsItmDO[] disableVOWithoutFilter(BdMrtplVsItmDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BdMrtplVsItmDO[] aggdos) throws BizException ;
	
}
