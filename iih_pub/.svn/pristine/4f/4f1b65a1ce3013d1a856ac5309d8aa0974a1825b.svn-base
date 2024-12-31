package iih.en.pv.inpatient.i;

import xap.mw.core.data.BizException;
import iih.en.pv.inpatient.d.EnIppreDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 预住院数据维护服务
*/
public interface IEnippreCudService {
	/**
	*  预住院数据真删除
	*/
    public abstract void delete(EnIppreDO[] aggdos) throws BizException;
    
    /**
	*  预住院数据插入保存
	*/
	public abstract EnIppreDO[] insert(EnIppreDO[] aggdos) throws BizException;
	
    /**
	*  预住院数据保存
	*/
	public abstract EnIppreDO[] save(EnIppreDO[] aggdos) throws BizException;
	
    /**
	*  预住院数据更新
	*/
	public abstract EnIppreDO[] update(EnIppreDO[] aggdos) throws BizException;
	
	/**
	*  预住院数据逻辑删除
	*/
	public abstract void logicDelete(EnIppreDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EnIppreDO[] enableWithoutFilter(EnIppreDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EnIppreDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EnIppreDO[] disableVOWithoutFilter(EnIppreDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EnIppreDO[] dos) throws BizException ;
}
