package iih.hr.hbd.psncontact.i;

import xap.mw.core.data.BizException;
import iih.hr.hbd.psncontact.d.HbdPsnContactDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 人员联系人数据维护服务
*/
public interface IPsncontactCudService {
	/**
	*  人员联系人数据真删除
	*/
    public abstract void delete(HbdPsnContactDO[] aggdos) throws BizException;
    
    /**
	*  人员联系人数据插入保存
	*/
	public abstract HbdPsnContactDO[] insert(HbdPsnContactDO[] aggdos) throws BizException;
	
    /**
	*  人员联系人数据保存
	*/
	public abstract HbdPsnContactDO[] save(HbdPsnContactDO[] aggdos) throws BizException;
	
    /**
	*  人员联系人数据更新
	*/
	public abstract HbdPsnContactDO[] update(HbdPsnContactDO[] aggdos) throws BizException;
	
	/**
	*  人员联系人数据逻辑删除
	*/
	public abstract void logicDelete(HbdPsnContactDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HbdPsnContactDO[] enableWithoutFilter(HbdPsnContactDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HbdPsnContactDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HbdPsnContactDO[] disableVOWithoutFilter(HbdPsnContactDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HbdPsnContactDO[] dos) throws BizException ;
}
