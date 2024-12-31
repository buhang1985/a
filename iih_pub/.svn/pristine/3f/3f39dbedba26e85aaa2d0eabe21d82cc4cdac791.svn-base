package iih.nm.nqm.nmnqmovkpiipv.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nmnqmovkpiipv.d.NqmovkpiipvDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 护理管理_病区超限指标改进数据维护服务
*/
public interface INmnqmovkpiipvCudService {
	/**
	*  护理管理_病区超限指标改进数据真删除
	*/
    public abstract void delete(NqmovkpiipvDO[] aggdos) throws BizException;
    
    /**
	*  护理管理_病区超限指标改进数据插入保存
	*/
	public abstract NqmovkpiipvDO[] insert(NqmovkpiipvDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_病区超限指标改进数据保存
	*/
	public abstract NqmovkpiipvDO[] save(NqmovkpiipvDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_病区超限指标改进数据更新
	*/
	public abstract NqmovkpiipvDO[] update(NqmovkpiipvDO[] aggdos) throws BizException;
	
	/**
	*  护理管理_病区超限指标改进数据逻辑删除
	*/
	public abstract void logicDelete(NqmovkpiipvDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NqmovkpiipvDO[] enableWithoutFilter(NqmovkpiipvDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NqmovkpiipvDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NqmovkpiipvDO[] disableVOWithoutFilter(NqmovkpiipvDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NqmovkpiipvDO[] dos) throws BizException ;
}
