package iih.ci.mr.nu.childhealthedu.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.childhealthedu.d.ChildHealthEduDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 儿科住院健康教育评价单数据维护服务
*/
public interface IChildhealtheduMDOCudService {
	/**
	*  儿科住院健康教育评价单数据真删除
	*/
    public abstract void delete(ChildHealthEduDO[] aggdos) throws BizException;
    
    /**
	*  儿科住院健康教育评价单数据插入保存
	*/
	public abstract ChildHealthEduDO[] insert(ChildHealthEduDO[] aggdos) throws BizException;
	
    /**
	*  儿科住院健康教育评价单数据保存
	*/
	public abstract ChildHealthEduDO[] save(ChildHealthEduDO[] aggdos) throws BizException;
	
    /**
	*  儿科住院健康教育评价单数据更新
	*/
	public abstract ChildHealthEduDO[] update(ChildHealthEduDO[] aggdos) throws BizException;
	
	/**
	*  儿科住院健康教育评价单数据逻辑删除
	*/
	public abstract void logicDelete(ChildHealthEduDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ChildHealthEduDO[] enableWithoutFilter(ChildHealthEduDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ChildHealthEduDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ChildHealthEduDO[] disableVOWithoutFilter(ChildHealthEduDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ChildHealthEduDO[] aggdos) throws BizException ;
	
}
