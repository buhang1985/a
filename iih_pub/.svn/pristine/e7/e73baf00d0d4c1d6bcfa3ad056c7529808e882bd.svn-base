package iih.en.pv.enfee.i;

import xap.mw.core.data.BizException;
import iih.en.pv.enfee.d.EnFixedFeeItemDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 患者就诊_固定费用数据维护服务
*/
public interface IEnFixedFeeItemDOCudService {
	/**
	*  患者就诊_固定费用数据真删除
	*/
    public abstract void delete(EnFixedFeeItemDO[] aggdos) throws BizException;
    
    /**
	*  患者就诊_固定费用数据插入保存
	*/
	public abstract EnFixedFeeItemDO[] insert(EnFixedFeeItemDO[] aggdos) throws BizException;
	
    /**
	*  患者就诊_固定费用数据保存
	*/
	public abstract EnFixedFeeItemDO[] save(EnFixedFeeItemDO[] aggdos) throws BizException;
	
    /**
	*  患者就诊_固定费用数据更新
	*/
	public abstract EnFixedFeeItemDO[] update(EnFixedFeeItemDO[] aggdos) throws BizException;
	
	/**
	*  患者就诊_固定费用数据逻辑删除
	*/
	public abstract void logicDelete(EnFixedFeeItemDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EnFixedFeeItemDO[] enableWithoutFilter(EnFixedFeeItemDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EnFixedFeeItemDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EnFixedFeeItemDO[] disableVOWithoutFilter(EnFixedFeeItemDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EnFixedFeeItemDO[] aggdos) throws BizException ;
	
	
	/**
	 * 通过id主键进行逻辑删除 无需进行版本控制
	 */
	public abstract void logicDeleteById(String id) throws BizException ;
}
