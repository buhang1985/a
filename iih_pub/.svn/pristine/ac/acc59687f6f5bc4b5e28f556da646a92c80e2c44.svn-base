package iih.mm.qy.validperiod.i;

import xap.mw.core.data.BizException;
import iih.mm.qy.validperiod.d.ValidPeriodView;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 有效期查询数据维护服务
*/
public interface IValidperiodCudService {
	/**
	*  有效期查询数据真删除
	*/
    public abstract void delete(ValidPeriodView[] aggdos) throws BizException;
    
    /**
	*  有效期查询数据插入保存
	*/
	public abstract ValidPeriodView[] insert(ValidPeriodView[] aggdos) throws BizException;
	
    /**
	*  有效期查询数据保存
	*/
	public abstract ValidPeriodView[] save(ValidPeriodView[] aggdos) throws BizException;
	
    /**
	*  有效期查询数据更新
	*/
	public abstract ValidPeriodView[] update(ValidPeriodView[] aggdos) throws BizException;
	
	/**
	*  有效期查询数据逻辑删除
	*/
	public abstract void logicDelete(ValidPeriodView[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ValidPeriodView[] enableWithoutFilter(ValidPeriodView[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ValidPeriodView[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ValidPeriodView[] disableVOWithoutFilter(ValidPeriodView[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ValidPeriodView[] dos) throws BizException ;
}
