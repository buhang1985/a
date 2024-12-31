package iih.ci.ord.s.bp.ordforbl;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.dto.prescostdto.d.PrescriptionConstBaseDto;
import iih.ci.ord.dto.prescostdto.d.PrescriptionCostDto;
import iih.ci.ord.dto.recipedto.d.RecipeDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.ordforbl.qry.GetUnchargeDrugOrdQry;
import iih.ci.ord.s.bp.ordforbl.qry.GetUnchargeSrvOrdQry;
import iih.ci.ord.s.bp.qry.RecipeDTOQry;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;

/**
 * 门诊费用调入逻辑（新版）
 * 仅支持旧版门诊收费调入
 * @author ly 2019/04/19
 *
 */
public class GetUnchargeOrdBP {

	/**
	 * 门诊费用调入
	 * @param patId 患者id
	 * @param dtSignB 开始时间 
	 * @param dtSignE 结束时间
	 * @param code_entps 就诊类型
	 * @return 调入结果
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public PrescriptionConstBaseDto exec(String patId, FDateTime dtSignB, FDateTime dtSignE, String[] code_entps) 
			throws BizException {

		//参数校验略
		PrescriptionConstBaseDto  baseDto = new PrescriptionConstBaseDto();
		
		//1.查询药品数据
		GetUnchargeDrugOrdQry drugQry = new GetUnchargeDrugOrdQry(patId, dtSignB, dtSignE, code_entps);		
		PrescriptionCostDto[] drugDatas = (PrescriptionCostDto[]) AppFwUtil.getDORstWithDao(drugQry, PrescriptionCostDto.class);
		 
		//2.查询诊疗数据
		GetUnchargeSrvOrdQry srvQry = new GetUnchargeSrvOrdQry(patId, dtSignB, dtSignE, code_entps);		
		PrescriptionCostDto[] srvDatas = (PrescriptionCostDto[]) AppFwUtil.getDORstWithDao(srvQry, PrescriptionCostDto.class);
		//2.1补充打印单据
		this.addSrvPrnInfo(srvDatas);
				
		//以下逻辑摘自原getPrescriptionCostDtoBP中逻辑
		
		String[] str = null;
		if (!ArrayUtil.isEmpty(drugDatas)) {
			str = CiOrdUtils.getDiag(drugDatas[0].getId_en());
		} else if (!ArrayUtil.isEmpty(srvDatas)) {
			str = CiOrdUtils.getDiag(srvDatas[0].getId_en());
		}

		FArrayList prescriptionList = new FArrayList();
		FArrayList prescrptionObsAndLabList = new FArrayList();
		Map<String,String> map = new HashMap<String,String>();

		if (!ArrayUtil.isEmpty(drugDatas)) {
			for (PrescriptionCostDto presDto : drugDatas) {
				if (presDto.getPresno() == null) {
					presDto.setPresno(presDto.getCode());
				}
				prescriptionList.add(presDto);
				map.put(presDto.getId_pres(), presDto.getId_pres());
			}
		}

		if (!ArrayUtil.isEmpty(srvDatas)) {
			for (PrescriptionCostDto presDto : srvDatas) {
				prescriptionList.add(presDto);
				// 检查检验 虚拟处方
				prescrptionObsAndLabList.add(this.getPrescrptionObsAndLab(presDto, str));

			}
		}

		baseDto.setPrescriptionCostDto(prescriptionList);
		FArrayList prescrptionlist = getPress(map);
		if (prescrptionlist != null && prescrptionlist.size() > 0) {
			for (int i = 0; i < prescrptionlist.size(); i++) {
				prescrptionObsAndLabList.add(prescrptionlist.get(i));
			}
		}
		baseDto.setRecipeDTO(prescrptionObsAndLabList);

		return baseDto;
	}
	
	/**
	 * 补充诊疗项目单据信息
	 * @param srvDatas
	 * @throws BizException
	 */
	private void addSrvPrnInfo(PrescriptionCostDto[] srvDatas) throws BizException {
		
		if(ArrayUtil.isEmpty(srvDatas))
			return;
		
		
		Set<String> risOrSet = new HashSet<String>(); //检查
		Set<String> lisOrSet = new HashSet<String>(); //检验
		Set<String> bingliOrSet = new HashSet<String>(); //病理
		Set<String> otherOrsrvSet = new HashSet<String>(); //其他
		
		for (PrescriptionCostDto costDto : srvDatas) {
			
			if(IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI.equals(costDto.getOrdsd_srvtp())){
				bingliOrSet.add(costDto.getId_or());
				costDto.setPrntype("05");
			}else if(costDto.getOrdsd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)){
				risOrSet.add(costDto.getId_or());
				costDto.setPrntype("02");
			}else if(costDto.getOrdsd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS)){
				lisOrSet.add(costDto.getId_or());
				costDto.setPrntype("03");
			}else{
				otherOrsrvSet.add(costDto.getId_orsrv());
				costDto.setPrntype("04");
			}
		}
		
		Map<String, String> risOrPrnMap = new HashMap<String, String>();
		Map<String, String> lisOrPrnMap = new HashMap<String, String>();
		Map<String, String> bingliPrnOrMap = new HashMap<String, String>();
		Map<String, String> otherOrPrnMap = new HashMap<String, String>();
		
		if(risOrSet.size() > 0){
			risOrPrnMap = this.getRisPrnMap(risOrSet.toArray(new String[0]));
		}
		
		if(lisOrSet.size() > 0){
			lisOrPrnMap = this.getLisPrnMap(lisOrSet.toArray(new String[0]));
		}
		
		if(bingliOrSet.size() > 0){
			bingliPrnOrMap = this.getBingliPrnMap(bingliOrSet.toArray(new String[0]));
		}
		
		if(otherOrsrvSet.size() > 0){
			otherOrPrnMap = this.getOtherPrnMap(otherOrsrvSet.toArray(new String[0]));
		}
		
	for (PrescriptionCostDto costDto : srvDatas) {
			
			if(IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI.equals(costDto.getOrdsd_srvtp())){
				String code = bingliPrnOrMap.get(costDto.getId_or());
				costDto.setPresno(code);
			}else if(costDto.getOrdsd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)){
				String code = risOrPrnMap.get(costDto.getId_or());
				costDto.setPresno(code);
			}else if(costDto.getOrdsd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS)){
				String code = lisOrPrnMap.get(costDto.getId_or());
				costDto.setPresno(code);
			}else{
				String code = otherOrPrnMap.get(costDto.getId_orsrv());
				costDto.setPresno(code);
			}
			
			if(StringUtil.isEmpty(costDto.getPresno())){
				costDto.setPresno(costDto.getCode_or());
			}
		}
	}
	
	/**
	 * 补充检查打印单号
	 * @param orIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private Map<String, String> getRisPrnMap(String[] orIds) throws BizException {

		Map<String,String> rtnMap = new HashMap<String,String>();
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select risor.id_or,ris.code_app ");
		sqlSb.append("from ci_app_ris_or risor ");
		sqlSb.append("inner join ci_app_ris ris  ");
		sqlSb.append("on risor.id_ciapprissheet = ris.id_ciapprissheet ");
		sqlSb.append("where ");
		
		sqlSb.append(SqlUtils.getInSqlByIds("risor.id_or", orIds));
		DAFacade daf = new DAFacade();
		List<Map<String, Object>> rlt = (List<Map<String, Object>>)daf.execQuery(sqlSb.toString(), new MapListHandler());
		
		
		if(ListUtil.isEmpty(rlt))
			return rtnMap;
		
		for (Map<String, Object> map : rlt) {
			
			String orId = (String)map.get("id_or");
			String code = (String)map.get("code_app");
			
			rtnMap.put(orId, code);
		}
		
		return rtnMap;
	}
	
	/**
	 * 补充检验打印单号
	 * @param orIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private Map<String, String> getLisPrnMap(String[] orIds) throws BizException {

		Map<String,String> rtnMap = new HashMap<String,String>();
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select lisor.id_or,lis.code_app ");
		sqlSb.append("from ci_app_lis_or lisor ");
		sqlSb.append("inner join ci_app_lis lis  ");
		sqlSb.append("on lisor.id_ciapplissheet = lis.id_ciapplissheet ");
		sqlSb.append("where ");
		
		sqlSb.append(SqlUtils.getInSqlByIds("lisor.id_or", orIds));
		DAFacade daf = new DAFacade();
		List<Map<String, Object>> rlt = (List<Map<String, Object>>)daf.execQuery(sqlSb.toString(), new MapListHandler());
		
		
		if(ListUtil.isEmpty(rlt))
			return rtnMap;
		
		for (Map<String, Object> map : rlt) {
			
			String orId = (String)map.get("id_or");
			String code = (String)map.get("code_app");
			
			rtnMap.put(orId, code);
		}
		
		return rtnMap;
	}
	
	/**
	 * 补充病理打印单号
	 * @param orIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private Map<String, String> getBingliPrnMap(String[] orIds) throws BizException {

		Map<String,String> rtnMap = new HashMap<String,String>();
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select pathgy.id_or,pathgy.code_app ");
		sqlSb.append("from ci_app_pathgy pathgy ");
		sqlSb.append("where ");
		
		sqlSb.append(SqlUtils.getInSqlByIds("pathgy.id_or", orIds));
		DAFacade daf = new DAFacade();
		List<Map<String, Object>> rlt = (List<Map<String, Object>>)daf.execQuery(sqlSb.toString(), new MapListHandler());
		
		
		if(ListUtil.isEmpty(rlt))
			return rtnMap;
		
		for (Map<String, Object> map : rlt) {
			
			String orId = (String)map.get("id_or");
			String code = (String)map.get("code_app");
			
			rtnMap.put(orId, code);
		}
		
		return rtnMap;
	}
	
	/**
	 * 补充其他打印单号
	 * @param orsrvIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private Map<String, String> getOtherPrnMap(String[] orsrvIds) throws BizException {

		Map<String,String> rtnMap = new HashMap<String,String>();
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select prnitm.id_biz,prn.code_prn ");
		sqlSb.append("from ci_prn_item prnitm ");
		sqlSb.append("inner join ci_prn prn ");
		sqlSb.append("on prnitm.id_ciprn = prn.id_ciprn ");
		sqlSb.append("where ");
		
		sqlSb.append(SqlUtils.getInSqlByIds("prnitm.id_biz", orsrvIds));
		DAFacade daf = new DAFacade();
		List<Map<String, Object>> rlt = (List<Map<String, Object>>)daf.execQuery(sqlSb.toString(), new MapListHandler());
		
		
		if(ListUtil.isEmpty(rlt))
			return rtnMap;
		
		for (Map<String, Object> map : rlt) {
			
			String orId = (String)map.get("id_biz");
			String code = (String)map.get("code_prn");
			
			rtnMap.put(orId, code);
		}
		
		return rtnMap;
	}
	
	// 检查检验 虚拟处方 需要完善 todo
	private RecipeDTO getPrescrptionObsAndLab(PrescriptionCostDto presDto,
			String[] str) throws BizException {
		RecipeDTO prescriptionInfo = new RecipeDTO();
		prescriptionInfo.setId_pres(presDto.getId_pres());
		prescriptionInfo.setPrestp_name(presDto.getPresrption_name());
		prescriptionInfo.setId_en(presDto.getId_en());
		prescriptionInfo.setId_pat(presDto.getId_pat());

		prescriptionInfo.setRecipetype(presDto.getFg_self());
		// 开单科室名称
		prescriptionInfo.setHospital_dept_name(presDto.getId_dep_srv());

		if (str != null && str.length > 1) {
			// 诊断编码字符串
			prescriptionInfo.setDidef_code(str[1]);
			// 诊断名称字符串
			prescriptionInfo.setDidef_name(str[0]);
		}

		// 处方日期，对于检查检验，则为医嘱开立日期
		prescriptionInfo.setDt_entry(presDto.getDt_sign());
		prescriptionInfo.setId_dep_or(presDto.getId_dep_srv());
		prescriptionInfo.setId_dep_name(presDto.getName_dep_srv());
		// 开单医生名称
		prescriptionInfo.setId_emp_or(presDto.getId_emp_srv());
		// 开单医生姓名
		prescriptionInfo.setId_emp_name(null);
		// 单据类型，能标示是药品还是诊疗的字段
		// prescriptionInfo.setBillstype("5");

		return prescriptionInfo;
	}
	
	 /***
	 * 患者未计费处方信息(药品)
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private  FArrayList  getPress(Map<String,String> map)throws BizException{
		
		FArrayList recipres = new FArrayList();
		if(map != null && map.size() >0){
			String id_press = "";
			for(String pres :map.keySet()){
				id_press += "'"+pres +"',";
			}
			id_press = id_press.substring(0, id_press.lastIndexOf(","));
			RecipeDTOQry qry = new RecipeDTOQry(id_press);
			RecipeDTO[] RecipresList = (RecipeDTO[])AppFwUtil.getDORstWithDao(qry, RecipeDTO.class);
		    if(RecipresList != null && RecipresList.length>0){
		    	for(RecipeDTO dto :RecipresList){
		    		recipres.add(dto);
		    	}
		    }
		}
		
		return recipres;
	}
}
