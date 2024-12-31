package iih.en.pv.inpatient.i;

import xap.mw.core.data.BizException;
import iih.en.pv.inpatient.d.EntPatListDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 就诊患者列表数据维护服务
*/
public interface IEntpatlistCudService {
	/**
	*  就诊患者列表数据真删除
	*/
    public abstract void delete(EntPatListDO[] aggdos) throws BizException;
    
    /**
	*  就诊患者列表数据插入保存
	*/
	public abstract EntPatListDO[] insert(EntPatListDO[] aggdos) throws BizException;
	
    /**
	*  就诊患者列表数据保存
	*/
	public abstract EntPatListDO[] save(EntPatListDO[] aggdos) throws BizException;
	
    /**
	*  就诊患者列表数据更新
	*/
	public abstract EntPatListDO[] update(EntPatListDO[] aggdos) throws BizException;
	
	/**
	*  就诊患者列表数据逻辑删除
	*/
	public abstract void logicDelete(EntPatListDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EntPatListDO[] enableWithoutFilter(EntPatListDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EntPatListDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EntPatListDO[] disableVOWithoutFilter(EntPatListDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EntPatListDO[] dos) throws BizException ;
}
