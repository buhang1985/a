package iih.mp.dg.manuprep.i;

import xap.mw.core.data.BizException;
import iih.mp.dg.manuprep.d.MpDgPrepDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 门诊后台摆药数据维护服务
*/
public interface IManuprepMDOCudService {
	/**
	*  门诊后台摆药数据真删除
	*/
    public abstract void delete(MpDgPrepDO[] aggdos) throws BizException;
    
    /**
	*  门诊后台摆药数据插入保存
	*/
	public abstract MpDgPrepDO[] insert(MpDgPrepDO[] aggdos) throws BizException;
	
    /**
	*  门诊后台摆药数据保存
	*/
	public abstract MpDgPrepDO[] save(MpDgPrepDO[] aggdos) throws BizException;
	
    /**
	*  门诊后台摆药数据更新
	*/
	public abstract MpDgPrepDO[] update(MpDgPrepDO[] aggdos) throws BizException;
	
	/**
	*  门诊后台摆药数据逻辑删除
	*/
	public abstract void logicDelete(MpDgPrepDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MpDgPrepDO[] enableWithoutFilter(MpDgPrepDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MpDgPrepDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MpDgPrepDO[] disableVOWithoutFilter(MpDgPrepDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MpDgPrepDO[] aggdos) throws BizException ;
	
}
