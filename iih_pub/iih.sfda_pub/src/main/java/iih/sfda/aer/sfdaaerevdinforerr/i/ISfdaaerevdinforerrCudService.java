package iih.sfda.aer.sfdaaerevdinforerr.i;

import xap.mw.core.data.BizException;
import iih.sfda.aer.sfdaaerevdinforerr.d.SfdaAerEvDInforErrDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 信息流转错误数据维护服务
*/
public interface ISfdaaerevdinforerrCudService {
	/**
	*  信息流转错误数据真删除
	*/
    public abstract void delete(SfdaAerEvDInforErrDO[] aggdos) throws BizException;
    
    /**
	*  信息流转错误数据插入保存
	*/
	public abstract SfdaAerEvDInforErrDO[] insert(SfdaAerEvDInforErrDO[] aggdos) throws BizException;
	
    /**
	*  信息流转错误数据保存
	*/
	public abstract SfdaAerEvDInforErrDO[] save(SfdaAerEvDInforErrDO[] aggdos) throws BizException;
	
    /**
	*  信息流转错误数据更新
	*/
	public abstract SfdaAerEvDInforErrDO[] update(SfdaAerEvDInforErrDO[] aggdos) throws BizException;
	
	/**
	*  信息流转错误数据逻辑删除
	*/
	public abstract void logicDelete(SfdaAerEvDInforErrDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SfdaAerEvDInforErrDO[] enableWithoutFilter(SfdaAerEvDInforErrDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SfdaAerEvDInforErrDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SfdaAerEvDInforErrDO[] disableVOWithoutFilter(SfdaAerEvDInforErrDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SfdaAerEvDInforErrDO[] dos) throws BizException ;
}
