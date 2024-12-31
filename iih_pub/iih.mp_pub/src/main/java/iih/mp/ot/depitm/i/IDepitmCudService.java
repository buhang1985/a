package iih.mp.ot.depitm.i;

import xap.mw.core.data.BizException;
import iih.mp.ot.depitm.d.MpOrPrDepItmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 通用医技科室录入项目数据维护服务
*/
public interface IDepitmCudService {
	/**
	*  通用医技科室录入项目数据真删除
	*/
    public abstract void delete(MpOrPrDepItmDO[] aggdos) throws BizException;
    
    /**
	*  通用医技科室录入项目数据插入保存
	*/
	public abstract MpOrPrDepItmDO[] insert(MpOrPrDepItmDO[] aggdos) throws BizException;
	
    /**
	*  通用医技科室录入项目数据保存
	*/
	public abstract MpOrPrDepItmDO[] save(MpOrPrDepItmDO[] aggdos) throws BizException;
	
    /**
	*  通用医技科室录入项目数据更新
	*/
	public abstract MpOrPrDepItmDO[] update(MpOrPrDepItmDO[] aggdos) throws BizException;
	
	/**
	*  通用医技科室录入项目数据逻辑删除
	*/
	public abstract void logicDelete(MpOrPrDepItmDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MpOrPrDepItmDO[] enableWithoutFilter(MpOrPrDepItmDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MpOrPrDepItmDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MpOrPrDepItmDO[] disableVOWithoutFilter(MpOrPrDepItmDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MpOrPrDepItmDO[] dos) throws BizException ;
}
