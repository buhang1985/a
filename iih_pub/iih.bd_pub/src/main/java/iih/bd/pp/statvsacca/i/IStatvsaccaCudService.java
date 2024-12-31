package iih.bd.pp.statvsacca.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.statvsacca.d.StatVsaCcaDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 自定义统计分类与核算科目对照数据维护服务
*/
public interface IStatvsaccaCudService {
	/**
	*  自定义统计分类与核算科目对照数据真删除
	*/
    public abstract void delete(StatVsaCcaDO[] aggdos) throws BizException;
    
    /**
	*  自定义统计分类与核算科目对照数据插入保存
	*/
	public abstract StatVsaCcaDO[] insert(StatVsaCcaDO[] aggdos) throws BizException;
	
    /**
	*  自定义统计分类与核算科目对照数据保存
	*/
	public abstract StatVsaCcaDO[] save(StatVsaCcaDO[] aggdos) throws BizException;
	
    /**
	*  自定义统计分类与核算科目对照数据更新
	*/
	public abstract StatVsaCcaDO[] update(StatVsaCcaDO[] aggdos) throws BizException;
	
	/**
	*  自定义统计分类与核算科目对照数据逻辑删除
	*/
	public abstract void logicDelete(StatVsaCcaDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public StatVsaCcaDO[] enableWithoutFilter(StatVsaCcaDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(StatVsaCcaDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public StatVsaCcaDO[] disableVOWithoutFilter(StatVsaCcaDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(StatVsaCcaDO[] dos) throws BizException ;
}
