package iih.en.pv.inpatient.i;

import xap.mw.core.data.BizException;
import iih.en.pv.inpatient.d.EnPeCmpyDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 团检记录数据维护服务
*/
public interface IEnpecmpyMDOCudService {
	/**
	*  团检记录数据真删除
	*/
    public abstract void delete(EnPeCmpyDO[] aggdos) throws BizException;
    
    /**
	*  团检记录数据插入保存
	*/
	public abstract EnPeCmpyDO[] insert(EnPeCmpyDO[] aggdos) throws BizException;
	
    /**
	*  团检记录数据保存
	*/
	public abstract EnPeCmpyDO[] save(EnPeCmpyDO[] aggdos) throws BizException;
	
    /**
	*  团检记录数据更新
	*/
	public abstract EnPeCmpyDO[] update(EnPeCmpyDO[] aggdos) throws BizException;
	
	/**
	*  团检记录数据逻辑删除
	*/
	public abstract void logicDelete(EnPeCmpyDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EnPeCmpyDO[] enableWithoutFilter(EnPeCmpyDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EnPeCmpyDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EnPeCmpyDO[] disableVOWithoutFilter(EnPeCmpyDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EnPeCmpyDO[] aggdos) throws BizException ;
	
}
