package iih.bl.cg.ip.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendInpBillParamDTO;
import iih.bl.cg.ip.dto.d.IpCompensateBillDTO;
import iih.bl.cg.ip.dto.d.UsageStrategyDTO;
import iih.bl.cg.service.i.IBLOrderAppendBillService;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医技执行计费
 * @author yi
 */
public class ExecuChargeBaseBp {

	/**医技补费
	 * @param ipCompensateBillDtoArr
	 * @param usageStrategyDtoArr
	 * @return
	 * @throws BizException
	 */
	public IpCompensateBillDTO[] exec(IpCompensateBillDTO[] ipCompensateBillDtoArr,UsageStrategyDTO[] usageStrategyDtoArr) throws BizException
	{
		AppendBillInfusionRuleBp infusionRuleBp=new AppendBillInfusionRuleBp();
		IpCompensateBillDTO[] compensateBillDtoArr=infusionRuleBp.exec(usageStrategyDtoArr);
		IpCompensateBillDTO[] compensateBillDtoArrCombine=(IpCompensateBillDTO[])ArrayUtils.addAll(compensateBillDtoArr, ipCompensateBillDtoArr);
		if(ArrayUtil.isEmpty(compensateBillDtoArrCombine))
			return null;
		//组装记账DTO
		List<BlOrderAppendBillParamDTO> orderBillItmDto=assemblyBlorderAppendParamDtoLst(compensateBillDtoArrCombine);
		//计费
		IBLOrderAppendBillService orderAppendBillService=ServiceFinder.find(IBLOrderAppendBillService.class);
		BlOrderAppendBillParamDTO[] chargedBillItemDtoArr=orderAppendBillService.SetOrderAppendBill_ByItms(orderBillItmDto.toArray(new BlOrderAppendBillParamDTO[orderBillItmDto.size()]), IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		//返回值
		return mapperToIpCompensateBillDtoArr(chargedBillItemDtoArr);
	}
	
	private List<BlOrderAppendBillParamDTO> assemblyBlorderAppendParamDtoLst(IpCompensateBillDTO[] compensateBillDtoArr) throws BizException
	{
		List<BlOrderAppendBillParamDTO> billParamDtoLst=new ArrayList<BlOrderAppendBillParamDTO>();
		for(IpCompensateBillDTO billDto:compensateBillDtoArr)
		{
			BlOrderAppendBillParamDTO billItmDto=new BlOrderAppendBillParamDTO();
			billItmDto.setId_org(Context.get().getOrgId());
			billItmDto.setId_grp(Context.get().getGroupId());
			billItmDto.setId_pat(billDto.getId_pat());
			billItmDto.setId_ent(billDto.getId_ent());
			billItmDto.setId_enttp(billDto.getId_enttp());
			billItmDto.setCode_enttp(billDto.getCode_enttp());
			billItmDto.setId_or(billDto.getId_or());
			billItmDto.setId_orsrv(billDto.getId_orsrv());
			billItmDto.setQuan(billDto.getQuan());
			billItmDto.setId_srvtp(billDto.getId_srvtp());
			billItmDto.setSd_srvtp(billDto.getSd_srvtp());
			billItmDto.setId_srvca(billDto.getId_srvca());
			billItmDto.setId_srv(billDto.getId_srv());
			billItmDto.setCode_srv(billDto.getCode_srv());
			billItmDto.setName_srv(billDto.getName_srv());
			billItmDto.setSrvu(billDto.getSrvu());
			billItmDto.setId_dep_cg(billDto.getId_dep_cg());
			billItmDto.setId_emp_cg(billDto.getId_emp_cg());
			billItmDto.setId_org_cg(Context.get().getOrgId());
			billItmDto.setEu_direct(billDto.getEu_direct());
			billItmDto.setPrice(billDto.getPrice());
			billItmDto.setAmt_std(billItmDto.getAmt());
			billItmDto.setAmt_pat(billItmDto.getAmt());
			billItmDto.setAmt_ratio(billItmDto.getAmt());
			billItmDto.setAmt_hp(new FDouble(0));
			billItmDto.setId_dep_or(billDto.getId_dep_or());
			billItmDto.setId_emp_or(billDto.getId_emp_or());
			billItmDto.setId_dep_mp(billDto.getId_dep_mp());//库房
			billItmDto.setId_dep_wh(billDto.getId_dep_wh());
			billItmDto.setFg_mm(billDto.getFg_mm());
			billItmDto.setId_mm(billDto.getId_mm());
			billItmDto.setId_mmtp(billDto.getId_mmtp());
			billItmDto.setCode_mm(billDto.getCode_mm());
			billItmDto.setName_mm(billDto.getName_mm());
			billItmDto.setPgku_base(billDto.getPgku_base());
			billItmDto.setPgku_cur(billDto.getPgku_cur());
			billItmDto.setFactor(billDto.getFactor());
			
			billItmDto.setSpec(billDto.getSpec());
			billItmDto.setSupportAppendBill(billDto.getSupportappendbill());

			billItmDto.setId_srv(billDto.getId_srv());
			billItmDto.setCode_srv(billDto.getCode_srv());
			billItmDto.setDt_or(billDto.getDt_or());
			billItmDto.setId_or_pr_srv(billDto.getId_or_pr_srv());
			billItmDto.setId_or_pr(billDto.getId_or_pr());
			
			billItmDto.setSrcfunc_des(billDto.getSrcfunc_des());

			billItmDto.setId_pripat(billDto.getId_pripat());
			billItmDto.setRatio_pripat(FDouble.ONE_DBL);

			BlOrderAppendInpBillParamDTO ipParam = new BlOrderAppendInpBillParamDTO();
			ipParam.setFg_bb(FBoolean.FALSE);
			ipParam.setId_dep_nur(billDto.getId_dep_nur());
			billItmDto.setInpBillDTO(ipParam);
			billParamDtoLst.add(billItmDto);
		}
		return billParamDtoLst;
	}

	private IpCompensateBillDTO[] mapperToIpCompensateBillDtoArr(BlOrderAppendBillParamDTO[] chargedBillItemDtoArr) throws BizException
	{
		List<IpCompensateBillDTO> lst=new ArrayList<IpCompensateBillDTO>();
		for(BlOrderAppendBillParamDTO billItmDto:chargedBillItemDtoArr)
		{
			IpCompensateBillDTO compensateBillDto=new IpCompensateBillDTO();
			compensateBillDto.setId_cg(billItmDto.getInpBillDTO().getId_cg());
			compensateBillDto.setId_or(billItmDto.getId_or());
			compensateBillDto.setId_orsrv(billItmDto.getId_orsrv());
			compensateBillDto.setId_pat(billItmDto.getId_pat());
			compensateBillDto.setId_ent(billItmDto.getId_ent());
			compensateBillDto.setId_mm(billItmDto.getId_mm());
			compensateBillDto.setId_enttp(billItmDto.getId_enttp());
			compensateBillDto.setCode_enttp(billItmDto.getCode_enttp());

			compensateBillDto.setName_srv(billItmDto.getName_srv());
			compensateBillDto.setId_srv(billItmDto.getId_srv());
			compensateBillDto.setCode_srv(billItmDto.getCode_srv());
			compensateBillDto.setAmt_std(billItmDto.getAmt_std());
			compensateBillDto.setPrice(billItmDto.getPrice_ratio());
			compensateBillDto.setQuan(billItmDto.getQuan());
			compensateBillDto.setSrvu(billItmDto.getSrvu());

			compensateBillDto.setId_or_pr(billItmDto.getId_or_pr());
			compensateBillDto.setId_or_pr_srv(billItmDto.getId_or_pr_srv());
			lst.add(compensateBillDto);
		}
		return lst.toArray(new IpCompensateBillDTO[lst.size()]);
	}
}
