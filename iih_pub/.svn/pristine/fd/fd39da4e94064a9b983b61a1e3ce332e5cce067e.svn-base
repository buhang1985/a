package iih.nm.nom.nmnomwbkapp.i;

import xap.mw.core.data.BizException;
import iih.nm.nom.nmnomwbkapp.d.NmNomWbkAppDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 护士长手册书写数据维护服务
*/
public interface INmnomwbkappCudService {
	/**
	*  护士长手册书写数据真删除
	*/
    public abstract void delete(NmNomWbkAppDO[] aggdos) throws BizException;
    
    /**
	*  护士长手册书写数据插入保存
	*/
	public abstract NmNomWbkAppDO[] insert(NmNomWbkAppDO[] aggdos) throws BizException;
	
    /**
	*  护士长手册书写数据保存
	*/
	public abstract NmNomWbkAppDO[] save(NmNomWbkAppDO[] aggdos) throws BizException;
	
    /**
	*  护士长手册书写数据更新
	*/
	public abstract NmNomWbkAppDO[] update(NmNomWbkAppDO[] aggdos) throws BizException;
	
	/**
	*  护士长手册书写数据逻辑删除
	*/
	public abstract void logicDelete(NmNomWbkAppDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNomWbkAppDO[] enableWithoutFilter(NmNomWbkAppDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNomWbkAppDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNomWbkAppDO[] disableVOWithoutFilter(NmNomWbkAppDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNomWbkAppDO[] dos) throws BizException ;
}
