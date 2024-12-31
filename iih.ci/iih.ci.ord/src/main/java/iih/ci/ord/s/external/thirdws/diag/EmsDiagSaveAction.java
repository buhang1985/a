package iih.ci.ord.s.external.thirdws.diag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.pp.i.IBdHpQryService;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.diagdef.i.IDiagdefMDORService;
import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.cidiag.i.ICidiagRService;
import iih.ci.diag.dto.d.DIDTO;
import iih.ci.diag.i.ICidiagMaintainService;
import iih.ci.ord.ciorder.d.HpBeyondEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.external.thirdws.diag.d.EmsDiagDto;
import iih.ci.ord.i.external.thirdws.diag.d.EntWsDiagDTO;
import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.s.external.thirdws.op.base.OpCommonSaveAction;
import iih.ci.ord.s.external.thirdws.utils.UdidocUtils;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.entplan.i.IEnthpRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.xbd.udi.d.UdidocDO;

public class EmsDiagSaveAction extends OpCommonSaveAction {
	public static final String id_udidoc_mz = "@@@@Z7100000000PWW43";// 门诊诊断类型
	public static final String id_udidoc_code = "BD.BC.1050";// 医疗体系编码

	@Override
	public String save(EntWsDTO entwsdto) throws BizException {
		super.save(entwsdto);
		EntWsDiagDTO entWsDiagDTO = (EntWsDiagDTO) entwsdto;
		PatiVisitDO entdto = getEntDO(entWsDiagDTO.getCode_en());

		CiEnContextDTO ctx = assembleEnt(entWsDiagDTO);
		CiDiagDO ciDiagDO = assembleDiag(entWsDiagDTO, entdto);
		DIDTO[] didtos = assembleDidto(entWsDiagDTO);
		CidiagAggDO agg = assembleAgg(ciDiagDO, ctx, didtos);
		// 签署时 诊断和事件
		CidiagAggDO ret = ServiceFinder.find(ICidiagMaintainService.class).SaveCiDi(agg);
		return outexec();

	}

	public String getoutformMsg(String code, String msg) {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n");
		sqlStr.append("<root>                                   \n");
		sqlStr.append(" 		<resultcode>" + code + "</resultcode>          \n");
		sqlStr.append(" 		<resultmsg>" + msg + "</resultmsg>     \n");
		sqlStr.append("</root>                                  \n");
		return sqlStr.toString();
	}

	/**
	 * 组装就诊信息
	 * 
	 * @param entWsDiagDTO
	 * @return
	 * @throws BizException
	 */
	private CiEnContextDTO assembleEnt(EntWsDiagDTO entWsDiagDTO) throws BizException {
		IPativisitRService iEnthpRService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO[] findByAttrValString = iEnthpRService.findByAttrValString("Code", entWsDiagDTO.getCode_en());
		CiEnContextDTO ctx = new CiEnContextDTO();
		ctx.setAttrVal("Code_entp", entWsDiagDTO.getAttrVal("Code_entp"));
		if (findByAttrValString != null && findByAttrValString.length>0&&findByAttrValString[0].getCode_hp() != null) {
			ctx.setAttrVal("Id_hp", findByAttrValString[0].getCode_hp());
		}

		ctx.setAttrVal("Id_emp_or", entWsDiagDTO.getDiagList().get(0).getCode_emp_create());
		ctx.setAttrVal("Id_denp_en", entWsDiagDTO.getDiagList().get(0).getCode_dep_create());
		return ctx;

	}

	/**
	 * 组装CiDiagDo
	 * 
	 * @param entWsDiagDTO
	 * @param entdto
	 * @return
	 * @throws BizException
	 */
	public CiDiagDO assembleDiag(EntWsDiagDTO entWsDiagDTO, PatiVisitDO entdto) throws BizException {
		List<EmsDiagDto> diagList = entWsDiagDTO.getDiagList();
		DIDTO[] diDTOs = new DIDTO[diagList.size()];
		for (int i = 0; i < entWsDiagDTO.getDiagList().size(); i++) {
			DIDTO didto = new DIDTO();
			EmsDiagDto emsDiagDto = entWsDiagDTO.getDiagList().get(i);
			didto.setCode_entp(entWsDiagDTO.getCode_entp());
			didto.setSd_infectiontp(emsDiagDto.getSd_infectiontp());
			didto.setEu_hpbeyond(emsDiagDto.getEu_hpbeyond());
			didto.setFg_special(new FBoolean(emsDiagDto.getFg_special()));
			didto.setFg_chronic(new FBoolean(emsDiagDto.getFg_chronic()));
			didto.setFg_ur(new FBoolean(emsDiagDto.getFg_ur()));
			didto.setSupplement(emsDiagDto.getSupplement());
			didto.setFg_infedi(new FBoolean(emsDiagDto.getFg_infedi()));
			didto.setFg_majdi(new FBoolean(emsDiagDto.getFg_majdi()));
			// didto.setId_dep(emsDiagDto.getCode_dep_create());
			didto.setId_dep_sign(emsDiagDto.getCode_dep_create());
			didto.setId_dep_create(emsDiagDto.getCode_dep_create());
			didto.setDt_sign(new FDateTime(emsDiagDto.getDt_create()));
			didto.setDt_create(new FDateTime(emsDiagDto.getDt_create()));
			didto.setId_emp_create(emsDiagDto.getCode_emp_create());
			didto.setStatus(DOStatus.NEW);
			didto.setId_emp_sign(emsDiagDto.getCode_emp_create());
			didto.setId_pat(entdto.getId_pat());
			didto.setId_en(entdto.getId_ent());
			didto.setDt_di(new FDateTime(emsDiagDto.getDt_create()));
			didto.setId_disease_code(emsDiagDto.getCode_didef());
			didto.setId_disease_name(emsDiagDto.getName_didef());
			didto.setDidef_code(emsDiagDto.getCode_didef());
			didto.setDidef_name(emsDiagDto.getName_didef());
			didto.setFg_sign(FBoolean.TRUE);
			didto.setId_entp(entdto.getId_entp());
			didto.setId_ditp(id_udidoc_mz);
			didto.setSd_ditp("00");
			diDTOs[i] = didto;

		}
		CiDiagDO ciDiagDO = getCiDiagDO(diDTOs);
		return ciDiagDO;

	}

	private DIDTO[] assembleDidto(EntWsDiagDTO entWsDiagDTO) {
		List<EmsDiagDto> diagList = entWsDiagDTO.getDiagList();
		DIDTO[] diDTOs = new DIDTO[diagList.size()];
		for (int i = 0; i < entWsDiagDTO.getDiagList().size(); i++) {
			DIDTO didto = new DIDTO();
			EmsDiagDto emsDiagDto = entWsDiagDTO.getDiagList().get(i);
			didto.setCode_entp(entWsDiagDTO.getCode_entp());
			didto.setSd_infectiontp(emsDiagDto.getSd_infectiontp());
			didto.setEu_hpbeyond(emsDiagDto.getEu_hpbeyond());
			didto.setFg_special(new FBoolean(emsDiagDto.getFg_special()));
			didto.setFg_chronic(new FBoolean(emsDiagDto.getFg_chronic()));
			didto.setFg_ur(new FBoolean(emsDiagDto.getFg_ur()));
			didto.setSupplement(emsDiagDto.getSupplement());
			didto.setFg_infedi(new FBoolean(emsDiagDto.getFg_infedi()));
			didto.setFg_majdi(new FBoolean(emsDiagDto.getFg_majdi()));
			didto.setId_dep(emsDiagDto.getCode_dep_create());
			didto.setId_dep_sign(emsDiagDto.getCode_dep_create());
			didto.setId_dep_create(emsDiagDto.getCode_dep_create());
			didto.setDt_sign(new FDateTime(emsDiagDto.getDt_create()));
			didto.setDt_create(new FDateTime(emsDiagDto.getDt_create()));
			didto.setId_emp_create(emsDiagDto.getCode_emp_create());
			didto.setStatus(DOStatus.NEW);
			didto.setId_emp_sign(emsDiagDto.getCode_emp_create());
			didto.setId_pat(entWsDiagDTO.getCode_pat());
			didto.setId_en(entWsDiagDTO.getCode_en());
			didto.setDt_di(new FDateTime(emsDiagDto.getDt_create()));
			didto.setId_disease_code(emsDiagDto.getCode_didef());
			didto.setId_disease_name(emsDiagDto.getName_didef());
			didto.setDidef_code(emsDiagDto.getCode_didef());
			didto.setDidef_name(emsDiagDto.getName_didef());
			didto.setFg_sign(FBoolean.TRUE);
			// 生成主键
			String[] id_didef = new DBUtil().getOIDs(1);
			didto.setId_didef(id_didef[0]);
			diDTOs[i] = didto;

		}
		return diDTOs;

	}

	/**
	 * 组装CidiagAggDO
	 * 
	 * @param ciDiagDO
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	private CidiagAggDO assembleAgg(CiDiagDO ciDiagDO, CiEnContextDTO ctx, DIDTO[] didtos) throws BizException {
		CidiagAggDO agg = new CidiagAggDO();
		agg.setParentDO(ciDiagDO);
		CidiagAggDO tempAgg = null;
		if (StringUtils.isNotEmpty(ciDiagDO.getId_di())) {
			tempAgg = getCidiagAggDO(ciDiagDO.getId_di());
		}
		List<CiDiagItemDO> itemList = new ArrayList<CiDiagItemDO>();
		List<String> idDiDefList = new ArrayList<String>();// bd的诊断主键
		List<String> diCodeList = new ArrayList<String>();// bd的诊断编码
		// 临床诊断 明细表
		String str = getCiDiagItemDO(itemList, tempAgg, didtos, idDiDefList, diCodeList);
		// 诊断描述信息
		// String signName = diDTO[0].getName_emp_sign();
		ciDiagDO.setDes_di(str);

		// 获取保外诊断判断结果，key值诊断定义id， value true 保内诊断，Y 保外诊断
		Map<String, FBoolean> map = null;
		if (StringUtils.isNotEmpty(ctx.getId_hp())) {

			String idDidefs[] = idDiDefList.toArray(new String[idDiDefList.size()]);
			// map = CommonUtil.BdHpDiJudge(ctx.getId_hp(), idDidefs,
			// diDTOs[0].getId_entp());
			map = ServiceFinder.find(IBdHpQryService.class).isSelfPaidDi(ctx.getId_hp(), ctx.getCode_entp(), idDidefs);

		}

		String idDidef = "";
		// 设置诊断明细
		if (itemList != null && itemList.size() > 0) {
			CiDiagItemDO[] items = new CiDiagItemDO[itemList.size()];
			int i = 0;

			String[] id_didef = new String[itemList.size()];
			if (map != null && map.size() > 0) {
				for (CiDiagItemDO item : itemList) {
					if (map.containsKey(item.getId_didef())) {
						if (FBoolean.TRUE.equals(map.get(item.getId_didef()))) {
							item.setEu_hpbeyond(HpBeyondEnum.HPEXTERNALDIAG);// 医保外
							idDidef += "," + item.getId_didef();
						} else {
							item.setEu_hpbeyond(HpBeyondEnum.HPDIAG);// 医保内
						}
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

		cidiag = new CiDiagDO();
		cidiag.setStatus(DOStatus.NEW);

		cidiag.setId_dep(item.getId_dep());
		cidiag.setFg_sign(item.getFg_sign());
		if (cidiag.getFg_sign().isValue()) {
			cidiag.setDt_sign(item.getDt_create());
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
		cidiag.setDt_di(item.getDt_create());

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

			ciDiagitem = new CiDiagItemDO();
			ciDiagitem.setStatus(DOStatus.NEW);

			ciDiagitem.setId_diitm(item.getId_diitm());
			ciDiagitem.setId_di(item.getId_di());
			ciDiagitem.setSortno(i + "");
			ciDiagitem.setDidef_name(item.getDidef_name());
			ciDiagitem.setDidef_code(item.getDidef_code());

			DiagDefDO[] diagDefDOs1 = ServiceFinder.find(IDiagdefMDORService.class).findByAttrValString("Code",
					item.getDidef_code());
			if (diagDefDOs1 != null && diagDefDOs1[0].getSd_cdsystp() != null) {
				UdidocDO udidoc = UdidocUtils.getUdidocByCode(id_udidoc_code, diagDefDOs1[0].getSd_cdsystp());

				ciDiagitem.setId_disys(udidoc.getId_udidoc());
				ciDiagitem.setSd_disys(diagDefDOs1[0].getSd_cdsystp());
				ciDiagitem.setId_disys_name(udidoc.getName());
			}

			if (item.getDidef_name() != null) {
				DiagDefDO[] diagDefDOs = ServiceFinder.find(IDiagdefMDORService.class).findByAttrValString("Code",
						item.getDidef_code());
				if (diagDefDOs != null && diagDefDOs[0].getId_didef() != null) {
					ciDiagitem.setId_didef(diagDefDOs[0].getId_didef());
				}
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
			// ciDiagitem.setId_disys(item.getId_disys());
			/*
			 * if (this.namemap != null && this.codemap != null) {
			 * ciDiagitem.setSd_disys(this.codemap.get(item.getId_disys()));
			 * ciDiagitem.setId_disys_name(this.namemap.get(item.getId_disys()))
			 * ; }
			 */
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

	public String outexec() {
		return getoutformMsg("0", "诊断保存成功");
	}

	

	private CidiagAggDO getCidiagAggDO(String id_di) throws BizException {

		CidiagAggDO agg = ServiceFinder.find(ICidiagRService.class).findById(id_di);
		/*
		 * if(agg !=null && agg.getCiDiagItemDO() != null &&
		 * agg.getCiDiagItemDO().length >0)
		 * CiDiUtils.getICidiagCudService().delete(new CidiagAggDO[]{agg});
		 */
		return agg;
	}

}