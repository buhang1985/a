package iih.bl.cg.ip.s.bp;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.DateTimeUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.pp.feeprojectrejectplan.d.ExclusiveDetailDO;
import iih.bd.pp.feeprojectrejectplan.d.FeeprojectrejectplanAggDO;
import iih.bd.pp.feeprojectrejectplan.i.IExclusiveDetailDORService;
import iih.bd.pp.feeprojectrejectplan.i.IFeeprojectrejectplanRService;
import iih.bd.pp.priusg.d.PriUsgDO;
import iih.bd.pp.priusg.i.IPriusgRService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.ip.dto.d.IpCompensateBillDTO;
import iih.bl.cg.ip.dto.d.UsageStrategyDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.cg.service.i.IBLOrderAppendBillService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 输液类补费规则
 * @author yangyang
 *
 */
public class AppendBillInfusionRuleBp {
	
	/**
	 * 输液类项目对于输液费每天只记录一次
	 * @param usageStrategyDtoArr
	 * @return
	 * @throws BizException
	 */
	public IpCompensateBillDTO[] exec(UsageStrategyDTO[] usageStrategyDtoArr) throws BizException{
		if(ArrayUtil.isEmpty(usageStrategyDtoArr)) //如果没有输液类项目，则不去处理
			return null;
		IPriusgRService priUsgRService=ServiceFinder.find(IPriusgRService.class);
		IExclusiveDetailDORService exclusiveService=ServiceFinder.find(IExclusiveDetailDORService.class);
		List<IpCompensateBillDTO> lst=new ArrayList<IpCompensateBillDTO>();
		for(UsageStrategyDTO item:usageStrategyDtoArr)
		{
			//原医嘱项目,用法
			String strIdRoute=item.getId_route();
			PriUsgDO[] priUsgDoArr=priUsgRService.findByAttrValString("Id_route", strIdRoute);
			if(ArrayUtil.isEmpty(priUsgDoArr))
				continue;
			//用法使用
			for(PriUsgDO usgDo:priUsgDoArr)
			{								
				//查找规则,互补策略
				ExclusiveDetailDO[] exclusiveDetailDtoArr=exclusiveService.findByAttrValString("Id_srv",usgDo.getId_srv());
				if(ArrayUtil.isEmpty(exclusiveDetailDtoArr))
				{
					return null;
				}
				if(exclusiveDetailDtoArr.length>1)
				{
					throw new BizException("服务业务规则维护出错，一个服务不能跨规则维护！");
				}
				IFeeprojectrejectplanRService feeprojectRservice=ServiceFinder.find(IFeeprojectrejectplanRService.class);
				FeeprojectrejectplanAggDO feeprojectAgg=feeprojectRservice.findById(exclusiveDetailDtoArr[0].getMaster_id());
				if(feeprojectAgg==null)
					return null;
				exclusiveDetailDtoArr=feeprojectAgg.getExclusiveDetailDO();

				//找出优先级最高的
				Map<String,Integer> map=new HashMap<String,Integer>();
				FArrayList strIdSrvLst=new FArrayList();
				ExclusiveDetailDO sortedDetail=null;
				String strComine="'";
				for(ExclusiveDetailDO detailDto:exclusiveDetailDtoArr)
				{
					map.put(detailDto.getId_srv(), detailDto.getSort());
					strIdSrvLst.add(detailDto.getId_srv());
					strComine=strComine+detailDto.getId_srv()+"','";
				}
				strComine=strComine.substring(0, strComine.length()-2);
//				String strWhere=String.format(" a0.id_srv in (%s) and a0.fg_refund='N' and a0.id_ent='%s' and a0.eu_direct=1 and a0.dt_cg>'%s'",
//						strComine,item.getId_ent(),Tools.getServerTime().getBeginDate().toString());
//				IBlcgqueryRService cgQueryRService=ServiceFinder.find(IBlcgqueryRService.class);
//				BlcgqueryAggDO[] cgIpAggdoArr=cgQueryRService.find(strWhere, "", FBoolean.FALSE);
				BlCgIpDO[] cgIpDoArr=getChargedBillItmArr(strComine,item.getId_ent());
				if(ArrayUtil.isEmpty(cgIpDoArr))
				{
					IpCompensateBillDTO compensateBillDto=assemblyCompensateBillDto(usgDo,item);
					lst.add(compensateBillDto);
				}
				else{
					int sortCgItm=map.get(cgIpDoArr[0].getId_srv());
					int sortUsgdo=map.get(usgDo.getId_srv());
					if(sortCgItm<=sortUsgdo)
					{
						//如果是最高优先级
						return null;
					}
					else{
						//TODO 这里需要删除原纪录
						IBLOrderAppendBillService appendBillService=ServiceFinder.find(IBLOrderAppendBillService.class);
						OperatorInfoDTO operatorInfoDTO=new OperatorInfoDTO();
						operatorInfoDTO.setId_dep(item.getId_dep_cg());
						operatorInfoDTO.setId_emp(item.getId_emp_cg());
						operatorInfoDTO.setId_grp(Context.get().getGroupId());
						operatorInfoDTO.setId_org(Context.get().getOrgId());
						operatorInfoDTO.setId_org_emp(Context.get().getOrgId());
						//优先级低的要退掉
						appendBillService.RefundInpBlcgById_cgip(new String[]{cgIpDoArr[0].getId_cgip()}, operatorInfoDTO);
						IpCompensateBillDTO compensateBillDto=assemblyCompensateBillDto(usgDo,item);
						lst.add(compensateBillDto);
					}
				}		
			}
			//当输液类项目的时候有多条的时候，只记录一条吧
			break;
		}//最外层循环
		return lst.toArray(new IpCompensateBillDTO[lst.size()]);
	}
	
	/**
	 * 生成补费数据
	 * @param usgDo
	 * @param usageStrategyDto
	 * @return
	 * @throws BizException
	 */
	private IpCompensateBillDTO assemblyCompensateBillDto(PriUsgDO usgDo,UsageStrategyDTO usageStrategyDto) throws BizException
	{
		IpCompensateBillDTO compensateBillDto=new IpCompensateBillDTO();
		IMedsrvRService rService=ServiceFinder.find(IMedsrvRService.class);
		ICiorderRService orderRService=ServiceFinder.find(ICiorderRService.class);
		CiOrderDO orderDo=orderRService.findById(usageStrategyDto.getId_or()).getParentDO();
		MedSrvDO medSrvDo=rService.findById(usgDo.getId_srv()).getParentDO();
		IPativisitRService pativisitRservice=ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO pativisitDo=pativisitRservice.findById(usageStrategyDto.getId_ent());
		compensateBillDto.setQuan(usgDo.getQuan_medu());
		compensateBillDto.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		compensateBillDto.setCode_srv(medSrvDo.getCode());
		compensateBillDto.setId_org_cg(Context.get().getOrgId());
		compensateBillDto.setId_pat(orderDo.getId_pat());
		compensateBillDto.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_IP);
		compensateBillDto.setEu_direct(1);
		compensateBillDto.setId_ent(usageStrategyDto.getId_ent());
		compensateBillDto.setId_srvtp(medSrvDo.getId_srvtp());
		compensateBillDto.setSd_srvtp(medSrvDo.getSd_srvtp());
		compensateBillDto.setId_srvca(medSrvDo.getId_srvca());
		compensateBillDto.setId_srv(usgDo.getId_srv());
		compensateBillDto.setName_srv(medSrvDo.getName());
		compensateBillDto.setSrvu(medSrvDo.getId_unit_med());
		compensateBillDto.setId_dep_mp(usageStrategyDto.getId_dep_mp());
		compensateBillDto.setId_dep_nur(usageStrategyDto.getId_dep_nur());
		compensateBillDto.setId_pripat(pativisitDo.getId_pripat());
		compensateBillDto.setSupportappendbill(FBoolean.FALSE);
		compensateBillDto.setId_emp_cg(usageStrategyDto.getId_emp_cg());
		compensateBillDto.setId_dep_cg(usageStrategyDto.getId_dep_cg());
		compensateBillDto.setId_org_cg(Context.get().getOrgId());
		return compensateBillDto;
	}

	/**
	 * 获取记账明细数据
	 * @param strIdSrvs 服务主键集合
	 * @return 记账数据
	 * @throws BizException
	 */
	private BlCgIpDO[] getChargedBillItmArr(String strIdSrvs,String strIdEnt) throws BizException
	{
//		String[] fields = { "quan", "id_ent", "id_srv" };
//		StringBuffer sql = new StringBuffer();
//		sql.append(" select sum(cgip.quan*cgip.eu_direct) as quan_total,cgip.id_ent,cgip.id_srv");
//		sql.append(" from bl_cg_ip cgip");
//		sql.append(" where cgip.id_ent='").append(strIdEnt).append("'");
//		sql.append(" and cgip.Fg_St='N' and cgip.dt_cg>'").append(Tools.getDateTimeAfter(Tools.getServerTime(), 1)).append("'");
//		sql.append(" and cgip.id_srv in(").append(strIdSrvs).append(")");
//		sql.append(" cgip.id_srv,cgip.id_dep_mp,cgip.id_dep_cg,cgip.id_ent");
////		SqlParam param=new SqlParam();
////		param.addParam(strIdEnt);
////		param.addParam(Tools.getDateTimeAfter(Tools.getServerTime(), 1));
////		param.addParam(strIdSrvs);
//		DAFacade dAFacade = new DAFacade();
//		List<BlCgIpDO> cgIpDoArr=(List<BlCgIpDO>)dAFacade.findByCond(BlCgIpDO.class,sql,fields);
//		return cgIpDoArr.toArray(cgIpDoArr.size());
		//AND CGIP.EU_DIRECT=1  这里解释一下方向取正向，因为是左关联，保证正向的都存在
		String strDate=DateTimeUtils.getDateTimeBefore(AppUtils.getServerDateTime(), 1).toString();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT CGIP.*,CIOR.NAME_OR AS DES_OR,DEP.NAME AS DEPMPNAME,MM.FG_CHARGE,CGIPRE.QUAN AS QUAN_MEND");
		sql.append(" FROM BL_CG_IP CGIP ");
		sql.append(" LEFT JOIN BL_CG_IP CGIPRE ON CGIP.ID_CGIP=CGIPRE.ID_PAR");
		sql.append(" LEFT JOIN BD_MM MM ON CGIP.ID_MM=MM.ID_MM");
		sql.append(" LEFT JOIN CI_ORDER CIOR ON CGIP.ID_OR=CIOR.ID_OR");
		sql.append(" LEFT JOIN BD_DEP DEP ON CGIP.ID_DEP_MP=DEP.ID_DEP ");
		sql.append(" LEFT JOIN BD_MEASDOC MEASDOC ON MEASDOC.ID_MEASDOC=CGIP.SRVU");
		sql.append(" WHERE CGIP.FG_ST='N' AND CGIP.EU_DIRECT=1 AND CGIP.ID_ENT='").append(strIdEnt).append("'");
		sql.append(" AND CGIP.ID_SRV in(").append(strIdSrvs).append(")");
		sql.append(" and CGIP.dt_cg>'").append(strDate).append("'");
		List<BlCgIpDO> cgIpDoQryResultArr  =(List<BlCgIpDO>)new DAFacade().execQuery(sql.toString(), new BeanListHandler(BlCgIpDO.class));
		if(ListUtil.isEmpty(cgIpDoQryResultArr))
			return null;
		List<BlCgIpDO> cgIpDoNewLst=new ArrayList<BlCgIpDO>();
		Map<String,BlCgIpDO> map=new HashMap<String,BlCgIpDO>();
		//这里对数据进行加工处理，退费必须要针对原退费记录进行退费
		for(BlCgIpDO cgIpDo:cgIpDoQryResultArr)
		{
			if(cgIpDo.getQuan_mend()!=null && cgIpDo.getQuan_mend().toDouble()>0)
			{
				if(map.containsKey(cgIpDo.getId_cgip()))
				{
					BlCgIpDO cgDo=map.get(cgIpDo.getId_cgip());
					cgDo.setQuan(cgDo.getQuan().sub(cgIpDo.getQuan_mend()));
				}
				else{
					cgIpDo.setQuan(cgIpDo.getQuan().sub(cgIpDo.getQuan_mend()));
					cgIpDo.setQuan_mend(new FDouble(0.00));
					map.put(cgIpDo.getId_cgip(), cgIpDo);
				}
				continue;
			}
			cgIpDoNewLst.add(cgIpDo);
		}
		
        //遍历HashMap的另一个方法  
        Set<Entry<String, BlCgIpDO>> sets = map.entrySet();  
        for(Entry<String, BlCgIpDO> entry : sets) {
        	BlCgIpDO cgipDo=entry.getValue();
        	if(cgipDo.getQuan().toDouble()>0)
        	{
        		cgIpDoNewLst.add(entry.getValue());
        	}
        }  
		return cgIpDoNewLst.toArray(new BlCgIpDO[cgIpDoNewLst.size()]);
	}
}
