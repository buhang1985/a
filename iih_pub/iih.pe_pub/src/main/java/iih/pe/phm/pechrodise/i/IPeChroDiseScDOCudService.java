package iih.pe.phm.pechrodise.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.pechrodise.d.PeChroDiseScDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检慢性病风险评估数据维护服务
*/
public interface IPeChroDiseScDOCudService {
	/**
	*  体检慢性病风险评估数据真删除
	*/
    public abstract void delete(PeChroDiseScDO[] aggdos) throws BizException;
    
    /**
	*  体检慢性病风险评估数据插入保存
	*/
	public abstract PeChroDiseScDO[] insert(PeChroDiseScDO[] aggdos) throws BizException;
	
    /**
	*  体检慢性病风险评估数据保存
	*/
	public abstract PeChroDiseScDO[] save(PeChroDiseScDO[] aggdos) throws BizException;
	
    /**
	*  体检慢性病风险评估数据更新
	*/
	public abstract PeChroDiseScDO[] update(PeChroDiseScDO[] aggdos) throws BizException;
	
	/**
	*  体检慢性病风险评估数据逻辑删除
	*/
	public abstract void logicDelete(PeChroDiseScDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeChroDiseScDO[] enableWithoutFilter(PeChroDiseScDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeChroDiseScDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeChroDiseScDO[] disableVOWithoutFilter(PeChroDiseScDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeChroDiseScDO[] aggdos) throws BizException ;
	
}
