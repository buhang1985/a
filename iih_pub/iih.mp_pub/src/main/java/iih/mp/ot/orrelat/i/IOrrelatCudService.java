package iih.mp.ot.orrelat.i;

import xap.mw.core.data.BizException;
import iih.mp.ot.orrelat.d.MpOtOrRelatDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医技补费医嘱关系数据维护服务
*/
public interface IOrrelatCudService {
	/**
	*  医技补费医嘱关系数据真删除
	*/
    public abstract void delete(MpOtOrRelatDO[] aggdos) throws BizException;
    
    /**
	*  医技补费医嘱关系数据插入保存
	*/
	public abstract MpOtOrRelatDO[] insert(MpOtOrRelatDO[] aggdos) throws BizException;
	
    /**
	*  医技补费医嘱关系数据保存
	*/
	public abstract MpOtOrRelatDO[] save(MpOtOrRelatDO[] aggdos) throws BizException;
	
    /**
	*  医技补费医嘱关系数据更新
	*/
	public abstract MpOtOrRelatDO[] update(MpOtOrRelatDO[] aggdos) throws BizException;
	
	/**
	*  医技补费医嘱关系数据逻辑删除
	*/
	public abstract void logicDelete(MpOtOrRelatDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MpOtOrRelatDO[] enableWithoutFilter(MpOtOrRelatDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MpOtOrRelatDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MpOtOrRelatDO[] disableVOWithoutFilter(MpOtOrRelatDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MpOtOrRelatDO[] dos) throws BizException ;
}
