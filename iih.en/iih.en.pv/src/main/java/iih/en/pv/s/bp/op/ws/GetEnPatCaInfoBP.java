package iih.en.pv.s.bp.op.ws;

import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.EnPatCaInfoDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取本次就诊患者分类
 * @param patCode
 * @param opTimes
 * @return
 * @throws BizException
 */
public class GetEnPatCaInfoBP {
	
	 /**
	  * 获取本次就诊患者分类
	  * @param patCode
	  * @param opTimes
	  * @return
	  * @throws BizException
	  */
	 public EnPatCaInfoDTO exec(String patCode,Integer opTimes)throws BizException{
		EnLogUtil.getInstance().logInfo("方法：getEnPatCaInfo参数为:patCode:"+patCode+";opTimes:"+opTimes);
		SqlParam param = new SqlParam();
		StringBuilder sb = new StringBuilder();	
		sb.append(" select ent.id_patca PatCaId,");
		sb.append(" pat.code patCode ,");
		sb.append(" ca.name PatCaName,");
		sb.append(" ca.code PatCaCode,");
		sb.append(" op.times_op TimesOp");
		sb.append(" from en_ent ent");
		sb.append(" inner join pi_pat pat ");
		sb.append(" on pat.id_pat = ent.id_pat ");
		sb.append(" inner join en_ent_op op");
		sb.append(" on ent.id_ent = op.id_ent");
		sb.append(" left join  pi_pat_ca ca");
		sb.append(" on ca.id_patca = ent.id_patca");
		sb.append(" where pat.code =?");
		sb.append(" and op.times_op = ?");
		param.addParam(patCode);
		param.addParam(opTimes);
		List<EnPatCaInfoDTO> list = (List<EnPatCaInfoDTO>) new DAFacade().execQuery(sb.toString(), param, new BeanListHandler(EnPatCaInfoDTO.class));				
		if(EnValidator.isEmpty(list))
			throw new BizException("未获取到患者"+patCode+"的就诊次数为"+opTimes+"就诊记录");
		
		return list.get(0);
		 
	 }	

}
