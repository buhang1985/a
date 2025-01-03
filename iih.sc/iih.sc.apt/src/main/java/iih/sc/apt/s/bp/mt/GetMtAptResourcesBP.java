package iih.sc.apt.s.bp.mt;

import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.comm.ScValidator;
import iih.sc.pub.ScGroupControlUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取资源已预约列表数据BP
 *
 * @author zhengcm
 * @modifier zhengcm 增加集团管控
 *
 */
public class GetMtAptResourcesBP {
	/**
	 * 获取资源已预约列表数据
	 *
	 * @param schId 排班id
	 * @return
	 * @throws BizException
	 */
	public MtAppDTO[] exec(String schId) throws BizException {
		// 检查参数
		ScValidator.validateParam("schId", schId);

		// 查询数据
		List<MtAppDTO> appDTOList = this.queryDatas(schId);
		if (ListUtil.isEmpty(appDTOList)) {
			return null;
		}

		//获取合单医嘱多条医嘱内容
		this.getContentOr(appDTOList);

		// 设置就诊数据和计算患者年龄
		new SetMtAppDTODatasBP().exec(appDTOList);

		return appDTOList.toArray(new MtAppDTO[0]);
	}

	/**
	 * 查询数据
	 *
	 * @param schId
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	private List<MtAppDTO> queryDatas(String schId) throws BizException {
		// 查询Sql语句
		StringBuilder sb = this.getSql();
		// 查询数据
		SqlParam params = new SqlParam();
		params.addParam(schId);
		List<MtAppDTO> appDTOList = (List<MtAppDTO>) new DAFacade().execQuery(sb.toString(), params,
				new BeanListHandler(MtAppDTO.class));
		return appDTOList;
	}

	/**
	 * 查询Sql语句
	 *
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private StringBuilder getSql() throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("select distinct ");
		sb.append("apt.queno,");
		sb.append("ent.id_entp,");
		sb.append("ent.id_ent,");
		sb.append("pat.id_pat,");
		sb.append("pat.name as name_pat,");
		sb.append("pat.dt_birth as dt_birth_pat,");
		sb.append("pat.id_sex,");
		sb.append("appl.fg_urgent,");
		sb.append("appl.id_dep_appl as id_dep_apply,");
		sb.append("dep.name as name_dep_apply,");
		sb.append("appl.id_or,");
		sb.append("appl.content_or, ");
		sb.append("apt.id_emp_appt, "); // add by yhl 2019/04/15
		sb.append("apptdoc.name as name_emp_appt, ");//预约人 add by yhl 2019/04/15
		sb.append("apt.dt_appt, ");//预约操作时间 add by yhl 2019/04/15
		sb.append("mt.id_aptmt, ");//医技辅id add by yhl 2019/04/15
		sb.append("mt.url_photo, ");//照片地址 add by yhl 2019/04/15
		sb.append("entp.name as name_enttp, ");//类型 add by yhl 2019/04/15
		sb.append("apt.dt_b,  ");//检查时间 add by yhl 2019/06/03
		sb.append("(case ");
		sb.append("when mt.fg_needcfm = 'Y' and mt.fg_aptcfm = 'Y' then '已确认' ");
		sb.append("when mt.fg_needcfm = 'Y' and mt.fg_aptcfm = 'N' then '待确认' ");
		sb.append("end) as wait_confirm ");
		sb.append("from ");
		sb.append("sc_apt apt ");
		sb.append("inner join sc_apt_mt mt on mt.id_apt = apt.id_apt ");
		sb.append("inner join sc_apt_appl appl on appl.id_aptappl = mt.id_aptappl ");
		sb.append("inner join  pi_pat pat on apt.id_pat = pat.id_pat ");
		sb.append("left join en_ent ent on appl.id_ent = ent.id_ent ");
		sb.append("left join bd_dep dep on dep.id_dep = appl.id_dep_appl ");
		sb.append("inner join bd_psndoc apptdoc on apt.id_emp_appt = apptdoc.id_psndoc ");
		sb.append("left join bd_entp entp on appl.id_entp = entp.id_entp ");
		sb.append("where ");
		sb.append("apt.fg_canc = 'N' ");
		sb.append("and apt.id_sch = ? ");
		// 集团管控
		sb.append(" and " + ScGroupControlUtils.getGroupControlFitler(new ScAptDO(), "apt"));
		return sb;
	}


	/**
	 * 合单医嘱内容修改
	 *
	 * @param qryDTO
	 * @return
	 * @author yu.b
	 *
	 */
	private void getContentOr(List<MtAppDTO> dataList){
		if(ListUtil.isEmpty(dataList)){
			return;
		}
		for(MtAppDTO mtAppDTO : dataList){
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
