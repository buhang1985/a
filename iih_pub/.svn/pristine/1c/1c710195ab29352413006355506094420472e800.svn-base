package iih.mp.dg.ipshetpauto.i;

import xap.mw.core.data.BizException;
import iih.mp.dg.ipshetpauto.d.IpShetpAutoDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 住院统领单联动生单配置数据维护服务
*/
public interface IIpshetpautoCudService {
	/**
	*  住院统领单联动生单配置数据真删除
	*/
    public abstract void delete(IpShetpAutoDO[] aggdos) throws BizException;
    
    /**
	*  住院统领单联动生单配置数据插入保存
	*/
	public abstract IpShetpAutoDO[] insert(IpShetpAutoDO[] aggdos) throws BizException;
	
    /**
	*  住院统领单联动生单配置数据保存
	*/
	public abstract IpShetpAutoDO[] save(IpShetpAutoDO[] aggdos) throws BizException;
	
    /**
	*  住院统领单联动生单配置数据更新
	*/
	public abstract IpShetpAutoDO[] update(IpShetpAutoDO[] aggdos) throws BizException;
	
	/**
	*  住院统领单联动生单配置数据逻辑删除
	*/
	public abstract void logicDelete(IpShetpAutoDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public IpShetpAutoDO[] enableWithoutFilter(IpShetpAutoDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(IpShetpAutoDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public IpShetpAutoDO[] disableVOWithoutFilter(IpShetpAutoDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(IpShetpAutoDO[] dos) throws BizException ;
}
