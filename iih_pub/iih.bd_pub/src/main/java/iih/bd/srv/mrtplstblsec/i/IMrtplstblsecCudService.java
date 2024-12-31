package iih.bd.srv.mrtplstblsec.i;

import xap.mw.core.data.BizException;
import  iih.bd.srv.mrtplstblsec.d.MrtplstblsecAggDO;

/**
* 医疗记录模板智能表格段落数据维护服务
*/
public interface IMrtplstblsecCudService {
	/**
	*  医疗记录模板智能表格段落数据删除
	*/
    public abstract void delete(MrtplstblsecAggDO[] aggdos) throws BizException;
    
    /**
	*  医疗记录模板智能表格段落数据插入保存
	*/
	public abstract MrtplstblsecAggDO[] insert(MrtplstblsecAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录模板智能表格段落数据保存
	*/
	public abstract MrtplstblsecAggDO[] save(MrtplstblsecAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录模板智能表格段落数据更新
	*/
	public abstract MrtplstblsecAggDO[] update(MrtplstblsecAggDO[] aggdos) throws BizException;
	
	/**
	*  医疗记录模板智能表格段落数据真删
	*/
	public abstract void logicDelete(MrtplstblsecAggDO[] aggdos) throws BizException;
}
