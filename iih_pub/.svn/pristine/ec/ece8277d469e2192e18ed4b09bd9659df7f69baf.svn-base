package iih.ci.mrqc.cimrrecalladd.i;

import xap.mw.core.data.BizException;
import iih.ci.mrqc.cimrrecalladd.d.CiMrRecallAddDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 病历召回新增数据维护服务
*/
public interface ICimrrecalladdCudService {
	/**
	*  病历召回新增数据真删除
	*/
    public abstract void delete(CiMrRecallAddDO[] aggdos) throws BizException;
    
    /**
	*  病历召回新增数据插入保存
	*/
	public abstract CiMrRecallAddDO[] insert(CiMrRecallAddDO[] aggdos) throws BizException;
	
    /**
	*  病历召回新增数据保存
	*/
	public abstract CiMrRecallAddDO[] save(CiMrRecallAddDO[] aggdos) throws BizException;
	
    /**
	*  病历召回新增数据更新
	*/
	public abstract CiMrRecallAddDO[] update(CiMrRecallAddDO[] aggdos) throws BizException;
	
	/**
	*  病历召回新增数据逻辑删除
	*/
	public abstract void logicDelete(CiMrRecallAddDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiMrRecallAddDO[] enableWithoutFilter(CiMrRecallAddDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiMrRecallAddDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiMrRecallAddDO[] disableVOWithoutFilter(CiMrRecallAddDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiMrRecallAddDO[] dos) throws BizException ;
}
