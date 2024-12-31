package iih.ci.mr.s.bp.task.bp.MrCheckUnFilnishedTaskBP;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mrm.dto.cimrmqrylist.d.CiMrmQryListDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetSqlbp {

	public CiMrmQryListDTO[] GetSQL(String id_org,FDateTime dateTime,int hours,int comhours) throws BizException, ParseException{
		StringBuilder sql = new StringBuilder();
		int hour = comhours + hours;
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		Date nowtime = simpleFormat.parse(dateTime.toString());
		Calendar cal = Calendar.getInstance();   
        cal.setTime(nowtime);   
        cal.add(Calendar.HOUR, -hour);
        Date date = cal.getTime();
		SqlParam str = new SqlParam();
		sql.append(" select ");
		sql.append(" amr.id_treat_doctor as id_emp_phy, ");
		sql.append(" amr.id_ent ,");
		sql.append(" ent.name_pat, ");
		sql.append(" amr.code_amr_ip, ");
		sql.append(" ent.dt_end as dt_end ");
		sql.append(" from en_ent ent ");
		sql.append(" left join ci_amr amr ");
		sql.append(" on ent.id_ent = amr.id_ent ");
		sql.append(" where ent.fg_ip = 'N' ");
		sql.append(" and amr.sd_qa_doctor_part_sta = '"+ICiMrDictCodeConst.SD_MR_COMWRITE+"' ");
		sql.append(" and ent.id_org = ? ");
		str.addParam(id_org);
		sql.append(" and ent.dt_end <= '"+simpleFormat.format(date)+"' ");
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<CiMrmQryListDTO> listDto = (List<CiMrmQryListDTO>) daf.execQuery(sql.toString(),str,
				new BeanListHandler(CiMrmQryListDTO.class));
		return listDto.toArray(new CiMrmQryListDTO[0]);
	}
}
