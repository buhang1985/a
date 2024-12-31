package iih.bd.mhi.hpstafftp.i;

import xap.mw.core.data.BizException;
import iih.bd.mhi.hpstafftp.d.HpStaffTpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保计划医院人员类别数据维护服务
*/
public interface IHpstafftpCudService {
	/**
	*  医保计划医院人员类别数据真删除
	*/
    public abstract void delete(HpStaffTpDO[] aggdos) throws BizException;
    
    /**
	*  医保计划医院人员类别数据插入保存
	*/
	public abstract HpStaffTpDO[] insert(HpStaffTpDO[] aggdos) throws BizException;
	
    /**
	*  医保计划医院人员类别数据保存
	*/
	public abstract HpStaffTpDO[] save(HpStaffTpDO[] aggdos) throws BizException;
	
    /**
	*  医保计划医院人员类别数据更新
	*/
	public abstract HpStaffTpDO[] update(HpStaffTpDO[] aggdos) throws BizException;
	
	/**
	*  医保计划医院人员类别数据逻辑删除
	*/
	public abstract void logicDelete(HpStaffTpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpStaffTpDO[] enableWithoutFilter(HpStaffTpDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpStaffTpDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpStaffTpDO[] disableVOWithoutFilter(HpStaffTpDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpStaffTpDO[] dos) throws BizException ;
}
