package iih.ei.sc.s.bp.qry;

import java.util.List;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.ei.sc.ws.bean.GetValidPeriodBean;
import iih.sc.apt.i.IScAptQryService;
import iih.sc.scbd.i.IScBdQryService;
import iih.sc.scbd.schedulechl.d.ScChlPeriodDO;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulechl.d.desc.ScChlPeriodDODesc;
import iih.sc.scbd.schedulechl.i.IScChlPeriodDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetValidPeriodBP {
	/**
	 * 根据渠道可预约时长和诊疗项目可以预约时间 获取申请单可以预约的时间范围
	 * @param id_aptapply
	 * @param chlType
	 * @return
	 * @throws BizException
	 */
	public GetValidPeriodBean[] exec(String id_aptapply,String chlType) throws BizException {
		GetValidPeriodBean bean = this.getValidPeriod(id_aptapply,chlType);	
		return new GetValidPeriodBean[]{bean};
	}
	
	/**
	 * 根据渠道可预约时长和诊疗项目可以预约时间 获取申请单可以预约的时间范围
	 * @param id_aptapply
	 * @param chlType
	 * @return
	 * @throws BizException
	 */
	private GetValidPeriodBean getValidPeriod(String id_aptapply,String chlType) throws BizException{
		GetValidPeriodBean bean = new GetValidPeriodBean();
		if(StringUtil.isEmpty(id_aptapply) || StringUtil.isEmpty(chlType)) return bean;
		FDate d_b = this.getServerDate();
		SchedulechlDO chlDO = this.getChlDO(chlType);
		int num_days_valid = this.getNumDaysValid(id_aptapply);
		FDate d_e = this.getMaxDate(chlDO, num_days_valid);
		bean.setD_b(d_b.toString());
		bean.setD_e(d_e.toString());
		return bean;
	} 
	/***
	 * 获得服务器日期
	 * 
	 * @return
	 */
	private FDate getServerDate() {
		TimeService ts = ServiceFinder.find(TimeService.class);
		return new FDate (ts.getUFDateTime().toLocalString());
	}
	/**
	 * 根据渠道编码获取渠道信息
	 * @param chlType
	 * @return
	 * @throws BizException 
	 */
	private SchedulechlDO getChlDO(String chlType) throws BizException{
		if (StringUtil.isEmptyWithTrim(chlType)) {
			return null;
		}
		IScAptQryService iscaptqryservice = ServiceFinder.find(IScAptQryService.class);
		SchedulechlDO[] schedulechldos = iscaptqryservice.valAptHaveChannel(chlType);
		if(ArrayUtil.isEmpty(schedulechldos)){
			return null;
		}
		SchedulechlDO chlDO = schedulechldos[0];
		return chlDO;
	}
	/**
	 * 获取渠道最大预约日期
	 *
	 * @param qryDTO
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private FDate getMaxDate(SchedulechlDO chlDO,int num_days_valid) throws BizException {
		String sd_sctp = IScDictCodeConst.SD_SCTP_MT;
		StringBuilder whereBuilder = new StringBuilder();
		whereBuilder.append(String.format("%s.ID_SCCHL='%s'", ScChlPeriodDODesc.TABLE_ALIAS_NAME, chlDO.getId_scchl()));
		whereBuilder.append(String.format(" AND %s.SD_SCTP='%s'", ScChlPeriodDODesc.TABLE_ALIAS_NAME, sd_sctp));
		IScChlPeriodDORService chlPeriodQryService = ServiceFinder.find(IScChlPeriodDORService.class);
		ScChlPeriodDO[] periodDOs = chlPeriodQryService.find(whereBuilder.toString(), null, FBoolean.FALSE);
		if(!ArrayUtil.isEmpty(periodDOs)){
			ScChlPeriodDO periodDO = periodDOs[0];
			if(periodDO.getDays() >= num_days_valid){
				return this.getChlMaxDate(chlDO, sd_sctp);
			}
		}
		return this.getValidMaxDate(num_days_valid);
	}
	/**
	 * 获取渠道最大可预约日期
	 * @param chlDO
	 * @param sd_sctp
	 * @return
	 * @throws BizException 
	 */
	private FDate getChlMaxDate(SchedulechlDO chlDO,String sd_sctp) throws BizException{
		IScBdQryService bdQryService = ServiceFinder.find(IScBdQryService.class);
		FDate fDate = bdQryService.getChlMaxAptDateBP(chlDO.getId_scchl(), sd_sctp);
		return fDate;
	}
	/**
	 * 获取有效期计算的最大可预约日期
	 * @param now
	 * @param num_days_valid
	 * @return
	 */
	private FDate getValidMaxDate(int num_days_valid){
		FDate now = this.getServerDate();
		return now.getDateAfter(num_days_valid);
	}
	/**
	 * 获取诊疗项目有效时间
	 * @param id_srv
	 * @return
	 * @throws DAException 
	 */
	private int getNumDaysValid(String id_aptapply) throws DAException{
		StringBuilder sql = new StringBuilder();
		sql.append(" select bdsrv.num_days_valid from sc_bdsrv bdsrv")
		.append(" left join sc_apt_appl appl on bdsrv.id_srv=appl.id_srv")
		.append(" where appl.id_aptappl=?");
		SqlParam params = new SqlParam();
		params.addParam(id_aptapply);
		List<String> list = (List<String>) new DAFacade().execQuery(sql.toString(),params, new ColumnListHandler());
		int num_days_valid = 0;
		if (list != null && list.size() > 0) {
			Object o = list.get(0);
			if(o != null && isInt(o.toString())){
			num_days_valid = Integer.parseInt(o.toString());
		}
		}
		return num_days_valid;
	}
	/**
	 * 判断是否是整型
	 * @param str
	 * @return
	 */
	private static boolean isInt(String str) {
        try {
            Integer.valueOf(str);
            return true;
        } catch (Exception e) {
        return false;
        }
    }
}
