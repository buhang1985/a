package iih.pe.pwf.peoverquery.i;

import xap.mw.core.data.BizException;
import iih.pe.pwf.peoverquery.d.PeOverQueryDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检报告核对名单检索数据维护服务
*/
public interface IPeoverqueryCudService {
	/**
	*  体检报告核对名单检索数据真删除
	*/
    public abstract void delete(PeOverQueryDO[] aggdos) throws BizException;
    
    /**
	*  体检报告核对名单检索数据插入保存
	*/
	public abstract PeOverQueryDO[] insert(PeOverQueryDO[] aggdos) throws BizException;
	
    /**
	*  体检报告核对名单检索数据保存
	*/
	public abstract PeOverQueryDO[] save(PeOverQueryDO[] aggdos) throws BizException;
	
    /**
	*  体检报告核对名单检索数据更新
	*/
	public abstract PeOverQueryDO[] update(PeOverQueryDO[] aggdos) throws BizException;
	
	/**
	*  体检报告核对名单检索数据逻辑删除
	*/
	public abstract void logicDelete(PeOverQueryDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeOverQueryDO[] enableWithoutFilter(PeOverQueryDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeOverQueryDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeOverQueryDO[] disableVOWithoutFilter(PeOverQueryDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeOverQueryDO[] dos) throws BizException ;
}
