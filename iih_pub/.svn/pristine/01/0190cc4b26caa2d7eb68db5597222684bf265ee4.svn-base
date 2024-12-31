package iih.sc.sch.scsch.i;

import xap.mw.core.data.BizException;
import iih.sc.sch.scsch.d.ScSchOptsrvDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 计划排班_排班数据维护服务
*/
public interface IScSchOptsrvDOCudService {
	/**
	*  计划排班_排班数据真删除
	*/
    public abstract void delete(ScSchOptsrvDO[] aggdos) throws BizException;
    
    /**
	*  计划排班_排班数据插入保存
	*/
	public abstract ScSchOptsrvDO[] insert(ScSchOptsrvDO[] aggdos) throws BizException;
	
    /**
	*  计划排班_排班数据保存
	*/
	public abstract ScSchOptsrvDO[] save(ScSchOptsrvDO[] aggdos) throws BizException;
	
    /**
	*  计划排班_排班数据更新
	*/
	public abstract ScSchOptsrvDO[] update(ScSchOptsrvDO[] aggdos) throws BizException;
	
	/**
	*  计划排班_排班数据逻辑删除
	*/
	public abstract void logicDelete(ScSchOptsrvDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ScSchOptsrvDO[] enableWithoutFilter(ScSchOptsrvDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ScSchOptsrvDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ScSchOptsrvDO[] disableVOWithoutFilter(ScSchOptsrvDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ScSchOptsrvDO[] aggdos) throws BizException ;
	
}
