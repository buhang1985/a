package iih.mp.mpbd.vscollprg.i;

import xap.mw.core.data.BizException;
import iih.mp.mpbd.vscollprg.d.VsCollPrgDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体征模板采集方案数据维护服务
*/
public interface IVscollprgCudService {
	/**
	*  体征模板采集方案数据真删除
	*/
    public abstract void delete(VsCollPrgDO[] aggdos) throws BizException;
    
    /**
	*  体征模板采集方案数据插入保存
	*/
	public abstract VsCollPrgDO[] insert(VsCollPrgDO[] aggdos) throws BizException;
	
    /**
	*  体征模板采集方案数据保存
	*/
	public abstract VsCollPrgDO[] save(VsCollPrgDO[] aggdos) throws BizException;
	
    /**
	*  体征模板采集方案数据更新
	*/
	public abstract VsCollPrgDO[] update(VsCollPrgDO[] aggdos) throws BizException;
	
	/**
	*  体征模板采集方案数据逻辑删除
	*/
	public abstract void logicDelete(VsCollPrgDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public VsCollPrgDO[] enableWithoutFilter(VsCollPrgDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(VsCollPrgDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public VsCollPrgDO[] disableVOWithoutFilter(VsCollPrgDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(VsCollPrgDO[] dos) throws BizException ;
}
