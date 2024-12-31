package iih.hr.hbd.psnwkexp.i;

import xap.mw.core.data.BizException;
import iih.hr.hbd.psnwkexp.d.HbdPsnWkexpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 人员工作经历数据维护服务
*/
public interface IPsnwkexpCudService {
	/**
	*  人员工作经历数据真删除
	*/
    public abstract void delete(HbdPsnWkexpDO[] aggdos) throws BizException;
    
    /**
	*  人员工作经历数据插入保存
	*/
	public abstract HbdPsnWkexpDO[] insert(HbdPsnWkexpDO[] aggdos) throws BizException;
	
    /**
	*  人员工作经历数据保存
	*/
	public abstract HbdPsnWkexpDO[] save(HbdPsnWkexpDO[] aggdos) throws BizException;
	
    /**
	*  人员工作经历数据更新
	*/
	public abstract HbdPsnWkexpDO[] update(HbdPsnWkexpDO[] aggdos) throws BizException;
	
	/**
	*  人员工作经历数据逻辑删除
	*/
	public abstract void logicDelete(HbdPsnWkexpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HbdPsnWkexpDO[] enableWithoutFilter(HbdPsnWkexpDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HbdPsnWkexpDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HbdPsnWkexpDO[] disableVOWithoutFilter(HbdPsnWkexpDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HbdPsnWkexpDO[] dos) throws BizException ;
}
