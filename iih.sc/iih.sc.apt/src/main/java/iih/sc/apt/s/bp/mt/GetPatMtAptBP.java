package iih.sc.apt.s.bp.mt;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.comm.ScAppUtils;
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
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取医技中心预约病人预约安排
 *
 * @author zhengcm
 * @modifier zhengcm 增加集团管控
 *
 */
public class GetPatMtAptBP {
	/**
	 * 获取医技中心预约病人预约安排
	 *
	 * @param patId
	 * @param deptId
	 * @return
	 * @throws BizException
	 */
	public MtAppDTO[] exec(String patId, String deptId, String code_sctp) throws BizException {
		// 检查参数
		ScValidator.validateParam("patId", patId);

		// 获取病人待预约数据
		MtAppDTO[] undoAppDTOs = new MtAptCiObsOperateBP().getAppObsByPat(patId, deptId, code_sctp,null);

		// 获取病人已预约数据
		MtAppDTO[] doneAppDTOs = this.getPatDoneApt(patId, code_sctp);

		// 合并数据并返回
		MtAppDTO[] result = this.mergeDatas(undoAppDTOs, doneAppDTOs);

		FBoolean fg_cancle_apt = ScParamUtils.canPsnCancleApt() ? FBoolean.TRUE : FBoolean.FALSE;
		// 设置退约权限
		this.handleCancleAptAuth(result, fg_cancle_apt, deptId);
		//获取合单医嘱多条医嘱内容
		this.setContentOr(result);
		return result;
	}
	/**
	 * 合单医嘱内容修改
	 *
	 * @param qryDTO
	 * @return
	 * @author yu.b
	 *
	 */
	private void setContentOr(MtAppDTO[] dtos){
		if (!ArrayUtil.isEmpty(dtos)) {
			for(MtAppDTO mtAppDTO : dtos){
				if(StringUtil.isEmpty(mtAppDTO.getContent_or())){
					continue;
				}
				StringBuilder sb = new StringBuilder("||");
				LinkedList<String> strs = new LinkedList<String>(Arrays.asList(mtAppDTO.getContent_or().split("\\|\\|")));
				if(strs.size() <= 2){
					continue;
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
				mtAppDTO.setContent_or(sb.toString());
			}
		}
	}

	/**
	 * 设置退约权限
	 *
	 * @author yzh
	 * @param datas
	 * @param fg_cancle_apt
	 */
	private void handleCancleAptAuth(MtAppDTO[] datas, FBoolean fg_cancle_apt, String deptId) {
		if (!ArrayUtil.isEmpty(datas)) {
			for (MtAppDTO mtAppDTO : datas) {
				mtAppDTO.setFg_cancle_apt(fg_cancle_apt);
			}
		}
	}

	/**
	 * 获取病人已预约数据
	 *
	 * @param patId
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	private MtAppDTO[] getPatDoneApt(String patId, String code_sctp) throws BizException {
		if (StringUtil.isEmptyWithTrim(patId)) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		sb.append("select ");
		sb.append("apt.id_apt,");
		sb.append("substr(apt.dt_b,12) as t_b,");
		sb.append("substr(apt.dt_e,12) as t_e,");
		sb.append("apt.dt_b as dt_plan,");
		sb.append("appl.dt_effe_or,");
		sb.append("apt.queno,");
		sb.append("ent.id_entp,");
		sb.append("apt.id_pat,");
		sb.append("appl.piname as name_pat,");
		sb.append("ent.id_ent,");
		sb.append("appl.d_pi as dt_birth_pat,");
		sb.append("appl.id_sex,");
		sb.append("mt.id_aptmt,");
		sb.append("mt.id_aptappl as id_apt_appl,");
		sb.append("mt.url_photo,");
		sb.append("(case ");
		sb.append("when mt.fg_needcfm = 'Y' and mt.fg_aptcfm = 'Y' then '已确认' ");
		sb.append("when mt.fg_needcfm = 'Y' and mt.fg_aptcfm = 'N' then '待确认' ");
		sb.append("end) as wait_confirm, ");
		sb.append("appl.fg_urgent,");
		sb.append("appl.id_dep_appl as id_dep_apply,");
		sb.append("dep.name as name_dep_apply,");
		sb.append("appl.id_or,");
		sb.append("appl.content_or, ");
		sb.append("apt.id_scca, ");
		sb.append("appl.id_srv, ");
		sb.append("apt.id_scres, ");
		sb.append("appl.id_dep_mp, ");
		sb.append("appl.sd_sys_from, ");
		sb.append("appl.sd_aptmd,");
		sb.append("appl.code_entp as sd_enttp,");
		sb.append("apt.id_scsrv, ");
		sb.append("sch.id_tickmd, ");
		sb.append("sch.sd_tickmd ");//2019-04-09 yhl增加票号模式
		sb.append("from ");
		sb.append("sc_apt apt ");
		sb.append("inner join sc_apt_mt mt on apt.id_apt = mt.id_apt ");
		sb.append("inner join sc_apt_appl appl on appl.id_scapt = apt.id_apt ");
		sb.append("left join en_ent ent on appl.id_ent = ent.id_ent ");
		sb.append("left join bd_dep dep on dep.id_dep = appl.id_dep_appl ");
		sb.append("left join sc_sch sch on apt.id_sch  = sch.id_sch ");//2019-04-09 yhl增加票号模式
		sb.append("where ");
		sb.append("apt.fg_canc = 'N' ");
		sb.append("and apt.dt_b >= ? ");
		sb.append("and apt.id_pat = ? ");
		sb.append("and apt.sd_status in (?,?,?) ");
		if (code_sctp != null) {
			sb.append("  and appl.sd_sctp ='");
			sb.append(code_sctp);
			sb.append("' ");
		} else {
			sb.append("  and appl.sd_sctp ='");
			sb.append(IScDictCodeConst.SD_SCTP_MT);
			sb.append("' ");
		}

		// 集团管控
		sb.append(" and " + ScGroupControlUtils.getGroupControlFitler(new ScAptDO(), "apt"));
		SqlParam params = new SqlParam();
		params.addParam(ScAppUtils.getServerDateTime().getBeginDate());
		params.addParam(patId);
		params.addParam(IScDictCodeConst.SD_APTSTATUS_ORDER);
		params.addParam(IScDictCodeConst.SD_APTSTATUS_PAY);
		params.addParam(IScDictCodeConst.SD_APTSTATUS_FINISH);
		List<MtAppDTO> appDTOList = (List<MtAppDTO>) new DAFacade().execQuery(sb.toString(), params,
				new BeanListHandler(MtAppDTO.class));
		if (ListUtil.isEmpty(appDTOList)) {
			return null;
		}
		for (MtAppDTO mtAppDTO : appDTOList) {
			if (IPiDictCodeConst.ID_SEX_MALE.equals(mtAppDTO.getId_sex())) {
				mtAppDTO.setName_sex(IPiDictCodeConst.NAME_SEX_MALE);
			} else if (IPiDictCodeConst.ID_SEX_FEMALE.equals(mtAppDTO.getId_sex())) {
				mtAppDTO.setName_sex(IPiDictCodeConst.NAME_SEX_FEMALE);
			} else if (IPiDictCodeConst.ID_SEX_UNEXPLAIN.equals(mtAppDTO.getId_sex())) {
				mtAppDTO.setName_sex(IPiDictCodeConst.NAME_SEX_UNEXPLAIN);
			} else if (IPiDictCodeConst.ID_SEX_UNKNOW.equals(mtAppDTO.getId_sex())) {
				mtAppDTO.setName_sex(IPiDictCodeConst.NAME_SEX_UNKNOW);
			}
			mtAppDTO.setAge(AgeCalcUtil.getAge(mtAppDTO.getDt_birth_pat()));
		}
		return appDTOList.toArray(new MtAppDTO[0]);
	}

	/**
	 * 合并数据
	 *
	 * @param undoAppDTOs
	 * @param doneAppDTOs
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private MtAppDTO[] mergeDatas(MtAppDTO[] undoAppDTOs, MtAppDTO[] doneAppDTOs) throws BizException {
		if (ArrayUtil.isEmpty(undoAppDTOs) && ArrayUtil.isEmpty(doneAppDTOs)) {
			return null;
		}
		List<MtAppDTO> list = new ArrayList<MtAppDTO>();
		if (!ArrayUtil.isEmpty(doneAppDTOs)) {
			list.addAll(Arrays.asList(doneAppDTOs));
		}
		if (!ArrayUtil.isEmpty(undoAppDTOs)) {
			list.addAll(Arrays.asList(undoAppDTOs));
		}
		return list.toArray(new MtAppDTO[0]);
	}

}
