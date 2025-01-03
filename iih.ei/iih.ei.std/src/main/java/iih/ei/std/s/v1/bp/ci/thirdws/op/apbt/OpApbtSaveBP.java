package iih.ei.std.s.v1.bp.ci.thirdws.op.apbt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.ems.d.EmsAppModeEnum;
import iih.bd.srv.ems.d.SrvMatchEmsParamDTO;
import iih.bd.srv.ems.d.SrvMatchEmsRstDTO;
import iih.bd.srv.ems.i.IEmsManagementService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvLisDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.cior.d.CiorappbtAggDO;
import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.cior.d.OrdApBtViewItemDO;
import iih.ci.ord.cior.i.ICiorappbtCudService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderCudService;
import iih.ci.ord.i.external.common.ICIOrdRService;
import iih.ci.ord.pub.listener.ICiEventConst;
import iih.ei.std.d.v1.ci.apbt.d.EmsApbtEntDTO;
import iih.ei.std.d.v1.ci.apbt.d.EmsApbtOrdDTO;
import iih.ei.std.d.v1.ci.apbt.d.EmsApbtSrvDTO;
import iih.ei.std.d.v1.ci.apbt.d.EmsApbtViewItemDTO;
import iih.ei.std.d.v1.ci.apbt.d.EmsapbtBloodItemDTO;
import iih.ei.std.d.v1.ci.ent.d.ResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.ci.thirdws.utils.BdDiDefUtils;
import iih.ei.std.s.v1.bp.ci.thirdws.utils.BdMeasdocUtils;
import iih.ei.std.s.v1.bp.ci.thirdws.utils.CiorderUtils;
import iih.ei.std.s.v1.bp.ci.thirdws.utils.ConvertDTOs2XmlUtils;
import iih.ei.std.s.v1.bp.ci.thirdws.utils.DeptUtils;
import iih.ei.std.s.v1.bp.ci.thirdws.utils.MedSrvUtils;
import iih.ei.std.s.v1.bp.ci.thirdws.utils.PsndocUtils;
import iih.ei.std.s.v1.bp.ci.thirdws.utils.ThirdInfoUtils;
import iih.ei.std.s.v1.bp.ci.thirdws.utils.UdidocUtils;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.appfw.orm.utils.AuditInfoUtil;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * @code 第三方门诊备血回写BP @author LiYue
 */
public class OpApbtSaveBP extends IIHServiceBaseBP<EmsApbtEntDTO, ResultDTO> {
	ThirdInfoUtils urils = new ThirdInfoUtils();
	private PatiVisitDO entdo;
	private OutpatientDO entopdo;
	private EntHpDO entHpdo;

	// 入参校验
	protected void checkParam(EmsApbtEntDTO entDTO) throws BizException {
		if (entDTO == null) {
			throw new BizException("未能获取到-就诊信息");
		}
		// ----------------校验数据信息----------
		// 1.校验就诊信息
		if (StringUtils.isEmpty(entDTO.getCode_org())) {
			throw new BizException(":未能获取到-所属组织");
		}
		if (StringUtils.isEmpty(entDTO.getCode_pat())) {
			throw new BizException(":未能获取到-患者");
		}
		if (StringUtils.isEmpty(entDTO.getCode_en())) {
			throw new BizException(":未能获取到-就诊编码");
		}
		if (StringUtils.isEmpty(entDTO.getCode_entp())) {
			throw new BizException(":未能获取到-就诊类型编码");
		}
		if (StringUtils.isEmpty(entDTO.getCode_dep_phy())) {
			throw new BizException(":未能获取到-当前就诊科室");
		}
		if (StringUtils.isEmpty(entDTO.getCode_emp_phy())) {
			throw new BizException(":未能获取到-当前主管医生");
		}
		if (StringUtils.isEmpty(entDTO.getSd_bloodtype_pi())) {
			throw new BizException(":未能获取到-患者血型编码");
		}
		if (StringUtils.isEmpty(entDTO.getSd_rhd_pi())) {
			throw new BizException(":未能获取到-患者Rh(D)编码");
		}
		List<EmsApbtOrdDTO> ordList = (List<EmsApbtOrdDTO>) entDTO.getEmslisprintdto();
		if (ordList == null && ordList.size() <= 0) {
			throw new BizException(":未能获取到-医嘱信息");
		}
		int i = 0;
		for (EmsApbtOrdDTO ordDTO : ordList) {
			i++;
			// 1.1校验医嘱信息

			if (StringUtils.isEmpty(ordDTO.getSortno_or())) {
				throw new BizException("[" + i + "]:未能获取到-医嘱序号");
			}
			if (StringUtils.isEmpty(ordDTO.getCode_or())) {
				throw new BizException("[" + i + "]:未能获取到-医嘱编码");
			}
			if (StringUtils.isEmpty(ordDTO.getCode_srv_or())) {
				throw new BizException("[" + i + "]:未能获取到-备血项目编码");
			}
			if (StringUtils.isEmpty(ordDTO.getName_srv_or())) {
				throw new BizException("[" + i + "]:未能获取到-备血项目名称");
			}
			if (StringUtils.isEmpty(ordDTO.getNo_applyform())) {
				throw new BizException("[" + i + "]:未能获取到备血申请单号");
			}
			if (StringUtils.isEmpty(ordDTO.getSd_his_bt())) {
				throw new BizException("[" + i + "]:未能获取到-输血史标识编码");
			}
			if (StringUtils.isEmpty(ordDTO.getSd_pps_bt())) {
				throw new BizException("[" + i + "]:未能获取到-输血目的描述");
			}
			if (StringUtils.isEmpty(ordDTO.getSd_demandsu_bt())) {
				throw new BizException("[" + i + "]:未能获取到-输血需求状态");
			}
			if (StringUtils.isEmpty(ordDTO.getSd_mode_bt())) {
				throw new BizException("[" + i + "]:未能获取到-预定输血方式");
			}
			if (StringUtils.isEmpty(ordDTO.getDt_bt_pl())) {
				throw new BizException("[" + i + "]:未能获取到-计划输血日期");
			}
			if (StringUtils.isEmpty(ordDTO.getSd_bloodtype_ap())) {
				throw new BizException("[" + i + "]:未能获取到-申请血型编码");
			}
			if (StringUtils.isEmpty(ordDTO.getSd_rhd_ap())) {
				throw new BizException("[" + i + "]:未能获取到-申请Rh(D)编码");
			}
			if (StringUtils.isEmpty(ordDTO.getQuan_medu_bt())) {
				throw new BizException("[" + i + "]:未能获取到-申请血量");
			}
			if (StringUtils.isEmpty(ordDTO.getCode_medu_bt())) {
				throw new BizException("[" + i + "]:未能获取到-申请血量单位");
			}
			if (StringUtils.isEmpty(ordDTO.getCode_dep_or())) {
				throw new BizException("[" + i + "]:未能获取到-开立部门");
			}
			if (StringUtils.isEmpty(ordDTO.getCode_emp_or())) {
				throw new BizException("[" + i + "]:未能获取到-开立医生");
			}
			if (StringUtils.isEmpty(ordDTO.getDt_entry_or())) {
				throw new BizException("[" + i + "]:未能获取到-开立日期");
			}
			if (StringUtils.isEmpty(ordDTO.getCode_dep_mp_or())) {
				throw new BizException("[" + i + "]:未能获取到-医嘱执行科室");
			}

			// 1.1.1校验服务信息
			List<EmsApbtSrvDTO> srvList = (List<EmsApbtSrvDTO>) ordDTO.getSrvlist();

			int j = 0;
			for (EmsApbtSrvDTO srvDto : srvList) {
				j++;
				// 校验服务
				if (StringUtils.isEmpty(srvDto.getCode_srv())) {
					throw new BizException("[" + j + "]:未能获取到-费用项目编码");
				}
				if (StringUtils.isEmpty(srvDto.getName_srv())) {
					throw new BizException("[" + j + "]:未能获取到-费用项目名称");
				}
				if (StringUtils.isEmpty(srvDto.getQuan_medu_srv())) {
					throw new BizException("[" + j + "]:未能获取到-费用项目单次数量");
				}
				if (StringUtils.isEmpty(srvDto.getPri())) {
					throw new BizException("[" + j + "]:未能获取到-单价");
				}
				if (StringUtils.isEmpty(srvDto.getPri_std())) {
					throw new BizException("[" + j + "]:未能获取到-标准价");
				}
				if (StringUtils.isEmpty(srvDto.getPri_ratio())) {
					throw new BizException("[" + j + "]:未能获取到-价格系数");
				}
				if (StringUtils.isEmpty(srvDto.getCode_dep_mp_srv())) {
					throw new BizException("[" + j + "]:未能获取到-费用执行科室");
				}

			}
			// 1.1.2校验检验信息
			List<EmsApbtViewItemDTO> checkList = (List<EmsApbtViewItemDTO>) ordDTO.getChecklist();
			if (checkList == null && checkList.size() <= 0) {
				throw new BizException(":未能获取到-血液成分信息");
			}
			int k = 0;
			for (EmsApbtViewItemDTO check : checkList) {
				k++;
				// 校验检验详细

				if (StringUtils.isEmpty(check.getSortno_viewitm())) {
					throw new BizException("[" + k + "]:未能获取到-序号");
				}
				if (StringUtils.isEmpty(check.getCode_srv_viewitm())) {
					throw new BizException("[" + k + "]:未能获取到-检验指标编码");
				}
				if (StringUtils.isEmpty(check.getName_or_viewitm())) {
					throw new BizException("[" + k + "]:未能获取到-检验指标简称");
				}
				if (StringUtils.isEmpty(check.getVal_rstrptla_viewitm())) {
					throw new BizException("[" + k + "]:未能获取到-项目结果值");
				}
			}
			// 血液成分
			List<EmsapbtBloodItemDTO> bloodItemDTOs = (List<EmsapbtBloodItemDTO>) ordDTO.getEmsapbtblooditemdto();
			if (bloodItemDTOs == null && bloodItemDTOs.size() <= 0) {
				throw new BizException("未能获取到-备血明细信息");
			}
			int u = 0;
			for (EmsapbtBloodItemDTO emsapbtBloodItemDTO : bloodItemDTOs) {
				u++;
				
				if (StringUtils.isEmpty(emsapbtBloodItemDTO.getCode_srv_or())) {
					throw new BizException("[" + k + "]:未能获取到-备血项目编码");
				}
				if (StringUtils.isEmpty(emsapbtBloodItemDTO.getName_srv_or())) {
					throw new BizException("[" + k + "]:未能获取到-备血项目名称");
				}
				if (StringUtils.isEmpty(emsapbtBloodItemDTO.getQuan_medu_bt())) {
					throw new BizException("[" + k + "]:未能获取到-申请血量");
				}
				if (StringUtils.isEmpty(emsapbtBloodItemDTO.getCode_medu_bt())) {
					throw new BizException("[" + k + "]:未能获取到-申请血量单位");
				}
			}
		}

	}

	// 核心逻辑 组装数据 保存
	protected ResultDTO process(EmsApbtEntDTO emsapbtentDTO) throws BizException {
		// 数据准备
		entdo = urils.getEntDO(emsapbtentDTO.getCode_en());
		entopdo = urils.getEnEntOpDO(entdo.getId_ent());
		entHpdo = urils.getEntHpDO(entdo.getId_ent());

		// 获取医嘱集合
		List<EmsApbtOrdDTO> oEmsapbtordDTOs = (List<EmsApbtOrdDTO>) emsapbtentDTO.getEmslisprintdto();
		if (oEmsapbtordDTOs != null && oEmsapbtordDTOs.size() > 0) {

			// agg集合
			List<CiorderAggDO> aggList = new ArrayList<CiorderAggDO>();
			List<CiorappbtAggDO> aptAggList = new ArrayList<CiorappbtAggDO>();

			for (EmsApbtOrdDTO emsapbtordDTO : oEmsapbtordDTOs) {
				List<EmsApbtSrvDTO> srvlist = (List<EmsApbtSrvDTO>) emsapbtordDTO.getSrvlist();
				List<EmsApbtViewItemDTO> Checklist = (List<EmsApbtViewItemDTO>) emsapbtordDTO.getChecklist();

				if (Checklist != null && Checklist.size() > 0) {
					emsapbtordDTO.setCode_srv_or(srvlist.get(0).getCode_srv());
					emsapbtordDTO.setName_srv_or(srvlist.get(0).getName_srv());
					emsapbtordDTO.setQuan_medu_bt(srvlist.get(0).getQuan_medu_srv());
				}
				// 子表do集合
				List<OrdApBtViewItemDO> ordApBtViewItemDOs = new ArrayList<OrdApBtViewItemDO>();
				// ---------ci_order-医嘱-主表-----------------------
				// 医嘱-服务agg
				CiorderAggDO aggdo = assebleOrderAgg(emsapbtordDTO);
				setBloodItems(aggdo, (List<EmsapbtBloodItemDTO>) emsapbtordDTO.getEmsapbtblooditemdto());
				aggList.add(aggdo);
				CiOrderDO c = aggdo.getParentDO();// 获取当前主表 给后面逻辑用
				// 判断医嘱编码是否重复
//				 CiOrderDO isDuplicateCiOrderDO=CiorderUtils.getCiOrderDO(CiOrderDO.CODE_OR,
//				 c.getCode_or());
//				 if(isDuplicateCiOrderDO != null) {
//				 throw new BizException("医嘱编码重复");
//				 }
//				System.out.println("id_or:-----" + c.getId_or() + "----------");

				// ------------ci_ap_bt-备血申请单 -主表--------------------
				// 组装备血申请单
				OrdApBtDO apBtDO = this.assembleCpBt(emsapbtordDTO);
				apBtDO.setId_or(c.getId_or());
				c.setApplyno(apBtDO.getNo_applyform());
				// aggdo.getOrdSrvDO()[0].setQuan_medu(apBtDO.getNum_margin_bu());
				// 检验
				List<EmsApbtViewItemDTO> emsapbtviewitemDTOs = emsapbtordDTO.getChecklist();
				for (EmsApbtViewItemDTO emsapbtviewitemDTO : emsapbtviewitemDTOs) {
					// -------------ci_ap_bt_viewitm-备血观察检验指标 -子表---------------
					OrdApBtViewItemDO viewItemDO = this.assembleViewItem(emsapbtviewitemDTO);
					// viewItemDO.setId_srv(c.getId_srv());
					if (viewItemDO.getId_srv() == null)
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
			// 保存发消息
			ResultDTO rstDTO = save(aggList, aptAggList);
			ConvertDTOs2XmlUtils util = new ConvertDTOs2XmlUtils();
			return rstDTO;
		}
		return null;
	}

	private ResultDTO save(List<CiorderAggDO> aggList, List<CiorappbtAggDO> aptAggList) {
		ResultDTO retdto = new ResultDTO();
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
		}
		return retdto;
	}

	/**
	 * 发送消息给执行域进行医嘱的拆分
	 * 
	 * @param aggarrays
	 * @throws BizException
	 */
	protected void fireSignEvent(CiorderAggDO[] aggarrays) throws BizException {
		// 发送消息给执行域，进行拆分
		List<CiOrderDO> orders = new ArrayList<CiOrderDO>();
		for (CiorderAggDO ciorderAggDO : aggarrays) {
			orders.add(ciorderAggDO.getParentDO());
		}

		BDCommonEvent event = new BDCommonEvent(ICiEventConst.CIOR_STATUS_EVENT_SOURCEID, IEventType.TYPE_UPDATE_AFTER,
				orders.toArray(new CiOrderDO[0]));
		EventDispatcher.fireEvent(event);
	}

	private OrdApBtViewItemDO assembleViewItem(EmsApbtViewItemDTO emsapbtviewitemDTO) throws BizException {
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

				MedSrvLisDO lis = MedSrvUtils.getMedLab(medSrvDO.getId_srv());
				// 检验项目单位
				if (lis != null) {
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

	private OrdApBtDO assembleCpBt(EmsApbtOrdDTO emsapbtordDTO) {
		OrdApBtDO ordApBtDO = new OrdApBtDO();
		ordApBtDO.setStatus(DOStatus.NEW);
		// 21.备血申请单号
		ordApBtDO.setNo_applyform(emsapbtordDTO.getNo_applyform());
		// 22.孕几胎
		ordApBtDO.setPregnant_num(
				emsapbtordDTO.getPregnant_num() == null ? null : Integer.parseInt(emsapbtordDTO.getPregnant_num()));
		// 23.生产数量
		ordApBtDO.setParturition_cnt(emsapbtordDTO.getParturition_cnt() == null ? null
				: Integer.parseInt(emsapbtordDTO.getParturition_cnt()));
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
			if (diagDefDO != null) {
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

	private void setBloodItems(CiorderAggDO aggdo, List<EmsapbtBloodItemDTO> blooditems) throws BizException {
		HashMap<String, OrdSrvDO> map = new HashMap<>();
		int sortno = 0;
		List<OrdSrvDO> slist = new ArrayList<>();
		for (OrdSrvDO srv : aggdo.getOrdSrvDO()) {
			map.put(srv.getCode_srv(), srv);
			slist.add(srv);
			if (srv.getSortno() != null && srv.getSortno() > sortno)
				sortno = srv.getSortno();
		}
		List<String> codes = new ArrayList<>();
		for (EmsapbtBloodItemDTO b : blooditems) {
			if (b.getCode_srv_or() == null || b.getCode_srv_or().trim().length() == 0 || map.containsKey(b.getCode_srv_or()))
				continue;
			codes.add(b.getCode_srv_or());
		}
		if (codes.size() > 0) {
			Map<String, MedSrvDO> srvmap = urils.getMedSrvMap(codes);

			for (EmsapbtBloodItemDTO b : blooditems) {

				if (b.getCode_srv_or() == null || b.getCode_srv_or().trim().length() == 0 || map.containsKey(b.getCode_srv_or()))
					continue;
				if (!srvmap.containsKey(b.getCode_srv_or()))
					throw new BizException(b.getCode_srv_or() + " 不存在");
				MedSrvDO medsrv = srvmap.get(b.getCode_srv_or());

				EmsApbtSrvDTO srvdo = new EmsApbtSrvDTO();
				OrdSrvDO s = assembleSrv(srvdo, medsrv, aggdo.getParentDO());
				s.setStatus(DOStatus.NEW);
				slist.add(s);
			}
		}
		aggdo.setOrdSrvDO(slist.toArray(new OrdSrvDO[0]));

	}

	private OrdSrvDO assembleSrv(EmsApbtSrvDTO apbtSrvdo, MedSrvDO medsrv, CiOrderDO order) throws BizException {
		OrdSrvDO srvdo = assembleSrv(apbtSrvdo);
		if (medsrv != null) {
			srvdo.setId_srv(medsrv.getId_srv());
			srvdo.setSd_srvtp(medsrv.getSd_srvtp());
			srvdo.setId_srvtp(medsrv.getId_srvtp());
			srvdo.setCode_srv(medsrv.getCode());
			srvdo.setId_srvca(medsrv.getId_srvca());
			srvdo.setName(medsrv.getName());
			srvdo.setId_primd(medsrv.getId_primd());
			srvdo.setFg_bl(medsrv.getFg_bl());
		}
		srvdo.setId_or(order.getId_or());
		srvdo.setDt_last_bl(order.getDt_effe());
		srvdo.setDt_last_mp(order.getDt_effe());
		srvdo.setId_route(order.getId_route());
		srvdo.setId_freq(order.getId_freq());
		// 开立相关信息 从ciorder获取
		srvdo.setId_org_srv(order.getId_org_or());// 开立机构
		srvdo.setId_dep_srv(order.getId_dep_or());// 开立科室
		srvdo.setId_wg_or(order.getId_wg_or());// 开立医疗组
		srvdo.setId_emp_srv(order.getId_emp_or());// 开立医生
		srvdo.setDt_create(order.getDt_entry());// 开始时间
		return srvdo;
	}

	private OrdSrvDO assembleSrv(EmsApbtSrvDTO emsDrugsSrvDTO) throws BizException {
		OrdSrvDO srvdo = new OrdSrvDO();
		String[] id_orsrv = new DBUtil().getOIDs(1);
		srvdo.setId_orsrv(id_orsrv[0]);
		srvdo.setStatus(DOStatus.NEW);
		srvdo.setId_pat(entdo.getId_pat());
		srvdo.setId_en(entdo.getId_ent());
		srvdo.setId_entp(entdo.getId_entp());
		srvdo.setCode_entp(entdo.getCode_entp());
		// srvdo.setDt_create(CiOrdAppUtils.getServerDateTime());
		srvdo.setId_pripat(entdo.getId_pripat());
		srvdo.setId_grp(entdo.getId_grp());
		srvdo.setId_org(entdo.getId_org());

		if (StringUtils.isNotEmpty(emsDrugsSrvDTO.getPri())) {
			srvdo.setPri(new FDouble(emsDrugsSrvDTO.getPri()));
		}
		if (StringUtils.isNotEmpty(emsDrugsSrvDTO.getPri_std())) {
			srvdo.setPri_std(new FDouble(emsDrugsSrvDTO.getPri_std()));
		}
		if (StringUtils.isNotEmpty(emsDrugsSrvDTO.getPri_ratio())) {
			srvdo.setPri_ratio(new FDouble(emsDrugsSrvDTO.getPri_ratio()));
		}
		srvdo.setSd_hpsrvtp(emsDrugsSrvDTO.getSd_hpsrvtp());
		if (StringUtils.isNotEmpty(emsDrugsSrvDTO.getSd_hpsrvtp())) {
			// 医保目录对照 BD.BL.1020
			UdidocDO udidoc = UdidocUtils.getUdidocByCode("BD.BL.1020", emsDrugsSrvDTO.getSd_hpsrvtp());
			srvdo.setId_hpsrvtp(udidoc.getId_udidoc());
		}
		srvdo.setFg_selfpay(new FBoolean(emsDrugsSrvDTO.getFg_selfpay()));
		srvdo.setFg_specill(new FBoolean(emsDrugsSrvDTO.getFg_specill()));
		srvdo.setFg_research(new FBoolean(emsDrugsSrvDTO.getFg_research()));

		// 科研项目产品还没有这个逻辑，后面可以添加
		if (StringUtils.isNotEmpty(emsDrugsSrvDTO.getCode_dep_mp_srv())) {
			DeptDO mpdept = DeptUtils.getDeptByCode(emsDrugsSrvDTO.getCode_dep_mp_srv());
			if (mpdept != null) {
				srvdo.setId_dep_mp(mpdept.getId_dep());
			}
		}
		// srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdo.getId_dep_mp()));
		srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		srvdo.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);
		srvdo.setId_en(entdo.getId_ent());
		srvdo.setId_hp(entHpdo.getId_hp());
		return srvdo;
	}

	private CiorderAggDO assebleOrderAgg(EmsApbtOrdDTO emsapbtordDTO) throws BizException {
		CiorderAggDO aggdo = assebleOrderAggSuper(emsapbtordDTO);
		CiOrderDO ciOrderDO = aggdo.getParentDO();
		// 医嘱频次
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
			// 服务数量
			srv.setQuan_medu(new FDouble(emsapbtordDTO.getQuan_medu_bt()));
			// 总量 频次为1 故总量和单个数量一致
			srv.setQuan_total_medu(srv.getQuan_medu());
		}
		// 组装处置内容
		assembleContent_or(aggdo);

		ciOrderDO.setSd_orsrcfun(ICiDictCodeConst.SD_ORDSRCFUN_DOC);// 医嘱来源功能sd
		ciOrderDO.setId_orsrcfun(ICiDictCodeConst.ID_ORDSRCFUN_DOC);// 医嘱来源功能id
		return aggdo;

	}

	private CiorderAggDO assebleOrderAggSuper(EmsApbtOrdDTO emsapbtordDTO) throws BizException {
		CiorderAggDO aggdo = new CiorderAggDO();
		List<EmsApbtSrvDTO> drugssrvs = (List<EmsApbtSrvDTO>)emsapbtordDTO.getSrvlist();
		CiOrderDO order = assembleOrderSuper(emsapbtordDTO);

		aggdo.setParent(order);
			List<OrdSrvDO> srvdos = asssembleSrv(drugssrvs, order);
			// 通过服务完善医嘱信息
			OrdSrvDO srvdo = srvdos.get(0);
			assembleOrderFromSrv(order, srvdo);
			aggdo.setOrdSrvDO(srvdos.toArray(new OrdSrvDO[0]));
		assembleContent_or(aggdo);
		return aggdo;
	}

	private void assembleOrderFromSrv(CiOrderDO order, OrdSrvDO srvdo) throws BizException {
		if(StringUtils.isEmpty(order.getId_srv())){
			order.setId_srv(srvdo.getId_srv());
			order.setId_srvtp(srvdo.getId_srvtp());
			order.setSd_srvtp(srvdo.getSd_srvtp());
			order.setId_srvca(srvdo.getId_srvca());
			order.setId_srv(srvdo.getId_srv());
			order.setName_or(srvdo.getName());
			order.setId_unit_med(srvdo.getId_medu());
			order.setQuan_medu(srvdo.getQuan_medu());
		}
		order.setFg_mp_in(ThirdInfoUtils.JudgeFgMpIn(order.getCode_entp(), order.getSd_srvtp()));
		if (order.getFg_mp_in()!=null) {
			if (order.getFg_mp_in().booleanValue()) {
				order.setTimes_mp_in(order.getTimes_cur());
			}
		}
		SrvMatchEmsParamDTO srvMatchEmsParamDTO = new SrvMatchEmsParamDTO();
		srvMatchEmsParamDTO.setId_srv(order.getId_srv());
		srvMatchEmsParamDTO.setCode_entp(order.getCode_entp());
		srvMatchEmsParamDTO.setId_emp(order.getId_emp_or());
		srvMatchEmsParamDTO.setId_dept(order.getId_dep_or());
		srvMatchEmsParamDTO.setId_org(order.getId_org());
		srvMatchEmsParamDTO.setId_grp(order.getId_grp());
		srvMatchEmsParamDTO.setSd_srvtp(order.getSd_srvtp());
		srvMatchEmsParamDTO.setDt_or(order.getDt_effe());
		srvMatchEmsParamDTO.setEmsappmode(EmsAppModeEnum.SVEMSAPPMODE);
		IEmsManagementService emsManagementService = ServiceFinder.find(IEmsManagementService.class);
		// 调用匹配医疗单算法服务
		FMap rstMap = emsManagementService.medSrvMatchEms(new SrvMatchEmsParamDTO[] { srvMatchEmsParamDTO });
		SrvMatchEmsRstDTO emsrstdto = (SrvMatchEmsRstDTO) rstMap.get(order.getId_srv());
		if (emsrstdto != null) {
			order.setId_srvof(emsrstdto.getId_ems());
			order.setFg_quickwflow(emsrstdto.getFg_quickwflow());
			order.setFuncclassstr(emsrstdto.getFuncclassstr());
		}else {			
			throw new BizException("没有匹配到医疗单");
		}
	}

	private CiOrderDO assembleOrderSuper(EmsApbtOrdDTO orddto) throws BizException {
		CiOrderDO ordo = new CiOrderDO();
		ordo.setStatus(DOStatus.NEW);
		String[] id_ors = new DBUtil().getOIDs(1);
		ordo.setId_or(id_ors[0]);
		
		ICIOrdRService ciOrdRService = ServiceFinder.find(ICIOrdRService.class);
		Integer result = ciOrdRService.getOrdMaxSortno(entdo.getId_ent());
		ordo.setSortno(++result);
		
		// 草药是否院内制剂
		ordo.setFg_hospital_herbpres(FBoolean.FALSE);
		ordo.setId_grp(entdo.getId_grp());
		ordo.setId_org(entdo.getId_org());
		ordo.setId_pat(entdo.getId_pat());
		ordo.setId_en(entdo.getId_ent());
		ordo.setId_entp(entdo.getId_entp());
		ordo.setCode_entp(entdo.getCode_entp());
		// 取第一个服务然后补齐
		ordo.setFg_set(FBoolean.FALSE);
		ordo.setFg_orhp(FBoolean.FALSE);
	
		if(StringUtils.isNotEmpty(orddto.getCode_or())){
			ordo.setCode_or(orddto.getCode_or());
		}else{
			ordo.setCode_or(orddto.getCode_or());
		}
		ordo.setDes_or(orddto.getDes_or());
		ordo.setFg_sign(FBoolean.TRUE);
		ordo.setId_su_or(ICiDictCodeConst.SD_SU_ID_SIGN);
		ordo.setSd_su_or(ICiDictCodeConst.SD_SU_SIGN);
		ordo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		ordo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		ordo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		ordo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		if (StringUtils.isNotEmpty(orddto.getCode_dep_or())) {
			DeptDO dept_or = DeptUtils.getDeptByCode(orddto.getCode_dep_or());
			if (dept_or != null) {
				ordo.setId_dep_or(dept_or.getId_dep());
			}
		}
		ordo.setId_dep_sign(ordo.getId_dep_or());
		//执行科室
		if(StringUtils.isNotEmpty(orddto.getCode_dep_mp_or())){
			DeptDO dept_mp = DeptUtils.getDeptByCode(orddto.getCode_dep_mp_or());
			if (dept_mp != null) {
				ordo.setId_dep_mp(dept_mp.getId_dep());
			}
		}
		ordo.setId_org_or(ThirdInfoUtils.getOrgOfDept(ordo.getId_dep_or()));
		// ordo.setId_wg_or(ems.getId_wg_or());没有
		if (StringUtils.isNotEmpty(orddto.getCode_emp_or())) {
			PsnDocDO psndoc = PsndocUtils.getPsnDocByCode(orddto.getCode_emp_or());
			if (psndoc != null) {
				ordo.setId_emp_or(psndoc.getId_psndoc());
			}
		}

		ordo.setId_emp_sign(ordo.getId_emp_or());
		if (StringUtils.isNotEmpty(orddto.getDt_entry_or())) {
			ordo.setDt_entry(new FDateTime(orddto.getDt_entry_or()));
		} else {
			ordo.setDt_entry(ThirdInfoUtils.getServerDateTime());
		}
		ordo.setDt_sign(ordo.getDt_entry());
		ordo.setDt_effe(ordo.getDt_entry());
		if(ordo.getDays_or() == null)
			ordo.setDays_or(1);
		if (ordo.getDays_or() != null) {
			ordo.setDt_end(ordo.getDt_effe().getDateTimeAfter(ordo.getDays_or()));
		}
		ordo.setDt_last_mp(ordo.getDt_effe());
		ordo.setDt_last_bl(ordo.getDt_effe());
		ordo.setFg_chk(ThirdInfoUtils.nullHandle(null));

		ordo.setFg_chk_stop(ThirdInfoUtils.nullHandle(null));
		ordo.setFg_canc(ThirdInfoUtils.nullHandle(null));
		ordo.setFg_chk_canc(ThirdInfoUtils.nullHandle(null));
		ordo.setFg_pmor(FBoolean.FALSE);
		ordo.setDes_pmor(null);
		ordo.setFg_active_pm(FBoolean.FALSE);
		ordo.setFg_ctlcp(null);
		ordo.setFg_mr(null);
		// 取第一个服务项目后再计算
		// ordo.setFg_mp_in(CiOrdUtils.JudgeFgMpIn(ordo.getCode_entp(),ordo.getSd_srvtp()));
		ordo.setFg_pres_outp(null);
		ordo.setFg_mp_bed(null);
		ordo.setNote_or(orddto.getDes_or());
		// 诊疗医嘱需要保存
		// ordo.setApplyno(ems.getApplyno());
		AuditInfoUtil.addData(ordo);// 设置设计信息
		ordo.setFg_skintest(null);
		ordo.setFg_feertnable(FBoolean.TRUE); // 可退费标识

		// 添加字段 医嘱来源
		ordo.setFg_uncancelable(FBoolean.FALSE);// 医嘱执行不可逆标识
		ordo.setEu_orsrcmdtp(OrSourceFromEnum.THIRDPARTYSYS);
		// 第三方调用医嘱，保存医嘱医生站
		ordo.setId_orsrcfun(ICiDictCodeConst.ID_ORDSRCFUN_MT);
		ordo.setSd_orsrcfun(ICiDictCodeConst.SD_ORDSRCFUN_MT);

		ordo.setFg_vip(entdo.getFg_ip());// vip号
		// 诊断信息
		// ordo.setId_didef(ems.getId_didef());
		// ordo.setCode_didef(ems.getCode_didef());
		// ordo.setName_didef(ems.getName_didef());
		if (StringUtils.isNotEmpty(orddto.getCode_srv_or())) {
			IMedsrvMDORService service = ServiceFinder.find(IMedsrvMDORService.class);
			MedSrvDO[] medsrvs = service.findByAttrValStrings(MedSrvDO.CODE,new String[]{orddto.getCode_srv_or()});
			if(medsrvs!=null&&medsrvs.length>0){
				MedSrvDO medsrv = medsrvs[0];
				ordo.setId_srv(medsrv.getId_srv());
				ordo.setId_srvtp(medsrv.getId_srvtp());
				ordo.setSd_srvtp(medsrv.getSd_srvtp());
				ordo.setId_srvca(medsrv.getId_srvca());
				ordo.setName_or(medsrv.getName());
				ordo.setId_unit_med(medsrv.getId_unit_med());
			}
		}
		ordo.setStatus(DOStatus.NEW);
		return ordo;
	}

	private void assembleContent_or(CiorderAggDO agg) {
		CiOrderDO orderDO = agg.getParentDO();
		StringBuilder stringBuilder=new StringBuilder();
		//查询所关联的备血的名字 
		String id_or_rel=orderDO.getId_or_rel();
		try {
			CiOrderDO ciOrderDO=CiorderUtils.getCiOrderDO(CiOrderDO.ID_OR,id_or_rel);
			stringBuilder.append("输"+(ciOrderDO==null?orderDO.getName_or():ciOrderDO.getName_or())+orderDO.getQuan_medu()+"次");
			String string=ThirdInfoUtils.create(orderDO.getSd_srvtp(), stringBuilder.toString(), orderDO.getRoute_name(), FBoolean.FALSE)
					.toString();
			System.out.println("content_or:----"+string+"---------");
			orderDO.setContent_or(string);
		} catch (BizException e) {
			e.printStackTrace();
		}
	}

	private CiOrderDO assembleOrder(EmsApbtOrdDTO orddto) throws BizException {
		CiOrderDO ordo = new CiOrderDO();
		ordo.setStatus(DOStatus.NEW);
		String[] id_ors = new DBUtil().getOIDs(1);
		ordo.setId_or(id_ors[0]);

		ICIOrdRService ciOrdRService = ServiceFinder.find(ICIOrdRService.class);
		Integer result = ciOrdRService.getOrdMaxSortno(entdo.getId_ent());
		ordo.setSortno(++result);

		// 草药是否院内制剂
		ordo.setFg_hospital_herbpres(FBoolean.FALSE);
		ordo.setId_grp(entdo.getId_grp());
		ordo.setId_org(entdo.getId_org());
		ordo.setId_pat(entdo.getId_pat());
		ordo.setId_en(entdo.getId_ent());
		ordo.setId_entp(entdo.getId_entp());
		ordo.setCode_entp(entdo.getCode_entp());
		// 取第一个服务然后补齐
		ordo.setFg_set(FBoolean.FALSE);
		ordo.setFg_orhp(FBoolean.FALSE);
		ordo.setFg_sign(FBoolean.TRUE);
		ordo.setId_su_or(ICiDictCodeConst.SD_SU_ID_SIGN);
		ordo.setSd_su_or(ICiDictCodeConst.SD_SU_SIGN);
		ordo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		ordo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		ordo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		ordo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		if (StringUtils.isNotEmpty(orddto.getCode_dep_or())) {
			DeptDO dept_or = DeptUtils.getDeptByCode(orddto.getCode_dep_or());
			if (dept_or != null) {
				ordo.setId_dep_or(dept_or.getId_dep());
			}
		}
		ordo.setId_dep_sign(ordo.getId_dep_or());
		// 执行科室
		if (StringUtils.isNotEmpty(orddto.getCode_dep_mp_or())) {
			DeptDO dept_mp = DeptUtils.getDeptByCode(orddto.getCode_dep_mp_or());
			if (dept_mp != null) {
				ordo.setId_dep_mp(dept_mp.getId_dep());
			}
		}
		// ordo.setId_org_or(CiOrdUtils.getOrgOfDept(ordo.getId_dep_or()));
		if (StringUtils.isNotEmpty(orddto.getCode_emp_or())) {
			PsnDocDO psndoc = PsndocUtils.getPsnDocByCode(orddto.getCode_emp_or());
			if (psndoc != null) {
				ordo.setId_emp_or(psndoc.getId_psndoc());
			}
		}

		ordo.setId_emp_sign(ordo.getId_emp_or());
		if (StringUtils.isNotEmpty(orddto.getDt_entry_or())) {
			ordo.setDt_entry(new FDateTime(orddto.getDt_entry_or()));
		} else {
			// ordo.setDt_entry(CiOrdAppUtils.getServerDateTime());
		}
		ordo.setDt_sign(ordo.getDt_entry());
		ordo.setDt_effe(ordo.getDt_entry());
		if (ordo.getDays_or() != null) {
			ordo.setDt_end(ordo.getDt_effe().getDateTimeAfter(ordo.getDays_or()));
		}
		ordo.setDt_last_mp(ordo.getDt_effe());
		ordo.setDt_last_bl(ordo.getDt_effe());
		ordo.setFg_pmor(FBoolean.FALSE);
		ordo.setDes_pmor(null);
		ordo.setFg_active_pm(FBoolean.FALSE);
		ordo.setFg_ctlcp(null);
		ordo.setFg_mr(null);
		// 取第一个服务项目后再计算
		ordo.setFg_pres_outp(null);
		ordo.setFg_mp_bed(null);
		ordo.setNote_or(orddto.getDes_or());
		// 诊疗医嘱需要保存
		AuditInfoUtil.addData(ordo);// 设置设计信息
		ordo.setFg_skintest(null);
		ordo.setFg_feertnable(FBoolean.TRUE); // 可退费标识

		// 添加字段 医嘱来源
		ordo.setFg_uncancelable(FBoolean.FALSE);// 医嘱执行不可逆标识
		ordo.setEu_orsrcmdtp(OrSourceFromEnum.THIRDPARTYSYS);
		// 第三方调用医嘱，保存医嘱医生站
		ordo.setId_orsrcfun(ICiDictCodeConst.ID_ORDSRCFUN_MT);
		ordo.setSd_orsrcfun(ICiDictCodeConst.SD_ORDSRCFUN_MT);

		ordo.setFg_vip(entdo.getFg_ip());// vip号
		if (StringUtils.isNotEmpty(orddto.getCode_srv_or())) {
			IMedsrvMDORService service = ServiceFinder.find(IMedsrvMDORService.class);
			MedSrvDO[] medsrvs = service.findByAttrValStrings(MedSrvDO.CODE, new String[] { orddto.getCode_srv_or() });
			if (medsrvs != null && medsrvs.length > 0) {
				MedSrvDO medsrv = medsrvs[0];
				ordo.setId_srv(medsrv.getId_srv());
				ordo.setId_srvtp(medsrv.getId_srvtp());
				ordo.setSd_srvtp(medsrv.getSd_srvtp());
				ordo.setId_srvca(medsrv.getId_srvca());
				ordo.setName_or(medsrv.getName());
				ordo.setId_unit_med(medsrv.getId_unit_med());
			}
		}
		ordo.setStatus(DOStatus.NEW);
		return ordo;
	}

	/**
	 * 组装服务，需要子类实现
	 * 
	 * @param drugssrvs
	 * @param order
	 * @return
	 * @throws BizException
	 */
	public List<OrdSrvDO> asssembleSrv(List<EmsApbtSrvDTO> drugssrvs, CiOrderDO order) throws BizException {
		List<OrdSrvDO> srvdos = new ArrayList<OrdSrvDO>();
		List<String> code_srvs = new ArrayList<String>();
		List<String> id_srvs = new ArrayList<String>();
		if (drugssrvs != null) {
			for (EmsApbtSrvDTO emsDrugsSrvDTO : drugssrvs) {
				String code_srv = emsDrugsSrvDTO.getCode_srv();
				if (code_srv == null || code_srv.trim().length() == 0)
					continue;
				code_srvs.add(code_srv);
			}
		}

		// 如果医嘱的服务id_srv不为空，并且在费用项目中不存在，需要将医嘱的服务编码对应的服务，存入到ci_or_srv表中
		if (StringUtils.isNotEmpty(order.getId_srv()) && !id_srvs.contains(order.getId_srv())) {
			OrdSrvDO srvdo = asssembleSrv(order);
			srvdos.add(srvdo);
		}
		return srvdos;
	}

	private OrdSrvDO asssembleSrv(CiOrderDO order) throws BizException {
		IMedsrvMDORService service = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO medsrv = service.findById(order.getId_srv());
		OrdSrvDO srvdo = new OrdSrvDO();
		String[] id_orsrv = new DBUtil().getOIDs(1);
		srvdo.setId_orsrv(id_orsrv[0]);
		srvdo.setStatus(DOStatus.NEW);
		srvdo.setId_pat(entdo.getId_pat());
		srvdo.setId_en(entdo.getId_ent());
		srvdo.setId_entp(entdo.getId_entp());
		srvdo.setCode_entp(entdo.getCode_entp());
		// srvdo.setDt_create(CiOrdAppUtils.getServerDateTime());
		srvdo.setId_pripat(entdo.getId_pripat());
		srvdo.setId_grp(entdo.getId_grp());
		srvdo.setId_org(entdo.getId_org());
		srvdo.setSortno(0);

		// srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(order.getId_dep_mp()));
		srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		srvdo.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);
		srvdo.setId_en(entdo.getId_ent());
		srvdo.setId_hp(entHpdo.getId_hp());

		srvdo.setId_srv(medsrv.getId_srv());
		srvdo.setSd_srvtp(medsrv.getSd_srvtp());
		srvdo.setId_srvtp(medsrv.getId_srvtp());
		srvdo.setCode_srv(medsrv.getCode());
		srvdo.setId_srvca(medsrv.getId_srvca());
		srvdo.setName(medsrv.getName());
		srvdo.setId_primd(medsrv.getId_primd());
		srvdo.setFg_bl(medsrv.getFg_bl());
		srvdo.setFg_or(medsrv.getFg_or());
		srvdo.setName(medsrv.getName());
		srvdo.setName_srv(medsrv.getName());

		srvdo.setId_or(order.getId_or());
		srvdo.setDt_last_bl(order.getDt_effe());
		srvdo.setDt_last_mp(order.getDt_effe());
		srvdo.setId_route(order.getId_route());
		srvdo.setId_freq(order.getId_freq());
		// 开立相关信息 从ciorder获取
		srvdo.setId_org_srv(order.getId_org_or());// 开立机构
		srvdo.setId_dep_srv(order.getId_dep_or());// 开立科室
		srvdo.setId_wg_or(order.getId_wg_or());// 开立医疗组
		srvdo.setId_emp_srv(order.getId_emp_or());// 开立医生
		srvdo.setDt_create(order.getDt_entry());// 开始时间
		srvdo.setId_dep_mp(order.getId_dep_mp());
		srvdo.setQuan_medu(order.getQuan_medu());
		srvdo.setQuan_total_medu(order.getQuan_medu());
		srvdo.setId_medu(order.getId_unit_med());
		srvdo.setMedu_name(order.getName_unit_med());
		return srvdo;
	}
}
