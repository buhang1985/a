package iih.mp.nr.infupr.i;

import xap.mw.core.data.BizException;
import iih.mp.nr.infupr.d.MpInfuPrDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 输液巡视数据维护服务
*/
public interface IInfuprCudService {
	/**
	*  输液巡视数据真删除
	*/
    public abstract void delete(MpInfuPrDO[] aggdos) throws BizException;
    
    /**
	*  输液巡视数据插入保存
	*/
	public abstract MpInfuPrDO[] insert(MpInfuPrDO[] aggdos) throws BizException;
	
    /**
	*  输液巡视数据保存
	*/
	public abstract MpInfuPrDO[] save(MpInfuPrDO[] aggdos) throws BizException;
	
    /**
	*  输液巡视数据更新
	*/
	public abstract MpInfuPrDO[] update(MpInfuPrDO[] aggdos) throws BizException;
	
	/**
	*  输液巡视数据逻辑删除
	*/
	public abstract void logicDelete(MpInfuPrDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MpInfuPrDO[] enableWithoutFilter(MpInfuPrDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MpInfuPrDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MpInfuPrDO[] disableVOWithoutFilter(MpInfuPrDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MpInfuPrDO[] dos) throws BizException ;
}
