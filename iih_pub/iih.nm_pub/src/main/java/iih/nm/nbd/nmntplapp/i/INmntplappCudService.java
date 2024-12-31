package iih.nm.nbd.nmntplapp.i;

import xap.mw.core.data.BizException;
import iih.nm.nbd.nmntplapp.d.NmNtplAppDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 护理管理应用文档数据维护服务
*/
public interface INmntplappCudService {
	/**
	*  护理管理应用文档数据真删除
	*/
    public abstract void delete(NmNtplAppDO[] aggdos) throws BizException;
    
    /**
	*  护理管理应用文档数据插入保存
	*/
	public abstract NmNtplAppDO[] insert(NmNtplAppDO[] aggdos) throws BizException;
	
    /**
	*  护理管理应用文档数据保存
	*/
	public abstract NmNtplAppDO[] save(NmNtplAppDO[] aggdos) throws BizException;
	
    /**
	*  护理管理应用文档数据更新
	*/
	public abstract NmNtplAppDO[] update(NmNtplAppDO[] aggdos) throws BizException;
	
	/**
	*  护理管理应用文档数据逻辑删除
	*/
	public abstract void logicDelete(NmNtplAppDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNtplAppDO[] enableWithoutFilter(NmNtplAppDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNtplAppDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNtplAppDO[] disableVOWithoutFilter(NmNtplAppDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNtplAppDO[] dos) throws BizException ;
}
