package iih.ci.ord.s.ems.ip.ems.opr;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.dto.d.EmsDynamicParamDTO;
import iih.bd.srv.ems.d.EmsDynamicIndexDTO;
import iih.bd.srv.ems.d.EmsregistryAggDO;
import iih.bd.srv.ems.i.IEmsregistryRService;
import iih.bd.srv.i.IBdSrvQryService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvOpDO;
import iih.bd.srv.medsrv.i.IMedSrvOpDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.cior.d.OrdApSugViewItemDO;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.dws.ip.ems.d.EmsOprEmpDTO;
import iih.ci.ord.dws.ip.ems.d.EmsOprViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.cache.BDEmsInfoCache;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsCreateBP;
import iih.ci.ord.s.ems.utils.OrderEmsDtUtils;
import iih.ci.ord.s.ems.utils.OrderEmsPriceUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 手术医疗单创建逻辑
 * 
 * @author Young
 *
 */
public class EmsOprCreateBP extends BaseIpEmsCreateBP {
	@Override
	public EmsRstDTO[] create(CiEnContextDTO ctx, EmsCrtDTO[] emsCrtDTOs) throws BizException {
		EmsCrtDTO emsCrtDTO = emsCrtDTOs[0];
		EmsRstDTO emsRstDTO = new EmsRstDTO();

		MedSrvDO medSrvDO = ServiceFinder.find(IMedsrvMDORService.class).findById(emsCrtDTO.getId_srv());
		if (medSrvDO == null) {
			FArrayList errorEmsList = new FArrayList();
			errorEmsList.append("查询主服务信息失败！");
			emsRstDTO.setErrorEmsList(errorEmsList);
			return new EmsRstDTO[] { emsRstDTO };
		}

		EmsOprViewDTO cacheEmsViewDTO = BDEmsInfoCache.GetCache(ctx, emsCrtDTO.getDriverInfo().getId_ems(),
				emsCrtDTO.getId_srv());
		EmsOprViewDTO emsViewDTO = null;
		if (null == cacheEmsViewDTO) {
			emsViewDTO = emsModelFrom(ctx, medSrvDO, emsCrtDTO);
			if (emsViewDTO == null) {
				FArrayList errorEmsList = new FArrayList();
				errorEmsList.append(String.format("没有查到【%s】服务的属性信息", medSrvDO.getName()));
				emsRstDTO.setErrorEmsList(errorEmsList);
				return new EmsRstDTO[] { emsRstDTO };
			}
			BDEmsInfoCache.PutCache(ctx, emsCrtDTO.getDriverInfo().getId_ems(),
					emsCrtDTO.getId_srv(),emsViewDTO);
		}else{
			emsViewDTO = (EmsOprViewDTO)cacheEmsViewDTO.clone();
		}

		// 处理特殊场景的频次数据
		handleMtOrderInfo(ctx, emsViewDTO);

		this.calcOrderWfDeptInfo(ctx, medSrvDO, emsViewDTO);
		this.setOrdDeptEmpInfo(ctx, emsViewDTO);

		emsViewDTO.setDt_effe(OrderEmsDtUtils.GetEffeDateTime(ctx.getId_en(), ctx.getDt_open()));// 开始时间赋值
		// 医嘱编码
//		emsViewDTO.setCode_or(
//				CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(CiOrderDODesc.CLASS_FULLNAME));
		emsViewDTO.setCode_or(CiOrdAppUtils.getCiOrdQryService().getCodeOr());
		// 非物品单价
		emsViewDTO.setPri(OrderEmsPriceUtils.calculatePrice(medSrvDO, ctx.getId_pripat()));

		//
		this.handleDefaultInfo(emsCrtDTO, emsViewDTO);
		
		emsViewDTO.setStatus(DOStatus.NEW);
		setEmsDriverInfo(emsCrtDTO.getDriverInfo(), emsViewDTO);
		emsRstDTO.setDocument(this.handleReturnDocument(emsViewDTO));
		return new EmsRstDTO[] { emsRstDTO };
	}

	/**
	 * 创建主模型对象
	 * 
	 * @param medSrv
	 * @return
	 * @throws BizException
	 */
	protected EmsOprViewDTO emsModelFrom(CiEnContextDTO ctx, MedSrvDO medSrv, EmsCrtDTO emsCrtDTO) throws BizException {
		MedSrvOpDO[] medSrvOpDOs = ServiceFinder.find(IMedSrvOpDORService.class)
				.find(String.format("a3.id_srv='%s'", medSrv.getId_srv()), "", FBoolean.FALSE);
		if (medSrvOpDOs == null || medSrvOpDOs.length <= 0) {
			return null;
		}
		MedSrvOpDO medSrvOpDO = medSrvOpDOs[0];
		FDateTime dt = CiOrdAppUtils.getServerDateTime();

		EmsOprViewDTO emsOpsViewDTO = new EmsOprViewDTO();
		this.orderListViewInfoFrom(ctx, medSrv, emsCrtDTO.getDriverInfo(), emsOpsViewDTO);

		// emsOpsViewDTO.setId_anestp(Id_anestp);//麻醉方式ID
		// emsOpsViewDTO.setSd_anestp(Sd_anestp);//麻醉方式编码
		// emsOpsViewDTO.setName_anestp(Name_anestp);//麻醉方式
		emsOpsViewDTO.setId_datelimittype(ICiDictCodeConst.ID_OPDATE_LIMITTP_ZQ);
		;// 手术时限
		emsOpsViewDTO.setSd_datelimittype(ICiDictCodeConst.SD_OPDATE_LIMITTP_ZQ);// 手术时限
		emsOpsViewDTO.setName_datelimittype(ICiDictCodeConst.NAME_OPDATE_LIMITTP_ZQ);// 手术时限

		emsOpsViewDTO.setDt_plan(dt);// 计划手术时间
		emsOpsViewDTO.setNo_applyform(CiOrdUtils.getApplyNo(emsOpsViewDTO.getSd_srvtp()));// 手术单号
		// emsOpsViewDTO.setId_opex_srvs(Id_opex_srvs);//附加手术ID
		// emsOpsViewDTO.setCode_opex_srvs(Code_opex_srvs);//附加手术编码
		// emsOpsViewDTO.setName_opex_srvs(Name_opex_srvs);//附加手术
		emsOpsViewDTO.setId_lvlsug(medSrvOpDO.getId_opclass());// 手术级别ID
		emsOpsViewDTO.setSd_lvlsug(medSrvOpDO.getSd_opclass());// 手术级别编码
		emsOpsViewDTO.setName_lvlsug(medSrvOpDO.getName_opclass());// 手术级别
		// emsOpsViewDTO.setId_emp_operator(Id_emp_operator);//主刀医师ID
		// emsOpsViewDTO.setName_emp_operator(Name_emp_operator);//主刀医师
		// emsOpsViewDTO.setId_emp_helper(Id_emp_helper);//第一助手ID
		// emsOpsViewDTO.setName_emp_helper(Name_emp_helper);//第一助手
		emsOpsViewDTO.setFg_patho(FBoolean.TRUE);// 冰冻处理标识
		emsOpsViewDTO.setFg_allergy(FBoolean.FALSE);// 药物过敏标识
		// emsOpsViewDTO.setQuan_bt_paln(Quan_bt_paln);//预期输血量
		// emsOpsViewDTO.setAnnouncements(Announcements);//注意事项
		// emsOpsViewDTO.setDes_or(Des_or);//描述
		// emsOpsViewDTO.setEu_anseca(Eu_anseca);//麻醉分类
		emsOpsViewDTO.setTimes_cur(1);

		// 默认添加主刀医师和第一助手
		FArrayList emsOpsEmpDTOs = new FArrayList();
		for (int i = 0; i < 2; i++) {
			EmsOprEmpDTO emsOpsEmpDTO = new EmsOprEmpDTO();
			emsOpsEmpDTO.setId_role(i < 1 ? ICiDictCodeConst.ID_OP_ROLE_SURG : ICiDictCodeConst.ID_OP_ROLE_FIRST);
			emsOpsEmpDTO.setSd_role(i < 1 ? ICiDictCodeConst.SD_OP_ROLE_SURG : ICiDictCodeConst.SD_OP_ROLE_FIRST);
			emsOpsEmpDTO.setName_role(i < 1 ? ICiDictCodeConst.NAME_OP_ROLE_SURG : ICiDictCodeConst.NAME_OP_ROLE_FIRST);
			emsOpsEmpDTO.setSortno(i + 1);
			emsOpsEmpDTOs.append(emsOpsEmpDTO);
		}
		emsOpsViewDTO.setExtInfoList(emsOpsEmpDTOs);// 手术人员集合

		// 动态指标
		if (null != emsCrtDTO.getDriverInfo()) {
			emsOpsViewDTO.setExtInfoList(this.getOrdApSugViewItemDOs(ctx, emsCrtDTO.getDriverInfo().getId_ems()));
		}

		return emsOpsViewDTO;
	}

	/**
	 * 获取动态指标集合
	 * 
	 * @param ctx
	 * @param id_srvof
	 * @return
	 * @throws BizException
	 */
	protected FArrayList getOrdApSugViewItemDOs(CiEnContextDTO ctx, String id_srvof) throws BizException {
		EmsregistryAggDO emsRegAggDO = ServiceFinder.find(IEmsregistryRService.class).findById(id_srvof);
		if (emsRegAggDO == null || emsRegAggDO.getParentDO() == null) {
			return null;
		}

		EmsDynamicParamDTO paramDTO = new EmsDynamicParamDTO();
		paramDTO.setId_ems(id_srvof);
		paramDTO.setId_ent(ctx.getId_en());
		paramDTO.setId_pat(ctx.getId_pat());
		paramDTO.setFg_dyncitm_en(emsRegAggDO.getParentDO().getFg_dyncitm_crossentp().booleanValue());
		paramDTO.setEu_dyncitmunit(emsRegAggDO.getParentDO().getEu_dyncitmunit());
		paramDTO.setDyncitmunitct(emsRegAggDO.getParentDO().getCnt_dyncitmunit());

		EmsDynamicIndexDTO[] dtos = ServiceFinder.find(IBdSrvQryService.class).getEmsDynamicIndexInfos(paramDTO);
		FArrayList rstList = new FArrayList();
		for (EmsDynamicIndexDTO dto : dtos) {
			OrdApSugViewItemDO item = new OrdApSugViewItemDO();
			item.setVal_rstrptla(dto.getIndexval() == null ? "" : dto.getIndexval());
			item.setVal_restrptlab(dto.getEnumvalues() == null ? "" : "|" + dto.getEnumvalues().replace(',', '|'));
			item.setSd_restrptlabtp(dto.getDatatype());
			item.setId_srv(dto.getId_srv());
			item.setName_srv(dto.getShowname());
			item.setId_unit(dto.getId_unit());
			item.setName_unit(dto.getUnitname());
			item.setStatus(DOStatus.NEW);
			rstList.append(item);
		}

		return rstList;
	}
}
