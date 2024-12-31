package iih.pe.phm.persticvd.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.persticvd.d.PeRstIcvdDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 健康管理_缺血性冠心病评估结果数据维护服务
*/
public interface IPersticvdMDOCudService {
	/**
	*  健康管理_缺血性冠心病评估结果数据真删除
	*/
    public abstract void delete(PeRstIcvdDO[] aggdos) throws BizException;
    
    /**
	*  健康管理_缺血性冠心病评估结果数据插入保存
	*/
	public abstract PeRstIcvdDO[] insert(PeRstIcvdDO[] aggdos) throws BizException;
	
    /**
	*  健康管理_缺血性冠心病评估结果数据保存
	*/
	public abstract PeRstIcvdDO[] save(PeRstIcvdDO[] aggdos) throws BizException;
	
    /**
	*  健康管理_缺血性冠心病评估结果数据更新
	*/
	public abstract PeRstIcvdDO[] update(PeRstIcvdDO[] aggdos) throws BizException;
	
	/**
	*  健康管理_缺血性冠心病评估结果数据逻辑删除
	*/
	public abstract void logicDelete(PeRstIcvdDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeRstIcvdDO[] enableWithoutFilter(PeRstIcvdDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeRstIcvdDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeRstIcvdDO[] disableVOWithoutFilter(PeRstIcvdDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeRstIcvdDO[] aggdos) throws BizException ;
	
}
