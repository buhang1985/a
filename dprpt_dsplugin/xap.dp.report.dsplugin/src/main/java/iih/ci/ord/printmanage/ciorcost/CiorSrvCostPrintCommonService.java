package iih.ci.ord.printmanage.ciorcost;

import iih.ci.ord.printmanage.common.CiOrderPrintDiagService;
import iih.ci.ord.printmanage.dto.UtilsDTO;
import iih.ci.ord.printmanage.srv.CiorderPrintUtils;
import iih.ci.ord.printmanage.srv.ICiorderPrintConst;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import xap.dp.report.data.reader.sqlqryutil.RptQryUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * 费用清单合单打印数据查询服务
 * @author Young
 *
 */
public class CiorSrvCostPrintCommonService {

	protected String Bl_State = ICiorderPrintConst.BLSTATE_UNPAID;
	/**
	 * 获得患者就诊信息/医嘱服务费用项目信息
	 * @param id_ors
	 * @return
	 * @throws Exception
	 */
	public List<PatEntPrnDTO> exec(String id_ors) throws Exception{
		if(StringUtils.isNullOrEmpty(id_ors))return null;
		//获取医嘱服务ID集合
		String strIdorsrvs=getIDorsrvs(id_ors);
		if(StringUtils.isNullOrEmpty(strIdorsrvs))return null;
		//获取打印数据ID集合
		String strIdciprns=getIDciprns(strIdorsrvs);
		if(StringUtils.isNullOrEmpty(strIdciprns))return null;
		//患者就诊信息查询
		List<PatEntPrnDTO> patEntPrnDTOs=this.getPatEntPrnList(this.getPatEntPrnInfoQry(strIdciprns));
		//减项服务类型
		String strSdSrvtp = getSubSdSrvtp();
		//服务费用信息查询
		List<CiorSrvCostDTO> ciorSrvCostDTOs=this.getCiorSrvCostList(this.getCiorSrvCostInfoQry(strIdciprns,strSdSrvtp));
		
		Map<String,List<CiorSrvCostDTO>> maps=new HashMap<String,List<CiorSrvCostDTO>>();
		for(CiorSrvCostDTO dto:ciorSrvCostDTOs){
			if(maps.containsKey(dto.getId_ciprn())){
				maps.get(dto.getId_ciprn()).add(dto);
			}
			else{
				List<CiorSrvCostDTO> lst=new ArrayList<CiorSrvCostDTO>();
				lst.add(dto);
				maps.put(dto.getId_ciprn(), lst);
			}
		}
		if (patEntPrnDTOs == null || patEntPrnDTOs.size() == 0)
			return null;
		List<PatEntPrnDTO> rst = new ArrayList<PatEntPrnDTO>();
		CiOrderPrintDiagService diag = new CiOrderPrintDiagService();
		for (int i = 0; i < patEntPrnDTOs.size(); i++) {
			List<CiorSrvCostDTO> lst = maps.get(patEntPrnDTOs.get(i).getId_ciprn());
			if (lst == null || lst.size() <= 0) {
				continue;
			}
			patEntPrnDTOs.get(i).setStr_name_di(diag.exec(patEntPrnDTOs.get(i).getId_en()));
			patEntPrnDTOs.get(i).setCiorSrvCostList(lst);
			FDouble amt = new FDouble("0.00");
			for (CiorSrvCostDTO dto : lst) {
				amt = amt.add(dto.getTotalPrice());
			}
			amt = amt.setScale(-2, BigDecimal.ROUND_HALF_UP);
			patEntPrnDTOs.get(i).setTotalPrice(amt);
			patEntPrnDTOs.get(i).setDt_entry((new FDateTime()).toString());
			//设置年龄（格式）
			if (patEntPrnDTOs.get(i).getDt_birth() != null) {
				Date birth = new Date();
				birth = CiorderPrintUtils.ConvertStrToDate(patEntPrnDTOs.get(i).getDt_birth());
				FDate dt = new FDate(birth);
				patEntPrnDTOs.get(i).setAge(AgeCalcUtil.getAge(dt));
			}
			rst.add(patEntPrnDTOs.get(i));
		}
		
		return rst;
	}
	
	public List<PatEntPrnDTO> exec(String ids, String blstatetp) throws Exception{
		if (StringUtils.isNullOrEmpty(ids))
			return null;
		this.Bl_State = blstatetp;
		return this.exec(ids);
	}
	
	/**
	 * 获取医嘱服务ID集合
	 * @param id_ors
	 * @return
	 * @throws Exception 
	 */
	private String getIDorsrvs(String id_ors) throws Exception{
		String sql="SELECT id_orsrv as def1 FROM ci_or_srv WHERE id_or in("+id_ors+")";
		List<UtilsDTO> result = CiorderPrintUtils.GetQueryResulte(UtilsDTO.class,sql);
		String strIdorsrvs="";
		if(result!=null&&result.size()>0){
			for(UtilsDTO dto:result){
				strIdorsrvs+="'"+dto.getDef1()+"',";
			}
		}

		return strIdorsrvs.length()>0?strIdorsrvs.substring(0, strIdorsrvs.length()-1):strIdorsrvs;
	}
	//获取减项的服务类型Id
	private String getSubSdSrvtp() throws Exception {
		String sql = "select Sd_srvtp as def1 from bd_ems_prntmpl_rel where ID_EMSPRNTMPL='0001Z8100000000MLQA5' and EU_DIRECT <> 1";
		List<UtilsDTO> result = CiorderPrintUtils.GetQueryResulte(UtilsDTO.class,sql);
		String strSd_srvtps="";
		if(result!=null&&result.size()>0){
			for(UtilsDTO dto:result){
				strSd_srvtps+="and SRV.sd_srvtp not like'"+dto.getDef1()+"%',";
			}
		}
	
		return strSd_srvtps.length()>0?strSd_srvtps.substring(0, strSd_srvtps.length()-1):strSd_srvtps;
	}
	/**
	 * 获取打印数据ID集合
	 * @param strIdorsrvs
	 * @return
	 * @throws Exception
	 */
	private String getIDciprns(String strIdorsrvs) throws Exception{
		String sql="select distinct id_ciprn as def1 from ci_prn_item where Id_biz in ("+strIdorsrvs+")";
		List<UtilsDTO> result = CiorderPrintUtils.GetQueryResulte(UtilsDTO.class,sql);
		String strIdciprns="";
		if(result!=null&&result.size()>0){
			for(UtilsDTO dto:result){
				strIdciprns+="'"+dto.getDef1()+"',";
			}
		}

		return strIdciprns.length()>0?strIdciprns.substring(0, strIdciprns.length()-1):strIdciprns;
	}
	
	/**
	 * 获得查询患者就诊sql
	 * @param strIdciprns 打印ID
	 * @return
	 * @throws Exception
	 */
	private String getPatEntPrnInfoQry(String strIdciprns){
		StringBuilder str=new StringBuilder();
		str.append("select distinct PRN.Id_ciprn,");
		str.append("PRN.Id_pat as Id_pati,");
		str.append("PAT.Code as Code_pati,");
		str.append("PAT.Name as Name_pati,");
		str.append("PAT.code as Barcode,");
		str.append("PAT.Dt_birth,");
		str.append("PAT.Workunit,");
		str.append("SEX.Name as Gender,");
		str.append("GRP.Name as Name_grp,");
		str.append("ORG.Name as Name_org,");
		str.append("ORG.ENName as Name_org_en,");

		str.append("ENT_OP.Id_ent as Id_en,");
		str.append("PRN.Id_entp,");
		str.append("PRN.Code_entp,");
		str.append("PRN.Str_name_di,");
		str.append("ENT_OP.Times_op as Num_pv,");
		str.append("PRN.Fg_vip,");
		str.append("PRN.Fg_prepay,");
		str.append("PRN.Fg_hecominsur,");
		str.append("PRN.Hecominsurinfo,");
		str.append("PRN.Fg_hp as Fg_orhp,");
		str.append("PRN.Fg_blsettled,");
		str.append("PRN.Fg_specill,");
		str.append("PRN.Researchinfo as Name_research,");
		
		str.append("PRN.Code_prn as Code,");
		str.append("ORD.Id_dep_or,");// 申请科室
		str.append("DEP_OR.Name as Name_dep_or,");
		str.append("EMP_OR.Name as Name_emp_or,");// 申请医生
		str.append("'' as Dt_entry,");// 申请日期
		str.append("ORD.Id_dep_sign,");//签署科室
		str.append("DEP_SIGN.Name as Name_dep_sign,");
		str.append("ORD.Id_emp_sign,");//签署医生
		str.append("EMP_SIGN.Name as Name_emp_sign,");
	//	str.append("DEP_OR.Id_Plc as address,");   0170500: 需求：费用清单的DTO里面sql语句字段取值不正确  暂时注释
		str.append("DEP.Id_Plc as address,");//执行科室地点
		str.append("DEP.name as name_executive,");

		str.append("PRN.Dt_prn,");
		str.append("0.0 as TotalPrice ");
		
		str.append("from ci_prn PRN ");
		str.append("left join pi_pat PAT on PAT.Id_pat = PRN.Id_pat ");
		str.append("left outer join bd_udidoc SEX on SEX.Id_udidoc = PAT.Id_sex ");
		str.append("left join bd_grp GRP on GRP.Id_grp = PRN.Id_grp ");
		str.append("left join bd_org ORG on ORG.Id_org = PRN.Id_org ");
		str.append("left join en_ent_op ENT_OP on ENT_OP.Id_ent = PRN.Id_en ");
		str.append("left join ci_prn_item PRNITM on PRNITM.Id_ciprn = PRN.Id_ciprn ");
		str.append("left join ci_or_srv SRV on SRV.Id_orsrv = PRNITM.Id_biz ");
		str.append("left join ci_order ORD on ORD.Id_or = SRV.Id_or ");
		str.append("left join bd_dep DEP_OR on DEP_OR.Id_dep = ORD.Id_dep_or ");
		str.append("left join bd_dep DEP on DEP.id_dep= ORD.id_dep_mp ");
		str.append("left join bd_psndoc EMP_OR on EMP_OR.Id_psndoc = ORD.Id_emp_or ");
		str.append("left join bd_dep DEP_SIGN on DEP_SIGN.Id_dep = ORD.Id_dep_sign ");
		str.append("left join bd_psndoc EMP_SIGN on EMP_SIGN.Id_psndoc = ORD.Id_emp_sign ");
		
		str.append(" where PRN.Id_ciprn in ("+strIdciprns+") "+CiorderPrintUtils.GetBlStatetpStr(this.Bl_State,"PRN"));
		str.append(" order by PRN.Dt_prn");
		
		return str.toString();
	}
	
	/**
	 * 获得查询服务费用sql
	 * @param strIdciprns 打印ID
	 * @return
	 */
	private String getCiorSrvCostInfoQry(String strIdciprns,String strSdSrvtp){
		StringBuilder str=new StringBuilder();
		str.append("select PRNITM.Id_ciprn,");
		str.append("PRNITM.Id_ciprnitm,");
		str.append("PRNITM.Id_biz as Id_srv,");
		str.append("SRV.Name as Name_srv,");
		str.append("(case when SRV.Fg_bl = 'Y' and SRV.Fg_mm = 'N' then SRV.Pri ");
		str.append("when SRV.Fg_bl = 'Y' and SRV.Fg_mm = 'Y' then SRV_MM.Price_Pgku_Cur else 0.0 end) as Price,");
        str.append("(case when SRV.Fg_bl = 'Y' and SRV.Fg_mm = 'N' then SRV.Quan_total_medu ");
        str.append("when SRV.Fg_bl = 'Y' and SRV.Fg_mm = 'Y' then SRV_MM.Quan_Cur else 0.0 end) as Amount,");
        str.append("(case when SRV.Fg_bl = 'Y' and SRV.Fg_mm = 'N' then SRV.Pri*SRV.Quan_total_medu ");
        str.append("when SRV.Fg_bl = 'Y' and SRV.Fg_mm = 'Y' then SRV_MM.Price_Pgku_Cur*SRV_MM.Quan_Cur else 0.0 end) as TotalPrice,");
        str.append("SRV.Id_medu,");
		str.append("MEAS.Name as Name_medu,");
		str.append("SRV.Id_hpsrvtp,");
		str.append("SRV.Sd_hpsrvtp,");
		str.append("substr(HPSRVTP.Name,0,2) as Name_hpsrvtp,");
		str.append("SRV.Id_dep_mp,");
		str.append("DEP_MP.Name as Name_dep_mp,");
		str.append("SRV.Fg_selfpay,");
		str.append("ORD.Des_or, ");
		str.append("freq.name as Name_freq, ");
		str.append("ORD.days_or||'天' as Use_days, ");
		str.append(" ord.fg_skintest as fg_skintest ");//皮试标识
		
		str.append("from ci_prn_item PRNITM ");
		str.append("left join ci_or_srv SRV on SRV.Id_orsrv = PRNITM.Id_biz ");
		str.append("left join ci_or_srv_mm SRV_MM on SRV.Id_orsrv = SRV_MM.Id_orsrv ");
		str.append("left join bd_measdoc MEAS on SRV.Id_medu = MEAS.Id_measdoc ");
		str.append("left join bd_udidoc HPSRVTP on HPSRVTP.Id_udidoc=SRV.Id_hpsrvtp ");
		str.append("left join bd_dep DEP_MP on DEP_MP.Id_dep = SRV.Id_dep_mp ");
		str.append("left join ci_order ORD on ORD.Id_or=SRV.Id_or ");
		str.append("left join bd_freq freq on ORD.id_freq=freq.id_freq ");
		
		str.append(" where SRV.sd_su_bl!=2 and PRNITM.Id_ciprn in ("+strIdciprns+") ");
		if(!StringUtils.isNullOrEmpty(strSdSrvtp)) {
			str.append(strSdSrvtp);
		}
		return str.toString();
	}
	
	/**
	 * 查询患者就诊信息
	 * @param qry
	 * @return
	 * @throws Exception
	 */
	private List<PatEntPrnDTO> getPatEntPrnList(String qry) throws Exception{
		if(StringUtils.isNullOrEmpty(qry))return null;
		// 执行sql查询数据记录
		List<PatEntPrnDTO> result = CiorderPrintUtils.GetQueryResulte(PatEntPrnDTO.class,qry);
		return result;
	}
	
	/**
	 * 查询费用项目信息
	 * @param qry
	 * @return
	 * @throws Exception
	 */
	private List<CiorSrvCostDTO> getCiorSrvCostList(String qry) throws Exception{
		if(StringUtils.isNullOrEmpty(qry))return null;
		// 执行sql查询数据记录
		List<CiorSrvCostDTO> result = CiorderPrintUtils.GetQueryResulte(CiorSrvCostDTO.class,qry);
		return result;
	}
}
