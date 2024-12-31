package iih.ei.std.cr_technology.v1.s.bp;

import java.util.LinkedHashMap;
import java.util.List;

import iih.ei.std.cr_technology.v1.d.PivasDispDrugParamBean;
import iih.ei.std.cr_technology.v1.d.PivasDispDrugRstBean;
import iih.mp.dg.dto.ipdrugmp.d.IpDgDtDTO;
import iih.mp.dg.i.IMpDgMaintainService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class PivasDispDrugSplitNewBp {
	
	/**
	 * 发药
	 * 
	 * @throws BizException
	 */
	public void exec(LinkedHashMap<String, LinkedHashMap<String, PivasDispDrugParamBean>> beanMap,
			List<PivasDispDrugRstBean> rstBeanList, List<IpDgDtDTO> ipdgList) throws BizException {
		try {
			//发药
			IMpDgMaintainService iMpDgMaintainService = ServiceFinder.find(IMpDgMaintainService.class);
			iMpDgMaintainService.putIpMedicineSend(ipdgList.toArray(new IpDgDtDTO[0]), "21", "47103015");
		} catch(Exception ex) {
			//抛出异常
			throw ex;
		}
		//设置返回结果(发药成功)
		for(IpDgDtDTO itemDTO : ipdgList) {
			PivasDispDrugParamBean paramBean = beanMap.get(itemDTO.getCode_or()).get(String.valueOf(itemDTO.getDt_mp_plan()));
			rstBeanList.add(PivasDispDrugCommBp.iniSuccRstBean(paramBean));
		}
	}
}
