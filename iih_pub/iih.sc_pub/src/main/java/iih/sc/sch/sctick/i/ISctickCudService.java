package iih.sc.sch.sctick.i;

import xap.mw.core.data.BizException;
import iih.sc.sch.sctick.d.ScSchTickDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 排班号位数据维护服务
*/
public interface ISctickCudService {
	/**
	*  排班号位数据真删除
	*/
    public abstract void delete(ScSchTickDO[] aggdos) throws BizException;
    
    /**
	*  排班号位数据插入保存
	*/
	public abstract ScSchTickDO[] insert(ScSchTickDO[] aggdos) throws BizException;
	
    /**
	*  排班号位数据保存
	*/
	public abstract ScSchTickDO[] save(ScSchTickDO[] aggdos) throws BizException;
	
    /**
	*  排班号位数据更新
	*/
	public abstract ScSchTickDO[] update(ScSchTickDO[] aggdos) throws BizException;
	
	/**
	*  排班号位数据逻辑删除
	*/
	public abstract void logicDelete(ScSchTickDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ScSchTickDO[] enableWithoutFilter(ScSchTickDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ScSchTickDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ScSchTickDO[] disableVOWithoutFilter(ScSchTickDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ScSchTickDO[] dos) throws BizException ;
}
