package iih.ci.ord.s.bp.assi.tl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.ortpl.d.OrTmplDO;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.tmpl.d.CiOrTmplDTO;
import iih.ci.ord.tmpl.d.CiOrTmplSrvDTO;
import iih.ci.ord.tmpl.d.LongTempOrEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;

/**
 * 将OrTplNItmDO对象集合 转换为标准医嘱模板CiOrTmplDTO对象集合 BP
 * 
 * @author HUMS
 *
 */
public class ConvertOrtmlNItem2CiOrTmplBP {

	// 数据来源	
	private String eu_orsrcmdtp;

	public ConvertOrtmlNItem2CiOrTmplBP() {

	}

	public List<CiOrTmplDTO> exec(OrTplNItmDO[] orTplNItms, String eu_orsrcmdtp) throws BizException {

		this.eu_orsrcmdtp = eu_orsrcmdtp;
		return this.getCiortmplAggDTO(orTplNItms);
	}

	/**
	 * 医嘱助手-医嘱模板映射成逻辑的医嘱模板
	 * 
	 * @param ortplItemDO
	 * @return
	 * @throws BizException
	 */
	private List<CiOrTmplDTO> getCiortmplAggDTO(OrTplNItmDO[] orTplNItms) throws BizException {
		if (orTplNItms == null || orTplNItms.length == 0)
			throw new BizException("没有选中的数据");
		//return null;
		JudgeOrderTemlateType judge = new JudgeOrderTemlateType();
		// 医嘱模板
		FMap2 map = judge.JudgeOrederTemlate(orTplNItms);
		if (map == null || map.size() == 0)
			return null;
		List<CiOrTmplDTO> tmpList = new ArrayList();

		//医嘱模板的优化
		List ortmplList = (List) map.get("ortmplList");
		FMap2 ortmplDOMap = OptimaizationOrTplNItmDO(ortmplList);
		map.remove("ortmplList");
		for (Object list : map.values()) {
			List temp = (List) list;
			if (temp != null && temp.size() > 0) {
				FArrayList srvlist = new FArrayList();
				CiOrTmplDTO aggdto = new CiOrTmplDTO();
				OrTplNItmDO orTplItem = (OrTplNItmDO) temp.get(0);
				// 映射医嘱
				MappingFieldOrder(aggdto, orTplItem, ortmplDOMap);
				aggdto.setDt_effe(orTplNItms[0].getDt_effe());
				aggdto.setFg_pres_outp("2".equals(orTplItem.getSd_drugdeliverymethod()) 
						? FBoolean.TRUE : FBoolean.FALSE);
				aggdto.setFg_wholepack("1".equals(orTplItem.getSd_drugdeliverymethod()) 
						? FBoolean.TRUE : FBoolean.FALSE);
				aggdto.setId_drugdeliverymethod(orTplItem.getId_drugdeliverymethod());
				aggdto.setSd_drugdeliverymethod(orTplItem.getSd_drugdeliverymethod());
				aggdto.setName_drugdeliverymethod(orTplItem.getName_drugdeliverymethod());
				//增加关联医嘱（护嘱增加的）
				aggdto.setId_or_rel(orTplNItms[0].getId_or_rel());
				for (int i = 0; i < temp.size(); i++) {
					
					orTplItem = (OrTplNItmDO) temp.get(i);
					// 映射医嘱的项目
					// srvlist.
					srvlist.append(MappinfieldOrderSrv(aggdto, orTplItem));

				}
				aggdto.setOrtmplsrvs(srvlist);
				tmpList.add(aggdto);
			}
		}

		//		List commonDrugList = (List) map.get(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG);
		//		List herbalDrugList = (List) map.get(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG);
		//
		//		// 普通药品（单服务）
		//		if (commonDrugList != null && commonDrugList.size() > 0) {
		//			// FArrayList srvlist = new FArrayList();
		//			for (int i = 0; i < commonDrugList.size(); i++) {
		//				FArrayList srvlist = new FArrayList();
		//				CiOrTmplDTO aggdto = new CiOrTmplDTO();
		//				OrTplNItmDO orTplItem = (OrTplNItmDO) commonDrugList.get(i);
		//				// 映射医嘱
		//				MappingFieldOrder(aggdto, orTplItem);
		//				// 映射医嘱的项目
		//				// srvlist.
		//				srvlist.append(MappinfieldOrderSrv(aggdto, orTplItem));
		//				aggdto.setOrtmplsrvs(srvlist);
		//				tmpList.add(aggdto);
		//			}
		//		}
		//
		//		// 草药 注射类（多服务）
		//		if (herbalDrugList != null && herbalDrugList.size() > 0) {
		//			CiOrTmplDTO aggdto = new CiOrTmplDTO();
		//			FArrayList srvlist = new FArrayList();
		//			for (int i = 0; i < herbalDrugList.size(); i++) {
		//				OrTplNItmDO orTplItem = (OrTplNItmDO) herbalDrugList.get(i);
		//				MappingFieldOrder(aggdto, orTplItem);
		//				srvlist.append(MappinfieldOrderSrv(aggdto, orTplItem));
		//			}
		//			aggdto.setOrtmplsrvs(srvlist);
		//			tmpList.add(aggdto);
		//		}
		return tmpList;
	}

	/**
	 * 查询出医嘱模板集合
	 * 
	 * @param map
	 * @return
	 * @throws BizException
	 */
	private FMap2 OptimaizationOrTplNItmDO(List<String> list) throws BizException {
		FMap2 orTemplmap = new FMap2();
		if (list == null || list.size() == 0)
			return null;
		String[] ids = list.toArray(new String[0]);
		OrTmplDO[] ortmpl = CiOrdAppUtils.getIOrtmplMDORService().findByIds(ids, FBoolean.FALSE);
		if (ortmpl != null && ortmpl.length > 0) {
			for (OrTmplDO ortmplDO : ortmpl) {
				orTemplmap.put(ortmplDO.getId_ortmpl(), ortmplDO);
			}
		}
		return orTemplmap;
	}

	/**
	 * 套本身
	 * 
	 * @param ortmpl
	 * @return
	 * @throws BizException
	 */
	private OrTplNItmDO MappingOrSetItem(OrTplNItmDO orTplItem) throws BizException {
		MedSrvDO medsrvDO = CiOrdAppUtils.getMedsrvMDORService().findById(orTplItem.getId_srv());
		if (medsrvDO != null) {
			OrTplNItmDO item = new OrTplNItmDO();
			item.setId_srv(medsrvDO.getId_srv());
			item.setOrtplnitm_srv_name(medsrvDO.getName());
			item.setId_ortmpl(orTplItem.getId_ortmpl());
			item.setId_boil(medsrvDO.getId_boil());
			item.setId_boildes(medsrvDO.getId_boildes());
			item.setQuan_med(medsrvDO.getQuan_med());
			item.setId_freq(medsrvDO.getId_freq());
			//item.setId_mm(medsrvDO.getId_mm);
			item.setId_ortmplitm(medsrvDO.getId_srv());
			item.setId_route(medsrvDO.getId_route());
			item.setId_routedes(medsrvDO.getId_routedes());
			item.setId_srvtp(medsrvDO.getId_srvtp());
			item.setSd_srvtp(medsrvDO.getSd_srvtp());
			item.setId_unit_med(medsrvDO.getId_unit_med());
			item.setOrtplnitm_boildes_name(medsrvDO.getBoil_name());
			item.setOrtplnitm_freq_name(medsrvDO.getFreq_name());
			item.setOrtplnitm_route_name(medsrvDO.getRoute_name());
			item.setOrtplnitm_routedes_name(medsrvDO.getRoutedes_name());
			item.setOrtplnitm_unit_name(medsrvDO.getMed_name());
			return item;
		}
		return null;
	}

	/**
	 * 医嘱 字段映射
	 * 
	 * @param dto
	 * @param orTplItem
	 */
	private void MappingFieldOrder(CiOrTmplDTO dto, OrTplNItmDO orTplItem, FMap2 ortmplDOMap) throws BizException {

		//OrTmplDO orTmplDO = CiOrdAppUtils.getIOrtmplMDORService().findById(orTplItem.getId_ortmpl());
		OrTmplDO orTmplDO = (OrTmplDO) ortmplDOMap.get(orTplItem.getId_ortmpl());
		// dto.setId_ciortmpl(orTplItem.getId_ciortmpl());//临床医嘱模板主键标识
		// dto.setOrtmplsrvs(orTplItem.getOrtmplsrvs());//医嘱模板项目列表
		dto.setEu_orsrcmdtp(this.eu_orsrcmdtp);// 临床医嘱来源类型
		dto.setId_orsrc_main(orTplItem.getId_ortmpl());// 来源ID_主 医嘱模板主表
		dto.setId_orsrc_sub(orTplItem.getId_ortmplitm());// 来源ID_子 医嘱模板明细
		//
		dto.setCode(orTplItem.getOrtplnitm_srv_code());// 编码
		// tId_srv_set 计算字段，前台赋值
		if (orTplItem.getId_srv_set() != null && orTplItem.getId_srv_set() != "") {
			//dto.setName(orTplItem.getOrtplnitm_mm_name());// 名称
			dto.setId_srv(orTplItem.getId_srv_set());//   套 id
			dto.setFg_set(FBoolean.TRUE);
			MedSrvDO medsrvDO = CiOrdAppUtils.getMedsrvMDORService().findById(orTplItem.getId_srv_set());
			//只有皮试套才有这样的特殊操作，皮试套中项目与主服务的类型和频次可能是不一致的
			dto.setId_freq(medsrvDO.getId_freq());// 医嘱频次
			dto.setId_srvtp(medsrvDO.getId_srvtp());// 医嘱类型
			dto.setSd_srvtp(medsrvDO.getSd_srvtp());// 医嘱类型编码
		} else {
			if(!StringUtils.isBlank(orTplItem.getName_srv())){
				dto.setName(orTplItem.getName_srv());// 名称
			}else{
				dto.setName(orTplItem.getOrtplnitm_srv_name());// 名称
			}
			dto.setId_srv(orTplItem.getId_srv());
			dto.setFg_set(FBoolean.FALSE);
			dto.setId_freq(orTplItem.getId_freq());// 医嘱频次
			dto.setId_srvtp(orTplItem.getId_srvtp());// 医嘱类型
			dto.setSd_srvtp(orTplItem.getSd_srvtp());// 医嘱类型编码
		}

		/*if(OrTplItmTypeEnum.SRVSET==orTplItem.getEu_ortplitmtp()){
			 dto.setName(orTplItem.getOrtplnitm_mm_name());// 名称
			 dto.setId_srv(orTplItem.getId_srv());//   套 id
			 orTplItem.setId_srv_set(orTplItem.getId_srv());
		}
		*/
		dto.setEu_long(LongTempOrEnum.TEMPORARYOR);// 长期临时类型
		dto.setId_route(orTplItem.getId_route());// 用法
		dto.setId_routedes(orTplItem.getId_routedes());// 用法要求
		dto.setId_boil(orTplItem.getId_boil());// 煎法
		dto.setId_boildes(orTplItem.getId_boildes());// 煎法要求
		dto.setDays_or(orTplItem.getDays_or());// 医嘱天数
		dto.setOrders(orTplItem.getOrders());// 医嘱付数
		// dto.setFg_boil(orTemplateDO.getfg);//代煎标识
		if(orTmplDO != null){
			dto.setDes_or(orTmplDO.getDes_or());
//			dto.setDays_or(orTmplDO.getDays_or());// 医嘱天数
		}

		// 草药设置医嘱付数
		if (CiOrdUtils.isHerbOrder(dto.getSd_srvtp()) && dto.getOrders() == null) {
               if(orTmplDO != null){
       			dto.setOrders(orTmplDO.getOrders() != null ? orTmplDO.getOrders() : CiOrdUtils.getDefaultOrders());// 医嘱付数
               }else{
            	   dto.setOrders(CiOrdUtils.getDefaultOrders());  
               }
		}
		dto.setFg_boil(orTplItem.getFg_boil());
		// dto.setTimes(orTemplateDO.getTimes());//医嘱次数
		// dto.setDes_or(orTemplateDO.getDes_or());//医嘱描述

	}

	/**
	 * 映射医嘱的项目
	 * 
	 * @param aggDTO
	 * @param orTplItem
	 */
	private CiOrTmplSrvDTO MappinfieldOrderSrv(CiOrTmplDTO ciOrtemplateDTO, OrTplNItmDO orTplItem) throws BizException {

		CiOrTmplSrvDTO srvDTO = new CiOrTmplSrvDTO();
		MedSrvDO medSrvDO = CiOrdAppUtils.getIMedsrvMDORService().findById(orTplItem.getId_srv());
		// srvDTO.setId_ciortmplsrv(orTplItem.getId_ciortmplsrv());//临床医嘱模板项目主键标识
		// srvDTO.setId_ciortmpl(orTplItem.getId_ciortmpl());//临床医嘱模板
		srvDTO.setSortno(orTplItem.getSortno());// 序号
		srvDTO.setId_srv(orTplItem.getId_srv());// 服务
		// srvDTO.setOrtplnitm_srv_name(orTplItem.getOrtplnitm_srv_name());
		// srvDTO.setFg_selfsrv(medSrvDO.getFg_selfsrv());//自定义服务标识
		// srvDTO.setName_selfsrv(medSrvDO.get);//自定义服务名
		srvDTO.setFg_set(medSrvDO.getFg_set());// 套标识
		srvDTO.setId_srvtp(orTplItem.getId_srvtp());// 服务类型
		srvDTO.setSd_srvtp(orTplItem.getSd_srvtp());// 服务类型编码
		if (orTplItem.getId_freq() != null && orTplItem.getId_freq() != "") {
			srvDTO.setId_freq(orTplItem.getId_freq());// 频次
		} else {
			srvDTO.setId_freq(medSrvDO.getId_freq());// 频次
		}
		if (orTplItem.getId_route() != null && orTplItem.getId_route() != "") {
			srvDTO.setId_route(orTplItem.getId_route());// 用法
		} else {
			srvDTO.setId_route(medSrvDO.getId_route());// 用法
		}
		if (orTplItem.getId_route() != null && orTplItem.getId_route() != "") {
			srvDTO.setId_route(orTplItem.getId_route());// 用法
		} else {
			srvDTO.setId_route(medSrvDO.getId_route());// 用法
		}
		if (orTplItem.getId_route() != null && orTplItem.getId_route() != "") {
			srvDTO.setId_route(orTplItem.getId_route());// 用法
		} else {
			srvDTO.setId_route(medSrvDO.getId_route());// 用法
		}
		if (orTplItem.getId_routedes() != null && orTplItem.getId_routedes() != "") {
			srvDTO.setId_routedes(orTplItem.getId_routedes());// 要求
		} else {
			srvDTO.setId_routedes(medSrvDO.getId_routedes());// 要求
		}
		if (orTplItem.getId_routedes() != null && orTplItem.getId_routedes() != "") {
			srvDTO.setId_routedes(orTplItem.getId_routedes());// 要求
		} else {
			srvDTO.setId_routedes(medSrvDO.getId_routedes());// 要求
		}
		if (orTplItem.getId_boil() != null && orTplItem.getId_boil() != "") {
			srvDTO.setId_boil(orTplItem.getId_boil());// 煎法
		} else {
			srvDTO.setId_boil(medSrvDO.getId_boil());// 煎法
		}
		if (orTplItem.getId_boildes() != null && orTplItem.getId_boildes() != "") {
			srvDTO.setId_boildes(orTplItem.getId_boildes());// 中医要求
		} else {
			srvDTO.setId_boildes(medSrvDO.getId_boildes());// 中医要求
		}
		//自定义医嘱剂量和单位模板是什么就是什么，不能随意赋值
		if (FBoolean.TRUE.equals(medSrvDO.getFg_ctm())) {
			srvDTO.setId_unit_med(orTplItem.getId_unit_med());// 医学单位
			srvDTO.setQuan_med(orTplItem.getQuan_med());// 医学单位数值
		}else{
			if (orTplItem.getId_unit_med() != null && orTplItem.getId_unit_med() != "") {
				srvDTO.setId_unit_med(orTplItem.getId_unit_med());// 医学单位
			} else {
				srvDTO.setId_unit_med(medSrvDO.getId_unit_med());// 医学单位
			}
			if (orTplItem.getQuan_med() != null) {
				srvDTO.setQuan_med(orTplItem.getQuan_med());// 医学单位数值
			} else {
				srvDTO.setQuan_med(medSrvDO.getQuan_med());// 医学单位数值
			}
		}
		
		// srvDTO.setQuan_total_medu(orTplItem.getQuan_total_medu());//服务总量
		if (orTplItem.getSd_drugdeliverymethod()!=null) {
			srvDTO.setQuan_total_medu(orTplItem.getQuan_total_medu());
			srvDTO.setId_unit_sale(orTplItem.getId_total_medu());
			srvDTO.setSd_drugdeliverymethod(orTplItem.getSd_drugdeliverymethod());
		}else{
			srvDTO.setQuan_total_medu(orTplItem.getQuan_med());// todo
		}
		
		srvDTO.setId_dep_mp(orTplItem.getId_dep_mp());// 执行科室
		srvDTO.setId_mm(orTplItem.getId_mm());// 关联物品
		srvDTO.setFg_skintest(orTplItem.getFg_skintest());
		// srvDTO.setSrvsetitms(orTplItem.getSrvsetitms());//套内项目集合
		return srvDTO;
	}

}
