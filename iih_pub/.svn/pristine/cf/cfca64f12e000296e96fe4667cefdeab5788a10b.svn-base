package iih.sc.scbd.log.i;

import xap.mw.core.data.BizException;
import iih.sc.scbd.log.d.ScLogSettingDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 日志设置数据维护服务
*/
public interface ISclogsettingCudService {
	/**
	*  日志设置数据真删除
	*/
    public abstract void delete(ScLogSettingDO[] aggdos) throws BizException;
    
    /**
	*  日志设置数据插入保存
	*/
	public abstract ScLogSettingDO[] insert(ScLogSettingDO[] aggdos) throws BizException;
	
    /**
	*  日志设置数据保存
	*/
	public abstract ScLogSettingDO[] save(ScLogSettingDO[] aggdos) throws BizException;
	
    /**
	*  日志设置数据更新
	*/
	public abstract ScLogSettingDO[] update(ScLogSettingDO[] aggdos) throws BizException;
	
	/**
	*  日志设置数据逻辑删除
	*/
	public abstract void logicDelete(ScLogSettingDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ScLogSettingDO[] enableWithoutFilter(ScLogSettingDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ScLogSettingDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ScLogSettingDO[] disableVOWithoutFilter(ScLogSettingDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ScLogSettingDO[] dos) throws BizException ;
}
