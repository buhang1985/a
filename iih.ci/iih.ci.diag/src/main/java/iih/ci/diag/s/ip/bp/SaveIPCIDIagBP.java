package iih.ci.diag.s.ip.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.dto.d.DIDTO;
import iih.ci.diag.log.Diaglogger;
import iih.ci.diag.pub.CiDiAppUtils;
import iih.ci.diag.pub.CommonUtil;
import iih.ci.diag.s.CiDiUtils;
import iih.ci.diag.s.bp.CiDiCurrentBP;
import iih.ci.diag.s.bp.JudgeOrderDiagBP;
import iih.ci.diag.s.bp.qry.getUdiDocListsMapQry;
import iih.ci.ord.ciorder.d.HpBeyondEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.en.pv.entdi.d.EntDiDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.xbd.udi.d.UdidocDO;
/**
 * 住院诊断保存
 * @author li_zheng
 *
 */
public class SaveIPCIDIagBP {
	private  Map<String,String> namemap = null;
	private  Map<String,String> codemap = null;;
	
	/**
	 * 查询诊断体系，并缓存Map结构，key 诊断体系id， value 诊断体系名称
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
	 * 诊断保存
	 * @param diDTOs
	 * @param des
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	public DIDTO[] exec(DIDTO[] diDTOs, String des, CiEnContextDTO ctx) throws BizException {
		long tBeginTime = System.currentTimeMillis();
		if (diDTOs == null || diDTOs.length <= 0)
			return null;

		if (this.namemap == null) {
			this.getUdidocMap();
		}

		// 将DIDTO对象转换为 CiDiagDO 
		CiDiagDO cidiag =  getCiDiagDO(diDTOs, ctx);

		if (StringUtils.isNotEmpty(diDTOs[0].getDidef_code())) {
			CidiagAggDO agg = new CidiagAggDO();
			agg.setParentDO(cidiag);

			CidiagAggDO tempAgg = null;
			if (StringUtils.isNotEmpty(cidiag.getId_di())) {
				tempAgg = getCidiagAggDO(cidiag.getId_di());
			}
			List<CiDiagItemDO> itemList = new ArrayList<CiDiagItemDO>();
			List<String> idDiDefList = new ArrayList<String>();//bd的诊断主键
			List<String> diCodeList = new ArrayList<String>();//bd的诊断编码
			// 临床诊断 明细表
			String str = getCiDiagItemDO(itemList, tempAgg, diDTOs, idDiDefList,diCodeList);
			//诊断描述信息
			//String signName = diDTO[0].getName_emp_sign();
			if (StringUtils.isEmpty(des)) {
				cidiag.setDes_di(str);
			} else {
				cidiag.setDes_di(des);
			}

			// 获取保外诊断判断结果，key值诊断定义id， value true 保内诊断，Y 保外诊断
			Map<String, FBoolean> map = null;
			if (StringUtils.isNotEmpty(ctx.getId_hp())) {

				String idDidefs[] = idDiDefList.toArray(new String[idDiDefList.size()]);
				//map = CommonUtil.BdHpDiJudge(ctx.getId_hp(), idDidefs, diDTOs[0].getId_entp());
				 map = CiDiUtils.getBdHpQrySerice().isSelfPaidDi(ctx.getId_hp(), diDTOs[0].getId_entp(), idDidefs);
			
			}

			String idDidef = "";
			//设置诊断明细
			if (itemList != null && itemList.size() > 0) {
				CiDiagItemDO[] items = new CiDiagItemDO[itemList.size()];
				int i = 0;

				String[] id_didef = new String[itemList.size()];
				if (map != null && map.size() > 0) {
					for (CiDiagItemDO item : itemList) {
						if (map.containsKey(item.getId_didef())) {
							if (FBoolean.TRUE.equals(map.get(item.getId_didef()))) {
								item.setEu_hpbeyond(HpBeyondEnum.HPEXTERNALDIAG);//医保外
								idDidef += "," + item.getId_didef();
							} else {
								item.setEu_hpbeyond(HpBeyondEnum.HPDIAG);//医保内
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
            //有自费医嘱 没有自费诊断了
			JudgeOrderDiagBP bp = new JudgeOrderDiagBP();
			/* if( bp.getEffectiveOrder(ctx)==FBoolean.TRUE){
				if(idDidef.length() <= 0){
					throw new BizException("有自费医嘱，必须有自费诊断");
				}
			 }*/
			 
			if (cidiag.getFg_sign().isValue()) {
				if (idDidef.length() > 0) {
					//bd 诊断的拼接 
					ctx.setDes_bhpjudgerst(idDidef.substring(1));
				}
				//判断是否有医嘱  有是有使用的诊断
				
				bp.JudgeOrderDiag(agg, ctx);

				// 签署时 诊断和事件
				CidiagAggDO ret = CiDiUtils.getCidiagMaintainServiceImpl().SaveCiDi(agg);
				setIddi4Rst(ret.getParentDO(),diDTOs);
				//删除就诊域的原由的诊断
				EntDiDO[] entDiDOs = CiDiUtils.getIEntdiRService().find(
						"a0.id_ent ='" + agg.getParentDO().getId_en() + "'", "id_ent", FBoolean.FALSE);
				if (entDiDOs != null && entDiDOs.length > 0) {
					CiDiUtils.getIEntdiCudService().delete(entDiDOs);
				}
				//删除就诊域的原由的诊断
				CogradientCiDiagToEnDiagBP cogradient = new CogradientCiDiagToEnDiagBP();
				cogradient.CogradientCiDiagToEnDiag(ret.getParentDO().getId_en());
				 //诊断的集成平台事件
				IEIpDiagFireEventBP ieFireEvent = new IEIpDiagFireEventBP();
				ieFireEvent.IEDiagFireEvent(ret,ctx);
				
			} else {
				// 住院诊断保存时，非签署
				CidiagAggDO[] aggdo = CiDiUtils.getICidiagCudService().save(new CidiagAggDO[] { agg });
				setIddi4Rst(aggdo[0].getParentDO(),diDTOs);
			}

			if (map != null && map.size() > 0) {

				for (DIDTO diDTO : diDTOs) {
					// 判断是否存在保外诊断
					if (map.containsKey(diDTO.getId_didef()) && FBoolean.TRUE.equals(map.get(diDTO.getId_didef()))) {
						diDTO.setEu_hpbeyond(HpBeyondEnum.HPEXTERNALDIAG);
					}
				}
			}
		} else {
			CiDiagDO[] res = CiDiAppUtils.getICidiagMDOCudService().save(new CiDiagDO[] { cidiag });
			setIddi4Rst(res[0],diDTOs);

			//删除就诊域的原有的诊断
			EntDiDO[] entDiDOs = CiDiUtils.getIEntdiRService().find("a0.id_ent ='" + cidiag.getId_en() + "'", "id_ent",
					FBoolean.FALSE);
			if (entDiDOs != null && entDiDOs.length > 0) {
				CiDiUtils.getIEntdiCudService().delete(entDiDOs);
			}

			CidiagAggDO aggDO = new CidiagAggDO();
			aggDO.setParentDO(res[0]);
			//诊断的集成平台事件
			//IEDiagFireEvent(aggDO);
		}
		Diaglogger.info(ctx, String.format("诊断保存[%s]，有效性判断,耗时:%s(ms)", des,System.currentTimeMillis()-tBeginTime));
		return diDTOs;
	}
	
	private  CidiagAggDO getCidiagAggDO(String id_di) throws BizException{

		CidiagAggDO agg= CiDiUtils.getICidiagRService().findById(id_di);
		/* if(agg !=null && agg.getCiDiagItemDO() != null && agg.getCiDiagItemDO().length >0)
		  CiDiUtils.getICidiagCudService().delete(new CidiagAggDO[]{agg});*/
		return agg;
	}
	/**
	 *   返回结果设置id_di
	 * @param aggdo
	 * @param diDTOs
	 */
	private void setIddi4Rst(CiDiagDO aggdo,DIDTO[] diDTOs) {
		for (DIDTO didto : diDTOs) {
			didto.setId_di(aggdo.getId_di());
		}
	}
	
	/**
	 * 临床诊断主表
	 * 
	 * @param cidiag
	 * @param diDTO
	 * @throws BizException
	 */
	private CiDiagDO getCiDiagDO(DIDTO[] diDTO, CiEnContextDTO ctx) throws BizException {

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
		cidiag.setId_pat(ctx.getId_pat());
		cidiag.setId_entp(ctx.getId_entp());
		cidiag.setCode_entp(ctx.getCode_entp());
		cidiag.setId_en(ctx.getId_en());
		cidiag.setId_ditp(item.getId_ditp());
		cidiag.setSd_ditp(item.getSd_ditp());
		cidiag.setDes_di(item.getDes_di());
		
	//	cidiag.setDt_di(item.getDt_di());
		if(item.getDt_di() != null){
			cidiag.setDt_di(item.getDt_di());
		}else{
			cidiag.setDt_di(CommonUtil.getDateTime());
		}

		
		cidiag.setFg_cancel(FBoolean.FALSE);
		StringBuffer sb = new StringBuffer();
		//暂时注释
		//sb.append(item.getId_disys()); 
		sb.append(" ");
		sb.append(item.getId_disys_name());
		//sb.append(item.getId_emp_create_name());
		//sb.append(item.getDt_di());
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
	private String getCiDiagItemDO(List<CiDiagItemDO> items, CidiagAggDO tempAgg, DIDTO[] diDTO, List<String> IddidefList,List<String> dicodes)
			throws BizException {
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
				//ciDiagitem = CiDiUtils.getICiDiagItemDORService().findById(item.getId_diitm());
				if (map.containsKey(item.getId_diitm())) {
					ciDiagitem = map.get(item.getId_diitm());
					ciDiagitem.setStatus(DOStatus.UPDATED);
					map.remove(item.getId_diitm());
				} else {
					ciDiagitem = new CiDiagItemDO();
					//ciDiagitem.setId_diitm(item.getId_diitm());
					ciDiagitem.setStatus(DOStatus.NEW);
				}

			} else {
				ciDiagitem = new CiDiagItemDO();
				ciDiagitem.setStatus(DOStatus.NEW);
			}
			ciDiagitem.setId_diitm(item.getId_diitm());
			ciDiagitem.setId_di(item.getId_di());
			if(i<10) {
				ciDiagitem.setSortno("0"+i);	
			}else {
				ciDiagitem.setSortno(i + "");
			}
			

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
			//ciDiagitem.setDes(item.getDes());
			ciDiagitem.setFg_majdi(item.getFg_majdi());
			ciDiagitem.setFg_suspdi(item.getFg_suspdi());
			//ciDiagitem.setFg_infedi(item.getFg_infedi());
			//ciDiagitem.setId_parent(item.getId_parent());
			//ciDiagitem.setInnercode(item.getInnercode());
			//ciDiagitem.setFg_flupci(item.getFg_flupci());
			//ciDiagitem.setFg_sym(item.getFg_sym());
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
			ciDiagitem.setFg_self(item.getFg_self());//zwq 2016-8-19 自定义诊断标识
			ciDiagitem.setInnercode(item.getInnercode());//zwq 2016-8-19 内部编码
			ciDiagitem.setId_parent(item.getId_par());//zwq 2016-8-19 上级编码
			ciDiagitem.setFg_ur(item.getFg_ur());//zwq 2016-9-2 上级编码
			ciDiagitem.setFg_chronic(item.getFg_chronic()); //慢性病标志
			ciDiagitem.setFg_special(item.getFg_special());//特种病标志
			ciDiagitem.setId_infectiontp(item.getId_infectiontp());
			ciDiagitem.setSd_infectiontp(item.getSd_infectiontp());
			item.setSortno(num + "");
			// 西医内容拼接
			if (item.getId_disys() == ICiDictCodeConst.ID_CI_DISYS_XYZDTX) {
				sb.append(num + "," + item.getDidef_name());
				//sb.append("\n");
				if (item.getSupplement() != null && item.getSupplement() != "") {
					sb.append("——" + item.getSupplement());
				}

				sb.append("          \n");

			} else if (item.getId_disys() == ICiDictCodeConst.ID_CI_DISYS_ZYZDTX) {
				//中医内容拼接
				sb.append(item.getId_disys_name() + " ");
				sb.append(num + "," + item.getId_disease_name());
				sb.append(" \n");
				sb.append(item.getId_didef_syn_name());
				sb.append("         \n");
			} else {
				//其它
				sb.append(num + "," + item.getDidef_name());
				//sb.append("\n");
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
	//诊断项目的 key  value
	private Map<String, CiDiagItemDO> getCidiItemKeyValue(CiDiagItemDO[] ciditem){
		if (ciditem == null)
			return null;
		Map<String, CiDiagItemDO> map = new HashMap<String, CiDiagItemDO>();
		for (CiDiagItemDO item : ciditem) {
			map.put(item.getId_diitm(), item);
		}
		return map;
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
		// EntDiDO[] entdis =null;
		List<EntDiDO> entdis = new ArrayList<EntDiDO>();
		if (aggs != null) {
			boolean Fg_maj = false;
			for (CidiagAggDO agg : aggs) {
				int i = 0;
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
			}
		}
		return entdis.toArray(new EntDiDO[] {});
	}
}
