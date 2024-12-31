package iih.en.pv.s.bp.op;

import iih.en.pv.dto.d.PrintRegistedInfoDTO;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取打印信息
 * @author Administrator
 *
 */
public class GetRegInfoForPrintBP {
	/**
	 * 获取打印信息
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	public PrintRegistedInfoDTO exec(String entId) throws BizException {				
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("select pat.code as pat_code, ");
		sqlStr.append(" ent.id_org as hosipital_name, ");
		sqlStr.append(" pat.name as pat_name, ");  
		sqlStr.append(" hp.name as hp_name, ");
		sqlStr.append(" res.name as res_name, ");
		sqlStr.append(" srv.name as srv_name, ");
		sqlStr.append(" op.ticketno as tick_num, ");
		sqlStr.append(" ticks.t_b as duration_begin, ");
		sqlStr.append(" ticks.t_e as duration_end, ");
		sqlStr.append(" tick.t_b as dura_begin, ");
		sqlStr.append(" tick.t_e as dura_end, ");
		sqlStr.append(" op.dt_valid_b as time_date, ");
		sqlStr.append(" ent.code as ent_code, ");
		sqlStr.append(" oep.amt as sum_charge, ");
		sqlStr.append(" oep.amt_pat as self_charge, ");
		sqlStr.append(" oep.amt - oep.amt_pat as tong_chou, ");
	    sqlStr.append(" ent.id_emp_entry as operator_id ");
	    sqlStr.append("from en_ent ent  "); 
	    sqlStr.append("left join pi_pat pat on pat.id_pat = ent.id_pat ");
	    sqlStr.append("left join bd_hp hp on hp.id_hp = ent.id_hp ");
	    sqlStr.append("inner join en_ent_op op on op.id_ent = ent.id_ent ");
	    sqlStr.append("left join sc_res res on op.id_scres = res.id_scres ");
	    sqlStr.append("left join sc_srv srv on op.id_scsrv = srv.id_scsrv ");
	    sqlStr.append("left join sc_ticks ticks on ticks.id_ticks = op.id_ticks ");
	    sqlStr.append("left join sc_tick tick on tick.queno = op.ticketno and op.id_sch = tick.id_sch ");
	    sqlStr.append("left join bl_cg_itm_oep oep on oep.id_ent = ent.id_ent ");
	    sqlStr.append("where ent.id_ent = ? ");
	    
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(entId);
	    
	    DAFacade dao = new DAFacade();  
	    List<PrintRegistedInfoDTO> result = (List<PrintRegistedInfoDTO>)dao.execQuery(
				sqlStr.toString(), sqlParam,  new BeanListHandler(PrintRegistedInfoDTO.class));
	    
	    // 处理 号位和号段的选择
	    if(result.get(0).getDuration_begin() == null || result.get(0).getDuration_end() == null){
	    	result.get(0).setDuration_begin(result.get(0).getDura_begin());
	    	result.get(0).setDuration_end(result.get(0).getDura_end());
	    }
	    
	    // 处理时间数据
	    
	    String time_begin = result.get(0).getDuration_begin().substring(0, 5);
	    String time_end = result.get(0).getDuration_end().substring(0, 5);
	    
	    result.get(0).setDuration_begin(time_begin);
	    result.get(0).setDuration_end(time_end);
	    
	    FDateTime time_date = new FDateTime(result.get(0).getTime_date());
	    result.get(0).setTime_date(time_date.getMonth() + "/" + time_date.getDay());
	    
	    //处理费用数据
	    
	    DecimalFormat df = new DecimalFormat("#00.00");

		BigDecimal sum =  new BigDecimal(result.get(0).getSum_charge());
		BigDecimal self = new BigDecimal(result.get(0).getSelf_charge());
		double tong_chou = 0.0;
	    
	    result.get(0).setSum_charge(df.format(sum.doubleValue()));
	    result.get(0).setSelf_charge(df.format(self.doubleValue()));
	    tong_chou = sum.subtract(self).doubleValue();
	    if(tong_chou > 0.0){
	    	result.get(0).setTong_chou(df.format(tong_chou));
	    }
	    
		if (result.get(0) == null) {
			return null;
		}else{
			return result.get(0);
		}
	}
}
