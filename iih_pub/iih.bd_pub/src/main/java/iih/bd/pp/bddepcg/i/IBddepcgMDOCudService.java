package iih.bd.pp.bddepcg.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.bddepcg.d.BdDepCgDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 科室补费策略数据维护服务
*/
public interface IBddepcgMDOCudService {
	/**
	*  科室补费策略数据真删除
	*/
    public abstract void delete(BdDepCgDO[] aggdos) throws BizException;
    
    /**
	*  科室补费策略数据插入保存
	*/
	public abstract BdDepCgDO[] insert(BdDepCgDO[] aggdos) throws BizException;
	
    /**
	*  科室补费策略数据保存
	*/
	public abstract BdDepCgDO[] save(BdDepCgDO[] aggdos) throws BizException;
	
    /**
	*  科室补费策略数据更新
	*/
	public abstract BdDepCgDO[] update(BdDepCgDO[] aggdos) throws BizException;
	
	/**
	*  科室补费策略数据逻辑删除
	*/
	public abstract void logicDelete(BdDepCgDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BdDepCgDO[] enableWithoutFilter(BdDepCgDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BdDepCgDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BdDepCgDO[] disableVOWithoutFilter(BdDepCgDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BdDepCgDO[] aggdos) throws BizException ;
	
}