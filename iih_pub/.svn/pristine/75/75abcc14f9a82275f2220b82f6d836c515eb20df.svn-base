package iih.pe.pqn.pesrvrecmcond.i;

import xap.mw.core.data.BizException;
import iih.pe.pqn.pesrvrecmcond.d.PeSrvRecmCondDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检项目推荐条件定义数据维护服务
*/
public interface IPesrvrecmcondCudService {
	/**
	*  体检项目推荐条件定义数据真删除
	*/
    public abstract void delete(PeSrvRecmCondDO[] aggdos) throws BizException;
    
    /**
	*  体检项目推荐条件定义数据插入保存
	*/
	public abstract PeSrvRecmCondDO[] insert(PeSrvRecmCondDO[] aggdos) throws BizException;
	
    /**
	*  体检项目推荐条件定义数据保存
	*/
	public abstract PeSrvRecmCondDO[] save(PeSrvRecmCondDO[] aggdos) throws BizException;
	
    /**
	*  体检项目推荐条件定义数据更新
	*/
	public abstract PeSrvRecmCondDO[] update(PeSrvRecmCondDO[] aggdos) throws BizException;
	
	/**
	*  体检项目推荐条件定义数据逻辑删除
	*/
	public abstract void logicDelete(PeSrvRecmCondDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeSrvRecmCondDO[] enableWithoutFilter(PeSrvRecmCondDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeSrvRecmCondDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeSrvRecmCondDO[] disableVOWithoutFilter(PeSrvRecmCondDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeSrvRecmCondDO[] dos) throws BizException ;
}
