package iih.nmr.ha.tcho.bgm.i;

import xap.mw.core.data.BizException;
import iih.nmr.ha.tcho.bgm.d.TchoBgmPatInfoDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 血糖监测表数据维护服务
*/
public interface IBgmMDOCudService {
	/**
	*  血糖监测表数据真删除
	*/
    public abstract void delete(TchoBgmPatInfoDO[] aggdos) throws BizException;
    
    /**
	*  血糖监测表数据插入保存
	*/
	public abstract TchoBgmPatInfoDO[] insert(TchoBgmPatInfoDO[] aggdos) throws BizException;
	
    /**
	*  血糖监测表数据保存
	*/
	public abstract TchoBgmPatInfoDO[] save(TchoBgmPatInfoDO[] aggdos) throws BizException;
	
    /**
	*  血糖监测表数据更新
	*/
	public abstract TchoBgmPatInfoDO[] update(TchoBgmPatInfoDO[] aggdos) throws BizException;
	
	/**
	*  血糖监测表数据逻辑删除
	*/
	public abstract void logicDelete(TchoBgmPatInfoDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public TchoBgmPatInfoDO[] enableWithoutFilter(TchoBgmPatInfoDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(TchoBgmPatInfoDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public TchoBgmPatInfoDO[] disableVOWithoutFilter(TchoBgmPatInfoDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(TchoBgmPatInfoDO[] aggdos) throws BizException ;
	
}
