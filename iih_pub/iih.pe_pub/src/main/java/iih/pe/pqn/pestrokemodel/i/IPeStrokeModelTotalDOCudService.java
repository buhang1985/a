package iih.pe.pqn.pestrokemodel.i;

import xap.mw.core.data.BizException;
import iih.pe.pqn.pestrokemodel.d.PeStrokeModelTotalDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 健康评估模型_脑卒中数据维护服务
*/
public interface IPeStrokeModelTotalDOCudService {
	/**
	*  健康评估模型_脑卒中数据真删除
	*/
    public abstract void delete(PeStrokeModelTotalDO[] aggdos) throws BizException;
    
    /**
	*  健康评估模型_脑卒中数据插入保存
	*/
	public abstract PeStrokeModelTotalDO[] insert(PeStrokeModelTotalDO[] aggdos) throws BizException;
	
    /**
	*  健康评估模型_脑卒中数据保存
	*/
	public abstract PeStrokeModelTotalDO[] save(PeStrokeModelTotalDO[] aggdos) throws BizException;
	
    /**
	*  健康评估模型_脑卒中数据更新
	*/
	public abstract PeStrokeModelTotalDO[] update(PeStrokeModelTotalDO[] aggdos) throws BizException;
	
	/**
	*  健康评估模型_脑卒中数据逻辑删除
	*/
	public abstract void logicDelete(PeStrokeModelTotalDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeStrokeModelTotalDO[] enableWithoutFilter(PeStrokeModelTotalDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeStrokeModelTotalDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeStrokeModelTotalDO[] disableVOWithoutFilter(PeStrokeModelTotalDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeStrokeModelTotalDO[] aggdos) throws BizException ;
	
}