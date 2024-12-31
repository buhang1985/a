package iih.mi.mc.mimcspec.i;

import xap.mw.core.data.BizException;
import iih.mi.mc.mimcspec.d.MiMcSpecDrugDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医保特殊病数据维护服务
*/
public interface IMiMcSpecDrugDOCudService {
	/**
	*  医保特殊病数据真删除
	*/
    public abstract void delete(MiMcSpecDrugDO[] aggdos) throws BizException;
    
    /**
	*  医保特殊病数据插入保存
	*/
	public abstract MiMcSpecDrugDO[] insert(MiMcSpecDrugDO[] aggdos) throws BizException;
	
    /**
	*  医保特殊病数据保存
	*/
	public abstract MiMcSpecDrugDO[] save(MiMcSpecDrugDO[] aggdos) throws BizException;
	
    /**
	*  医保特殊病数据更新
	*/
	public abstract MiMcSpecDrugDO[] update(MiMcSpecDrugDO[] aggdos) throws BizException;
	
	/**
	*  医保特殊病数据逻辑删除
	*/
	public abstract void logicDelete(MiMcSpecDrugDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MiMcSpecDrugDO[] enableWithoutFilter(MiMcSpecDrugDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MiMcSpecDrugDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MiMcSpecDrugDO[] disableVOWithoutFilter(MiMcSpecDrugDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MiMcSpecDrugDO[] aggdos) throws BizException ;
	
}
