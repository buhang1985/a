package iih.sc.scbd.scprtcfg.i;

import xap.mw.core.data.BizException;
import iih.sc.scbd.scprtcfg.d.ScPrtCfgDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 打印模板项目配置数据维护服务
*/
public interface IScprtcfgCudService {
	/**
	*  打印模板项目配置数据真删除
	*/
    public abstract void delete(ScPrtCfgDO[] aggdos) throws BizException;
    
    /**
	*  打印模板项目配置数据插入保存
	*/
	public abstract ScPrtCfgDO[] insert(ScPrtCfgDO[] aggdos) throws BizException;
	
    /**
	*  打印模板项目配置数据保存
	*/
	public abstract ScPrtCfgDO[] save(ScPrtCfgDO[] aggdos) throws BizException;
	
    /**
	*  打印模板项目配置数据更新
	*/
	public abstract ScPrtCfgDO[] update(ScPrtCfgDO[] aggdos) throws BizException;
	
	/**
	*  打印模板项目配置数据逻辑删除
	*/
	public abstract void logicDelete(ScPrtCfgDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ScPrtCfgDO[] enableWithoutFilter(ScPrtCfgDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ScPrtCfgDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ScPrtCfgDO[] disableVOWithoutFilter(ScPrtCfgDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ScPrtCfgDO[] dos) throws BizException ;
}
