package iih.nm.nqm.nmnqmwdkpida.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nmnqmwdkpida.d.NmNqmWdKpidaDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 病区护理指标数据数据维护服务
*/
public interface INmnqmwdkpidaCudService {
	/**
	*  病区护理指标数据数据真删除
	*/
    public abstract void delete(NmNqmWdKpidaDO[] aggdos) throws BizException;
    
    /**
	*  病区护理指标数据数据插入保存
	*/
	public abstract NmNqmWdKpidaDO[] insert(NmNqmWdKpidaDO[] aggdos) throws BizException;
	
    /**
	*  病区护理指标数据数据保存
	*/
	public abstract NmNqmWdKpidaDO[] save(NmNqmWdKpidaDO[] aggdos) throws BizException;
	
    /**
	*  病区护理指标数据数据更新
	*/
	public abstract NmNqmWdKpidaDO[] update(NmNqmWdKpidaDO[] aggdos) throws BizException;
	
	/**
	*  病区护理指标数据数据逻辑删除
	*/
	public abstract void logicDelete(NmNqmWdKpidaDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNqmWdKpidaDO[] enableWithoutFilter(NmNqmWdKpidaDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNqmWdKpidaDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNqmWdKpidaDO[] disableVOWithoutFilter(NmNqmWdKpidaDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNqmWdKpidaDO[] dos) throws BizException ;
}
