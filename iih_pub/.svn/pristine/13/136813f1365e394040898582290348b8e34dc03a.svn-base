package iih.nmr.ha.tcho.ipevalsigle.i;

import xap.mw.core.data.BizException;
import iih.nmr.ha.tcho.ipevalsigle.d.TchoEvaluateDO;
import iih.nmr.ha.tcho.ipevalsigle.d.TchoipevalsigleAggDO;

/**
* 住院患者评价单数据维护服务
*/
public interface ITchoipevalsigleCudService {
	/**
	*  住院患者评价单数据真删除
	*/
    public abstract void delete(TchoipevalsigleAggDO[] aggdos) throws BizException;
    
    /**
	*  住院患者评价单数据插入保存
	*/
	public abstract TchoipevalsigleAggDO[] insert(TchoipevalsigleAggDO[] aggdos) throws BizException;
	
    /**
	*  住院患者评价单数据保存
	*/
	public abstract TchoipevalsigleAggDO[] save(TchoipevalsigleAggDO[] aggdos) throws BizException;
	
    /**
	*  住院患者评价单数据更新
	*/
	public abstract TchoipevalsigleAggDO[] update(TchoipevalsigleAggDO[] aggdos) throws BizException;
	
	/**
	*  住院患者评价单数据逻辑删除
	*/
	public abstract void logicDelete(TchoipevalsigleAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对住院患者评价单数据真删除
	 */
	public abstract void deleteByParentDO(TchoEvaluateDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对住院患者评价单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(TchoEvaluateDO[] mainDos) throws BizException;
}
