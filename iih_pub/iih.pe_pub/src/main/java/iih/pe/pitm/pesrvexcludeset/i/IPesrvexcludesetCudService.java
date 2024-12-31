package iih.pe.pitm.pesrvexcludeset.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.pesrvexcludeset.d.PeSrvExcludesetDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检项目关系设定数据维护服务
*/
public interface IPesrvexcludesetCudService {
	/**
	*  体检项目关系设定数据真删除
	*/
    public abstract void delete(PeSrvExcludesetDO[] aggdos) throws BizException;
    
    /**
	*  体检项目关系设定数据插入保存
	*/
	public abstract PeSrvExcludesetDO[] insert(PeSrvExcludesetDO[] aggdos) throws BizException;
	
    /**
	*  体检项目关系设定数据保存
	*/
	public abstract PeSrvExcludesetDO[] save(PeSrvExcludesetDO[] aggdos) throws BizException;
	
    /**
	*  体检项目关系设定数据更新
	*/
	public abstract PeSrvExcludesetDO[] update(PeSrvExcludesetDO[] aggdos) throws BizException;
	
	/**
	*  体检项目关系设定数据逻辑删除
	*/
	public abstract void logicDelete(PeSrvExcludesetDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeSrvExcludesetDO[] enableWithoutFilter(PeSrvExcludesetDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeSrvExcludesetDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeSrvExcludesetDO[] disableVOWithoutFilter(PeSrvExcludesetDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeSrvExcludesetDO[] dos) throws BizException ;
}
