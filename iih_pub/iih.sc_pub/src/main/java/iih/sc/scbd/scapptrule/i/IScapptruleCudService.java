package iih.sc.scbd.scapptrule.i;

import xap.mw.core.data.BizException;
import iih.sc.scbd.scapptrule.d.ScapptruleDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 排班预约规则数据维护服务
*/
public interface IScapptruleCudService {
	/**
	*  排班预约规则数据真删除
	*/
    public abstract void delete(ScapptruleDO[] aggdos) throws BizException;
    
    /**
	*  排班预约规则数据插入保存
	*/
	public abstract ScapptruleDO[] insert(ScapptruleDO[] aggdos) throws BizException;
	
    /**
	*  排班预约规则数据保存
	*/
	public abstract ScapptruleDO[] save(ScapptruleDO[] aggdos) throws BizException;
	
    /**
	*  排班预约规则数据更新
	*/
	public abstract ScapptruleDO[] update(ScapptruleDO[] aggdos) throws BizException;
	
	/**
	*  排班预约规则数据逻辑删除
	*/
	public abstract void logicDelete(ScapptruleDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ScapptruleDO[] enableWithoutFilter(ScapptruleDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ScapptruleDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ScapptruleDO[] disableVOWithoutFilter(ScapptruleDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ScapptruleDO[] dos) throws BizException ;
}
