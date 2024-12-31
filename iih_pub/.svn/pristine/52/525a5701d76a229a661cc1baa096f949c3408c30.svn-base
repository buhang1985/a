package iih.sc.sch.scsch.i;

import xap.mw.core.data.BizException;
import iih.sc.sch.scsch.d.ScSchChlDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 计划排班_排班数据维护服务
*/
public interface IScSchChlDOCudService {
	/**
	*  计划排班_排班数据真删除
	*/
    public abstract void delete(ScSchChlDO[] aggdos) throws BizException;
    
    /**
	*  计划排班_排班数据插入保存
	*/
	public abstract ScSchChlDO[] insert(ScSchChlDO[] aggdos) throws BizException;
	
    /**
	*  计划排班_排班数据保存
	*/
	public abstract ScSchChlDO[] save(ScSchChlDO[] aggdos) throws BizException;
	
    /**
	*  计划排班_排班数据更新
	*/
	public abstract ScSchChlDO[] update(ScSchChlDO[] aggdos) throws BizException;
	
	/**
	*  计划排班_排班数据逻辑删除
	*/
	public abstract void logicDelete(ScSchChlDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ScSchChlDO[] enableWithoutFilter(ScSchChlDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ScSchChlDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ScSchChlDO[] disableVOWithoutFilter(ScSchChlDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ScSchChlDO[] aggdos) throws BizException ;
	
}
