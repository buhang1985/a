package iih.ci.mr.nu.perioperativenurrec.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.perioperativenurrec.d.PpNurDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 围手术期护理记录单数据维护服务
*/
public interface IPerioperativenurrecMDOCudService {
	/**
	*  围手术期护理记录单数据真删除
	*/
    public abstract void delete(PpNurDO[] aggdos) throws BizException;
    
    /**
	*  围手术期护理记录单数据插入保存
	*/
	public abstract PpNurDO[] insert(PpNurDO[] aggdos) throws BizException;
	
    /**
	*  围手术期护理记录单数据保存
	*/
	public abstract PpNurDO[] save(PpNurDO[] aggdos) throws BizException;
	
    /**
	*  围手术期护理记录单数据更新
	*/
	public abstract PpNurDO[] update(PpNurDO[] aggdos) throws BizException;
	
	/**
	*  围手术期护理记录单数据逻辑删除
	*/
	public abstract void logicDelete(PpNurDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PpNurDO[] enableWithoutFilter(PpNurDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PpNurDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PpNurDO[] disableVOWithoutFilter(PpNurDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PpNurDO[] aggdos) throws BizException ;
	
}
