package iih.bd.srv.mrtplvst.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.mrtplvst.d.BdMrtplVstItmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 生命体征模版数据维护服务
*/
public interface IBdMrtplVstItmDOCudService {
	/**
	*  生命体征模版数据真删除
	*/
    public abstract void delete(BdMrtplVstItmDO[] aggdos) throws BizException;
    
    /**
	*  生命体征模版数据插入保存
	*/
	public abstract BdMrtplVstItmDO[] insert(BdMrtplVstItmDO[] aggdos) throws BizException;
	
    /**
	*  生命体征模版数据保存
	*/
	public abstract BdMrtplVstItmDO[] save(BdMrtplVstItmDO[] aggdos) throws BizException;
	
    /**
	*  生命体征模版数据更新
	*/
	public abstract BdMrtplVstItmDO[] update(BdMrtplVstItmDO[] aggdos) throws BizException;
	
	/**
	*  生命体征模版数据逻辑删除
	*/
	public abstract void logicDelete(BdMrtplVstItmDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BdMrtplVstItmDO[] enableWithoutFilter(BdMrtplVstItmDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BdMrtplVstItmDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BdMrtplVstItmDO[] disableVOWithoutFilter(BdMrtplVstItmDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BdMrtplVstItmDO[] aggdos) throws BizException ;
	
}
