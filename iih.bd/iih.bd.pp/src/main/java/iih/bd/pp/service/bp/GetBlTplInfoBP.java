package iih.bd.pp.service.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.fc.wf.d.EnumFlow;
import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.pp.bdbltpl.d.BdBlTplDO;
import iih.bd.pp.bdbltpl.d.BdBlTplOwTypeEnum;
import iih.bd.pp.bdbltpl.d.BdBltplItmDO;
import iih.bd.pp.bdbltpl.d.BdbltplAggDO;
import iih.bd.pp.bdbltpl.d.desc.BdBlTplDODesc;
import iih.bd.pp.bdbltpl.s.BdbltplCrudServiceImpl;
import iih.bd.pp.dto.bltpl.d.BlTplDTO;
import iih.bd.pp.dto.bltpl.d.BlTplItmDTO;
import iih.bd.pp.dto.d.PriStdSrvDTO;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.pp.primd.i.IPriCalService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.mp.dg.dto.mpdrugflow.d.MpDrugFlowDTO;
import iih.mp.dg.i.IMpDgOutService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.SqlBuildHelper;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 取得费用模板信息处理类 按照费用模板里的服务都为标准服务处理
 * 
 * @author ly
 *
 */
public class GetBlTplInfoBP {

	/**
	 * 取得费用模板信息 补充srv信息，物品信息及金额
	 * 
	 * @param deptId 责任科室
	 * @param empId 责任人
	 * @param containHos 包含院级模板
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BlTplDTO[] exec(String deptId, String empId,FBoolean containHos) throws BizException {

		// 取得费用模板数据
		BdbltplCrudServiceImpl tplService = new BdbltplCrudServiceImpl();
		String whereSql = "a0.ds = 0 and ";
		whereSql += this.getDeptPsnWhereSql(deptId, empId, containHos,
				BdBlTplDODesc.TABLE_ALIAS_NAME);

		BdbltplAggDO[] tplAggs = tplService.find(whereSql,
				"a0.sd_owtp,a0.code", FBoolean.FALSE);

		if (ArrayUtil.isEmpty(tplAggs))
			return null;

		// 补充srv信息
		List<MedSrvDO> srvList = this.getSrvInfo(deptId, empId, containHos);
		// 转化为map
		Map<String, MedSrvDO> srvMap = (Map<String, MedSrvDO>) this
				.convertArrayToMap(srvList.toArray(new MedSrvDO[0]),MedSrvDO.ID_SRV);

		// 将srv信息分为物品及非物品服务
		List<String> mmSrvList = new ArrayList<String>();// 物品服务
		List<MedSrvDO> notMmSrvList = new ArrayList<MedSrvDO>();// 非物品服务
		for (MedSrvDO srv : srvList) {
			if (FBoolean.TRUE.equals(srv.getFg_mm())) {
				mmSrvList.add(srv.getId_srv());
			} else {
				notMmSrvList.add(srv);
			}
		}
		// 补充物品信息
		Map<String, MeterialDO> mmMap = this.getMmInfo(mmSrvList);
		//物品模板明细信息
		Map<String, BdBltplItmDO> mmTplItm = this.getMmItm(tplAggs);
		// 补充物品单位信息
		Map<String, MMPackageUnitDO> mmPkgUnitMap = new HashMap<String, MMPackageUnitDO>();
		
		// 取得srv金额信息
		Map<String, FDouble> srvPriceMap = this.getSrvPrice(notMmSrvList);
		
		// 取得物品金额信息
		Map<String, FDouble> mmPriceMap = this.getMmPrice(mmTplItm,srvMap,mmPkgUnitMap);

		// 组织返回数据
		return this.organizeReturnData(tplAggs, srvMap, mmMap,mmPkgUnitMap, srvPriceMap,mmPriceMap);
	}


	/**
	 * 取得医嘱服务信息
	 * 
	 * @param deptId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<MedSrvDO> getSrvInfo(String deptId, String empId, FBoolean containHos)
			throws BizException {

		// 服务DO模型中关联表较多，所以用sql取
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select distinct ");
		sqlSb.append("bd_srv.*, ");
		sqlSb.append("bd_measdoc.name as med_name ");
		sqlSb.append("from bd_bltpl ");
		sqlSb.append("inner join bd_bltpl_itm ");
		sqlSb.append("on bd_bltpl.id_bltpl = bd_bltpl_itm.id_bltpl ");
		sqlSb.append("and bd_bltpl_itm.ds = 0 ");
		sqlSb.append("inner join bd_srv ");
		sqlSb.append("on bd_bltpl_itm.id_srv = bd_srv.id_srv ");

		sqlSb.append("left join bd_measdoc ");
		sqlSb.append("on bd_srv.id_unit_med = bd_measdoc.id_measdoc ");
		sqlSb.append("where bd_bltpl.ds = 0 ");
		sqlSb.append("and "
				+ this.getDeptPsnWhereSql(deptId, empId, containHos, "bd_bltpl"));

		DAFacade daf = new DAFacade();
		List<MedSrvDO> srvList = (List<MedSrvDO>) daf.execQuery(
				sqlSb.toString(), new BeanListHandler(MedSrvDO.class));

		return srvList;
	}

	/**
	 * 取得物品信息 对应的srv没有取到数据也不做异常提示
	 * 
	 * @param mmSrvList
	 * @return key:id_mm value:MeterialDO
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private Map<String, MeterialDO> getMmInfo(List<String> mmSrvList)
			throws BizException {

		Map<String, MeterialDO> result = new HashMap<String, MeterialDO>();
		if (ListUtil.isEmpty(mmSrvList))
			return result;
		
		
		SqlBuildHelper sqlSb = new SqlBuildHelper();
		sqlSb.append("select bd_mm.* ");
		sqlSb.append("from bd_mm ");
		sqlSb.append("where bd_mm.ds = 0 ");
		sqlSb.append("and bd_mm.id_srv", mmSrvList.toArray(new String[0]));
		sqlSb.append(" order by bd_mm.id_srv,bd_mm.code");

		DAFacade daf = new DAFacade();
		List<MeterialDO> mmList = (List<MeterialDO>) daf.execQuery(
				sqlSb.toString(), new BeanListHandler(MeterialDO.class));

		if (ListUtil.isEmpty(mmList)) {
			return result;
		}

		// 转化为map
		result = (Map<String, MeterialDO>) this.convertArrayToMap(
				mmList.toArray(new MeterialDO[0]), MeterialDO.ID_MM);

		return result;
	}

	/**
	 * 取得物品模板明细信息
	 * @param tplAggs
	 * @return
	 */
	private Map<String, BdBltplItmDO> getMmItm(BdbltplAggDO[] tplAggs) {
		Map<String, BdBltplItmDO> itmmap = new HashMap<String, BdBltplItmDO>();
		if(tplAggs == null || tplAggs.length <= 0)
			return itmmap;
		for (BdbltplAggDO bdbltplAggDO : tplAggs) {
			BdBltplItmDO[] tplitms = bdbltplAggDO.getBdBltplItmDO();
			for (BdBltplItmDO bdBltplItmDO : tplitms) {
				if (!StringUtils.isEmpty(bdBltplItmDO.getId_mm())) {
					itmmap.put(bdBltplItmDO.getId_bltplitm(), bdBltplItmDO);
				}
			}
		}
		return itmmap;
	}
	
	/**
	 * 获取srv金额信息 费用模板里的服务应该都是标准服务
	 * 
	 * @param notMmSrvList
	 * @return
	 * @throws BizException
	 */
	private Map<String, FDouble> getSrvPrice(List<MedSrvDO> notMmSrvList)
			throws BizException {

		IPriCalService priService = ServiceFinder.find(IPriCalService.class);
		List<PriStdSrvDTO> priList = new ArrayList<PriStdSrvDTO>();
		for (MedSrvDO dto : notMmSrvList) {
			PriStdSrvDTO priDto = new PriStdSrvDTO();
			priDto.setId_srv(dto.getId_srv());
			priDto.setName_srv(dto.getName());
			priList.add(priDto);
		}
		// 取得服务对应价格
		PriStdSrvDTO[] srvDtos = priService.CalManySrvsStdPrices(priList
				.toArray(new PriStdSrvDTO[priList.size()]));

		Map<String, FDouble> result = new HashMap<String, FDouble>();

		if (ArrayUtil.isEmpty(srvDtos))
			return result;

		for (PriStdSrvDTO dto : srvDtos) {
			result.put(dto.getId_srv(), dto.getPrice());
		}

		return result;
	}

	/**
	 * 获取物品金额信息
	 * 
	 * @param mmMap
	 * @param srvMap 
	 * @param mmPkgUnitMap 
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private Map<String, FDouble> getMmPrice(Map<String, BdBltplItmDO> tplmmItm, Map<String, MedSrvDO> srvMap,
			Map<String, MMPackageUnitDO> mmPkgUnitMap)
			throws BizException {

		Map<String, FDouble> result = new HashMap<String, FDouble>();
		
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT MMPKGU.ID_MM,                 ");
		sb.append("   MMPKGU.ID_MMPKGU,                  ");
		sb.append("   MMPKGU.ID_UNIT_PKG,                ");
		sb.append("   MMPKGU.FACTOR,                     ");
		sb.append("   MMPKGU.MMPKGUNAME                  ");
		sb.append(" FROM BD_BLTPL_ITM ITM                ");
		sb.append(" INNER JOIN BD_MM_PKGU MMPKGU         ");
		sb.append(" ON ITM.ID_MM    = MMPKGU.ID_MM       ");
		sb.append(" AND ITM.ID_UNIT = MMPKGU.ID_UNIT_PKG ");
		sb.append(" AND MMPKGU.DS = 0                        ");
		
		DAFacade daf = new DAFacade();
		List<MMPackageUnitDO> mmpkgulist = (List<MMPackageUnitDO>) daf.execQuery(
				sb.toString(), new BeanListHandler(MMPackageUnitDO.class));
		
		// 应该根据流程配置取到执行药房，在从库存中取价格
		IMpDgOutService dgOutService = ServiceFinder.find(IMpDgOutService.class);
		List<MpDrugFlowDTO> flowList = new ArrayList<MpDrugFlowDTO>();
		MpDrugFlowDTO[] resultDtos = null;
		for(BdBltplItmDO bdBltplItmDO : tplmmItm.values()){
			MedSrvDO srvDo = srvMap.get(bdBltplItmDO.getId_srv());
			MpDrugFlowDTO flowDto = new MpDrugFlowDTO();
			flowDto.setId_srv(srvDo.getId_srv());
			flowDto.setId_mm(bdBltplItmDO.getId_mm());
			flowDto.setSd_srvtp(srvDo.getSd_srvtp());
			flowDto.setId_srvca(srvDo.getId_srvca());
			flowDto.setId_measdoc(bdBltplItmDO.getId_unit());
			flowDto.setCode_entp("10");
			flowDto.setEu_wftp(EnumFlow.SUPPLIESFLOW);
			flowList.add(flowDto);
			
			for (MMPackageUnitDO mmPkug : mmpkgulist) {
				if (mmPkug.getId_mm().equals(bdBltplItmDO.getId_mm()) 
						&& mmPkug.getId_unit_pkg().equals(bdBltplItmDO.getId_unit())) {
					//单位map
					mmPkgUnitMap.put(mmPkug.getId_mm() + mmPkug.getId_unit_pkg(),mmPkug);
					break;
				}
			}
		}

		resultDtos = dgOutService.getMaterialFlowAndStockPrice(flowList.toArray(new MpDrugFlowDTO[0]));
		if(!ArrayUtil.isEmpty(resultDtos)){
			for(MpDrugFlowDTO res : resultDtos){
				
				if(FBoolean.TRUE.equals(res.getResult()) && res.getPrice() != null){
					result.put(res.getId_srv(), res.getPrice());
				}else{
					result.put(res.getId_srv(),  FDouble.ZERO_DBL);
				}
			}
		}
		
		return result;
	}

	/**
	 * 组织返回数据
	 * 
	 * @param tplAggs
	 *            费用模板数据
	 * @param srvMap
	 *            服务数据
	 * @param mmMap
	 *            物品数据
	 * @param mmPkgUnitMap 
	 * 			  物品单位
	 * @param srvPriceMap
	 *            服务价格
	 * @param mmPriceMap
	 *            物品价格
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private BlTplDTO[] organizeReturnData(BdbltplAggDO[] tplAggs,
			Map<String, MedSrvDO> srvMap, Map<String, MeterialDO> mmMap,
			Map<String, MMPackageUnitDO> mmPkgUnitMap, Map<String, FDouble> srvPriceMap, Map<String, FDouble> mmPriceMap) {

		// 组织返回数据
		List<BlTplDTO> result = new ArrayList<BlTplDTO>();
		for (BdbltplAggDO tplAgg : tplAggs) {
			BdBlTplDO tplDo = tplAgg.getParentDO();
			BdBltplItmDO[] tplItmDos = tplAgg.getBdBltplItmDO();

			// 设置主dto数据
			BlTplDTO tplDto = new BlTplDTO();
			tplDto.setId_bltpl(tplDo.getId_bltpl());
			tplDto.setId_owtp(tplDo.getId_owtp());
			tplDto.setSd_owtp(tplDo.getSd_owtp());
			tplDto.setId_bltpltp(tplDo.getId_bltpltp());
			tplDto.setSd_bltpltp(tplDo.getSd_bltpltp());
			tplDto.setName(tplDo.getName());
			tplDto.setCode(tplDo.getCode());
			tplDto.setDes(tplDo.getDes());
			result.add(tplDto);

			FArrayList children = new FArrayList();
			tplDto.setDetails(children);

			if (ArrayUtil.isEmpty(tplItmDos))
				continue;

			for (BdBltplItmDO tplItmDo : tplItmDos) {
				// 设置子dto数据
				BlTplItmDTO tplItmDto = new BlTplItmDTO();
				tplItmDto.setId_bltplitm(tplItmDo.getId_bltplitm());
				tplItmDto.setId_bltpl(tplItmDo.getId_bltpl());
				tplItmDto.setSortno(tplItmDo.getSortno());
				tplItmDto.setId_srv(tplItmDo.getId_srv());
				tplItmDto.setId_unit_med(tplItmDo.getId_unit());//srvDo.getId_unit_med()
				

				MedSrvDO srvDo = srvMap.get(tplItmDto.getId_srv());
				if (srvDo != null) {
					// srv信息
					tplItmDto.setCode_srv(srvDo.getCode());
					tplItmDto.setName_srv(srvDo.getName());
					tplItmDto.setId_srvtp(srvDo.getId_srvtp());
					tplItmDto.setSd_srvtp(srvDo.getSd_srvtp());
					tplItmDto.setId_srvca(srvDo.getId_srvca());
					tplItmDto.setName_unit_med(srvDo.getMed_name());
					tplItmDto.setFg_mm(srvDo.getFg_mm());
					tplItmDto.setFg_active(IBdPrimdCodeConst.CODE_PRI_SRV.equals(srvDo.getSd_primd()) ? srvDo.getFg_active_bl() : srvDo.getFg_active());
				}

				if (FBoolean.TRUE.equals(tplItmDto.getFg_mm())) {
					// 物品信息
					MeterialDO mmDo = mmMap.get(tplItmDo.getId_mm());
					if (mmDo != null) {
						tplItmDto.setQuan_medu(tplItmDo.getQuan_medu());
						tplItmDto.setId_mm(mmDo.getId_mm());
						tplItmDto.setName_mm(mmDo.getName());
						tplItmDto.setSpec(mmDo.getSpec());
						tplItmDto.setPrice(mmPriceMap.get(tplItmDo.getId_srv()));
						tplItmDto.setFactor(mmPkgUnitMap.get(tplItmDo.getId_mm()+tplItmDo.getId_unit()).getFactor());
						
						tplItmDto.setFactor_mb(mmDo.getFactor_mb());
						tplItmDto.setId_pkgu_base(mmDo.getId_unit_pkgbase());		
						tplItmDto.setId_pkgu_cur(mmDo.getId_unit_pkgsp());
						tplItmDto.setId_mmpkgu(mmPkgUnitMap.get(tplItmDo.getId_mm()+tplItmDo.getId_unit()).getId_mmpkgu());
						tplItmDto.setId_unit_pkg(mmPkgUnitMap.get(tplItmDo.getId_mm()+tplItmDo.getId_unit()).getId_unit_pkg());
						tplItmDto.setName_unit_pkg(mmPkgUnitMap.get(tplItmDo.getId_mm()+tplItmDo.getId_unit()).getMmpkguname());
						tplItmDto.setId_route(srvDo.getId_route());
						tplItmDto.setFg_otc(mmDo.getFg_otc());
						tplItmDto.setFg_active(new FBoolean(tplItmDto.getFg_active().booleanValue() && mmDo.getFg_active().booleanValue()));
					}
				} else {
					tplItmDto.setQuan_medu(tplItmDo.getQuan_medu());
					tplItmDto.setPrice(srvPriceMap.get(tplItmDto.getId_srv()));
				}

				children.add(tplItmDto);
			}
		}

		return result.toArray(new BlTplDTO[result.size()]);
	}

	/**
	 * 获取全员，科室，人员条件串
	 * 
	 * @param deptId
	 * @param empId
	 */
	private String getDeptPsnWhereSql(String deptId, String empId,
			FBoolean containHos, String tableName) {

		String whereSql = "(";
		//包含全院
		if(FBoolean.TRUE.equals(containHos)){
			whereSql += "%s.sd_owtp = "
					+ BdBlTplOwTypeEnum.HOSPITALAUTHORITY;
			whereSql = String.format(whereSql, tableName);
		}

		// 责任科室不为空
		if (!StringUtil.isEmpty(deptId)) {
			
			if(!"(".equals(whereSql)){
				whereSql += " or ";
			}
			whereSql += "(%s.sd_owtp = " + BdBlTplOwTypeEnum.DEPAUTHORITY
					+ " " + "and %s.id_dep = '" + deptId + "')";
			whereSql = String.format(whereSql, tableName, tableName);
		}
		// 责任人不为空
		if (!StringUtil.isEmpty(empId)) {
			
			if(!"(".equals(whereSql)){
				whereSql += " or ";
			}
			
			whereSql += "(%s.sd_owtp = " + BdBlTplOwTypeEnum.SELFAUTHORITY
					+ " " + "and %s.id_emp = '" + empId + "')";
			whereSql = String.format(whereSql, tableName, tableName);
		}
		whereSql += ")";

		return whereSql;
	}

	/**
	 * 转为map
	 * 
	 * @param dos
	 * @param keyName
	 * @return
	 */
	public Map<String, ? extends BaseDO> convertArrayToMap(BaseDO[] dos,
			String keyName) {

		Map<String, BaseDO> map = new HashMap<String, BaseDO>();
		if (ArrayUtil.isEmpty(dos))
			return map;

		for (BaseDO baseDO : dos) {
			String key = baseDO.getAttrVal(keyName).toString();
			if (map.containsKey(key))
				continue;

			map.put(key, baseDO);
		}

		return map;
	}
}
