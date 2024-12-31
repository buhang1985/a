package iih.sfda.aer.sfdaaerimprd.i;

import xap.mw.core.data.BizException;
import iih.sfda.aer.sfdaaerimprd.d.SfdaAerImprdDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 上报事件_受损害对象数据维护服务
*/
public interface ISfdaaerimprdCudService {
	/**
	*  上报事件_受损害对象数据真删除
	*/
    public abstract void delete(SfdaAerImprdDO[] aggdos) throws BizException;
    
    /**
	*  上报事件_受损害对象数据插入保存
	*/
	public abstract SfdaAerImprdDO[] insert(SfdaAerImprdDO[] aggdos) throws BizException;
	
    /**
	*  上报事件_受损害对象数据保存
	*/
	public abstract SfdaAerImprdDO[] save(SfdaAerImprdDO[] aggdos) throws BizException;
	
    /**
	*  上报事件_受损害对象数据更新
	*/
	public abstract SfdaAerImprdDO[] update(SfdaAerImprdDO[] aggdos) throws BizException;
	
	/**
	*  上报事件_受损害对象数据逻辑删除
	*/
	public abstract void logicDelete(SfdaAerImprdDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SfdaAerImprdDO[] enableWithoutFilter(SfdaAerImprdDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SfdaAerImprdDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SfdaAerImprdDO[] disableVOWithoutFilter(SfdaAerImprdDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SfdaAerImprdDO[] dos) throws BizException ;
}
