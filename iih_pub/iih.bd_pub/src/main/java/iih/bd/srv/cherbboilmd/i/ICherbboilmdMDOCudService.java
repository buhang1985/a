package iih.bd.srv.cherbboilmd.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.cherbboilmd.d.CHerbBoilMdDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医疗服务中药煎法数据维护服务
*/
public interface ICherbboilmdMDOCudService {
	/**
	*  医疗服务中药煎法数据真删除
	*/
    public abstract void delete(CHerbBoilMdDO[] aggdos) throws BizException;
    
    /**
	*  医疗服务中药煎法数据插入保存
	*/
	public abstract CHerbBoilMdDO[] insert(CHerbBoilMdDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务中药煎法数据保存
	*/
	public abstract CHerbBoilMdDO[] save(CHerbBoilMdDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务中药煎法数据更新
	*/
	public abstract CHerbBoilMdDO[] update(CHerbBoilMdDO[] aggdos) throws BizException;
	
	/**
	*  医疗服务中药煎法数据逻辑删除
	*/
	public abstract void logicDelete(CHerbBoilMdDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CHerbBoilMdDO[] enableWithoutFilter(CHerbBoilMdDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CHerbBoilMdDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CHerbBoilMdDO[] disableVOWithoutFilter(CHerbBoilMdDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CHerbBoilMdDO[] aggdos) throws BizException ;
	
}
