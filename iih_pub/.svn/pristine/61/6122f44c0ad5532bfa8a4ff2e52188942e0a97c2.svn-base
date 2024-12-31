package iih.sc.sch.scsch.i;

import xap.mw.core.data.BizException;
import iih.sc.sch.scsch.d.ScSchEnDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 计划排班_排班数据维护服务
*/
public interface IScSchEnDOCudService {
	/**
	*  计划排班_排班数据真删除
	*/
    public abstract void delete(ScSchEnDO[] aggdos) throws BizException;
    
    /**
	*  计划排班_排班数据插入保存
	*/
	public abstract ScSchEnDO[] insert(ScSchEnDO[] aggdos) throws BizException;
	
    /**
	*  计划排班_排班数据保存
	*/
	public abstract ScSchEnDO[] save(ScSchEnDO[] aggdos) throws BizException;
	
    /**
	*  计划排班_排班数据更新
	*/
	public abstract ScSchEnDO[] update(ScSchEnDO[] aggdos) throws BizException;
	
	/**
	*  计划排班_排班数据逻辑删除
	*/
	public abstract void logicDelete(ScSchEnDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ScSchEnDO[] enableWithoutFilter(ScSchEnDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ScSchEnDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ScSchEnDO[] disableVOWithoutFilter(ScSchEnDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ScSchEnDO[] aggdos) throws BizException ;
	
}
