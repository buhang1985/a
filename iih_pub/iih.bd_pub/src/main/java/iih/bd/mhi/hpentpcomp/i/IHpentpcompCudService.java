package iih.bd.mhi.hpentpcomp.i;

import xap.mw.core.data.BizException;
import iih.bd.mhi.hpentpcomp.d.HpEntpCompDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保产品就诊类型对照数据维护服务
*/
public interface IHpentpcompCudService {
	/**
	*  医保产品就诊类型对照数据真删除
	*/
    public abstract void delete(HpEntpCompDO[] aggdos) throws BizException;
    
    /**
	*  医保产品就诊类型对照数据插入保存
	*/
	public abstract HpEntpCompDO[] insert(HpEntpCompDO[] aggdos) throws BizException;
	
    /**
	*  医保产品就诊类型对照数据保存
	*/
	public abstract HpEntpCompDO[] save(HpEntpCompDO[] aggdos) throws BizException;
	
    /**
	*  医保产品就诊类型对照数据更新
	*/
	public abstract HpEntpCompDO[] update(HpEntpCompDO[] aggdos) throws BizException;
	
	/**
	*  医保产品就诊类型对照数据逻辑删除
	*/
	public abstract void logicDelete(HpEntpCompDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpEntpCompDO[] enableWithoutFilter(HpEntpCompDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpEntpCompDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpEntpCompDO[] disableVOWithoutFilter(HpEntpCompDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpEntpCompDO[] dos) throws BizException ;
}
