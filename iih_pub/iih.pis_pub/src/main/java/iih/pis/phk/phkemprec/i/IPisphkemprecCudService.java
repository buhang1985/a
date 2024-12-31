package iih.pis.phk.phkemprec.i;

import iih.pis.phk.phkemprec.d.PisPhkEmpRecDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 患者管家_管家数据维护服务
*/
public interface IPisphkemprecCudService {
	/**
	*  患者管家_管家数据真删除
	*/
    public abstract void delete(PisPhkEmpRecDO[] aggdos) throws BizException;
    
    /**
	*  患者管家_管家数据插入保存
	*/
	public abstract PisPhkEmpRecDO[] insert(PisPhkEmpRecDO[] aggdos) throws BizException;
	
    /**
	*  患者管家_管家数据保存
	*/
	public abstract PisPhkEmpRecDO[] save(PisPhkEmpRecDO[] aggdos) throws BizException;
	
    /**
	*  患者管家_管家数据更新
	*/
	public abstract PisPhkEmpRecDO[] update(PisPhkEmpRecDO[] aggdos) throws BizException;
	
	/**
	*  患者管家_管家数据逻辑删除
	*/
	public abstract void logicDelete(PisPhkEmpRecDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PisPhkEmpRecDO[] enableWithoutFilter(PisPhkEmpRecDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PisPhkEmpRecDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PisPhkEmpRecDO[] disableVOWithoutFilter(PisPhkEmpRecDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PisPhkEmpRecDO[] dos) throws BizException ;
}
