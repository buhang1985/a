package iih.hp.cp.eletp.i;

import xap.mw.core.data.BizException;
import iih.hp.cp.eletp.d.HpCpElemTypeDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 诊疗计划元素类型数据维护服务
*/
public interface IHpcpeletpMDOCudService {
	/**
	*  诊疗计划元素类型数据真删除
	*/
    public abstract void delete(HpCpElemTypeDO[] aggdos) throws BizException;
    
    /**
	*  诊疗计划元素类型数据插入保存
	*/
	public abstract HpCpElemTypeDO[] insert(HpCpElemTypeDO[] aggdos) throws BizException;
	
    /**
	*  诊疗计划元素类型数据保存
	*/
	public abstract HpCpElemTypeDO[] save(HpCpElemTypeDO[] aggdos) throws BizException;
	
    /**
	*  诊疗计划元素类型数据更新
	*/
	public abstract HpCpElemTypeDO[] update(HpCpElemTypeDO[] aggdos) throws BizException;
	
	/**
	*  诊疗计划元素类型数据逻辑删除
	*/
	public abstract void logicDelete(HpCpElemTypeDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpCpElemTypeDO[] enableWithoutFilter(HpCpElemTypeDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpCpElemTypeDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpCpElemTypeDO[] disableVOWithoutFilter(HpCpElemTypeDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpCpElemTypeDO[] aggdos) throws BizException ;
	
}