package iih.bd.srv.srvselfcaitm.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.srvselfcaitm.d.SrvSelfCaItemDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 服务自定义分类项目数据维护服务
*/
public interface ISrvselfcaitmMDOCudService {
	/**
	*  服务自定义分类项目数据真删除
	*/
    public abstract void delete(SrvSelfCaItemDO[] aggdos) throws BizException;
    
    /**
	*  服务自定义分类项目数据插入保存
	*/
	public abstract SrvSelfCaItemDO[] insert(SrvSelfCaItemDO[] aggdos) throws BizException;
	
    /**
	*  服务自定义分类项目数据保存
	*/
	public abstract SrvSelfCaItemDO[] save(SrvSelfCaItemDO[] aggdos) throws BizException;
	
    /**
	*  服务自定义分类项目数据更新
	*/
	public abstract SrvSelfCaItemDO[] update(SrvSelfCaItemDO[] aggdos) throws BizException;
	
	/**
	*  服务自定义分类项目数据逻辑删除
	*/
	public abstract void logicDelete(SrvSelfCaItemDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SrvSelfCaItemDO[] enableWithoutFilter(SrvSelfCaItemDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SrvSelfCaItemDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SrvSelfCaItemDO[] disableVOWithoutFilter(SrvSelfCaItemDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SrvSelfCaItemDO[] aggdos) throws BizException ;
	
}
