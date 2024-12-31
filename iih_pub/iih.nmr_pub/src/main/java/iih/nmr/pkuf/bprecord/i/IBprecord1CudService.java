package iih.nmr.pkuf.bprecord.i;

import xap.mw.core.data.BizException;
import iih.nmr.pkuf.bprecord.d.BprecordDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 血压监测记录单数据维护服务
*/
public interface IBprecord1CudService {
	/**
	*  血压监测记录单数据真删除
	*/
    public abstract void delete(BprecordDO[] aggdos) throws BizException;
    
    /**
	*  血压监测记录单数据插入保存
	*/
	public abstract BprecordDO[] insert(BprecordDO[] aggdos) throws BizException;
	
    /**
	*  血压监测记录单数据保存
	*/
	public abstract BprecordDO[] save(BprecordDO[] aggdos) throws BizException;
	
    /**
	*  血压监测记录单数据更新
	*/
	public abstract BprecordDO[] update(BprecordDO[] aggdos) throws BizException;
	
	/**
	*  血压监测记录单数据逻辑删除
	*/
	public abstract void logicDelete(BprecordDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BprecordDO[] enableWithoutFilter(BprecordDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BprecordDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BprecordDO[] disableVOWithoutFilter(BprecordDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BprecordDO[] dos) throws BizException ;
}
