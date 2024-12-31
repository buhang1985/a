package iih.pe.pbd.pefuncarea.i;

import xap.mw.core.data.BizException;
import iih.pe.pbd.pefuncarea.d.PeFuncAreaDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检功能区定义数据维护服务
*/
public interface IPefuncareaCudService {
	/**
	*  体检功能区定义数据真删除
	*/
    public abstract void delete(PeFuncAreaDO[] aggdos) throws BizException;
    
    /**
	*  体检功能区定义数据插入保存
	*/
	public abstract PeFuncAreaDO[] insert(PeFuncAreaDO[] aggdos) throws BizException;
	
    /**
	*  体检功能区定义数据保存
	*/
	public abstract PeFuncAreaDO[] save(PeFuncAreaDO[] aggdos) throws BizException;
	
    /**
	*  体检功能区定义数据更新
	*/
	public abstract PeFuncAreaDO[] update(PeFuncAreaDO[] aggdos) throws BizException;
	
	/**
	*  体检功能区定义数据逻辑删除
	*/
	public abstract void logicDelete(PeFuncAreaDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeFuncAreaDO[] enableWithoutFilter(PeFuncAreaDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeFuncAreaDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeFuncAreaDO[] disableVOWithoutFilter(PeFuncAreaDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeFuncAreaDO[] dos) throws BizException ;
}
