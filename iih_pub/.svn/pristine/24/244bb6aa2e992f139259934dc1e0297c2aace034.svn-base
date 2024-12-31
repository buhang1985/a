package iih.bd.srv.enregpkg.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.enregpkg.d.SrvEnRegPkgDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医疗服务就诊登记包数据维护服务
*/
public interface IEnregpkgCudService {
	/**
	*  医疗服务就诊登记包数据删除
	*/
    public abstract void delete(SrvEnRegPkgDO[] aggdos) throws BizException;
    
    /**
	*  医疗服务就诊登记包数据插入保存
	*/
	public abstract SrvEnRegPkgDO[] insert(SrvEnRegPkgDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务就诊登记包数据保存
	*/
	public abstract SrvEnRegPkgDO[] save(SrvEnRegPkgDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务就诊登记包数据更新
	*/
	public abstract SrvEnRegPkgDO[] update(SrvEnRegPkgDO[] aggdos) throws BizException;
	
	/**
	*  医疗服务就诊登记包数据真删
	*/
	public abstract void logicDelete(SrvEnRegPkgDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SrvEnRegPkgDO[] enableWithoutFilter(SrvEnRegPkgDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SrvEnRegPkgDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SrvEnRegPkgDO[] disableVOWithoutFilter(SrvEnRegPkgDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SrvEnRegPkgDO[] aggdos) throws BizException ;
}
