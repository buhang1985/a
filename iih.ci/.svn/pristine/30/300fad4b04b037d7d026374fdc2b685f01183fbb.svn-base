package iih.ci.ord.s.external.thirdws.op.opr;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.cior.d.CiorappsurgeryAggDO;
import iih.ci.ord.cior.d.OrdApOpDO;
import iih.ci.ord.cior.d.OrdOpEmpDO;
import iih.ci.ord.cior.i.ICiorappsurgeryCudService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderCudService;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.external.thirdws.base.EmsCommonOrdDTO;
import iih.ci.ord.i.external.thirdws.base.EmsCommonSrvDTO;
import iih.ci.ord.i.external.thirdws.base.EmsRstDTO;
import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.i.external.thirdws.opr.d.EmsOprAddDTO;
import iih.ci.ord.i.external.thirdws.opr.d.EmsOprOrdDTO;
import iih.ci.ord.i.external.thirdws.opr.d.EmsOprPerDTO;
import iih.ci.ord.i.external.thirdws.opr.d.EmsOprSrvDTO;
import iih.ci.ord.i.external.thirdws.opr.d.EntWsOprDTO;
import iih.ci.ord.s.ems.orcontent.CiOrContentUtils;
import iih.ci.ord.s.ems.orcontent.meta.OPOprOrContentParam;
import iih.ci.ord.s.external.blood.ruimei.s.bp.ConvertDTOs2XmlUtils;
import iih.ci.ord.s.external.thirdws.base.BaseOrdWsCtxSaveBP;
import iih.ci.ord.s.external.thirdws.utils.UdidocUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 手术医嘱保存
 * @author HUMS
 *
 */
public class EmsOprSaveAction extends BaseOrdWsCtxSaveBP {
	
	@Override
	protected void resetCtxInfo(CiEnContextDTO ctx, Object obj) throws BizException {
		EmsOprOrdDTO emsOprOrd = (EmsOprOrdDTO) obj;

		DeptDO depOr = this.getDeptByCode(emsOprOrd.getCode_dep_or());

		ctx.setId_dep_or(depOr.getId_dep());
		ctx.setName_dep_or(depOr.getName());

		PsnDocDO psndoc = this.getPsndocByCode(emsOprOrd.getCode_emp_or());
		ctx.setId_emp_or(psndoc.getId_psndoc());
		ctx.setCode_emp_or(psndoc.getCode());
		ctx.setName_emp_or(psndoc.getName());

		ctx.setTel_dep_or(depOr.getTel());
		ctx.setAddr_dep_or(depOr.getId_plc());
		// ctx.setId_wg_or(id_wg_or);

		UserDO user = this.getUserByIdPsn(psndoc.getId_psndoc());
		ctx.setId_user(user.getId_user());
		ctx.setName_user(user.getName());
		ctx.setId_psndoc(psndoc.getId_psndoc());
		ctx.setCode_psndoc(psndoc.getCode());
		ctx.setName_psndoc(psndoc.getName());
		// ctx.setDiagitemlist(diagitemlist);
	}
	
	@Override
	public String save(EntWsDTO entWs) throws BizException {
		// 父类保存
		super.save(entWs);

		CiEnContextDTO ctx = this.getWsEnContext(entWs);

		EntWsOprDTO entWsOpr = (EntWsOprDTO) entWs;

		// 医嘱集合
		List<CiorderAggDO> orderAggList = new ArrayList<CiorderAggDO>();
		// 手术申请单集合
		List<CiorappsurgeryAggDO> ordApOpAggList = new ArrayList<CiorappsurgeryAggDO>();
		
		List<EmsOprOrdDTO> emsOprOrdList = entWsOpr.getOrdList();

		for (EmsOprOrdDTO emsOprOrd : emsOprOrdList) {

			this.resetCtxInfo(ctx, emsOprOrd);

			// 医嘱和服务的主子关系都在这方法里
			CiorderAggDO orderAgg = this.assebleOrderAgg(emsOprOrd);
			orderAggList.add(orderAgg);

			List<OrdSrvDO> ordSrvList = new ArrayList<OrdSrvDO>();
			/*OrdSrvDO mainSrv = this.getMainSrvInfo(ctx, orderAgg,emsOprOrd);
			ordSrvList.add(mainSrv);*/
			// 附件手术集合
			List<OrdSrvDO> addOrdSrvList = this.getAdditionalOpr(ctx, orderAgg, emsOprOrd.getAddList());
			ordSrvList.addAll(addOrdSrvList);
			OrdSrvDO[] ordSrvs = orderAgg.getOrdSrvDO();
			
			if(ordSrvs != null && ordSrvs.length >0){
				for(OrdSrvDO ordSrv : ordSrvs){
					ordSrvList.add(ordSrv);
				}
			}			
			
			for(int i=0;i<ordSrvList.size();i++){
				ordSrvList.get(i).setSortno(i+1);
			}
			orderAgg.setOrdSrvDO(ordSrvList.toArray(new OrdSrvDO[ordSrvList.size()]));

			// 构造申请单
			
			CiorappsurgeryAggDO surgeryAgg = this.getSurgeryAggInfo(ctx, orderAgg, emsOprOrd);
			ordApOpAggList.add(surgeryAgg);
		}

		EmsRstDTO emsRst =  this.saveOrderAgg(orderAggList,ordApOpAggList);
		
 		ConvertDTOs2XmlUtils util = new ConvertDTOs2XmlUtils();
		//返回XML
		return util.exec(new EmsRstDTO[]{emsRst}, "rst", "");
		
	}
	
	/**
	 * 组装处置内容
	 */
	@Override
	protected void assembleContent_or(CiorderAggDO agg) {
		
		CiOrderDO orderDO = agg.getParentDO();
		
		OPOprOrContentParam param = new OPOprOrContentParam();
		param.setSd_srvtp(orderDO.getSd_srvtp());
		param.setName_srv(orderDO.getName_or());
		param.setNote(orderDO.getDes_or());
		param.setPri(StringUtils.isEmpty(orderDO.getOr_total_pri())?null : new FDouble(orderDO.getOr_total_pri()));
		param.setFg_urgent(orderDO.getFg_urgent());
		
		CiOrContentDO orContent = CiOrContentUtils.create(param);
		
		System.out.println("content_or:----"+orContent.toString()+"---------");
		orderDO.setContent_or(orContent.toString());
	}
	
	/**
	 * 保存数据
	 * @param orderAggList
	 * @param ordApOpAggList
	 * @throws BizException
	 */
	public EmsRstDTO saveOrderAgg(List<CiorderAggDO> orderAggList ,List<CiorappsurgeryAggDO> ordApOpAggList) throws BizException{
		
		EmsRstDTO retdto = new EmsRstDTO();
 		try {
 			//保存医嘱和服务
 			ICiorderCudService service = ServiceFinder.find(ICiorderCudService.class);
 			CiorderAggDO[] dos = service.save(orderAggList.toArray(new CiorderAggDO[orderAggList.size()]));
 			
 			ICiorappsurgeryCudService surgeryService = ServiceFinder.find(ICiorappsurgeryCudService.class);
 			surgeryService.save(ordApOpAggList.toArray(new CiorappsurgeryAggDO[ordApOpAggList.size()]));
 	 		//发送事件
 	 		this.fireSignEvent(dos);
 	 		retdto.setResultcode("0");
		} catch (Exception e) {
			retdto.setResultcode("1");
			retdto.setResultmsg(e.toString());
			throw new BizException(e);
		}
 		return retdto;
		
	}

	/**
	 * 组装医嘱信息
	 */
	public CiorderAggDO assebleOrderAgg(EmsCommonOrdDTO emsCommonOrd) throws BizException {
		CiorderAggDO orderAgg = super.assebleOrderAgg(emsCommonOrd);

		return orderAgg;
	}

	/**
	 * 组装服务项目信息，添加附加手术
	 */
	public List<OrdSrvDO> asssembleSrv(List<EmsCommonSrvDTO> emsCommonSrvList, CiOrderDO order) throws BizException {
		List<OrdSrvDO> ordSrvList = super.asssembleSrv(emsCommonSrvList, order);

		return ordSrvList;
	}

	/**
	 * 获取主服务数据
	 * 
	 * @param order
	 * @param oprAddList
	 * @return
	 * @throws BizException 
	 */
	protected OrdSrvDO getMainSrvInfo(CiEnContextDTO ctx, CiorderAggDO orderAgg,EmsOprOrdDTO emsOprOrd
			) throws BizException {

		CiOrderDO order = orderAgg.getParentDO();
		OrdSrvDO[] ordSrvs = orderAgg.getOrdSrvDO();

		List<String> codeSrvList = new ArrayList<String>();
		codeSrvList.add(emsOprOrd.getCode_srv_or());

		Map<String, MedSrvDO> medSrvMap = this.getMedSrvMap(codeSrvList);

		int sortno = ordSrvs.length;

		OrdSrvDO ordSrv = new OrdSrvDO();
		ordSrv.setStatus(DOStatus.NEW);

		MedSrvDO medSrv = medSrvMap.get(emsOprOrd.getCode_srv_or());
		ordSrv.setId_or(order.getId_or());
		ordSrv.setId_org(order.getId_org());
		ordSrv.setId_grp(order.getId_grp());
		ordSrv.setId_pat(order.getId_pat());
		ordSrv.setId_entp(order.getId_entp());
		ordSrv.setCode_entp(order.getCode_entp());
		ordSrv.setId_en(order.getId_en());
		ordSrv.setSortno(sortno++);
		ordSrv.setId_srvtp(medSrv.getId_srvtp());
		ordSrv.setSd_srvtp(medSrv.getSd_srvtp());
		ordSrv.setId_srv(medSrv.getId_srv());
		ordSrv.setName(medSrv.getName());
		ordSrv.setFg_dose_anoma(FBoolean.FALSE);
		ordSrv.setQuan_medu(medSrv.getQuan_med());
		ordSrv.setId_medu(medSrv.getId_unit_med());
		// ordSrv.setId_route(Id_route);
		// ordSrv.setId_routedes(Id_routedes);
		// ordSrv.setId_boil(Id_boil);
		// ordSrv.setId_boildes(Id_boildes);
		ordSrv.setId_freq(medSrv.getId_freq());

		ordSrv.setId_org_srv(order.getId_org());
		ordSrv.setId_dep_srv(order.getId_dep_or());
		ordSrv.setId_wg_or(order.getId_wg_or());
		ordSrv.setId_emp_srv(order.getId_emp_or());

		DeptDO deptMp = this.getDeptById(order.getId_dep_mp());
		ordSrv.setId_org_mp(deptMp.getId_org());
		ordSrv.setId_dep_mp(order.getId_dep_mp());

		ordSrv.setId_su_bl(order.getId_su_bl());
		ordSrv.setSd_su_bl(order.getSd_su_bl());
		ordSrv.setDt_last_bl(order.getDt_effe()); // ?
		// ordSrv.setDt_last_cg(Dt_last_cg); // ?

		ordSrv.setId_su_mp(order.getId_su_mp());
		ordSrv.setSd_su_mp(order.getSd_su_mp());
		// ordSrv.setDt_last_mp(Dt_last_mp);

		ordSrv.setFg_or(medSrv.getFg_or());
		ordSrv.setEu_blmd(medSrv.getEu_blmd());
		ordSrv.setFg_mm(FBoolean.FALSE);

		ordSrv.setFg_set(FBoolean.FALSE);
		// ordSrv.setNote_srv(Note_srv);
		ordSrv.setFg_pres_outp(FBoolean.FALSE);

		ordSrv.setFg_indic(FBoolean.FALSE);// ?
		ordSrv.setFg_propc(FBoolean.FALSE);
		ordSrv.setFg_self(FBoolean.FALSE);
		ordSrv.setDt_create(order.getDt_entry());
		ordSrv.setId_srvca(medSrv.getId_srvca());
		ordSrv.setFg_bl(medSrv.getFg_bl());
		ordSrv.setCode_srv(medSrv.getCode());
		ordSrv.setId_dep_nur_srv(order.getId_dep_nur_or());
		ordSrv.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);

		// 医保
		ordSrv.setId_hp(ctx.getId_hp());
		/*
		ordSrv.setId_hpsrvtp(Id_hpsrvtp);
		ordSrv.setSd_hpsrvtp(Sd_hpsrvtp);
		ordSrv.setFg_selfpay(FBoolean.TRUE);
		ordSrv.setDes_hplimit(Des_hplimit);
		ordSrv.setFg_hpindicjudged(Fg_hpindicjudged);
		ordSrv.setEu_hpdoctorjudge(Eu_hpdoctorjudge);
		ordSrv.setIndicitemid(Indicitemid);
		ordSrv.setEu_hpindicjudge(Eu_hpindicjudge);
		ordSrv.setEu_hpsrvctrtp(Eu_hpsrvctrtp);
		*/

		ordSrv.setFg_skintest(FBoolean.FALSE);
		// ordSrv.setId_skintest_skip_reason(Id_skintest_skip_reason);
		// ordSrv.setSd_skintest_skip_reason(Id_skintest_skip_reason);
		// ordSrv.setId_reltp(Id_reltp);
		// ordSrv.setSd_reltp(Sd_reltp);
		// ordSrv.setId_or_rel(Id_or_rel);

		ordSrv.setFg_skintest_rst(FBoolean.FALSE);
		ordSrv.setFg_selfsrv(FBoolean.FALSE);
		// ordSrv.setId_srv_src(Id_srv_src);
		// ordSrv.setQuan_total_medu(Quan_total_medu);
		ordSrv.setId_primd(medSrv.getId_primd());
		// ordSrv.setId_dep_wh(Id_dep_wh);
		ordSrv.setInnercode_srvca(medSrv.getSrvca_innercode());
		ordSrv.setFg_base(FBoolean.FALSE);

		ordSrv.setFg_feertnable(FBoolean.TRUE);

		ordSrv.setFg_specill(FBoolean.FALSE);
		ordSrv.setFg_extdispense(FBoolean.FALSE);

		/*
		 * ordSrv.setPri(Pri); ordSrv.setPri_std(Pri_std);
		 * ordSrv.setPri_ratio(Pri_ratio); ordSrv.setId_pripat(id_pripat);
		 */

		// ordSrv.setEu_feereversetp(Eu_feereversetp);
		// ordSrv.setId_mm(Id_mm);
		ordSrv.setFg_nothingwithorders(FBoolean.FALSE);
		ordSrv.setFg_research(FBoolean.FALSE);
		// ordSrv.setId_researchproject(Id_researchproject);
		// ordSrv.setCode_researchproject(Code_researchproject);

		return ordSrv;
	}
	
	/**
	 * 获取附加手术服务数据
	 * 
	 * @param order
	 * @param oprAddList
	 * @return
	 * @throws BizException 
	 */
	protected List<OrdSrvDO> getAdditionalOpr(CiEnContextDTO ctx, CiorderAggDO orderAgg,
			List<EmsOprAddDTO> oprAddList) throws BizException {

		List<OrdSrvDO> ordSrvList = new ArrayList<OrdSrvDO>();
		if (oprAddList == null || oprAddList.size() == 0) {
			return ordSrvList;
		}

		CiOrderDO order = orderAgg.getParentDO();
		OrdSrvDO[] ordSrvs = orderAgg.getOrdSrvDO();

		List<String> codeSrvList = new ArrayList<String>();
		for (EmsOprAddDTO emsOprAdd : oprAddList) {
			codeSrvList.add(emsOprAdd.getCode_srv_sug_add());
		}

		Map<String, MedSrvDO> medSrvMap = this.getMedSrvMap(codeSrvList);

		int sortno = ordSrvs.length;
		for (EmsOprAddDTO emdOprAdd : oprAddList) {
			OrdSrvDO ordSrv = new OrdSrvDO();
			ordSrv.setStatus(DOStatus.NEW);

			MedSrvDO medSrv = medSrvMap.get(emdOprAdd.getCode_srv_sug_add());
			ordSrv.setId_or(order.getId_or());
			ordSrv.setId_org(order.getId_org());
			ordSrv.setId_grp(order.getId_grp());
			ordSrv.setId_pat(order.getId_pat());
			ordSrv.setId_entp(order.getId_entp());
			ordSrv.setCode_entp(order.getCode_entp());
			ordSrv.setId_en(order.getId_en());
			ordSrv.setSortno(sortno++);
			ordSrv.setId_srvtp(medSrv.getId_srvtp());
			ordSrv.setSd_srvtp(medSrv.getSd_srvtp());
			ordSrv.setId_srv(medSrv.getId_srv());
			ordSrv.setName(medSrv.getName());
			ordSrv.setFg_dose_anoma(FBoolean.FALSE);
			ordSrv.setQuan_medu(medSrv.getQuan_med());
			ordSrv.setId_medu(medSrv.getId_unit_med());
			// ordSrv.setId_route(Id_route);
			// ordSrv.setId_routedes(Id_routedes);
			// ordSrv.setId_boil(Id_boil);
			// ordSrv.setId_boildes(Id_boildes);
			ordSrv.setId_freq(medSrv.getId_freq());

			ordSrv.setId_org_srv(order.getId_org());
			ordSrv.setId_dep_srv(order.getId_dep_or());
			ordSrv.setId_wg_or(order.getId_wg_or());
			ordSrv.setId_emp_srv(order.getId_emp_or());

			DeptDO deptMp = this.getDeptById(order.getId_dep_mp());
			ordSrv.setId_org_mp(deptMp.getId_org());
			ordSrv.setId_dep_mp(order.getId_dep_mp());

			ordSrv.setId_su_bl(order.getId_su_bl());
			ordSrv.setSd_su_bl(order.getSd_su_bl());
			ordSrv.setDt_last_bl(order.getDt_effe()); // ?
			// ordSrv.setDt_last_cg(Dt_last_cg); // ?

			ordSrv.setId_su_mp(order.getId_su_mp());
			ordSrv.setSd_su_mp(order.getSd_su_mp());
			// ordSrv.setDt_last_mp(Dt_last_mp);

			ordSrv.setFg_or(medSrv.getFg_or());
			ordSrv.setEu_blmd(medSrv.getEu_blmd());
			ordSrv.setFg_mm(FBoolean.FALSE);

			ordSrv.setFg_set(FBoolean.FALSE);
			// ordSrv.setNote_srv(Note_srv);
			ordSrv.setFg_pres_outp(FBoolean.FALSE);

			ordSrv.setFg_indic(FBoolean.FALSE);// ?
			ordSrv.setFg_propc(FBoolean.FALSE);
			ordSrv.setFg_self(FBoolean.FALSE);
			ordSrv.setDt_create(order.getDt_entry());
			ordSrv.setId_srvca(medSrv.getId_srvca());
			ordSrv.setFg_bl(medSrv.getFg_bl());
			ordSrv.setCode_srv(medSrv.getCode());
			ordSrv.setId_dep_nur_srv(order.getId_dep_nur_or());
			ordSrv.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);

			// 医保
			ordSrv.setId_hp(ctx.getId_hp());
			/*
			ordSrv.setId_hpsrvtp(Id_hpsrvtp);
			ordSrv.setSd_hpsrvtp(Sd_hpsrvtp);
			ordSrv.setFg_selfpay(FBoolean.TRUE);
			ordSrv.setDes_hplimit(Des_hplimit);
			ordSrv.setFg_hpindicjudged(Fg_hpindicjudged);
			ordSrv.setEu_hpdoctorjudge(Eu_hpdoctorjudge);
			ordSrv.setIndicitemid(Indicitemid);
			ordSrv.setEu_hpindicjudge(Eu_hpindicjudge);
			ordSrv.setEu_hpsrvctrtp(Eu_hpsrvctrtp);
			*/

			ordSrv.setFg_skintest(FBoolean.FALSE);
			// ordSrv.setId_skintest_skip_reason(Id_skintest_skip_reason);
			// ordSrv.setSd_skintest_skip_reason(Id_skintest_skip_reason);
			// ordSrv.setId_reltp(Id_reltp);
			// ordSrv.setSd_reltp(Sd_reltp);
			// ordSrv.setId_or_rel(Id_or_rel);

			ordSrv.setFg_skintest_rst(FBoolean.FALSE);
			ordSrv.setFg_selfsrv(FBoolean.FALSE);
			// ordSrv.setId_srv_src(Id_srv_src);
			// ordSrv.setQuan_total_medu(Quan_total_medu);
			ordSrv.setId_primd(medSrv.getId_primd());
			// ordSrv.setId_dep_wh(Id_dep_wh);
			ordSrv.setInnercode_srvca(medSrv.getSrvca_innercode());
			ordSrv.setFg_base(FBoolean.FALSE);

			ordSrv.setFg_feertnable(FBoolean.TRUE);

			ordSrv.setFg_specill(FBoolean.FALSE);
			ordSrv.setFg_extdispense(FBoolean.FALSE);

			/*
			 * ordSrv.setPri(Pri); ordSrv.setPri_std(Pri_std);
			 * ordSrv.setPri_ratio(Pri_ratio); ordSrv.setId_pripat(id_pripat);
			 */

			// ordSrv.setEu_feereversetp(Eu_feereversetp);
			// ordSrv.setId_mm(Id_mm);
			ordSrv.setFg_nothingwithorders(FBoolean.FALSE);
			ordSrv.setFg_research(FBoolean.FALSE);
			// ordSrv.setId_researchproject(Id_researchproject);
			// ordSrv.setCode_researchproject(Code_researchproject);

			ordSrvList.add(ordSrv);
		}

		return ordSrvList;
	}

	protected List<OrdSrvDO> getOrdSrvFeeList(CiEnContextDTO ctx, CiorderAggDO orderAgg,
			List<EmsOprSrvDTO> oprSrvList) {

		List<OrdSrvDO> ordSrvList = new ArrayList<OrdSrvDO>();
		/*if (oprSrvList == null || oprSrvList.size() == 0) {
			return ordSrvList;
		}

		CiOrderDO order = orderAgg.getParentDO();
		OrdSrvDO[] ordSrvs = orderAgg.getOrdSrvDO();

		List<String> codeSrvList = new ArrayList<String>();
		for (EmsOprSrvDTO oprSrv : oprSrvList) {
			codeSrvList.add(oprSrv.getCode_srv());
		}

		Map<String, MedSrvDO> medSrvMap = this.getMedSrvMap(codeSrvList);

		int sortno = ordSrvs.length;
		for (EmsOprSrvDTO oprSrv : oprSrvList) {
			OrdSrvDO ordSrv = new OrdSrvDO();
			ordSrv.setStatus(DOStatus.NEW);

			MedSrvDO medSrv = medSrvMap.get(oprSrv.getCode_srv());
			ordSrv.setId_or(order.getId_or());
			ordSrv.setId_org(order.getId_org());
			ordSrv.setId_grp(order.getId_grp());
			ordSrv.setId_pat(order.getId_pat());
			ordSrv.setId_entp(order.getId_entp());
			ordSrv.setCode_entp(order.getCode_entp());
			ordSrv.setId_en(order.getId_en());
			ordSrv.setSortno(sortno++);
			ordSrv.setId_srvtp(medSrv.getId_srvtp());
			ordSrv.setSd_srvtp(medSrv.getSd_srvtp());
			ordSrv.setId_srv(medSrv.getId_srv());
			ordSrv.setName(medSrv.getName());
			ordSrv.setFg_dose_anoma(FBoolean.FALSE);
			ordSrv.setQuan_medu(new FDouble(oprSrv.getQuan_medu_srv()));
			ordSrv.setId_medu(medSrv.getId_unit_med());
			// ordSrv.setId_route(Id_route);
			// ordSrv.setId_routedes(Id_routedes);
			// ordSrv.setId_boil(Id_boil);
			// ordSrv.setId_boildes(Id_boildes);
			ordSrv.setId_freq(medSrv.getId_freq());

			ordSrv.setId_org_srv(order.getId_org());
			ordSrv.setId_dep_srv(order.getId_dep_or());
			ordSrv.setId_wg_or(order.getId_wg_or());
			ordSrv.setId_emp_srv(order.getId_emp_or());

			DeptDO deptMp = this.getDeptById(oprSrv.getCode_dep_mp_srv());
			ordSrv.setId_org_mp(deptMp.getId_org());
			ordSrv.setId_dep_mp(order.getId_dep_mp());

			ordSrv.setId_su_bl(order.getId_su_bl());
			ordSrv.setSd_su_bl(order.getSd_su_bl());
			ordSrv.setDt_last_bl(order.getDt_effe()); // ?
			// ordSrv.setDt_last_cg(Dt_last_cg); // ?

			ordSrv.setId_su_mp(order.getId_su_mp());
			ordSrv.setSd_su_mp(order.getSd_su_mp());
			// ordSrv.setDt_last_mp(Dt_last_mp);

			ordSrv.setFg_or(medSrv.getFg_or());
			ordSrv.setEu_blmd(medSrv.getEu_blmd());
			ordSrv.setFg_mm(FBoolean.FALSE);

			ordSrv.setFg_set(FBoolean.FALSE);
			// ordSrv.setNote_srv(Note_srv);
			ordSrv.setFg_pres_outp(FBoolean.FALSE);

			ordSrv.setFg_indic(FBoolean.FALSE);// ?
			ordSrv.setFg_propc(FBoolean.FALSE);
			ordSrv.setFg_self(FBoolean.FALSE);
			ordSrv.setDt_create(order.getDt_entry());
			ordSrv.setId_srvca(medSrv.getId_srvca());
			ordSrv.setFg_bl(medSrv.getFg_bl());
			ordSrv.setCode_srv(medSrv.getCode());
			ordSrv.setId_dep_nur_srv(order.getId_dep_nur_or());
			ordSrv.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);

			// 医保
			ordSrv.setId_hp(Id_hp);
			ordSrv.setId_hpsrvtp(Id_hpsrvtp);
			ordSrv.setSd_hpsrvtp(oprSrv.getSd_hpsrvtp());
			ordSrv.setFg_selfpay("Y".equals(oprSrv.getFg_selfpay()) ? FBoolean.TRUE : FBoolean.FALSE);
			ordSrv.setDes_hplimit(Des_hplimit);
			ordSrv.setFg_hpindicjudged(Fg_hpindicjudged);
			ordSrv.setEu_hpdoctorjudge(Eu_hpdoctorjudge);
			ordSrv.setIndicitemid(Indicitemid);
			ordSrv.setEu_hpindicjudge(Eu_hpindicjudge);
			ordSrv.setEu_hpsrvctrtp(Eu_hpsrvctrtp);

			ordSrv.setFg_skintest(FBoolean.FALSE);
			// ordSrv.setId_skintest_skip_reason(Id_skintest_skip_reason);
			// ordSrv.setSd_skintest_skip_reason(Id_skintest_skip_reason);
			// ordSrv.setId_reltp(Id_reltp);
			// ordSrv.setSd_reltp(Sd_reltp);
			// ordSrv.setId_or_rel(Id_or_rel);

			ordSrv.setFg_skintest_rst(FBoolean.FALSE);
			ordSrv.setFg_selfsrv(FBoolean.FALSE);
			// ordSrv.setId_srv_src(Id_srv_src);
			// ordSrv.setQuan_total_medu(Quan_total_medu);
			ordSrv.setId_primd(medSrv.getId_primd());
			// ordSrv.setId_dep_wh(Id_dep_wh);
			ordSrv.setInnercode_srvca(medSrv.getSrvca_innercode());
			ordSrv.setFg_base(FBoolean.FALSE);

			ordSrv.setFg_feertnable(FBoolean.TRUE);

			ordSrv.setFg_specill("Y".equals(oprSrv.getFg_specill()) ? FBoolean.TRUE : FBoolean.FALSE);
			ordSrv.setFg_extdispense(FBoolean.FALSE);

			ordSrv.setPri(new FDouble(oprSrv.getPri()));
			ordSrv.setPri_std(new FDouble(oprSrv.getPri_std()));
			ordSrv.setPri_ratio(new FDouble(oprSrv.getPri_ratio()));
			ordSrv.setId_pripat(id_pripat);

			// ordSrv.setEu_feereversetp(Eu_feereversetp);
			// ordSrv.setId_mm(Id_mm);
			ordSrv.setFg_nothingwithorders(FBoolean.FALSE);
			ordSrv.setFg_research("Y".equals(oprSrv.getFg_research()) ? FBoolean.TRUE : FBoolean.FALSE);
			// ordSrv.setId_researchproject(Id_researchproject);
			// ordSrv.setCode_researchproject(Code_researchproject);

			ordSrvList.add(ordSrv);
		}
*/
		return ordSrvList;
	}

	/**
	 * 手术申请单
	 * 
	 * @return
	 * @throws BizException 
	 */
	public CiorappsurgeryAggDO getSurgeryAggInfo(CiEnContextDTO ctx, CiorderAggDO orderAgg, EmsOprOrdDTO emsOprOrd)
			throws BizException {

		CiorappsurgeryAggDO surgeryAgg = new CiorappsurgeryAggDO();

		OrdApOpDO ordApOp = this.getOrdApOpInfo(ctx, orderAgg, emsOprOrd);

		surgeryAgg.setParentDO(ordApOp);

		List<EmsOprPerDTO> oprPerList = emsOprOrd.getPerList();

		List<OrdOpEmpDO> ordOpEmpList = this.getOrdOpEmpList(ctx, ordApOp, oprPerList);
		
		surgeryAgg.setOrdOpEmpDO(ordOpEmpList.toArray(new OrdOpEmpDO[ordOpEmpList.size()]));

		return surgeryAgg;
	}
	
	/**
	 * 获取申请单主表
	 * @param ctx
	 * @param orderAgg
	 * @param emsOprOrd
	 * @return
	 * @throws BizException
	 */
	private OrdApOpDO getOrdApOpInfo(CiEnContextDTO ctx, CiorderAggDO orderAgg,EmsOprOrdDTO emsOprOrd) throws BizException{
		
		OrdApOpDO ordApOp = new OrdApOpDO();
		CiOrderDO order = orderAgg.getParentDO();
		ordApOp.setId_or(order.getId_or());
		//ordApOp.setId_di(Id_di);
		//ordApOp.setStr_id_diitm(Str_id_diitm);
		//ordApOp.setStr_code_di(Str_code_di);
		//ordApOp.setStr_name_di(Str_name_di);
		ordApOp.setNo_applyform(emsOprOrd.getNo_applyform());
		ordApOp.setDt_plan(new FDateTime(emsOprOrd.getDt_plan()));
		ordApOp.setSugplantime(StringUtils.isEmpty(emsOprOrd.getSugplantime())?null : new FDouble(emsOprOrd.getSugplantime()));
		//ordApOp.setId_lvlsug(); // 手术级别
		//ordApOp.setSd_lvlsug(Sd_lvlsug); // 手术级别编码
		
		UdidocDO anestpUdidoc = this.getAnestpUdidoc(emsOprOrd.getSd_anestp());
		ordApOp.setId_anestp(anestpUdidoc.getId_udidoc()); //麻醉方式
		ordApOp.setSd_anestp(emsOprOrd.getSd_anestp());
		//ordApOp.setId_incitp(Id_incitp); // 切口愈合分级
		//ordApOp.setSd_incitp(Sd_incitp);
		ordApOp.setFg_allergy("Y".equals(emsOprOrd.getFg_allergy())?FBoolean.TRUE: FBoolean.FALSE);
		ordApOp.setFg_patho(FBoolean.FALSE); // 冰冻病理标识
		/*
		ordApOp.setId_su_op(Id_su_op); // 手术申请状态
		ordApOp.setSd_su_op(Sd_su_op); // 
		*/
		ordApOp.setAnnouncements(emsOprOrd.getAnnouncements()); // 注意事项
		
		ordApOp.setId_srv(order.getId_srv());
		//ordApOp.setId_srv_code(Id_srv_code);
		
		ordApOp.setQuan_bt_paln(new FDouble());
		
		ordApOp.setId_emp_operate(this.getPsndocByCode(emsOprOrd.getCode_emp_operate()).getId_psndoc());
		ordApOp.setId_emp_helper(this.getPsndocByCode(emsOprOrd.getCode_emp_helper()).getId_psndoc());
		// 体位
		UdidocDO bodyUdidoc = this.getBodyUdidoc(emsOprOrd.getSd_sugbody());
		ordApOp.setId_sugbody(bodyUdidoc.getId_udidoc());
		ordApOp.setSd_sugbody(emsOprOrd.getSd_sugbody());
		
		ordApOp.setFg_er_sug(FBoolean.FALSE);
		ordApOp.setFg_xq_sug(FBoolean.FALSE);
		ordApOp.setFg_zq_sug(FBoolean.FALSE);
		if(ICiDictCodeConst.SD_OPDATE_LIMITTP_ER.equals(emsOprOrd.getSd_sugbody())){
			ordApOp.setFg_er_sug(FBoolean.TRUE);
		}else if(ICiDictCodeConst.SD_OPDATE_LIMITTP_XQ.equals(emsOprOrd.getSd_sugbody())){
			ordApOp.setFg_xq_sug(FBoolean.TRUE);
		}else if(ICiDictCodeConst.SD_OPDATE_LIMITTP_ZQ.equals(emsOprOrd.getSd_sugbody())){
			ordApOp.setFg_zq_sug(FBoolean.TRUE);
		}
		
		ordApOp.setFg_new_sug(FBoolean.TRUE);
		/*
		ordApOp.setName_diag(Name_diag);
		ordApOp.setId_diitm(Id_diitm);
		ordApOp.setId_didef_relstd(Id_didef_relstd); // 手术所归类的标准诊断
		*/
		ordApOp.setFg_prn(FBoolean.FALSE);		
		ordApOp.setFg_daysug(FBoolean.TRUE);
		ordApOp.setName_des(emsOprOrd.getName_srv_or());
		
		// 手术期限
		UdidocDO dateLimitTypeudidoc = this.getDateLimitTypeUdidoc(emsOprOrd.getSd_datelimittype());
		ordApOp.setId_datelimittype(dateLimitTypeudidoc.getId_udidoc());
		ordApOp.setSd_datelimittype(emsOprOrd.getSd_datelimittype());
		
		// 手术部位
		UdidocDO surgicalSiteUdidoc = this.getSurgicalSiteUdidoc(emsOprOrd.getSd_surgical_site());
		ordApOp.setId_surgical_site(surgicalSiteUdidoc.getId_udidoc());
		ordApOp.setSd_surgical_site(emsOprOrd.getSd_surgical_site());
		
		//ordApOp.setSpecialreq(Specialreq);
		//ordApOp.setId_specialreq(Id_specialreq);
		//ordApOp.setSd_specialreq(Sd_specialreq);
		//ordApOp.setSpecialinstrument(Specialinstrument);
		
		// 特殊准备
		ordApOp.setSpecialdes(emsOprOrd.getSpecialdes());
		// 特殊仪器
		//ordApOp.setId_specialinstrument(Id_specialinstrument);
		//ordApOp.setSd_specialinstrument(Sd_specialinstrument);
		
		//手术要求
		//ordApOp.setSug_require(Sug_require);
		
		return ordApOp;
	}

	private List<OrdOpEmpDO> getOrdOpEmpList(CiEnContextDTO ctx, OrdApOpDO ordApOp ,List<EmsOprPerDTO>  oprPerList) throws BizException{
		
		List<OrdOpEmpDO> ordOpEmpList = new ArrayList<OrdOpEmpDO>();
		if(oprPerList == null || oprPerList.size() ==0){
			return ordOpEmpList;
		}
		
		for(int i=0;i< oprPerList.size() ; i++ ){
			
			EmsOprPerDTO emsOprPer = oprPerList.get(i);
			
			OrdOpEmpDO ordOpEmp = new OrdOpEmpDO();
			ordOpEmp.setStatus(DOStatus.NEW);
			
			PsnDocDO psnDoc = this.getPsndocByCode(emsOprPer.getCode_emp_sug_emp());
			ordOpEmp.setId_emp(psnDoc.getId_psndoc());
			
			UdidocDO udidoc = this.getRoleUdidoc(emsOprPer.getSd_role_sug_emp());
			ordOpEmp.setId_role(udidoc.getId_udidoc());
			ordOpEmp.setSd_role(udidoc.getCode());
			ordOpEmp.setSortno(i+1);
		}
		
		return ordOpEmpList;
	}

	/**
	 * 体位编码_自定义档案
	 * @throws BizException 
	 */
	private UdidocDO getBodyUdidoc(String code) throws BizException{
		
		return getUdidoc("BD.SRV.1015", code);
	}
	
	/**
	 * 手术期限
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private UdidocDO getDateLimitTypeUdidoc(String code) throws BizException{
		
		return getUdidoc("CI.OR.0590", code);
	}
	
	/**
	 * 手术部位
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private UdidocDO getSurgicalSiteUdidoc(String code) throws BizException{
		
		return getUdidoc("CI.OR.0910", code);
	}
	
	/**
	 * 麻醉方法
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private UdidocDO getAnestpUdidoc(String code) throws BizException{
		
		return getUdidoc("CI.OR.0580", code);
	}
	
	/**
	 * 手术人员角色
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private UdidocDO getRoleUdidoc(String code) throws BizException{
		
		return getUdidoc("CI.OR.0635", code);
	}
	
	private UdidocDO getUdidoc(String code_udidoclist, String code_udidoc) throws BizException{
		if(StringUtils.isEmpty(code_udidoclist) || StringUtils.isEmpty(code_udidoc)){
			return new UdidocDO();
		}
		
		UdidocDO udidoc = UdidocUtils.getUdidocByCode(code_udidoclist, code_udidoc);
		
		if(udidoc == null){
			throw new BizException("未找到自定义档案类型["+code_udidoclist+"] 编码为 ["+code_udidoc+"]的档案信息！");
		}
		
		return udidoc;
	}
}
