package iih.bd.srv.emrterm.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.emrterm.d.EmrTermCompDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 病历辅助录入组件数据维护服务
*/
public interface IEmrtermcompCudService {
	/**
	*  病历辅助录入组件数据真删除
	*/
    public abstract void delete(EmrTermCompDO[] aggdos) throws BizException;
    
    /**
	*  病历辅助录入组件数据插入保存
	*/
	public abstract EmrTermCompDO[] insert(EmrTermCompDO[] aggdos) throws BizException;
	
    /**
	*  病历辅助录入组件数据保存
	*/
	public abstract EmrTermCompDO[] save(EmrTermCompDO[] aggdos) throws BizException;
	
    /**
	*  病历辅助录入组件数据更新
	*/
	public abstract EmrTermCompDO[] update(EmrTermCompDO[] aggdos) throws BizException;
	
	/**
	*  病历辅助录入组件数据逻辑删除
	*/
	public abstract void logicDelete(EmrTermCompDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EmrTermCompDO[] enableWithoutFilter(EmrTermCompDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EmrTermCompDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EmrTermCompDO[] disableVOWithoutFilter(EmrTermCompDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EmrTermCompDO[] dos) throws BizException ;
}