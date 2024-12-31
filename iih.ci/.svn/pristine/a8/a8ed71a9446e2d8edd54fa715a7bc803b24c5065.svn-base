package iih.ci.ord.s.bp.assi.gj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.param.IBdMmParamValueConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.ortpl.d.OrTmplDO;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.bd.srv.ortpl.dto.ortmplcareldto.d.OrtmplSetDTO;
import iih.bd.srv.ortpl.i.IOrTplNItmDORService;
import iih.bd.utils.BdMmParamUtils;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import iih.ci.ord.tmpl.d.CiOrTmplDTO;
import iih.ci.ord.tmpl.d.CiOrTmplSrvDTO;
import iih.ci.ord.tmpl.d.LongTempOrEnum;
import iih.ci.sdk.cache.BDMeasInfoCache;
import iih.ci.sdk.cache.BDMeterialInfoCache;
import iih.ci.sdk.cache.BDSrvInfoCache;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 将OrTplNItmDO对象集合 转换为标准医嘱模板CiOrTmplDTO对象集合 BP
 * 
 * @author HUMS
 *
 */
public class ConvertOrtmlNItem2CiOrTmplBP {

	// 数据来源	
	private String eu_orsrcmdtp;

	public ConvertOrtmlNItem2CiOrTmplBP(String eu_orsrcmdtp) {
		this.eu_orsrcmdtp = eu_orsrcmdtp;
	}

	public List<CiOrTmplDTO> exec(OrTplNItmDO[] orTplNItms) throws BizException {
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
			return null;
		//处理当前剂量和实际剂量的换算问题
		convertQuan_medu(orTplNItms);
		// 医嘱模板
		FMap2 map = OrtemplateGrouping(orTplNItms);
		
		if (map == null || map.size() == 0)
			return null;
		
		List<CiOrTmplDTO> tmpList = new ArrayList<CiOrTmplDTO>();
		//医嘱模板的优化
		@SuppressWarnings("unchecked")
		List<String> ortmplList = (List<String>) map.get("ortmplList");
		Map<String,OrTmplDO> ortmplDOMap = OptimaizationOrTplNItmDO(ortmplList);
		map.remove("ortmplList");
		for (Object list : map.values()) {
			@SuppressWarnings("unchecked")
			List<OrTplNItmDO> temp = (List<OrTplNItmDO>) list;
			if (temp != null && temp.size() > 0) {
				FArrayList srvlist = new FArrayList();
				CiOrTmplDTO aggdto = new CiOrTmplDTO();
				OrTplNItmDO orTplItem = temp.get(0);
				// 映射医嘱
				MappingFieldOrder(aggdto, orTplItem, ortmplDOMap);
				//医嘱模板套赋值
				MappingfiledOrder2(aggdto,orTplItem);
				String strIdsrv = "";
				for (OrTplNItmDO itmDO : temp) {
					strIdsrv += ",'" + itmDO.getId_srv() + "'";
				}
				if (orTplItem.getId_srv_set() != null && orTplItem.getId_srv_set().length() > 0) {
				    strIdsrv += ",'" + orTplItem.getId_srv_set() + "'";				    
				}
				
				MedSrvDO[] medSrvDOs= null;
				String drugManagementModel = BdMmParamUtils.GetDrugMCPropMM();
				//药品用药属性管理模式，只用于药品
				if(orTplItem.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG) && IBdMmParamValueConst.DRUGMCPROPMM_DRUG.equals(drugManagementModel) ){
					GetBdMMInfoQry qry = new GetBdMMInfoQry(strIdsrv.substring(1));
					medSrvDOs  = (MedSrvDO[]) AppFwUtil.getDORstWithDao(qry, MedSrvDO.class);
				}else{
					GetMedsrvQry qry = new GetMedsrvQry(strIdsrv.substring(1));
					medSrvDOs  = (MedSrvDO[]) AppFwUtil.getDORstWithDao(qry, MedSrvDO.class);
				}
				Map<String, MedSrvDO> mapMedSrvDOs = new HashMap<String, MedSrvDO>();
				for (MedSrvDO srvDO : medSrvDOs) {
					if (!mapMedSrvDOs.containsKey(srvDO.getId_srv())) {
						mapMedSrvDOs.put(srvDO.getId_srv(), srvDO);
					}
				}
				//套映射套本身的服务项目
				if (FBoolean.TRUE.equals(aggdto.getFg_set())) {
					MappinfieldOrderSetSrv(srvlist, aggdto, temp, mapMedSrvDOs.get(orTplItem.getId_srv_set()));
				} else {
					for (int i = 0; i < temp.size(); i++) {
						// 映射医嘱的项目
						srvlist.append(MappinfieldOrderSrv(aggdto, temp.get(i), mapMedSrvDOs.get(orTplItem.getId_srv())));
					}
				}
				aggdto.setOrtmplsrvs(srvlist);
				tmpList.add(aggdto);
			}
		}

		return tmpList;
	}
	
	private void MappingfiledOrder2(CiOrTmplDTO aggdto, OrTplNItmDO orTplNItmDO) throws BizException {
		if (orTplNItmDO.getOrtmplSetDTO()!=null) {
			OrtmplSetDTO ortmplSetDTO = orTplNItmDO.getOrtmplSetDTO();
			//根据是否是多剂量 ，多执行进行判定赋值
			if (FBoolean.TRUE.equals(ortmplSetDTO.getIsmuldose())) {
				aggdto.setQuan_med(ortmplSetDTO.getQuan_med());
			}
			if (FBoolean.TRUE.equals(ortmplSetDTO.getIsmulexec())) {
				if ("0".equals(ortmplSetDTO.getSd_totalopenmode())) {//周期开立
					aggdto.setId_freq(ortmplSetDTO.getId_freq());
					aggdto.setDays_or(ortmplSetDTO.getDays_or());
					//计算总次数
					Integer totalTimes = new GetTotalTimesBP().getTotalTimes(orTplNItmDO.getDt_effe(), orTplNItmDO.getId_freq(), ortmplSetDTO.getDays_or());
					aggdto.setTimes(totalTimes);
				}else{
					aggdto.setTimes(ortmplSetDTO.getTimes());
				}
			}
		}
	}

	private void convertQuan_medu(OrTplNItmDO[] orTplNItms) throws BizException {
		for (OrTplNItmDO orTplNItmDO : orTplNItms) {
			//只处理药品
			if(!(orTplNItmDO.getSd_srvtp() != null && orTplNItmDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG))){
				continue;
			}
			FDouble quan_medu_cur = orTplNItmDO.getQuan_medu_cur();//当前剂量
			String id_medu_cur = orTplNItmDO.getId_medu_cur();//当前剂量单位
			FDouble factor_cur = orTplNItmDO.getFactor_cur();//当前换算单位（和医疗单位的换算）
			//判断当前单位和基本单位是否一致
			if (orTplNItmDO.getId_medu_cur()!=null) {
				MeterialDO meterialDO = BDMeterialInfoCache.GetMeterialInfo(null, orTplNItmDO.getId_mm());
				if (meterialDO!=null&&orTplNItmDO.getId_medu_cur().equals(meterialDO.getId_unit_pkgbase())) {
					FDouble quan_med = quan_medu_cur.multiply(factor_cur);
					orTplNItmDO.setQuan_med(quan_med);
				}else{
					orTplNItmDO.setQuan_med(quan_medu_cur);
					orTplNItmDO.setId_unit_med(id_medu_cur);
				}
				orTplNItmDO.setOrtplnitm_unit_name(BDMeasInfoCache.GetNameOfBdMeasInfo(id_medu_cur));
			}
		}
	}

	/**
     * 医嘱项目 一个医嘱模板的 是一条医嘱
     * @param map
     * @param ortplItemDO
     * @throws BizException
     */
	@SuppressWarnings("unchecked")
	private FMap2 OrtemplateGrouping(OrTplNItmDO[] ortplItems)
			throws BizException {
		FMap2 map = new FMap2();
		List<OrTplNItmDO> itemlist = null;
		List<String> ortmplList = new ArrayList<String>();
		
		// 根据数据库中的医嘱模板明细补全前台传入的模板明细
		this.setOrtmplItmDefaultVal(ortplItems);
		
		for (OrTplNItmDO item : ortplItems) {
			ortmplList.add(item.getId_ortmpl());
			String key = item.getId_ortmpl() + item.getIdentical_ortmpl() + item.getSd_srvtp().substring(0, 2);
			if (map.containsKey(key)) {
				itemlist = (List<OrTplNItmDO>) map.get(key);
				itemlist.add(item);
			} else {
				List<OrTplNItmDO> temp = new ArrayList<OrTplNItmDO>();
				temp.add(item);
				map.put(key, temp);
			}
		}
		map.put("ortmplList", ortmplList);
		return map;
	}
	
	/**
	 * 根据数据库中的医嘱模板，补全前台传入的医嘱模板数据
	 * @return
	 * @throws BizException 
	 */
	private void  setOrtmplItmDefaultVal(OrTplNItmDO[] ortplItems) throws BizException{
		
		// 医嘱模板明细id集合
		List<String> idOrtmplItm = new ArrayList<String>();
				
		for(OrTplNItmDO orTplNItm : ortplItems){
			idOrtmplItm.add(orTplNItm.getId_ortmplitm());
		}
		
		// 查询中数据库中的医嘱模板，并转换为map结构
		OrTplNItmDO[] defaultOrTplNItms = ((IOrTplNItmDORService)ServiceFinder.find(IOrTplNItmDORService.class))
				.findByIds(idOrtmplItm.toArray(new String[0]), FBoolean.FALSE);
		if(defaultOrTplNItms == null || defaultOrTplNItms.length ==0){
			return ;
		}
		
		Map<String,OrTplNItmDO> orTplNItmMap = new HashMap<String,OrTplNItmDO>();
		Map<String,String> mapIdmm = new HashMap<String,String>();
		for(OrTplNItmDO orTplNItm : defaultOrTplNItms){
			orTplNItmMap.put(orTplNItm.getId_ortmplitm(), orTplNItm);
			if(orTplNItm.getSd_srvtp().startsWith("01")) {
				mapIdmm.put(orTplNItm.getId_mm(), orTplNItm.getId_unit_med());
			}
			
		}
		//判断模板的医学单位华为药品基本信息的基本单位是否不一致
		String message = JudgeMMUintMed(defaultOrTplNItms);
		if(!StringUtils.isNullOrEmpty(message)) {
			throw new BizException(message);
		}
		// 将数据库中医嘱模板信息合并到前台传入的模板数据中
		for(OrTplNItmDO orTplNItm : ortplItems){
			
			OrTplNItmDO sourceOrTplNItm = orTplNItmMap.get(orTplNItm.getId_ortmplitm());
			
			if(StringUtils.isNullOrEmpty(orTplNItm.getId_freq())){
				orTplNItm.setId_freq(sourceOrTplNItm.getId_freq());
				orTplNItm.setOrtplnitm_freq_code(sourceOrTplNItm.getOrtplnitm_freq_code());
				orTplNItm.setOrtplnitm_freq_name(sourceOrTplNItm.getOrtplnitm_freq_name());
			}
			
			if(StringUtils.isNullOrEmpty(orTplNItm.getId_route())){
				orTplNItm.setId_route(sourceOrTplNItm.getId_route());
				orTplNItm.setOrtplnitm_route_code(sourceOrTplNItm.getOrtplnitm_route_code());
				orTplNItm.setOrtplnitm_route_name(sourceOrTplNItm.getOrtplnitm_route_name());
			}
			
			if(StringUtils.isNullOrEmpty(orTplNItm.getId_routedes())){
				orTplNItm.setId_routedes(sourceOrTplNItm.getId_routedes());
				orTplNItm.setOrtplnitm_routedes_code(sourceOrTplNItm.getOrtplnitm_routedes_code());
				orTplNItm.setOrtplnitm_routedes_name(sourceOrTplNItm.getOrtplnitm_routedes_name());
			}
			
			if(StringUtils.isNullOrEmpty(orTplNItm.getId_boil())){
				orTplNItm.setId_boil(sourceOrTplNItm.getId_boil());
				orTplNItm.setOrtplnitm_boil_code(sourceOrTplNItm.getOrtplnitm_boil_code());
				orTplNItm.setOrtplnitm_boil_name(sourceOrTplNItm.getOrtplnitm_boil_name());
			}
			
			if(orTplNItm.getDays_or() == null){
				orTplNItm.setDays_or(sourceOrTplNItm.getDays_or());
			}
			if(orTplNItm.getDes_or() == null){
				orTplNItm.setDes_or(sourceOrTplNItm.getDes_or());
		
			}
			if(StringUtils.isNullOrEmpty(orTplNItm.getName_srv())){
				orTplNItm.setName_srv(sourceOrTplNItm.getName_srv());
		
			}
			if(orTplNItm.getId_dep_mp()==null){
				orTplNItm.setId_dep_mp(sourceOrTplNItm.getId_dep_mp());
			}			
		}
	}

	/**
	 * 查询出医嘱模板集合
	 * 
	 * @param map
	 * @return
	 * @throws BizException
	 */
	private Map<String,OrTmplDO> OptimaizationOrTplNItmDO(List<String> list) throws BizException {
		if (list == null || list.size() == 0)
			return null;
		Map<String,OrTmplDO> orTemplmap = new HashMap<String,OrTmplDO>();
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
	 * 医嘱 字段映射
	 * 
	 * @param dto
	 * @param orTplItem
	 */
	private void MappingFieldOrder(CiOrTmplDTO dto, OrTplNItmDO orTplItem, Map<String,OrTmplDO> ortmplDOMap) throws BizException {

		//OrTmplDO orTmplDO = CiOrdAppUtils.getIOrtmplMDORService().findById(orTplItem.getId_ortmpl());
		OrTmplDO orTmplDO = ortmplDOMap.get(orTplItem.getId_ortmpl());
		// dto.setId_ciortmpl(orTplItem.getId_ciortmpl());//临床医嘱模板主键标识
		// dto.setOrtmplsrvs(orTplItem.getOrtmplsrvs());//医嘱模板项目列表
		dto.setEu_orsrcmdtp(this.eu_orsrcmdtp);// 临床医嘱来源类型
		dto.setId_orsrc_main(orTplItem.getId_ortmpl());// 来源ID_主 医嘱模板主表
		dto.setId_orsrc_sub(orTplItem.getId_ortmplitm());// 来源ID_子 医嘱模板明细
		
		dto.setCode(orTplItem.getOrtplnitm_srv_code());// 编码
		// tId_srv_set 计算字段，前台赋值
		if (orTplItem.getId_srv_set() != null && orTplItem.getId_srv_set().length() > 0) {
			//dto.setName(orTplItem.getOrtplnitm_mm_name());// 名称
			dto.setId_srv(orTplItem.getId_srv_set());//   套 id
			dto.setFg_set(FBoolean.TRUE);
		} else {
			if(!StringUtils.isNullOrEmpty(orTplItem.getName_srv())){
				dto.setName(orTplItem.getName_srv());// 名称
			}else{
				dto.setName(orTplItem.getOrtplnitm_srv_name());// 名称
			}
			//自定义的使用编辑的服务名称，否则使用bd_srv中的服务名称
			MedSrvDO tempMedSrv = BDSrvInfoCache.GetBdSrvInfo(null, orTplItem.getId_srv());
			if (FBoolean.TRUE.equals(tempMedSrv.getFg_ctm())) {
				dto.setName(orTplItem.getName_srv());// 名称
			}else{
				dto.setName(orTplItem.getOrtplnitm_srv_name());// 名称
			}
			dto.setId_srv(orTplItem.getId_srv());
			dto.setFg_set(FBoolean.FALSE);
		}

		if(orTmplDO != null){
			dto.setDes_or(orTmplDO.getDes_or());
		} 
		dto.setId_srvtp(orTplItem.getId_srvtp());// 医嘱类型
		dto.setSd_srvtp(orTplItem.getSd_srvtp());// 医嘱类型编码
		dto.setEu_long(LongTempOrEnum.TEMPORARYOR);// 长期临时类型
		dto.setId_freq(orTplItem.getId_freq());// 医嘱频次
		dto.setId_route(orTplItem.getId_route());// 用法
		dto.setId_routedes(orTplItem.getId_routedes());// 用法要求
		dto.setId_boil(orTplItem.getId_boil());// 煎法
		dto.setId_boildes(orTplItem.getId_boildes());// 煎法要求
		dto.setDays_or(orTplItem.getDays_or());// 医嘱天数
		dto.setOrders(orTplItem.getOrders());// 医嘱付数
		dto.setDes_or((orTmplDO==null||StringUtils.isNullOrEmpty(orTmplDO.getDes_or()))?orTplItem.getDes_or():orTmplDO.getDes_or());
		// dto.setFg_boil(orTemplateDO.getfg);//代煎标识
		dto.setDes((orTmplDO==null||StringUtils.isNullOrEmpty(orTmplDO.getDes()))?orTplItem.getDes():orTmplDO.getDes());
		if (dto.getDays_or() == null) {
			dto.setDays_or(orTmplDO != null && orTmplDO.getDays_or() != null ? orTmplDO.getDays_or() : 1);// 医嘱天数
		  }

		// 草药设置医嘱付数
		if (CiOrdUtils.isHerbOrder(dto.getSd_srvtp()) && dto.getOrders() == null) {
			dto.setOrders(orTmplDO != null && orTmplDO.getOrders() != null ? orTmplDO.getOrders() : CiOrdUtils.getDefaultOrders());// 医嘱付数
		}
		//设置超量开单原因
		dto.setSd_excessive_reason(orTplItem.getSd_excessive_reason());
		dto.setId_excessive_reason(orTplItem.getId_excessive_reason());
		if (FBoolean.TRUE.equals(orTplItem.getIsmulexec())) {
			if (orTplItem.getSd_totalopenmode()!=null && "0".equals(orTplItem.getSd_totalopenmode())) {//周期开立
				dto.setId_freq(orTplItem.getId_freq());
				dto.setDays_or(orTplItem.getDays_or());
				//计算总次数
				GetTotalTimesBP  bp = new GetTotalTimesBP();
				Integer totalTimes = bp.getTotalTimes(orTplItem.getDt_effe(), orTplItem.getId_freq(), orTplItem.getDays_or());
				dto.setTimes(totalTimes);
			}else{
				dto.setTimes(orTplItem.getTimes());
			}
		}
	}

	/**
	 * 映射医嘱的项目
	 * 
	 * @param aggDTO
	 * @param orTplItem
	 */
	private CiOrTmplSrvDTO MappinfieldOrderSrv(CiOrTmplDTO ciOrtemplateDTO, OrTplNItmDO orTplItem, MedSrvDO medSrvDO) throws BizException {

		CiOrTmplSrvDTO srvDTO = new CiOrTmplSrvDTO();
		// srvDTO.setId_ciortmplsrv(orTplItem.getId_ciortmplsrv());//临床医嘱模板项目主键标识
		// srvDTO.setId_ciortmpl(orTplItem.getId_ciortmpl());//临床医嘱模板
		srvDTO.setSortno(orTplItem.getSortno());// 序号
		srvDTO.setId_srv(orTplItem.getId_srv());// 服务
		// srvDTO.setOrtplnitm_srv_name(orTplItem.getOrtplnitm_srv_name());
		// srvDTO.setFg_selfsrv(medSrvDO.getFg_selfsrv());//自定义服务标识
		// srvDTO.setName_selfsrv(medSrvDO.get);//自定义服务名
		if(!StringUtils.isNullOrEmpty(orTplItem.getName_srv())){
			srvDTO.setName_selfsrv(orTplItem.getName_srv());
		}
		srvDTO.setFg_set(medSrvDO.getFg_set());// 套标识
		srvDTO.setId_srvtp(orTplItem.getId_srvtp());// 服务类型
		srvDTO.setSd_srvtp(orTplItem.getSd_srvtp());// 服务类型编码
		srvDTO.setId_freq(StringUtils.isNullOrEmpty(orTplItem.getId_freq())?
				medSrvDO.getId_freq():orTplItem.getId_freq());// 频次
		srvDTO.setId_route(StringUtils.isNullOrEmpty(orTplItem.getId_route())?
				medSrvDO.getId_route():orTplItem.getId_route());// 用法
		srvDTO.setId_routedes(StringUtils.isNullOrEmpty(orTplItem.getId_routedes())?
				medSrvDO.getId_routedes():orTplItem.getId_routedes());// 要求
		srvDTO.setId_boil(StringUtils.isNullOrEmpty(orTplItem.getId_boil())?
				medSrvDO.getId_boil():orTplItem.getId_boil());// 煎法
		srvDTO.setId_boildes(StringUtils.isNullOrEmpty(orTplItem.getId_boildes())?
				medSrvDO.getId_boildes():orTplItem.getId_boildes());// 中医要求
		srvDTO.setId_unit_med(StringUtils.isNullOrEmpty(orTplItem.getId_unit_med())?
				medSrvDO.getId_unit_med():orTplItem.getId_unit_med());// 医学单位
		srvDTO.setQuan_med(orTplItem.getQuan_med() == null?
				medSrvDO.getQuan_med():orTplItem.getQuan_med());// 医学单位数值
		// srvDTO.setQuan_total_medu(orTplItem.getQuan_total_medu());//服务总量
		//srvDTO.setQuan_total_medu(orTplItem.getQuan_med());// todo 剂量不能直接等于总量，需要后面计算
		//门诊总量取值模式  0不可编辑 1 可编辑
		srvDTO.setQuan_total_medu(orTplItem.getQuan_total_medu());
		srvDTO.setId_unit_sale(orTplItem.getId_total_medu());
		
		srvDTO.setId_dep_mp(orTplItem.getId_dep_mp());// 执行科室
		srvDTO.setId_mm(orTplItem.getId_mm());// 关联物品
		srvDTO.setDes_or(orTplItem.getDes_or());//嘱托
		// srvDTO.setSrvsetitms(orTplItem.getSrvsetitms());//套内项目集合
		srvDTO.setQuan_medu_cur(orTplItem.getQuan_medu_cur());
		srvDTO.setId_medu_cur(orTplItem.getId_medu_cur());
		srvDTO.setFactor_cur(orTplItem.getFactor_cur());
		srvDTO.setFg_skintest(orTplItem.getFg_skintest());
		return srvDTO;
	}
	
	/**
	 * 映射医嘱套的项目
	 * 
	 * @param aggDTO
	 * @param orTplItem
	 */
	private void MappinfieldOrderSetSrv(FArrayList srvlist, CiOrTmplDTO ciOrtemplateDTO, List<OrTplNItmDO> orTplItems, MedSrvDO setMedSrvDO) throws BizException {
	    // 将服务套本身项目放在列表首位
	    if (setMedSrvDO != null) {
	        CiOrTmplSrvDTO srvDTO = new CiOrTmplSrvDTO();
	        OrTplNItmDO orTplItem = orTplItems.get(0);
            srvDTO.setSortno(0);// 序号
            srvDTO.setId_srv(setMedSrvDO.getId_srv());// 服务
            if(!StringUtils.isNullOrEmpty(orTplItem.getOrtplnitm_mm_name())){
                srvDTO.setName_selfsrv(orTplItem.getOrtplnitm_mm_name());
            }
            srvDTO.setFg_set(FBoolean.TRUE);// 套标识              
            MedSrvDO medSrvDO2 = BDSrvInfoCache.GetBdSrvInfo(null, setMedSrvDO.getId_srv());           
            srvDTO.setId_srvtp(medSrvDO2.getId_srvtp());// 服务类型
            srvDTO.setSd_srvtp(medSrvDO2.getSd_srvtp());// 服务类型编码
            srvDTO.setId_freq(StringUtils.isNullOrEmpty(orTplItem.getId_freq())?
                    medSrvDO2.getId_freq():orTplItem.getId_freq());// 频次
            srvDTO.setId_route(medSrvDO2.getId_route());// 用法
            srvDTO.setId_routedes(medSrvDO2.getId_routedes());// 要求
            srvDTO.setId_boil(medSrvDO2.getId_boil());// 煎法
            srvDTO.setId_boildes(medSrvDO2.getId_boildes());// 中医要求
            srvDTO.setId_unit_med(medSrvDO2.getId_unit_med());// 医学单位
            srvDTO.setQuan_med(orTplItem.getQuan_med() == null ? medSrvDO2.getQuan_med() : orTplItem.getQuan_med());// 医学单位数值
            srvDTO.setId_mm(medSrvDO2.getId_mm());// 关联物品
            srvDTO.setDes_or(orTplItem.getDes_or());//嘱托
            srvDTO.setId_dep_mp(orTplItem.getId_dep_mp());// 执行科室
            srvDTO.setQuan_medu_cur(orTplItem.getQuan_medu_cur());
            srvDTO.setId_medu_cur(orTplItem.getId_medu_cur());
            srvDTO.setFactor_cur(orTplItem.getFactor_cur());
            srvlist.append(srvDTO);
	    }
	    
		for(OrTplNItmDO orTplItem : orTplItems) {
			CiOrTmplSrvDTO srvDTO = new CiOrTmplSrvDTO();
			// srvDTO.setId_ciortmplsrv(orTplItem.getId_ciortmplsrv());//临床医嘱模板项目主键标识
			// srvDTO.setId_ciortmpl(orTplItem.getId_ciortmpl());//临床医嘱模板
			srvDTO.setSortno(0);// 序号
			srvDTO.setId_srv(orTplItem.getId_srv());// 服务
			// srvDTO.setOrtplnitm_srv_name(orTplItem.getOrtplnitm_srv_name());
			// srvDTO.setFg_selfsrv(medSrvDO.getFg_selfsrv());//自定义服务标识
			// srvDTO.setName_selfsrv(medSrvDO.get);//自定义服务名
			if(!StringUtils.isNullOrEmpty(orTplItem.getOrtplnitm_mm_name())){
				srvDTO.setName_selfsrv(orTplItem.getOrtplnitm_mm_name());
			}
			if (srvDTO.getId_srv().equals(ciOrtemplateDTO.getId_srv())) {
			    srvDTO.setFg_set(FBoolean.TRUE);// 套标识			    
			} else {
			    srvDTO.setFg_set(FBoolean.FALSE);
			}
			MedSrvDO medSrvDO2 = BDSrvInfoCache.GetBdSrvInfo(null, orTplItem.getId_srv());
			
			srvDTO.setId_srvtp(medSrvDO2.getId_srvtp());// 服务类型
			srvDTO.setSd_srvtp(medSrvDO2.getSd_srvtp());// 服务类型编码
			srvDTO.setId_freq(StringUtils.isNullOrEmpty(orTplItem.getId_freq())?
					medSrvDO2.getId_freq():orTplItem.getId_freq());// 频次
			srvDTO.setId_route(medSrvDO2.getId_route());// 用法
			srvDTO.setId_routedes(medSrvDO2.getId_routedes());// 要求
			srvDTO.setId_boil(medSrvDO2.getId_boil());// 煎法
			srvDTO.setId_boildes(medSrvDO2.getId_boildes());// 中医要求
			srvDTO.setId_unit_med(medSrvDO2.getId_unit_med());// 医学单位
			srvDTO.setQuan_med(orTplItem.getQuan_med() == null?
					medSrvDO2.getQuan_med():orTplItem.getQuan_med());// 医学单位数值
			// srvDTO.setQuan_total_medu(orTplItem.getQuan_total_medu());//服务总量
			//srvDTO.setQuan_total_medu(orTplItem.getQuan_med());// todo 剂量不能直接等于总量，需要后面计算
			
			srvDTO.setId_mm(medSrvDO2.getId_mm());// 关联物品
			srvDTO.setDes_or(orTplItem.getDes_or());//嘱托
			srvDTO.setId_dep_mp(orTplItem.getId_dep_mp());// 执行科室
			// srvDTO.setSrvsetitms(orTplItem.getSrvsetitms());//套内项目集合
			srvDTO.setQuan_medu_cur(orTplItem.getQuan_medu_cur());
			srvDTO.setId_medu_cur(orTplItem.getId_medu_cur());
			srvDTO.setFactor_cur(orTplItem.getFactor_cur());
			srvlist.append(srvDTO);
		}
	}

	 /**
	  * 判断 药品的医学单位和模板的医学单位是否一致
	  * @param envinfo
	  * @param ortplItemDO
	  * @return
	  */
	  private String JudgeMMUintMed(OrTplNItmDO[] defaultOrTplNItms) throws BizException{
		 StringBuffer message =  new StringBuffer();
		 List<String> list = new ArrayList<String>();//药品 id_mm 集合
		 Map<String,String> map = new HashMap<String,String>();
		 if(defaultOrTplNItms !=null && defaultOrTplNItms.length > 0) {
			 for(OrTplNItmDO itemDO: defaultOrTplNItms) {
				 if(itemDO.getSd_srvtp().startsWith("01")) {
					 map.put(itemDO.getId_mm(), itemDO.getId_unit_med());
					 list.add(itemDO.getId_mm());
				 }
			 }
			 if(list != null && list.size() > 0) {
				 MeterialDO[] materiaDOs = BDMeterialInfoCache.GetMeterialInfos(null, list.toArray(new String[0]));
			     if(materiaDOs != null && materiaDOs.length > 0) {
			    	 for(MeterialDO meteria :materiaDOs) {
				    	 if(!meteria.getId_unit_med().equals(map.get(meteria.getId_mm()))){
				    		 message.append(meteria.getName()).append("" );
				    		 message.append("在模板里面的剂量单位和 药品基本信息里的剂量单位不一致 请修改模板，在开立" ).append("\n");
				    	 }
				     } 
			     } 
			 } 
		 }
		 return message.toString();
	  }
}
