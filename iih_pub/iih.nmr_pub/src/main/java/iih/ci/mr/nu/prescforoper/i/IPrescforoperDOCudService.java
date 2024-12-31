package iih.ci.mr.nu.prescforoper.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.prescforoper.d.PrescforoperDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 手术室患者压疮危险因素评分数据维护服务
*/
public interface IPrescforoperDOCudService {
	/**
	*  手术室患者压疮危险因素评分数据真删除
	*/
    public abstract void delete(PrescforoperDO[] aggdos) throws BizException;
    
    /**
	*  手术室患者压疮危险因素评分数据插入保存
	*/
	public abstract PrescforoperDO[] insert(PrescforoperDO[] aggdos) throws BizException;
	
    /**
	*  手术室患者压疮危险因素评分数据保存
	*/
	public abstract PrescforoperDO[] save(PrescforoperDO[] aggdos) throws BizException;
	
    /**
	*  手术室患者压疮危险因素评分数据更新
	*/
	public abstract PrescforoperDO[] update(PrescforoperDO[] aggdos) throws BizException;
	
	/**
	*  手术室患者压疮危险因素评分数据逻辑删除
	*/
	public abstract void logicDelete(PrescforoperDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PrescforoperDO[] enableWithoutFilter(PrescforoperDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PrescforoperDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PrescforoperDO[] disableVOWithoutFilter(PrescforoperDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PrescforoperDO[] aggdos) throws BizException ;
	
}
