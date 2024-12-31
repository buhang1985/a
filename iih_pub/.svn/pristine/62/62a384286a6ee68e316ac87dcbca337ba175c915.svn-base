package iih.pis.phk.phkemp.i;

import xap.mw.core.data.BizException;
import iih.pis.phk.phkemp.d.PhkEmpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 患者管家人员信息数据维护服务
*/
public interface IPhkempCudService {
	/**
	*  患者管家人员信息数据真删除
	*/
    public abstract void delete(PhkEmpDO[] aggdos) throws BizException;
    
    /**
	*  患者管家人员信息数据插入保存
	*/
	public abstract PhkEmpDO[] insert(PhkEmpDO[] aggdos) throws BizException;
	
    /**
	*  患者管家人员信息数据保存
	*/
	public abstract PhkEmpDO[] save(PhkEmpDO[] aggdos) throws BizException;
	
    /**
	*  患者管家人员信息数据更新
	*/
	public abstract PhkEmpDO[] update(PhkEmpDO[] aggdos) throws BizException;
	
	/**
	*  患者管家人员信息数据逻辑删除
	*/
	public abstract void logicDelete(PhkEmpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PhkEmpDO[] enableWithoutFilter(PhkEmpDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PhkEmpDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PhkEmpDO[] disableVOWithoutFilter(PhkEmpDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PhkEmpDO[] dos) throws BizException ;
}
