package iih.en.pv.inpatient.i;

import xap.mw.core.data.BizException;
import iih.en.pv.inpatient.d.EmgStayDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 出留观数据维护服务
*/
public interface IEmgstayCudService {
	/**
	*  出留观数据真删除
	*/
    public abstract void delete(EmgStayDO[] aggdos) throws BizException;
    
    /**
	*  出留观数据插入保存
	*/
	public abstract EmgStayDO[] insert(EmgStayDO[] aggdos) throws BizException;
	
    /**
	*  出留观数据保存
	*/
	public abstract EmgStayDO[] save(EmgStayDO[] aggdos) throws BizException;
	
    /**
	*  出留观数据更新
	*/
	public abstract EmgStayDO[] update(EmgStayDO[] aggdos) throws BizException;
	
	/**
	*  出留观数据逻辑删除
	*/
	public abstract void logicDelete(EmgStayDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EmgStayDO[] enableWithoutFilter(EmgStayDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EmgStayDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EmgStayDO[] disableVOWithoutFilter(EmgStayDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EmgStayDO[] dos) throws BizException ;
}
