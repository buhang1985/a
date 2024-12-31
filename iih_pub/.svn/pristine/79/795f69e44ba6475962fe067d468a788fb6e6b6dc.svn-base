package iih.pe.pitm.pechinesedris.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.pechinesedris.d.PeChineseDRISDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检中国居民膳食营养素参考日摄入量数据维护服务
*/
public interface IPechinesedrisCudService {
	/**
	*  体检中国居民膳食营养素参考日摄入量数据真删除
	*/
    public abstract void delete(PeChineseDRISDO[] aggdos) throws BizException;
    
    /**
	*  体检中国居民膳食营养素参考日摄入量数据插入保存
	*/
	public abstract PeChineseDRISDO[] insert(PeChineseDRISDO[] aggdos) throws BizException;
	
    /**
	*  体检中国居民膳食营养素参考日摄入量数据保存
	*/
	public abstract PeChineseDRISDO[] save(PeChineseDRISDO[] aggdos) throws BizException;
	
    /**
	*  体检中国居民膳食营养素参考日摄入量数据更新
	*/
	public abstract PeChineseDRISDO[] update(PeChineseDRISDO[] aggdos) throws BizException;
	
	/**
	*  体检中国居民膳食营养素参考日摄入量数据逻辑删除
	*/
	public abstract void logicDelete(PeChineseDRISDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeChineseDRISDO[] enableWithoutFilter(PeChineseDRISDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeChineseDRISDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeChineseDRISDO[] disableVOWithoutFilter(PeChineseDRISDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeChineseDRISDO[] dos) throws BizException ;
}
