package iih.bd.mhi.hpdepdircomp.i;

import xap.mw.core.data.BizException;
import iih.bd.mhi.hpdepdircomp.d.HpDepDirCompDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保产品_科别对照数据维护服务
*/
public interface IHpdepdircompCudService {
	/**
	*  医保产品_科别对照数据真删除
	*/
    public abstract void delete(HpDepDirCompDO[] aggdos) throws BizException;
    
    /**
	*  医保产品_科别对照数据插入保存
	*/
	public abstract HpDepDirCompDO[] insert(HpDepDirCompDO[] aggdos) throws BizException;
	
    /**
	*  医保产品_科别对照数据保存
	*/
	public abstract HpDepDirCompDO[] save(HpDepDirCompDO[] aggdos) throws BizException;
	
    /**
	*  医保产品_科别对照数据更新
	*/
	public abstract HpDepDirCompDO[] update(HpDepDirCompDO[] aggdos) throws BizException;
	
	/**
	*  医保产品_科别对照数据逻辑删除
	*/
	public abstract void logicDelete(HpDepDirCompDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpDepDirCompDO[] enableWithoutFilter(HpDepDirCompDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpDepDirCompDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpDepDirCompDO[] disableVOWithoutFilter(HpDepDirCompDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpDepDirCompDO[] dos) throws BizException ;
}
