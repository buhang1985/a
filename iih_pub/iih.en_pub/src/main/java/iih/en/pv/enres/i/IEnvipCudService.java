package iih.en.pv.enres.i;

import xap.mw.core.data.BizException;
import iih.en.pv.enres.d.EnExtVipDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 患者就诊_扩展_VIP数据维护服务
*/
public interface IEnvipCudService {
	/**
	*  患者就诊_扩展_VIP数据真删除
	*/
    public abstract void delete(EnExtVipDO[] aggdos) throws BizException;
    
    /**
	*  患者就诊_扩展_VIP数据插入保存
	*/
	public abstract EnExtVipDO[] insert(EnExtVipDO[] aggdos) throws BizException;
	
    /**
	*  患者就诊_扩展_VIP数据保存
	*/
	public abstract EnExtVipDO[] save(EnExtVipDO[] aggdos) throws BizException;
	
    /**
	*  患者就诊_扩展_VIP数据更新
	*/
	public abstract EnExtVipDO[] update(EnExtVipDO[] aggdos) throws BizException;
	
	/**
	*  患者就诊_扩展_VIP数据逻辑删除
	*/
	public abstract void logicDelete(EnExtVipDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EnExtVipDO[] enableWithoutFilter(EnExtVipDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EnExtVipDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EnExtVipDO[] disableVOWithoutFilter(EnExtVipDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EnExtVipDO[] dos) throws BizException ;
}
