package iih.cssd.dpus.dfprecy.i;

import xap.mw.core.data.BizException;
import iih.cssd.dpus.dfprecy.d.DfpRecyItmDo;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 消毒包回收数据维护服务
*/
public interface IDfpRecyItmDoCudService {
	/**
	*  消毒包回收数据真删除
	*/
    public abstract void delete(DfpRecyItmDo[] aggdos) throws BizException;
    
    /**
	*  消毒包回收数据插入保存
	*/
	public abstract DfpRecyItmDo[] insert(DfpRecyItmDo[] aggdos) throws BizException;
	
    /**
	*  消毒包回收数据保存
	*/
	public abstract DfpRecyItmDo[] save(DfpRecyItmDo[] aggdos) throws BizException;
	
    /**
	*  消毒包回收数据更新
	*/
	public abstract DfpRecyItmDo[] update(DfpRecyItmDo[] aggdos) throws BizException;
	
	/**
	*  消毒包回收数据逻辑删除
	*/
	public abstract void logicDelete(DfpRecyItmDo[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DfpRecyItmDo[] enableWithoutFilter(DfpRecyItmDo[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DfpRecyItmDo[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DfpRecyItmDo[] disableVOWithoutFilter(DfpRecyItmDo[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DfpRecyItmDo[] aggdos) throws BizException ;
	
}
