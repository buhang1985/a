package iih.bl.st.ip.s.bp;

import iih.bd.base.utils.CollectionUtils;
import iih.bl.st.blcgipdto.d.BlStBaseInfo;
import iih.mi.biz.dto.d.CommonPropDataDTO;
import iih.mi.biz.dto.d.HisPropertyRefHpDTO;
import iih.mi.itf.context.InsureContext;
import iih.mi.itf.facade.InsureFacade;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

/**获取前置流程下医保分摊数据
 * @author yangyang
 * @date 2018-04-23
 */
public class GetHpPropDataBp {

	public CommonPropDataDTO exec(InsureContext insureContext,String strStId) throws BizException
	{
		//1、校验一下医保参数
		validateParam(insureContext);
		HisPropertyRefHpDTO propertyRefhpDto=new HisPropertyRefHpDTO();
		propertyRefhpDto.setId_ref(strStId);
		InsureFacade facade=new InsureFacade(insureContext);
		FArrayList arrayList=facade.getHpPropDataIp(propertyRefhpDto);
		if(arrayList.size()<=0)
			throw new BizException("获取到的分摊数据为空！");
		CommonPropDataDTO propDataDto=(CommonPropDataDTO)arrayList.get(0);
		return propDataDto;
	}
	
	private void validateParam(InsureContext insureContext) throws BizException
	{
		if(insureContext==null || insureContext.getIdHp().isEmpty())
		{
			throw new BizException("医保前置流程，获取医保分摊数据，医保上下文出入为空！");
		}
		
	}
}
