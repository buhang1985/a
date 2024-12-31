package iih.pis.ivx.pisivxstaff.i;

import xap.mw.core.data.BizException;
import iih.pis.ivx.pisivxstaff.d.PisIvxStaffDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 微信服务号职工绑定数据维护服务
*/
public interface IPisivxstaffCudService {
	/**
	*  微信服务号职工绑定数据真删除
	*/
    public abstract void delete(PisIvxStaffDO[] aggdos) throws BizException;
    
    /**
	*  微信服务号职工绑定数据插入保存
	*/
	public abstract PisIvxStaffDO[] insert(PisIvxStaffDO[] aggdos) throws BizException;
	
    /**
	*  微信服务号职工绑定数据保存
	*/
	public abstract PisIvxStaffDO[] save(PisIvxStaffDO[] aggdos) throws BizException;
	
    /**
	*  微信服务号职工绑定数据更新
	*/
	public abstract PisIvxStaffDO[] update(PisIvxStaffDO[] aggdos) throws BizException;
	
	/**
	*  微信服务号职工绑定数据逻辑删除
	*/
	public abstract void logicDelete(PisIvxStaffDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PisIvxStaffDO[] enableWithoutFilter(PisIvxStaffDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PisIvxStaffDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PisIvxStaffDO[] disableVOWithoutFilter(PisIvxStaffDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PisIvxStaffDO[] dos) throws BizException ;
}
