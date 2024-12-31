package iih.pi.overview.overview.i;

import xap.mw.core.data.BizException;
import  iih.pi.overview.overview.d.OverviewAggDO;

/**
* 患者临床摘要数据维护服务
*/
public interface IOverviewCudService {
	/**
	*  患者临床摘要数据真删除
	*/
    public abstract void delete(OverviewAggDO[] aggdos) throws BizException;
    
    /**
	*  患者临床摘要数据插入保存
	*/
	public abstract OverviewAggDO[] insert(OverviewAggDO[] aggdos) throws BizException;
	
    /**
	*  患者临床摘要数据保存
	*/
	public abstract OverviewAggDO[] save(OverviewAggDO[] aggdos) throws BizException;
	
    /**
	*  患者临床摘要数据更新
	*/
	public abstract OverviewAggDO[] update(OverviewAggDO[] aggdos) throws BizException;
	
	/**
	*  患者临床摘要数据逻辑删除
	*/
	public abstract void logicDelete(OverviewAggDO[] aggdos) throws BizException;
}
