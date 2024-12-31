package iih.pe.pps.peinterview.i;

import xap.mw.core.data.BizException;
import iih.pe.pps.peinterview.d.PeInterviewHistDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检检后随访数据维护服务
*/
public interface IPeInterviewHistDOCudService {
	/**
	*  体检检后随访数据真删除
	*/
    public abstract void delete(PeInterviewHistDO[] aggdos) throws BizException;
    
    /**
	*  体检检后随访数据插入保存
	*/
	public abstract PeInterviewHistDO[] insert(PeInterviewHistDO[] aggdos) throws BizException;
	
    /**
	*  体检检后随访数据保存
	*/
	public abstract PeInterviewHistDO[] save(PeInterviewHistDO[] aggdos) throws BizException;
	
    /**
	*  体检检后随访数据更新
	*/
	public abstract PeInterviewHistDO[] update(PeInterviewHistDO[] aggdos) throws BizException;
	
	/**
	*  体检检后随访数据逻辑删除
	*/
	public abstract void logicDelete(PeInterviewHistDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeInterviewHistDO[] enableWithoutFilter(PeInterviewHistDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeInterviewHistDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeInterviewHistDO[] disableVOWithoutFilter(PeInterviewHistDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeInterviewHistDO[] aggdos) throws BizException ;
	
}
