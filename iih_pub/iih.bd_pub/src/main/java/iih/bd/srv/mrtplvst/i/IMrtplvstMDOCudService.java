package iih.bd.srv.mrtplvst.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.mrtplvst.d.BdMrtplVstDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 生命体征模版数据维护服务
*/
public interface IMrtplvstMDOCudService {
	/**
	*  生命体征模版数据真删除
	*/
    public abstract void delete(BdMrtplVstDO[] aggdos) throws BizException;
    
    /**
	*  生命体征模版数据插入保存
	*/
	public abstract BdMrtplVstDO[] insert(BdMrtplVstDO[] aggdos) throws BizException;
	
    /**
	*  生命体征模版数据保存
	*/
	public abstract BdMrtplVstDO[] save(BdMrtplVstDO[] aggdos) throws BizException;
	
    /**
	*  生命体征模版数据更新
	*/
	public abstract BdMrtplVstDO[] update(BdMrtplVstDO[] aggdos) throws BizException;
	
	/**
	*  生命体征模版数据逻辑删除
	*/
	public abstract void logicDelete(BdMrtplVstDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BdMrtplVstDO[] enableWithoutFilter(BdMrtplVstDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BdMrtplVstDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BdMrtplVstDO[] disableVOWithoutFilter(BdMrtplVstDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BdMrtplVstDO[] aggdos) throws BizException ;
	
}
