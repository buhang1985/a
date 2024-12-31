package iih.pe.pqn.peicdvmodel.i;

import xap.mw.core.data.BizException;
import iih.pe.pqn.peicdvmodel.d.PeIcdvModelBmiDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 健康评估模型_缺血性冠心病数据维护服务
*/
public interface IPeIcdvModelBmiDOCudService {
	/**
	*  健康评估模型_缺血性冠心病数据真删除
	*/
    public abstract void delete(PeIcdvModelBmiDO[] aggdos) throws BizException;
    
    /**
	*  健康评估模型_缺血性冠心病数据插入保存
	*/
	public abstract PeIcdvModelBmiDO[] insert(PeIcdvModelBmiDO[] aggdos) throws BizException;
	
    /**
	*  健康评估模型_缺血性冠心病数据保存
	*/
	public abstract PeIcdvModelBmiDO[] save(PeIcdvModelBmiDO[] aggdos) throws BizException;
	
    /**
	*  健康评估模型_缺血性冠心病数据更新
	*/
	public abstract PeIcdvModelBmiDO[] update(PeIcdvModelBmiDO[] aggdos) throws BizException;
	
	/**
	*  健康评估模型_缺血性冠心病数据逻辑删除
	*/
	public abstract void logicDelete(PeIcdvModelBmiDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeIcdvModelBmiDO[] enableWithoutFilter(PeIcdvModelBmiDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeIcdvModelBmiDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeIcdvModelBmiDO[] disableVOWithoutFilter(PeIcdvModelBmiDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeIcdvModelBmiDO[] aggdos) throws BizException ;
	
}
