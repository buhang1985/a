package iih.ci.ord.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.wf.d.EnumFlow;
import iih.bd.fc.wf.d.OrRecurTypeEnum;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.i.IHpsrvorcaRService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvRelMmDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.medsrv.i.IMedsrvRelMmRService;
import iih.bd.srv.medsrv.refs.sql.op.DrugCheckDisplayMd4OP;
import iih.bl.hp.bdhpindicationdto.d.BdHpIndicationDTO;
import iih.ci.mi.ord.i.ICiMiOrdRService;
import iih.ci.ord.ciordems.d.EmsHeadDO;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.ciorder.d.HpBeyondEnum;
import iih.ci.ord.dto.ems.EmsDrugCreateParamDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.hp.tl.HpService;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.qry.CiorderDrugQry;
import iih.ci.ord.s.ems.cache.BDMmDoseUnitInfoCache;
import iih.ci.ord.s.ems.utils.DeptInfoUtils;
import iih.mm.itf.material.d.GetStockReqDTO;
import iih.mm.itf.material.d.MaterialDTO;
import iih.mm.itf.material.d.MaterialStatus;
import iih.mm.itf.material.d.MaterialStockDTO;
import iih.mm.itf.material.d.QueryCondDTO;
import iih.mm.itf.material.i.IMaterialService;
import iih.mm.itf.material.i.IMaterialStockService;
import iih.mm.itf.materialunitdto.d.MaterialUnitDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.orgfw.dept.d.DeptDO;

public class GetOrderBP {

	static String fldname = null;
	
	private ICiMiOrdRService ciMiOrdRService ; 
	public GetOrderBP(){
		ciMiOrdRService = ServiceFinder.find(ICiMiOrdRService.class);
	}

	public EmsHeadDO exec(String id_srv, CiEnContextDTO ctx) throws BizException {
		return exec(id_srv, ctx.getId_hp(), ctx.getCode_entp(), ctx);
	}

	/**
	 * 页面所需所有信息
	 * 
	 * @param id_srv
	 * @return EmsHeadDO
	 * @throws BizException
	 */
	public EmsHeadDO exec(String id_srv, String id_hp, String code_entp, CiEnContextDTO ciEnContextDTO)
			throws BizException {
		if (StringUtils.isBlank(id_srv))
			return null;
		EmsHeadDO emsDo = new EmsHeadDO();

		// 物品单位服务
		DAFacade cade = new DAFacade();
		List<EmsOrDrug> mm = (List<EmsOrDrug>) cade.execQuery(getQry(new String[]{id_srv}).getQrySQLStr(),
				new BeanListHandler(EmsOrDrug.class));
		String idsrvs = id_srv.replace("'", "");
		String[] id_srvArray = idsrvs.split(",");
		// 获取医保信息
		Map<String, HPSrvorcaDO> hpMap = null;
		BdHpIndicationDTO[] hpIndiccation = null;
		// TODO：医保信息调整后改动
		
		//获取MEDSRV  0156111: 验证版，住院医生站，开立医嘱，药房名称列表下参照不对，应该只有维护的药房数据
		IMedsrvMDORService ser = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO[] aggs = ser.findByBIds(id_srvArray, FBoolean.FALSE);
		Map<String,MedSrvDO>srvmap=new HashMap<>();
		for (MedSrvDO medSrvDO : aggs) {
			if(!srvmap.containsKey(medSrvDO.getId_srv()))
				srvmap.put(medSrvDO.getId_srv(), medSrvDO);
		}

		FArrayList list = new FArrayList();
		List<String> mmIds = new ArrayList<String>();
		for (EmsOrDrug drug : mm) {
			if (!CiOrdUtils.isEmpty(drug.getId_mm())) {
				mmIds.add(drug.getId_mm());
			}
		}
		MaterialUnitDTO[] materUnit = BDMmDoseUnitInfoCache.getMaterialUnitInfos(code_entp, mmIds.toArray(new String[0]));
		for (EmsOrDrug object : mm) {
			/*
			 * if (hpMap != null && hpMap.size() != 0) {
			 * object.setName_hp(hpMap.get(object.getId_srv()).getName());// 医保
			 * object.setLimit(hpMap.get(object.getId_srv()).getDes());// 报销限制条件
			 */ // TODO:单次剂量 =医学单位值/系数 单次数量应该改为 string类型
				// 根据物品和单位类型参数配置 获取物品的单位集合
				// 关于医保信息，一个服务一个一医保信息（多个物品暂时不考虑）
			if (ciEnContextDTO != null && ciEnContextDTO.getId_hp() != null && ciEnContextDTO.getId_hp() != ""
					&& FBoolean.TRUE.equals(ciEnContextDTO.getFg_hpfundpay()) && ciEnContextDTO.getEu_hpbeyond() != null
					&& ciEnContextDTO.getEu_hpbeyond().equals("0")) {
				// hpMap = findHps(id_hp, id_srvArray);
				hpIndiccation = HpService.getMedSrvHpService(id_srv, object.getId_mm(), ciEnContextDTO);

				if (hpIndiccation != null && hpIndiccation.length > 0) {
					object.setFg_treat(hpIndiccation[0].getFg_indic());
					if (!CiOrdUtils.isEmpty(object.getFg_treat()) && !object.getFg_treat().booleanValue()) {
						object.setFg_selfpay(FBoolean.TRUE);
					} else {
						object.setFg_selfpay(FBoolean.FALSE);
					}
					object.setLimit(hpIndiccation[0].getDes_hplimit());
					object.setId_hp(id_hp);
					object.setSd_hpsrvtp(hpIndiccation[0].getSd_hpsrvtp());
					if (!CiOrdUtils.isEmpty(object.getSd_hpsrvtp())) {
						object.setId_hpsrvtp(CiOrdUtils.idHpSrvtpFromSdHpSrvtp(object.getSd_hpsrvtp()));
					}
					// object.setId_hpsrvtp(hpIndiccation[0].getId_hpsrvtp());
					// object.setName_hp(hpIndiccation[0].);
					// object.setBdHpIndicationDTO(new
					// FArrayList().append(hpIndiccation[0]));
				}
			} else {
				object.setFg_selfpay(FBoolean.TRUE);
			}

			// }
			// if(object.getQuan_med()!=null && object.getFactor_mb()!=null){
			// DecimalFormat df = new DecimalFormat("0.00");
			// double
			// t=(object.getQuan_med().toDouble()/object.getFactor_mb().toDouble());
			// object.setQuan_base(new FDouble(df.format(t)));
			// }
			// 总量单位不使用
			// @SuppressWarnings("unused")
			// String unittype=getUnitParam.getUnitParam(null,
			// ICiOrdSysParamConst.SYS_PARAM_IPPKGUTP);
			/*
			 * if(unittype!=null) { unittype= "'"+ unittype.replaceAll(",",
			 * "','")+"'"; }
			 */
			// @SuppressWarnings("unchecked")
			// List<EmsOrDrug> unitList = (List<EmsOrDrug>)
			// cade.execQuery(qry.GeUnitByMmAndParmSQL(object.getId_mm(),unittype),new
			// BeanListHandler(EmsOrDrug.class));
			if (object.getFg_mm().booleanValue() && object.getId_mm() == null)
				throw new BizException(object.getName_srv() + " 没有绑定物品 或者 物品没有启用");
			if (object.getFg_mm().booleanValue() && object.getId_mm() != null) {
				if (materUnit != null && materUnit.length > 0) {
					String strUnit = "";
					int i = 0;
					String ids = "", names = "", factors = "";
					for (MaterialUnitDTO dto : materUnit) {
						if (object.getId_mm().equals(dto.getId_mm())) {
							if (i == 0) {
								object.setId_unit_sale(dto.getId_measdoc());
								object.setFactor_cb(dto.getFactor());// 基本包装单位和总量单位间的换算系数
								object.setName_unit_sale(dto.getMeasdoc_name());
								if (dto.getPrice() != null) {
									object.setPrice(dto.getPrice());// 单价
								}
							}
							ids += "," + dto.getId_measdoc();
							names += "," + dto.getMeasdoc_name();
							if (CiOrdUtils.isEmpty(dto.getFactor())) {
								factors += ",1";
							} else {
								factors += "," + dto.getFactor();
							}
							i++;
							strUnit += ",'" + dto.getId_measdoc() + "'";
						}
					}

					if (strUnit == "")
						throw new BizException(" 物品" + object.getName_mm() + "没有对应的单位");

					object.setStr_unit_pkg_ids(strUnit.substring(1));
					FMap fmap = new FMap();
					if (!CiOrdUtils.isEmpty(ids)) {
						fmap.put(ICiDictCodeConst.EMSORDRUG_RELATIVE_FIELD_ID_MEASDOC, ids.substring(1));

					}
					if (!CiOrdUtils.isEmpty(names)) {
						fmap.put(ICiDictCodeConst.EMSORDRUG_RELATIVE_FIELD_MEASDOC_NAME, names.substring(1));
					}
					if (!CiOrdUtils.isEmpty(factors)) {
						fmap.put("factor", factors.substring(1));
					}
					object.setRelativefieldmap(fmap);
					// object.setName_unit_sale(unitList.get(0).getName_unit_sale());
					// object.setId_unit_sale(unitList.get(0).getId_unit_sale());
					// object.setName_unit_med(unitList.get(0).getName_unit_med());
					// object.setId_unit_med(unitList.get(0).getId_unit_med());
					//0156111: 验证版，住院医生站，开立医嘱，药房名称列表下参照不对，应该只有维护的药房数据
					OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(ciEnContextDTO, object.getId_srv(), object.getId_mm(),object.getId_route(),null, object.getFg_long(),ciEnContextDTO.getFg_pres_outp(),CiOrdAppUtils.getServerDateTime());
					if(wf!=null) {
						object.setStr_mp_dep_ids(wf.getId_mp_depts());
						object.setStr_wh_dep_ids(wf.getId_dept_whs());
					}
				}
			} else {
				object.setStr_unit_pkg_ids(object.getId_unit_med());
				FMap fmap = new FMap();
				fmap.put(ICiDictCodeConst.EMSORDRUG_RELATIVE_FIELD_ID_MEASDOC, object.getId_unit_med());
				fmap.put(ICiDictCodeConst.EMSORDRUG_RELATIVE_FIELD_MEASDOC_NAME, object.getName_unit_med());
				object.setRelativefieldmap(fmap);
			}

			list.add(object);
		}

		emsDo.setEmsdrugitems(list);

		return emsDo;

	}

	public EmsOrDrug[] getMmByMmtp(String mmtp) throws BizException {
		if (StringUtils.isBlank(mmtp))
			return null;
		CiorderDrugQry qry = new CiorderDrugQry(mmtp);

		DAFacade cade = new DAFacade();
		List<EmsOrDrug> mm = (List<EmsOrDrug>) cade.execQuery(qry.getMmByMmtp(), new BeanListHandler(EmsOrDrug.class));
		// String[] id_srvArray=id_srv.split(",");
		// 获取医保信息
		// Map<String,HpSrvOrCaDO> hpMap=findHps(id_hp,id_srvArray);

		// FArrayList list = new FArrayList();
		// for (EmsDrugItemDO object : mm) {
		// object.setName_heath(hpMap.get(object.getId_srv()).getName());//医保
		// object.setLimit(hpMap.get(object.getId_srv()).getDes());//报销限制条件
		// list.add(object);
		// }
		// emsDo.setEmsdrugitems(list);

		return mm.toArray(new EmsOrDrug[0]);

	}

	/**
	 * 获取通用药品信息
	 * 
	 * @param id_org
	 * @param id_srv
	 * @param id_dept_mp
	 * @param id_dept_phy
	 * @param id_hp
	 * @return
	 * @throws BizException
	 */
	public EmsOrDrug[] getSrvVsMm(String id_org, String id_srvs, String id_dept_mp, String id_dept_phy, String id_hp)
			throws BizException {
		if (id_org == null || id_srvs == null || id_dept_mp == null || id_dept_phy == null || id_hp == null) {
			return null;
		}
		String[] id_srvArray = id_srvs.split(",");
		List<EmsOrDrug> mmlist = new ArrayList<EmsOrDrug>();
		// 服务关联物品id集合
		Map<String, Map<String, MedSrvRelMmDO>> mmMaps = getMmids(id_srvArray);
		StringBuffer mms = new StringBuffer("");
		for (String id_srv : mmMaps.keySet()) {
			Map<String, MedSrvRelMmDO> srvMap = mmMaps.get(id_srv);
			if (srvMap == null)
				continue;
			for (String id_mm : srvMap.keySet()) {
				// id_mms+=id_mm+",";
				mms.append(id_mm + ",");
			}
			if (mms.length() > 2) {
				mms.deleteCharAt((mms.length() - 2));
			}
		}

		QueryCondDTO conditio = new QueryCondDTO();
		conditio.setId_org(id_org);
		// conditio.setId_mms(id_mms);
		conditio.setId_mms(mms.toString());
		conditio.setId_whs(id_dept_mp);
		conditio.setId_dept(id_dept_phy);
		// 获取物品信息
		MaterialDTO[] mmdtos = findMm(conditio);
		// 获取医保信息
		Map<String, HPSrvorcaDO> hpMap = findHps(id_hp, id_srvArray);

		if (mmdtos.length != 0) {
			for (String id_srv : id_srvArray) {
				for (MaterialDTO dto : mmdtos) {
					EmsOrDrug mm = new EmsOrDrug();
					if (hpMap != null) {
						mm.setName_heath(hpMap.get(id_srv).getName());// 医保
						mm.setLimit(hpMap.get(id_srv).getDes());// 报销限制条件
					}
					mm.setId_srv(id_srv);
					mm.setName_mm(dto.getName());
					mm.setId_mm(dto.getId_mm());
					mm.setSpec_mm(dto.getSpec());
					mm.setVender(dto.getName_sup());
					mm.setPrice(dto.getPrice_sale());
					mm.setFactor_cb(dto.getFactor_sb());
					mm.setFactor_mb(dto.getFactor_mb());
					mm.setId_unit_sale(dto.getSale_pkgu_id());
					mm.setName_unit_sale(dto.getSale_pkgu_name());
					mm.setId_unit_base(dto.getBase_pkgu_id());
					mm.setName_unit_base(dto.getBase_pkgu_name());
					mm.setFact_count(dto.getStock_num());// 库存
					mm.setFg_skintest(dto.getFg_skin());// 皮试标志
					mm.setSortno(mmMaps.get(id_srv).get(dto.getId_mm()).getSortno());
					mm.setSd_dosage(dto.getSd_dosage());// 药品剂型
					mm.setSd_pharm(dto.getSd_pharm());// 药品分类
					mm.setSd_pois(dto.getSd_pois());// 毒麻药分类
					mm.setSd_anti(dto.getSd_anti());// 抗菌药分类
					mm.setSd_mmtp(dto.getSd_mmtp());// 物品分类
					// mm.setSd_val();//价值分类
					// mm.setSd_antipsy();//抗精神分类
					mmlist.add(mm);
				}
			}
		}

		return mmlist.toArray(new EmsOrDrug[0]);
	}

	/**
	 * 根据服务id和医保类型查找医保DO
	 * 
	 * @param hpCode
	 * @param idSrv
	 * @return HpSrvOrCaDO
	 * @throws BizException
	 */
	public HPSrvorcaDO findHp(String id_hp, String id_Srv) throws BizException {
		IHpsrvorcaRService hpService = (IHpsrvorcaRService) ServiceFinder.find(IHpsrvorcaRService.class.getName());
		if (id_hp == null || id_hp == "")
			return null;
		String whereStr = HPSrvorcaDO.ID_HP + "='" + id_hp + "' and  " + HPSrvorcaDO.ID_SRV + " ='" + id_Srv + "'";
		HPSrvorcaDO[] orca = hpService.find(whereStr, HPSrvorcaDO.ID_HPSRVTP, FBoolean.FALSE);
		if (orca != null && orca.length > 0) {
			return orca[0];
		} else {
			throw new BizException("没有找医保信息");
		}
	}

	public Map<String, HPSrvorcaDO> findHps(String id_hp, String[] id_srvs) throws BizException {
		// return hpService.getHpSrvTpByCode(hpCode,id_Srv);
		if (id_hp == null || id_hp == "" || (CiOrdUtils.isEmpty(id_srvs)))
			return null;
		String idsrvs = "";
		if (!CiOrdUtils.isEmpty(id_srvs)) {
			idsrvs = CiOrdUtils.SQUOTE_MARK_STR
					+ id_srvs.toString().replaceAll(CiOrdUtils.COMMA_STR,
							CiOrdUtils.SQUOTE_MARK_STR + CiOrdUtils.COMMA_STR + CiOrdUtils.SQUOTE_MARK_STR)
					+ CiOrdUtils.SQUOTE_MARK_STR;
		}
		// if(!CiOrdUtils.isEmpty(id_mms)){
		// idmms =
		// CiOrdUtils.SQUOTE_MARK_STR+id_mms.toString().replaceAll(CiOrdUtils.COMMA_STR,CiOrdUtils.SQUOTE_MARK_STR+
		// CiOrdUtils.COMMA_STR+CiOrdUtils.SQUOTE_MARK_STR)+CiOrdUtils.SQUOTE_MARK_STR;
		// }
		IHpsrvorcaRService hpService = (IHpsrvorcaRService) ServiceFinder.find(IHpsrvorcaRService.class.getName());
		String whereStr = HPSrvorcaDO.ID_HP + "='" + id_hp + "' and  " + HPSrvorcaDO.ID_SRV + " in (" + idsrvs + ")";
		HPSrvorcaDO[] orca = hpService.find(whereStr, HPSrvorcaDO.ID_HPSRVTP, FBoolean.FALSE);
		Map<String, HPSrvorcaDO> hpMap = new HashMap<String, HPSrvorcaDO>();
		if (!CiOrdUtils.isEmpty(orca)) {
			for (HPSrvorcaDO hpdo : orca) {
				if (hpdo == null)
					continue;
				hpMap.put(hpdo.getId_srv(), hpdo);
			}
		}
		return hpMap;
	}

	/**
	 * 调用物品信息
	 * 
	 * @return
	 * @throws BizException
	 */
	public MaterialDTO[] findMm(QueryCondDTO conditio) throws BizException {
		IMaterialService mmService = (IMaterialService) ServiceFinder.find(IMaterialService.class.getName());
		MaterialDTO[] mmdto = mmService.query(conditio);
		return mmdto;
	}

	/**
	 * 查询服务关联的物品
	 * 
	 * @param id_srv
	 * @return MedSrvRelMmDO[]
	 * @throws BizException
	 */
	public Map<String, Map<String, MedSrvRelMmDO>> getMmids(String[] id_srvs) throws BizException {
		IMedsrvRelMmRService hpService = (IMedsrvRelMmRService) ServiceFinder
				.find(IMedsrvRelMmRService.class.getName());
		Map<String, Map<String, MedSrvRelMmDO>> maps = new HashMap<String, Map<String, MedSrvRelMmDO>>();

		for (String id : id_srvs) {
			Map<String, MedSrvRelMmDO> map = new HashMap<String, MedSrvRelMmDO>();
			MedSrvRelMmDO[] mms = hpService.find("a11.id_srv='" + id + "'", "sortno", FBoolean.FALSE);
			for (MedSrvRelMmDO mm : mms) {
				map.put(id, mm);
			}
			maps.put(id, map);
		}
		return maps;
	}

	public CiorderDrugQry getQry(String[] id_srv) {
		return new CiorderDrugQry(id_srv, fldname);
	}

	public EmsOrDrug[] exec(EmsDrugCreateParamDTO source, CiEnContextDTO contextdto) throws BizException {
		FArrayList idsrvlist = source.getId_srvs();
		if (idsrvlist==null||idsrvlist.size()==0)
			return null;
		String[] idsrvs = (String[])idsrvlist.toArray(new String[]{});
		fldname=source.getId_or();
		// 物品单位服务
		List<EmsOrDrug> mm = (List<EmsOrDrug>) new DAFacade().execQuery(getQry(idsrvs).getQrySQLStr(),
				new BeanListHandler(EmsOrDrug.class));
		// 获取医保信息
		Map<String, HPSrvorcaDO> hpMap = null;
		BdHpIndicationDTO[] hpIndiccation = null;
		FArrayList list = new FArrayList();
		List<String> mmIds = new ArrayList<String>();
		//设置服务的执行科室和仓库
	    setDepWhInfo(mm, source, contextdto);//
		// 查询发药单位时，出院带药按门诊处理
		String code_entp = FBoolean.TRUE.equals(contextdto.getFg_pres_outp()) ? IBdFcDictCodeConst.SD_CODE_ENTP_OP
				: contextdto.getCode_entp();
		for (EmsOrDrug drug : mm) {
			if (!CiOrdUtils.isEmpty(drug.getId_mm())) {
				mmIds.add(drug.getId_mm());
			}
			if(!CiOrdUtils.isEmpty(drug.getSd_nodispense())){
				if(ICiDictCodeConst.SD_NODISPENSE_SELF.equals(drug.getSd_nodispense())){
					drug.setName_nodispense(ICiDictCodeConst.NAME_NODISPENSE_SELF);	
				}else if(ICiDictCodeConst.SD_NODISPENSE_ENTRUST.equals(drug.getSd_nodispense())){
					drug.setName_nodispense(ICiDictCodeConst.NAME_NODISPENSE_ENTRUST);
				}else if(ICiDictCodeConst.SD_NODISPENSE_FOREIGN.equals(drug.getSd_nodispense())){
					drug.setName_nodispense(ICiDictCodeConst.NAME_NODISPENSE_FOREIGN);
				}
			}
		}
		//药品的发药单位
		MaterialUnitDTO[] materUnit = BDMmDoseUnitInfoCache.getMaterialUnitInfos(code_entp, mmIds.toArray(new String[0]));
		for (EmsOrDrug emsOrDrug : mm) {
			// 根据物品和单位类型参数配置 获取物品的单位集合
			
			// 未启用新医保计划时，使用老的医保判断模式，当使用新医保判断模式时，停用老的模式
			if(!ciMiOrdRService.isEnabledIndicVerify(contextdto)){
				// 关于医保信息，一个服务一个一医保信息（多个物品暂时不考虑）
				if (contextdto != null && contextdto.getId_hp() != null && contextdto.getId_hp() != ""
						&& FBoolean.TRUE.equals(contextdto.getFg_hpfundpay()) && contextdto.getEu_hpbeyond() != null
						&& contextdto.getEu_hpbeyond().equals("0")) {
					hpIndiccation = HpService.getMedSrvHpService(emsOrDrug.getId_srv(), emsOrDrug.getId_mm(), contextdto);

					if (hpIndiccation != null && hpIndiccation.length > 0) {
						emsOrDrug.setFg_treat(hpIndiccation[0].getFg_indic());
						if (!CiOrdUtils.isEmpty(emsOrDrug.getFg_treat()) && !emsOrDrug.getFg_treat().booleanValue()) {
							emsOrDrug.setFg_selfpay(FBoolean.TRUE);
						} else {
							emsOrDrug.setFg_selfpay(FBoolean.FALSE);
						}
						emsOrDrug.setLimit(hpIndiccation[0].getDes_hplimit());
						emsOrDrug.setId_hp(contextdto.getId_hp());
						emsOrDrug.setSd_hpsrvtp(hpIndiccation[0].getSd_hpsrvtp());
						if (!CiOrdUtils.isEmpty(emsOrDrug.getSd_hpsrvtp())) {
							emsOrDrug.setId_hpsrvtp(CiOrdUtils.idHpSrvtpFromSdHpSrvtp(emsOrDrug.getSd_hpsrvtp()));
						}
						if (!FBoolean.TRUE.equals(contextdto.getFg_hpfundpay()) && !HpBeyondEnum.HPDIAG.equals(contextdto.getEu_hpbeyond()))
		                {
							emsOrDrug.setFg_treat(FBoolean.FALSE);
							emsOrDrug.setFg_selfpay(FBoolean.TRUE);
		                }
		                //单次剂量录入
						emsOrDrug.setQuan_medu_virtual(emsOrDrug.getQuan_med());
						emsOrDrug.setName_unit_medu_virtual(emsOrDrug.getName_unit_med());
					}
				} else {
					emsOrDrug.setFg_selfpay(FBoolean.TRUE);
				}
			}
			

			if (emsOrDrug.getFg_mm().booleanValue() && emsOrDrug.getId_mm() == null)
				throw new BizException(emsOrDrug.getName_srv() + " 没有绑定物品 或者 物品没有启用");
			if (emsOrDrug.getFg_mm().booleanValue() && emsOrDrug.getId_mm() != null) {
				
				emsOrDrug.setId_drugdeliverymethod( source.getId_drugdeliverymethod());
				emsOrDrug.setSd_drugdeliverymethod( source.getSd_drugdeliverymethod());
				emsOrDrug.setName_drugdeliverymethod( source.getName_drugdeliverymethod());
				emsOrDrug.setFg_urgent(source.getFg_urgent());
								
				if (materUnit != null && materUnit.length > 0) {
					String strUnit = "";
					int i = 0;
					String ids = "", names = "", factors = "";
					for (MaterialUnitDTO dto : materUnit) {
						if (emsOrDrug.getId_mm().equals(dto.getId_mm())) {
							emsOrDrug.setQuan_cur(source.getQuan_cur());
							
							if(StringUtils.isNotEmpty(source.getId_unit_sale())&&source.getId_unit_sale().equals(dto.getId_measdoc())){
								emsOrDrug.setId_unit_sale(dto.getId_measdoc());
								emsOrDrug.setFactor_cb(dto.getFactor());// 基本包装单位和总量单位间的换算系数
								emsOrDrug.setName_unit_sale(dto.getMeasdoc_name());
							}else{
								if (i == 0) {
									emsOrDrug.setId_unit_sale(dto.getId_measdoc());
									emsOrDrug.setFactor_cb(dto.getFactor());// 基本包装单位和总量单位间的换算系数
									emsOrDrug.setName_unit_sale(dto.getMeasdoc_name());
								}
							}
							ids += "," + dto.getId_measdoc();
							names += "," + dto.getMeasdoc_name();
							if (CiOrdUtils.isEmpty(dto.getFactor())) {
								factors += ",1";
							} else {
								factors += "," + dto.getFactor();
							}
							i++;
							strUnit += ",'" + dto.getId_measdoc() + "'";
						}
					}

					if (strUnit == "")
						throw new BizException(" 物品" + emsOrDrug.getName_mm() + "没有对应的单位");

					emsOrDrug.setStr_unit_pkg_ids(strUnit.substring(1));
					FMap fmap = new FMap();
					if (!CiOrdUtils.isEmpty(ids)) {
						fmap.put(ICiDictCodeConst.EMSORDRUG_RELATIVE_FIELD_ID_MEASDOC, ids.substring(1));

					}
					if (!CiOrdUtils.isEmpty(names)) {
						fmap.put(ICiDictCodeConst.EMSORDRUG_RELATIVE_FIELD_MEASDOC_NAME, names.substring(1));
					}
					if (!CiOrdUtils.isEmpty(factors)) {
						fmap.put("factor", factors.substring(1));
					}
					emsOrDrug.setRelativefieldmap(fmap);
				}
			} else {
				emsOrDrug.setStr_unit_pkg_ids(emsOrDrug.getId_unit_med());
				FMap fmap = new FMap();
				fmap.put(ICiDictCodeConst.EMSORDRUG_RELATIVE_FIELD_ID_MEASDOC, emsOrDrug.getId_unit_med());
				fmap.put(ICiDictCodeConst.EMSORDRUG_RELATIVE_FIELD_MEASDOC_NAME, emsOrDrug.getName_unit_med());
				emsOrDrug.setRelativefieldmap(fmap);
			}
			
			// 设置联合主键  大小包装拼接单位  商品模式不拼
			if ("11".equals(DrugCheckDisplayMd4OP.getInstance().getDrugCheckDisplayMd4OP())&&!CiOrdUtils.isEmpty(contextdto.getCode_entp())&&IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(contextdto.getCode_entp())) {
				emsOrDrug.setIdSrvIdMm(emsOrDrug.getId_srv() + emsOrDrug.getId_mm() + emsOrDrug.getId_unit_sale());
			} else {
				emsOrDrug.setIdSrvIdMm(emsOrDrug.getId_srv() + emsOrDrug.getId_mm());
			}
			list.add(emsOrDrug);
		}
		this.setFact_count(list);
		return (EmsOrDrug[]) list.toArray(new EmsOrDrug[0]);
	}
	/**
	 * 设置执行科室信息
	 * @param mm
	 * @param source
	 * @param contextdto
	 * @throws BizException 
	 */
	private void setDepWhInfo(List<EmsOrDrug> mm, EmsDrugCreateParamDTO source, CiEnContextDTO contextdto) throws BizException {
		ICiOrdQryService ordQryService = ServiceFinder.find(ICiOrdQryService.class);
		for (EmsOrDrug drug : mm) {
			// 查询执行科室
			OrWfExDeptParamDTO param = new OrWfExDeptParamDTO();
			param.setEu_wftp(EnumFlow.NULL); // 0执行与物资 1执行科室 2物资流向
			param.setCode_entp(contextdto.getCode_entp()); // 就诊类型
			param.setId_dept_ns(contextdto.getId_dep_ns()); // 就诊护理病区
			param.setId_dept_or(Context.get().getDeptId());// 开单科室
			param.setId_dept_en(contextdto.getId_dep_en()); // 就诊科室
			param.setId_srv(drug.getId_srv()); // 服务
			param.setSd_srvtp(drug.getSd_srvtp()); // 服务类型sd
			param.setId_srvca(drug.getId_srvca()); // 服务分类
			param.setRecurstr(source.getFg_long() == null ? OrRecurTypeEnum.NULL.toString()
					: (source.getFg_long().booleanValue() ? OrRecurTypeEnum.LONG.toString()
							: OrRecurTypeEnum.TEMP.toString()));
			param.setId_mm(drug.getId_mm()); // 传物品id_mm没有用
			param.setSd_pois(drug.getSd_pois());
			param.setSd_herbpreparationtp(drug.getSd_herbpreparationtp());
			param.setId_dosage(drug.getId_dosage());
			param.setId_usage(source.getId_route()); // 用法
			FDateTime fdt = source.getDt_begin();
			if(fdt==null){
				fdt = CiOrdAppUtils.getServerDateTime();
			}
			param.setTimestr(fdt.getUFTime());
			if(isNotEmptyIgnoreBlank(contextdto.getDt_birth())){
				String newStr=contextdto.getDt_birth().substring(0, 10);
				param.setDt_birth(new FDate(newStr));// 患者年龄
			}
			param.setWeekno(CiOrdUtils.getDayOfWeek(fdt));
			param.setSd_herbpreparationtp(drug.getSd_herbpreparationtp());//草药制剂类型 
			//领药方式是出院带药
			if(ICiDictCodeConst.SD_DRUG_DELIVERY_METHOD_PRES_OUT.equals(source.getSd_drugdeliverymethod())||(contextdto.getFg_pres_outp()!=null&&contextdto.getFg_pres_outp().booleanValue())){
				param.setFg_pres_outp(FBoolean.TRUE);
			}else {
				param.setFg_pres_outp(FBoolean.FALSE);
			}
			OrWfDeptInfoDTO orWfDeptInfoDTO = ordQryService.getExeDepts4CiOrSrvN(param);
			if (orWfDeptInfoDTO != null && orWfDeptInfoDTO.getOrwfexedepts() != null
					&& orWfDeptInfoDTO.getOrwfexedepts().size() != 0) {
				drug.setId_mp_dep(((OrWfExDeptDTO) orWfDeptInfoDTO.getOrwfexedepts().get(0)).getId_dept());
				drug.setName_mp_dep(((OrWfExDeptDTO) orWfDeptInfoDTO.getOrwfexedepts().get(0)).getName_dept());
				if (drug != null && orWfDeptInfoDTO.getPharmwfwhdepts() != null
						&& orWfDeptInfoDTO.getPharmwfwhdepts().size() > 0) {
					drug.setId_dep_wh(((OrWfExDeptDTO) orWfDeptInfoDTO.getPharmwfwhdepts().get(0)).getId_dept());
					drug.setName_dep_wh(((OrWfExDeptDTO) orWfDeptInfoDTO.getPharmwfwhdepts().get(0)).getName_dept());
				}
				drug.setStr_mp_dep_ids(orWfDeptInfoDTO.getId_mp_depts());
				drug.setStr_wh_dep_ids(orWfDeptInfoDTO.getId_dept_whs());
			}
			// 草药库房校验
			if(!CiOrdUtils.isEmpty(drug.getSd_srvtp())&&drug.getSd_srvtp().startsWith(iih.bd.bc.udi.pub.IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)){
				if(setDepWh(orWfDeptInfoDTO,param,contextdto)){
					drug.setId_dep_wh(null);
					drug.setName_dep_wh(null);
				}
			}
			
		}
	}

	/**
	 * 校验医嘱流向科室返回值为当前就诊科室时，就诊科室赋值到药房的问题 liyuelong 2020/5/22
	 * 医嘱流向科室为空,临床赋值为就诊科室。操作类：iih.ci.ord.s.bp.common.GetExeDepts4CiOrSrvBP
	 * @param orWfDeptInfoDTO
	 * @param param
	 * @param contextdto
	 * @return
	 * @throws BizException
	 */
	private boolean setDepWh(OrWfDeptInfoDTO orWfDeptInfoDTO, OrWfExDeptParamDTO param, CiEnContextDTO contextdto)
			throws BizException {
		// 医嘱流向科室库房如果为就诊科室且服务执行科室为null，则可判断医嘱流向科室返回的当前科室是临床自己封装的，不能将就诊科室赋值到药房
		if (orWfDeptInfoDTO != null && orWfDeptInfoDTO.getOrwfexedepts() != null
				&& orWfDeptInfoDTO.getOrwfexedepts().size() != 0) {
			if (orWfDeptInfoDTO.getPharmwfwhdepts() != null && orWfDeptInfoDTO.getPharmwfwhdepts().size() > 0) {
				String id_dep_wh = ((OrWfExDeptDTO) orWfDeptInfoDTO.getPharmwfwhdepts().get(0)).getId_dept();
				// 获得服务执行科室
				OrWfExDeptDTO[] exdeptinfo = CiOrdAppUtils.getBdFcQryQryService().getOrExDeptMainBP(param);
				if (exdeptinfo == null && id_dep_wh.equals(contextdto.getId_dep_en())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 组装查询药品价格参数
	 * @param mms
	 * @return
	 */
	private GetStockReqDTO[] getMaterialStockQryParams(List<EmsOrDrug> mms){
		List<GetStockReqDTO> reqDtos = new ArrayList<GetStockReqDTO>();
		for (int i = 0; i < mms.size(); i++)
        {
            if (FBoolean.TRUE.equals(mms.get(i).getFg_mm()))//物品且非自备药时判断库存
            {
                GetStockReqDTO reqDTO = new GetStockReqDTO();
                reqDTO.setId_mm(mms.get(i).getId_mm());
                reqDTO.setId_dep(mms.get(i).getId_dep_wh());
                reqDTO.setReq_unit_id(mms.get(i).getId_unit_sale());
                reqDtos.add(reqDTO);
            }
        }
		return reqDtos.toArray(new GetStockReqDTO[0]);
	}
	/**
	 * 
	 * @code 设置药品库存
	 * @author LiYue
	 * @date 2019年5月21日,下午8:03:54
	 * @param drug
	 * @param source
	 * @param contextdto
	 * @throws BizException 
	 */
	private void setFact_count(List<EmsOrDrug> emsOrDrugs) throws BizException {
		StringBuilder strWhDepIds = new StringBuilder();
		for(EmsOrDrug drug : emsOrDrugs){
			strWhDepIds.append(drug.getStr_wh_dep_ids()+",");
		}
		if(strWhDepIds.length()>0)
		{
			strWhDepIds.deleteCharAt(strWhDepIds.length()-1);
		}
		if(strWhDepIds.length()==0){
			return;
		}
		List<GetStockReqDTO> stockDtos = new ArrayList<GetStockReqDTO>();
		//查询所有的科室
		Map<String,String> deptMap = getNameDepts(strWhDepIds.toString());
		for(EmsOrDrug drug : emsOrDrugs){
			String id_dep_whs = drug.getStr_wh_dep_ids();
			if(StringUtils.isEmpty(id_dep_whs)){
				continue;
			}
			String[] whArrays = id_dep_whs.split(",");
			for(String id_dep_wh : whArrays){
				String id_dep = id_dep_wh.replaceAll("'", "");
				GetStockReqDTO reqDTO = new GetStockReqDTO();
				reqDTO.setId_mm(drug.getId_mm());
				reqDTO.setId_dep(id_dep);
				reqDTO.setReq_unit_id(drug.getId_unit_sale());
				stockDtos.add(reqDTO);
			}
		}	
		if(stockDtos.size() > 0){
			Map<String,FactOutPricBean> stockMap = getFactCount(stockDtos);
			for(EmsOrDrug drug : emsOrDrugs){
				StringBuilder fullCountWhs = new StringBuilder();
				String id_dep_whs = drug.getStr_wh_dep_ids();
				if(StringUtils.isEmpty(id_dep_whs)){
					continue;
				}
				String[] whArrays = id_dep_whs.split(",");
				//先判断优先级最好的仓库是否有库存
				String key = drug.getId_mm() + drug.getId_dep_wh();
				FactOutPricBean factOutPrice = null;
				if(stockMap.containsKey(key)){
					factOutPrice = stockMap.get(key);
					if(factOutPrice.getFactCount().compareTo(FDouble.ZERO_DBL)>0){
						drug.setFact_count(factOutPrice.getFactCount());
						drug.setPrice(factOutPrice.getPrice());
					}
				}
				for(String id_dep_wh : whArrays){
					String id_dep = id_dep_wh.replaceAll("'", "");
					key = drug.getId_mm() + id_dep;
					if(stockMap.containsKey(key)){
						factOutPrice = stockMap.get(key);
						if(factOutPrice.getFactCount().compareTo(FDouble.ZERO_DBL)>0){
							fullCountWhs.append(id_dep_wh+",");
							
							if(drug.getFact_count() == null || drug.getFact_count().compareTo(FDouble.ZERO_DBL) <= 0){
								drug.setFact_count(factOutPrice.getFactCount());
								drug.setPrice(factOutPrice.getPrice());
								drug.setId_dep_wh(id_dep);
								if(deptMap!=null && deptMap.containsKey(id_dep)){
									drug.setName_dep_wh(deptMap.get(id_dep));
								}
							}
						}
					}
				}
				if(fullCountWhs.length()>0)
				{
					fullCountWhs.deleteCharAt(fullCountWhs.length()-1);
				}
				drug.setStr_wh_dep_ids(fullCountWhs.toString());
			}
		}	
	}
	private Map<String,String> getNameDepts(String id_dep_whs) throws DAException{
		String sql = "select id_dep,name from bd_dep where id_dep in ("+id_dep_whs+")";
		List<DeptDO> depts = (List<DeptDO>) new DAFacade().execQuery(sql, new BeanListHandler(DeptDO.class));
		if(depts!=null && depts.size()>0){
			Map<String,String> map = new HashMap<String,String>();
			for(DeptDO dept : depts){
				map.put(dept.getId_dep(), dept.getName());
			}
			return map;
		}
		return null;
	}
	private Map<String,FactOutPricBean> getFactCount(List<GetStockReqDTO> reqDtos) throws BizException{
		MaterialStockDTO[] stockdto = null;
		IMaterialStockService stoctService = CiOrdAppUtils.getMaterialStockQryService();
		stockdto = stoctService.getMaterialStocks(reqDtos.toArray(new GetStockReqDTO[0]));
		Map<String,FactOutPricBean> maps = new HashMap<String,FactOutPricBean>();
		
		if(stockdto != null) {
			for (MaterialStockDTO materialStockDTO : stockdto) {
				int mmStatus = materialStockDTO.getMmstatus();
				FDouble factCount = FDouble.ZERO_DBL;
				if(mmStatus == MaterialStatus.STOP ||mmStatus == MaterialStatus.NORELATION) {
					factCount = FDouble.ZERO_DBL;
				}else {
					factCount = materialStockDTO.getQuan_stock();
				}	
				String key = materialStockDTO.getId_mm()+materialStockDTO.getId_dep();
				FactOutPricBean factOutPric = new FactOutPricBean();
				factOutPric.setFactCount(factCount);
				factOutPric.setPrice(materialStockDTO.getPrice_act());
				maps.put(key, factOutPric);
			}	
		}
		return maps;
	}
	
	/**
	 * 包含价格和库存的内部类
	 * @author zhangwq
	 *
	 */
	public class FactOutPricBean{
		private FDouble price;
		private FDouble factCount;
		public FDouble getPrice() {
			return price;
		}
		public void setPrice(FDouble price) {
			this.price = price;
		}
		public FDouble getFactCount() {
			return factCount;
		}
		public void setFactCount(FDouble factCount) {
			this.factCount = factCount;
		}
	}
	/** 
     * 判断字符串是否为非空(包含null与"","    ") 
     * @param str 
     * @return 
     */  
    public static boolean isNotEmptyIgnoreBlank(String str){  
        if(str == null || "".equals(str) || "".equals(str.trim()))  
            return false;  
        return true;  
    }
}
