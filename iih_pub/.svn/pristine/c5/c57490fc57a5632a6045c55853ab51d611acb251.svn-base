package iih.mi.biz.insureprop.rural.i;

import xap.mw.core.data.BizException;
import iih.mi.biz.insureprop.rural.d.MiHpPropArRuralIpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 新农合医保分摊最终存储数据维护服务
*/
public interface IMihpproparruralipCudService {
	/**
	*  新农合医保分摊最终存储数据真删除
	*/
    public abstract void delete(MiHpPropArRuralIpDO[] aggdos) throws BizException;
    
    /**
	*  新农合医保分摊最终存储数据插入保存
	*/
	public abstract MiHpPropArRuralIpDO[] insert(MiHpPropArRuralIpDO[] aggdos) throws BizException;
	
    /**
	*  新农合医保分摊最终存储数据保存
	*/
	public abstract MiHpPropArRuralIpDO[] save(MiHpPropArRuralIpDO[] aggdos) throws BizException;
	
    /**
	*  新农合医保分摊最终存储数据更新
	*/
	public abstract MiHpPropArRuralIpDO[] update(MiHpPropArRuralIpDO[] aggdos) throws BizException;
	
	/**
	*  新农合医保分摊最终存储数据逻辑删除
	*/
	public abstract void logicDelete(MiHpPropArRuralIpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MiHpPropArRuralIpDO[] enableWithoutFilter(MiHpPropArRuralIpDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MiHpPropArRuralIpDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MiHpPropArRuralIpDO[] disableVOWithoutFilter(MiHpPropArRuralIpDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MiHpPropArRuralIpDO[] dos) throws BizException ;
}
