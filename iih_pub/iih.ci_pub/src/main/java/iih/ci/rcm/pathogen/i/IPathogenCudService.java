package iih.ci.rcm.pathogen.i;

import xap.mw.core.data.BizException;
import iih.ci.rcm.pathogen.d.PathogenDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 病原体数据维护服务
*/
public interface IPathogenCudService {
	/**
	*  病原体数据真删除
	*/
    public abstract void delete(PathogenDO[] aggdos) throws BizException;
    
    /**
	*  病原体数据插入保存
	*/
	public abstract PathogenDO[] insert(PathogenDO[] aggdos) throws BizException;
	
    /**
	*  病原体数据保存
	*/
	public abstract PathogenDO[] save(PathogenDO[] aggdos) throws BizException;
	
    /**
	*  病原体数据更新
	*/
	public abstract PathogenDO[] update(PathogenDO[] aggdos) throws BizException;
	
	/**
	*  病原体数据逻辑删除
	*/
	public abstract void logicDelete(PathogenDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PathogenDO[] enableWithoutFilter(PathogenDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PathogenDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PathogenDO[] disableVOWithoutFilter(PathogenDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PathogenDO[] dos) throws BizException ;
}
