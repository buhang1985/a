package iih.ci.mrm.cimrcataveruledo.i;

import xap.mw.core.data.BizException;
import iih.ci.mrm.cimrcataveruledo.d.CiMrCataVeruleDo;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 编目核查规则数据维护服务
*/
public interface ICimrcataveruledoCudService {
	/**
	*  编目核查规则数据真删除
	*/
    public abstract void delete(CiMrCataVeruleDo[] aggdos) throws BizException;
    
    /**
	*  编目核查规则数据插入保存
	*/
	public abstract CiMrCataVeruleDo[] insert(CiMrCataVeruleDo[] aggdos) throws BizException;
	
    /**
	*  编目核查规则数据保存
	*/
	public abstract CiMrCataVeruleDo[] save(CiMrCataVeruleDo[] aggdos) throws BizException;
	
    /**
	*  编目核查规则数据更新
	*/
	public abstract CiMrCataVeruleDo[] update(CiMrCataVeruleDo[] aggdos) throws BizException;
	
	/**
	*  编目核查规则数据逻辑删除
	*/
	public abstract void logicDelete(CiMrCataVeruleDo[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiMrCataVeruleDo[] enableWithoutFilter(CiMrCataVeruleDo[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiMrCataVeruleDo[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiMrCataVeruleDo[] disableVOWithoutFilter(CiMrCataVeruleDo[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiMrCataVeruleDo[] dos) throws BizException ;
}
