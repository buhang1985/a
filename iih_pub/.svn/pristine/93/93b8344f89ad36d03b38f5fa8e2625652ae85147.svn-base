package iih.pe.phm.peehr.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.peehr.d.PeEhrDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检电子健康档案EHR数据维护服务
*/
public interface IPeehrCudService {
	/**
	*  体检电子健康档案EHR数据真删除
	*/
    public abstract void delete(PeEhrDO[] aggdos) throws BizException;
    
    /**
	*  体检电子健康档案EHR数据插入保存
	*/
	public abstract PeEhrDO[] insert(PeEhrDO[] aggdos) throws BizException;
	
    /**
	*  体检电子健康档案EHR数据保存
	*/
	public abstract PeEhrDO[] save(PeEhrDO[] aggdos) throws BizException;
	
    /**
	*  体检电子健康档案EHR数据更新
	*/
	public abstract PeEhrDO[] update(PeEhrDO[] aggdos) throws BizException;
	
	/**
	*  体检电子健康档案EHR数据逻辑删除
	*/
	public abstract void logicDelete(PeEhrDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeEhrDO[] enableWithoutFilter(PeEhrDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeEhrDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeEhrDO[] disableVOWithoutFilter(PeEhrDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeEhrDO[] dos) throws BizException ;
}
