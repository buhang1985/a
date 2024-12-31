package iih.en.pv.enfee.i;

import xap.mw.core.data.BizException;
import iih.en.pv.enfee.d.EnFixedFeeDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 患者就诊_固定费用数据维护服务
*/
public interface IEnfixedfeeMDOCudService {
	/**
	*  患者就诊_固定费用数据真删除
	*/
    public abstract void delete(EnFixedFeeDO[] aggdos) throws BizException;
    
    /**
	*  患者就诊_固定费用数据插入保存
	*/
	public abstract EnFixedFeeDO[] insert(EnFixedFeeDO[] aggdos) throws BizException;
	
    /**
	*  患者就诊_固定费用数据保存
	*/
	public abstract EnFixedFeeDO[] save(EnFixedFeeDO[] aggdos) throws BizException;
	
    /**
	*  患者就诊_固定费用数据更新
	*/
	public abstract EnFixedFeeDO[] update(EnFixedFeeDO[] aggdos) throws BizException;
	
	/**
	*  患者就诊_固定费用数据逻辑删除
	*/
	public abstract void logicDelete(EnFixedFeeDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EnFixedFeeDO[] enableWithoutFilter(EnFixedFeeDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EnFixedFeeDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EnFixedFeeDO[] disableVOWithoutFilter(EnFixedFeeDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EnFixedFeeDO[] aggdos) throws BizException ;
	
}
