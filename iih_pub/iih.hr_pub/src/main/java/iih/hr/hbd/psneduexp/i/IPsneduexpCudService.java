package iih.hr.hbd.psneduexp.i;

import xap.mw.core.data.BizException;
import iih.hr.hbd.psneduexp.d.HbdPsnEduexpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 人员教育经历数据维护服务
*/
public interface IPsneduexpCudService {
	/**
	*  人员教育经历数据真删除
	*/
    public abstract void delete(HbdPsnEduexpDO[] aggdos) throws BizException;
    
    /**
	*  人员教育经历数据插入保存
	*/
	public abstract HbdPsnEduexpDO[] insert(HbdPsnEduexpDO[] aggdos) throws BizException;
	
    /**
	*  人员教育经历数据保存
	*/
	public abstract HbdPsnEduexpDO[] save(HbdPsnEduexpDO[] aggdos) throws BizException;
	
    /**
	*  人员教育经历数据更新
	*/
	public abstract HbdPsnEduexpDO[] update(HbdPsnEduexpDO[] aggdos) throws BizException;
	
	/**
	*  人员教育经历数据逻辑删除
	*/
	public abstract void logicDelete(HbdPsnEduexpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HbdPsnEduexpDO[] enableWithoutFilter(HbdPsnEduexpDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HbdPsnEduexpDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HbdPsnEduexpDO[] disableVOWithoutFilter(HbdPsnEduexpDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HbdPsnEduexpDO[] dos) throws BizException ;
}
