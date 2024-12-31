package iih.ci.mr.nu.ipobstetricnur.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.ipobstetricnur.d.IpobstetricnurinfoDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 产科住院患者护理记录单数据维护服务
*/
public interface IIpobstetricnurMDOCudService {
	/**
	*  产科住院患者护理记录单数据真删除
	*/
    public abstract void delete(IpobstetricnurinfoDO[] aggdos) throws BizException;
    
    /**
	*  产科住院患者护理记录单数据插入保存
	*/
	public abstract IpobstetricnurinfoDO[] insert(IpobstetricnurinfoDO[] aggdos) throws BizException;
	
    /**
	*  产科住院患者护理记录单数据保存
	*/
	public abstract IpobstetricnurinfoDO[] save(IpobstetricnurinfoDO[] aggdos) throws BizException;
	
    /**
	*  产科住院患者护理记录单数据更新
	*/
	public abstract IpobstetricnurinfoDO[] update(IpobstetricnurinfoDO[] aggdos) throws BizException;
	
	/**
	*  产科住院患者护理记录单数据逻辑删除
	*/
	public abstract void logicDelete(IpobstetricnurinfoDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public IpobstetricnurinfoDO[] enableWithoutFilter(IpobstetricnurinfoDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(IpobstetricnurinfoDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public IpobstetricnurinfoDO[] disableVOWithoutFilter(IpobstetricnurinfoDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(IpobstetricnurinfoDO[] aggdos) throws BizException ;
	
}
