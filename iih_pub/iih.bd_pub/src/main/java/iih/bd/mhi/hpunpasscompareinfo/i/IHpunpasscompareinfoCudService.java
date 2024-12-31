package iih.bd.mhi.hpunpasscompareinfo.i;

import xap.mw.core.data.BizException;
import iih.bd.mhi.hpunpasscompareinfo.d.HpUnPassCompareInfoDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保对照_未通过对照信息数据维护服务
*/
public interface IHpunpasscompareinfoCudService {
	/**
	*  医保对照_未通过对照信息数据真删除
	*/
    public abstract void delete(HpUnPassCompareInfoDO[] aggdos) throws BizException;
    
    /**
	*  医保对照_未通过对照信息数据插入保存
	*/
	public abstract HpUnPassCompareInfoDO[] insert(HpUnPassCompareInfoDO[] aggdos) throws BizException;
	
    /**
	*  医保对照_未通过对照信息数据保存
	*/
	public abstract HpUnPassCompareInfoDO[] save(HpUnPassCompareInfoDO[] aggdos) throws BizException;
	
    /**
	*  医保对照_未通过对照信息数据更新
	*/
	public abstract HpUnPassCompareInfoDO[] update(HpUnPassCompareInfoDO[] aggdos) throws BizException;
	
	/**
	*  医保对照_未通过对照信息数据逻辑删除
	*/
	public abstract void logicDelete(HpUnPassCompareInfoDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpUnPassCompareInfoDO[] enableWithoutFilter(HpUnPassCompareInfoDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpUnPassCompareInfoDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpUnPassCompareInfoDO[] disableVOWithoutFilter(HpUnPassCompareInfoDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpUnPassCompareInfoDO[] dos) throws BizException ;
}
