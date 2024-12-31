package iih.pe.por.pepsncard.i;

import xap.mw.core.data.BizException;
import iih.pe.por.pepsncard.d.PePsnCardDDO;
import iih.pe.por.pepsncard.d.PepsncardAggDO;

/**
* 体检客户会员卡数据维护服务
*/
public interface IPepsncardCudService {
	/**
	*  体检客户会员卡数据真删除
	*/
    public abstract void delete(PepsncardAggDO[] aggdos) throws BizException;
    
    /**
	*  体检客户会员卡数据插入保存
	*/
	public abstract PepsncardAggDO[] insert(PepsncardAggDO[] aggdos) throws BizException;
	
    /**
	*  体检客户会员卡数据保存
	*/
	public abstract PepsncardAggDO[] save(PepsncardAggDO[] aggdos) throws BizException;
	
    /**
	*  体检客户会员卡数据更新
	*/
	public abstract PepsncardAggDO[] update(PepsncardAggDO[] aggdos) throws BizException;
	
	/**
	*  体检客户会员卡数据逻辑删除
	*/
	public abstract void logicDelete(PepsncardAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检客户会员卡数据真删除
	 */
	public abstract void deleteByParentDO(PePsnCardDDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检客户会员卡数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PePsnCardDDO[] mainDos) throws BizException;
}
