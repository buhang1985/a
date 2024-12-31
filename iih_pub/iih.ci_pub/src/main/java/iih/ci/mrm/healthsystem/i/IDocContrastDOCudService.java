package iih.ci.mrm.healthsystem.i;

import xap.mw.core.data.BizException;
import iih.ci.mrm.healthsystem.d.DocContrastDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 数据抽取任务数据维护服务
*/
public interface IDocContrastDOCudService {
	/**
	*  数据抽取任务数据真删除
	*/
    public abstract void delete(DocContrastDO[] aggdos) throws BizException;
    
    /**
	*  数据抽取任务数据插入保存
	*/
	public abstract DocContrastDO[] insert(DocContrastDO[] aggdos) throws BizException;
	
    /**
	*  数据抽取任务数据保存
	*/
	public abstract DocContrastDO[] save(DocContrastDO[] aggdos) throws BizException;
	
    /**
	*  数据抽取任务数据更新
	*/
	public abstract DocContrastDO[] update(DocContrastDO[] aggdos) throws BizException;
	
	/**
	*  数据抽取任务数据逻辑删除
	*/
	public abstract void logicDelete(DocContrastDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DocContrastDO[] enableWithoutFilter(DocContrastDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DocContrastDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DocContrastDO[] disableVOWithoutFilter(DocContrastDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DocContrastDO[] aggdos) throws BizException ;
	
}
