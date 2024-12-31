package iih.pe.pip.peipregquery.i;

import xap.mw.core.data.BizException;
import iih.pe.pip.peipregquery.d.PeIpRegQueryDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 住院体检名单列表查询数据维护服务
*/
public interface IPeipregqueryCudService {
	/**
	*  住院体检名单列表查询数据真删除
	*/
    public abstract void delete(PeIpRegQueryDO[] aggdos) throws BizException;
    
    /**
	*  住院体检名单列表查询数据插入保存
	*/
	public abstract PeIpRegQueryDO[] insert(PeIpRegQueryDO[] aggdos) throws BizException;
	
    /**
	*  住院体检名单列表查询数据保存
	*/
	public abstract PeIpRegQueryDO[] save(PeIpRegQueryDO[] aggdos) throws BizException;
	
    /**
	*  住院体检名单列表查询数据更新
	*/
	public abstract PeIpRegQueryDO[] update(PeIpRegQueryDO[] aggdos) throws BizException;
	
	/**
	*  住院体检名单列表查询数据逻辑删除
	*/
	public abstract void logicDelete(PeIpRegQueryDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeIpRegQueryDO[] enableWithoutFilter(PeIpRegQueryDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeIpRegQueryDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeIpRegQueryDO[] disableVOWithoutFilter(PeIpRegQueryDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeIpRegQueryDO[] dos) throws BizException ;
}
