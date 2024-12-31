package iih.pis.ivx.pisivxaccsetting.i;

import xap.mw.core.data.BizException;
import iih.pis.ivx.pisivxaccsetting.d.PisivxAccSettingDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 微信账户设置数据维护服务
*/
public interface IPisivxaccsettingCudService {
	/**
	*  微信账户设置数据真删除
	*/
    public abstract void delete(PisivxAccSettingDO[] aggdos) throws BizException;
    
    /**
	*  微信账户设置数据插入保存
	*/
	public abstract PisivxAccSettingDO[] insert(PisivxAccSettingDO[] aggdos) throws BizException;
	
    /**
	*  微信账户设置数据保存
	*/
	public abstract PisivxAccSettingDO[] save(PisivxAccSettingDO[] aggdos) throws BizException;
	
    /**
	*  微信账户设置数据更新
	*/
	public abstract PisivxAccSettingDO[] update(PisivxAccSettingDO[] aggdos) throws BizException;
	
	/**
	*  微信账户设置数据逻辑删除
	*/
	public abstract void logicDelete(PisivxAccSettingDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PisivxAccSettingDO[] enableWithoutFilter(PisivxAccSettingDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PisivxAccSettingDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PisivxAccSettingDO[] disableVOWithoutFilter(PisivxAccSettingDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PisivxAccSettingDO[] dos) throws BizException ;
}
