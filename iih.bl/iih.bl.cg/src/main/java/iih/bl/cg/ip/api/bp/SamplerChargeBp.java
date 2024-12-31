package iih.bl.cg.ip.api.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendInpBillParamDTO;
import iih.bl.cg.ip.dto.d.IpCompensateBillDTO;
import iih.bl.cg.ip.i.IExecuChargeService;
import iih.bl.cg.service.i.IBLOrderAppendBillService;
import iih.bl.cg.service.udi.IBlCgCodeConst;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.mp.dg.ipdgapp.d.ChargeStatusEnum;
import iih.mp.nr.api.bill.d.Billsupply;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class SamplerChargeBp {

	List<String> lstEntCode=new ArrayList<String>();
	List<String> lstBdSrv=new ArrayList<String>();
	
	/** 采样器补费
	 * @param supplyBillArr 采样器项目集合
	 * @throws BizException
	 */
	public void exec(Billsupply[] supplyBillArr) throws BizException
	{
		//如果为空则没有需要补充的附属费用
		if(ArrayUtils.isEmpty(supplyBillArr))
			return;
		//1、参数校验
		validateParam(supplyBillArr);
		//2、生成补费所需数据源
		IpCompensateBillDTO[] ipCompensateBillDtos=assemblyIpCompensateBillDtos(supplyBillArr);
		if(ipCompensateBillDtos == null || ipCompensateBillDtos.length == 0){
			return;
		}
		//3、组装记账DTO
		List<BlOrderAppendBillParamDTO> orderBillItmDto=assemblyBlorderAppendParamDtoLst(ipCompensateBillDtos);
		//4、计入费用
		IBLOrderAppendBillService orderAppendBillService=ServiceFinder.find(IBLOrderAppendBillService.class);
		BlOrderAppendBillParamDTO[] chargedBillItemDtoArr=orderAppendBillService.SetOrderAppendBill_ByItms(orderBillItmDto.toArray(new BlOrderAppendBillParamDTO[orderBillItmDto.size()]), IBdFcDictCodeConst.SD_CODE_ENTP_IP);
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
	
	/**组装数据源
	 * @param supplyBillArr 采血项目
	 * @return 补费明细
	 * @throws BizException
	 */
	private IpCompensateBillDTO[] assemblyIpCompensateBillDtos(Billsupply[] supplyBillArr) throws BizException
	{	
		Map<String,PatiVisitDO> mapEnt=new HashMap<String,PatiVisitDO>(); 
		Map<String,MedSrvDO> mapSrv=new HashMap<String,MedSrvDO>();
		IPativisitRService patRService=ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO[] patiVisitDoArr=patRService.findByAttrValStrings(PatiVisitDO.CODE, lstEntCode.toArray(new String[lstEntCode.size()]));
		for(PatiVisitDO item:patiVisitDoArr)
		{
			mapEnt.put(item.getCode(), item);
		}
		
		IMedsrvRService medSrvRService=ServiceFinder.find(IMedsrvRService.class);
		MedsrvAggDO[] medSrvAggDoArr=medSrvRService.findByAttrValStrings(MedSrvDO.CODE,lstBdSrv.toArray(new String[lstBdSrv.size()]));
		
		/**
		 * 如果没有对应的服务项目返回空
		 */
		if(medSrvAggDoArr == null || medSrvAggDoArr.length ==0){
			return null;
		}
		for(MedsrvAggDO aggDo:medSrvAggDoArr)
		{
			MedSrvDO medSrvDo=aggDo.getParentDO();
			mapSrv.put(medSrvDo.getCode(), medSrvDo);
		}
		
		List<IpCompensateBillDTO> lstCompensateBillDtoLst=new ArrayList<IpCompensateBillDTO>();
		for(Billsupply supplyDto:supplyBillArr)
		{
			IpCompensateBillDTO ipCompensateBillDto=new IpCompensateBillDTO();
			MedSrvDO medSrvDo=mapSrv.get(supplyDto.getCode_srv());
			PatiVisitDO entDo=mapEnt.get(supplyDto.getCode_ent());
			ipCompensateBillDto.setId_ent(entDo.getId_ent());
			ipCompensateBillDto.setCode_enttp(entDo.getCode_entp());
			ipCompensateBillDto.setEu_direct(ChargeStatusEnum.CHARGED);
			ipCompensateBillDto.setFg_mm(FBoolean.FALSE);
			ipCompensateBillDto.setQuan(new FDouble(supplyDto.getQuan_medu()));
			ipCompensateBillDto.setId_dep_cg(entDo.getId_dep_nur());
			ipCompensateBillDto.setId_dep_nur(entDo.getId_dep_nur());
			ipCompensateBillDto.setCode_srv(supplyDto.getCode_srv());
			//执行科室
			ipCompensateBillDto.setId_dep_mp(Context.get().getDeptId());
			ipCompensateBillDto.setId_emp_cg(Context.get().getStuffId());
			ipCompensateBillDto.setId_dep_or(Context.get().getDeptId());
			ipCompensateBillDto.setId_emp_or(Context.get().getStuffId());
			ipCompensateBillDto.setId_pat(entDo.getId_pat());
			ipCompensateBillDto.setId_srv(medSrvDo.getId_srv());
			ipCompensateBillDto.setId_srvca(medSrvDo.getId_srvca());
			ipCompensateBillDto.setId_srvtp(medSrvDo.getId_srvtp());
			ipCompensateBillDto.setSd_srvtp(medSrvDo.getSd_srvtp());
			ipCompensateBillDto.setName_srv(medSrvDo.getName());
			ipCompensateBillDto.setId_enttp(entDo.getId_entp());
			ipCompensateBillDto.setSrvu(medSrvDo.getId_unit_med());
			ipCompensateBillDto.setId_pripat(entDo.getId_pripat());
			ipCompensateBillDto.setSrcfunc_des("SamplerChargeBp");
			ipCompensateBillDto.setSupportappendbill(FBoolean.FALSE);
			lstCompensateBillDtoLst.add(ipCompensateBillDto);
		}
		return lstCompensateBillDtoLst.toArray(new IpCompensateBillDTO[lstCompensateBillDtoLst.size()]);
	}
	/** 参数校验
	 * @param supplyBillArr
	 * @throws BizException
	 */
 	private void validateParam(Billsupply[] supplyBillArr) throws BizException{
		for(int i=0;i<supplyBillArr.length;i++)
		{
			if(StringUtils.isEmpty(supplyBillArr[i].getCode_ent()))
			{
				throw new BizException("采血管计费过程中，未找到患者编码！");
			}
			if(StringUtils.isEmpty(supplyBillArr[i].getCode_srv()))
			{
				throw new BizException("采血管计费过程中，未找到项目编码！");
			}
			if(StringUtils.isEmpty(supplyBillArr[i].getCode_dep()))
			{
				throw new BizException("采血管计费过程中，未找到执行科室主键！");
			}
			if(supplyBillArr[i].getQuan_medu().compareTo(FDouble.ZERO_DBL)<0)
			{
				throw new BizException("采血管计费过程中，数量小于0！");
			}
			if(i>0)
			{
				if(!supplyBillArr[i].getCode_dep().equals(supplyBillArr[0].getCode_dep()))
				{
					throw new BizException("采血管计费过程中，执行科室不一致！");
				}
			}
			if(!lstEntCode.contains(supplyBillArr[i].getCode_ent()))
			{
				lstEntCode.add(supplyBillArr[i].getCode_ent());
			}
			if(!lstBdSrv.contains(supplyBillArr[i].getCode_srv()))
			{
				lstBdSrv.add(supplyBillArr[i].getCode_srv());
			}
		}
	}
}
