package iih.bd.srv.mropgroup.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.mropgroup.d.MrOpGroupDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 病历业务组数据维护服务
*/
public interface IMropgroupCudService {
	/**
	*  病历业务组数据真删除
	*/
    public abstract void delete(MrOpGroupDO[] aggdos) throws BizException;
    
    /**
	*  病历业务组数据插入保存
	*/
	public abstract MrOpGroupDO[] insert(MrOpGroupDO[] aggdos) throws BizException;
	
    /**
	*  病历业务组数据保存
	*/
	public abstract MrOpGroupDO[] save(MrOpGroupDO[] aggdos) throws BizException;
	
    /**
	*  病历业务组数据更新
	*/
	public abstract MrOpGroupDO[] update(MrOpGroupDO[] aggdos) throws BizException;
	
	/**
	*  病历业务组数据逻辑删除
	*/
	public abstract void logicDelete(MrOpGroupDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MrOpGroupDO[] enableWithoutFilter(MrOpGroupDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MrOpGroupDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MrOpGroupDO[] disableVOWithoutFilter(MrOpGroupDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MrOpGroupDO[] dos) throws BizException ;
}
