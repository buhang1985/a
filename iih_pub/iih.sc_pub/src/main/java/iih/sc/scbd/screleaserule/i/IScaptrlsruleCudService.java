package iih.sc.scbd.screleaserule.i;

import xap.mw.core.data.BizException;
import iih.sc.scbd.screleaserule.d.ScaptrlsruleDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 预约释放规则DO数据维护服务
*/
public interface IScaptrlsruleCudService {
	/**
	*  预约释放规则DO数据真删除
	*/
    public abstract void delete(ScaptrlsruleDO[] aggdos) throws BizException;
    
    /**
	*  预约释放规则DO数据插入保存
	*/
	public abstract ScaptrlsruleDO[] insert(ScaptrlsruleDO[] aggdos) throws BizException;
	
    /**
	*  预约释放规则DO数据保存
	*/
	public abstract ScaptrlsruleDO[] save(ScaptrlsruleDO[] aggdos) throws BizException;
	
    /**
	*  预约释放规则DO数据更新
	*/
	public abstract ScaptrlsruleDO[] update(ScaptrlsruleDO[] aggdos) throws BizException;
	
	/**
	*  预约释放规则DO数据逻辑删除
	*/
	public abstract void logicDelete(ScaptrlsruleDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ScaptrlsruleDO[] enableWithoutFilter(ScaptrlsruleDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ScaptrlsruleDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ScaptrlsruleDO[] disableVOWithoutFilter(ScaptrlsruleDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ScaptrlsruleDO[] dos) throws BizException ;
}
