package iih.en.pv.inpatient.i;

import xap.mw.core.data.BizException;
import  iih.en.pv.inpatient.d.EnipntAggDO;

/**
* 入院通知单数据维护服务
*/
public interface IEnipntCudService {
	/**
	*  入院通知单数据真删除
	*/
    public abstract void delete(EnipntAggDO[] aggdos) throws BizException;
    
    /**
	*  入院通知单数据插入保存
	*/
	public abstract EnipntAggDO[] insert(EnipntAggDO[] aggdos) throws BizException;
	
    /**
	*  入院通知单数据保存
	*/
	public abstract EnipntAggDO[] save(EnipntAggDO[] aggdos) throws BizException;
	
    /**
	*  入院通知单数据更新
	*/
	public abstract EnipntAggDO[] update(EnipntAggDO[] aggdos) throws BizException;
	
	/**
	*  入院通知单数据逻辑删除
	*/
	public abstract void logicDelete(EnipntAggDO[] aggdos) throws BizException;
}
