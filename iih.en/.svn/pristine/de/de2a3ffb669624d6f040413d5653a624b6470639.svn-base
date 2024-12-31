package iih.en.pv.s.task.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.en.comm.util.EnAppUtils;
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
 * 门诊评价短信通知BP
 * @author fanliqin
 *
 */
public class OpEvaluate4SmsBP {
	/**
	 * 执行
	 * @throws BizException
	 */
	public void exec() throws BizException{
		//1、获取前一天诊毕患者
		OpApt4SmsDTO[] opApt4SmsDTOs = this.getOpApt4SmsDTO();
		if(EnValidator.isEmpty(opApt4SmsDTOs))
			return;
		//2、调用发送短信服务
		IScAptOutCmdService icservice=ServiceFinder.find(IScAptOutCmdService.class);
		CheckIsSendedMsgBP bp = new CheckIsSendedMsgBP();
		for(OpApt4SmsDTO opApt4SmsDTO : opApt4SmsDTOs){
			if(EnValidator.isEmpty(opApt4SmsDTO.getMobile()))
				continue;
			//查询短信发送结果，fanlq-2018-04-28
			FBoolean fg_suc = bp.getSendMsgData(opApt4SmsDTO.getId_ent(), IScSmsConst.EN_OP_REG_MSG_TEMPLATE);
			if(FBoolean.TRUE.equals(fg_suc))
				continue;
			String result = "";
			try{
				result = icservice.sendOpSmsMsg(opApt4SmsDTO.getMobile(), IScSmsConst.SC_DIAG_END_MSG_TEMPLATE,opApt4SmsDTO);
				//保存短信发送结果，fanlq-2018-04-28
				bp.saveSendedMsgData(opApt4SmsDTO.getId_ent(),IScSmsConst.EN_OP_REG_MSG_TEMPLATE, result);
				}catch(Exception e) {
					continue;
			}
		}
	}
	
	public OpApt4SmsDTO[] getOpApt4SmsDTO() throws BizException{
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlBuilder.append("select distinct ent.id_ent as Id_ent,dep.name as Name_dep,pat.code as code_pat, ent.telno_pat as Mobile,dep.name as Name_dep, ");
		sqlBuilder.append("op.times_op as Time_op,dep.code as code_dep,res.code as code_doc,ent.code_entp as Code_enttp ");
		sqlBuilder.append("from en_ent ent ");
		sqlBuilder.append("inner join en_ent_op op ");
		sqlBuilder.append("on ent.id_ent = op.id_ent ");
		sqlBuilder.append("inner join bd_dep dep ");
		sqlBuilder.append("on ent.id_dep_phy = dep.id_dep ");
		sqlBuilder.append("inner join sc_res res on res.id_scres = op.id_scres ");
		sqlBuilder.append("inner join pi_pat pat on pat.id_pat = ent.id_pat ");
		sqlBuilder.append("where ent.code_entp = ? ");
		sqlBuilder.append("and ent.fg_canc = ? ");	
		sqlBuilder.append("and ent.dt_acpt >= ? ");
		sqlBuilder.append("and ent.dt_acpt < ? ");
		param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		param.addParam(FBoolean.FALSE);
		FDate today = EnAppUtils.getServerDate();
		param.addParam(today.getDateAfter(-1));
		param.addParam(today);
		List<OpApt4SmsDTO> opaptList = (List<OpApt4SmsDTO>) new DAFacade().execQuery(sqlBuilder.toString(), param,
				new BeanListHandler(OpApt4SmsDTO.class));
		if (EnValidator.isEmpty(opaptList)) {
			return null;
		}
		
		return opaptList.toArray(new OpApt4SmsDTO[0]);
	}
	
}
