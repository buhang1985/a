package iih.mp.dg.pres.tl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDouble;
import iih.ci.ord.printmanage.dto.OrdPresDTO;
import iih.ci.ord.printmanage.dto.PresDrugDTO;
import iih.ci.ord.printmanage.srv.CiorderPrintUtils;
import iih.ci.ord.printmanage.srv.ICiorderPrintConst;
import iih.ci.ord.printmanage.srv.pres.CiorderPresPrintService;

public class MpTLPresPrintService extends CiorderPresPrintService{

	private String HERB_TMPL = "%s 付，代煎 %s 付      %s  %s";
	
	@Override
	public List<OrdPresDTO> exec(String ids) throws Exception {
		
		this.Bl_State = ICiorderPrintConst.BLSTATE_ALL;
		List<OrdPresDTO> presList = super.exec(ids);
		
		if(ListUtil.isEmpty(presList))
			return presList;
		
		
		List<String> opOrsrvList = new ArrayList<String>();
		List<String> ipOrsrvList = new ArrayList<String>();
		
		//处理合计金额(真实值)
		for (OrdPresDTO pres : presList) {
			
			//组装处方描述信息
			pres.setHerb_info(String.format(HERB_TMPL, pres.getOrders(),
					StringUtils.isBlank(pres.getOrders_boil()) ? "0" : pres.getOrders_boil(), pres.getName_freq(),
					pres.getDes_or()));
			
			if(ListUtil.isEmpty(pres.getPresDrugList()))
				continue;
			
			List<String> srvList = null;
			if("00".equals(pres.getCode_entp()) || "01".equals(pres.getCode_entp())){
				srvList = opOrsrvList;
			}else{
				srvList = ipOrsrvList;
			}
			
			for (PresDrugDTO drug : pres.getPresDrugList()) {
				srvList.add(drug.getId_orsrv());
			}
		}
		
		//处理门诊金额
		this.handleOpAmt(opOrsrvList, presList);
		
		//住院住院金额
		this.handleIpAmt(ipOrsrvList, presList);
		
		return presList;
	}
	
	private void handleOpAmt(List<String> opOrsrvList,List<OrdPresDTO> presList) throws Exception {
		
		if(opOrsrvList.size() == 0)
			return;
		
		String inSql = "(";
		for (String str : opOrsrvList) {
			inSql += "'" + str + "',";
		}
		
		inSql = inSql.substring(0, inSql.length() - 1);
		inSql += ")";
		
		List<FeeInfoDTO> feeDtos = CiorderPrintUtils.GetQueryResulte(FeeInfoDTO.class, this.getOpAmtSql(inSql));
		if(ListUtil.isEmpty(feeDtos))
			return;
		
		Map<String,FDouble> feeMap = new HashMap<String,FDouble>();
		for (FeeInfoDTO fee : feeDtos) {
			feeMap.put(fee.getId_orsrv(), fee.getAmt());
		}
	
		for (OrdPresDTO pres : presList) {
			if(ListUtil.isEmpty(pres.getPresDrugList()))
				continue;
			
			if(!"00".equals(pres.getCode_entp()) && "01".equals(pres.getCode_entp()))
				continue;
			
			FDouble atm_total=new FDouble("0.00");
			for (PresDrugDTO drug : pres.getPresDrugList()) {
				
				FDouble amt = feeMap.get(drug.getId_orsrv());
				if(amt == null){
					amt = drug.getPrice().multiply(drug.getQuan_cur());
				}
				
				atm_total = atm_total.add(amt);
			}
			
			pres.setAmt_total(atm_total);
		}
	}
	
	private String getOpAmtSql(String whereInCond){
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select ");
		sqlSb.append("oepitm.id_orsrv,");
		sqlSb.append("oepitm.amt ");
		sqlSb.append("from bl_cg_itm_oep oepitm ");
		sqlSb.append("inner join bl_cg_oep oep ");
		sqlSb.append("on oepitm.id_cgoep = oep.id_cgoep ");
		sqlSb.append("and oep.eu_direct = 1 ");
		sqlSb.append("where oepitm.id_orsrv in " + whereInCond + " ");
		sqlSb.append("and oepitm.fg_refund = 'N' ");
		
		return sqlSb.toString();
	}
	
	private void handleIpAmt(List<String> ipOrsrvList,List<OrdPresDTO> presList){
		
	}
}
