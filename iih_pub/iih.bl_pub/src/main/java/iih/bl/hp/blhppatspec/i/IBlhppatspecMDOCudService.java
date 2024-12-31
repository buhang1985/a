package iih.bl.hp.blhppatspec.i;

import xap.mw.core.data.BizException;
import iih.bl.hp.blhppatspec.d.BlHpPatSpecDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医保特殊病患者数据维护服务
*/
public interface IBlhppatspecMDOCudService {
	/**
	*  医保特殊病患者数据真删除
	*/
    public abstract void delete(BlHpPatSpecDO[] aggdos) throws BizException;
    
    /**
	*  医保特殊病患者数据插入保存
	*/
	public abstract BlHpPatSpecDO[] insert(BlHpPatSpecDO[] aggdos) throws BizException;
	
    /**
	*  医保特殊病患者数据保存
	*/
	public abstract BlHpPatSpecDO[] save(BlHpPatSpecDO[] aggdos) throws BizException;
	
    /**
	*  医保特殊病患者数据更新
	*/
	public abstract BlHpPatSpecDO[] update(BlHpPatSpecDO[] aggdos) throws BizException;
	
	/**
	*  医保特殊病患者数据逻辑删除
	*/
	public abstract void logicDelete(BlHpPatSpecDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlHpPatSpecDO[] enableWithoutFilter(BlHpPatSpecDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlHpPatSpecDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlHpPatSpecDO[] disableVOWithoutFilter(BlHpPatSpecDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlHpPatSpecDO[] aggdos) throws BizException ;
	
}
