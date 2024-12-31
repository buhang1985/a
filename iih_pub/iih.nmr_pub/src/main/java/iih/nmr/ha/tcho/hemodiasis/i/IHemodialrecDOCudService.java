package iih.nmr.ha.tcho.hemodiasis.i;

import xap.mw.core.data.BizException;
import iih.nmr.ha.tcho.hemodiasis.d.HemodialrecDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 血液透析护理记录数据维护服务
*/
public interface IHemodialrecDOCudService {
	/**
	*  血液透析护理记录数据真删除
	*/
    public abstract void delete(HemodialrecDO[] aggdos) throws BizException;
    
    /**
	*  血液透析护理记录数据插入保存
	*/
	public abstract HemodialrecDO[] insert(HemodialrecDO[] aggdos) throws BizException;
	
    /**
	*  血液透析护理记录数据保存
	*/
	public abstract HemodialrecDO[] save(HemodialrecDO[] aggdos) throws BizException;
	
    /**
	*  血液透析护理记录数据更新
	*/
	public abstract HemodialrecDO[] update(HemodialrecDO[] aggdos) throws BizException;
	
	/**
	*  血液透析护理记录数据逻辑删除
	*/
	public abstract void logicDelete(HemodialrecDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HemodialrecDO[] enableWithoutFilter(HemodialrecDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HemodialrecDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HemodialrecDO[] disableVOWithoutFilter(HemodialrecDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HemodialrecDO[] aggdos) throws BizException ;
	
}
