package iih.pis.ivx.pisivxmember.i;

import xap.mw.core.data.BizException;
import iih.pis.ivx.pisivxmember.d.PisIvxMemberDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 微信服务-就诊人管理数据维护服务
*/
public interface IPisivxmemberCudService {
	/**
	*  微信服务-就诊人管理数据真删除
	*/
    public abstract void delete(PisIvxMemberDO[] aggdos) throws BizException;
    
    /**
	*  微信服务-就诊人管理数据插入保存
	*/
	public abstract PisIvxMemberDO[] insert(PisIvxMemberDO[] aggdos) throws BizException;
	
    /**
	*  微信服务-就诊人管理数据保存
	*/
	public abstract PisIvxMemberDO[] save(PisIvxMemberDO[] aggdos) throws BizException;
	
    /**
	*  微信服务-就诊人管理数据更新
	*/
	public abstract PisIvxMemberDO[] update(PisIvxMemberDO[] aggdos) throws BizException;
	
	/**
	*  微信服务-就诊人管理数据逻辑删除
	*/
	public abstract void logicDelete(PisIvxMemberDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PisIvxMemberDO[] enableWithoutFilter(PisIvxMemberDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PisIvxMemberDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PisIvxMemberDO[] disableVOWithoutFilter(PisIvxMemberDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PisIvxMemberDO[] dos) throws BizException ;
}
