package iih.bd.srv.itmfst.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.itmfst.d.ItmFstDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 质控项目一级分类数据维护服务
*/
public interface IItmfstCudService {
	/**
	*  质控项目一级分类数据真删除
	*/
    public abstract void delete(ItmFstDO[] aggdos) throws BizException;
    
    /**
	*  质控项目一级分类数据插入保存
	*/
	public abstract ItmFstDO[] insert(ItmFstDO[] aggdos) throws BizException;
	
    /**
	*  质控项目一级分类数据保存
	*/
	public abstract ItmFstDO[] save(ItmFstDO[] aggdos) throws BizException;
	
    /**
	*  质控项目一级分类数据更新
	*/
	public abstract ItmFstDO[] update(ItmFstDO[] aggdos) throws BizException;
	
	/**
	*  质控项目一级分类数据逻辑删除
	*/
	public abstract void logicDelete(ItmFstDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ItmFstDO[] enableWithoutFilter(ItmFstDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ItmFstDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ItmFstDO[] disableVOWithoutFilter(ItmFstDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ItmFstDO[] dos) throws BizException ;
}
