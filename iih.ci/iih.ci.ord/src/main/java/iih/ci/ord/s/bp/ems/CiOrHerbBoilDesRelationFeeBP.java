package iih.ci.ord.s.bp.ems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.fc.wf.d.EnumFlow;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvRelMmDTO;
import iih.bl.cg.dto.d.BoilDesReferBillDTO;
import iih.bl.cg.dto.d.SrvBoilDesInfoDTO;
import iih.bl.cg.ip.i.IUsageWithBillService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.ExeDeptCalParamDTO;
import iih.ci.ord.emsdi.d.ExeWhDeptDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import iih.ci.ord.s.bp.quantum.CalQuantumBP;
import iih.ci.ord.s.bp.srvpri.CiOrSrvPriCalUtils;
import iih.ci.ord.s.ems.meta.StringList;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 草药医嘱-煎法要求关联费用 相关操作BP
 */
public class CiOrHerbBoilDesRelationFeeBP {

	/**
	 * @param emsdto
	 * @throws BizException
	 */
	public ArrayList<OrdSrvDO> exec(CiorderAggDO aggorder, CiEmsDTO ems, ArrayList<OrdSrvDO> orsrvs,Hashtable ht) throws BizException {

		// 获得医嘱关联费用服务数据
		// CiOrUsageRelFeeSrvGetBP bp=new CiOrUsageRelFeeSrvGetBP();
		// UsageRelFeeSrvDO[] relfeesrvdos=bp.exec(ems);

		// 过滤符合条件的草药医嘱
		ArrayList<OrdSrvDO> list = filterList(aggorder, ems, orsrvs, ht);
		return list;

	}

	/**
	 * 检索出符合条件的数据 条件:1、为草药医嘱 2、煎法不为空 3、非删除 在院执行标识默认值设置处理逻辑
	 * 
	 * @param emsdto
	 * @throws BizException
	 */
	private ArrayList<OrdSrvDO> filterList(CiorderAggDO aggdo, CiEmsDTO ems, ArrayList<OrdSrvDO> orsrvs,Hashtable ht)
			throws BizException {
		SrvBoilDesInfoDTO dto;
		ArrayList<SrvBoilDesInfoDTO> list = new ArrayList<SrvBoilDesInfoDTO>();
		for (int i = 0; i < orsrvs.size(); i++) {
			if (orsrvs.get(i).getId_boildes() != null && DOStatus.DELETED != orsrvs.get(i).getStatus()
					&& (orsrvs.get(i).getSd_srvtp() != null && orsrvs.get(i).getSd_srvtp().startsWith("0103"))) {
				dto = new SrvBoilDesInfoDTO();
				dto.setId_srv(orsrvs.get(i).getId_srv());
				dto.setName_srv(orsrvs.get(i).getName_srv());
				dto.setQuan(orsrvs.get(i).getQuan_total_medu());// 总数量
				dto.setId_unit(orsrvs.get(i).getId_medu());// 单位
				dto.setName_unit(orsrvs.get(i).getId_medu());// 单位 名称？
				dto.setId_boildes(orsrvs.get(i).getId_boildes());// 煎法要求
				list.add(dto);
			}
		}
		if (list.size() == 0) {
			return new ArrayList<OrdSrvDO>();
		}

		// 调用费用接口
		IUsageWithBillService ser = ServiceFinder.find(IUsageWithBillService.class);
		BoilDesReferBillDTO[] outarr = ser.getBoilDesRefbill((SrvBoilDesInfoDTO[]) list.toArray(new SrvBoilDesInfoDTO[list.size()]));
		
		//假数据测试
//		outarr = new BoilDesReferBillDTO[1];
//		BoilDesReferBillDTO ou = new BoilDesReferBillDTO();
//		ou.setId_srv("0001Z8100000000LIZD9");
//		ou.setId_unit("2");
//		ou.setName_srv("3");
//		ou.setName_unit("4");
//		ou.setQuan_medu(new FDouble(1.2));
//		outarr[0]=ou;
		if(outarr==null||outarr.length==0){
			return new ArrayList<OrdSrvDO>();
		}
		return convertOrsrv(aggdo, ems, outarr,ht);
	}

	/**
	 * 转换成ciorsrv数组
	 * 
	 * @throws BizException
	 */
	private ArrayList<OrdSrvDO> convertOrsrv(CiorderAggDO aggdo, CiEmsDTO ems, BoilDesReferBillDTO[] dtoArr,Hashtable ht) throws BizException {
		CiEnContextDTO CiEnContext = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
		CiOrderDO ordo = aggdo.getParentDO();
		ArrayList<OrdSrvDO> list = new ArrayList<OrdSrvDO>();
		OrdSrvDO srvdo;
		MedSrvDO medsrvdo;
		
		//医嘱保存完成后的提示信息
		String key="RelSrvMessageList";
		List<String> boilDesRefIdsrvs = new ArrayList<String>();
		for(BoilDesReferBillDTO boilDesReferBillDTO:dtoArr){
			boilDesRefIdsrvs.add(boilDesReferBillDTO.getId_srv());
		}
		MedSrvDO[] bdsrvdo = CiOrdAppUtils.getMedsrvMDORService().findByIds(boilDesRefIdsrvs.toArray(new String[0]), FBoolean.FALSE);
		Map<String, MedSrvDO> map = new HashMap<String, MedSrvDO>();
		for (MedSrvDO doinfo : bdsrvdo) {
			map.put(doinfo.getId_srv(), doinfo);
		}
		for (int i = 0; i < dtoArr.length; i++) {
			medsrvdo = map.get(dtoArr[i].getId_srv());
			if(medsrvdo==null||medsrvdo.getFg_active_bl()==FBoolean.FALSE||medsrvdo.getFg_active()==FBoolean.FALSE) {
				StringList msgList = new StringList();
				if(ht.containsKey(key)) {
					msgList=(StringList)ht.get(key);
				}else {
					ht.put(key, msgList);
				}
				msgList.add("煎法要求："+getBoilDesName(ems)+"关联的{"+medsrvdo.getCode()+"："+medsrvdo.getName()+"}已停用，未正常带出，请注意补费！");
				continue;
				}
			srvdo = new OrdSrvDO();
			srvdo.setId_srv(dtoArr[i].getId_srv());
			srvdo.setName_srv(dtoArr[i].getName_srv());
			srvdo.setQuan_medu(dtoArr[i].getQuan_medu());// 剂量
			srvdo.setId_medu(dtoArr[i].getId_unit());// 单位
			MedSrvRelMmDTO srvrelmmdo = null;
			srvdo.setId_or(ordo.getId_or());
			srvdo.setId_pat(ordo.getId_pat());
			srvdo.setId_entp(ordo.getId_entp());
			srvdo.setCode_entp(ordo.getCode_entp());
			srvdo.setId_en(ordo.getId_en());
			srvdo.setId_srvtp(medsrvdo.getId_srvtp());
			srvdo.setSd_srvtp(medsrvdo.getSd_srvtp());
			srvdo.setName(medsrvdo.getName());
			srvdo.setFg_dose_anoma(FBoolean.FALSE);
			srvdo.setId_route(medsrvdo.getId_route());
			srvdo.setId_routedes(medsrvdo.getId_routedes());
			srvdo.setId_boil(medsrvdo.getId_boil());
			srvdo.setId_boildes(medsrvdo.getId_boildes());
			srvdo.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);

			srvdo.setId_org_srv(ordo.getId_org_or());
			srvdo.setId_dep_srv(ordo.getId_dep_or());
			srvdo.setId_wg_or(ordo.getId_wg_or());
			srvdo.setId_emp_srv(ordo.getId_emp_or());
			srvdo.setDt_create(ordo.getDt_entry());
			srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdo.getId_dep_mp()));
			srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
			srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
			srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
			srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
			srvdo.setDt_last_bl(ordo.getDt_last_bl());
			srvdo.setFg_or(FBoolean.FALSE);
			srvdo.setEu_blmd(medsrvdo.getEu_blmd()); // 本服务定价
			srvdo.setFg_mm(FBoolean.FALSE);
			srvdo.setFg_set(FBoolean.FALSE);
			srvdo.setFg_propc(FBoolean.FALSE);
			srvdo.setFg_self(FBoolean.FALSE);
			srvdo.setFg_pres_outp(FBoolean.FALSE);
			srvdo.setNote_srv("");
			srvdo.setId_srvca(medsrvdo.getId_srvca());
			srvdo.setFg_bl(CiOrdUtils.nullHandle(medsrvdo.getFg_bl()));
			srvdo.setCode_srv(medsrvdo.getCode());
			srvdo.setEu_sourcemd(OrSrvSourceFromEnum.BOILDESRELFEE);
			srvdo.setId_primd(medsrvdo.getId_primd());
			srvdo.setFg_selfsrv(medsrvdo.getFg_ctm());
			srvdo.setId_srv_src(ordo.getId_srv());
			CalQuantumBP calQuantum = new CalQuantumBP();
			
			//郑州骨伤科医院需求 煎法要求打粉费=药总量*剂数；setQuan_total_medu是总量；
			//srvdo.setQuan_total_medu(calQuantum.getUnMMQuantum(srvdo.getId_freq(), 1,srvdo.getQuan_medu()).multiply((double)ordo.getOrders().intValue()));
			srvdo.setQuan_total_medu(calQuantum.getUnMMQuantum(ordo.getDt_effe(),srvdo.getId_freq(), 1,srvdo.getQuan_medu()));
			srvdo.setId_hp(CiEnContext.getId_hp());// 2016-07-12新增医保相关信息
			if (OrSrvSplitUtil.isTrue(srvdo.getFg_mm())) {
				srvrelmmdo = CiOrdUtils.getSrvRelDefaultMmDTO(medsrvdo.getId_srv(), ordo.getId_dep_or());
			}
			ExeWhDeptDTO exeandwhdeptinfo = null; // 2016-07-28 新执行科室逻辑调整
													// 调整到新的时将如下语句进行对应处理
			if (srvdo.getId_dep_mp() == null) {

				exeandwhdeptinfo = CiOrdUtils.getMpDeptID(getExeDeptCalParamDTO(ordo, medsrvdo, srvrelmmdo)); // 待打开
				srvdo.setId_org_mp(exeandwhdeptinfo.getId_org_mp()); // 待打开
				srvdo.setId_dep_mp(exeandwhdeptinfo.getId_dep_mp()); // 待打开
				srvdo.setId_dep_wh(exeandwhdeptinfo.getId_dep_wh()); // 待打开
			} else {
			}
			if (srvdo.getId_org_mp() == null) {
				srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdo.getId_dep_mp()));
			}

			// 给 id_org和id_grp赋值

			srvdo.setId_org(CiOrdAppUtils.getEnvContext().getOrgId());
			srvdo.setId_grp(CiOrdAppUtils.getEnvContext().getGroupId());

			// 计算价格 String code_entp, String id_srv, String id_primd, OrdSrvDO
			// srvdo
			CiOrSrvPriCalUtils.mappingPriceRateFromEmsToSrv("", srvdo.getId_srv(), srvdo.getId_primd(), srvdo);

			srvdo.setFg_feertnable(FBoolean.TRUE);
			srvdo.setStatus(DOStatus.NEW);
			list.add(srvdo);

		}
		return list;
	}
	private String getBoilDesName(CiEmsDTO ems){
		FArrayList emssrvlist=ems.getEmssrvs();
		StringBuilder sb=new StringBuilder();
		for(Object o : emssrvlist){
			CiEmsSrvDTO srv=(CiEmsSrvDTO)o;
			if(srv.getName_boildes()!=null&&srv.getName_boildes().trim().length()>0&&!sb.toString().contains(srv.getName_boildes()))
			sb.append(srv.getName_boildes()+",");
		}
		return sb.toString();
	}

	/**
	 * 获得执行科室计算参数信息DTO
	 * 
	 * @param ordo
	 * @param ems
	 * @param srvinsetdo
	 * @param tmpdo
	 * @param srvrelmmdo
	 * @return
	 * @throws BizException
	 */
	private ExeDeptCalParamDTO getExeDeptCalParamDTO(CiOrderDO ordo, MedSrvDO bdsrvdo, MedSrvRelMmDTO srvrelmmdo)
			throws BizException {
		ExeDeptCalParamDTO paramdto = new ExeDeptCalParamDTO();
		PatiVisitDO pvdo = CiOrdUtils.getPatiVisitDO(ordo.getId_en()); // 最后注释掉
																		// 从
																		// ordo中取该相关数据值
		paramdto.setCode_entp(ordo.getCode_entp());
		paramdto.setId_dep_en(pvdo.getId_dep_phy());
		paramdto.setId_dep_or(ordo.getId_dep_or());
		paramdto.setId_dep_ns(pvdo.getId_dep_nur());
		paramdto.setId_dep_exe(ordo.getId_dep_mp());
		paramdto.setFg_long(ordo.getFg_long());
		paramdto.setId_srv(bdsrvdo.getId_srv());
		if (!CiOrdUtils.isEmpty(srvrelmmdo)) {
			paramdto.setId_mm(srvrelmmdo.getId_mm());
		}
		paramdto.setSd_srvtp(bdsrvdo.getSd_srvtp());
		paramdto.setId_srvca(bdsrvdo.getId_srvca());
		paramdto.setInnercode_srvca(bdsrvdo.getSrvca_innercode());
		paramdto.setId_route(bdsrvdo.getId_route());
		paramdto.setDt_effe(ordo.getDt_effe());
		if (!CiOrdUtils.isTrue(bdsrvdo.getFg_mm())) {
			paramdto.setEu_wftp(EnumFlow.EXECUTEFLOW); // 只求执行科室
		} else {
			paramdto.setEu_wftp(EnumFlow.NULL); // 求物资流向科室
		}

		return paramdto;
	}
}
