package iih.pe.pqn.pediabmodel.i;

import xap.mw.core.data.BizException;
import iih.pe.pqn.pediabmodel.d.PeDiabModelSexDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 健康评估模型_糖尿病数据维护服务
*/
public interface IPeDiabModelSexDOCudService {
	/**
	*  健康评估模型_糖尿病数据真删除
	*/
    public abstract void delete(PeDiabModelSexDO[] aggdos) throws BizException;
    
    /**
	*  健康评估模型_糖尿病数据插入保存
	*/
	public abstract PeDiabModelSexDO[] insert(PeDiabModelSexDO[] aggdos) throws BizException;
	
    /**
	*  健康评估模型_糖尿病数据保存
	*/
	public abstract PeDiabModelSexDO[] save(PeDiabModelSexDO[] aggdos) throws BizException;
	
    /**
	*  健康评估模型_糖尿病数据更新
	*/
	public abstract PeDiabModelSexDO[] update(PeDiabModelSexDO[] aggdos) throws BizException;
	
	/**
	*  健康评估模型_糖尿病数据逻辑删除
	*/
	public abstract void logicDelete(PeDiabModelSexDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeDiabModelSexDO[] enableWithoutFilter(PeDiabModelSexDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeDiabModelSexDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeDiabModelSexDO[] disableVOWithoutFilter(PeDiabModelSexDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeDiabModelSexDO[] aggdos) throws BizException ;
	
}
