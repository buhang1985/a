package iih.mp.mpbd.vstrule.i;

import xap.mw.core.data.BizException;
import iih.mp.mpbd.vstrule.d.MpBdVstRuleDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体征模板匹配规则数据维护服务
*/
public interface IVstruleCudService {
	/**
	*  体征模板匹配规则数据真删除
	*/
    public abstract void delete(MpBdVstRuleDO[] aggdos) throws BizException;
    
    /**
	*  体征模板匹配规则数据插入保存
	*/
	public abstract MpBdVstRuleDO[] insert(MpBdVstRuleDO[] aggdos) throws BizException;
	
    /**
	*  体征模板匹配规则数据保存
	*/
	public abstract MpBdVstRuleDO[] save(MpBdVstRuleDO[] aggdos) throws BizException;
	
    /**
	*  体征模板匹配规则数据更新
	*/
	public abstract MpBdVstRuleDO[] update(MpBdVstRuleDO[] aggdos) throws BizException;
	
	/**
	*  体征模板匹配规则数据逻辑删除
	*/
	public abstract void logicDelete(MpBdVstRuleDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MpBdVstRuleDO[] enableWithoutFilter(MpBdVstRuleDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MpBdVstRuleDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MpBdVstRuleDO[] disableVOWithoutFilter(MpBdVstRuleDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MpBdVstRuleDO[] dos) throws BizException ;
}
