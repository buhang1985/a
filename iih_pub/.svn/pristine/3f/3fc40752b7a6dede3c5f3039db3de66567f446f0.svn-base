package iih.bd.srv.srvdc.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.srvdc.d.FixedChargePkgDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医疗服务固定收费包数据维护服务
*/
public interface ISrvdcMDOCudService {
	/**
	*  医疗服务固定收费包数据真删除
	*/
    public abstract void delete(FixedChargePkgDO[] aggdos) throws BizException;
    
    /**
	*  医疗服务固定收费包数据插入保存
	*/
	public abstract FixedChargePkgDO[] insert(FixedChargePkgDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务固定收费包数据保存
	*/
	public abstract FixedChargePkgDO[] save(FixedChargePkgDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务固定收费包数据更新
	*/
	public abstract FixedChargePkgDO[] update(FixedChargePkgDO[] aggdos) throws BizException;
	
	/**
	*  医疗服务固定收费包数据逻辑删除
	*/
	public abstract void logicDelete(FixedChargePkgDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public FixedChargePkgDO[] enableWithoutFilter(FixedChargePkgDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(FixedChargePkgDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public FixedChargePkgDO[] disableVOWithoutFilter(FixedChargePkgDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(FixedChargePkgDO[] aggdos) throws BizException ;
	
}
