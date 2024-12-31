package iih.nm.nit.nmnitgrppl.i;

import xap.mw.core.data.BizException;
import iih.nm.nit.nmnitgrppl.d.NmNitGrpPlDepDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 护理管理_实习小组_计划数据维护服务
*/
public interface INmNitGrpPlDepDOCudService {
	/**
	*  护理管理_实习小组_计划数据真删除
	*/
    public abstract void delete(NmNitGrpPlDepDO[] aggdos) throws BizException;
    
    /**
	*  护理管理_实习小组_计划数据插入保存
	*/
	public abstract NmNitGrpPlDepDO[] insert(NmNitGrpPlDepDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_实习小组_计划数据保存
	*/
	public abstract NmNitGrpPlDepDO[] save(NmNitGrpPlDepDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_实习小组_计划数据更新
	*/
	public abstract NmNitGrpPlDepDO[] update(NmNitGrpPlDepDO[] aggdos) throws BizException;
	
	/**
	*  护理管理_实习小组_计划数据逻辑删除
	*/
	public abstract void logicDelete(NmNitGrpPlDepDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNitGrpPlDepDO[] enableWithoutFilter(NmNitGrpPlDepDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNitGrpPlDepDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNitGrpPlDepDO[] disableVOWithoutFilter(NmNitGrpPlDepDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNitGrpPlDepDO[] aggdos) throws BizException ;
	
}
