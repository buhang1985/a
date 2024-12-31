package iih.nm.nit.nitnuredu.i;

import xap.mw.core.data.BizException;
import iih.nm.nit.nitnuredu.d.NitNurEduDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 教育经历数据维护服务
*/
public interface INitnureduCudService {
	/**
	*  教育经历数据真删除
	*/
    public abstract void delete(NitNurEduDO[] aggdos) throws BizException;
    
    /**
	*  教育经历数据插入保存
	*/
	public abstract NitNurEduDO[] insert(NitNurEduDO[] aggdos) throws BizException;
	
    /**
	*  教育经历数据保存
	*/
	public abstract NitNurEduDO[] save(NitNurEduDO[] aggdos) throws BizException;
	
    /**
	*  教育经历数据更新
	*/
	public abstract NitNurEduDO[] update(NitNurEduDO[] aggdos) throws BizException;
	
	/**
	*  教育经历数据逻辑删除
	*/
	public abstract void logicDelete(NitNurEduDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NitNurEduDO[] enableWithoutFilter(NitNurEduDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NitNurEduDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NitNurEduDO[] disableVOWithoutFilter(NitNurEduDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NitNurEduDO[] dos) throws BizException ;
}
