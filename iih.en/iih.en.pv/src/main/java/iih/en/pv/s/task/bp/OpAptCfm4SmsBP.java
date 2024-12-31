package iih.en.pv.s.task.bp;

import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.sc.apt.dto.d.OpApt4SmsDTO;
import iih.sc.apt.i.IScAptOutCmdService;
import iih.sc.pub.IScSmsConst;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;


/**
 * 预约取号短信通知BP
 * @author fanliqin
 *
 */

public class OpAptCfm4SmsBP {
	
	/**
	 * 执行
	 * @throws BizException
	 */
	public void exec(String orgId) throws BizException{
		//1、获取预约后一天的患者信息
		OpApt4SmsDTO[] opApt4SmsDTOs = this.getOpApt4SmsDTO(orgId);
		if(EnValidator.isEmpty(opApt4SmsDTOs))
			return;
		//2、调用发送短信服务
		IScAptOutCmdService icservice=ServiceFinder.find(IScAptOutCmdService.class);
		CheckIsSendedMsgBP bp = new CheckIsSendedMsgBP();
		for(OpApt4SmsDTO opApt4SmsDTO : opApt4SmsDTOs){
			if(EnValidator.isEmpty(opApt4SmsDTO.getMobile()))
				continue;
			//查询短信发送结果，fanlq-2018-04-28
			FBoolean fg_suc = bp.getSendMsgData(!EnValidator.isEmpty(opApt4SmsDTO.getId_ent())  ? opApt4SmsDTO.getId_ent():opApt4SmsDTO.getId_apt(), IScSmsConst.EN_OP_REG_MSG_TEMPLATE);
			if(FBoolean.TRUE.equals(fg_suc))
				continue;
			String result = "";
			try{
				result = icservice.sendOpSmsMsg(opApt4SmsDTO.getMobile(), IScSmsConst.EN_OP_APT_CFM_MSG_TEMPLATE,opApt4SmsDTO);
				//保存短信发送结果，fanlq-2018-04-28
				bp.saveSendedMsgData(!EnValidator.isEmpty(opApt4SmsDTO.getId_ent())  ? opApt4SmsDTO.getId_ent():opApt4SmsDTO.getId_apt(),IScSmsConst.EN_OP_APT_CFM_MSG_TEMPLATE, result);
			}catch(Exception e) {
				continue;
			}
			
		}
	}
	
	private OpApt4SmsDTO[] getOpApt4SmsDTO(String orgId) throws BizException{
		
		String[] noAptChIds = null;
		String str = EnParamUtils.getNoteExclChlTp(orgId);
		if(!EnValidator.isEmpty(str))
		{
			noAptChIds = str.split(",");		
		}
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlBuilder.append("select distinct apt.id_apt as Id_apt,ent.id_ent as Id_ent,pat.name as Name_pat,apt.dt_b as Dt_entry,pat.mob as Mobile, sc_res.name as name_doc, ");
		sqlBuilder.append("pat.code as code_pat,sc_res.code as code_doc,dep.code as code_dep,entop.times_op as Time_op,");
		sqlBuilder.append("ent.code_entp as Code_enttp ");
		sqlBuilder.append("from sc_apt apt ");
		sqlBuilder.append("inner join sc_apt_op op on apt.id_apt=op.id_apt ");
		sqlBuilder.append("inner join pi_pat pat on apt.id_pat = pat.id_pat ");	
		sqlBuilder.append("inner join sc_res sc_res  on apt.id_scres = sc_res.id_scres ");	
		sqlBuilder.append("left join en_ent_op entop on entop.id_ent = op.id_en ");
		sqlBuilder.append("left join en_ent ent on ent.id_ent = op.id_en ");
		sqlBuilder.append("left join bd_dep dep on dep.id_dep = op.id_dep ");
		sqlBuilder.append("where apt.fg_canc = ? ");
		if(!EnValidator.isEmpty(noAptChIds)){
			sqlBuilder.append("and ").append(EnSqlUtils.getNotInSqlByIds("apt.id_scchl", noAptChIds));
		}
		sqlBuilder.append("and apt.dt_b >= ? ");
		sqlBuilder.append("and apt.dt_b < ? ");
		param.addParam(FBoolean.FALSE);
		FDate today = EnAppUtils.getServerDate();
		param.addParam(today.getDateAfter(+1));
		param.addParam(today.getDateAfter(+2));
		List<OpApt4SmsDTO> opaptList = (List<OpApt4SmsDTO>) new DAFacade().execQuery(sqlBuilder.toString(), param,
				new BeanListHandler(OpApt4SmsDTO.class));
		if (EnValidator.isEmpty(opaptList)) {
			return null;
		}
		
		return opaptList.toArray(new OpApt4SmsDTO[0]);
	}
	
}
