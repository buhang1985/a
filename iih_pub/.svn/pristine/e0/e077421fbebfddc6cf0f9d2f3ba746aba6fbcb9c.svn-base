package iih.ems.einv.embl.i;

import xap.mw.core.data.BizException;
import iih.ems.einv.embl.d.EmsBlDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 设备库存数据维护服务
*/
public interface IEmblCudService {
	/**
	*  设备库存数据真删除
	*/
    public abstract void delete(EmsBlDO[] aggdos) throws BizException;
    
    /**
	*  设备库存数据插入保存
	*/
	public abstract EmsBlDO[] insert(EmsBlDO[] aggdos) throws BizException;
	
    /**
	*  设备库存数据保存
	*/
	public abstract EmsBlDO[] save(EmsBlDO[] aggdos) throws BizException;
	
    /**
	*  设备库存数据更新
	*/
	public abstract EmsBlDO[] update(EmsBlDO[] aggdos) throws BizException;
	
	/**
	*  设备库存数据逻辑删除
	*/
	public abstract void logicDelete(EmsBlDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EmsBlDO[] enableWithoutFilter(EmsBlDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EmsBlDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EmsBlDO[] disableVOWithoutFilter(EmsBlDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EmsBlDO[] dos) throws BizException ;
}
