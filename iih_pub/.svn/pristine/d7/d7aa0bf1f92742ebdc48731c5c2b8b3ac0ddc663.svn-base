package iih.nmr.nm.bch.dls.i;

import xap.mw.core.data.BizException;
import iih.nmr.nm.bch.dls.d.BchDLSDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 住院患者日常生活自理评估单数据维护服务
*/
public interface IDlsCudService {
	/**
	*  住院患者日常生活自理评估单数据真删除
	*/
    public abstract void delete(BchDLSDO[] aggdos) throws BizException;
    
    /**
	*  住院患者日常生活自理评估单数据插入保存
	*/
	public abstract BchDLSDO[] insert(BchDLSDO[] aggdos) throws BizException;
	
    /**
	*  住院患者日常生活自理评估单数据保存
	*/
	public abstract BchDLSDO[] save(BchDLSDO[] aggdos) throws BizException;
	
    /**
	*  住院患者日常生活自理评估单数据更新
	*/
	public abstract BchDLSDO[] update(BchDLSDO[] aggdos) throws BizException;
	
	/**
	*  住院患者日常生活自理评估单数据逻辑删除
	*/
	public abstract void logicDelete(BchDLSDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BchDLSDO[] enableWithoutFilter(BchDLSDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BchDLSDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BchDLSDO[] disableVOWithoutFilter(BchDLSDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BchDLSDO[] dos) throws BizException ;
}
