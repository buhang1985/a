package iih.bd.srv.srvselfca.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.srvselfca.d.SrvSlefCateDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 服务自定义分类数据维护服务
*/
public interface ISrvselfcaCudService {
	/**
	*  服务自定义分类数据真删除
	*/
    public abstract void delete(SrvSlefCateDO[] aggdos) throws BizException;
    
    /**
	*  服务自定义分类数据插入保存
	*/
	public abstract SrvSlefCateDO[] insert(SrvSlefCateDO[] aggdos) throws BizException;
	
    /**
	*  服务自定义分类数据保存
	*/
	public abstract SrvSlefCateDO[] save(SrvSlefCateDO[] aggdos) throws BizException;
	
    /**
	*  服务自定义分类数据更新
	*/
	public abstract SrvSlefCateDO[] update(SrvSlefCateDO[] aggdos) throws BizException;
	
	/**
	*  服务自定义分类数据逻辑删除
	*/
	public abstract void logicDelete(SrvSlefCateDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SrvSlefCateDO[] enableWithoutFilter(SrvSlefCateDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SrvSlefCateDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SrvSlefCateDO[] disableVOWithoutFilter(SrvSlefCateDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SrvSlefCateDO[] dos) throws BizException ;
}
