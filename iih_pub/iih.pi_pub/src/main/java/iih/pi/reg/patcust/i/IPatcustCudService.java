package iih.pi.reg.patcust.i;

import xap.mw.core.data.BizException;
import iih.pi.reg.patcust.d.PiPatCustDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 团体患者关系数据维护服务
*/
public interface IPatcustCudService {
	/**
	*  团体患者关系数据真删除
	*/
    public abstract void delete(PiPatCustDO[] aggdos) throws BizException;
    
    /**
	*  团体患者关系数据插入保存
	*/
	public abstract PiPatCustDO[] insert(PiPatCustDO[] aggdos) throws BizException;
	
    /**
	*  团体患者关系数据保存
	*/
	public abstract PiPatCustDO[] save(PiPatCustDO[] aggdos) throws BizException;
	
    /**
	*  团体患者关系数据更新
	*/
	public abstract PiPatCustDO[] update(PiPatCustDO[] aggdos) throws BizException;
	
	/**
	*  团体患者关系数据逻辑删除
	*/
	public abstract void logicDelete(PiPatCustDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PiPatCustDO[] enableWithoutFilter(PiPatCustDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PiPatCustDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PiPatCustDO[] disableVOWithoutFilter(PiPatCustDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PiPatCustDO[] dos) throws BizException ;
}
