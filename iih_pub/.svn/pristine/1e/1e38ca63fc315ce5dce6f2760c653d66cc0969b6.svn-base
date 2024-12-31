package iih.bd.mm.meterial.i;

import xap.mw.core.data.BizException;
import iih.bd.mm.meterial.d.MMAliasDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医疗物品数据维护服务
*/
public interface IMMAliasDOCudService {
	/**
	*  医疗物品数据真删除
	*/
    public abstract void delete(MMAliasDO[] aggdos) throws BizException;
    
    /**
	*  医疗物品数据插入保存
	*/
	public abstract MMAliasDO[] insert(MMAliasDO[] aggdos) throws BizException;
	
    /**
	*  医疗物品数据保存
	*/
	public abstract MMAliasDO[] save(MMAliasDO[] aggdos) throws BizException;
	
    /**
	*  医疗物品数据更新
	*/
	public abstract MMAliasDO[] update(MMAliasDO[] aggdos) throws BizException;
	
	/**
	*  医疗物品数据逻辑删除
	*/
	public abstract void logicDelete(MMAliasDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MMAliasDO[] enableWithoutFilter(MMAliasDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MMAliasDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MMAliasDO[] disableVOWithoutFilter(MMAliasDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MMAliasDO[] aggdos) throws BizException ;
	
}
