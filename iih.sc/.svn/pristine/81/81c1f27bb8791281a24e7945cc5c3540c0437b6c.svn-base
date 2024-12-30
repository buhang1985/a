package iih.sc.apt.s.bp.mt;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.sc.apt.dto.d.MtAppQryDTO;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.apt.s.bp.CalcSchChlRemainBP;
import iih.sc.comm.ScParamUtils;
import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.d.ScSchEnDO;
import iih.sc.sch.scsch.i.IScSchEnDORService;
import iih.sc.sch.scsch.i.IScschMDORService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取医技预约指定排班数据BP
 * 
 * @author zhengcm
 * @date 2016-12-08 16:55:51
 *
 */
public class GetMtResBP {

	/**
	 * 获取医技预约指定排班数据
	 *
	 * @param id_dept
	 * @param id_sch
	 * @param id_scchl
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	public MtResDTO exec(String id_dept, String id_sch, String id_scchl,FBoolean fg_autofilter,String id_srv) throws BizException {
		// 参数检查
		ScValidator.validateParam("id_dept", id_dept);
		ScValidator.validateParam("id_sch", id_sch);
		ScValidator.validateParam("id_scchl", id_scchl);
		if (fg_autofilter.booleanValue()) {
			ScValidator.validateParam("id_srv", id_srv);
		}
		// 查询数据
		StringBuilder sql = this.getSql(id_sch,fg_autofilter);
		SqlParam params = new SqlParam();
		params.addParam(id_dept);
		params.addParam(id_scchl);
		if(!StringUtil.isEmpty(id_sch)){
		params.addParam(id_sch);
		}
		if (fg_autofilter.booleanValue()) {
			params.addParam(id_srv);
		}
		List<MtResDTO> mtAptDTOs = (List<MtResDTO>) new DAFacade().execQuery(sql.toString(), params,
				new BeanListHandler(MtResDTO.class));
		if (ListUtil.isEmpty(mtAptDTOs)) {
			return null;
		}

		// 设置号位和号段数据
		new SetMtAptSchTicksBP().exec(mtAptDTOs);

		// 设置排班对应号位和号段的排班服务
		new SetMtAptScSrvBP().exec(mtAptDTOs);

		// 计算渠道剩余可预约数
		new CalcSchChlRemainBP().exec(mtAptDTOs);
		//设置用户的可选号预约权限
		this.handleCanPsnApt(mtAptDTOs);
		MtResDTO resDTO = mtAptDTOs.get(0);
		this.countByEntp(resDTO);
		return resDTO;
	}
	/**
	 * 设置当前用户的可选号预约权限
	 * @param mtAptDTOs
	 */
	private void handleCanPsnApt(List<MtResDTO> mtAptDTOs){
		FBoolean fg_canapt = ScParamUtils.canPsnApt()?FBoolean.TRUE:FBoolean.FALSE;
		for (MtResDTO mtResDTO : mtAptDTOs) {
			mtResDTO.setFg_canapt(fg_canapt);
			mtResDTO.setFg_quickapt(FBoolean.TRUE);
		}
	}
	/**
	 * 查询Sql
	 *
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private StringBuilder getSql(String id_sch,FBoolean fg_autofilter) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("sch.id_sch,");
		sb.append("sch.d_sch,");
		sb.append("pl.id_scpl,");
		sb.append("pl.name as name_scpl,");
		sb.append("pl.id_tickmd,");
		sb.append("pl.sd_tickmd,");
		sb.append("pl.id_dep,");
		sb.append("pl.srvslot_min as srvlot_min,");
		sb.append("pl.eu_timeslottp as Eu_timeslottp,");
		sb.append("res.id_scres as id_res,");
		sb.append("res.name as name_res,");
		sb.append("res.code as code_res,");
		sb.append("res.id_mt,");
		sb.append("chl.id_scchl,");
		sb.append("chl.scpolcn,");
		sb.append("sch.id_dayslot,");
		sb.append("sch.fg_setentp,");
		sb.append("lot.code as sd_dayslot,");
		sb.append("lot.name as name_dayslot,");
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
		sb.append("inner join sc_sch_chl chl on chl.id_sch = sch.id_sch ");
		sb.append("inner join sc_res res on res.id_scres = pl.id_scres ");
		sb.append("inner join bd_dayslot lot on lot.id_dayslot = sch.id_dayslot ");
		sb.append("where ");
		sb.append("pl.id_dep = ? ");
		sb.append("and chl.id_scchl = ? ");
		if(!StringUtil.isEmpty(id_sch)){
		sb.append("and sch.id_sch = ? ");
		}
		if (fg_autofilter.booleanValue()) {
			sb.append("and pl.id_scsrv in (select rel.id_scsrv from sc_srv_rel rel where rel.id_mdsrv = ?) ");
		}
		return sb;
	}
	/**
	 * 根据就诊类型过滤排班数据
	 * @param mtAptDTOs
	 * @param qryDTO
	 * @return
	 */
	private MtResDTO countByEntp(MtResDTO resDTO) throws BizException {
		if (!resDTO.getFg_setentp().booleanValue()) {
			return resDTO;
		}
		// 获取所有符合条件排班信息
		IScschMDORService iscschmdorservice = ServiceFinder.find(IScschMDORService.class);
		ScSchDO sch = iscschmdorservice.findById(resDTO.getId_sch());
		// 获取所有符合条件排班的所有排班就诊信息
		IScSchEnDORService iscschendorservice = ServiceFinder.find(IScSchEnDORService.class);
		ScSchEnDO[] schens = iscschendorservice.find("id_sch='"+resDTO.getId_sch()+"'", null, FBoolean.FALSE);
		Map<String, List<ScSchEnDO>> schEnMap = new HashMap<String, List<ScSchEnDO>>();
		if (sch != null) {
			// 按照id_sch给排班就诊信息分组
			for (ScSchEnDO scSchEnDO : schens) {
				if (schEnMap.containsKey(scSchEnDO.getId_sch())) {
					schEnMap.get(scSchEnDO.getId_sch()).add(scSchEnDO);
				} else {
					List<ScSchEnDO> schEnList = new ArrayList<ScSchEnDO>();
					schEnList.add(scSchEnDO);
					schEnMap.put(scSchEnDO.getId_sch(), schEnList);
				}
			}

		}
		this.countSchEntpData(resDTO, sch, schEnMap);
		return resDTO;
	}
	
	/**
	 * 通过号源池 排班就诊 过滤排班数据
	 * @param mtAptDTOs
	 * @param chlMap
	 * @param schEnMap
	 * @return
	 */
	private void countSchEntpData(MtResDTO resDTO, ScSchDO sch, Map<String, List<ScSchEnDO>> schEnMap) {
			String id_sch = resDTO.getId_sch();
			if (schEnMap.containsKey(id_sch)) {
				int ip_remain = 0;
				int op_remain = 0;
				List<ScSchEnDO> schEnList = schEnMap.get(id_sch);
				List<Integer> opPolcsList = new ArrayList<Integer>();
				List<Integer> ipPolcsList = new ArrayList<Integer>();
				for (ScSchEnDO scSchEnDO : schEnList) {
					if (scSchEnDO.getId_entp().contains(IBdFcDictCodeConst.ID_CODE_ENTP_OP)) {
						opPolcsList.add(scSchEnDO.getScpolcn());
					}
					if (scSchEnDO.getId_entp().contains(IBdFcDictCodeConst.ID_CODE_ENTP_IP)) {
						ipPolcsList.add(scSchEnDO.getScpolcn());
					}
				}
				
				for (Integer polcn : ipPolcsList) {
					ip_remain += Integer.parseInt(sch.getAttrVal("Quan" + polcn + "_appt").toString())
							- Integer.parseInt(sch.getAttrVal("Quan" + polcn + "_used").toString());
				}
				
				for (Integer polcn : opPolcsList) {
					op_remain += Integer.parseInt(sch.getAttrVal("Quan" + polcn + "_appt").toString())
								- Integer.parseInt(sch.getAttrVal("Quan" + polcn + "_used").toString());
				}
				resDTO.setIp_apt_num(ip_remain);
				resDTO.setOp_apt_num(op_remain);
			}else{
				resDTO.setIp_apt_num(0);
				resDTO.setOp_apt_num(0);
			}
	}
}
