package iih.pe.phm.i;

import iih.pe.phm.pehmgroup.d.PeHmGroupPsnDO;
import iih.pe.phm.pehmgroup.d.PeHmGroupRisksDO;
import iih.pe.phm.perstsurvery.d.PerstsurveryAggDO;
import xap.mw.core.data.BizException;

public interface IPetcmconMaintainService{
	
	//保存中医体质评分
	public boolean setEval(String id_pepsnappt, String id_pehmappt) throws BizException;
	
	//根据id_pepsnappt新增一套中医体质数据
	public void createSeries(String id_pepsnappt, String id_pehmappt) throws BizException;
	
	//计算平均值和中位数
	public PeHmGroupRisksDO[] countValue(PeHmGroupRisksDO[] risksDo, PeHmGroupPsnDO[] psnDos) throws BizException;
	
	//健康评估保存处理
	public boolean saveCountValue(PerstsurveryAggDO dataAggDos) throws BizException;
	
	//生命质量评估保存
	public boolean saveQualityLife(PerstsurveryAggDO dataAggDos) throws BizException;
	
} 
