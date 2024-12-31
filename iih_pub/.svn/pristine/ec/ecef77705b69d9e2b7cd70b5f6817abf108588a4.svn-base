package iih.ci.rcm.msinjury.i;

import xap.mw.core.data.BizException;
import iih.ci.rcm.msinjury.d.MsInjuryDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医疗锐器伤登记表数据维护服务
*/
public interface IMsinjuryCudService {
	/**
	*  医疗锐器伤登记表数据真删除
	*/
    public abstract void delete(MsInjuryDO[] aggdos) throws BizException;
    
    /**
	*  医疗锐器伤登记表数据插入保存
	*/
	public abstract MsInjuryDO[] insert(MsInjuryDO[] aggdos) throws BizException;
	
    /**
	*  医疗锐器伤登记表数据保存
	*/
	public abstract MsInjuryDO[] save(MsInjuryDO[] aggdos) throws BizException;
	
    /**
	*  医疗锐器伤登记表数据更新
	*/
	public abstract MsInjuryDO[] update(MsInjuryDO[] aggdos) throws BizException;
	
	/**
	*  医疗锐器伤登记表数据逻辑删除
	*/
	public abstract void logicDelete(MsInjuryDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MsInjuryDO[] enableWithoutFilter(MsInjuryDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MsInjuryDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MsInjuryDO[] disableVOWithoutFilter(MsInjuryDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MsInjuryDO[] dos) throws BizException ;
}
