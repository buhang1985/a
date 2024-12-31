package iih.bd.pp.bdbltpl.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.bdbltpl.d.BdBlTplDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 自定义费用模板数据维护服务
*/
public interface IBdbltplMDOCudService {
	/**
	*  自定义费用模板数据真删除
	*/
    public abstract void delete(BdBlTplDO[] aggdos) throws BizException;
    
    /**
	*  自定义费用模板数据插入保存
	*/
	public abstract BdBlTplDO[] insert(BdBlTplDO[] aggdos) throws BizException;
	
    /**
	*  自定义费用模板数据保存
	*/
	public abstract BdBlTplDO[] save(BdBlTplDO[] aggdos) throws BizException;
	
    /**
	*  自定义费用模板数据更新
	*/
	public abstract BdBlTplDO[] update(BdBlTplDO[] aggdos) throws BizException;
	
	/**
	*  自定义费用模板数据逻辑删除
	*/
	public abstract void logicDelete(BdBlTplDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BdBlTplDO[] enableWithoutFilter(BdBlTplDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BdBlTplDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BdBlTplDO[] disableVOWithoutFilter(BdBlTplDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BdBlTplDO[] aggdos) throws BizException ;
	
}
