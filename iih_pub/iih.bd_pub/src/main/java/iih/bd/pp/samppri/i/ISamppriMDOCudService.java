package iih.bd.pp.samppri.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.samppri.d.SampPriDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 标本费用对照数据维护服务
*/
public interface ISamppriMDOCudService {
	/**
	*  标本费用对照数据真删除
	*/
    public abstract void delete(SampPriDO[] aggdos) throws BizException;
    
    /**
	*  标本费用对照数据插入保存
	*/
	public abstract SampPriDO[] insert(SampPriDO[] aggdos) throws BizException;
	
    /**
	*  标本费用对照数据保存
	*/
	public abstract SampPriDO[] save(SampPriDO[] aggdos) throws BizException;
	
    /**
	*  标本费用对照数据更新
	*/
	public abstract SampPriDO[] update(SampPriDO[] aggdos) throws BizException;
	
	/**
	*  标本费用对照数据逻辑删除
	*/
	public abstract void logicDelete(SampPriDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SampPriDO[] enableWithoutFilter(SampPriDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SampPriDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SampPriDO[] disableVOWithoutFilter(SampPriDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SampPriDO[] aggdos) throws BizException ;
	
}
