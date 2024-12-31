package iih.sc.sch.sctickb.i;

import xap.mw.core.data.BizException;
import iih.sc.sch.sctickb.d.ScSchTickBDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 计划排班_号位B数据维护服务
*/
public interface ISctickbCudService {
	/**
	*  计划排班_号位B数据真删除
	*/
    public abstract void delete(ScSchTickBDO[] aggdos) throws BizException;
    
    /**
	*  计划排班_号位B数据插入保存
	*/
	public abstract ScSchTickBDO[] insert(ScSchTickBDO[] aggdos) throws BizException;
	
    /**
	*  计划排班_号位B数据保存
	*/
	public abstract ScSchTickBDO[] save(ScSchTickBDO[] aggdos) throws BizException;
	
    /**
	*  计划排班_号位B数据更新
	*/
	public abstract ScSchTickBDO[] update(ScSchTickBDO[] aggdos) throws BizException;
	
	/**
	*  计划排班_号位B数据逻辑删除
	*/
	public abstract void logicDelete(ScSchTickBDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ScSchTickBDO[] enableWithoutFilter(ScSchTickBDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ScSchTickBDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ScSchTickBDO[] disableVOWithoutFilter(ScSchTickBDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ScSchTickBDO[] dos) throws BizException ;
}
