package iih.pe.por.pecorpcharge.i;

import xap.mw.core.data.BizException;
import iih.pe.por.pecorpcharge.d.PeCorpChargeDO;
import iih.pe.por.pecorpcharge.d.PecorpchargeAggDO;

/**
* 体检团体账单数据维护服务
*/
public interface IPecorpchargeCudService {
	/**
	*  体检团体账单数据真删除
	*/
    public abstract void delete(PecorpchargeAggDO[] aggdos) throws BizException;
    
    /**
	*  体检团体账单数据插入保存
	*/
	public abstract PecorpchargeAggDO[] insert(PecorpchargeAggDO[] aggdos) throws BizException;
	
    /**
	*  体检团体账单数据保存
	*/
	public abstract PecorpchargeAggDO[] save(PecorpchargeAggDO[] aggdos) throws BizException;
	
    /**
	*  体检团体账单数据更新
	*/
	public abstract PecorpchargeAggDO[] update(PecorpchargeAggDO[] aggdos) throws BizException;
	
	/**
	*  体检团体账单数据逻辑删除
	*/
	public abstract void logicDelete(PecorpchargeAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检团体账单数据真删除
	 */
	public abstract void deleteByParentDO(PeCorpChargeDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检团体账单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeCorpChargeDO[] mainDos) throws BizException;
}
