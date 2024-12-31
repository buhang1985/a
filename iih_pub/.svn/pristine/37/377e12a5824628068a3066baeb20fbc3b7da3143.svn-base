package iih.nm.nom.nmnomwbk.i;

import xap.mw.core.data.BizException;
import iih.nm.nom.nmnomwbk.d.NmNomWbkDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 护士长手册数据维护服务
*/
public interface INmnomwbkCudService {
	/**
	*  护士长手册数据真删除
	*/
    public abstract void delete(NmNomWbkDO[] aggdos) throws BizException;
    
    /**
	*  护士长手册数据插入保存
	*/
	public abstract NmNomWbkDO[] insert(NmNomWbkDO[] aggdos) throws BizException;
	
    /**
	*  护士长手册数据保存
	*/
	public abstract NmNomWbkDO[] save(NmNomWbkDO[] aggdos) throws BizException;
	
    /**
	*  护士长手册数据更新
	*/
	public abstract NmNomWbkDO[] update(NmNomWbkDO[] aggdos) throws BizException;
	
	/**
	*  护士长手册数据逻辑删除
	*/
	public abstract void logicDelete(NmNomWbkDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNomWbkDO[] enableWithoutFilter(NmNomWbkDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNomWbkDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNomWbkDO[] disableVOWithoutFilter(NmNomWbkDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNomWbkDO[] dos) throws BizException ;
}
