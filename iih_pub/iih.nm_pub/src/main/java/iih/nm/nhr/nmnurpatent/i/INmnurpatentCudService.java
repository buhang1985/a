package iih.nm.nhr.nmnurpatent.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmnurpatent.d.NmNurPatentDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 护理管理_专利登记数据维护服务
*/
public interface INmnurpatentCudService {
	/**
	*  护理管理_专利登记数据真删除
	*/
    public abstract void delete(NmNurPatentDO[] aggdos) throws BizException;
    
    /**
	*  护理管理_专利登记数据插入保存
	*/
	public abstract NmNurPatentDO[] insert(NmNurPatentDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_专利登记数据保存
	*/
	public abstract NmNurPatentDO[] save(NmNurPatentDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_专利登记数据更新
	*/
	public abstract NmNurPatentDO[] update(NmNurPatentDO[] aggdos) throws BizException;
	
	/**
	*  护理管理_专利登记数据逻辑删除
	*/
	public abstract void logicDelete(NmNurPatentDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNurPatentDO[] enableWithoutFilter(NmNurPatentDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNurPatentDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNurPatentDO[] disableVOWithoutFilter(NmNurPatentDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNurPatentDO[] dos) throws BizException ;
}
