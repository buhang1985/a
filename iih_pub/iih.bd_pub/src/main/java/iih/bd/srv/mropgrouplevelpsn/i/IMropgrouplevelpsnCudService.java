package iih.bd.srv.mropgrouplevelpsn.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.mropgrouplevelpsn.d.MrOpGroupLevelPsnDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 操作人员数据维护服务
*/
public interface IMropgrouplevelpsnCudService {
	/**
	*  操作人员数据真删除
	*/
    public abstract void delete(MrOpGroupLevelPsnDO[] aggdos) throws BizException;
    
    /**
	*  操作人员数据插入保存
	*/
	public abstract MrOpGroupLevelPsnDO[] insert(MrOpGroupLevelPsnDO[] aggdos) throws BizException;
	
    /**
	*  操作人员数据保存
	*/
	public abstract MrOpGroupLevelPsnDO[] save(MrOpGroupLevelPsnDO[] aggdos) throws BizException;
	
    /**
	*  操作人员数据更新
	*/
	public abstract MrOpGroupLevelPsnDO[] update(MrOpGroupLevelPsnDO[] aggdos) throws BizException;
	
	/**
	*  操作人员数据逻辑删除
	*/
	public abstract void logicDelete(MrOpGroupLevelPsnDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MrOpGroupLevelPsnDO[] enableWithoutFilter(MrOpGroupLevelPsnDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MrOpGroupLevelPsnDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MrOpGroupLevelPsnDO[] disableVOWithoutFilter(MrOpGroupLevelPsnDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MrOpGroupLevelPsnDO[] dos) throws BizException ;
}
