package iih.en.pv.s.task.bp;

import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.d.EuRegTp;
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
 * 门诊挂号短信通知BP
 * @author fanliqin
 *
 */
public class OpReg4SmsBP {
	/**
	 * 执行
	 * @throws BizException
	 */
	public void exec() throws BizException{
		//1、获取预约后一天的患者信息
		OpApt4SmsDTO[] opApt4SmsDTOs = this.getOpApt4SmsDTO();
		if(EnValidator.isEmpty(opApt4SmsDTOs))
			return;
		CheckIsSendedMsgBP bp = new CheckIsSendedMsgBP();	
		//2、调用发送短信服务
		IScAptOutCmdService icservice=ServiceFinder.find(IScAptOutCmdService.class);
		for(OpApt4SmsDTO opApt4SmsDTO : opApt4SmsDTOs){
			if(EnValidator.isEmpty(opApt4SmsDTO.getMobile()))
				continue;
			//查询短信发送结果，fanlq-2018-04-28
			FBoolean fg_suc = bp.getSendMsgData(opApt4SmsDTO.getId_ent(), IScSmsConst.EN_OP_REG_MSG_TEMPLATE);
			if(FBoolean.TRUE.equals(fg_suc))
				continue;
			String result = "";
			try{
			    result = icservice.sendOpSmsMsg(opApt4SmsDTO.getMobile(), IScSmsConst.EN_OP_REG_MSG_TEMPLATE,opApt4SmsDTO);
				//保存短信发送结果，fanlq-2018-04-28
				bp.saveSendedMsgData(opApt4SmsDTO.getId_ent(),IScSmsConst.EN_OP_REG_MSG_TEMPLATE, result);
				}catch(Exception e) {
					continue;
			}
		}
	}

	private OpApt4SmsDTO[] getOpApt4SmsDTO() throws BizException{

		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlBuilder.append("select ent.id_ent as Id_ent,ent.name_pat as Name_pat,ent.dt_entry as Dt_entry,ent.telno_pat as Mobile, sc_res.name as name_doc, ");
		sqlBuilder.append("sc_res.code as code_doc,dep.code as code_dep,op.times_op as Time_op,ent.code_entp as Code_enttp ");
		sqlBuilder.append("from en_ent ent ");
		sqlBuilder.append("inner join en_ent_op op ");
		sqlBuilder.append("on ent.id_ent = op.id_ent ");
		sqlBuilder.append("inner join sc_res sc_res ");
		sqlBuilder.append("on op.id_scres = sc_res.id_scres ");
		sqlBuilder.append("inner join bd_dep dep on dep.id_dep = op.id_dep_reg ");
		sqlBuilder.append("where ent.fg_canc = ? ");
		sqlBuilder.append("and op.eu_regtp <> ?");	
		sqlBuilder.append("and ent.dt_entry >= ? ");
		sqlBuilder.append("and ent.dt_entry < ? ");

		param.addParam(FBoolean.FALSE);
		param.addParam(EuRegTp.APT);
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
