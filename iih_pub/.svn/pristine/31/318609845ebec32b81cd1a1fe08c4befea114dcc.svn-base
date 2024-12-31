package iih.bd.srv.nurcustomcaown.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.nurcustomcaown.d.NuOwnDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医疗记录_护理文书所属数据维护服务
*/
public interface INurcustomcaownCudService {
	/**
	*  医疗记录_护理文书所属数据真删除
	*/
    public abstract void delete(NuOwnDO[] aggdos) throws BizException;
    
    /**
	*  医疗记录_护理文书所属数据插入保存
	*/
	public abstract NuOwnDO[] insert(NuOwnDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录_护理文书所属数据保存
	*/
	public abstract NuOwnDO[] save(NuOwnDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录_护理文书所属数据更新
	*/
	public abstract NuOwnDO[] update(NuOwnDO[] aggdos) throws BizException;
	
	/**
	*  医疗记录_护理文书所属数据逻辑删除
	*/
	public abstract void logicDelete(NuOwnDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NuOwnDO[] enableWithoutFilter(NuOwnDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NuOwnDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NuOwnDO[] disableVOWithoutFilter(NuOwnDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NuOwnDO[] dos) throws BizException ;
}
