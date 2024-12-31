package iih.sc.apt.aptipbedday.i;

import xap.mw.core.data.BizException;
import iih.sc.apt.aptipbedday.d.AptIpBeddayDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 预住院预约日间诊疗数据维护服务
*/
public interface IAptipbeddayCudService {
	/**
	*  预住院预约日间诊疗数据真删除
	*/
    public abstract void delete(AptIpBeddayDO[] aggdos) throws BizException;
    
    /**
	*  预住院预约日间诊疗数据插入保存
	*/
	public abstract AptIpBeddayDO[] insert(AptIpBeddayDO[] aggdos) throws BizException;
	
    /**
	*  预住院预约日间诊疗数据保存
	*/
	public abstract AptIpBeddayDO[] save(AptIpBeddayDO[] aggdos) throws BizException;
	
    /**
	*  预住院预约日间诊疗数据更新
	*/
	public abstract AptIpBeddayDO[] update(AptIpBeddayDO[] aggdos) throws BizException;
	
	/**
	*  预住院预约日间诊疗数据逻辑删除
	*/
	public abstract void logicDelete(AptIpBeddayDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public AptIpBeddayDO[] enableWithoutFilter(AptIpBeddayDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(AptIpBeddayDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public AptIpBeddayDO[] disableVOWithoutFilter(AptIpBeddayDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(AptIpBeddayDO[] dos) throws BizException ;
}
