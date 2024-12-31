package iih.bl.cc.service.s;

import java.util.List;

import iih.bl.cc.blccdto.d.BlpayOepPatDTO;
import iih.bl.cc.dto.d.BlccDRdetailDTO;
import iih.bl.cc.service.i.IBlccDailyReportService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

@Service(serviceInterfaces = {IBlccDailyReportService.class }, binding = Binding.JSONRPC)
public class BlccDailyReportServiceImpl implements IBlccDailyReportService {

	@Override
	public BlccDRdetailDTO[] findDetail(String begin, String end) throws BizException {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		
		sb.append("select psn.name name, ");
		sb.append("case when bdpm.name in ('现金') ");
		sb.append("then pm.amt else 0.00 end ic_cash, ");
		sb.append("case when bdpm.name in ('支票') ");
		sb.append("then pm.amt else 0.00 end ic_cheque, ");
		sb.append("case when bdpm.name not in ('现金','支票') ");
		sb.append("then pm.amt else 0.00 end ic_other, ");
		sb.append("case when bdpm.name in ('现金') ");
		sb.append("then pm.amt_return else 0.00 end rtn_cash, ");
		sb.append("case when bdpm.name in ('支票') ");
		sb.append("then pm.amt_return else 0.00 end rtn_cheque, ");
		sb.append("case when bdpm.name not in ('现金','支票') ");
		sb.append("then pm.amt_return else 0.00 end rtn_other, ");
		sb.append("inc.num_b num_b, ");
		sb.append("inc.num_e num_e, ");
		sb.append("pm.cn_amt cn_amt, ");
		sb.append("pm.cn_amtreturn cn_amtreturn, ");
		sb.append("cc.inccn_canc inccn_canc, ");
		sb.append("cc.dt_cc dt_cc ");
		sb.append("from bl_cc cc ");
		sb.append("inner join bl_cc_pm pm ");
		sb.append("on cc.id_cc = pm.id_cc ");
		sb.append("inner join bl_cc_inc inc ");
		sb.append("on cc.id_cc = inc.id_cc ");
		sb.append("inner join bd_psndoc psn ");
		sb.append("on cc.id_emp = psn.id_psndoc ");
		sb.append("inner join bd_pri_pm bdpm ");
		sb.append("on pm.id_pm = bdpm.id_pm ");
		sb.append("where cc.dt_cc between ? and ? ");
		sb.append("order by cc.dt_cc");
		
		SqlParam sp=new SqlParam();
		sp.addParam(begin);
		sp.addParam(end);
		
		@SuppressWarnings("unchecked")
		List<BlccDRdetailDTO> rtn= (List<BlccDRdetailDTO>)new DAFacade().execQuery(
				sb.toString(),
				sp,new BeanListHandler(BlccDRdetailDTO.class));
		
		if(rtn == null) return null;
		else return rtn.toArray(new BlccDRdetailDTO[rtn.size()]);
	}

	@Override
	public String getSysTime() throws BizException {
		// TODO Auto-generated method stub
		TimeService timeService = new TimeServiceImpl();
		String strDateTime =timeService.getUFDateTime().toStdString();
		return strDateTime;
	}

}
