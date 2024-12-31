package iih.pi.dic.phyind.i;

import xap.mw.core.data.BizException;
import iih.pi.dic.phyind.d.PiPatPhyIndOptDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 患者生理指标数据维护服务
*/
public interface IPiPatPhyIndOptDOCudService {
	/**
	*  患者生理指标数据真删除
	*/
    public abstract void delete(PiPatPhyIndOptDO[] aggdos) throws BizException;
    
    /**
	*  患者生理指标数据插入保存
	*/
	public abstract PiPatPhyIndOptDO[] insert(PiPatPhyIndOptDO[] aggdos) throws BizException;
	
    /**
	*  患者生理指标数据保存
	*/
	public abstract PiPatPhyIndOptDO[] save(PiPatPhyIndOptDO[] aggdos) throws BizException;
	
    /**
	*  患者生理指标数据更新
	*/
	public abstract PiPatPhyIndOptDO[] update(PiPatPhyIndOptDO[] aggdos) throws BizException;
	
	/**
	*  患者生理指标数据逻辑删除
	*/
	public abstract void logicDelete(PiPatPhyIndOptDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PiPatPhyIndOptDO[] enableWithoutFilter(PiPatPhyIndOptDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PiPatPhyIndOptDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PiPatPhyIndOptDO[] disableVOWithoutFilter(PiPatPhyIndOptDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PiPatPhyIndOptDO[] aggdos) throws BizException ;
	
}
