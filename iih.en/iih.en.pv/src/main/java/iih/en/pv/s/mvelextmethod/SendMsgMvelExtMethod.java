package iih.en.pv.s.mvelextmethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mvel2.MVEL;
import org.mvel2.ParserContext;

import com.ymer.designer.scripteditor.MvelExtMethod;

import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.s.task.bp.CheckIsSendedMsgBP;
import iih.sc.apt.dto.d.OpApt4SmsDTO;
import iih.sc.apt.i.IScAptOutCmdService;
import iih.sc.pub.ScGroupControlUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.MapHandler;
import xap.sys.jdbc.kernel.SqlParam;

/***
 * 发送短信规则内置函数（方法）
 * @author fanlq
 *
 */
public class SendMsgMvelExtMethod implements MvelExtMethod {
	@Override
	public void importMethod(ParserContext paramParserContext) {
		paramParserContext.addImport("sendMsgBySrv", MVEL.getStaticMethod(SendMsgMvelExtMethod.class, "sendMsgBySrv", new Class[] {String.class, String.class, String.class, String.class}));
		paramParserContext.addImport("sendMsgByMobMsg", MVEL.getStaticMethod(SendMsgMvelExtMethod.class, "sendMsgByMobMsg", new Class[] {String.class, String.class, String.class}));
	}
	
	@Override
	public String getClazzDesc() {
		return "挂号短信发送规则";
	}

	@Override
	public Map<String, String> getMethodParamsDesc() {
		Map<String, String> desclz = new HashMap<String, String>();
		desclz.put("sendMsgBySrv", String.class.getName() + ", " + String.class.getName() + ", " + String.class.getName()+ ", " + String.class.getName());
		desclz.put("sendMsgByMobMsg", String.class.getName() + ", " + String.class.getName() + ", " + String.class.getName());
		return desclz;
	}
	
	@Override
	public Map<String, String> getReturnTypes() {
		Map<String, String> rtnTypes = new HashMap<String, String>();
		rtnTypes.put("sendMsgBySrv", FBoolean.class.getName());
		rtnTypes.put("sendMsgByMobMsg", FBoolean.class.getName());
		return rtnTypes;
	}
	
	/***
	 * 挂号的服务是否发送短信
	 * @author fanlq 
	 * @param codeSrvs 服务编码
	 * @param mobiles 手机号，多个手机号用逗号隔开
	 * @param msgCode 短信模板编码
	 * @return
	 * @throws BizException 
	 */
	public static FBoolean sendMsgBySrv(String codeSrvs,String mobiles,String msgCode,String entId) throws BizException{
		//服务编码是否有效
		if(codeSrvs == null){
			Logger.error("未获取到需要发送短信的医事服务");
			return FBoolean.FALSE;
		}
		//校验手机号
		if (EnValidator.isEmpty(mobiles)) {
			Logger.error("未获取到接收短信的电话");
			return FBoolean.FALSE;
		}
		OpApt4SmsDTO aptDTO = wrapObj4Sms(entId);
		//挂号的服务是否匹配
		String srvCode = aptDTO.getCode_srv();
		if(srvCode == null || !codeSrvs.contains(srvCode)){
			return FBoolean.FALSE;
		}
		String[] srvCodes = codeSrvs.replaceAll("，", ",").split(",");
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT COUNT(*) as srvcount FROM sc_srv ");
		builder.append("where "+EnSqlUtils.getInSqlByIds("code",srvCodes)+" ");
		int count = 0;
		// 查询数据
		@SuppressWarnings("unchecked")
		Map<String, Integer> datas = (Map<String, Integer>) new DAFacade().execQuery(builder.toString(), new MapHandler());
		if (null != datas && !datas.isEmpty()) {
			count = datas.get("srvcount");
		}
		if(count == 0){
			return FBoolean.FALSE;
		}
		CheckIsSendedMsgBP bp = new CheckIsSendedMsgBP();
		FBoolean fg_suc = bp.getSendMsgData(entId, msgCode);
		if(FBoolean.TRUE.equals(fg_suc))
			return FBoolean.TRUE;
		//发送短信
		IScAptOutCmdService aptOutCmdService = ServiceFinder
				.find(IScAptOutCmdService.class);
		String result = aptOutCmdService.sendOpSmsMsg(mobiles,msgCode, aptDTO);
		bp.saveSendedMsgData(entId,msgCode, result);
		return FBoolean.TRUE;
	}
	
	/***
	 * 给指定手机号发送指定的短信
	 * @author fanlq 
	 * @param mobiles
	 * @param msgCode
	 * @return
	 * @throws BizException 
	 */
	public static FBoolean sendMsgByMobMsg(String mobiles,String msgCode,String entId) throws BizException{
		//校验挂号患者是否是需要发送短信的患者
		OpApt4SmsDTO aptDTO = wrapObj4Sms(entId);
		//校验手机号是否为空
		if (EnValidator.isEmpty(mobiles)) {
			Logger.error("未获取到接收短信的电话");
			return FBoolean.FALSE;
		}
		CheckIsSendedMsgBP bp = new CheckIsSendedMsgBP();
		FBoolean fg_suc = bp.getSendMsgData(entId, msgCode);
		if(FBoolean.TRUE.equals(fg_suc))
			return FBoolean.TRUE;
		//发送短信
		IScAptOutCmdService aptOutCmdService = ServiceFinder
				.find(IScAptOutCmdService.class);
		String result = aptOutCmdService.sendOpSmsMsg(mobiles,msgCode, aptDTO);
		bp.saveSendedMsgData(entId,msgCode, result);
		return FBoolean.TRUE;
	}

	/**
	 * 包装短信通知DTO
	 * 
	 * @param esDTO
	 * @return
	 * @throws BizException
	 */
	private static OpApt4SmsDTO wrapObj4Sms(String entId) throws BizException {
		if(EnValidator.isEmpty(entId)){
			return null;
		}
		StringBuilder builder = new StringBuilder();
		SqlParam param = new SqlParam();
		builder.append("SELECT pat.code as Code_pat,pat.name as Name_pat,pat.mob as Mobile,srv.code as code_srv, srv.name as  Name_srv,");
		builder.append("doc.name as Name_doc,ent.dt_insert as D_apt,ent.dt_entry as Dt_entry,substr(ent.dt_entry,0,10) as Dt_expect,");
		builder.append("dep.name as Name_dep,op.times_op as Time_op,srv.name as name_srv ");
		builder.append("from en_ent ent ");
		builder.append("left join en_ent_op op on op.id_ent = ent.id_ent ");
		builder.append("left join pi_pat pat on pat.id_pat = ent.id_pat ");
		builder.append("left join bd_psndoc doc on doc.id_psndoc = op.id_emp_reg ");
		builder.append("left join bd_dep dep on dep.id_dep = ent.id_dep_phy ");
		builder.append("left join sc_srv srv on srv.id_scsrv = op.id_scsrv ");
		builder.append("where ent.id_ent = ? ");
		param.addParam(entId);
		//集团管控
		String orgWhere = ScGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "ENT");
		if(!EnValidator.isEmpty(orgWhere)){
			builder.append(" AND ").append(orgWhere);
		}
		@SuppressWarnings("unchecked")
		List<OpApt4SmsDTO> list = (List<OpApt4SmsDTO>) new DAFacade().execQuery(builder.toString(), param, new BeanListHandler(OpApt4SmsDTO.class));
		if(list != null && !list.isEmpty() && list.size() > 0){
			return list.get(0);
		}
		return null;
	}
}
