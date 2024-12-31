package iih.sfda.aer.aerevcpytuser.i;

import xap.mw.core.data.BizException;
import iih.sfda.aer.aerevcpytuser.d.AerEvCopyUserDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 事件抄送人员数据维护服务
*/
public interface IAerevcpytuserCudService {
	/**
	*  事件抄送人员数据真删除
	*/
    public abstract void delete(AerEvCopyUserDO[] aggdos) throws BizException;
    
    /**
	*  事件抄送人员数据插入保存
	*/
	public abstract AerEvCopyUserDO[] insert(AerEvCopyUserDO[] aggdos) throws BizException;
	
    /**
	*  事件抄送人员数据保存
	*/
	public abstract AerEvCopyUserDO[] save(AerEvCopyUserDO[] aggdos) throws BizException;
	
    /**
	*  事件抄送人员数据更新
	*/
	public abstract AerEvCopyUserDO[] update(AerEvCopyUserDO[] aggdos) throws BizException;
	
	/**
	*  事件抄送人员数据逻辑删除
	*/
	public abstract void logicDelete(AerEvCopyUserDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public AerEvCopyUserDO[] enableWithoutFilter(AerEvCopyUserDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(AerEvCopyUserDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public AerEvCopyUserDO[] disableVOWithoutFilter(AerEvCopyUserDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(AerEvCopyUserDO[] dos) throws BizException ;
}
