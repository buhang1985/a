package iih.sc.apt.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.MtAppQryDTO;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.apt.s.bp.mt.SetMtAptScSrvBP;
import iih.sc.apt.s.bp.mt.SetMtAptSchTicksBP;
import iih.sc.apt.s.bp.mt.apt.CalcSchChlRemainNewBP;
import iih.sc.comm.ScValidator;
import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulechl.i.ISchedulechlMDORService;
import iih.sc.sch.scsch.d.ScSchDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.xapformula.vo.pub.formulaset.function.DateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetMtAptSchDatasByDateBP {

	/**
	 * 查询医技排班信息
	 * 
	 * @param qryDTO 查询DTO
	 * @return
	 * @throws BizException
	 */
	public MtResDTO[] exec(MtAppQryDTO qryDTO,FDate time) throws BizException {
		if (null == qryDTO) {
			return null;
		}
		// 检查参数
		ScValidator.validateParam("id_dep", qryDTO.getId_dep());
		ScValidator.validateParam("id_scchl", qryDTO.getId_scchl());
		ScValidator.validateParam("d_begin", qryDTO.getD_begin());
		if (qryDTO.getFg_autofilter().booleanValue()) {
			ScValidator.validateParam("id_srv", qryDTO.getId_srv_filter());
		}

		// 查询数据
		List<MtResDTO> mtAptDTOs = this.queryDatas(qryDTO,time);
		if (ListUtil.isEmpty(mtAptDTOs)) {
			return null;
		}
		// 根据就诊类型过滤数据
		mtAptDTOs = this.filterByEntp(mtAptDTOs, qryDTO);
		
		// 设置号位和号段数据
		new SetMtAptSchTicksBP().exec(mtAptDTOs);

		// 设置排班对应号位和号段的排班服务
		new SetMtAptScSrvBP().exec(mtAptDTOs);

		// 计算渠道剩余可预约数
		new CalcSchChlRemainNewBP().exec(mtAptDTOs,qryDTO);

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
	private List<MtResDTO> queryDatas(MtAppQryDTO qryDTO,FDate time) throws BizException {
		boolean isSccaFilter = qryDTO.getId_scca() != null && !"".equals(qryDTO.getId_scca());
		StringBuilder sql = this.getSql(isSccaFilter);
		SqlParam params = new SqlParam();
		params.addParam(qryDTO.getId_dep());
		params.addParam(IScDictCodeConst.SD_SCTP_OT);// 手术
		params.addParam(qryDTO.getId_scchl());
		params.addParam(time);
		if(isSccaFilter){
			params.addParam(qryDTO.getId_scca());
		}
		if (qryDTO.getFg_autofilter().booleanValue()) {
			params.addParam(qryDTO.getId_srv_filter());
		}
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
	private StringBuilder getSql(boolean isSccaFilter) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append(" select ");
		sb.append(" sch.id_sch,");
		sb.append(" sch.d_sch,");
		sb.append(" pl.id_scpl,");
		sb.append(" pl.name as name_scpl,");
		sb.append(" pl.code as code_scpl,");
		sb.append(" pl.id_tickmd,");
		sb.append(" pl.sd_tickmd,");
		sb.append(" pl.id_dep,");
		sb.append(" pl.srvslot_min as srvlot_min,");
		sb.append(" pl.eu_timeslottp as Eu_timeslottp,");
		sb.append(" res.id_scres as id_res,");
		sb.append(" res.name as name_res,");
		sb.append(" res.code as code_res,");
		sb.append(" res.id_mt,");
		sb.append(" chl.id_scchl,");
		sb.append(" chl.scpolcn,");
		sb.append(" chl.id_entp as ids_entp,");
		sb.append(" sch.id_dayslot,");
		sb.append(" lot.code as sd_dayslot,");
		sb.append(" lot.name as name_dayslot,");
		sb.append(" sch.quan_total,");
		sb.append(" sch.quan_total_appt,");
		sb.append(" sch.quan_total_used,");
		sb.append(" sch.fg_active,");
		sb.append(" sch.t_b_acpt,");
		sb.append(" sch.t_e_acpt,");
		sb.append(" sch.quan0_appt,");
		sb.append(" sch.quan1_appt,");
		sb.append(" sch.quan2_appt,");
		sb.append(" sch.quan3_appt,");
		sb.append(" sch.quan4_appt,");
		sb.append(" sch.quan5_appt,");
		sb.append(" sch.quan6_appt,");
		sb.append(" sch.quan7_appt,");
		sb.append(" sch.quan8_appt,");
		sb.append(" sch.quan9_appt,");
		sb.append(" sch.quan0_used,");
		sb.append(" sch.quan1_used,");
		sb.append(" sch.quan2_used,");
		sb.append(" sch.quan3_used,");
		sb.append(" sch.quan4_used,");
		sb.append(" sch.quan5_used,");
		sb.append(" sch.quan6_used,");
		sb.append(" sch.quan7_used,");
		sb.append(" sch.quan8_used,");
		sb.append(" sch.quan9_used, ");
		sb.append(" srv.name as  name_scsrv,");
		sb.append(" pl.id_scsrv,");
		sb.append(" sch.sugest_exmint");
		sb.append(" from ");
		sb.append(" sc_sch sch ");
		sb.append(" inner join sc_pl pl on pl.id_scpl = sch.id_scpl ");
		sb.append(" inner join sc_srv srv on srv.id_scsrv = pl.id_scsrv ");
		sb.append(" inner join sc_sch_chl chl on chl.id_sch = sch.id_sch ");
		sb.append(" inner join sc_res res on res.id_scres = pl.id_scres ");
		sb.append(" inner join bd_dayslot lot on lot.id_dayslot = sch.id_dayslot ");
		sb.append(" where ");
		sb.append(" pl.id_dep = ? ");
		sb.append(" and pl.sd_sctp = ? ");
		sb.append(" and chl.id_scchl = ? ");
		sb.append(" and sch.d_sch = ? ");
		if(isSccaFilter){
			sb.append("and pl.id_scca = ? ");
		}
		// 集团管控
		sb.append(" and " + ScGroupControlUtils.getGroupControlFitler(new ScSchDO(), "sch"));
		sb.append("order by res.name");
		//sb.append("order by sch.id_sch");
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
	 * 根据就诊类型过滤排班数据
	 * @param mtAptDTOs
	 * @param qryDTO
	 * @return
	 */
	private List<MtResDTO> filterByEntp(List<MtResDTO> mtAptDTOs,MtAppQryDTO qryDTO){
		FBoolean fg_ip = qryDTO.getFg_ip()==null?FBoolean.FALSE:qryDTO.getFg_ip();//住院
		FBoolean fg_op = qryDTO.getFg_op()==null?FBoolean.FALSE:qryDTO.getFg_op();//门诊
		FBoolean fg_et = qryDTO.getFg_et()==null?FBoolean.FALSE:qryDTO.getFg_et();//急诊
		boolean fliterEntp = !fg_ip.booleanValue()&&!fg_op.booleanValue()&&!fg_et.booleanValue();
		//FIXME  就诊类型过滤待放开
		if(!fliterEntp){
			Map<String,MtResDTO> filterMap = new HashMap<String,MtResDTO>();
			// 根据就诊类型过滤排班数据
			if(!ListUtil.isEmpty(mtAptDTOs)){
				for (MtResDTO mtResDTO : mtAptDTOs) {
					
					String key = mtResDTO.getId_sch()+mtResDTO.getId_scchl()+mtResDTO.getScpolcn();
					if(fg_ip.booleanValue()){
						if(mtResDTO.getIds_entp() != null && mtResDTO.getIds_entp().contains(IBdFcDictCodeConst.ID_CODE_ENTP_OP)){
							filterMap.put(key,mtResDTO);
						}
					}
					
					if(!filterMap.containsKey(key)){
						if(fg_op.booleanValue()){
							if(mtResDTO.getIds_entp() != null && mtResDTO.getIds_entp().contains(IBdFcDictCodeConst.ID_CODE_ENTP_IP)){
								filterMap.put(key,mtResDTO);
							}
						}
					}
					
					if(!filterMap.containsKey(key)){
						if(fg_et.booleanValue()){
							if(mtResDTO.getIds_entp() != null && mtResDTO.getIds_entp().contains(IBdFcDictCodeConst.ID_CODE_ENTP_ET)){
								filterMap.put(key,mtResDTO);
							}
						}
					}
					
				}
			}
			List<MtResDTO> result = new ArrayList<MtResDTO>();
			//result = (List<MtResDTO>) filterMap.values();
			for (MtResDTO mtResDTO : filterMap.values()) {
				result.add(mtResDTO);
			}
			return result;
		}else{
			return mtAptDTOs;
		}
	}
}
