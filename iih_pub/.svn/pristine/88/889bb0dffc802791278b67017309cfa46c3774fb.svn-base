package iih.mc.st.inspection.i;

import xap.mw.core.data.BizException;
import iih.mc.st.inspection.d.McInspectionItemDo;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 高值耗材验收表数据维护服务
*/
public interface IMcInspectionItemDoCudService {
	/**
	*  高值耗材验收表数据真删除
	*/
    public abstract void delete(McInspectionItemDo[] aggdos) throws BizException;
    
    /**
	*  高值耗材验收表数据插入保存
	*/
	public abstract McInspectionItemDo[] insert(McInspectionItemDo[] aggdos) throws BizException;
	
    /**
	*  高值耗材验收表数据保存
	*/
	public abstract McInspectionItemDo[] save(McInspectionItemDo[] aggdos) throws BizException;
	
    /**
	*  高值耗材验收表数据更新
	*/
	public abstract McInspectionItemDo[] update(McInspectionItemDo[] aggdos) throws BizException;
	
	/**
	*  高值耗材验收表数据逻辑删除
	*/
	public abstract void logicDelete(McInspectionItemDo[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public McInspectionItemDo[] enableWithoutFilter(McInspectionItemDo[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(McInspectionItemDo[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public McInspectionItemDo[] disableVOWithoutFilter(McInspectionItemDo[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(McInspectionItemDo[] aggdos) throws BizException ;
	
}
