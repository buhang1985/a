package iih.sc.apt.s.bp.mt;

import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.dto.d.MtAppQryDTO;
import iih.sc.apt.scaptappl.d.ScAptApplDO;
import iih.sc.apt.scaptappl.i.IScaptapplMDORService;
import iih.sc.comm.ScLogUtil;
import iih.sc.comm.ScParamUtils;
import iih.sc.comm.ScValidator;
import iih.sc.pub.ScGroupControlUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据申请单号查询患者预约信息BP
 *
 * @author zhengcm
 *
 */
public class GetMtAppByApplyNoBP {

	/**
	 * 根据申请单号查询患者预约信息
	 *
	 * @param appNo
	 *            申请单号
	 * @return
	 * @throws BizException
	 */
	public MtAppDTO exec(MtAppQryDTO qryDTO) throws BizException {
		// 检查参数
		//ScValidator.validateParam("appNo", appNo);
		if(qryDTO == null) return null;
		ScValidator.validateParam("appNo", qryDTO.getAppno());
		String appNo = qryDTO.getAppno();

		MtAppDTO appDTO = null;
		if (qryDTO.getFg_apted().booleanValue()) {
			ScLogUtil.getInstance().logError("1.GetMtAppListBP.exec()-->获取已预约申请单信息开始!");
			if(getIdApt(appNo) != null ){
				MtAppDTO mtAppDTO = this.getDoneData(getIdApt(appNo));// 已预约
				if(mtAppDTO != null){
					appDTO = mtAppDTO;
					appDTO.setFg_apt("Y");
				}
			}
			ScLogUtil.getInstance().logError("2.GetMtAppListBP.exec()-->获取已预约申请单信息开始!");
		} else {
			ScLogUtil.getInstance().logError("1.GetMtAppListBP.exec()-->获取待预约申请单信息开始!");
			MtAppDTO mtAppDTO = this.getData(appNo);// 待预约
			if(mtAppDTO != null){
				appDTO = mtAppDTO;
				appDTO.setFg_apt("N");
			}
			ScLogUtil.getInstance().logError("2.GetMtAppListBP.exec()-->获取待预约申请单信息结束!");
		}

		/*String idApt = getIdApt(appNo);
		if (!StringUtil.isEmptyWithTrim(idApt)) {
			// 查询已预约数据
			appDTO = this.getDoneData(idApt);
			appDTO.setFg_apt("Y");
		} else {
			// 查询待预约数据
			appDTO = this.getData(appNo);
			appDTO.setFg_apt("N");
		}*/
		// 设置就诊和患者数据
		if (null != appDTO) {
			//合单医嘱内容修改
			this.getContentOr(appDTO);
			new SetMtAppDTODatasBP().exec(Arrays.asList(new MtAppDTO[] { appDTO }));
			return appDTO;
		}
		return null;
	}

	/**
	 * 验证是否已预约
	 *
	 * @author yhl
	 * @param appNo
	 *            申请单号
	 * @return
	 * @throws BizException
	 */
	private String getIdApt(String appNo) throws BizException {
		IScaptapplMDORService applService = ServiceFinder.find(IScaptapplMDORService.class);
		String cond = " applyno = '" + appNo + "' and fg_canc = 'N' and fg_comfirm = 'Y' ";
		ScAptApplDO[] applDOS = applService.find(cond, "", FBoolean.FALSE);
		if (!ArrayUtil.isEmpty(applDOS) && applDOS.length == 1 && !StringUtil.isEmpty(applDOS[0].getId_scapt())) {
			return applDOS[0].getId_scapt();
		} else if (applDOS.length > 1) {
			throw new DAException("申请单号查询到多条数据!");
		} else {
			return null;
		}
	}

	/**
	 * 查询已预约信息
	 *
	 * @param appNo
	 *            申请单号
	 * @return
	 * @throws DAException
	 */
	private MtAppDTO getDoneData(String id_scapt) throws DAException {
		StringBuffer sb = new StringBuffer();
		sb.append("select distinct ");
		sb.append("appl.id_aptappl as id_apt_appl,");
		sb.append("apt.dt_appt,");
		sb.append("decode(sch.sd_tickmd,'03',substr(dt_b,12,5),to_char(apt.queno)) as  Queno_apt,");
		sb.append("apt.id_apt, ");
		sb.append("apt.id_scca, ");// add by yhl 2019/04/18
		sb.append("apt.id_scsrv,");// add by yhl 2019/04/18
		sb.append("appl.id_entp as id_enttp,");
		sb.append("appl.fg_hp,");// 医保支付标识
		sb.append("entp.name as name_enttp,");
		sb.append("doc.name as name_sex,");
		sb.append("appl.sd_aptmd,appl.sd_sys_from,");
		sb.append("appl.id_pi as id_pat,");
		sb.append("pat.name as name_pat,");
		sb.append("appl.id_ent,");
		sb.append("pat.dt_birth as dt_birth_pat,");
		sb.append("pat.id_sex,");
		sb.append("appl.fg_urgent,");
		sb.append("appl.id_dep_appl as id_dep_apply,");
		sb.append("dep.name as name_dep_apply,");
		sb.append("appl.content_or, ");
		sb.append("apt.dt_b as dt_acpt , ");
		sb.append("res.name as name_scres, ");
		sb.append("apt.sd_status as apt_status, ");
		sb.append("appl.id_srv, ");
		sb.append("appl.id_or, ");
		sb.append("appl.id_dep_mp, ");
		sb.append("appl.dt_effe_or as dt_plan, ");
		sb.append("appl.dt_effe_or, ");
		sb.append("appl.id_emp_appl, ");
		sb.append("(case ");
		sb.append("when mt.fg_needcfm = 'Y' and mt.fg_aptcfm = 'Y' then '已确认' ");
		sb.append("when mt.fg_needcfm = 'Y' and mt.fg_aptcfm = 'N' then '待确认' ");
		sb.append("end) as wait_confirm, ");
		sb.append("mt.id_aptmt, ");
		sb.append("mt.note, ");
		sb.append("apt.id_sch, ");
		sb.append("bdsrv.fg_needcfm, ");
		sb.append("appl.fg_bl, ");
		sb.append(
				"case  when appl.fg_bl='Y' then '已收费' when appl.fg_bl='N' then '未收费'  when  appl.fg_bl is null then '未收费' end  name_bl ");
		sb.append("from ");
		sb.append("sc_apt apt ");
		sb.append("inner join sc_apt_mt mt on apt.id_apt = mt.id_apt ");
		sb.append("inner join sc_apt_appl appl on appl.id_aptappl = mt.id_aptappl ");
		sb.append("inner join pi_pat pat on appl.id_pi = pat.id_pat ");
		sb.append("left join bd_dep dep on dep.id_dep = appl.id_dep_appl ");
		sb.append("inner join sc_res res on res.id_scres =  apt.id_scres ");
		sb.append("inner join sc_sch sch on sch.id_sch = apt.id_sch ");
		sb.append("left outer join sc_bdsrv bdsrv on appl.id_srv = bdsrv.id_srv ");
		sb.append("left outer join bd_entp entp on appl.id_entp = entp.id_entp ");
		sb.append("left outer join bd_udidoc doc on appl.id_sex = doc.id_udidoc ");
		sb.append(" where ");
		sb.append(" apt.fg_canc = 'N' ");
		sb.append(" and apt.id_apt = ? ");
		SqlParam params = new SqlParam();
		params.addParam(id_scapt);
		List<MtAppDTO> appDTOList = (List<MtAppDTO>) new DAFacade().execQuery(sb.toString(), params,
				new BeanListHandler(MtAppDTO.class));
		if (!ListUtil.isEmpty(appDTOList)) {
			return appDTOList.get(0);
		}
		return null;
	}
	/**
	 * 查询待预约申请单信息
	 * @param appNo
	 * @return
	 * @throws DAException
	 */
	private MtAppDTO getData(String appNo) throws DAException {
		StringBuilder sb = new StringBuilder();
		sb.append(" select");
		sb.append(" appl.id_aptappl as id_apt_appl,");
		sb.append(" appl.id_scapt as id_apt,");
		sb.append(" appl.id_or,");
		sb.append(" appl.id_ent,");
		sb.append(" appl.id_pi as id_pat,");
		sb.append(" appl.content_or,");
		sb.append(" appl.des,");
		sb.append(" appl.id_srv,");
		sb.append(" appl.id_dep_appl as id_dep_apply,");
		sb.append(" appl.id_dep_mp,");
		sb.append(" appl.id_emp_appl as id_emp_apply,");
		sb.append(" appl.sd_aptmd,appl.sd_sys_from,");
		sb.append(" appl.id_entp as id_enttp,");
		sb.append(" psndoc.name as name_emp_apply,");
		sb.append(" appl.applyno,");
		// sb.append(" ent.id_entp as id_enttp,");
		sb.append(" appl.dt_effe_or as dt_plan,");
		sb.append(" appl.dt_effe_or,");
		sb.append(" appl.name as name_or,");
		sb.append(" appl.fg_urgent,");
		sb.append(" appl.fg_hp,");
		sb.append(" srv.name as name_srv,");
		sb.append(" dep.name as name_dep_apply,");
		sb.append(" mp_dep.name as name_dep_mp,");
		sb.append(" pat.name as name_pat,");
		sb.append(" pat.id_sex,");
		sb.append(" pat.sd_sex,  ");
		sb.append(" pat.dt_birth as dt_birth_pat,");
		sb.append(" appl.dt_appl as dt_apply,");
		sb.append(" bdsrv.fg_needcfm,");
		sb.append(" appl.fg_bl,");
		sb.append(
				" case  when appl.fg_bl='Y' then '已收费' when appl.fg_bl='N' then '未收费'  when  appl.fg_bl is null then '未收费' end  name_bl");
		sb.append(" from sc_apt_appl appl ");
		sb.append(" inner join bd_srv srv on appl.id_srv = srv.id_srv");
		sb.append(" left outer join bd_dep dep on dep.id_dep = appl.id_dep_appl");
		sb.append(" left outer join bd_dep mp_dep on appl.id_dep_mp = mp_dep.id_dep");
		sb.append(" left outer join pi_pat  pat on pat.id_pat = appl.id_pi");
		sb.append(" left outer join bd_psndoc psndoc on psndoc.id_psndoc = appl.id_emp_appl");
		// sb.append(" left outer join en_ent ent on appl.id_ent=ent.id_ent");
		sb.append(" left outer join sc_bdsrv bdsrv on appl.id_srv = bdsrv.id_srv");
		sb.append(" where appl.fg_comfirm='N' ");
		sb.append(" and appl.fg_canc = 'N' and appl.fg_reg_arv = 'N' and appl.fg_canc_exec = 'N'");
		sb.append(" and appl.applyno= ? ");
		// 集团管控
		sb.append(" and " + ScGroupControlUtils.getGroupControlFitler(new ScAptApplDO(), "appl"));
		SqlParam params = new SqlParam();
		params.addParam(appNo);
		List<MtAppDTO> appDTOList = (List<MtAppDTO>) new DAFacade().execQuery(sb.toString(), params,
				new BeanListHandler(MtAppDTO.class));
		if (!ListUtil.isEmpty(appDTOList) && appDTOList.size() == 1) {
			if (!StringUtil.isEmpty(appDTOList.get(0).getId_apt())) {

			}
			List<MtAppDTO> result = new ArrayList<MtAppDTO>();
			boolean isCheckFee = ScParamUtils.getScAptMtChkFee(appDTOList.get(0).getId_dep_mp());
			if (appDTOList.get(0).getFg_needcfm() == null)
				appDTOList.get(0).setFg_needcfm(FBoolean.FALSE);
			if (isCheckFee) {
				if (appDTOList.get(0).getFg_needcfm().booleanValue()) {
					result.add(appDTOList.get(0));
				} else if (!appDTOList.get(0).getFg_needcfm().booleanValue() && appDTOList.get(0).getFg_bl() != null
						&& appDTOList.get(0).getFg_bl().booleanValue()) {
					result.add(appDTOList.get(0));
				}
			} else {
				result.add(appDTOList.get(0));
			}
			if (!ListUtil.isEmpty(result)) {
				return result.get(0);
			}
		} else if (appDTOList.size() > 0) {
			throw new DAException("申请单号查询到多条数据!");
		}
		return null;
	}


	/**
	 * 合单医嘱内容修改
	 *
	 * @param DTO
	 * @return
	 * @author yu.b
	 */
	private void getContentOr(MtAppDTO dto){

		if(StringUtil.isEmpty(dto.getContent_or())) {
			return;
		}

		StringBuilder sb = new StringBuilder("||");
		LinkedList<String> strs = new LinkedList<String>(Arrays.asList(dto.getContent_or().split("\\|\\|")));
		if(strs.size() <= 2){
			return;
		}
		strs.remove(0);
		for(String str1 : strs) {
			if(StringUtil.isEmpty(str1)) continue;
			String[] strArr = str1.split("&");
			if(ArrayUtil.isEmpty(strArr)) continue;
			sb.append(strArr[0]);
			if(strArr.length >= 3){
				sb.append(" ");
				sb.append(StringUtil.isEmpty(strArr[3]) ? "" : strArr[3].split("\\|")[0]);
			}
			sb.append(";");
		}
		sb.append("&&&|&&");
		dto.setContent_or(sb.toString());

	}

}
