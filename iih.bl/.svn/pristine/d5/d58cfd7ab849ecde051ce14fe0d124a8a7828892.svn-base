package iih.bl.st.exchagehandle.bp;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDORService;
import iih.bl.cg.dto.d.BlChargeDTO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class BlChargeQryBp {

	/**
	 * 查询未划价的记账信息
	 * @param id_pat
	 * @param id_grp
	 * @param validateTime
	 * @return
	 * @throws BizException
	 */
	public BlChargeDTO[] getUnPricedChargeItem(String id_pat,String id_grp,String validateTime) throws BizException
	{
		//1.获取记账明细
		IBlCgItmOepDORService blcgitmRservice=ServiceFinder.find(IBlCgItmOepDORService.class);
		BlCgItmOepDO[] cgitmoepDoArr=blcgitmRservice.find(" fg_st='N'", "", new FBoolean(false));
		
		//2.组装成BlChargeDTO
		BlChargeDTO[] blchargeDtoArr=assemblyBlChargeDTOSource(cgitmoepDoArr);
		return null;
	}
	
	private BlChargeDTO[] assemblyBlChargeDTOSource(BlCgItmOepDO[] chargeDtoArr) throws BizException
	{
		//判断是否有记账信息
		if(chargeDtoArr==null || chargeDtoArr.length<=0)
			return null;
		List<String> strIdPresLst=new ArrayList<String>();
		BlChargeDTO[] datasource=new BlChargeDTO[chargeDtoArr.length];
		for(int i=0;i<chargeDtoArr.length;i++)
		{
			BlChargeDTO chargeDto=new BlChargeDTO();
			
			
			//处方主键
			chargeDto.setId_pres(chargeDtoArr[i].getId_pres());
			chargeDto.setId_pat(chargeDtoArr[i].getId_pat());
			chargeDto.setId_ent(chargeDtoArr[i].getId_ent());
			//就诊类型
			chargeDto.setCode_entp(chargeDtoArr[i].getCode_enttp());
			//诊断编码
			chargeDto.setDidef_code(null);
			chargeDto.setDidef_name(null);
			chargeDto.setMr_content(null);
			chargeDto.setName_dep_or(chargeDtoArr[i].getDepor_name());
			chargeDto.setId_dep_or(chargeDtoArr[i].getId_dep_or());
			chargeDto.setId_prestp(null);
			chargeDto.setSd_prestp(null);
			chargeDto.setId_emp_or(chargeDtoArr[i].getId_emp_or());
			chargeDto.setName_emp_or(chargeDtoArr[i].getEmpor_name());
			chargeDto.setDt_entry(null);
			chargeDto.setRegistertradeno(null);
			chargeDto.setId_dep_mp(chargeDtoArr[i].getId_dep_mp());
			chargeDto.setName_dep_mp(chargeDtoArr[i].getDepmp_name());
			
			
		}
		return null;
	}
	/**
	 * @param id_pat
	 * @param id_grp
	 * @param validateTime
	 * @return
	 * @throws BizException
	 */
	public BlChargeDTO[] getOrderSrvItemByPres(String id_pat,String id_grp,String validateTime) throws BizException
	{
		return null;
	}

}
