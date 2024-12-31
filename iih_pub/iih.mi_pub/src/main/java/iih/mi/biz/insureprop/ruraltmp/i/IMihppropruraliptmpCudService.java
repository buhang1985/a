package iih.mi.biz.insureprop.ruraltmp.i;

import xap.mw.core.data.BizException;
import iih.mi.biz.insureprop.ruraltmp.d.MiHpPropRuralIpTmpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保分摊新农合数据维护服务
*/
public interface IMihppropruraliptmpCudService {
	/**
	*  医保分摊新农合数据真删除
	*/
    public abstract void delete(MiHpPropRuralIpTmpDO[] aggdos) throws BizException;
    
    /**
	*  医保分摊新农合数据插入保存
	*/
	public abstract MiHpPropRuralIpTmpDO[] insert(MiHpPropRuralIpTmpDO[] aggdos) throws BizException;
	
    /**
	*  医保分摊新农合数据保存
	*/
	public abstract MiHpPropRuralIpTmpDO[] save(MiHpPropRuralIpTmpDO[] aggdos) throws BizException;
	
    /**
	*  医保分摊新农合数据更新
	*/
	public abstract MiHpPropRuralIpTmpDO[] update(MiHpPropRuralIpTmpDO[] aggdos) throws BizException;
	
	/**
	*  医保分摊新农合数据逻辑删除
	*/
	public abstract void logicDelete(MiHpPropRuralIpTmpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MiHpPropRuralIpTmpDO[] enableWithoutFilter(MiHpPropRuralIpTmpDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MiHpPropRuralIpTmpDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MiHpPropRuralIpTmpDO[] disableVOWithoutFilter(MiHpPropRuralIpTmpDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MiHpPropRuralIpTmpDO[] dos) throws BizException ;
}
