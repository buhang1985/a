package iih.bd.pp.bdpriadm.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.bdpriadm.d.BDPriAdmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 入院登记收费项目配置数据维护服务
*/
public interface IBdpriadmCudService {
	/**
	*  入院登记收费项目配置数据真删除
	*/
    public abstract void delete(BDPriAdmDO[] aggdos) throws BizException;
    
    /**
	*  入院登记收费项目配置数据插入保存
	*/
	public abstract BDPriAdmDO[] insert(BDPriAdmDO[] aggdos) throws BizException;
	
    /**
	*  入院登记收费项目配置数据保存
	*/
	public abstract BDPriAdmDO[] save(BDPriAdmDO[] aggdos) throws BizException;
	
    /**
	*  入院登记收费项目配置数据更新
	*/
	public abstract BDPriAdmDO[] update(BDPriAdmDO[] aggdos) throws BizException;
	
	/**
	*  入院登记收费项目配置数据逻辑删除
	*/
	public abstract void logicDelete(BDPriAdmDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BDPriAdmDO[] enableWithoutFilter(BDPriAdmDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BDPriAdmDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BDPriAdmDO[] disableVOWithoutFilter(BDPriAdmDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BDPriAdmDO[] dos) throws BizException ;
}
