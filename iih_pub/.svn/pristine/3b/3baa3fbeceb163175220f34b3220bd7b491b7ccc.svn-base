package iih.mp.nr.entlv.i;

import xap.mw.core.data.BizException;
import iih.mp.nr.entlv.d.PatLeaveDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 患者外出数据维护服务
*/
public interface IEntlvCudService {
	/**
	*  患者外出数据真删除
	*/
    public abstract void delete(PatLeaveDO[] aggdos) throws BizException;
    
    /**
	*  患者外出数据插入保存
	*/
	public abstract PatLeaveDO[] insert(PatLeaveDO[] aggdos) throws BizException;
	
    /**
	*  患者外出数据保存
	*/
	public abstract PatLeaveDO[] save(PatLeaveDO[] aggdos) throws BizException;
	
    /**
	*  患者外出数据更新
	*/
	public abstract PatLeaveDO[] update(PatLeaveDO[] aggdos) throws BizException;
	
	/**
	*  患者外出数据逻辑删除
	*/
	public abstract void logicDelete(PatLeaveDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PatLeaveDO[] enableWithoutFilter(PatLeaveDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PatLeaveDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PatLeaveDO[] disableVOWithoutFilter(PatLeaveDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PatLeaveDO[] dos) throws BizException ;
}
