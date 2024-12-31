package iih.bl.st.blauditip.i;

import xap.mw.core.data.BizException;
import iih.bl.st.blauditip.d.BlAuditIp;
import iih.bl.st.blauditip.d.BlauditipAggDO;

/**
* 住院费用审核数据维护服务
*/
public interface IBlauditipCudService {
	/**
	*  住院费用审核数据真删除
	*/
    public abstract void delete(BlauditipAggDO[] aggdos) throws BizException;
    
    /**
	*  住院费用审核数据插入保存
	*/
	public abstract BlauditipAggDO[] insert(BlauditipAggDO[] aggdos) throws BizException;
	
    /**
	*  住院费用审核数据保存
	*/
	public abstract BlauditipAggDO[] save(BlauditipAggDO[] aggdos) throws BizException;
	
    /**
	*  住院费用审核数据更新
	*/
	public abstract BlauditipAggDO[] update(BlauditipAggDO[] aggdos) throws BizException;
	
	/**
	*  住院费用审核数据逻辑删除
	*/
	public abstract void logicDelete(BlauditipAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对住院费用审核数据真删除
	 */
	public abstract void deleteByParentDO(BlAuditIp[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对住院费用审核数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(BlAuditIp[] mainDos) throws BizException;
}
