package iih.en.que.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.bl.cg.i.IBlCgValidateService;
import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.dto.d.OpRegPatDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.sc.scbd.i.IScDaysLotService;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.reg.dto.d.RegResDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 判定号源的价格
 * @author renying
 *
 */
public class GetPriceBP {
	/**
	 * 判断一天是否只收一次挂号费,当天挂号费记帐
	 * 
	 * @author liubin
	 * 
	 * @param patId
	 * @param regRes
	 * @throws BizException
	 */
	public  RegResDTO exec(OpRegPatDTO opRegPat, RegResDTO regRes,String entId) throws BizException{
		this.validate(opRegPat);
		String patPriId = opRegPat.getId_pripat();
		if(!EnValidator.isEmpty(entId)){
			//已经记账的不再查询号源价格
			OutpatientDO entDO= new OpEP().getOpByEntIdWithOutRef(entId);
			if(!EnValidator.isEmpty(entDO.getId_cg())){
				return null;
			}
			regRes.setId_scsrv(entDO.getId_scsrv());
			PatiVisitDO pv = new PvEP().getPvByPK(entId);
			patPriId = pv.getId_pripat();
			String unRegSrvTp = EnParamUtils.GetUnregSrvTp();
			if("1".equals(unRegSrvTp)){
				//使用医生个人队列的主排班服务
				String scsrvId = getEmpMainSrvId(entId);
				if(!EnValidator.isEmpty(scsrvId))
					regRes.setId_scsrv(scsrvId);
			}
		}
		//判断一天是否只收一次挂号费,当天挂号费记过帐
		if(EnParamUtils.IsUnregChagOne() && hasChargedRegisterCost(opRegPat.getId_pat()) && !EnParamUtils.isOpinregSt(regRes.getId_dep())){
			//免挂号费
			String scsrvId = EnParamUtils.GetFreeRegistScSrvId();
			if(EnValidator.isEmpty(scsrvId))
				throw new BizException("免挂号费所使用排班服务[SC0110]未配置！");
			regRes.setId_scsrv(scsrvId);
		}	
		
		IScSchOutQryService schOutQryService = ServiceFinder.find(IScSchOutQryService.class);
		//1.加载挂号资源价格
		schOutQryService.loadPatResPri(new RegResDTO[]{regRes}, patPriId);
		
		return regRes;
		
		
	}
	
	/**
	 * 是否收取过挂号费
	 * 
	 * @author liubin
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	public boolean hasChargedRegisterCost(String patId) throws BizException{
		StringBuilder sqlBuider = new StringBuilder();
		sqlBuider.append(" SELECT EN.ID_ENT ");
		sqlBuider.append(" FROM EN_ENT EN ");
		sqlBuider.append(" INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
		sqlBuider.append(" WHERE EN.FG_CANC = 'N' ");
		sqlBuider.append(" AND EN.ID_PAT = ? ");
		sqlBuider.append(" AND OP.DT_VALID_B <= ? ");
		sqlBuider.append(" AND OP.DT_VALID_E >= ? ");
		SqlParam param = new SqlParam();  
		param.addParam(patId);
		DaysLotDO dayslot = getCurDayslot();
		FDateTime dateTime = EnAppUtils.getAcptQryDateTime(new FDate(dayslot.getDef1()), dayslot.getId_dayslot());
		param.addParam(EnAppUtils.getAdvanceAcptTime(dateTime));
		param.addParam(dateTime);
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) new DAFacade().execQuery(sqlBuider.toString(), param, new ColumnListHandler());
		if(EnValidator.isEmpty(list))
			return false;
		IBlCgValidateService serv = ServiceFinder.find(IBlCgValidateService.class);
		FBoolean result = serv.hasChargedRegisterCost(list.toArray(new String[0]));
		return FBoolean.TRUE.equals(result);
	}
	/**
	 * 数据校验
	 * 
	 * @param opRegPat
	 * @throws BizException
	 */
	private void validate(OpRegPatDTO opRegPat) throws BizException{
		if(opRegPat == null || EnValidator.isEmpty(opRegPat.getId_pat()))
			throw new BizException("患者信息不能为空！");
	}
	/**
	 * 获取当前日期分组
	 * 
	 * @return
	 * @throws BizException
	 */
	private DaysLotDO getCurDayslot() throws BizException{
		IScDaysLotService serv = ServiceFinder.find(IScDaysLotService.class);
		DaysLotDO dayslot = serv.getNowDaysLotCross(IScDictCodeConst.SD_SCTP_OP, FBoolean.TRUE);
		if(dayslot == null)
			throw new BizException("获取当前日期分组失败！");
		return dayslot;
	}
	/**
	 * 获取医生个人队列的主排班服务
	 * 
	 * @param entId
	 * @return
	 * @throws DAException 
	 */
	private String getEmpMainSrvId(String entId) throws DAException{
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT BQ.ID_SCSRV ");
		builder.append("FROM BD_QUE BQ ");
		builder.append("INNER JOIN SC_RES RES ON BQ.ID_SCRES = RES.ID_SCRES  ");
		builder.append("INNER JOIN (SELECT BQ1.ID_QUEBEN FROM BD_QUE BQ1 INNER JOIN EN_ENT_QUE EQ ON BQ1.ID_QUE = EQ.ID_QUE WHERE EQ.ID_ENT = ? AND  EQ.SD_ENTQUE_TP = ?) BEN ON BQ.ID_QUEBEN = BEN.ID_QUEBEN  ");
		builder.append("WHERE BQ.FG_ACTIVE = ? ");
		builder.append("AND BQ.ID_DEP = ? ");
		builder.append("AND RES.ID_EMP = ? ");
		SqlParam param = new SqlParam();
		param.addParam(entId);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(FBoolean.TRUE);
		param.addParam(EnContextUtils.getDeptId());
		param.addParam(EnContextUtils.getPsnId());
		@SuppressWarnings("unchecked")
		List<String>  list = (List<String>) new DAFacade().execQuery(builder.toString(),param, new ColumnListHandler());
		return EnValidator.isEmpty(list) ? null : list.get(0);
	}
}
