package iih.nmr.nm.bch.disnurguid.i;

import xap.mw.core.data.BizException;
import iih.nmr.nm.bch.disnurguid.d.DisNurGuidDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 出院护理指导记录单数据维护服务
*/
public interface IDisnurguidCudService {
	/**
	*  出院护理指导记录单数据真删除
	*/
    public abstract void delete(DisNurGuidDO[] aggdos) throws BizException;
    
    /**
	*  出院护理指导记录单数据插入保存
	*/
	public abstract DisNurGuidDO[] insert(DisNurGuidDO[] aggdos) throws BizException;
	
    /**
	*  出院护理指导记录单数据保存
	*/
	public abstract DisNurGuidDO[] save(DisNurGuidDO[] aggdos) throws BizException;
	
    /**
	*  出院护理指导记录单数据更新
	*/
	public abstract DisNurGuidDO[] update(DisNurGuidDO[] aggdos) throws BizException;
	
	/**
	*  出院护理指导记录单数据逻辑删除
	*/
	public abstract void logicDelete(DisNurGuidDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DisNurGuidDO[] enableWithoutFilter(DisNurGuidDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DisNurGuidDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DisNurGuidDO[] disableVOWithoutFilter(DisNurGuidDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DisNurGuidDO[] dos) throws BizException ;
}
