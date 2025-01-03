package iih.bl.inc.blincquery.bp;

import iih.bd.base.utils.SqlUtils;
import iih.bl.inc.blincquerydto.d.BlincQueryDTO;
import iih.pi.reg.pat.d.PiPatCardDO;
import iih.pi.reg.pat.i.IPiPatCardDORService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
/**
 * 发票查询
 * @author LIM
 * @since 2019-10-21
 *
 */
public class BlIncQryBP {
	public PagingRtnData<BlincQueryDTO> findByPageInfo(PaginationInfo pg,
			String incType, String wherePart) throws BizException{
		String sql ="";
		if(!StringUtil.isEmpty(incType) && "op".equals(incType)){
			sql=this.getIncOPSql(wherePart);
		}else{
			sql= this.getIncIPSql(wherePart);
		}
		BlincQueryDTO incdto = new BlincQueryDTO();
		PagingServiceImpl<BlincQueryDTO> pagingServiceImpl = new PagingServiceImpl<BlincQueryDTO>();
		PagingRtnData<BlincQueryDTO> prd=pagingServiceImpl.findByPageInfo( incdto,  pg,  sql.toString(), "", null);
		
		//给表添加序号和就诊卡号字段
		if(prd != null){
			List<String> idPats = new ArrayList<String>();
			for (int i = 0; i < prd.getPageData().size(); i++) {
				BlincQueryDTO incInfoDTO = ((BlincQueryDTO)prd.getPageData().get(i));
				if(incInfoDTO != null){
					String id_pat = incInfoDTO.getId_pat();
					if(!StringUtil.isEmpty(id_pat)){
						if(!idPats.contains(id_pat)){
							idPats.add(id_pat);
						}
					}
				}
			}
			//获取患者卡信息
			Map<String,String> cardMap=this.getPatCardMap(idPats);
			PaginationInfo pagInfo = prd.getPagingInfo();//分页页数信息
			for (int i = 0; i < prd.getPageData().size(); i++) {
				BlincQueryDTO incInfoDTO = ((BlincQueryDTO)prd.getPageData().get(i));
				if(incInfoDTO != null){
					//给序号赋值
					incInfoDTO.setSortno(pagInfo.getPageIndex()*pagInfo.getPageSize()+1+i);
					//给就诊卡号赋值（如果一个患者多个就诊卡，则在所有启用的卡中取最新的那一个）
					if(!StringUtil.isEmpty(cardMap.get(incInfoDTO.getId_pat()))){
						incInfoDTO.setEnt_card(cardMap.get(incInfoDTO.getId_pat()));
					}
				}
			}
		}
		return prd;
	}
	
	/**
	 * 获取门诊发票查询语句
	 * @param wherePart
	 * @param orderByPart
	 * @return
	 */
	private String getIncOPSql(String wherePart){
		StringBuilder sb = new StringBuilder();
		sb.append("select inc.id_incoep id_inc,");
		sb.append("inc.id_pat,");
		sb.append("inc.id_enttp,");
		sb.append("inc.id_incca,");
		sb.append("inc.code_incpkg,");
		sb.append("decode(inc.fg_ec_inc,'Y',inc.incno,null) as incno,");
		sb.append("inc.dt_inc,");
//		sb.append("inc.amt_ratio * inc.eu_direct as amt,");
		sb.append("inc.amt_ratio * inc.eu_direct  - NVL((SELECT SUM(BL_PAY_ITM_PAT_OEP.AMT *");
		sb.append("BL_PAY_ITM_PAT_OEP.EU_DIRECT *BL_PAY_PAT_OEP.EU_DIRECT)");
		sb.append(" FROM BL_PAY_ITM_PAT_OEP");
		sb.append(" INNER JOIN BL_PAY_PAT_OEP on BL_PAY_ITM_PAT_OEP.ID_PAYPATOEP =BL_PAY_PAT_OEP.ID_PAYPATOEP");
		sb.append(" WHERE ID_PM = '@@@@Z71000000001ZJSK' ");
//		sb.append(" AND exists (SELECT ID_PAYPATOEP FROM BL_ST_OEP st WHERE  BL_PAY_PAT_OEP.ID_PAYPATOEP=st.id_stoep and st.ID_STOEP = inc.ID_STOEP)), 0) amt,");
		sb.append(" AND BL_PAY_PAT_OEP.ID_PAYPATOEP=(SELECT ID_PAYPATOEP FROM BL_ST_OEP WHERE ID_STOEP=inc.ID_STOEP)),0) amt,");
		sb.append("inc.id_emp_inc,");
		sb.append("inc.fg_canc,");
		sb.append("inc.fg_print,");
		sb.append("inc.sd_reason_canc,");
		sb.append("inc.des_reason_canc,");
		sb.append("inc.id_emp_canc,");
		sb.append("inc.dt_canc,");
		sb.append("inc.code_enttp,");
		sb.append("inc.amt_pat,");
		sb.append("inc.note,");
		sb.append("inc.times_prn,");
		sb.append("inc.ID_STOEP id_st,");
		sb.append("pat.name as pat_name,");
		sb.append("pat.code as pat_code,");
		sb.append("pat.sd_sex sd_sex,");
		sb.append("entp.name as entpname,");
		sb.append("incpsn.name as empinc_name,");
		sb.append("incpsn.code as empinc_code,");
		sb.append("cancpsn.name as empcanc_name,");
		sb.append("decode(inc.fg_ec_inc,'Y',incpaper.incno,inc.incno) as incno_paper,");
		sb.append("incpaper.dt_inc as dt_inc_paper,");
		sb.append("incpaper.fg_canc as fg_canc_paper,");
		sb.append("oep.dt_st,");
		sb.append("inc.fg_ec_inc");
		sb.append(" from bl_inc_oep inc");
		sb.append(" left join bl_inc_oep_paper incpaper on inc.id_incoep = incpaper.id_incoep ");
		sb.append(" left join pi_pat pat on inc.id_pat = pat.id_pat");
		sb.append(" left join bd_entp entp on inc.code_enttp=entp.code");
		sb.append(" left join bd_psndoc incpsn on inc.id_emp_inc = incpsn.id_psndoc");
		sb.append(" left join bd_psndoc cancpsn on inc.id_emp_canc=cancpsn.id_psndoc");
		sb.append(" left join bl_st_oep oep on inc.id_stoep=oep.id_stoep");
		sb.append(" where inc.fg_print = 'Y' ");
		sb.append(wherePart);
		sb.append(" order by inc.dt_inc desc ");
		return sb.toString();
	}
		
	/**
	 * 获取住院发票查询语句
	 * @param wherePart
	 * @param orderByPart
	 * @return
	 */
	private String getIncIPSql(String wherePart){
		StringBuilder sb = new StringBuilder();
		sb.append("select inc.id_incip id_inc,");
		sb.append("inc.id_pat,");
		sb.append("inc.id_enttp,");
		sb.append("inc.id_incca,");
		sb.append("inc.code_incpkg,");
		sb.append("decode(inc.fg_ec_inc,'Y',inc.incno,null) as incno,");
		sb.append("inc.dt_inc,");
		sb.append("inc.amt_ratio * inc.eu_direct  - NVL((SELECT SUM(BL_PAY_ITM_PAT_IP.AMT *");
		sb.append("BL_PAY_ITM_PAT_IP.EU_DIRECT *BL_PAY_PAT_IP.EU_DIRECT)");
		sb.append(" FROM BL_PAY_ITM_PAT_IP");
		sb.append(" INNER JOIN BL_PAY_PAT_IP on BL_PAY_ITM_PAT_IP.ID_PAYPATIP =BL_PAY_PAT_IP.ID_PAYPATIP");
		sb.append(" WHERE ID_PM = '@@@@Z71000000001ZJSK' ");
		sb.append("AND BL_PAY_PAT_IP.Id_Stip= inc.id_stip), 0) amt,");
		sb.append("inc.id_emp_inc,");
		sb.append("inc.fg_canc,");
		sb.append("inc.fg_print,");
		sb.append("inc.sd_reason_canc,");
		sb.append("inc.des_reason_canc,");
		sb.append("inc.id_emp_canc,");
		sb.append("inc.dt_canc,");
		sb.append("inc.code_enttp,");
		sb.append("inc.amt_pat,");
		sb.append("inc.note,");
		sb.append("inc.times_prn,");
		sb.append("inc.ID_STIP id_st,");
		sb.append("pat.name as pat_name,");
		sb.append("pat.code as pat_code,");
		sb.append("pat.sd_sex sd_sex,");
		sb.append("entp.name as entpname,");
		sb.append("incpsn.name as empinc_name,");
		sb.append("incpsn.code as empinc_code,");
		sb.append("cancpsn.name as empcanc_name,");
		sb.append("decode(inc.fg_ec_inc,'Y',incpaper.incno,inc.incno) as incno_paper,");
		sb.append("incpaper.dt_inc as dt_inc_paper,");
		sb.append("incpaper.fg_canc as fg_canc_paper,");
		sb.append("ip.dt_st,");
		sb.append("inc.fg_ec_inc");
		sb.append(" from bl_inc_ip inc");
		sb.append(" left join bl_inc_ip_paper incpaper on inc.id_incip = incpaper.id_incip ");
		sb.append(" left join pi_pat pat on inc.id_pat = pat.id_pat");
		sb.append(" left join bd_entp entp on inc.code_enttp=entp.code");
		sb.append(" left join bd_psndoc incpsn on inc.id_emp_inc = incpsn.id_psndoc");
		sb.append(" left join bd_psndoc cancpsn on inc.id_emp_canc=cancpsn.id_psndoc");
		sb.append(" left join bl_st_ip ip on ip.id_stip=inc.id_stip");
		sb.append(" where inc.fg_print = 'Y' ");
		sb.append(wherePart);
		sb.append(" order by inc.dt_inc desc ");
		return sb.toString();	
	}
	
	/**
	 * 获取患者卡信息map
	 * @param idPats 患者id
	 * @return
	 * @throws BizException 
	 */
	private Map<String,String> getPatCardMap(List<String> idPats) throws BizException{
		PiPatCardDO[] piPatCardDOs = null;
		if(!ListUtil.isEmpty(idPats)){
			IPiPatCardDORService piPatCardService = ServiceFinder.find(IPiPatCardDORService.class);
			piPatCardDOs = piPatCardService.find(" fg_act = 'Y' and " +SqlUtils.getInSqlByIds("id_pat", idPats), " sortno desc ", FBoolean.FALSE);
		}
		Map<String, String> cardMap=new HashMap<String, String>();
		if(!ArrayUtil.isEmpty(piPatCardDOs))
		{
			for (PiPatCardDO piPatCardDO : piPatCardDOs) {
				if(!cardMap.containsKey(piPatCardDO.getId_pat()))
				{
					cardMap.put(piPatCardDO.getId_pat(), piPatCardDO.getCode());
				}
			}
		}
		return cardMap;
	}
}
