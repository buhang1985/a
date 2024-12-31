package iih.mi.inst.bizbase;

import iih.mi.bd.d.HpDTO;
import iih.mi.biz.dto.d.ParamAttributeDTO;
import iih.mi.itf.facade.InsureFacade;

import java.util.Arrays;

import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;

public class InsureBaseImpl {
	
	protected String getDataSourceName(){
		InsureFacade insureFacade = (InsureFacade)Context.get().getAttribute(InsureFacade.class.getName());
		HpDTO hpDTO= insureFacade.geHpDTO();
		String dataSourceName = insureFacade.getDataSourceName();
		if (StringUtil.isEmptyWithTrim(dataSourceName))
			throw new BizRuntimeException("请先设置["+hpDTO.getCode()+"]医保产品的[第三方数据源]实体参数!");
		return dataSourceName;
	}
	
    @SuppressWarnings("unchecked")
	public ParamAttributeDTO getInOrOutParamOnlyLevel1(String[] inOrOutParamKeys){
		FArrayList inOrOutParamKeyList = new FArrayList();
		inOrOutParamKeyList.addAll(Arrays.asList(inOrOutParamKeys));
		ParamAttributeDTO inOrOutParam = new ParamAttributeDTO();
		inOrOutParam.setParamattributelevel1(inOrOutParamKeyList);
		return inOrOutParam;
    }
	
	protected HpDTO getHpDTO(){
		InsureFacade insureFacade = (InsureFacade)Context.get().getAttribute(InsureFacade.class.getName());
		return insureFacade.geHpDTO();
	}

	
}
