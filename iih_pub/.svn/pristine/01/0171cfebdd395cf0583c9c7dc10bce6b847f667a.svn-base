package iih.mp.nr.hdvview.i;

import xap.mw.core.data.BizException;
import iih.mp.nr.hdvview.d.MpHdvSumDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 交班汇总数据维护服务
*/
public interface IMpHdvSumDOCudService {
	/**
	*  交班汇总数据真删除
	*/
    public abstract void delete(MpHdvSumDO[] aggdos) throws BizException;
    
    /**
	*  交班汇总数据插入保存
	*/
	public abstract MpHdvSumDO[] insert(MpHdvSumDO[] aggdos) throws BizException;
	
    /**
	*  交班汇总数据保存
	*/
	public abstract MpHdvSumDO[] save(MpHdvSumDO[] aggdos) throws BizException;
	
    /**
	*  交班汇总数据更新
	*/
	public abstract MpHdvSumDO[] update(MpHdvSumDO[] aggdos) throws BizException;
	
	/**
	*  交班汇总数据逻辑删除
	*/
	public abstract void logicDelete(MpHdvSumDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MpHdvSumDO[] enableWithoutFilter(MpHdvSumDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MpHdvSumDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MpHdvSumDO[] disableVOWithoutFilter(MpHdvSumDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MpHdvSumDO[] aggdos) throws BizException ;
	
}
