package iih.ci.mrm.cimrfpothertcatado.i;

import xap.mw.core.data.BizException;
import iih.ci.mrm.cimrfpothertcatado.d.CiMrFpOthertCataDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 病案编目附页数据维护服务
*/
public interface ICimrfpothertcatadoCudService {
	/**
	*  病案编目附页数据真删除
	*/
    public abstract void delete(CiMrFpOthertCataDO[] aggdos) throws BizException;
    
    /**
	*  病案编目附页数据插入保存
	*/
	public abstract CiMrFpOthertCataDO[] insert(CiMrFpOthertCataDO[] aggdos) throws BizException;
	
    /**
	*  病案编目附页数据保存
	*/
	public abstract CiMrFpOthertCataDO[] save(CiMrFpOthertCataDO[] aggdos) throws BizException;
	
    /**
	*  病案编目附页数据更新
	*/
	public abstract CiMrFpOthertCataDO[] update(CiMrFpOthertCataDO[] aggdos) throws BizException;
	
	/**
	*  病案编目附页数据逻辑删除
	*/
	public abstract void logicDelete(CiMrFpOthertCataDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiMrFpOthertCataDO[] enableWithoutFilter(CiMrFpOthertCataDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiMrFpOthertCataDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiMrFpOthertCataDO[] disableVOWithoutFilter(CiMrFpOthertCataDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiMrFpOthertCataDO[] dos) throws BizException ;
}
