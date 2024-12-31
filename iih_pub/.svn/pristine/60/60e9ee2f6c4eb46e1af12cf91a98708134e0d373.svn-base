package iih.ei.itf.eiitfcateitm.i;

import xap.mw.core.data.BizException;
import iih.ei.itf.eiitfcateitm.d.ItfCateItmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 接口分类项目数据维护服务
*/
public interface IEiitfcateitmCudService {
	/**
	*  接口分类项目数据真删除
	*/
    public abstract void delete(ItfCateItmDO[] aggdos) throws BizException;
    
    /**
	*  接口分类项目数据插入保存
	*/
	public abstract ItfCateItmDO[] insert(ItfCateItmDO[] aggdos) throws BizException;
	
    /**
	*  接口分类项目数据保存
	*/
	public abstract ItfCateItmDO[] save(ItfCateItmDO[] aggdos) throws BizException;
	
    /**
	*  接口分类项目数据更新
	*/
	public abstract ItfCateItmDO[] update(ItfCateItmDO[] aggdos) throws BizException;
	
	/**
	*  接口分类项目数据逻辑删除
	*/
	public abstract void logicDelete(ItfCateItmDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ItfCateItmDO[] enableWithoutFilter(ItfCateItmDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ItfCateItmDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ItfCateItmDO[] disableVOWithoutFilter(ItfCateItmDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ItfCateItmDO[] dos) throws BizException ;
}
