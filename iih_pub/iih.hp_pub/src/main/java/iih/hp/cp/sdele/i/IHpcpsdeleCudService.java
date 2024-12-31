package iih.hp.cp.sdele.i;

import xap.mw.core.data.BizException;
import  iih.hp.cp.sdele.d.HpcpsdeleAggDO;

/**
* 诊疗计划标准元素数据维护服务
*/
public interface IHpcpsdeleCudService {
	/**
	*  诊疗计划标准元素数据真删除
	*/
    public abstract void delete(HpcpsdeleAggDO[] aggdos) throws BizException;
    
    /**
	*  诊疗计划标准元素数据插入保存
	*/
	public abstract HpcpsdeleAggDO[] insert(HpcpsdeleAggDO[] aggdos) throws BizException;
	
    /**
	*  诊疗计划标准元素数据保存
	*/
	public abstract HpcpsdeleAggDO[] save(HpcpsdeleAggDO[] aggdos) throws BizException;
	
    /**
	*  诊疗计划标准元素数据更新
	*/
	public abstract HpcpsdeleAggDO[] update(HpcpsdeleAggDO[] aggdos) throws BizException;
	
	/**
	*  诊疗计划标准元素数据逻辑删除
	*/
	public abstract void logicDelete(HpcpsdeleAggDO[] aggdos) throws BizException;
}
