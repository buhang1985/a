package iih.ci.ord.s.external.thirdws.op.apbt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvLisDO;
import iih.ci.ord.cior.d.CiorappbtAggDO;
import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.cior.d.OrdApBtViewItemDO;
import iih.ci.ord.cior.i.ICiorappbtCudService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderCudService;
import iih.ci.ord.i.external.thirdws.apbt.d.EmsapbtBloodItemDTO;
import iih.ci.ord.i.external.thirdws.apbt.d.EmsapbtentDTO;
import iih.ci.ord.i.external.thirdws.apbt.d.EmsapbtordDTO;
import iih.ci.ord.i.external.thirdws.apbt.d.EmsapbtviewitemDTO;
import iih.ci.ord.i.external.thirdws.base.EmsCommonOrdDTO;
import iih.ci.ord.i.external.thirdws.base.EmsCommonSrvDTO;
import iih.ci.ord.i.external.thirdws.base.EmsRstDTO;
import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.orcontent.CiOrContentUtils;
import iih.ci.ord.s.external.blood.ruimei.s.bp.ConvertDTOs2XmlUtils;
import iih.ci.ord.s.external.thirdws.op.base.OpCommonSaveAction;
import iih.ci.ord.s.external.thirdws.utils.BdDiDefUtils;
import iih.ci.ord.s.external.thirdws.utils.BdMeasdocUtils;
import iih.ci.ord.s.external.thirdws.utils.CiorderUtils;
import iih.ci.ord.s.external.thirdws.utils.MedSrvUtils;
import iih.ci.ord.s.external.thirdws.utils.UdidocUtils;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.udi.d.UdidocDO;

public class EmsApbtSaveAction extends OpCommonSaveAction{
	
	
	@Override
	public String save(EntWsDTO entdto) throws BizException {
		super.save(entdto);
		EmsapbtentDTO emsapbtentDTO = (EmsapbtentDTO) entdto;
		// 获取医嘱集合
		List<EmsapbtordDTO> oEmsapbtordDTOs = emsapbtentDTO.getOrdList();
		if (!CiOrdUtils.isEmpty(oEmsapbtordDTOs)) {
			
			// agg集合
			List<CiorderAggDO> aggList = new ArrayList<CiorderAggDO>();
			List<CiorappbtAggDO> aptAggList = new ArrayList<CiorappbtAggDO>();

			for (EmsapbtordDTO emsapbtordDTO : oEmsapbtordDTOs) {
				//覆盖某些数值
	 			if(!CiOrdUtils.isEmpty(emsapbtordDTO.getSrvList())){
	 				for(EmsCommonSrvDTO sCommonSrvDTO:emsapbtordDTO.getSrvList()) {
	 	 				//费用项目单次数量
	 					sCommonSrvDTO.setQuan_medu_cur(sCommonSrvDTO.getQuan_medu_srv());
	 	 			}
	 			}
	 			if(emsapbtordDTO.getBloodItemList()!=null&&emsapbtordDTO.getBloodItemList().size()>0) {
	 			emsapbtordDTO.setCode_srv_or(emsapbtordDTO.getBloodItemList().get(0).getCode_srv_or());
	 			emsapbtordDTO.setName_srv_or(emsapbtordDTO.getBloodItemList().get(0).getName_srv_or());
	 			emsapbtordDTO.setQuan_medu_bt(emsapbtordDTO.getBloodItemList().get(0).getQuan_medu_bt());
	 			emsapbtordDTO.setCode_medu_bt(emsapbtordDTO.getBloodItemList().get(0).getCode_medu_bt());
	 			}
				// 子表do集合
				List<OrdApBtViewItemDO> ordApBtViewItemDOs = new ArrayList<OrdApBtViewItemDO>();
				// ---------ci_order-医嘱-主表-----------------------
				// 医嘱-服务agg
				CiorderAggDO aggdo = this.assebleOrderAgg(emsapbtordDTO);
				this.setBloodItems(aggdo, emsapbtordDTO.getBloodItemList());
				aggList.add(aggdo);
				CiOrderDO c = aggdo.getParentDO();//获取当前主表 给后面逻辑用 
				//判断医嘱编码是否重复
				CiOrderDO isDuplicateCiOrderDO=CiorderUtils.getCiOrderDO(CiOrderDO.CODE_OR, c.getCode_or());
				if(isDuplicateCiOrderDO != null) {
					throw new BizException("医嘱编码重复");
				}
				System.out.println("id_or:-----" + c.getId_or() + "----------");

				// ------------ci_ap_bt-备血申请单 -主表--------------------
				// 组装备血申请单
				OrdApBtDO apBtDO = this.assembleCpBt(emsapbtordDTO);
				apBtDO.setId_or(c.getId_or());
				c.setApplyno(apBtDO.getNo_applyform());
				//aggdo.getOrdSrvDO()[0].setQuan_medu(apBtDO.getNum_margin_bu());
				// 检验
				List<EmsapbtviewitemDTO> emsapbtviewitemDTOs = emsapbtordDTO.getCheckList();
				for (EmsapbtviewitemDTO emsapbtviewitemDTO : emsapbtviewitemDTOs) {
					// -------------ci_ap_bt_viewitm-备血观察检验指标 -子表---------------
					OrdApBtViewItemDO viewItemDO = this.assembleViewItem(emsapbtviewitemDTO);
//					viewItemDO.setId_srv(c.getId_srv());
					if(viewItemDO.getId_srv()==null)
						continue;
					ordApBtViewItemDOs.add(viewItemDO);
				}
				// 备血-检验agg
				CiorappbtAggDO aptAgg = new CiorappbtAggDO();
				OrdApBtViewItemDO[] aptArrDos = ordApBtViewItemDOs.toArray(new OrdApBtViewItemDO[0]);
				aptAgg.setParentDO(apBtDO);
				aptAgg.setOrdApBtViewItemDO(aptArrDos);
				aptAggList.add(aptAgg);
			}
			//保存发消息
			EmsRstDTO rstDTO = save(aggList, aptAggList);
			ConvertDTOs2XmlUtils util = new ConvertDTOs2XmlUtils();
			// 返回XML
			return util.exec(new EmsRstDTO[] { rstDTO }, "rst", "");
		}
		return null;
	}
	/**
	 * 保存发消息
	 * @param aggList
	 * @param aptAggList
	 * @return
	 * @throws BizException
	 */
	private EmsRstDTO save(List<CiorderAggDO> aggList, List<CiorappbtAggDO> aptAggList) throws BizException {
		EmsRstDTO retdto = new EmsRstDTO();
		ICiorderCudService service = ServiceFinder.find(ICiorderCudService.class);
		ICiorappbtCudService apbtService = ServiceFinder.find(ICiorappbtCudService.class);
		try {
			// 保存医嘱 服务list
			for (CiorderAggDO d : aggList) {
				System.out.println("agg:" + d.toString() + "//n");
			}
			CiorderAggDO[] dos = aggList.toArray(new CiorderAggDO[0]);
			dos = service.save(dos);
			// 保存申请单 检验单list
			for (CiorappbtAggDO d : aptAggList) {
				System.out.println("aggList:" + d.toString() + "//n");
			}
			CiorappbtAggDO[] doss = aptAggList.toArray(new CiorappbtAggDO[0]);
			apbtService.save(doss);
			retdto.setResultcode("0");
			this.fireSignEvent(dos);
		} catch (Exception e) {
			e.printStackTrace();
			retdto.setResultcode("1");
			retdto.setResultmsg(e.toString());
			throw new BizException(e);
		}
		return retdto;
	}

	/**
	 * 重写组装医嘱和服务
	 */
	@Override
	public CiorderAggDO assebleOrderAgg(EmsCommonOrdDTO emsDrugsOrdDTO) throws BizException {
		EmsapbtordDTO emsapbtordDTO = (EmsapbtordDTO) emsDrugsOrdDTO;
		CiorderAggDO aggdo = super.assebleOrderAgg(emsDrugsOrdDTO);
		CiOrderDO ciOrderDO=aggdo.getParentDO();
		//医嘱频次
		ciOrderDO.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);
		ciOrderDO.setFreq_name(IBdSrvDictCodeConst.NAME_FREQNUNITCT_ITEM_ONCE);
		// 补充其他数据在这里
		// 医嘱和服务设置id_or
		OrdSrvDO[] srvDOs = (OrdSrvDO[]) aggdo.getChildrenDO();
		for (OrdSrvDO srv : srvDOs) {
			// 服务频次
			srv.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);
			srv.setFreq_name(IBdSrvDictCodeConst.NAME_FREQNUNITCT_ITEM_ONCE);
			// 服务单位 从医嘱申请用量单位出获取
			if (StringUtils.isNotEmpty(emsapbtordDTO.getCode_medu_bt())) {
				MeasDocDO meas = BdMeasdocUtils.getMeasDocDOByCode(emsapbtordDTO.getCode_medu_bt());
				if (meas != null) {
					srv.setId_medu(meas.getId_measdoc());
				}
			}
			//服务数量
			srv.setQuan_medu(new FDouble(emsapbtordDTO.getQuan_medu_bt()));
			//总量  频次为1  故总量和单个数量一致
			srv.setQuan_total_medu(srv.getQuan_medu());
		}
		//组装处置内容
		assembleContent_or(aggdo);
		
		ciOrderDO.setSd_orsrcfun(ICiDictCodeConst.SD_ORDSRCFUN_DOC);//医嘱来源功能sd
		ciOrderDO.setId_orsrcfun(ICiDictCodeConst.ID_ORDSRCFUN_DOC);//医嘱来源功能id
		return aggdo;
	}
	/**
	 * 组装处置内容
	 */
	@Override
	protected void assembleContent_or(CiorderAggDO agg) {
		CiOrderDO orderDO = agg.getParentDO();
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append("配"+orderDO.getName_or()+orderDO.getQuan_medu()+"次");
		String string=CiOrContentUtils.create(orderDO.getSd_srvtp(), stringBuilder.toString(), orderDO.getRoute_name(), FBoolean.FALSE)
				.toString();
		System.out.println("content_or:----"+string+"---------");
		orderDO.setContent_or(string);
	}
	/**
	 * 组装检验指标
	 * 
	 * @param viewitemDTO
	 * @return
	 * @throws BizException 
	 */
	private OrdApBtViewItemDO assembleViewItem(BaseDTO viewitemDTO) throws BizException {
		EmsapbtviewitemDTO emsapbtviewitemDTO = (EmsapbtviewitemDTO) viewitemDTO;
		OrdApBtViewItemDO ordApBtViewItemDO = new OrdApBtViewItemDO();
		ordApBtViewItemDO.setStatus(DOStatus.NEW);
		// 47.序号
		if (StringUtils.isNotEmpty(emsapbtviewitemDTO.getSortno_viewitm())) {
			ordApBtViewItemDO.setSortno(Integer.parseInt(emsapbtviewitemDTO.getSortno_viewitm()));
		}
		// 48.检验指标编码
		ordApBtViewItemDO.setCode_srv(emsapbtviewitemDTO.getCode_srv_viewitm());
		// 49.检验指标简称
		ordApBtViewItemDO.setName_srv(emsapbtviewitemDTO.getName_or_viewitm());
		// 服务信息 通过code_srv查询
		if (StringUtils.isNotEmpty(emsapbtviewitemDTO.getCode_srv_viewitm())) {
			MedSrvDO medSrvDO = MedSrvUtils.getMedSrv(MedSrvDO.CODE, emsapbtviewitemDTO.getCode_srv_viewitm());
			if (medSrvDO != null) {
				// 检验项目编码
				ordApBtViewItemDO.setId_srv(medSrvDO.getId_srv());// 医疗服务主键标识
				
				MedSrvLisDO lis=MedSrvUtils.getMedLab(medSrvDO.getId_srv());
				// 检验项目单位
				if(lis!=null) {
					// 检验项目单位
				ordApBtViewItemDO.setId_unit(lis.getId_unit_nuit());// 检验结果单位
				ordApBtViewItemDO.setName_unit(lis.getNuit_name());// 简称
				}
			}
		}
		// 50.项目结果值
		ordApBtViewItemDO.setVal_rstrptla(emsapbtviewitemDTO.getVal_rstrptla_viewitm());
		// ---------------其他数据----------

		return ordApBtViewItemDO;
	}

	/**
	 * 组装备血申请单
	 * 
	 * @param orDto
	 * @return
	 */
	private OrdApBtDO assembleCpBt(BaseDTO orDto) {
		EmsapbtordDTO emsapbtordDTO = (EmsapbtordDTO) orDto;
		OrdApBtDO ordApBtDO = new OrdApBtDO();
		ordApBtDO.setStatus(DOStatus.NEW);
		// 21.备血申请单号
		ordApBtDO.setNo_applyform(emsapbtordDTO.getNo_applyform());
		// 22.孕几胎
		ordApBtDO.setPregnant_num(emsapbtordDTO.getPregnant_num()==null?null:Integer.parseInt(emsapbtordDTO.getPregnant_num()));
		// 23.生产数量
		ordApBtDO.setParturition_cnt(emsapbtordDTO.getParturition_cnt()==null?null:Integer.parseInt(emsapbtordDTO.getParturition_cnt()));
		// 24.输血史标识编码
		try {
			UdidocDO udidocDO = UdidocUtils.getUdidocByCode("CI.OR.0665", emsapbtordDTO.getSd_his_bt());
			if (udidocDO != null) {
				// 输血史标识id
				ordApBtDO.setId_his_bt(udidocDO.getId_udidoc());
			}
		} catch (BizException e1) {
			e1.printStackTrace();
		}
		ordApBtDO.setSd_his_bt(emsapbtordDTO.getSd_his_bt());
		// 25.输血目的编码
		try {
			UdidocDO udidocDO = UdidocUtils.getUdidocByCode("CI.OR.0670", emsapbtordDTO.getSd_pps_bt());
			if (udidocDO != null) {
				// 输血目的id
				ordApBtDO.setId_pps_bt(udidocDO.getId_udidoc());
			}
		} catch (BizException e1) {
			e1.printStackTrace();
		}
		ordApBtDO.setSd_pps_bt(emsapbtordDTO.getSd_pps_bt());
		// 26.输血目的描述
		ordApBtDO.setDes_pps_bt(emsapbtordDTO.getDes_pps_bt());
		// 27.临床诊断编码 根据编码查诊断相关信息
		try {
			DiagDefDO diagDefDO = BdDiDefUtils.getDiagDefDOByCode(emsapbtordDTO.getCode_diag());
			if (!CiOrdUtils.isEmpty(diagDefDO)) {
				// 临床诊断
				ordApBtDO.setId_di(diagDefDO.getId_didef());
				// 诊断id明细
				ordApBtDO.setId_diitm(diagDefDO.getId_didef());
				// 临床诊断明细
				ordApBtDO.setStr_id_diitm(diagDefDO.getId_didef());
				// 28.临床诊断名称 通过查询的赋值 并没有从传进来的获取
				ordApBtDO.setName_diag(diagDefDO.getName());
			}
		} catch (BizException e) {
			e.printStackTrace();
		}
		
		// 29.献血史标识
		ordApBtDO.setFg_db(FBoolean.valueOf(emsapbtordDTO.getFg_db()));
		// 30.献血证号
		ordApBtDO.setNo_db(emsapbtordDTO.getNo_db());
		// 31.输血需求状态
		try {
			UdidocDO udidocDO = UdidocUtils.getUdidocByCode("CI.OR.0675", emsapbtordDTO.getSd_demandsu_bt());
			if (udidocDO != null) {
				// 输血需求状态id
				ordApBtDO.setId_demandsu_bt(udidocDO.getId_udidoc());
			}
		} catch (BizException e1) {
			e1.printStackTrace();
		}
		ordApBtDO.setSd_demandsu_bt(emsapbtordDTO.getSd_demandsu_bt());
		// 32.预定输血方式
		try {
			UdidocDO udidocDO = UdidocUtils.getUdidocByCode("CI.OR.0680", emsapbtordDTO.getSd_mode_bt());
			if (udidocDO != null) {
				// 预定输血方式id
				ordApBtDO.setId_mode_bt(udidocDO.getId_udidoc());
			}
		} catch (BizException e1) {
			e1.printStackTrace();
		}
		ordApBtDO.setSd_mode_bt(emsapbtordDTO.getSd_mode_bt());
		// 33.计划输血日期
		ordApBtDO.setDt_bt_pl(emsapbtordDTO.getDt_bt_pl());
		// 34.申请血型编码
		try {
			UdidocDO udidocDO = UdidocUtils.getUdidocByCode("PI.PI.1585", emsapbtordDTO.getSd_bloodtype_ap());
			if (udidocDO != null) {
				// 申请血型编码id
				ordApBtDO.setId_bloodtype_ap(udidocDO.getId_udidoc());
			}
		} catch (BizException e1) {
			e1.printStackTrace();
		}
		ordApBtDO.setSd_bloodtype_ap(emsapbtordDTO.getSd_bloodtype_ap());
		// 35.申请Rh(D)编码
		try {
			UdidocDO udidocDO = UdidocUtils.getUdidocByCode("PI.PI.1505", emsapbtordDTO.getSd_rhd_ap());
			if (udidocDO != null) {
				// 申请Rh(D)id
				ordApBtDO.setId_rhd_ap(udidocDO.getId_udidoc());
			}
		} catch (BizException e1) {
			e1.printStackTrace();
		}
		ordApBtDO.setSd_rhd_ap(emsapbtordDTO.getSd_rhd_ap());
		// 36.新生儿标识
		ordApBtDO.setFg_newborn(FBoolean.valueOf(emsapbtordDTO.getFg_newborn()));
		// 37.申请血量(申请表和服务表都存-申请表)服务表取得单次数量-53
		ordApBtDO.setNum_margin_bu(new FDouble(emsapbtordDTO.getQuan_medu_bt()));
		// ---------其他数据-----------
		// 备血申请状态-已申请
		ordApBtDO.setId_su_bt(ICiDictCodeConst.ID_CI_BT_YSQ);
		ordApBtDO.setSd_su_bt(ICiDictCodeConst.SD_CI_BT_YSQ);
		// 报告标志
		ordApBtDO.setFg_rpt("N");
		// 打印标识
		ordApBtDO.setFg_prn(FBoolean.FALSE);
		// 打印次数
		ordApBtDO.setCnt_prn(0);
		return ordApBtDO;
	}
	
	private void setBloodItems(CiorderAggDO aggdo,List<EmsapbtBloodItemDTO>blooditems) throws BizException {
		HashMap<String,OrdSrvDO> map=new HashMap<>();
		int sortno=0;
		List<OrdSrvDO> slist=new ArrayList<>();
		for (OrdSrvDO srv : aggdo.getOrdSrvDO()) {
			map.put(srv.getCode_srv(), srv);
			slist.add(srv);
			if(srv.getSortno()!=null&&srv.getSortno()>sortno)
				sortno=srv.getSortno();
		}
		List<String> codes=new ArrayList<>();
		for (EmsapbtBloodItemDTO b : blooditems) {
			if(b.getCode_srv_or()==null||b.getCode_srv_or().trim().length()==0||map.containsKey(b.getCode_srv_or()))
				continue;
			codes.add(b.getCode_srv_or());
		}
		if(codes.size()>0) {
		Map<String, MedSrvDO> srvmap=this.getMedSrvMap(codes);
		
		for (EmsapbtBloodItemDTO b : blooditems) {
			if(b.getCode_srv_or()==null||b.getCode_srv_or().trim().length()==0||map.containsKey(b.getCode_srv_or()))
				continue;
			if(!srvmap.containsKey(b.getCode_srv_or()))
				throw new BizException(b.getCode_srv_or()+" 不存在");
			MedSrvDO medsrv=srvmap.get(b.getCode_srv_or());
			EmsCommonSrvDTO srvdo=new EmsCommonSrvDTO();
			srvdo.setQuan_medu_cur(b.getQuan_medu_bt());
			srvdo.setCode_medu_cur(b.getCode_medu_bt());
			srvdo.setSortno_srv(""+(++sortno));
			OrdSrvDO s=this.assembleSrv(srvdo,medsrv,aggdo.getParentDO());
			s.setStatus(DOStatus.NEW);
			slist.add(s);		
		}
		}
		aggdo.setOrdSrvDO(slist.toArray(new OrdSrvDO[0]));
		
	}

}
