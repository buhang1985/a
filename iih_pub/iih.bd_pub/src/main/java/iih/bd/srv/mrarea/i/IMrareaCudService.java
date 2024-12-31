package iih.bd.srv.mrarea.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.mrarea.d.MrAreaDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 病历四级行政区划数据维护服务
*/
public interface IMrareaCudService {
	/**
	*  病历四级行政区划数据真删除
	*/
    public abstract void delete(MrAreaDO[] aggdos) throws BizException;
    
    /**
	*  病历四级行政区划数据插入保存
	*/
	public abstract MrAreaDO[] insert(MrAreaDO[] aggdos) throws BizException;
	
    /**
	*  病历四级行政区划数据保存
	*/
	public abstract MrAreaDO[] save(MrAreaDO[] aggdos) throws BizException;
	
    /**
	*  病历四级行政区划数据更新
	*/
	public abstract MrAreaDO[] update(MrAreaDO[] aggdos) throws BizException;
	
	/**
	*  病历四级行政区划数据逻辑删除
	*/
	public abstract void logicDelete(MrAreaDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MrAreaDO[] enableWithoutFilter(MrAreaDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MrAreaDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MrAreaDO[] disableVOWithoutFilter(MrAreaDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MrAreaDO[] dos) throws BizException ;
}
