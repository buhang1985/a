package iih.sc.apt.s.bp.mt.apt.auto;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.MtAppQryDTO;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.apt.i.IScAptQryService;
import iih.sc.apt.s.bp.GetAptChlMaxDateBP;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scbd.bdsrv.d.ScBdsrvDO;
import iih.sc.scbd.bdsrv.i.IScbdsrvMDORService;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDO;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDsDO;
import iih.sc.scbd.scdeptparam.d.ScdeptparamAggDO;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulechl.i.ISchedulechlMDORService;
import iih.sc.sch.scsch.d.ScSchDO;

import java.util.ArrayList;
import java.util.List;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 自动预约查询医技排班信息
 * 
 * @author zhengcm
 * @modifier zhengcm 增加集团管控
 *
 */
public class GetMtResList4AutoAptBP {
	/**
	 * 查询医技排班信息
	 * 
	 * @param qryDTO 查询DTO
	 * @return
	 * @throws BizException
	 */
	public MtResDTO[] exec(MtAppQryDTO qryDTO) throws BizException {
		if (null == qryDTO) {
			return null;
		}
		IScbdsrvMDORService iscbdsrvmdorservice = ServiceFinder.find(IScbdsrvMDORService.class);
		ScBdsrvDO[] scbdsrvdos = iscbdsrvmdorservice.find("id_srv ='"+qryDTO.getId_srv()+"'", null, FBoolean.FALSE);
		
		if (!ArrayUtil.isEmpty(scbdsrvdos)) {
			ScBdsrvDO scbdsrvdo = scbdsrvdos[0];
			qryDTO.setId_scca(scbdsrvdo.getId_scca());
		}else{
			throw new BizException("该服务未在医技排班医疗项目中!");
		}
		//排班当天可以预约的午别
		List<String> dayslotList = this.getDayslotList(qryDTO.getId_scca(), qryDTO.getId_dep(), IScDictCodeConst.SD_SCTP_MT);
		// 检查参数
		ScValidator.validateParam("id_dep", qryDTO.getId_dep());
		ScValidator.validateParam("d_begin", qryDTO.getD_begin());
		ScValidator.validateParam("id_entp", qryDTO.getId_entp());
		//ScValidator.validateParam("d_end", qryDTO.getD_end());
		if (qryDTO.getFg_autofilter().booleanValue()) {
			ScValidator.validateParam("id_srv", qryDTO.getId_srv_filter());
		}

		// 根据渠道最大预约日期修正查询的结束日期
		FDate end = this.getChlMaxDate(qryDTO);
		if (end != null && qryDTO.getD_end().after(end)) {
			qryDTO.setD_end(end);
		}
		// 查询数据
		List<MtResDTO> mtAptDTOs = this.queryDatas(qryDTO,dayslotList);
		if (ListUtil.isEmpty(mtAptDTOs)) {
			return null;
		}

		return mtAptDTOs.toArray(new MtResDTO[0]);
	}

	/**
	 * 查询数据
	 *
	 * @param qryDTO
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	private List<MtResDTO> queryDatas(MtAppQryDTO qryDTO,List<String> dayslotList) throws BizException {
		boolean hasToday = !ListUtil.isEmpty(dayslotList);
		StringBuilder sql = this.getSql(hasToday,dayslotList);
		SqlParam params = new SqlParam();
		params.addParam(qryDTO.getId_dep());
		if (null != qryDTO.getQrytype() && qryDTO.getQrytype() == 3) {
			params.addParam(IScDictCodeConst.SD_SCTP_OT);// 手术
		} else {
			params.addParam(IScDictCodeConst.SD_SCTP_MT);// 医技
		}
		params.addParam(qryDTO.getD_begin());
		if (hasToday) {
			params.addParam(qryDTO.getD_begin());
		}
		params.addParam(qryDTO.getId_entp());
		params.addParam(qryDTO.getId_srv());
		//params.addParam(qryDTO.getD_end());
		List<MtResDTO> mtAptDTOs = (List<MtResDTO>) new DAFacade().execQuery(sql.toString(), params,
				new BeanListHandler(MtResDTO.class));
		return mtAptDTOs;
	}

	/**
	 * 查询Sql
	 *
	 * @param isAutoFilter 是否自动过滤
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private StringBuilder getSql(boolean hasToday,List<String> dayslotList) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("sch.id_sch,");
		sb.append("sch.d_sch,");
		sb.append("res.id_mt,");
		sb.append("pl.id_scpl,");
		sb.append("pl.name as name_scpl,");
		sb.append("pl.id_tickmd,");
		sb.append("pl.sd_tickmd,");
		sb.append("pl.id_dep,");
		sb.append("pl.srvslot_min as srvlot_min,");
		sb.append("pl.eu_timeslottp as Eu_timeslottp,");
		sb.append("pl.level_pri,");
		sb.append("sch.id_dayslot,");
		sb.append("sch.quan_total,");
		sb.append("sch.quan_total_appt,");
		sb.append("sch.quan_total_used,");
		sb.append("sch.fg_active,");
		sb.append("sch.t_b_acpt,");
		sb.append("sch.t_e_acpt,");
		sb.append("sch.quan0_appt,");
		sb.append("sch.quan1_appt,");
		sb.append("sch.quan2_appt,");
		sb.append("sch.quan3_appt,");
		sb.append("sch.quan4_appt,");
		sb.append("sch.quan5_appt,");
		sb.append("sch.quan6_appt,");
		sb.append("sch.quan7_appt,");
		sb.append("sch.quan8_appt,");
		sb.append("sch.quan9_appt,");
		sb.append("sch.quan0_used,");
		sb.append("sch.quan1_used,");
		sb.append("sch.quan2_used,");
		sb.append("sch.quan3_used,");
		sb.append("sch.quan4_used,");
		sb.append("sch.quan5_used,");
		sb.append("sch.quan6_used,");
		sb.append("sch.quan7_used,");
		sb.append("sch.quan8_used,");
		sb.append("sch.quan9_used ");
		sb.append("from ");
		sb.append("sc_sch sch ");
		sb.append("inner join sc_pl pl on pl.id_scpl = sch.id_scpl ");
		sb.append("inner join sc_srv_rel rel on pl.id_scsrv=rel.id_scsrv ");
		sb.append("left outer join sc_sch_en schen on sch.id_sch = schen.id_sch ");
		sb.append("inner join sc_res res on pl.id_scres=res.id_scres ");
		sb.append("where ");
		sb.append("pl.id_dep = ? ");
		//sb.append("and to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') < (sch.d_sch|| ' '||sch.t_e_acpt) ");
		sb.append("and pl.sd_sctp = ? ");
		
		if (hasToday) {
			String cond = ScSqlUtils.buildIdStr(dayslotList);
			sb.append("and (sch.d_sch > ? ");
			sb.append("or (sch.d_sch = ? and sch.id_dayslot in (").append(cond).append(")))");
		}else{
		sb.append("and sch.d_sch > ? ");
		}
		sb.append("and (INSTR(schen.id_entp, ?) > 0 or schen.id_entp is null) ");
		sb.append("and rel.id_mdsrv= ? ");
		sb.append("and sch.fg_active = 'Y' ");
		sb.append("and sch.fg_auto_apt = 'Y'");//适用于自动预约的排班
		//sb.append("and sch.d_sch <= ? ");
		// 集团管控
		sb.append(" and " + ScGroupControlUtils.getGroupControlFitler(new ScSchDO(), "sch"));
		sb.append("order by sch.d_sch,sch.t_b_acpt desc ,sch.id_sch");
		return sb;
	}

	/**
	 * 获取渠道最大预约日期
	 *
	 * @param qryDTO
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private FDate getChlMaxDate(MtAppQryDTO qryDTO) throws BizException {
		if (StringUtil.isEmptyWithTrim(qryDTO.getId_scchl())) {
			return null;
		}
		ISchedulechlMDORService chlQryService = ServiceFinder.find(ISchedulechlMDORService.class);
		SchedulechlDO chlDO = chlQryService.findById(qryDTO.getId_scchl());
		if (chlDO == null) {
			return null;
		}
		String sd_sctp = IScDictCodeConst.SD_SCTP_MT;
		if (null != qryDTO.getQrytype() && qryDTO.getQrytype() == 3) {
			sd_sctp = IScDictCodeConst.SD_SCTP_OT;
		}
		return new GetAptChlMaxDateBP().exec(chlDO.getCode_scchltp(), sd_sctp);
	}

	/**
	 * 获取当天可以预约的午别
	 * @param id_scca
	 * @param id_dep_mp
	 * @param sd_sctp
	 * @return
	 * @throws BizException
	 */
	public List<String> getDayslotList(String id_scca, String id_dep_mp,String sd_sctp) throws BizException {
		// 检查参数
		ScValidator.validateParam("id_scca", id_scca);
		ScValidator.validateParam("id_dep_mp", id_dep_mp);
		FDateTime now = ScAppUtils.getServerDateTime();
		List<String> dayslotList = new ArrayList<String>();
		IScAptQryService qry = ServiceFinder.find(IScAptQryService.class);
		ScdeptparamAggDO[] aggDOs = qry.getDeptParamList(id_dep_mp, sd_sctp);
		if(ArrayUtil.isEmpty(aggDOs)){
			throw new BizException("排班科室参数为空!");
		}
		for (ScdeptparamAggDO scdeptparamAggDO : aggDOs) {
			ScDeptParamDO deptParamDO = scdeptparamAggDO.getParentDO();
			if(id_scca.equals(deptParamDO.getId_scca())){
				ScDeptParamDsDO[] deptParamDs = scdeptparamAggDO.getScDeptParamDsDO();
				if(ArrayUtil.isEmpty(deptParamDs)){
					throw new BizException("排班科室参数为空");
				}
				for (ScDeptParamDsDO scDeptParamDsDO : deptParamDs) {
					FDate nowDate = now.getBeginDate();
					if(now.compareTo(new FDateTime(nowDate, scDeptParamDsDO.getT_end_reg())) < 0){
						dayslotList.add(scDeptParamDsDO.getId_dayslot());
					}
				}
				return dayslotList;
			}
		}
		return dayslotList;
	}
}
