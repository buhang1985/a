package iih.bd.srv.medvalidate.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.medvalidate.d.BDErrorInfoItemDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 基础数据服务校验数据维护服务
*/
public interface IBDErrorInfoItemDOCudService {
	/**
	*  基础数据服务校验数据真删除
	*/
    public abstract void delete(BDErrorInfoItemDO[] aggdos) throws BizException;
    
    /**
	*  基础数据服务校验数据插入保存
	*/
	public abstract BDErrorInfoItemDO[] insert(BDErrorInfoItemDO[] aggdos) throws BizException;
	
    /**
	*  基础数据服务校验数据保存
	*/
	public abstract BDErrorInfoItemDO[] save(BDErrorInfoItemDO[] aggdos) throws BizException;
	
    /**
	*  基础数据服务校验数据更新
	*/
	public abstract BDErrorInfoItemDO[] update(BDErrorInfoItemDO[] aggdos) throws BizException;
	
	/**
	*  基础数据服务校验数据逻辑删除
	*/
	public abstract void logicDelete(BDErrorInfoItemDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BDErrorInfoItemDO[] enableWithoutFilter(BDErrorInfoItemDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BDErrorInfoItemDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BDErrorInfoItemDO[] disableVOWithoutFilter(BDErrorInfoItemDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BDErrorInfoItemDO[] aggdos) throws BizException ;
	
}
