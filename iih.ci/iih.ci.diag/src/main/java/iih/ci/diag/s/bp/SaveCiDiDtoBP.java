package iih.ci.diag.s.bp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.res.deptb.d.DeptBDO;
import iih.bd.res.deptb.i.IDeptbRService;
import iih.ci.ciet.cievent.d.CiEventDO;
import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.dto.d.DIDTO;
import iih.ci.diag.i.external.ICidiagExtQryService;
import iih.ci.diag.log.Diaglogger;
import iih.ci.diag.pub.CiDiAppUtils;
import iih.ci.diag.s.CiDiUtils;
import iih.ci.diag.s.bp.qry.getUdiDocListsMapQry;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.mi.diag.i.ICiMiDiagService;
import iih.ci.ord.ciorder.d.HpBeyondEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.iemsg.d.IEOpPvDiagDTO;
import iih.ci.ord.iemsg.d.IEOpPvDiagEnDTO;
import iih.en.pv.dto.d.OpBasicDTO;
import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.i.IEnOutQryService;
import iih.pi.overview.overview.d.OverviewAggDO;
import iih.pi.overview.overview.i.IOverviewRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.bdfw.bbd.d.PsndocAggDO;
import xap.sys.bdfw.bbd.i.IPsndocRService;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRService;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 临床诊断
 * 
 * @author li_zheng
 *
 */
public class SaveCiDiDtoBP {

	private Map<String, String> namemap = null;
	private Map<String, String> codemap = null;;

	/**
	 * 查询诊断体系，并缓存Map结构，key 诊断体系id， value 诊断体系名称
	 * 
	 * @throws BizException
	 */
	public void getUdidocMap() throws BizException {
		getUdiDocListsMapQry qry = new getUdiDocListsMapQry();
		UdidocDO[] rtn = (UdidocDO[]) AppFwUtil.getDORstWithDao(qry, UdidocDO.class);
		if (rtn != null && rtn.length > 0) {
			namemap = new HashMap<String, String>();
			codemap = new HashMap<String, String>();
			for (UdidocDO udidoc : rtn) {
				namemap.put(udidoc.getId_udidoc(), udidoc.getName());
				codemap.put(udidoc.getId_udidoc(), udidoc.getCode());
			}
		}
	}

	/**
	 * 保存就诊的当前诊断
	 * 
	 * @param diDTO
	 * @return diDTO
	 * @throws BizException
	 */
	public DIDTO[] exec(DIDTO[] diDTOs, String des, CiEnContextDTO ctx) throws BizException {
		long tBeginTime = System.currentTimeMillis();
		if (diDTOs == null || diDTOs.length <= 0)
			return null;

		if (this.namemap == null) {
			this.getUdidocMap();
		}
		// ----------0151377: 门诊不下西医诊断，中医诊断保存不上。----
		if (!StringUtils.isEmpty(ctx.getCode_entp())) {
			diDTOs[0].setCode_entp(ctx.getCode_entp());
		}
		// --------------------------------------------------
		// 将DIDTO对象转换为 CiDiagDO
		CiDiagDO cidiag = getCiDiagDO(diDTOs);

		if (StringUtils.isNotEmpty(diDTOs[0].getId_didef())
				|| (("0000".equals(diDTOs[0].getId_disease_code())) || ("0000".equals(diDTOs[0].getDidef_code())))) {
			CidiagAggDO agg = new CidiagAggDO();
			agg.setParentDO(cidiag);

			CidiagAggDO tempAgg = null;
			if (StringUtils.isNotEmpty(cidiag.getId_di())) {
				tempAgg = getCidiagAggDO(cidiag.getId_di());
			}
			List<CiDiagItemDO> itemList = new ArrayList<CiDiagItemDO>();
			List<String> idDiDefList = new ArrayList<String>();// bd的诊断主键
			List<String> diCodeList = new ArrayList<String>();// bd的诊断编码
			// 临床诊断 明细表
			String str = getCiDiagItemDO(itemList, tempAgg, diDTOs, idDiDefList, diCodeList);
			// 诊断描述信息
			// String signName = diDTO[0].getName_emp_sign();
			if (StringUtils.isEmpty(des)) {
				cidiag.setDes_di(str);
			} else {
				cidiag.setDes_di(des);
			}

			// 获取保外诊断判断结果，key值诊断定义id， value Y 保外诊断，N 保内诊断
			ICiMiDiagService ciMiDiagService = ServiceFinder.find(ICiMiDiagService.class);
			FMap map = ciMiDiagService.checkDiScopeRule(ctx, idDiDefList.toArray(new String[idDiDefList.size()]));

			String idDidef = "";
			// 设置诊断明细
			if (itemList != null && itemList.size() > 0) {
				CiDiagItemDO[] items = new CiDiagItemDO[itemList.size()];
				int i = 0;

				String[] id_didef = new String[itemList.size()];
				if (isHpUsing(ctx)) {
					for (CiDiagItemDO item : itemList) {
						
						if (FBoolean.TRUE.equals(map.get(item.getId_didef()))) {
							item.setEu_hpbeyond(HpBeyondEnum.HPEXTERNALDIAG);// 医保外
							idDidef += "," + item.getId_didef();							
						} else {
							item.setEu_hpbeyond(HpBeyondEnum.HPDIAG);// 医保内
						}
						
						items[i] = item;
						id_didef[i] = item.getId_didef();
						i++;
					}
				} else {
					for (CiDiagItemDO item : itemList) {
						item.setEu_hpbeyond(HpBeyondEnum.NONMEDICARE);
						items[i] = item;
						id_didef[i] = item.getId_didef();
						i++;
					}
				}
				agg.setCiDiagItemDO(items);
			}
			// 有自费医嘱 没有自费诊断了
			JudgeOrderDiagBP bp = new JudgeOrderDiagBP();
			/*
			 * if( bp.getEffectiveOrder(ctx)==FBoolean.TRUE){
			 * if(idDidef.length() <= 0){ throw new
			 * BizException("有自费医嘱，必须有自费诊断"); } }
			 */

			if (cidiag.getFg_sign().isValue()) {
				if (idDidef.length() > 0) {
					// bd 诊断的拼接
					ctx.setDes_bhpjudgerst(idDidef.substring(1));
				}
				// 判断是否有医嘱 有是有使用的诊断

				bp.JudgeOrderDiag(agg, ctx);

				// 签署时 诊断和事件
				CidiagAggDO ret = CiDiUtils.getCidiagMaintainServiceImpl().SaveCiDi(agg);
				// 删除就诊域的原由的诊断
				EntDiDO[] entDiDOs = CiDiUtils.getIEntdiRService()
						.find("a0.id_ent ='" + agg.getParentDO().getId_en() + "'", "id_ent", FBoolean.FALSE);
				if (entDiDOs != null && entDiDOs.length > 0) {
					CiDiUtils.getIEntdiCudService().delete(entDiDOs);
				}
				// 保存就诊的当前诊断
				CiDiUtils.getIEntdiCudService().save(getEntDiDO(agg.getParentDO().getId_en()));
				// 诊断的集成平台事件
				IEDiagFireEvent(ret, ctx);
			} else {
				// 住院诊断保存时，非签署
				CidiagAggDO[] aggdo = CiDiUtils.getICidiagCudService().save(new CidiagAggDO[] { agg });
			}
			if (isHpUsing(ctx)) {
				for (DIDTO diDTO : diDTOs) {
					// 判断是否存在保外诊断
					if (FBoolean.TRUE.equals(map.get(diDTO.getId_didef()))) {
						diDTO.setEu_hpbeyond(HpBeyondEnum.HPEXTERNALDIAG);
					} else {
						diDTO.setEu_hpbeyond(HpBeyondEnum.HPDIAG);
					}
				}
			} else {
				for (DIDTO diDTO : diDTOs) {
					diDTO.setEu_hpbeyond(HpBeyondEnum.NONMEDICARE);
				}
			}
		} else {
			CiDiagDO[] res = CiDiAppUtils.getICidiagMDOCudService().save(new CiDiagDO[] { cidiag });

			// 删除就诊域的原有的诊断
			EntDiDO[] entDiDOs = CiDiUtils.getIEntdiRService().find("a0.id_ent ='" + cidiag.getId_en() + "'", "id_ent",
					FBoolean.FALSE);
			if (entDiDOs != null && entDiDOs.length > 0) {
				CiDiUtils.getIEntdiCudService().delete(entDiDOs);
			}

			CidiagAggDO aggDO = new CidiagAggDO();
			aggDO.setParentDO(res[0]);
			// 诊断的集成平台事件
			IEDiagFireEvent(aggDO, ctx);
		}
		Diaglogger.info(ctx, String.format("诊断保存[%s]，有效性判断,耗时:%s(ms)", des, System.currentTimeMillis() - tBeginTime));
		return diDTOs;
	}

	/**
	 * 是否是医保就诊
	 * 
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	public boolean isHpUsing(CiEnContextDTO ctx) throws BizException {
		String sd_hptp = ctx.getSd_hptp();// 高端商保不走医保逻辑，1开头社保，2开头商保
		boolean flag = StringUtils.isNotEmpty(ctx.getId_hp()) && FBoolean.TRUE.equals(ctx.getFg_hpfundpay())
				&& StringUtils.isNotEmpty(sd_hptp) && sd_hptp.startsWith("1");
		return flag;
	}

	/**
	 * BS301： 诊断信息服务 IE 集成平台</br>
	 * 门诊诊断签署(住院的通过集成平台配置实现)
	 * 
	 * @param ret
	 * @throws BizException
	 */
	public void IEDiagFireEvent(CidiagAggDO ret, CiEnContextDTO ctx) throws BizException {
		if (ret != null && (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(ret.getParentDO().getCode_entp())
				||IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(ret.getParentDO().getCode_entp())
				||IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(ret.getParentDO().getCode_entp()))) {
			 Object[] objects=new Object[] {ret,ctx};
			 BDCommonEvent event = new BDCommonEvent(IOrdEventSources.OP_IP_DIAG_ENTER, IEventType.TYPE_UPDATE_AFTER, objects);
			 EventDispatcher.fireEvent(event);
//			IEOpPvDiagEnDTO[] OpPvDiagDTO = IEOpPvDiagEnDTO(ret, ret.getParentDO().getId_en(), ctx);
//			// 触发事件
//			for (IEOpPvDiagEnDTO d : OpPvDiagDTO) {
//				DomainBusinessUserObj buo = new DomainBusinessUserObj(d, BusiType.MZ, "0", "0");
//				MsgObj msg = new MsgObj();
//				msg.setInteractionCode("new");
//				buo.setMsgObj(msg);
//				BusinessEvent event = new BusinessEvent(ICiIEEventConst.EVENT_IE_CIDIAG_OP_SIGN,
//						IEventType.TYPE_UPDATE_AFTER, buo);
//				EventDispatcher.fireEvent(event);
//
//			}
		} /*
			 * else if(ret != null &&
			 * "10".equals(ret.getParentDO().getCode_entp())){ IEOpPvDiagEnDTO[]
			 * OpPvDiagDTO = IEOpPvDiagEnDTO(ret,
			 * ret.getParentDO().getId_en(),ctx); // 触发事件 for (IEOpPvDiagEnDTO d
			 * : OpPvDiagDTO) { DomainBusinessUserObj buo = new
			 * DomainBusinessUserObj(d, BusiType.ZY, "0", "0"); MsgObj msg = new
			 * MsgObj(); msg.setInteractionCode("new"); buo.setMsgObj(msg);
			 * BusinessEvent event = new
			 * BusinessEvent(ICiIEEventConst.EVENT_IE_CIDIAG_OP_SIGN,
			 * IEventType.TYPE_UPDATE_AFTER, buo);
			 * EventDispatcher.fireEvent(event);
			 * 
			 * } }
			 */
	}

	private CidiagAggDO getCidiagAggDO(String id_di) throws BizException {

		CidiagAggDO agg = CiDiUtils.getICidiagRService().findById(id_di);
		/*
		 * if(agg !=null && agg.getCiDiagItemDO() != null &&
		 * agg.getCiDiagItemDO().length >0)
		 * CiDiUtils.getICidiagCudService().delete(new CidiagAggDO[]{agg});
		 */
		return agg;
	}

	/**
	 * 临床诊断主表
	 * 
	 * @param cidiag
	 * @param diDTO
	 * @throws BizException
	 */
	private CiDiagDO getCiDiagDO(DIDTO[] diDTO) throws BizException {

		CiDiagDO cidiag = new CiDiagDO();

		DIDTO item = diDTO[0];
		if (item.getId_di() != null) {
			cidiag = CiDiUtils.getICidiagMDORService().findById(item.getId_di());
			if (cidiag == null) {
				cidiag = new CiDiagDO();
				cidiag.setStatus(DOStatus.NEW);
			} else {
				cidiag.setStatus(DOStatus.UPDATED);
			}
		} else {
			cidiag.setStatus(DOStatus.NEW);
		}
		cidiag.setId_dep(item.getId_dep());
		cidiag.setFg_sign(item.getFg_sign());
		if (cidiag.getFg_sign().isValue()) {
			cidiag.setDt_sign(item.getDt_sign());
			cidiag.setId_dep_sign(item.getId_dep_sign());
			cidiag.setId_emp_sign(item.getId_emp_sign());
		}
		cidiag.setId_emp_create(item.getId_emp_create());
		cidiag.setId_dep_create(item.getId_dep_create());
		cidiag.setDt_create(item.getDt_create());
		cidiag.setId_di(item.getId_di());
		cidiag.setId_grp(Context.get().getGroupId());
		cidiag.setId_org(Context.get().getOrgId());
		cidiag.setId_pat(item.getId_pat());
		cidiag.setId_entp(item.getId_entp());
		cidiag.setCode_entp(item.getCode_entp());
		cidiag.setId_en(item.getId_en());
		cidiag.setId_ditp(item.getId_ditp());
		cidiag.setSd_ditp(item.getSd_ditp());
		cidiag.setDes_di(item.getDes_di());
		cidiag.setDt_di(item.getDt_di());

		StringBuffer sb = new StringBuffer();
		// 暂时注释
		// sb.append(item.getId_disys());
		sb.append(" ");
		sb.append(item.getId_disys_name());
		// sb.append(item.getId_emp_create_name());
		// sb.append(item.getDt_di());
		sb.append(" ");
		cidiag.setDes_di(sb.toString());

		return cidiag;
	}

	/**
	 * 诊断子表信息
	 * 
	 * @param items
	 * @param diDTO
	 * @return
	 * @throws BizException
	 */
	private String getCiDiagItemDO(List<CiDiagItemDO> items, CidiagAggDO tempAgg, DIDTO[] diDTO,
			List<String> IddidefList, List<String> dicodes) throws BizException {
		StringBuffer sb = new StringBuffer();
		int num = 1;
		Map<String, CiDiagItemDO> map = null;
		if (tempAgg != null && tempAgg.getCiDiagItemDO().length > 0) {
			CiDiagItemDO[] ciditem = tempAgg.getCiDiagItemDO();
			map = getCidiItemKeyValue(ciditem);
		} else {
			map = new HashMap<String, CiDiagItemDO>();
		}
		for (int i = 0; i < diDTO.length; i++) {
			DIDTO item = diDTO[i];
			CiDiagItemDO ciDiagitem = null;
			if (item.getId_diitm() != null) {
				// ciDiagitem =
				// CiDiUtils.getICiDiagItemDORService().findById(item.getId_diitm());
				if (map.containsKey(item.getId_diitm())) {
					ciDiagitem = map.get(item.getId_diitm());
					ciDiagitem.setStatus(DOStatus.UPDATED);
					map.remove(item.getId_diitm());
				} else {
					ciDiagitem = new CiDiagItemDO();
					// ciDiagitem.setId_diitm(item.getId_diitm());
					ciDiagitem.setStatus(DOStatus.NEW);
				}

			} else {
				ciDiagitem = new CiDiagItemDO();
				ciDiagitem.setStatus(DOStatus.NEW);
			}
			ciDiagitem.setId_diitm(item.getId_diitm());
			ciDiagitem.setId_di(item.getId_di());
			ciDiagitem.setSortno(i + "");

			if (item.getDidef_name() != null) {
				ciDiagitem.setId_didef(item.getId_didef());
				ciDiagitem.setId_didef_code(item.getDidef_code());
				ciDiagitem.setId_didef_name(item.getDidef_name());
			} else {
				ciDiagitem.setId_didef(item.getDi_disease());
				ciDiagitem.setId_didef_code(item.getId_disease_code());
				ciDiagitem.setId_didef_name(item.getId_disease_name());
			}
			ciDiagitem.setId_didef_syn(item.getId_didef_syn());
			ciDiagitem.setId_didef_syn_code(item.getId_didef_syn_code());
			ciDiagitem.setId_didef_syn_name(item.getId_didef_syn_name());
			// ciDiagitem.setDes(item.getDes());
			ciDiagitem.setFg_majdi(item.getFg_majdi());
			ciDiagitem.setFg_suspdi(item.getFg_suspdi());
			// ciDiagitem.setFg_infedi(item.getFg_infedi());
			// ciDiagitem.setId_parent(item.getId_parent());
			// ciDiagitem.setInnercode(item.getInnercode());
			// ciDiagitem.setFg_flupci(item.getFg_flupci());
			// ciDiagitem.setFg_sym(item.getFg_sym());
			// 自定义诊断不需要加入IddidefList集合
			if ((!("0000".equals(item.getId_disease_code())) && (!("0000".equals(item.getDidef_code())))))
				IddidefList.add(ciDiagitem.getId_didef());
			dicodes.add(ciDiagitem.getId_didef_code());
			ciDiagitem.setSupplement(item.getSupplement());
			ciDiagitem.setId_disys(item.getId_disys());
			if (this.namemap != null && this.codemap != null) {
				ciDiagitem.setSd_disys(this.codemap.get(item.getId_disys()));
				ciDiagitem.setId_disys_name(this.namemap.get(item.getId_disys()));
			}
			ciDiagitem.setDi_standard(item.getDi_standard());
			ciDiagitem.setDi_standard_code(item.getDi_standard_code());
			ciDiagitem.setDi_standard_name(item.getDi_standard_name());
			ciDiagitem.setFg_self(item.getFg_self());// zwq 2016-8-19 自定义诊断标识
			ciDiagitem.setInnercode(item.getInnercode());// zwq 2016-8-19 内部编码
			ciDiagitem.setId_parent(item.getId_par());// zwq 2016-8-19 上级编码
			ciDiagitem.setFg_ur(item.getFg_ur());// zwq 2016-9-2 上级编码
			ciDiagitem.setFg_chronic(item.getFg_chronic()); // 慢性病标志
			ciDiagitem.setFg_special(item.getFg_special());// 特种病标志
			ciDiagitem.setId_infectiontp(item.getId_infectiontp());
			ciDiagitem.setSd_infectiontp(item.getSd_infectiontp());
			item.setSortno(num + "");
			// 西医内容拼接
			if (item.getId_disys() == ICiDictCodeConst.ID_CI_DISYS_XYZDTX) {
				sb.append(num + "," + item.getDidef_name());
				// sb.append("\n");
				if (item.getSupplement() != null && item.getSupplement() != "") {
					sb.append("——" + item.getSupplement());
				}

				sb.append("          \n");

			} else if (item.getId_disys() == ICiDictCodeConst.ID_CI_DISYS_ZYZDTX) {
				// 中医内容拼接
				sb.append(item.getId_disys_name() + " ");
				sb.append(num + "," + item.getId_disease_name());
				sb.append(" \n");
				sb.append(item.getId_didef_syn_name());
				sb.append("         \n");
			} else {
				// 其它
				sb.append(num + "," + item.getDidef_name());
				// sb.append("\n");
				if (item.getSupplement() != null && item.getSupplement() != "") {
					sb.append("——" + item.getSupplement());
				}
				sb.append("         \n");
			}
			items.add(ciDiagitem);
			num++;
		}

		if (map != null && map.size() > 0) {
			for (CiDiagItemDO itemdo : map.values()) {
				itemdo.setStatus(DOStatus.DELETED);
				items.add(itemdo);
			}
		}

		return sb.toString();
	}

	/**
	 * 取得就诊的当前诊断
	 * 
	 * @param id_en
	 * @return
	 * @throws BizException
	 */
	private EntDiDO[] getEntDiDO(String id_en) throws BizException {
		CiDiCurrentBP bp = new CiDiCurrentBP();
		CidiagAggDO[] aggs = bp.getCiDiCurrent(id_en);
		List<EntDiDO> entdis = new ArrayList<EntDiDO>();
		if (aggs != null) {
			boolean Fg_maj = false;
			for (CidiagAggDO agg : aggs) {
				int i = 0;
				if (agg.getCiDiagItemDO() != null && agg.getCiDiagItemDO().length > 0) {
					for (CiDiagItemDO item : agg.getCiDiagItemDO()) {
						EntDiDO entdi = new EntDiDO();
						entdi.setId_org(agg.getParentDO().getId_org());
						entdi.setId_grp(agg.getParentDO().getId_grp());
						entdi.setId_ent(agg.getParentDO().getId_en());
						entdi.setId_didef_dis(item.getId_didef());
						entdi.setName_didef_dis(item.getId_didef_name());
						entdi.setSupplement(item.getSupplement());
						entdi.setId_ditp(agg.getParentDO().getId_ditp());
						entdi.setSd_ditp(agg.getParentDO().getSd_ditp());
						entdi.setId_didef_syn(item.getId_didef_syn());
						entdi.setName_didef_syn(item.getDidef_syn_name());
						entdi.setId_dep(Context.get().getDeptId());
						entdi.setName_bddi(item.getId_didef_name());
						entdi.setDt_diag(agg.getParentDO().getDt_di());
						entdi.setId_diitm(item.getId_diitm());
						entdi.setId_emp_phy(agg.getParentDO().getId_emp_sign());
						entdi.setSd_cdsystp(item.getSd_disys());
						entdi.setId_cdsystp(item.getId_disys());
						entdi.setFg_chronic(item.getFg_chronic());
						entdi.setFg_special(item.getFg_special());
						entdi.setFg_ur(item.getFg_ur());
						if (item.getId_didef_code() != null) {
							entdi.setCode_didef_dis(item.getId_didef_code());
						} else {
							entdi.setCode_didef_dis(item.getId_didef_syn_code());
						}

						entdi.setSortno(i);
						entdi.setId_parent(item.getId_parent());
						entdi.setInnercode(item.getInnercode());
						entdi.setFg_self(item.getFg_self());
						entdi.setId_di(item.getId_di());
						// entdi.setDes(dto.getSupply());
						// 只有一个主诊断
						if (item.getFg_majdi().booleanValue() && !Fg_maj) {
							entdi.setFg_maj(item.getFg_majdi());
							Fg_maj = true;
						} else {
							entdi.setFg_maj(item.getFg_majdi());
						}

						// entdi.setFg_flupci(dto.getFg_flupci());
						// item.setFg_infedi(entdi.get);
						entdi.setFg_suspdi(item.getFg_suspdi());
						// entdi.setFg_sym(dto.getFg_sym());
						// entdi.setDes_di(agg.getParentDO().getDes_di());
						entdi.setId_infectiontp(item.getId_infectiontp());
						entdi.setSd_infectiontp(item.getSd_infectiontp());
						entdi.setStatus(DOStatus.NEW);
						entdis.add(entdi);
						i++;
					}
				} else {

				}
			}
		}
		return entdis.toArray(new EntDiDO[] {});
	}

	// 诊断项目的 key value
	private Map<String, CiDiagItemDO> getCidiItemKeyValue(CiDiagItemDO[] ciditem) {
		if (ciditem == null)
			return null;
		Map<String, CiDiagItemDO> map = new HashMap<String, CiDiagItemDO>();
		for (CiDiagItemDO item : ciditem) {
			map.put(item.getId_diitm(), item);
		}
		return map;
	}

	/**
	 * 诊断事件
	 * 
	 * @param agg
	 * @return
	 */
	private CiEventDO getCiEventDO(CiDiagDO ciDiagDO) {
		CiEventDO cievent = new CiEventDO();
		cievent.setStatus(DOStatus.NEW);
		cievent.setId_di(ciDiagDO.getId_di());
		cievent.setId_pat(ciDiagDO.getId_pat());
		cievent.setId_ettp(ciDiagDO.getId_en());
		return cievent;
	}

	private IEOpPvDiagEnDTO[] IEOpPvDiagEnDTO(CidiagAggDO aggDO, String id_ent, CiEnContextDTO ctx)
			throws BizException {
		// 有效性校验

		IEOpPvDiagEnDTO pvDaigEnt = new IEOpPvDiagEnDTO();
		// 映射患者就诊信息
		MappingPvDiagEnDTO(pvDaigEnt, id_ent, ctx);
		// 映射诊断信息
		MappingDiag(aggDO, pvDaigEnt, ctx);
		return new IEOpPvDiagEnDTO[] { pvDaigEnt };
	}

	/**
	 * 映射患者就诊信息
	 * 
	 * @param pvDaigEnt
	 * @param id_ent
	 * @throws BizException
	 */
	private void MappingPvDiagEnDTO(IEOpPvDiagEnDTO pvDaigEnt, String id_ent, CiEnContextDTO ctx) throws BizException {
		IEnOutQryService qryService = ServiceFinder.find(IEnOutQryService.class);
		IDeptRService deptService = ServiceFinder.find(IDeptRService.class);
		IOverviewRService pipatService = ServiceFinder.find(IOverviewRService.class);
		IOrgRService orgRService = ServiceFinder.find(IOrgRService.class);
		if (qryService != null) {
			OpBasicDTO OpBasicDTO = qryService.getOpBasicInfo(id_ent);
			OverviewAggDO piPatDO = pipatService.findById(OpBasicDTO.getId_pat());
			if (OpBasicDTO != null) {
				// pvDaigEnt.setId_ieoppvdiagen(ipBasicDTO.getId_ieoppvdiagen());//
				// IE门诊诊断就诊信息主键标识
				// pvDaigEnt.setIeoppvmaindiags(ipBasicDTO.getIeoppvmaindiags());//
				// ie门诊就诊诊断集合
				pvDaigEnt.setPatientid(piPatDO.getParentDO().getCode());// 患者ID
				// pvDaigEnt.setP_bar_code(OpBasicDTO.getCode_ent());// 就诊号
				pvDaigEnt.setP_bar_code(piPatDO.getParentDO().getBarcode_chis());// 就诊号
				pvDaigEnt.setBqcode(OpBasicDTO.getTimes_op() + "");// 就诊次数
				pvDaigEnt.setBqname(OpBasicDTO.getName_pat());// 患者姓名
				DeptDO dept = null;
				if (OpBasicDTO.getId_dep_phy() == null) {
					dept = deptService.findById(ctx.getId_dep_en());
				} else {
					dept = deptService.findById(OpBasicDTO.getId_dep_phy());
				}
				pvDaigEnt.setBedno(dept.getCode());// 科室编码
				pvDaigEnt.setName(dept.getName());// 科室名称
				// pvDaigEnt.setDeptcode(ipBasicDTO.getId_dep_nur());// 病区编码
				// pvDaigEnt.setDeptname(ipBasicDTO.getName_dep_nur());// 病区名称
				// pvDaigEnt.setTimes(ipBasicDTO.getId_bed());// 床位号
				OrgDO org = orgRService.findById(dept.getId_org());
				pvDaigEnt.setHospital_code(org.getOrgcode());// 医疗机构编码
				pvDaigEnt.setHospital_name(org.getName());// 医疗机构名称
				pvDaigEnt.setDomain_id("01");// 域id
				pvDaigEnt.setCategorycode(OpBasicDTO.getCategory_code());
				pvDaigEnt.setCategoryname(OpBasicDTO.getCategory_name());
				pvDaigEnt.setSerialno(OpBasicDTO.getSerialno());
			}
		}
	}

	/**
	 * 映射诊断信息
	 * 
	 * @param pvDaigEnt
	 * @param id_ent
	 */
	@SuppressWarnings("unchecked")
	private void MappingDiag(CidiagAggDO aggDO, IEOpPvDiagEnDTO pvDaigEnt, CiEnContextDTO ctx) throws BizException {
		if (aggDO != null) {
			FArrayList2 list = new FArrayList2();
			// 需要优化 todo
			IDeptbRService deptService = ServiceFinder.find(IDeptbRService.class);
			IPsndocRService psnService = ServiceFinder.find(IPsndocRService.class);
			String bed_no = "";
			if(!OrdEventUtil.isEmpty(aggDO.getParentDO())&&!OrdEventUtil.isEmpty(aggDO.getParentDO().getId_en())) {
				DAFacade dafacade = new DAFacade();
				SqlParam param = new SqlParam();
				param.addParam(aggDO.getParentDO().getId_en());
				String bedSql = "select name_bed from en_ent_ip where id_ent= ? ";
				List<String> bedList = (List<String>) dafacade.execQuery(bedSql.toString(),param, new ColumnListHandler());
				if (bedList != null && bedList.size() > 0) {
					bed_no = bedList.get(0).toString();
				}
			}
			PsndocAggDO psnagg = null;
			if (aggDO.getParentDO().getId_emp_sign() == null) {
				psnagg = psnService.findById(ctx.getId_emp_or());
			} else {
				psnagg = psnService.findById(aggDO.getParentDO().getId_emp_sign());
			}
			DeptBDO dept = null;
			if (aggDO.getParentDO().getId_dep_sign() == null) {
				dept = deptService.findById(ctx.getId_dep_en());
			} else {
				dept = deptService.findById(aggDO.getParentDO().getId_dep_sign());
			}
			pvDaigEnt.setDeptcode(dept.getCode());
			pvDaigEnt.setDeptname(dept.getName());
			pvDaigEnt.setBedno(bed_no);
			aggDO.getParentDO().setEmpcode(psnagg.getParentDO().getCode());
			aggDO.getParentDO().setEmpname(psnagg.getParentDO().getName());
			if (aggDO.getCiDiagItemDO() != null && aggDO.getCiDiagItemDO().length > 0) {
				for (CiDiagItemDO item : aggDO.getCiDiagItemDO()) {
					IEOpPvDiagDTO pvDiag = new IEOpPvDiagDTO();
					setPvDiag(pvDiag, item, aggDO, dept);
					list.append(pvDiag);
				}
			}
			pvDaigEnt.setIeoppvmaindiags(list);
		}
	}

	/**
	 * 
	 * @param pvDiag
	 * @param item
	 * @param aggDO
	 * @throws BizException
	 */
	private void setPvDiag(IEOpPvDiagDTO pvDiag, CiDiagItemDO item, CidiagAggDO aggDO, DeptBDO dept)
			throws BizException {
		// pvDiag.setId_ieoppvmaindiag(item.getId_ieoppvmaindiag());//
		// ie门诊就诊诊断主键标识
		// pvDiag.setId_ieoppvdiagen(item.getId_ieoppvdiagen());//
		// IE门诊诊断就诊信息主键标识
		ICidiagExtQryService iCidiagExtQryService = ServiceFinder.find(ICidiagExtQryService.class);
		FMap2 result = iCidiagExtQryService.ConvertDiagType(aggDO.getParentDO().getCode_ditp(),
				aggDO.getParentDO().getCode_entp());

		pvDiag.setDiagno(item.getSortno());// 诊断号
		// pvDiag.setDiagcode(aggDO.getParentDO().getCode_ditp());// 诊断类别编码
		// pvDiag.setDiagname(aggDO.getParentDO().getName_ditp());// 诊断类别名称
		pvDiag.setDiagcode((String) result.get("code"));// 诊断类别编码
		pvDiag.setDiagname((String) result.get("name"));// 诊断类别名称
		// <!-- 是否待查 @code: N代表是, U代表否 --> 集成平台
		if (FBoolean.TRUE.equals(item.getFg_flupci())) { // 待查诊断标志
															// Fg_flupci存在为空情况
			pvDiag.setUnconfirm("N");// 是否待查
		} else {
			pvDiag.setUnconfirm("U");// 是否待查
		}
		pvDiag.setDiseasecode(item.getId_didef_code());// 疾病编码
		pvDiag.setDiseasename(item.getId_didef_name());// 疾病名称
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date(aggDO.getParentDO().getDt_di().getMillis());
		pvDiag.setDiagtime(sdf.format(date));// 诊断时间
		pvDiag.setDoctorcode(aggDO.getParentDO().getEmpcode());// 诊断医生编码
		pvDiag.setDoctorname(aggDO.getParentDO().getEmpname());// 诊断医生名称
		pvDiag.setDeptcode(dept.getCode());// 诊断科室编码
		pvDiag.setDeptname(dept.getName());// 诊断科室编码
		pvDiag.setEmrtpcode(pvDiag.getDiagcode());// EMR系统诊断类别编码
		pvDiag.setEmrtpname(pvDiag.getDiagname());// EMR系统诊断类别名称
		if (FBoolean.TRUE.equals(item.getFg_infedi())) {
			pvDiag.setInflectable("true");// 是否传染
		} else {
			pvDiag.setInflectable("false");// 是否传染
		}

		if (FBoolean.TRUE.equals(item.getFg_majdi())) {
			pvDiag.setMain_flag("true");// 是否主诊断
		} else {
			pvDiag.setMain_flag("false");// 是否主诊断
		}

	}
}
