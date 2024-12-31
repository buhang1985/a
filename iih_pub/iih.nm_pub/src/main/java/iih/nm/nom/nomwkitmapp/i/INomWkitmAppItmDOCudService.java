package iih.nm.nom.nomwkitmapp.i;

import xap.mw.core.data.BizException;
import iih.nm.nom.nomwkitmapp.d.NomWkitmAppItmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 护理工作项目数据录入数据维护服务
*/
public interface INomWkitmAppItmDOCudService {
	/**
	*  护理工作项目数据录入数据真删除
	*/
    public abstract void delete(NomWkitmAppItmDO[] aggdos) throws BizException;
    
    /**
	*  护理工作项目数据录入数据插入保存
	*/
	public abstract NomWkitmAppItmDO[] insert(NomWkitmAppItmDO[] aggdos) throws BizException;
	
    /**
	*  护理工作项目数据录入数据保存
	*/
	public abstract NomWkitmAppItmDO[] save(NomWkitmAppItmDO[] aggdos) throws BizException;
	
    /**
	*  护理工作项目数据录入数据更新
	*/
	public abstract NomWkitmAppItmDO[] update(NomWkitmAppItmDO[] aggdos) throws BizException;
	
	/**
	*  护理工作项目数据录入数据逻辑删除
	*/
	public abstract void logicDelete(NomWkitmAppItmDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NomWkitmAppItmDO[] enableWithoutFilter(NomWkitmAppItmDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NomWkitmAppItmDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NomWkitmAppItmDO[] disableVOWithoutFilter(NomWkitmAppItmDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NomWkitmAppItmDO[] aggdos) throws BizException ;
	
}
