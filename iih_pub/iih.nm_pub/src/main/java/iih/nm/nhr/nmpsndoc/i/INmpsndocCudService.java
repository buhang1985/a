package iih.nm.nhr.nmpsndoc.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmpsndoc.d.NmNurDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 护理人员属性数据维护服务
*/
public interface INmpsndocCudService {
	/**
	*  护理人员属性数据真删除
	*/
    public abstract void delete(NmNurDO[] aggdos) throws BizException;
    
    /**
	*  护理人员属性数据插入保存
	*/
	public abstract NmNurDO[] insert(NmNurDO[] aggdos) throws BizException;
	
    /**
	*  护理人员属性数据保存
	*/
	public abstract NmNurDO[] save(NmNurDO[] aggdos) throws BizException;
	
    /**
	*  护理人员属性数据更新
	*/
	public abstract NmNurDO[] update(NmNurDO[] aggdos) throws BizException;
	
	/**
	*  护理人员属性数据逻辑删除
	*/
	public abstract void logicDelete(NmNurDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNurDO[] enableWithoutFilter(NmNurDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNurDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNurDO[] disableVOWithoutFilter(NmNurDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNurDO[] dos) throws BizException ;
}
