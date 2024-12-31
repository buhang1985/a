package iih.sc.scbd.screleaserule.i;

import xap.mw.core.data.BizException;
import iih.sc.scbd.screleaserule.d.ScReleaseRuleDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 排班释放规则数据维护服务
*/
public interface IScreleaseruleMDOCudService {
	/**
	*  排班释放规则数据真删除
	*/
    public abstract void delete(ScReleaseRuleDO[] aggdos) throws BizException;
    
    /**
	*  排班释放规则数据插入保存
	*/
	public abstract ScReleaseRuleDO[] insert(ScReleaseRuleDO[] aggdos) throws BizException;
	
    /**
	*  排班释放规则数据保存
	*/
	public abstract ScReleaseRuleDO[] save(ScReleaseRuleDO[] aggdos) throws BizException;
	
    /**
	*  排班释放规则数据更新
	*/
	public abstract ScReleaseRuleDO[] update(ScReleaseRuleDO[] aggdos) throws BizException;
	
	/**
	*  排班释放规则数据逻辑删除
	*/
	public abstract void logicDelete(ScReleaseRuleDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ScReleaseRuleDO[] enableWithoutFilter(ScReleaseRuleDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ScReleaseRuleDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ScReleaseRuleDO[] disableVOWithoutFilter(ScReleaseRuleDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ScReleaseRuleDO[] aggdos) throws BizException ;
	
}