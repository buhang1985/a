package iih.ci.mr.nu.ipevalsigle.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.ipevalsigle.d.EvaluateDO;
import iih.ci.mr.nu.ipevalsigle.d.IpevalsigleAggDO;

/**
* 住院患者评价单数据维护服务
*/
public interface IIpevalsigleCudService {
	/**
	*  住院患者评价单数据真删除
	*/
    public abstract void delete(IpevalsigleAggDO[] aggdos) throws BizException;
    
    /**
	*  住院患者评价单数据插入保存
	*/
	public abstract IpevalsigleAggDO[] insert(IpevalsigleAggDO[] aggdos) throws BizException;
	
    /**
	*  住院患者评价单数据保存
	*/
	public abstract IpevalsigleAggDO[] save(IpevalsigleAggDO[] aggdos) throws BizException;
	
    /**
	*  住院患者评价单数据更新
	*/
	public abstract IpevalsigleAggDO[] update(IpevalsigleAggDO[] aggdos) throws BizException;
	
	/**
	*  住院患者评价单数据逻辑删除
	*/
	public abstract void logicDelete(IpevalsigleAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对住院患者评价单数据真删除
	 */
	public abstract void deleteByParentDO(EvaluateDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对住院患者评价单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(EvaluateDO[] mainDos) throws BizException;
}
