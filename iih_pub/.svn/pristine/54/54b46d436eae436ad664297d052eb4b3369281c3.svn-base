package iih.nm.nqm.nmnqmcsca.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nmnqmcsca.d.NmNqmCsCaDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 检查标准分类数据维护服务
*/
public interface INmnqmcscaCudService {
	/**
	*  检查标准分类数据真删除
	*/
    public abstract void delete(NmNqmCsCaDO[] aggdos) throws BizException;
    
    /**
	*  检查标准分类数据插入保存
	*/
	public abstract NmNqmCsCaDO[] insert(NmNqmCsCaDO[] aggdos) throws BizException;
	
    /**
	*  检查标准分类数据保存
	*/
	public abstract NmNqmCsCaDO[] save(NmNqmCsCaDO[] aggdos) throws BizException;
	
    /**
	*  检查标准分类数据更新
	*/
	public abstract NmNqmCsCaDO[] update(NmNqmCsCaDO[] aggdos) throws BizException;
	
	/**
	*  检查标准分类数据逻辑删除
	*/
	public abstract void logicDelete(NmNqmCsCaDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNqmCsCaDO[] enableWithoutFilter(NmNqmCsCaDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNqmCsCaDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNqmCsCaDO[] disableVOWithoutFilter(NmNqmCsCaDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNqmCsCaDO[] dos) throws BizException ;
}
