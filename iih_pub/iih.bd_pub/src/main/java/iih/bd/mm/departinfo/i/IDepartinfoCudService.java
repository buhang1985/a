package iih.bd.mm.departinfo.i;

import xap.mw.core.data.BizException;
import iih.bd.mm.departinfo.d.DepartInfoDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医疗物品_与科室关系数据维护服务
*/
public interface IDepartinfoCudService {
	/**
	*  医疗物品_与科室关系数据删除
	*/
    public abstract void logicDelete(DepartInfoDO[] aggdos) throws BizException;
    
    /**
	*  医疗物品_与科室关系数据插入保存
	*/
	public abstract DepartInfoDO[] insert(DepartInfoDO[] aggdos) throws BizException;
	
    /**
	*  医疗物品_与科室关系数据保存
	*/
	public abstract DepartInfoDO[] save(DepartInfoDO[] aggdos) throws BizException;
	
    /**
	*  医疗物品_与科室关系数据更新
	*/
	public abstract DepartInfoDO[] update(DepartInfoDO[] aggdos) throws BizException;
	
	/**
	*  医疗物品_与科室关系数据真删
	*/
	public abstract void delete(DepartInfoDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DepartInfoDO[] enableWithoutFilter(DepartInfoDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DepartInfoDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DepartInfoDO[] disableVOWithoutFilter(DepartInfoDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DepartInfoDO[] dos) throws BizException ;
}
