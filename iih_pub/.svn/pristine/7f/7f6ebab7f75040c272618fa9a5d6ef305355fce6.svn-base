package iih.pis.ivx.pisivxecard.i;

import xap.mw.core.data.BizException;
import iih.pis.ivx.pisivxecard.d.PisivxEcardDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 微信服务-电子就诊卡数据维护服务
*/
public interface IPisivxecardCudService {
	/**
	*  微信服务-电子就诊卡数据真删除
	*/
    public abstract void delete(PisivxEcardDO[] aggdos) throws BizException;
    
    /**
	*  微信服务-电子就诊卡数据插入保存
	*/
	public abstract PisivxEcardDO[] insert(PisivxEcardDO[] aggdos) throws BizException;
	
    /**
	*  微信服务-电子就诊卡数据保存
	*/
	public abstract PisivxEcardDO[] save(PisivxEcardDO[] aggdos) throws BizException;
	
    /**
	*  微信服务-电子就诊卡数据更新
	*/
	public abstract PisivxEcardDO[] update(PisivxEcardDO[] aggdos) throws BizException;
	
	/**
	*  微信服务-电子就诊卡数据逻辑删除
	*/
	public abstract void logicDelete(PisivxEcardDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PisivxEcardDO[] enableWithoutFilter(PisivxEcardDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PisivxEcardDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PisivxEcardDO[] disableVOWithoutFilter(PisivxEcardDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PisivxEcardDO[] dos) throws BizException ;
}
