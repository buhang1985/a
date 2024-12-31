package iih.pe.por.pepsnmerge.i;

import xap.mw.core.data.BizException;
import iih.pe.por.pepsnmerge.d.PePsnMergeDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检客户资料合并数据维护服务
*/
public interface IPepsnmergeCudService {
	/**
	*  体检客户资料合并数据真删除
	*/
    public abstract void delete(PePsnMergeDO[] aggdos) throws BizException;
    
    /**
	*  体检客户资料合并数据插入保存
	*/
	public abstract PePsnMergeDO[] insert(PePsnMergeDO[] aggdos) throws BizException;
	
    /**
	*  体检客户资料合并数据保存
	*/
	public abstract PePsnMergeDO[] save(PePsnMergeDO[] aggdos) throws BizException;
	
    /**
	*  体检客户资料合并数据更新
	*/
	public abstract PePsnMergeDO[] update(PePsnMergeDO[] aggdos) throws BizException;
	
	/**
	*  体检客户资料合并数据逻辑删除
	*/
	public abstract void logicDelete(PePsnMergeDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PePsnMergeDO[] enableWithoutFilter(PePsnMergeDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PePsnMergeDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PePsnMergeDO[] disableVOWithoutFilter(PePsnMergeDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PePsnMergeDO[] dos) throws BizException ;
}
