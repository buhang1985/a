package iih.pe.por.pepsncard.i;

import xap.mw.core.data.BizException;
import iih.pe.por.pepsncard.d.PePsnCardRecDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检客户会员卡数据维护服务
*/
public interface IPePsnCardRecDOCudService {
	/**
	*  体检客户会员卡数据真删除
	*/
    public abstract void delete(PePsnCardRecDO[] aggdos) throws BizException;
    
    /**
	*  体检客户会员卡数据插入保存
	*/
	public abstract PePsnCardRecDO[] insert(PePsnCardRecDO[] aggdos) throws BizException;
	
    /**
	*  体检客户会员卡数据保存
	*/
	public abstract PePsnCardRecDO[] save(PePsnCardRecDO[] aggdos) throws BizException;
	
    /**
	*  体检客户会员卡数据更新
	*/
	public abstract PePsnCardRecDO[] update(PePsnCardRecDO[] aggdos) throws BizException;
	
	/**
	*  体检客户会员卡数据逻辑删除
	*/
	public abstract void logicDelete(PePsnCardRecDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PePsnCardRecDO[] enableWithoutFilter(PePsnCardRecDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PePsnCardRecDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PePsnCardRecDO[] disableVOWithoutFilter(PePsnCardRecDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PePsnCardRecDO[] aggdos) throws BizException ;
	
}
