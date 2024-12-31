package iih.mi.verify.bp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.incca.d.IncCaItmRelDO;
import iih.bd.utils.ParamUtils;
import iih.mi.biz.dto.verify.d.VerifySrvInputDTO;
import iih.mi.itf.bizgrpitf.constant.BdMhiParamCodeConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 获取医嘱相关
 * @author hanjq  2019年04月09日
 *
 */
public class GetSrvVerifyBP {
	private String douHao = ",";
	private String danYinHao = "'";	
	
	/**
	 * 获取处方明细集合
	 */
	private List<VerifySrvInputDTO> getOepDetailsParamDTOs(FArrayList id_ors) throws DAException{
		DAFacade daf = new DAFacade();
		StringBuffer sb = new StringBuffer("SELECT ");
		sb.append(" nvl(ci.ORDERS,0) Orders, ");//帖数(针对中药的  开了几贴就传几贴 ，其他传默认值0)
		sb.append(" psn.code Doctorcode, ");//医生编码
		sb.append(" '0' Approvalnumber, ");//预留3
		sb.append(" nvl(mm.quan_cur,1) Packno,");//包装数量
		sb.append(" ci.code_or Presno, ");//处方号
		sb.append(" srv.quan_total_medu * srv.pri Amt, ");//金额
		sb.append(" dep.NAME Depname, ");//开方科室
		sb.append(" psn.NAME Doctorname, ");//开方医师
		sb.append(" srv.quan_total_medu * srv.pri Amt_hp, ");//医保报销金额
		sb.append(" freq.code Freq, ");//频次
		sb.append(" srv.id_orsrv Id, ");//id
		sb.append(" ci.dt_entry Presdate, ");//开方日期
		sb.append(" srv.CODE_SRV Hisitemcode, ");//医院内码
		sb.append(" srv.NAME Hisitemname, ");//项目名称
		sb.append(" ci.sd_srvtp Srvtp, ");//项目类别
		sb.append(" srv.quan_total_medu Quan, ");//数量
		sb.append(" srv.pri Price, ");//单价
		sb.append(" ci.sd_srvtp Feetp_code, ");//费用类别Feetp_code
		
		sb.append("CASE WHEN ZC.NAME like '%副教授%' THEN '3'");
		sb.append("WHEN ZC.NAME like '%教授%' THEN '4'");
		sb.append("WHEN ZC.NAME like '%主任%' THEN '2'");
		sb.append("ELSE '1' END Doc_level ,");//医师级别
		
		sb.append(" bm.spec Spec, ");//规格
		sb.append(" srv.quan_medu Doseage,");//每次用量
		sb.append(" ci.days_or Days, ");//用药天数
		
		sb.append(" CASE WHEN SUBSTR (srv.sd_srvtp, 0, 2) = '01' THEN	mmunit.NAME ");//
		sb.append(" ELSE	unit.NAME END Unit, ");// 单位
		sb.append(" '0' Chrflag, ");//计费标记(默认0)
		sb.append(" zc.name Z_physicianap "); //医师行政职务
//		sb.append(" dosage.NAME Dose, ");//剂型 -- 需要对照
//		sb.append(" route.NAME Usage, ");//用法
//		sb.append(" unit.name Dosage_unit, ");//用量单位
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
		sb.append(" LEFT OUTER JOIN bd_udidoc zc on zc.ID_UDIDOC = PSN.id_emptitle ");//
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
		List<VerifySrvInputDTO> Details = (List<VerifySrvInputDTO>) daf.execQuery(sb.toString(),new BeanListHandler(VerifySrvInputDTO.class));
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
	public FArrayList exce(FArrayList id_ors ,String id_ent ,String sdIncca) throws BizException{
		List<VerifySrvInputDTO> Details = getOepDetailsParamDTOs(id_ors);
		String id_hp = "1001Z8100000000032QV";
		if(Details != null && Details.size() > 0){			
			HashSet<String> HisCodes = new HashSet<>();//对照编码集合
			Integer priceDigit = ParamUtils.GetInstanceParamIntegerValue(id_hp,
					BdMhiParamCodeConst.BDMHI2013);//明细上传价格小数位数
			Integer quanDigit = ParamUtils.GetInstanceParamIntegerValue(id_hp,
					BdMhiParamCodeConst.BDMHI2014);//明细上传数量小数位数
			
			for(VerifySrvInputDTO Dto : Details){
				HisCodes.add(Dto.getHisitemcode());
			}			
			HashMap<String, HPSrvorcaDO> HPSrvorcaDOMap = getHPSrvorcaDOMap(HisCodes, id_hp);//目录对照药品
			HashMap<String, String> Feetp_codeMap = getHpFeetp(sdIncca, id_ors);//目录对照药品
			HashMap<String, String> freqMap= getHisToHPFreq();//频次对照
			if(Details.size() > 0){
				FArrayList array = new FArrayList();
				for(VerifySrvInputDTO Dto : Details){	
					String defaultHpitemcode = "9999999999";
					if(Dto.getSrvtp().indexOf("01") == 0){//药品
						defaultHpitemcode = "90V00000";
						Dto.setSrvtp("1");//项目类型
					}else{
						Dto.setSrvtp("0");
					}
					HPSrvorcaDO hpSrvorcaDO = HPSrvorcaDOMap.get(Dto.getHisitemcode());
					
					if(hpSrvorcaDO != null){
						//项目编码
						Dto.setHisitemcode(hpSrvorcaDO.getCode());
						//医保项目名称
						Dto.setHisitemname(hpSrvorcaDO.getName());
						//费用类别
						Dto.setFeetp_code(hpSrvorcaDO.getCode_ca());						
					}else{
						Dto.setHisitemcode(defaultHpitemcode);
						//费用类别
						Dto.setFeetp_code(Feetp_codeMap.get(Dto.getHisitemcode()));
					}
					
					//单价
					Dto.setPrice(Dto.getPrice().setScale(priceDigit, FDouble.ROUND_HALF_UP));
					//数量
					if(Dto.getQuan() != null){
						Dto.setQuan(Dto.getQuan().setScale(quanDigit, FDouble.ROUND_HALF_UP));
					}else{
						Dto.setQuan(Dto.getDoseage().setScale(quanDigit, FDouble.ROUND_HALF_UP));
						Dto.setDays(new FDouble(1));
					}					
					//金额
					Dto.setAmt(Dto.getPrice().multiply(Dto.getQuan()).setScale(2, FDouble.ROUND_HALF_UP));
					Dto.setAmt_hp(Dto.getAmt());
					//频次
					String freq = freqMap.get(Dto.getFreq());
					if(StringUtils.isBlank(freq)){
						Dto.setFreq("-1");
					}else{
						Dto.setFreq(freq);
					}
					//规格
					if(StringUtils.isBlank(Dto.getSpec()))
						Dto.setSpec(Dto.getUnit());
					array.add(Dto);
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
		sb.append(" HPSRVCA.NAME,");//医保名称
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
	
	private HashMap<String, String> getHisToHPFreq(){
		HashMap<String, String> freqMap = new HashMap<>();
		freqMap.put("ALWAYS", "52");//ALWAYS	持续	持续	52	24小时维持		
		freqMap.put("ONCE", "61");//ONCE	一次	一次	61	立即(st) 
		freqMap.put("Q1H", "31");//	Q1H	Q1H一次/h		31	每小时一次(qh) 
		freqMap.put("q6h", "35");//		q6h	每6小时1次		35	每6小时一次(q6h)
		freqMap.put("Q4H", "33");//		Q4H	Q4H(9-1-5-9-1-5)	1次/4小时	33	每4小时一次(q4h)
		freqMap.put("QW", "21");//		QW	1/周	1次/周	21	每周一次(qw)
		freqMap.put("ST", "61");//		ST	即刻	即刻	61	立即(st) 
		freqMap.put("W2D5", "22");//		W2D5	每周两次	周三.六	22	每周二次(biw)
		freqMap.put("Q5H", "34");//		Q5H	间隔5小时		34	每5小时一次(q5h)
		freqMap.put("W3D3", "23");//		W3D3	每周三次	W3D3周一.二.五 (8am)	23	每周三次(tiw) 
		freqMap.put("4ID", "14");//		4ID	4ID(8-12-4-8)	4次/日	14	每天四次(qid)  
		freqMap.put("5ID", "15");//		5ID	5ID日(7-11-3-7-11)	5次/日	15	每天五次(Quingid)
		freqMap.put("7ID", "18");//		7ID	7ID(6-10-1-3-5-7-9)	7次/日	18	每天七次(7times/d)
		freqMap.put("HAC", "13");//		HAC	三餐前	三餐前	13	每天三次(tid) 
		freqMap.put("Q12H", "37");//		Q12H	Q12H (8-8)	1次/12小时	37	每12小时一次(q12h)
		freqMap.put("Q8H", "36");//		Q8H	Q8H	1次/8小时	36	每8小时一次(q8h)   
		freqMap.put("QD", "11");//		QD	QD	1次/日	11	每天一次(qd)   
		freqMap.put("QD(10am)", "11");//		QD(10am)	QD(10am)	QD(10am)	11	每天一次(qd) 
		freqMap.put("QN", "41");//		QN	QN每晚 (8pm)	1次/晚	41	每晚一次(qn)
		freqMap.put("QOD", "42");//		QOD	QOD(8am)	1次/隔日	42	隔天一次(qod)  
		freqMap.put("BID", "12");//		BID	BID	2次/日	12	每天二次(bid)   
		freqMap.put("QID1", "14");//		QID1	4/日1	4次/日	14	每天四次(qid)
		freqMap.put("TID", "13");//		TID	TID	3次/日	13	每天三次(tid)
		freqMap.put("SOS", "63");//		SOS	备用		63	必要时用(s.o.s)		
		freqMap.put("ALWAYS", "-1");//		112	睡前	
		freqMap.put("prn", "62");//		prn	需要时（长期）	长期备用	62	必要时使用(prn)
		freqMap.put("sos", "63");//		sos	需要时（限用1次，12小时内有效）	临时备用	63	必要时用(s.o.s)   
		freqMap.put("Q2H", "32");//		Q2H	Q2H一次/2h		32	每2小时一次(q2h)	
		freqMap.put("MTSC", "-1");//		MTSC	每天10次		
		freqMap.put("Q2/1H", "30");//		Q2/1H	每小时2次	30	每半小时一次(q1/2h)   
		freqMap.put("Q3/1H", "-1");//		Q3/1H	每小时3次	
		freqMap.put("q8h", "36");//		q8h	每8小时1次		36	每8小时一次(q8h) 
		freqMap.put("Q3H", "38");//		Q3H	Q3H		38	每3小时一次(q3h) 
		freqMap.put("q6h1", "35");//		q6h1	q6h		35	每6小时一次(q6h)    
		freqMap.put("q6h2", "35");//		q6h2	q6h(9-15-21-3)		35	每6小时一次(q6h)
		freqMap.put("8ID", "-1");//		8ID	每天8次				
		freqMap.put("PC", "-1");//		PC	饭后			
		freqMap.put("QM", "-1");//		QM	每天早上1次				
		freqMap.put("AC", "-1");//		AC	饭前	
		freqMap.put("Q12H3", "37");//		Q12H3	Q12H(9-9)	1次/12小时	37	每12小时一次(q12h)
		freqMap.put("Q8H2", "36"); //		Q8H2	Q8H(9-17-1)	1次/8小时	36	每8小时一次(q8h)
		freqMap.put("TID2", "13"); //		TID2	TID(11-13-17)	3次/日	13	每天三次(tid)   
		freqMap.put("QD2", "11");//		QD2	QD(11am)	1次/日	11	每天一次(qd)         
		freqMap.put("QID", "14");//		QID	QID	4次/日	14	每天四次(qid)
		freqMap.put("6ID", "17");//		6ID	每天6次		17	每天六次(6times/d)
		freqMap.put("BID3", "12");//		BID3	BID(11-17)	2次/日	12	每天二次(bid)
		return freqMap;
	}
}
