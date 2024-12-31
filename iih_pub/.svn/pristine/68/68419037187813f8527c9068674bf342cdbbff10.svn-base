package iih.ems.emcm.upkeep.i;

import xap.mw.core.data.BizException;
import iih.ems.emcm.upkeep.d.EmsUpkeepDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 设备保养记录数据维护服务
*/
public interface IUpkeepCudService {
	/**
	*  设备保养记录数据真删除
	*/
    public abstract void delete(EmsUpkeepDO[] aggdos) throws BizException;
    
    /**
	*  设备保养记录数据插入保存
	*/
	public abstract EmsUpkeepDO[] insert(EmsUpkeepDO[] aggdos) throws BizException;
	
    /**
	*  设备保养记录数据保存
	*/
	public abstract EmsUpkeepDO[] save(EmsUpkeepDO[] aggdos) throws BizException;
	
    /**
	*  设备保养记录数据更新
	*/
	public abstract EmsUpkeepDO[] update(EmsUpkeepDO[] aggdos) throws BizException;
	
	/**
	*  设备保养记录数据逻辑删除
	*/
	public abstract void logicDelete(EmsUpkeepDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EmsUpkeepDO[] enableWithoutFilter(EmsUpkeepDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EmsUpkeepDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EmsUpkeepDO[] disableVOWithoutFilter(EmsUpkeepDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EmsUpkeepDO[] dos) throws BizException ;
}
