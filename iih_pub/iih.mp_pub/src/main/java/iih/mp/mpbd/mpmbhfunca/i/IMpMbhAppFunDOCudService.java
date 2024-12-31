package iih.mp.mpbd.mpmbhfunca.i;

import xap.mw.core.data.BizException;
import iih.mp.mpbd.mpmbhfunca.d.MpMbhAppFunDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 移动医疗功能分类数据维护服务
*/
public interface IMpMbhAppFunDOCudService {
	/**
	*  移动医疗功能分类数据真删除
	*/
    public abstract void delete(MpMbhAppFunDO[] aggdos) throws BizException;
    
    /**
	*  移动医疗功能分类数据插入保存
	*/
	public abstract MpMbhAppFunDO[] insert(MpMbhAppFunDO[] aggdos) throws BizException;
	
    /**
	*  移动医疗功能分类数据保存
	*/
	public abstract MpMbhAppFunDO[] save(MpMbhAppFunDO[] aggdos) throws BizException;
	
    /**
	*  移动医疗功能分类数据更新
	*/
	public abstract MpMbhAppFunDO[] update(MpMbhAppFunDO[] aggdos) throws BizException;
	
	/**
	*  移动医疗功能分类数据逻辑删除
	*/
	public abstract void logicDelete(MpMbhAppFunDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MpMbhAppFunDO[] enableWithoutFilter(MpMbhAppFunDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MpMbhAppFunDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MpMbhAppFunDO[] disableVOWithoutFilter(MpMbhAppFunDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MpMbhAppFunDO[] aggdos) throws BizException ;
	
}