package iih.mp.ne.i;

import iih.mp.ne.samsend.d.InspectionSheetDTO;
import iih.mp.ne.samsend.d.SendConditionDTO;
import xap.mw.core.data.BizException;

public interface ISampleSendExtService {
	
	/*
	 * 获取送检单列表
	 * SendDate 送检日期
	 * Id_dep 送检科室
	 * */
	public abstract InspectionSheetDTO[] GetInspectionSheetList(SendConditionDTO conditionDto) throws BizException;
	
	/*
	 * 送检单打印
	 * DTOS 送检列表
	 * */
	public abstract InspectionSheetDTO[] SendSavePrint(InspectionSheetDTO[] DTOS) throws BizException;	
	
}
