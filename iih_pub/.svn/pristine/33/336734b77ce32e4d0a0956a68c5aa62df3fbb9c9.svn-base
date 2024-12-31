package iih.ci.ord.ap.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.ap.d.CiApSpecAntiRecordDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 特殊级抗菌药物临床应用记录表数据维护服务
*/
public interface ICiapspecantirecordCudService {
	/**
	*  特殊级抗菌药物临床应用记录表数据真删除
	*/
    public abstract void delete(CiApSpecAntiRecordDO[] aggdos) throws BizException;
    
    /**
	*  特殊级抗菌药物临床应用记录表数据插入保存
	*/
	public abstract CiApSpecAntiRecordDO[] insert(CiApSpecAntiRecordDO[] aggdos) throws BizException;
	
    /**
	*  特殊级抗菌药物临床应用记录表数据保存
	*/
	public abstract CiApSpecAntiRecordDO[] save(CiApSpecAntiRecordDO[] aggdos) throws BizException;
	
    /**
	*  特殊级抗菌药物临床应用记录表数据更新
	*/
	public abstract CiApSpecAntiRecordDO[] update(CiApSpecAntiRecordDO[] aggdos) throws BizException;
	
	/**
	*  特殊级抗菌药物临床应用记录表数据逻辑删除
	*/
	public abstract void logicDelete(CiApSpecAntiRecordDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiApSpecAntiRecordDO[] enableWithoutFilter(CiApSpecAntiRecordDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiApSpecAntiRecordDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiApSpecAntiRecordDO[] disableVOWithoutFilter(CiApSpecAntiRecordDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiApSpecAntiRecordDO[] dos) throws BizException ;
	/**
	*  特殊级抗菌药物临床应用记录表数据真删除
	*/
    public abstract void deleteByIdOrs(String[] id_ors) throws BizException;
}
