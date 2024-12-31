package iih.mi.mibd.entp.i;

import xap.mw.core.data.BizException;
import iih.mi.mibd.entp.d.EnTpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保平台_就诊类型数据维护服务
*/
public interface IEntpCudService {
	/**
	*  医保平台_就诊类型数据真删除
	*/
    public abstract void delete(EnTpDO[] aggdos) throws BizException;
    
    /**
	*  医保平台_就诊类型数据插入保存
	*/
	public abstract EnTpDO[] insert(EnTpDO[] aggdos) throws BizException;
	
    /**
	*  医保平台_就诊类型数据保存
	*/
	public abstract EnTpDO[] save(EnTpDO[] aggdos) throws BizException;
	
    /**
	*  医保平台_就诊类型数据更新
	*/
	public abstract EnTpDO[] update(EnTpDO[] aggdos) throws BizException;
	
	/**
	*  医保平台_就诊类型数据逻辑删除
	*/
	public abstract void logicDelete(EnTpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EnTpDO[] enableWithoutFilter(EnTpDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EnTpDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EnTpDO[] disableVOWithoutFilter(EnTpDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EnTpDO[] dos) throws BizException ;
}
