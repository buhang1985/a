package iih.mi.biz.miregop.i;

import xap.mw.core.data.BizException;
import iih.mi.biz.miregop.d.MiRegOpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 门诊医保就诊登记信息数据维护服务
*/
public interface IMiregopCudService {
	/**
	*  门诊医保就诊登记信息数据真删除
	*/
    public abstract void delete(MiRegOpDO[] aggdos) throws BizException;
    
    /**
	*  门诊医保就诊登记信息数据插入保存
	*/
	public abstract MiRegOpDO[] insert(MiRegOpDO[] aggdos) throws BizException;
	
    /**
	*  门诊医保就诊登记信息数据保存
	*/
	public abstract MiRegOpDO[] save(MiRegOpDO[] aggdos) throws BizException;
	
    /**
	*  门诊医保就诊登记信息数据更新
	*/
	public abstract MiRegOpDO[] update(MiRegOpDO[] aggdos) throws BizException;
	
	/**
	*  门诊医保就诊登记信息数据逻辑删除
	*/
	public abstract void logicDelete(MiRegOpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MiRegOpDO[] enableWithoutFilter(MiRegOpDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MiRegOpDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MiRegOpDO[] disableVOWithoutFilter(MiRegOpDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MiRegOpDO[] dos) throws BizException ;
}
