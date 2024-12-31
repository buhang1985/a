package iih.bl.inc.s.bp.inc.incsplit;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.pp.inccasplit.d.BdInccaSplitDO;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.inc.s.bp.inc.incsplit.data.IncSplitMaskDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;

/**
 * 发票分票数据封装模型转换工具类
 * @author ly 2018/08/21
 *
 */
public class IncSplitMaskConvertUtil {

	/**
	 * 由门诊记账明细转换为分票数据封装模型
	 * @param itmList 门诊记账明细
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<IncSplitMaskDTO> covertOepCgToMask(BdInccaSplitDO splitSet, List<BlCgItmOepDO> itmList) throws BizException{
		
		List<IncSplitMaskDTO> maskList = new ArrayList<IncSplitMaskDTO>();
		
		if(isOrderAsOneWhenDetailShow(splitSet)){
			//明细模式医嘱按照一条显示
			List<String> orList = new ArrayList<String>();
			for (BlCgItmOepDO cgItm : itmList) {
				if(!StringUtil.isEmpty(cgItm.getId_or()) && !orList.contains(cgItm.getId_or())){
					orList.add(cgItm.getId_or());
				}
			}
			
			List<String> asoneOrList = judgeAsOneOrder(orList, splitSet.getSd_disp_ci_srvtp());
			Map<String,IncSplitMaskDTO> orMaskMap = new HashMap<String,IncSplitMaskDTO>();//key:医嘱id
			
			for (BlCgItmOepDO cgItm : itmList) {
				
				if(asoneOrList.contains(cgItm.getId_or())){
					if(orMaskMap.containsKey(cgItm.getId_or())){
						IncSplitMaskDTO maskDto = orMaskMap.get(cgItm.getId_or());
						maskDto.getCgData().add(cgItm);
					}else{
						IncSplitMaskDTO maskDto = createMaskByOepCgItm(cgItm);
						
						maskList.add(maskDto);
						orMaskMap.put(cgItm.getId_or(), maskDto);
					}
				}else{
					IncSplitMaskDTO maskDto = createMaskByOepCgItm(cgItm);
					maskList.add(maskDto);
				}
			}
		}else if(isIncitmWhenDetailShow(splitSet)){
			//明细模式账单按照一条显示
			List<String> inccaItmList = new ArrayList<String>();
			inccaItmList.addAll(Arrays.asList(splitSet.getSd_disp_incitm().split(",")));
			
			Map<String,IncSplitMaskDTO> orMaskMap = new HashMap<String,IncSplitMaskDTO>();//key:账单项编码
			for (BlCgItmOepDO cgItm : itmList) {
				
				if(inccaItmList.contains(cgItm.getCode_inccaitm())){
					if(orMaskMap.containsKey(cgItm.getCode_inccaitm())){
						IncSplitMaskDTO maskDto = orMaskMap.get(cgItm.getCode_inccaitm());
						maskDto.getCgData().add(cgItm);
					}else{
						IncSplitMaskDTO maskDto = createMaskByOepCgItm(cgItm);
						
						maskList.add(maskDto);
						orMaskMap.put(cgItm.getCode_inccaitm(), maskDto);
					}
				}else{
					IncSplitMaskDTO maskDto = createMaskByOepCgItm(cgItm);
					maskList.add(maskDto);
				}
			}
		}else if(isIncitmAndOrdWhenDetailShow(splitSet)){
			//明细模式账单或医嘱按照一条显示
			List<String> orList = new ArrayList<String>();
			for (BlCgItmOepDO cgItm : itmList) {
				if(!StringUtil.isEmpty(cgItm.getId_or()) && !orList.contains(cgItm.getId_or())){
					orList.add(cgItm.getId_or());
				}
			}
			
			List<String> asoneOrList = judgeAsOneOrder(orList, splitSet.getSd_disp_ci_srvtp());
			List<String> inccaItmList = new ArrayList<String>();
			if(!StringUtil.isEmpty(splitSet.getSd_disp_incitm())){
				inccaItmList.addAll(Arrays.asList(splitSet.getSd_disp_incitm().split(",")));
			}
			
			Map<String,IncSplitMaskDTO> orMaskMap = new HashMap<String,IncSplitMaskDTO>();
			for (BlCgItmOepDO cgItm : itmList) {
				if(asoneOrList.contains(cgItm.getId_or())){
					if(orMaskMap.containsKey(cgItm.getId_or())){
						IncSplitMaskDTO maskDto = orMaskMap.get(cgItm.getId_or());
						maskDto.getCgData().add(cgItm);
					}else{
						IncSplitMaskDTO maskDto = createMaskByOepCgItm(cgItm);
						
						maskList.add(maskDto);
						orMaskMap.put(cgItm.getId_or(), maskDto);
					}
				}else if(inccaItmList.contains(cgItm.getCode_inccaitm())){
					if(orMaskMap.containsKey(cgItm.getCode_inccaitm())){
						IncSplitMaskDTO maskDto = orMaskMap.get(cgItm.getCode_inccaitm());
						maskDto.getCgData().add(cgItm);
					}else{
						IncSplitMaskDTO maskDto = createMaskByOepCgItm(cgItm);
						
						maskList.add(maskDto);
						orMaskMap.put(cgItm.getCode_inccaitm(), maskDto);
					}
				}else{
					IncSplitMaskDTO maskDto = createMaskByOepCgItm(cgItm);
					maskList.add(maskDto);
				}
			}
		}else{
			for (BlCgItmOepDO cgItm : itmList) {
				IncSplitMaskDTO maskDto = createMaskByOepCgItm(cgItm);
				maskList.add(maskDto);
			}
		}
		
		return maskList;
	}

	/**
	 * 由住院记账明细转换为分票数据封装模型
	 * @param itmList 住院记账明细
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<IncSplitMaskDTO> covertIpCgToMask(BdInccaSplitDO splitSet, List<BlCgIpDO> itmList) throws BizException{
		
		List<IncSplitMaskDTO> maskList = new ArrayList<IncSplitMaskDTO>();
		
		if(isOrderAsOneWhenDetailShow(splitSet)){
			//明细模式医嘱按照一条显示
			List<String> orList = new ArrayList<String>();
			for (BlCgIpDO cgItm : itmList) {
				if(!StringUtil.isEmpty(cgItm.getId_or()) && !orList.contains(cgItm.getId_or())){
					orList.add(cgItm.getId_or());
				}
			}
			
			List<String> asoneOrList = judgeAsOneOrder(orList, splitSet.getSd_disp_ci_srvtp());
			Map<String,IncSplitMaskDTO> orMaskMap = new HashMap<String,IncSplitMaskDTO>();//key:医嘱id
			
			for (BlCgIpDO cgItm : itmList) {
				
				if(asoneOrList.contains(cgItm.getId_or())){
					if(orMaskMap.containsKey(cgItm.getId_or())){
						IncSplitMaskDTO maskDto = orMaskMap.get(cgItm.getId_or());
						maskDto.getCgData().add(cgItm);
					}else{
						IncSplitMaskDTO maskDto = createMaskByIpCgItm(cgItm);
						
						maskList.add(maskDto);
						orMaskMap.put(cgItm.getId_or(), maskDto);
					}
				}else{
					IncSplitMaskDTO maskDto = createMaskByIpCgItm(cgItm);
					maskList.add(maskDto);
				}
			}
		}else{
			for (BlCgIpDO cgItm : itmList) {
				IncSplitMaskDTO maskDto = createMaskByIpCgItm(cgItm);
				maskList.add(maskDto);
			}
		}
		
		return maskList;
	}
	
	/**
	 * 由分票结果转换为门诊记账分票结果
	 * @param splitMap
	 * @return
	 * @throws BizException
	 */
	public static Map<String, List<BlCgItmOepDO>> convertToOepCgSplitRlt(Map<String, List<IncSplitMaskDTO>> splitMap) throws BizException{
		
		Map<String, List<BlCgItmOepDO>> cgItmMap = new HashMap<String, List<BlCgItmOepDO>>();
		for (String key : splitMap.keySet()) {
			
			List<IncSplitMaskDTO> maskList = splitMap.get(key);
			List<BlCgItmOepDO> cgItmList = new ArrayList<BlCgItmOepDO>();
			for (IncSplitMaskDTO maskDto : maskList) {
			
				FArrayList cgDataList = maskDto.getCgData();
				for (int i = 0; i < cgDataList.size(); i++) {
					BlCgItmOepDO cgItm = (BlCgItmOepDO)cgDataList.get(i);
					cgItmList.add(cgItm);
				}
			}
			
			cgItmMap.put(key, cgItmList);
		}
		
		return cgItmMap;
	}
	
	/**
	 * 由分票结果转换为住院记账分票结果
	 * @param splitMap
	 * @return
	 * @throws BizException
	 */
	public static Map<String, List<BlCgIpDO>> convertToIpCgSplitRlt(Map<String, List<IncSplitMaskDTO>> splitMap) throws BizException{
		
		Map<String, List<BlCgIpDO>> cgItmMap = new HashMap<String, List<BlCgIpDO>>();
		for (String key : splitMap.keySet()) {
			
			List<IncSplitMaskDTO> maskList = splitMap.get(key);
			List<BlCgIpDO> cgItmList = new ArrayList<BlCgIpDO>();
			for (IncSplitMaskDTO maskDto : maskList) {
			
				FArrayList cgDataList = maskDto.getCgData();
				for (int i = 0; i < cgDataList.size(); i++) {
					BlCgIpDO cgItm = (BlCgIpDO)cgDataList.get(i);
					cgItmList.add(cgItm);
				}
			}
			
			cgItmMap.put(key, cgItmList);
		}
		
		return cgItmMap;
	}
	
	/**
	 * 明细模式下医嘱是否按照一条显示明细模式下医嘱是否按照一条显示
	 * @param splitSet
	 * @return
	 * @throws BizException
	 */
	private static boolean isOrderAsOneWhenDetailShow(BdInccaSplitDO splitSet) throws BizException{
		
		if(StringUtil.isEmpty(splitSet.getSd_disp_ci_srvtp())){
			return false;
		}
		
		if(FBoolean.TRUE.equals(splitSet.getFg_splitbyaccount())){
			return IBdPpCodeTypeConst.SD_DISPTP_DETAILORDER.equals(splitSet.getSd_ac_disptp());
		}else{
			return IBdPpCodeTypeConst.SD_DISPTP_DETAILORDER.equals(splitSet.getSd_disptp());
		}
	}
	
	/**
	 * 明细模式下账单项是否单独显示
	 * @param splitSet
	 * @return
	 * @throws BizException
	 */
	private static boolean isIncitmWhenDetailShow(BdInccaSplitDO splitSet) throws BizException{
		
		if(StringUtil.isEmpty(splitSet.getSd_disp_incitm())){
			return false;
		}
		
		if(FBoolean.TRUE.equals(splitSet.getFg_splitbyaccount())){
			return IBdPpCodeTypeConst.SD_DISPTP_DETAILINCITM.equals(splitSet.getSd_ac_disptp());
		}else{
			return IBdPpCodeTypeConst.SD_DISPTP_DETAILINCITM.equals(splitSet.getSd_disptp());
		}
	}

	/**
	 * 明细模式下账单项和医嘱是否单独显示
	 * @param splitSet
	 * @return
	 * @throws BizException
	 */
	private static boolean isIncitmAndOrdWhenDetailShow(BdInccaSplitDO splitSet) throws BizException{
		
		if(StringUtil.isEmpty(splitSet.getSd_disp_incitm()) && StringUtil.isEmpty(splitSet.getSd_disp_ci_srvtp())){
			return false;
		}
		
		if(FBoolean.TRUE.equals(splitSet.getFg_splitbyaccount())){
			return IBdPpCodeTypeConst.SD_DISPTP_DETAILINCITMORDER.equals(splitSet.getSd_ac_disptp());
		}else{
			return IBdPpCodeTypeConst.SD_DISPTP_DETAILINCITMORDER.equals(splitSet.getSd_disptp());
		}
	}
	
	/**
	 * 由门诊记账数据创建分票数据封装模型
	 * @param cgItm
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private static IncSplitMaskDTO createMaskByOepCgItm(BlCgItmOepDO cgItm) throws BizException{
		
		IncSplitMaskDTO maskDto = new IncSplitMaskDTO();
		maskDto.setId_pk(cgItm.getId_cgitmoep());
		maskDto.setId_ent(cgItm.getId_ent());
		maskDto.setCode_inccaitm(cgItm.getCode_inccaitm());
		maskDto.setCode_account(cgItm.getCode_account());
		maskDto.setId_dep_or(cgItm.getId_dep_or());
		maskDto.setId_dep_mp(cgItm.getId_dep_mp());
		maskDto.setId_emp_or(cgItm.getId_emp_or());
		
		FArrayList cgList = new FArrayList();
		cgList.add(cgItm);
		maskDto.setCgData(cgList);
		
		return maskDto;
	}
	
	/**
	 * 由住院记账数据创建分票数据封装模型
	 * @param cgItm
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private static IncSplitMaskDTO createMaskByIpCgItm(BlCgIpDO cgItm) throws BizException{
		
		IncSplitMaskDTO maskDto = new IncSplitMaskDTO();
		maskDto.setId_pk(cgItm.getId_cgip());
		maskDto.setId_ent(cgItm.getId_or());
		maskDto.setCode_inccaitm(cgItm.getCode_inccaitm());
		maskDto.setCode_account(cgItm.getCode_account());
		maskDto.setId_dep_or(cgItm.getId_dep_or());
		maskDto.setId_dep_mp(cgItm.getId_dep_mp());
		maskDto.setId_emp_or(cgItm.getId_emp_or());
		
		FArrayList cgList = new FArrayList();
		cgList.add(cgItm);
		maskDto.setCgData(cgList);
		
		return maskDto;
	}
	
	/**
	 * 过滤明细模式下需要单独医嘱的医嘱
	 * @param orList
	 * @param ciSrvTp
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private static List<String> judgeAsOneOrder(List<String> orList,String ciSrvTp) throws BizException{
		
		List<String> result = new ArrayList<String>();
		if(ListUtil.isEmpty(orList) || StringUtil.isEmpty(ciSrvTp)){
			return result;
		}
		
		String[] srtTps = ciSrvTp.split(",");
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select id_or ");
		sqlSb.append("from ci_order ");
		sqlSb.append("where " + SqlUtils.getInSqlByIds("id_or", orList.toArray(new String[0])) + " ");
		sqlSb.append("and "+ SqlUtils.getInSqlByIds("sd_srvtp", srtTps));
		
		DAFacade daf = new DAFacade();
		List<Object> filterOrList =  (List<Object>)daf.execQuery(sqlSb.toString(), new ColumnListHandler());
		
		
		if(ListUtil.isEmpty(filterOrList))
			return result;
		
		for (Object orId : filterOrList) {
			result.add(orId.toString());
		}
		
		return result;
	}
}
