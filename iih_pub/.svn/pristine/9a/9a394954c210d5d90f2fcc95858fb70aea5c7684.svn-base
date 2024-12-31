package iih.nm.nbd.nmnbdadtlvl.i;

import xap.mw.core.data.BizException;
import iih.nm.nbd.nmnbdadtlvl.d.NmNbdAdtLvlDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 审核级别配置数据维护服务
*/
public interface INmnbdadtlvlCudService {
	/**
	*  审核级别配置数据真删除
	*/
    public abstract void delete(NmNbdAdtLvlDO[] aggdos) throws BizException;
    
    /**
	*  审核级别配置数据插入保存
	*/
	public abstract NmNbdAdtLvlDO[] insert(NmNbdAdtLvlDO[] aggdos) throws BizException;
	
    /**
	*  审核级别配置数据保存
	*/
	public abstract NmNbdAdtLvlDO[] save(NmNbdAdtLvlDO[] aggdos) throws BizException;
	
    /**
	*  审核级别配置数据更新
	*/
	public abstract NmNbdAdtLvlDO[] update(NmNbdAdtLvlDO[] aggdos) throws BizException;
	
	/**
	*  审核级别配置数据逻辑删除
	*/
	public abstract void logicDelete(NmNbdAdtLvlDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNbdAdtLvlDO[] enableWithoutFilter(NmNbdAdtLvlDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNbdAdtLvlDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNbdAdtLvlDO[] disableVOWithoutFilter(NmNbdAdtLvlDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNbdAdtLvlDO[] dos) throws BizException ;
}
