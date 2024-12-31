package iih.nm.nhr.nmoptpl.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmoptpl.d.NmOptPlDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 实习计划数据维护服务
*/
public interface INmoptplMDOCudService {
	/**
	*  实习计划数据真删除
	*/
    public abstract void delete(NmOptPlDO[] aggdos) throws BizException;
    
    /**
	*  实习计划数据插入保存
	*/
	public abstract NmOptPlDO[] insert(NmOptPlDO[] aggdos) throws BizException;
	
    /**
	*  实习计划数据保存
	*/
	public abstract NmOptPlDO[] save(NmOptPlDO[] aggdos) throws BizException;
	
    /**
	*  实习计划数据更新
	*/
	public abstract NmOptPlDO[] update(NmOptPlDO[] aggdos) throws BizException;
	
	/**
	*  实习计划数据逻辑删除
	*/
	public abstract void logicDelete(NmOptPlDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmOptPlDO[] enableWithoutFilter(NmOptPlDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmOptPlDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmOptPlDO[] disableVOWithoutFilter(NmOptPlDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmOptPlDO[] aggdos) throws BizException ;
	
}
