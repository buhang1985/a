package iih.nmr.pkuf.pathandover.i;

import xap.mw.core.data.BizException;
import iih.nmr.pkuf.pathandover.d.PatHandoverDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 院内转科患者交接记录单数据维护服务
*/
public interface IPathandover1CudService {
	/**
	*  院内转科患者交接记录单数据真删除
	*/
    public abstract void delete(PatHandoverDO[] aggdos) throws BizException;
    
    /**
	*  院内转科患者交接记录单数据插入保存
	*/
	public abstract PatHandoverDO[] insert(PatHandoverDO[] aggdos) throws BizException;
	
    /**
	*  院内转科患者交接记录单数据保存
	*/
	public abstract PatHandoverDO[] save(PatHandoverDO[] aggdos) throws BizException;
	
    /**
	*  院内转科患者交接记录单数据更新
	*/
	public abstract PatHandoverDO[] update(PatHandoverDO[] aggdos) throws BizException;
	
	/**
	*  院内转科患者交接记录单数据逻辑删除
	*/
	public abstract void logicDelete(PatHandoverDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PatHandoverDO[] enableWithoutFilter(PatHandoverDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PatHandoverDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PatHandoverDO[] disableVOWithoutFilter(PatHandoverDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PatHandoverDO[] dos) throws BizException ;
}