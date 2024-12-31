package iih.bl.st.blstaroep.i;

import xap.mw.core.data.BizException;
import  iih.bl.st.blstaroep.d.BlstaroepAggDO;

/**
* 结算应收_门急体数据维护服务
*/
public interface IBlstaroepCudService {
	/**
	*  结算应收_门急体数据删除
	*/
    public abstract void delete(BlstaroepAggDO[] aggdos) throws BizException;
    
    /**
	*  结算应收_门急体数据插入保存
	*/
	public abstract BlstaroepAggDO[] insert(BlstaroepAggDO[] aggdos) throws BizException;
	
    /**
	*  结算应收_门急体数据保存
	*/
	public abstract BlstaroepAggDO[] save(BlstaroepAggDO[] aggdos) throws BizException;
	
    /**
	*  结算应收_门急体数据更新
	*/
	public abstract BlstaroepAggDO[] update(BlstaroepAggDO[] aggdos) throws BizException;
	
	/**
	*  结算应收_门急体数据逻辑删除
	*/
	public abstract void logicDelete(BlstaroepAggDO[] aggdos) throws BizException;
}
