package iih.nm.nqm.nqmchkitm.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nqmchkitm.d.NmNqmChkitmDo;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 护理管理_评分项目数据维护服务
*/
public interface INmNqmChkitmDoCudService {
	/**
	*  护理管理_评分项目数据真删除
	*/
    public abstract void delete(NmNqmChkitmDo[] aggdos) throws BizException;
    
    /**
	*  护理管理_评分项目数据插入保存
	*/
	public abstract NmNqmChkitmDo[] insert(NmNqmChkitmDo[] aggdos) throws BizException;
	
    /**
	*  护理管理_评分项目数据保存
	*/
	public abstract NmNqmChkitmDo[] save(NmNqmChkitmDo[] aggdos) throws BizException;
	
    /**
	*  护理管理_评分项目数据更新
	*/
	public abstract NmNqmChkitmDo[] update(NmNqmChkitmDo[] aggdos) throws BizException;
	
	/**
	*  护理管理_评分项目数据逻辑删除
	*/
	public abstract void logicDelete(NmNqmChkitmDo[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNqmChkitmDo[] enableWithoutFilter(NmNqmChkitmDo[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNqmChkitmDo[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNqmChkitmDo[] disableVOWithoutFilter(NmNqmChkitmDo[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNqmChkitmDo[] aggdos) throws BizException ;
	
}
