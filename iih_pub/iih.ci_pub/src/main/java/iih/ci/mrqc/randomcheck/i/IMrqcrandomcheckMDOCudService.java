package iih.ci.mrqc.randomcheck.i;

import xap.mw.core.data.BizException;
import iih.ci.mrqc.randomcheck.d.CiMrQcRandomRecordDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 门诊病历抽查数据维护服务
*/
public interface IMrqcrandomcheckMDOCudService {
	/**
	*  门诊病历抽查数据真删除
	*/
    public abstract void delete(CiMrQcRandomRecordDO[] aggdos) throws BizException;
    
    /**
	*  门诊病历抽查数据插入保存
	*/
	public abstract CiMrQcRandomRecordDO[] insert(CiMrQcRandomRecordDO[] aggdos) throws BizException;
	
    /**
	*  门诊病历抽查数据保存
	*/
	public abstract CiMrQcRandomRecordDO[] save(CiMrQcRandomRecordDO[] aggdos) throws BizException;
	
    /**
	*  门诊病历抽查数据更新
	*/
	public abstract CiMrQcRandomRecordDO[] update(CiMrQcRandomRecordDO[] aggdos) throws BizException;
	
	/**
	*  门诊病历抽查数据逻辑删除
	*/
	public abstract void logicDelete(CiMrQcRandomRecordDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiMrQcRandomRecordDO[] enableWithoutFilter(CiMrQcRandomRecordDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiMrQcRandomRecordDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiMrQcRandomRecordDO[] disableVOWithoutFilter(CiMrQcRandomRecordDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiMrQcRandomRecordDO[] aggdos) throws BizException ;
	
}
