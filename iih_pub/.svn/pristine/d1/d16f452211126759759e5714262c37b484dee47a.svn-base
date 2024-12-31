package iih.en.pv.enres.i;

import xap.mw.core.data.BizException;
import iih.en.pv.enres.d.EnBedDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 患者就诊_床位数据维护服务
*/
public interface IEnbedCudService {
	/**
	*  患者就诊_床位数据真删除
	*/
    public abstract void delete(EnBedDO[] aggdos) throws BizException;
    
    /**
	*  患者就诊_床位数据插入保存
	*/
	public abstract EnBedDO[] insert(EnBedDO[] aggdos) throws BizException;
	
    /**
	*  患者就诊_床位数据保存
	*/
	public abstract EnBedDO[] save(EnBedDO[] aggdos) throws BizException;
	
    /**
	*  患者就诊_床位数据更新
	*/
	public abstract EnBedDO[] update(EnBedDO[] aggdos) throws BizException;
	
	/**
	*  患者就诊_床位数据逻辑删除
	*/
	public abstract void logicDelete(EnBedDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EnBedDO[] enableWithoutFilter(EnBedDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EnBedDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EnBedDO[] disableVOWithoutFilter(EnBedDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EnBedDO[] dos) throws BizException ;
}
