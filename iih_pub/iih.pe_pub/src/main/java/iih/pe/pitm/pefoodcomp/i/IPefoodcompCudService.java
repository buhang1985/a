package iih.pe.pitm.pefoodcomp.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.pefoodcomp.d.PeFoodCompDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检食物成份表数据维护服务
*/
public interface IPefoodcompCudService {
	/**
	*  体检食物成份表数据真删除
	*/
    public abstract void delete(PeFoodCompDO[] aggdos) throws BizException;
    
    /**
	*  体检食物成份表数据插入保存
	*/
	public abstract PeFoodCompDO[] insert(PeFoodCompDO[] aggdos) throws BizException;
	
    /**
	*  体检食物成份表数据保存
	*/
	public abstract PeFoodCompDO[] save(PeFoodCompDO[] aggdos) throws BizException;
	
    /**
	*  体检食物成份表数据更新
	*/
	public abstract PeFoodCompDO[] update(PeFoodCompDO[] aggdos) throws BizException;
	
	/**
	*  体检食物成份表数据逻辑删除
	*/
	public abstract void logicDelete(PeFoodCompDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeFoodCompDO[] enableWithoutFilter(PeFoodCompDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeFoodCompDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeFoodCompDO[] disableVOWithoutFilter(PeFoodCompDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeFoodCompDO[] dos) throws BizException ;
}
