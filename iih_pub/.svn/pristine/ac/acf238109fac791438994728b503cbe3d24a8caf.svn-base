package iih.pe.pqn.pediabmodel.i;

import xap.mw.core.data.BizException;
import iih.pe.pqn.pediabmodel.d.PeDiabModelWaistDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 健康评估模型_糖尿病数据维护服务
*/
public interface IPeDiabModelWaistDOCudService {
	/**
	*  健康评估模型_糖尿病数据真删除
	*/
    public abstract void delete(PeDiabModelWaistDO[] aggdos) throws BizException;
    
    /**
	*  健康评估模型_糖尿病数据插入保存
	*/
	public abstract PeDiabModelWaistDO[] insert(PeDiabModelWaistDO[] aggdos) throws BizException;
	
    /**
	*  健康评估模型_糖尿病数据保存
	*/
	public abstract PeDiabModelWaistDO[] save(PeDiabModelWaistDO[] aggdos) throws BizException;
	
    /**
	*  健康评估模型_糖尿病数据更新
	*/
	public abstract PeDiabModelWaistDO[] update(PeDiabModelWaistDO[] aggdos) throws BizException;
	
	/**
	*  健康评估模型_糖尿病数据逻辑删除
	*/
	public abstract void logicDelete(PeDiabModelWaistDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeDiabModelWaistDO[] enableWithoutFilter(PeDiabModelWaistDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeDiabModelWaistDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeDiabModelWaistDO[] disableVOWithoutFilter(PeDiabModelWaistDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeDiabModelWaistDO[] aggdos) throws BizException ;
	
}
