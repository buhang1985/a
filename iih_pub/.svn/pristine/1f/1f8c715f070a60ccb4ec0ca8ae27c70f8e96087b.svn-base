package iih.bd.bs.ctmitf.i;

import xap.mw.core.data.BizException;
import iih.bd.bs.ctmitf.d.CtmImplDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 客开接口实现类数据维护服务
*/
public interface ICtmimplCudService {
	/**
	*  客开接口实现类数据真删除
	*/
    public abstract void delete(CtmImplDO[] aggdos) throws BizException;
    
    /**
	*  客开接口实现类数据插入保存
	*/
	public abstract CtmImplDO[] insert(CtmImplDO[] aggdos) throws BizException;
	
    /**
	*  客开接口实现类数据保存
	*/
	public abstract CtmImplDO[] save(CtmImplDO[] aggdos) throws BizException;
	
    /**
	*  客开接口实现类数据更新
	*/
	public abstract CtmImplDO[] update(CtmImplDO[] aggdos) throws BizException;
	
	/**
	*  客开接口实现类数据逻辑删除
	*/
	public abstract void logicDelete(CtmImplDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CtmImplDO[] enableWithoutFilter(CtmImplDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CtmImplDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CtmImplDO[] disableVOWithoutFilter(CtmImplDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CtmImplDO[] dos) throws BizException ;
}
