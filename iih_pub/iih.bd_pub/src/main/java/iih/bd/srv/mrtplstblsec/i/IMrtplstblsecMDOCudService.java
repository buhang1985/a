package iih.bd.srv.mrtplstblsec.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.mrtplstblsec.d.MrTplSTblSecDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医疗记录模板智能表格段落数据维护服务
*/
public interface IMrtplstblsecMDOCudService {
	/**
	*  医疗记录模板智能表格段落数据删除
	*/
    public abstract void delete(MrTplSTblSecDO[] aggdos) throws BizException;
    
    /**
	*  医疗记录模板智能表格段落数据插入保存
	*/
	public abstract MrTplSTblSecDO[] insert(MrTplSTblSecDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录模板智能表格段落数据保存
	*/
	public abstract MrTplSTblSecDO[] save(MrTplSTblSecDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录模板智能表格段落数据更新
	*/
	public abstract MrTplSTblSecDO[] update(MrTplSTblSecDO[] aggdos) throws BizException;
	
	/**
	*  医疗记录模板智能表格段落数据真删
	*/
	public abstract void logicDelete(MrTplSTblSecDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MrTplSTblSecDO[] enableWithoutFilter(MrTplSTblSecDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MrTplSTblSecDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MrTplSTblSecDO[] disableVOWithoutFilter(MrTplSTblSecDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MrTplSTblSecDO[] aggdos) throws BizException ;
	
}
