package iih.bd.pp.hpmedkindah.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.hpmedkindah.d.HpMedKindAhDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保计划_医疗类别字典_东软数据维护服务
*/
public interface IHpmedkindahCudService {
	/**
	*  医保计划_医疗类别字典_东软数据真删除
	*/
    public abstract void delete(HpMedKindAhDO[] aggdos) throws BizException;
    
    /**
	*  医保计划_医疗类别字典_东软数据插入保存
	*/
	public abstract HpMedKindAhDO[] insert(HpMedKindAhDO[] aggdos) throws BizException;
	
    /**
	*  医保计划_医疗类别字典_东软数据保存
	*/
	public abstract HpMedKindAhDO[] save(HpMedKindAhDO[] aggdos) throws BizException;
	
    /**
	*  医保计划_医疗类别字典_东软数据更新
	*/
	public abstract HpMedKindAhDO[] update(HpMedKindAhDO[] aggdos) throws BizException;
	
	/**
	*  医保计划_医疗类别字典_东软数据逻辑删除
	*/
	public abstract void logicDelete(HpMedKindAhDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpMedKindAhDO[] enableWithoutFilter(HpMedKindAhDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpMedKindAhDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpMedKindAhDO[] disableVOWithoutFilter(HpMedKindAhDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpMedKindAhDO[] dos) throws BizException ;
}
