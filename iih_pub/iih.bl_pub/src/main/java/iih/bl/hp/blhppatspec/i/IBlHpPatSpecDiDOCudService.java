package iih.bl.hp.blhppatspec.i;

import xap.mw.core.data.BizException;
import iih.bl.hp.blhppatspec.d.BlHpPatSpecDiDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医保特殊病患者数据维护服务
*/
public interface IBlHpPatSpecDiDOCudService {
	/**
	*  医保特殊病患者数据真删除
	*/
    public abstract void delete(BlHpPatSpecDiDO[] aggdos) throws BizException;
    
    /**
	*  医保特殊病患者数据插入保存
	*/
	public abstract BlHpPatSpecDiDO[] insert(BlHpPatSpecDiDO[] aggdos) throws BizException;
	
    /**
	*  医保特殊病患者数据保存
	*/
	public abstract BlHpPatSpecDiDO[] save(BlHpPatSpecDiDO[] aggdos) throws BizException;
	
    /**
	*  医保特殊病患者数据更新
	*/
	public abstract BlHpPatSpecDiDO[] update(BlHpPatSpecDiDO[] aggdos) throws BizException;
	
	/**
	*  医保特殊病患者数据逻辑删除
	*/
	public abstract void logicDelete(BlHpPatSpecDiDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlHpPatSpecDiDO[] enableWithoutFilter(BlHpPatSpecDiDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlHpPatSpecDiDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlHpPatSpecDiDO[] disableVOWithoutFilter(BlHpPatSpecDiDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlHpPatSpecDiDO[] aggdos) throws BizException ;
	
}
