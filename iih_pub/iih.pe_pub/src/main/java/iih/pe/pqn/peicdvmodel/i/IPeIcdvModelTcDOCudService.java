package iih.pe.pqn.peicdvmodel.i;

import xap.mw.core.data.BizException;
import iih.pe.pqn.peicdvmodel.d.PeIcdvModelTcDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 健康评估模型_缺血性冠心病数据维护服务
*/
public interface IPeIcdvModelTcDOCudService {
	/**
	*  健康评估模型_缺血性冠心病数据真删除
	*/
    public abstract void delete(PeIcdvModelTcDO[] aggdos) throws BizException;
    
    /**
	*  健康评估模型_缺血性冠心病数据插入保存
	*/
	public abstract PeIcdvModelTcDO[] insert(PeIcdvModelTcDO[] aggdos) throws BizException;
	
    /**
	*  健康评估模型_缺血性冠心病数据保存
	*/
	public abstract PeIcdvModelTcDO[] save(PeIcdvModelTcDO[] aggdos) throws BizException;
	
    /**
	*  健康评估模型_缺血性冠心病数据更新
	*/
	public abstract PeIcdvModelTcDO[] update(PeIcdvModelTcDO[] aggdos) throws BizException;
	
	/**
	*  健康评估模型_缺血性冠心病数据逻辑删除
	*/
	public abstract void logicDelete(PeIcdvModelTcDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeIcdvModelTcDO[] enableWithoutFilter(PeIcdvModelTcDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeIcdvModelTcDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeIcdvModelTcDO[] disableVOWithoutFilter(PeIcdvModelTcDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeIcdvModelTcDO[] aggdos) throws BizException ;
	
}
