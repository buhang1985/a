package iih.nm.nhr.nmnurtrn.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmnurtrn.d.NmNurTrnDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 护理管理-人员培训数据维护服务
*/
public interface INmnurtrnCudService {
	/**
	*  护理管理-人员培训数据真删除
	*/
    public abstract void delete(NmNurTrnDO[] aggdos) throws BizException;
    
    /**
	*  护理管理-人员培训数据插入保存
	*/
	public abstract NmNurTrnDO[] insert(NmNurTrnDO[] aggdos) throws BizException;
	
    /**
	*  护理管理-人员培训数据保存
	*/
	public abstract NmNurTrnDO[] save(NmNurTrnDO[] aggdos) throws BizException;
	
    /**
	*  护理管理-人员培训数据更新
	*/
	public abstract NmNurTrnDO[] update(NmNurTrnDO[] aggdos) throws BizException;
	
	/**
	*  护理管理-人员培训数据逻辑删除
	*/
	public abstract void logicDelete(NmNurTrnDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNurTrnDO[] enableWithoutFilter(NmNurTrnDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNurTrnDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNurTrnDO[] disableVOWithoutFilter(NmNurTrnDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNurTrnDO[] dos) throws BizException ;
}
