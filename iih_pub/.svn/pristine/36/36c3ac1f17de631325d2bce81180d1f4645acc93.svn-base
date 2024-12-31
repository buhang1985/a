package iih.bl.st.blpreauditip.i;

import xap.mw.core.data.BizException;
import iih.bl.st.blpreauditip.d.BlPreAuditIpDO;
import iih.bl.st.blpreauditip.d.BlpreauditipAggDO;

/**
* 医保预审核_住院数据维护服务
*/
public interface IBlpreauditipCudService {
	/**
	*  医保预审核_住院数据真删除
	*/
    public abstract void delete(BlpreauditipAggDO[] aggdos) throws BizException;
    
    /**
	*  医保预审核_住院数据插入保存
	*/
	public abstract BlpreauditipAggDO[] insert(BlpreauditipAggDO[] aggdos) throws BizException;
	
    /**
	*  医保预审核_住院数据保存
	*/
	public abstract BlpreauditipAggDO[] save(BlpreauditipAggDO[] aggdos) throws BizException;
	
    /**
	*  医保预审核_住院数据更新
	*/
	public abstract BlpreauditipAggDO[] update(BlpreauditipAggDO[] aggdos) throws BizException;
	
	/**
	*  医保预审核_住院数据逻辑删除
	*/
	public abstract void logicDelete(BlpreauditipAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医保预审核_住院数据真删除
	 */
	public abstract void deleteByParentDO(BlPreAuditIpDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医保预审核_住院数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(BlPreAuditIpDO[] mainDos) throws BizException;
}
