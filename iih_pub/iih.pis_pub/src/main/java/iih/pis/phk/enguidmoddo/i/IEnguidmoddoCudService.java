package iih.pis.phk.enguidmoddo.i;

import xap.mw.core.data.BizException;
import iih.pis.phk.enguidmoddo.d.EnGuidModDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 导诊模块数据维护服务
*/
public interface IEnguidmoddoCudService {
	/**
	*  导诊模块数据真删除
	*/
    public abstract void delete(EnGuidModDO[] aggdos) throws BizException;
    
    /**
	*  导诊模块数据插入保存
	*/
	public abstract EnGuidModDO[] insert(EnGuidModDO[] aggdos) throws BizException;
	
    /**
	*  导诊模块数据保存
	*/
	public abstract EnGuidModDO[] save(EnGuidModDO[] aggdos) throws BizException;
	
    /**
	*  导诊模块数据更新
	*/
	public abstract EnGuidModDO[] update(EnGuidModDO[] aggdos) throws BizException;
	
	/**
	*  导诊模块数据逻辑删除
	*/
	public abstract void logicDelete(EnGuidModDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EnGuidModDO[] enableWithoutFilter(EnGuidModDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EnGuidModDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EnGuidModDO[] disableVOWithoutFilter(EnGuidModDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EnGuidModDO[] dos) throws BizException ;
}
