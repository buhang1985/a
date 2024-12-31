package iih.bl.hp.blhppatpoor.i;

import xap.mw.core.data.BizException;
import iih.bl.hp.blhppatpoor.d.BlHpPatPoorDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保贫困患者库数据维护服务
*/
public interface IBlhppatpoordoCudService {
	/**
	*  医保贫困患者库数据真删除
	*/
    public abstract void delete(BlHpPatPoorDO[] aggdos) throws BizException;
    
    /**
	*  医保贫困患者库数据插入保存
	*/
	public abstract BlHpPatPoorDO[] insert(BlHpPatPoorDO[] aggdos) throws BizException;
	
    /**
	*  医保贫困患者库数据保存
	*/
	public abstract BlHpPatPoorDO[] save(BlHpPatPoorDO[] aggdos) throws BizException;
	
    /**
	*  医保贫困患者库数据更新
	*/
	public abstract BlHpPatPoorDO[] update(BlHpPatPoorDO[] aggdos) throws BizException;
	
	/**
	*  医保贫困患者库数据逻辑删除
	*/
	public abstract void logicDelete(BlHpPatPoorDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlHpPatPoorDO[] enableWithoutFilter(BlHpPatPoorDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlHpPatPoorDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlHpPatPoorDO[] disableVOWithoutFilter(BlHpPatPoorDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlHpPatPoorDO[] dos) throws BizException ;
}
