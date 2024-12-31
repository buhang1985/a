package iih.bd.srv.ortpl.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.ortpl.d.RegularOrRelSrvDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 常规医嘱关联服务数据维护服务
*/
public interface IRegularorrelsrvCudService {
	/**
	*  常规医嘱关联服务数据真删除
	*/
    public abstract void delete(RegularOrRelSrvDO[] aggdos) throws BizException;
    
    /**
	*  常规医嘱关联服务数据插入保存
	*/
	public abstract RegularOrRelSrvDO[] insert(RegularOrRelSrvDO[] aggdos) throws BizException;
	
    /**
	*  常规医嘱关联服务数据保存
	*/
	public abstract RegularOrRelSrvDO[] save(RegularOrRelSrvDO[] aggdos) throws BizException;
	
    /**
	*  常规医嘱关联服务数据更新
	*/
	public abstract RegularOrRelSrvDO[] update(RegularOrRelSrvDO[] aggdos) throws BizException;
	
	/**
	*  常规医嘱关联服务数据逻辑删除
	*/
	public abstract void logicDelete(RegularOrRelSrvDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public RegularOrRelSrvDO[] enableWithoutFilter(RegularOrRelSrvDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(RegularOrRelSrvDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public RegularOrRelSrvDO[] disableVOWithoutFilter(RegularOrRelSrvDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(RegularOrRelSrvDO[] dos) throws BizException ;
}
