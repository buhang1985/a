package iih.mi.mibd.dep.i;

import xap.mw.core.data.BizException;
import iih.mi.mibd.dep.d.DepDo;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保平台_科别数据维护服务
*/
public interface IDepCudService {
	/**
	*  医保平台_科别数据真删除
	*/
    public abstract void delete(DepDo[] aggdos) throws BizException;
    
    /**
	*  医保平台_科别数据插入保存
	*/
	public abstract DepDo[] insert(DepDo[] aggdos) throws BizException;
	
    /**
	*  医保平台_科别数据保存
	*/
	public abstract DepDo[] save(DepDo[] aggdos) throws BizException;
	
    /**
	*  医保平台_科别数据更新
	*/
	public abstract DepDo[] update(DepDo[] aggdos) throws BizException;
	
	/**
	*  医保平台_科别数据逻辑删除
	*/
	public abstract void logicDelete(DepDo[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DepDo[] enableWithoutFilter(DepDo[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DepDo[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DepDo[] disableVOWithoutFilter(DepDo[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DepDo[] dos) throws BizException ;
}
