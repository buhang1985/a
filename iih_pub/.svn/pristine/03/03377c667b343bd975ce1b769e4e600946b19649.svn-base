package iih.bd.mhi.hpdoc.i;

import xap.mw.core.data.BizException;
import iih.bd.mhi.hpdoc.d.HpDocDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保档案数据维护服务
*/
public interface IHpdocCudService {
	/**
	*  医保档案数据真删除
	*/
    public abstract void delete(HpDocDO[] aggdos) throws BizException;
    
    /**
	*  医保档案数据插入保存
	*/
	public abstract HpDocDO[] insert(HpDocDO[] aggdos) throws BizException;
	
    /**
	*  医保档案数据保存
	*/
	public abstract HpDocDO[] save(HpDocDO[] aggdos) throws BizException;
	
    /**
	*  医保档案数据更新
	*/
	public abstract HpDocDO[] update(HpDocDO[] aggdos) throws BizException;
	
	/**
	*  医保档案数据逻辑删除
	*/
	public abstract void logicDelete(HpDocDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpDocDO[] enableWithoutFilter(HpDocDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpDocDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpDocDO[] disableVOWithoutFilter(HpDocDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpDocDO[] dos) throws BizException ;
}
