package iih.sc.apt.s.bp.mt;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.dto.d.MtAppQryDTO;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScLogUtil;
import iih.sc.comm.ScSqlUtils;
import iih.sc.pub.ScGroupControlUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询待预约和已预约申请单信息（不分页）
 *
 * @author
 * @modifier zhengcm 增加集团管控
 *
 */
public class GetMtAppListBP {
	/**
	 * 待预约和已预约申请单查询
	 *
	 * @param qryDTO 查询DTO
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public MtAppDTO[] exec(MtAppQryDTO qryDTO, String code_sctp) throws BizException {
		if (null == qryDTO) {
			return null;
		}
		List<MtAppDTO> datas = null;
		if (qryDTO.getFg_apted().booleanValue()) {
			ScLogUtil.getInstance().logError("1.GetMtAppListBP.exec()-->获取已预约申请单信息开始!");
			datas = this.queryMtAptDoneApp(qryDTO,code_sctp);// 已预约
			ScLogUtil.getInstance().logError("2.GetMtAppListBP.exec()-->获取已预约申请单信息开始!");
		} else {
			ScLogUtil.getInstance().logError("1.GetMtAppListBP.exec()-->获取待预约申请单信息开始!");
			datas = this.queryMtAptUndoApp(qryDTO,code_sctp);// 待预约
			ScLogUtil.getInstance().logError("2.GetMtAppListBP.exec()-->获取待预约申请单信息结束!");
		}
		if (ListUtil.isEmpty(datas)) {
			return null;
		}
		// 设置就诊和患者数据
		new SetMtAppDTODatasBP().exec(datas);
		return datas.toArray(new MtAppDTO[0]);
	}

	/**
	 * 查询待预约申请单
	 *
	 * @param qryDTO
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private List<MtAppDTO> queryMtAptUndoApp(MtAppQryDTO qryDTO, String code_sctp) throws BizException {
		if (null == qryDTO) {
			return null;
		}
		if(qryDTO.getD_begin() == null){
			qryDTO.setD_begin(ScAppUtils.getServerDate());
		}
		if (qryDTO.getD_end() == null) {
			qryDTO.setD_end(qryDTO.getD_begin());
		}
		MtAptCiObsOperateBP obsOperateBP = new MtAptCiObsOperateBP();
		MtAppDTO[] datas = null;
		String code_schhl = "";
		if(qryDTO.getCode_scchl() != null){
			code_schhl = qryDTO.getCode_scchl();
		}
		ScLogUtil.getInstance().logError("2.进入方法MtAppListBP.queryMtAptUndoApp()-->获取待预约申请单信息,参数:id_pat:"+qryDTO.getId_pat()+" code_schhl:"+code_schhl);
		if (StringUtil.isEmptyWithTrim(qryDTO.getId_pat()) && IScDictCodeConst.SD_SCCHLTP_HOSPITAL_ALL.equals(code_schhl)) {// 预约中心预约
			String deptId = qryDTO.getId_dep();
			FDateTime d_begin = this.convertBeginDate(qryDTO.getD_begin());
			FDateTime d_end = this.convertEndDate(qryDTO.getD_end());
			String[] sd_entps = this.getEnttpSelected(qryDTO);
			if (StringUtil.isEmptyWithTrim(deptId) || d_begin == null || d_end == null || ArrayUtil.isEmpty(sd_entps)) {
				return null;
			}
			datas = obsOperateBP.getAppObsByDept(deptId, sd_entps, d_begin, d_end, code_sctp);
		}else if(!StringUtil.isEmpty(qryDTO.getId_pat()) && IScDictCodeConst.SD_SCCHLTP_HOSPITAL_ALL.equals(code_schhl)){//预约中心按照患者查询
			String deptId = qryDTO.getId_dep();
			FDateTime d_begin = this.convertBeginDate(qryDTO.getD_begin());
			FDateTime d_end = this.convertEndDate(qryDTO.getD_end());
			String[] sd_entps = this.getEnttpSelected(qryDTO);
			ScLogUtil.getInstance().logError("3.方法MtAppListBP.queryMtAptUndoApp()-->获取待预约申请单信息,根据患者信息查询,参数:d_begin:"+d_begin.toString()+" d_end:"+d_end.toString()+" deptid:"+deptId);
			if (StringUtil.isEmptyWithTrim(deptId) || d_begin == null || d_end == null || ArrayUtil.isEmpty(sd_entps)) {
				return null;
			}
			datas = obsOperateBP.getAppObsByDeptAndPat(deptId, sd_entps, d_begin, d_end,new String[]{qryDTO.getId_pat()},code_sctp);
		}
		else {// 病人预约（医生）
			FDateTime d_begin = this.convertBeginDate(qryDTO.getD_begin());
			datas = obsOperateBP.getAppObsByPat(qryDTO.getId_pat(), qryDTO.getId_dep(), code_sctp,d_begin);
		}
		List<MtAppDTO> dataList = null;
		if (!ArrayUtil.isEmpty(datas)) {
			dataList = Arrays.asList(datas);
		}
		//获取合单医嘱多条医嘱内容
		this.getContentOr(dataList);
		ScLogUtil.getInstance().logError("4.结束方法MtAppListBP.queryMtAptUndoApp()-->返回结果数:("+(datas==null?0:datas.length)+")");
		return dataList;
	}


	/**
	 * 查询已预约申请单
	 *
	 * @param qryDTO
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	private List<MtAppDTO> queryMtAptDoneApp(MtAppQryDTO qryDTO, String code_sctp) throws BizException {
		if (null == qryDTO) {
			return null;
		}
		if(qryDTO.getD_begin() == null){
			qryDTO.setD_begin(ScAppUtils.getServerDate());
		}
		String code_schhl = "";
		if(qryDTO.getCode_scchl() != null){
			code_schhl = qryDTO.getCode_scchl();
		}

		String deptId = qryDTO.getId_dep();

		FDateTime d_begin = null;
		FDateTime d_end = null;
		String sd_entps = null;
		if (StringUtil.isEmptyWithTrim(qryDTO.getId_pat()) || (IScDictCodeConst.SD_SCCHLTP_HOSPITAL_ALL.equals(code_schhl) && !StringUtil.isEmptyWithTrim(qryDTO.getId_pat()))) {
			d_begin = this.convertBeginDate(qryDTO.getD_begin());
			if(qryDTO.getD_end() == null){
				d_end = this.convertEndDate(qryDTO.getD_begin());
			}else{
			d_end = this.convertEndDate(qryDTO.getD_end());
			}
			sd_entps = ScSqlUtils.arrayToStr(this.getEnttpSelected(qryDTO));
		}

		if (StringUtil.isEmptyWithTrim(deptId)) {
			return null;
		}
		Map<String,Boolean> isMoreMap = new HashMap<String,Boolean>();
		isMoreMap.put("isMore", false);
		List<String> deptList = new ArrayList<String>();
		deptId = this.duplicateDeptId(deptId,isMoreMap,deptList);
		Boolean isMore = isMoreMap.get("isMore");
		StringBuffer sb = new StringBuffer();
		sb.append("select distinct ");
		sb.append("appl.id_aptappl as id_apt_appl,");//2018-5-21王鹏新增 预约申请id
		sb.append("apt.dt_appt,");//2018-5-21王鹏新增  预约日期
		sb.append("decode(sch.sd_tickmd,'03',substr(dt_b,12,5),to_char(apt.queno)) as  Queno_apt,");
		sb.append("apt.id_apt, ");
		sb.append("apt.id_scca, ");//add by yhl 2019/04/18
		sb.append("apt.id_scsrv,");//add by yhl 2019/04/18
		sb.append("appl.id_entp as id_enttp,");
		sb.append("appl.fg_hp,");//医保支付标识
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
		sb.append("appl.id_entp as id_enttp, ");
		sb.append("appl.id_srv, ");
		sb.append("appl.id_or, ");
		sb.append("appl.id_dep_mp, ");
		sb.append("appl.code_entp as sd_enttp, ");
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
		sb.append("case  when appl.fg_bl='Y' then '已收费' when appl.fg_bl='N' then '未收费'  when  appl.fg_bl is null then '未收费' end  name_bl ");
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
		sb.append("where ");
		sb.append("apt.fg_canc = 'N' ");
		if(qryDTO.getQrytype() != null &&qryDTO.getQrytype() != 3){
			if (!((IScDictCodeConst.SD_SCCHLTP_HOSPITAL_ROOM.equals(code_schhl) || IScDictCodeConst.SD_SCCHLTP_HOSPITAL_Triage.equals(code_schhl) ) &&  !StringUtil.isEmptyWithTrim(qryDTO.getId_pat()))) {
				if(isMore){
					sb.append("and mt.id_dep_mp in ("+ScSqlUtils.buildIdStr(deptList)+") ");
				}else{
					sb.append("and mt.id_dep_mp = ? ");
				}
			}
		}
		sb.append("and apt.sd_status in (?,?,?) ");
		if (StringUtil.isEmptyWithTrim(qryDTO.getId_pat()) || (IScDictCodeConst.SD_SCCHLTP_HOSPITAL_ALL.equals(code_schhl) && !StringUtil.isEmptyWithTrim(qryDTO.getId_pat()))) {
			sb.append("and apt.dt_appt >= ? ");
			sb.append("and apt.dt_appt <= ? ");
			sb.append("and appl.code_entp in (" + sd_entps + ") ");
		}
		if (!StringUtil.isEmptyWithTrim(qryDTO.getId_pat())) {
			sb.append("and appl.id_pi = ? ");
		}
		//空是医技
		if(StringUtil.isEmpty(code_sctp))
		{
			sb.append(String.format("and appl.sd_sctp = '%s' ", IScDictCodeConst.SD_SCTP_MT));
		}
		else
		{
			sb.append(String.format("and appl.sd_sctp = '%s' ", code_sctp));
		}
		// 集团管控
		sb.append(" and " + ScGroupControlUtils.getGroupControlFitler(new ScAptDO(), "apt"));
		SqlParam params = new SqlParam();
		if(qryDTO.getQrytype() != null &&qryDTO.getQrytype() != 3){
			if (!((IScDictCodeConst.SD_SCCHLTP_HOSPITAL_ROOM.equals(code_schhl) || IScDictCodeConst.SD_SCCHLTP_HOSPITAL_Triage.equals(code_schhl) ) &&  !StringUtil.isEmptyWithTrim(qryDTO.getId_pat()))) {
				if(isMore){
					//params.addParam(ScSqlUtils.buildIdStr(deptList));
				}else{
					params.addParam(deptId);
				}
			}
		}
		params.addParam(IScDictCodeConst.SD_APTSTATUS_ORDER);
		params.addParam(IScDictCodeConst.SD_APTSTATUS_PAY);
		params.addParam(IScDictCodeConst.SD_APTSTATUS_FINISH);

		if (StringUtil.isEmptyWithTrim(qryDTO.getId_pat()) || (IScDictCodeConst.SD_SCCHLTP_HOSPITAL_ALL.equals(code_schhl) && !StringUtil.isEmptyWithTrim(qryDTO.getId_pat()))) {
			params.addParam(d_begin);
			params.addParam(d_end);

		}
		if(!StringUtil.isEmpty(qryDTO.getId_pat())) {
			params.addParam(qryDTO.getId_pat());
		}
		// 查询
		List<MtAppDTO> appDTOList = (List<MtAppDTO>) new DAFacade().execQuery(sb.toString(), params,
				new BeanListHandler(MtAppDTO.class));

		//获取合单医嘱多条医嘱内容
		this.getContentOr(appDTOList);
		return appDTOList;
	}

	/**
	 * 获取选中的就诊类型
	 *
	 * @param qryDTO
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private String[] getEnttpSelected(MtAppQryDTO qryDTO) throws BizException {
		List<String> enttps = new ArrayList<String>();
		if (qryDTO.getFg_es().booleanValue()) {
			//enttps.add(IBdFcDictCodeConst.SD_CODE_ENTP_ES);// 出院留观
			enttps.add(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS);//急诊留观
		}
		if (qryDTO.getFg_et().booleanValue()) {
			enttps.add(IBdFcDictCodeConst.SD_CODE_ENTP_ET);// 急诊
		}
		if (qryDTO.getFg_ip().booleanValue()) {
			enttps.add(IBdFcDictCodeConst.SD_CODE_ENTP_IP);// 住院
			enttps.add(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE);//预住院
		}
		if (qryDTO.getFg_op().booleanValue()) {
			enttps.add(IBdFcDictCodeConst.SD_CODE_ENTP_OP);// 门诊
		}
		if (qryDTO.getFg_et_flow().booleanValue()) {
			enttps.add(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW);// 急诊流水
		}
		if (qryDTO.getFg_et_fstaid().booleanValue()) {
			enttps.add(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID);// 急诊抢救
		}
		return enttps.toArray(new String[0]);
	}

	/**
	 * 转换开始日期
	 *
	 * @author zhengcm
	 *
	 * @param date
	 * @return
	 * @throws BizException
	 */
	private FDateTime convertBeginDate(FDate date) throws BizException {
		return new FDateTime(date.toString().substring(0, 10) + " 00:00:00");
	}

	/**
	 * 转换结束日期
	 *
	 * @author zhengcm
	 *
	 * @param date
	 * @return
	 * @throws BizException
	 */
	private FDateTime convertEndDate(FDate date) throws BizException {
		return new FDateTime(date.toString().substring(0, 10) + " 23:59:59");
	}

	/**
	 * 部门id过多时去重
	 * @param deptId
	 * @return
	 */
	private String duplicateDeptId(String deptId,Map<String,Boolean> isMoreMap,List<String> rtnDeptList) {
		String[] deptIds = deptId.split(",");
		Map<String, String> map = new HashMap<String, String>();
		for (String dept_id : deptIds) {
			if (!map.containsKey(dept_id)) {
				map.put(dept_id, dept_id);
			}
		}
		List<String> deptList = new ArrayList<String>();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			deptList.add(entry.getKey());
		}
		String result = "";
		if (!ListUtil.isEmpty(deptList)) {
			for (String dept_id : deptList) {
				rtnDeptList.add(dept_id);
				result += dept_id + ",";
			}
			result = result.substring(0, result.length()-1);
			if(result.contains(",")){
				isMoreMap.put("isMore", true);
			}
			return result;
		}
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
