package iih.en.pv.enfee.i;

import xap.mw.core.data.BizException;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.en.pv.enfee.d.EnaccountAggDO;

/**
* 患者就诊_就诊账户数据维护服务
*/
public interface IEnaccountCudService {
	/**
	*  患者就诊_就诊账户数据真删除
	*/
    public abstract void delete(EnaccountAggDO[] aggdos) throws BizException;
    
    /**
	*  患者就诊_就诊账户数据插入保存
	*/
	public abstract EnaccountAggDO[] insert(EnaccountAggDO[] aggdos) throws BizException;
	
    /**
	*  患者就诊_就诊账户数据保存
	*/
	public abstract EnaccountAggDO[] save(EnaccountAggDO[] aggdos) throws BizException;
	
    /**
	*  患者就诊_就诊账户数据更新
	*/
	public abstract EnaccountAggDO[] update(EnaccountAggDO[] aggdos) throws BizException;
	
	/**
	*  患者就诊_就诊账户数据逻辑删除
	*/
	public abstract void logicDelete(EnaccountAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对患者就诊_就诊账户数据真删除
	 */
	public abstract void deleteByParentDO(EnAccountDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对患者就诊_就诊账户数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(EnAccountDO[] mainDos) throws BizException;
}
