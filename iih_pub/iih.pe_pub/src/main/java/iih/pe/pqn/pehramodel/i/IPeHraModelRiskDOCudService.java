package iih.pe.pqn.pehramodel.i;

import xap.mw.core.data.BizException;
import iih.pe.pqn.pehramodel.d.PeHraModelRiskDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检疾病风险评估模型数据维护服务
*/
public interface IPeHraModelRiskDOCudService {
	/**
	*  体检疾病风险评估模型数据真删除
	*/
    public abstract void delete(PeHraModelRiskDO[] aggdos) throws BizException;
    
    /**
	*  体检疾病风险评估模型数据插入保存
	*/
	public abstract PeHraModelRiskDO[] insert(PeHraModelRiskDO[] aggdos) throws BizException;
	
    /**
	*  体检疾病风险评估模型数据保存
	*/
	public abstract PeHraModelRiskDO[] save(PeHraModelRiskDO[] aggdos) throws BizException;
	
    /**
	*  体检疾病风险评估模型数据更新
	*/
	public abstract PeHraModelRiskDO[] update(PeHraModelRiskDO[] aggdos) throws BizException;
	
	/**
	*  体检疾病风险评估模型数据逻辑删除
	*/
	public abstract void logicDelete(PeHraModelRiskDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeHraModelRiskDO[] enableWithoutFilter(PeHraModelRiskDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeHraModelRiskDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeHraModelRiskDO[] disableVOWithoutFilter(PeHraModelRiskDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeHraModelRiskDO[] aggdos) throws BizException ;
	
}
