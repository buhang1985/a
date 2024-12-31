package iih.en.pv.s.bp;

import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.PatEntInfoDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取患者就诊记录BP
 * 
 * @author jizb
 *
 */
public class GetEntListByPatcodeBP {

	/**
	 * 获取患者就诊记录
	 * 
	 * @param patCode   患者编码
	 * @param dtBegin   就诊时间开始时间
	 * @param dtEnd  	就诊时间结束时间
	 * @param entpCode	就诊类型编码
	 * @return
	 * @throws BizException
	 */
	public PatEntInfoDTO[] exec(String patCode, String dtBegin, String dtEnd, String entpCode) throws BizException {
		//记录输入参数日志，fanlq-add
		EnLogUtil.getInstance().logInfo("方法：GetEntListByPatcodeBP参数为:patCode:"+patCode+";dtBegin:"+dtBegin
				+";dtEnd:"+dtEnd+";entpCode:"+entpCode);
		
		if (EnValidator.isEmpty(patCode) || EnValidator.isEmpty(dtBegin) || EnValidator.isEmpty(dtEnd)) {
			return null;
		}
		//从chis同步患者
		GetPatIdForAp patap = new GetPatIdForAp();
		String patId = patap.exec(patCode);
		StringBuilder sqlSb = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlSb.append(" select");
		sqlSb.append(" ? as patCode,");
		param.addParam(patCode);
		sqlSb.append(" op.times_op    opTimes,");
		sqlSb.append(" null as ipTimes,");
		sqlSb.append(" ent.dt_acpt    dtAcpt,");
		sqlSb.append(" ent.id_ent     entId,");
		sqlSb.append(" ent.code_entp  EntpCode,");
		sqlSb.append(" ent.name_pat   patName,");
		sqlSb.append(" ent.id_dep_phy phyDepId,");
		sqlSb.append(" dep.code       phyDepCode,");
		sqlSb.append(" op.sd_status   statusCode");
		sqlSb.append(" from en_ent ent");
		sqlSb.append(" inner join en_ent_op op on ent.id_ent = op.id_ent");
		sqlSb.append(" left  join bd_dep dep on ent.id_dep_phy = dep.id_dep");
		sqlSb.append(" where ent.id_pat in (select id_pat from pi_pat where code = ?)");
		param.addParam(patCode);
		sqlSb.append(" and ent.fg_canc = 'N'");
		sqlSb.append(" and ent.dt_entry >= ?");
		param.addParam(dtBegin);
		sqlSb.append(" and ent.dt_entry < ?");
		param.addParam(dtEnd);
		if (!EnValidator.isEmpty(entpCode)) {
			sqlSb.append(" and ent.code_entp = ?");
			param.addParam(entpCode);
		}
		sqlSb.append(" union");
		sqlSb.append(" select");
		sqlSb.append(" ? as patCode,");
		param.addParam(patCode);
		sqlSb.append(" null as opTimes,");
		sqlSb.append(" ip.times_ip    ipTimes,");
		sqlSb.append(" ent.dt_acpt    dtAcpt,");
		sqlSb.append(" ent.id_ent     entId,");
		sqlSb.append(" ent.code_entp  EntpCode,");
		sqlSb.append(" ent.name_pat   patName,");
		sqlSb.append(" ent.id_dep_phy phyDepId,");
		sqlSb.append(" dep.code       phyDepCode,");
		sqlSb.append(" ip.sd_status   statusCode");
		sqlSb.append(" from en_ent ent");
		sqlSb.append(" inner join en_ent_ip ip on ent.id_ent = ip.id_ent");
		sqlSb.append(" left  join bd_dep dep on ent.id_dep_phy = dep.id_dep");
		sqlSb.append(" where ent.id_pat in (select id_pat from pi_pat where code = ?)");
		param.addParam(patCode);
		sqlSb.append(" and ent.fg_canc = 'N'");
		sqlSb.append(" and ent.dt_entry >= ?");
		param.addParam(dtBegin);
		sqlSb.append(" and ent.dt_entry < ?");
		param.addParam(dtEnd);
		if (!EnValidator.isEmpty(entpCode)) {
			sqlSb.append(" and ent.code_entp = ?");
			param.addParam(entpCode);
		}
		List<PatEntInfoDTO> patEntInfos = (List<PatEntInfoDTO>) new DAFacade().execQuery(sqlSb.toString(), param, new BeanListHandler(PatEntInfoDTO.class));
		if (EnValidator.isEmpty(patEntInfos)) 
			return null;
		return patEntInfos.toArray(new PatEntInfoDTO[0]);
	}
}
