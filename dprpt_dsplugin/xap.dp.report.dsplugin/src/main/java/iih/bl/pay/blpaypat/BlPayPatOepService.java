package iih.bl.pay.blpaypat;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.handler.BeanListHandler;

public class BlPayPatOepService {

	public List<BlPatPayInfoDTO> assemPatPayInfo(String id_pat,String code_rep,String amt,String name_paymod,String name_emp_pay,String eudrict,String code_amt) throws Exception{
		BlPatPayInfoDTO blPatPayInfoDTO = new BlPatPayInfoDTO();
		List<BlPatPayReceiveInfoDTO> recList = new ArrayList<BlPatPayReceiveInfoDTO>();
		DecimalFormat df   = new DecimalFormat("######0.00");
		if("-1".equals(eudrict)){
			blPatPayInfoDTO.setEudrict("退费");
			blPatPayInfoDTO.setSignature("收费单位签章：");
		}else if("1".equals(eudrict)){
			blPatPayInfoDTO.setEudrict("收费");
			BlPatPayReceiveInfoDTO dto1 = new BlPatPayReceiveInfoDTO();
			dto1.setName_item("办卡工本费");
			dto1.setName_item_en("Cost Of Card");
			dto1.setAmt_pay(code_amt);
			recList.add(dto1);
		}
		BlPatPayReceiveInfoDTO dto2 = new BlPatPayReceiveInfoDTO();
		dto2.setName_item("预存医疗款");
		dto2.setName_item_en("Pre Paid Amount");
		dto2.setAmt_pay(df.format(Double.valueOf(amt)));
		recList.add(dto2);
		PiPatDTO piPatDTO = this.getPiPatInfo(id_pat);
		if(piPatDTO != null){
			blPatPayInfoDTO.setName_pat(piPatDTO.getName_pat());
			blPatPayInfoDTO.setCode_pat(piPatDTO.getCode_pat());
			piPatDTO.setAmt_total(new FDouble(df.format(piPatDTO.getPrepay().sub(piPatDTO.getAcc_lock()))));
			blPatPayInfoDTO.setAmt_balance(piPatDTO.getAmt_total().toString());
			blPatPayInfoDTO.setName_org(piPatDTO.getName_org());
		}
		blPatPayInfoDTO.setNo_ticket(code_rep);
		blPatPayInfoDTO.setRecList(recList);
		blPatPayInfoDTO.setAmt_total(new FDouble(df.format(Double.valueOf(amt))));
		blPatPayInfoDTO.setName_emp_pay(name_emp_pay);
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //HH表示24小时制；  
        String formatDate = dFormat.format(new Date());  
		blPatPayInfoDTO.setDt_pay(formatDate);
		blPatPayInfoDTO.setName_paymod(name_paymod);

		List<BlPatPayInfoDTO> list = new ArrayList<BlPatPayInfoDTO>();
		list.add(blPatPayInfoDTO);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public PiPatDTO getPiPatInfo(String id_pat) throws Exception{
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT org.name as name_org,P.NAME as name_pat,P.CODE as code_pat,C.PREPAY,C.ACC_LOCK ")
			 .append("FROM PI_PAT P ")
			 .append("LEFT JOIN PI_PAT_ACC C ON C.ID_PAT = P.ID_PAT ")
			 .append("inner join bd_org org on org.id_org = p.id_org ")//显示组织名称，fanlq-2018-05-14
			 .append("WHERE P.ID_PAT = '").append(id_pat).append("'");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		
		BeanListHandler beanlist_handler = new BeanListHandler(PiPatDTO.class);
		List<PiPatDTO> result = (List<PiPatDTO>)beanlist_handler.processRs(cached_rs);
		if(result == null || result.size() == 0){
			return null;
		}
		return result.get(0);
	}
}
