package iih.bd.pp.bdpriboil.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.bdpriboil.d.BdPriBoilDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 煎法下费用项目对照数据维护服务
*/
public interface IBdpriboilCudService {
	/**
	*  煎法下费用项目对照数据真删除
	*/
    public abstract void delete(BdPriBoilDO[] aggdos) throws BizException;
    
    /**
	*  煎法下费用项目对照数据插入保存
	*/
	public abstract BdPriBoilDO[] insert(BdPriBoilDO[] aggdos) throws BizException;
	
    /**
	*  煎法下费用项目对照数据保存
	*/
	public abstract BdPriBoilDO[] save(BdPriBoilDO[] aggdos) throws BizException;
	
    /**
	*  煎法下费用项目对照数据更新
	*/
	public abstract BdPriBoilDO[] update(BdPriBoilDO[] aggdos) throws BizException;
	
	/**
	*  煎法下费用项目对照数据逻辑删除
	*/
	public abstract void logicDelete(BdPriBoilDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BdPriBoilDO[] enableWithoutFilter(BdPriBoilDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BdPriBoilDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BdPriBoilDO[] disableVOWithoutFilter(BdPriBoilDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BdPriBoilDO[] dos) throws BizException ;
}
