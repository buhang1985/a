package iih.mi.verify.bp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.incca.d.IncCaItmRelDO;
import iih.bd.utils.ParamUtils;
import iih.mi.biz.dto.d.OepDetailsParamDTO;
import iih.mi.itf.bizgrpitf.constant.BdMhiParamCodeConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 获取医嘱相关
 * @author hanjq  2019年04月01日
 *
 */
public class GetSrvDetailsBP {
	private String douHao = ",";
	private String danYinHao = "'";	
	
	/**
	 * 获取处方明细集合
	 */
	private List<OepDetailsParamDTO> getOepDetailsParamDTOs(FArrayList id_ors) throws DAException{
		DAFacade daf = new DAFacade();
		StringBuffer sb = new StringBuffer("SELECT ");
		sb.append(" ci.code_or Presno, ");//处方号
		sb.append(" srv.SORTNO Billitemno, ");//处方内序号
		sb.append(" srv.CODE_SRV Hisitemcode, ");//医院内码
		sb.append(" srv.NAME Hpitemname, ");//项目名称
		sb.append(" srv.NAME Hisitemname, ");//项目名称
		sb.append(" ci.sd_srvtp Srvtp, ");//项目类别
		sb.append(" ci.sd_srvtp Feetp_code, ");//费用类别Feetp_code
		sb.append(" srv.pri Price, ");//单价
		sb.append(" srv.quan_total_medu Quan, ");//数量
		sb.append(" srv.quan_total_medu * srv.pri Amt, ");//金额
		sb.append(" CASE WHEN SUBSTR (srv.sd_srvtp, 0, 2) = '01' THEN	mmunit.NAME ");//
		sb.append(" ELSE	unit.NAME END Unit, ");// 单位
		sb.append(" bm.spec Spec, ");//规格
		sb.append(" dosage.NAME Dose, ");//剂型 -- 需要对照
		sb.append(" ci.dt_entry Presdate, ");//开方日期
		sb.append(" dep.NAME Depname, ");//开方科室
		sb.append(" psn.NAME Doctorname, ");//开方医师
		sb.append(" '0' Fg_sigle, ");//复方标识 1-复方 0-单方 默认填 0
		sb.append(" psn.code Doctorcode, ");//医生编码
		sb.append(" srv.quan_medu Doseage,");//每次用量
		sb.append(" freq.NAME Freq, ");//频次
		sb.append(" route.NAME Usage, ");//用法
		sb.append(" ci.days_or Days, ");//用药天数
		sb.append(" unit.name Dosage_unit, ");//用量单位
		sb.append(" srv.ID_ORSRV Hpregno ");//处方明细 ID
		sb.append(" FROM ci_or_srv srv ");//
		sb.append(" LEFT OUTER JOIN ci_or_srv_mm mm ON srv.id_orsrv = mm.id_orsrv ");//
		sb.append(" LEFT OUTER JOIN ci_order ci ON srv.id_or = ci.id_or ");//
		sb.append(" LEFT OUTER JOIN bd_measdoc unit ON unit.id_measdoc = srv.id_medu ");//
		sb.append(" LEFT OUTER JOIN bd_measdoc mmunit ON mmunit.id_measdoc = mm.id_pgku_cur ");//
		sb.append(" LEFT OUTER JOIN bd_mm bm ON bm.id_mm = mm.id_mm ");//
		sb.append(" LEFT OUTER JOIN bd_srv_drug drug ON drug.id_srv = srv.id_srv ");//
		sb.append(" LEFT OUTER JOIN bd_udidoc dosage ON dosage.id_udidoc = drug.id_dosage ");//
		sb.append(" LEFT OUTER JOIN bd_psndoc psn ON psn.id_psndoc = ci.id_emp_or ");//
		sb.append(" LEFT OUTER JOIN bd_dep dep ON dep.id_dep = ci.id_dep_or ");//
		sb.append(" LEFT OUTER JOIN bd_srv bdsrv ON bdsrv.id_srv = srv.id_srv ");//
		sb.append(" LEFT OUTER JOIN bd_freq freq ON freq.id_freq = ci.id_freq ");//
		sb.append(" LEFT OUTER JOIN bd_route route ON route.id_route = ci.id_route ");//
		sb.append(" WHERE	ci.id_or IN ( ");//
		boolean hasDouHao = false;
		for(Object obj : id_ors){
			if(hasDouHao)
				sb.append(douHao);
			hasDouHao = true;
			sb.append(danYinHao).append(obj).append(danYinHao);
		}
		sb.append(") ");
		sb.append(" ORDER BY ci.code_or , srv.SORTNO ");
		List<OepDetailsParamDTO> Details = (List<OepDetailsParamDTO>) daf.execQuery(sb.toString(),new BeanListHandler(OepDetailsParamDTO.class));
		return Details;	
	}
	
	
	/**
	 * 获取处方数组
	 * @param id_ors
	 * @param id_hp
	 * @return
	 * @author hanjq 2019年4月3日
	 * @throws BizException 
	 */
	public FArrayList exce(FArrayList id_ors ,String id_hp ,String sdIncca) throws BizException{
		List<OepDetailsParamDTO> Details = getOepDetailsParamDTOs(id_ors);
		if(Details != null && Details.size() > 0){			
			HashSet<String> HisCodes = new HashSet<>();//对照编码集合
			HashMap<String, FBoolean> PresnoMap = new HashMap<>();//处方号-设置复方使用
			
			Integer priceDigit = ParamUtils.GetInstanceParamIntegerValue(id_hp,
					BdMhiParamCodeConst.BDMHI2013);//明细上传价格小数位数
			Integer quanDigit = ParamUtils.GetInstanceParamIntegerValue(id_hp,
					BdMhiParamCodeConst.BDMHI2014);//明细上传数量小数位数
			
			for(OepDetailsParamDTO Dto : Details){
				HisCodes.add(Dto.getHisitemcode());
				if(PresnoMap.containsKey(Dto.getPresno())){
					PresnoMap.put(Dto.getPresno(), FBoolean.TRUE);
				}else{
					PresnoMap.put(Dto.getPresno(), FBoolean.FALSE);
				}
			}			
			HashMap<String, HPSrvorcaDO> HPSrvorcaDOMap = getHPSrvorcaDOMap(HisCodes, id_hp);//目录对照药品
			
			//费用类别对照
			HashMap<String, String> FeetpMap = getHpFeetp(sdIncca,id_ors);
			
			String fuFang = "1";//1-复方 0-单方
			if(HPSrvorcaDOMap.size() > 0){
				FArrayList array = new FArrayList();
				for(OepDetailsParamDTO Dto : Details){	
					String defaultHpitemcode = "9999999999";
					if(Dto.getSrvtp().indexOf("01") == 0){//药品
						defaultHpitemcode = "90V00000";
					}
					HPSrvorcaDO hpSrvorcaDO = HPSrvorcaDOMap.get(Dto.getHisitemcode());
					
					if(hpSrvorcaDO != null){
						//医保编码
						Dto.setHpitemcode(hpSrvorcaDO.getCode());
						//医保项目名称
						Dto.setHpitemname(hpSrvorcaDO.getName());
						//费用类别
						Dto.setFeetp_code(hpSrvorcaDO.getCode_ca());
						//剂型
						if(!StringUtils.isNotBlank(hpSrvorcaDO.getCode_dosage()))
							Dto.setDose(hpSrvorcaDO.getCode_dosage());
						
					}else{
						//医保编码
						Dto.setHpitemcode(defaultHpitemcode);
						//费用类别
						Dto.setFeetp_code(FeetpMap.get(Dto.getHisitemcode()));
					}
					
					//单价
					Dto.setPrice(Dto.getPrice().setScale(priceDigit, FDouble.ROUND_HALF_UP));
					//数量
					Dto.setQuan(Dto.getQuan().setScale(quanDigit, FDouble.ROUND_HALF_UP));
					//金额
					Dto.setAmt(Dto.getPrice().multiply(Dto.getQuan()).setScale(2, FDouble.ROUND_HALF_UP));
					//复方标识
					if(PresnoMap.get(Dto.getPresno()).booleanValue())
						Dto.setFg_sigle(fuFang);
					//规格
					if(StringUtils.isBlank(Dto.getSpec()))
						Dto.setSpec(Dto.getUnit());
					array.add(Dto);
//					return array;
				}
				
				return array;
			}
		}
		return null;		
	}
	
	/**
	 * 获取已审核和已上传,已对照的对照目录
	 * @param HisCodes
	 * @param id_hp
	 * @return
	 * @throws DAException
	 * @author hanjq 2019年4月3日
	 */
	private HashMap<String, HPSrvorcaDO> getHPSrvorcaDOMap(HashSet<String> HisCodes ,String id_hp) throws DAException{
		HashMap<String, HPSrvorcaDO> HPSrvorcaDOMap = new HashMap<>();//目录对照药品
		DAFacade daf = new DAFacade();
		StringBuffer sb = new StringBuffer("SELECT ");
		sb.append(" DECODE (HPSRVCA.ID_MM,'~',SRV.CODE,MM.CODE) AS HIS_CODE, ");//HIS编码
		sb.append(" HPSRVCA.CODE, ");//医保编码
		sb.append(" HPSRVCA.CODE_CA, ");//收费类别编码
		sb.append(" HPSRVCA.CODE_DOSAGE ");//医保剂型编码
		sb.append(" FROM BD_HP_SRVORCA HPSRVCA ");//
		sb.append(" LEFT JOIN BD_SRV SRV ON SRV.ID_SRV = HPSRVCA.ID_SRV ");//
		sb.append(" LEFT JOIN BD_MM MM ON MM.ID_MM = HPSRVCA.ID_MM ");//
		sb.append(" WHERE HPSRVCA.ID_HP  = ");//
		sb.append(danYinHao).append(id_hp).append(danYinHao);
		sb.append(" AND DECODE (HPSRVCA.ID_MM,'~',SRV.CODE,MM.CODE) IN ( ");//
		boolean hasDouHao = false;
		for(String code : HisCodes){
			if(hasDouHao)
				sb.append(douHao);
			hasDouHao = true;
			sb.append(danYinHao).append(code).append(danYinHao);
		}
		sb.append(") AND HPSRVCA.eu_status in (2,3,4)");
		List<HPSrvorcaDO> HPSrvorcaDOs = (List<HPSrvorcaDO>) daf.execQuery(sb.toString(),new BeanListHandler(HPSrvorcaDO.class));
		if(HPSrvorcaDOs != null && HPSrvorcaDOs.size() > 0){
			for(HPSrvorcaDO hpSrv:HPSrvorcaDOs){
				HPSrvorcaDOMap.put(hpSrv.getHis_code(), hpSrv);
			}
		}		
		return HPSrvorcaDOMap;		
	}
	
	/**
	 * 获取医保费用类别(如果没有医保对照则使用这个)
	 * @param sdIncca 11:门诊，12:住院
	 * @return HashMap<key,val> key:账单码，val:医保费用类别
	 * @author hanjq 2019年4月3日
	 * @throws DAException 
	 */
	private HashMap<String, String> getHpFeetp(String sdIncca ,FArrayList id_ors) throws DAException{
		HashMap<String, String> oepMap = new HashMap<>();//门诊
		/** 医保费用类别
		 * 11  西药费 
			12  中成药费 
			13  中草药费 
			14  血液制品费
			21  检查费 
			22  特殊检查费
			23  输氧费 
			24  手术费 
			25  化验费 
			26  输血费 
			27  诊疗费 
			28  放射费 
			29  麻醉费 
			31  治疗费 
			32  特殊治疗费
			33  护理费 
			34  床位费
			71  进口特殊材料 
			72  进口人工器官 
			81  国产特殊材料 
			82  国产人工器官 
			91  其他费用 
			92  挂号费 
			93  普通材料费
		 */
		oepMap.put("mz001", "12");//mz001	中药饮片  12  中成药费  
		oepMap.put("mz002", "11");//mz002	西药费 11  西药费 
		oepMap.put("mz003", "12");//mz003	中成药费   12  中成药费
		oepMap.put("mz004", "24");//mz004	手术费 24  手术费 
		oepMap.put("mz005", "29");//mz005	麻醉费 29  麻醉费 
		oepMap.put("mz007", "34");//mz007	床位费 34  床位费
		oepMap.put("mz008", "31");//mz008	治疗费 31  治疗费
		oepMap.put("mz009", "93");//mz009	材料费 93  普通材料费
		oepMap.put("mz011", "25");//mz011	化验费 25  化验费 
		oepMap.put("mz012", "21");//mz012	检查费  21  检查费
		oepMap.put("mz013", "25");//mz013	检验费 25  化验费  
		oepMap.put("mz014", "23");//mz014	输氧费 23  输氧费
		oepMap.put("mz015", "34");//mz015	床椅费 34  床位费
		oepMap.put("mz016", "91");//mz016	诊查费 91  其他费用
		oepMap.put("mz017", "92");//mz017	挂号费 92  挂号费
		oepMap.put("mz018", "21");//mz018	放射检查费 21  检查费
		oepMap.put("mz019", "28");//mz019	放射治疗费 28  放射费
		oepMap.put("mz020", "33");//mz020	护理费   33  护理费 
		oepMap.put("mz021", "93");//mz021	检查材料 93  普通材料费 
		oepMap.put("mz023", "14");//mz023	血液制品  14  血液制品费
		oepMap.put("mz024", "93");//mz024	治疗材料 93  普通材料费 
		oepMap.put("mz025", "91");//mz025	注射费 91  其他费用 
		oepMap.put("mz026", "91");//mz026	其他费  91  其他费用
		
		HashMap<String, String> map = new HashMap<>();//住院
		 map.put("zy001", "12");//zy001	中药饮片费 12  中成药费 
		 map.put("zy002", "11");//zy002	西药费 11  西药费 
		 map.put("zy003", "12");//zy003	中成药  12  中成药费 
		 map.put("zy004", "24");//zy004	手术费  24  手术费
		 map.put("zy005", "29");//zy005	麻醉费 29  麻醉费 
		 map.put("zy006", "34");//zy006	床位费 34  床位费
		 map.put("zy007", "31");//zy007	治疗费 31  治疗费
		 map.put("zy008", "93");//zy008	材料费 93  普通材料费
		 map.put("zy009", "21");//zy009	检查费 21  检查费 
		 map.put("zy010", "21");//zy010	检验费 21  检查费
		 map.put("zy011", "23");//zy011	输氧费  23  输氧费
		 map.put("zy012", "91");//zy012	注射费 91  其他费用 
		 map.put("zy015", "33");//zy015	护理费    33  护理费
		 map.put("zy016", "21");//zy016	放射检查费 21  检查费 
		 map.put("zy017", "21");//zy017	诊查费 21  检查费
		 map.put("zy018", "28");//zy018	放射治疗费 28  放射费 
		 map.put("zy019", "93");//zy019	检查材料 93  普通材料费 
		 map.put("zy021", "14");//zy021	血液制品   14  血液制品费
		 map.put("zy022", "93");//zy022	治疗材料 93  普通材料费 
		 map.put("zy024", "91");//zy024	其他费用   91  其他费用
		 
		HashMap<String, String> HPSrvorcaDOMap = new HashMap<>();//费用类别对照药品
		DAFacade daf = new DAFacade();
		StringBuffer sb = new StringBuffer("SELECT DISTINCT ");
		sb.append(" orsrv.code_srv id_srv, ");//code_srv
		sb.append(" caitm.code inccaitm_code ");//账单码
		sb.append(" FROM bd_incca_itm_rel itmrel ");//
		sb.append(" inner join bd_incca_itm caitm on itmrel.id_inccaitm = caitm.id_inccaitm ");//
		sb.append(" INNER JOIN CI_OR_SRV orsrv ON orsrv.id_srv = itmrel.id_srv ");//
		sb.append(" WHERE itmrel.SD_INCCA = ");//
		sb.append(danYinHao).append(sdIncca).append(danYinHao);
		sb.append(" AND orsrv.id_or IN ( ");//
		boolean hasDouHao = false;
		for(Object id_or : id_ors){
			if(hasDouHao)
				sb.append(douHao);
			hasDouHao = true;
			sb.append(danYinHao).append(id_or).append(danYinHao);
		}
		sb.append(")");
		List<IncCaItmRelDO> IncCaItmRelDOs = (List<IncCaItmRelDO>) daf.execQuery(sb.toString(),new BeanListHandler(IncCaItmRelDO.class));
		if(IncCaItmRelDOs != null && IncCaItmRelDOs.size() > 0){
			for(IncCaItmRelDO itm:IncCaItmRelDOs){
				if("11".equals(sdIncca)){
					HPSrvorcaDOMap.put(itm.getId_srv(), oepMap.get(itm.getInccaitm_code()));
				}else{
					HPSrvorcaDOMap.put(itm.getId_srv(), map.get(itm.getInccaitm_code()));
				}
					
			}
		}
		return HPSrvorcaDOMap;
		
	}
	
}
