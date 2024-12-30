package iih.sc.apt.s.bp.ip;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.res.bed.d.Bdbed;
import iih.bd.res.bed.d.BedDTO;
import iih.bd.res.bed.i.IBedExtRService;
import iih.sc.apt.dto.d.BedQrySchmDTO;
import iih.sc.apt.dto.d.EuAptStatus;
import iih.sc.apt.s.bp.GetDeplNurBp;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScParamUtils;
import iih.sc.pub.ScGroupControlUtils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取床位集合BP
 * 
 * @author zhouliming
 * @modifier zhengcm 整理和规范
 * @modifier zhengcm 增加集团管控
 *
 */
public class GetBedListBP {
	/**
	 * 查询床位信息
	 * 
	 * @param qrySchmDTO
	 * @param pageInfo
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingRtnData<BedDTO> exec(BedQrySchmDTO qrySchmDTO, PaginationInfo pageInfo, String id_dep)
			throws BizException {
		if (qrySchmDTO == null) {
			return null;
		}
		PagingRtnData<BedDTO> pageBedDTO = new PagingRtnData<BedDTO>();
		PagingServiceImpl<BedDTO> service = new PagingServiceImpl();
		String sql = sqlString(qrySchmDTO, id_dep);// 查询床位sql

		SqlParam params = new SqlParam();
		if (StringUtils.isNotBlank(qrySchmDTO.getId_nur())) {
			params.addParam(qrySchmDTO.getId_nur());
		}
		if (StringUtils.isNotBlank(qrySchmDTO.getEu_appt()) && !qrySchmDTO.getEu_appt().equals(EuAptStatus.ALL)) {
			params.addParam(qrySchmDTO.getEu_appt());
		}
		// 床位费用-fanlq
		if (qrySchmDTO.getMin_bltpl() != null) {
			params.addParam(qrySchmDTO.getMin_bltpl());
		}
		if (qrySchmDTO.getMax_bltpl() != null) {
			params.addParam(qrySchmDTO.getMax_bltpl());
		}

		pageBedDTO = service.findByPageInfo(new BedDTO(), pageInfo, sql, "", params);
		// 调用接口显示床位费用，fanlq-2018.02.27
		// this.getBedPric(pageBedDTO);
		return pageBedDTO;
	}

	/**
	 * 查询床位信息sql
	 * 
	 * @param qrySchmDTO 查询模板
	 * @return
	 * @throws BizException
	 */
	public String sqlString(BedQrySchmDTO qrySchmDTO, String id_dep) throws BizException {
		if (qrySchmDTO == null) {
			return null;
		}
		// 通过懒加载，这里只查询主DO，前端选中后，如果未加载床位属性，调用床位的属性服务加载
		String id_nur = qrySchmDTO.getId_nur();// 病区
		String id_status = qrySchmDTO.getId_status();// 床位状态
		String eu_appt = qrySchmDTO.getEu_appt();// 预约状态
		FArrayList attrList = qrySchmDTO.getBedattrs();// 床位状态集合

		StringBuffer sb = new StringBuffer();
		sb.append("select bed.id_bed,bed.id_bedtp,bed.sd_bedtp, ");
		sb.append("bed.code,bed.name,doc.name as name_bedtp, ");
		sb.append("bed.id_dep_belong,depNur.name as name_dep_belong,bed.fg_appt, ");
		sb.append("bed.id_dep_use,dep.name as name_dep_use, ");
		sb.append("bed.id_bedsu,bed.sd_bedsu,bed.fg_act,docSu.Name as name_bedsu, ");
		sb.append("sexdoc.name as Name_sex,sexdoc.code as sd_sex,");// 床位性别，fanlq-2018-03-22
		sb.append("NVL(bedState.FG_WILLLV,'N') as FG_WILLLV,  ");
		sb.append("pritpl.price as Bed_pric "); // fanlq-add
		sb.append("from bd_bed bed ");
		sb.append("left join (SELECT ip.id_bed,CASE ");
		sb.append("WHEN COUNT(ID_ENTSTATE) > 0 THEN 'Y' ");
		sb.append("ELSE 'N' ");
		sb.append("END  FG_WILLLV ");
		sb.append("FROM EN_ENT_STATE STATE ");
		sb.append("left JOIN EN_ENT_IP IP  ON STATE.ID_ENT = IP.ID_ENT ");
		sb.append("WHERE STATE.SD_ENSTATETP = '" + IBdFcDictCodeConst.SD_ENSTATE_TOBEDISCHARGE + "' ");// 待出院
		sb.append("AND STATE.VAL = '1' ");// 待出院：是
		sb.append("and ip.sd_status ='" + IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN + "' ");// 就诊状态：住院入科
		sb.append("group by ip.id_bed) bedState ");
		sb.append("on bedState.id_bed = bed.id_bed ");
		sb.append("left join bd_udidoc doc on doc.id_udidoc = bed.id_bedtp ");
		sb.append("left join bd_udidoc docSu on docSu.id_udidoc = bed.id_bedsu ");
		sb.append("left join bd_dep depNur on depNur.Id_Dep = bed.id_dep_belong ");
		sb.append("left join bd_dep dep on dep.Id_Dep = bed.id_dep_use  ");
		sb.append("left join bd_udidoc sexdoc on sexdoc.id_udidoc = bed.id_bedsexlimit ");// 床位性别，fanlq-2018-03-22
		// sql连接查询显示床位费用，fanlq-2018.02.27
		sb.append("left join ( ");
		sb.append("select bltpl.id_bltpl, ");
		sb.append("sum(bltplitm.quan_medu * nvl(prisrv.price,0)) price ");
		sb.append("from bd_bltpl bltpl  ");
		sb.append("inner join bd_bltpl_itm bltplitm  on bltpl.id_bltpl = bltplitm.id_bltpl ");
		sb.append("left join bd_pri_srv prisrv on prisrv.dt_e = '2099-12-31 23:59:59'and bltplitm.id_srv = prisrv.id_srv ");
		sb.append("group by bltpl.id_bltpl ) pritpl ");
		sb.append("on bed.id_bltpl = pritpl.id_bltpl  ");

		sb.append("where bed.ds = 0 and bed.fg_act = 'Y' ");
		if (StringUtils.isNotBlank(id_nur)) {
			sb.append("and bed.id_dep_belong = ? ");// 病区
		}
		if (attrList != null && attrList.size() != 0) {
			for (int i = 0; i < attrList.size(); i++) {
				// 床位属性查询时是且的关系 changed by zhengcm 2017-03-23
				String attr = attrList.get(i).toString();
				String[] attrVal = attr.split(",");
				sb.append("and bed.id_bed in ");
				sb.append("(SELECT ID_BED FROM BD_BED_ATTR ");
				sb.append("WHERE 1=1 ");
				sb.append("AND ID_BEDATTR_TP = '" + attrVal[0] + "' AND VAL = '" + attrVal[1] + "') ");
			}
		}
		if (StringUtils.isNotBlank(id_status)) {
			String status = getSplitString(id_status);
			sb.append("and bed.id_bedsu in ( " + status + ") ");// 床位状态
		}
		if (StringUtils.isNotBlank(eu_appt) && !eu_appt.equals(EuAptStatus.ALL)) {
			sb.append(" and bed.fg_appt = ? ");// 预约标志
		}
		if (StringUtils.isNotBlank(id_dep)) {
			GetDeplNurBp bp = new GetDeplNurBp();
			String depNurList = bp.exec(id_dep);
			if (StringUtils.isNotBlank(depNurList)) {
				sb.append("and id_dep_belong in " + depNurList + " ");// 所属病区
			}
		}
		// 床位费用-fanlq
		if (qrySchmDTO.getMin_bltpl() != null) {
			sb.append("and pritpl.price >= ? ");
		}
		if (qrySchmDTO.getMax_bltpl() != null) {
			sb.append("and pritpl.price <= ? ");
		}

		// 集团管控
		sb.append(" and " + ScGroupControlUtils.getGroupControlFitler(new Bdbed(), "bed"));

		// 没有全院住院预约权限用户只能约直接管理的床位，fanlq-2018.03.22
		String psnId = ScContextUtils.getPsnId();
		Boolean canApt = ScParamUtils.canApptIpHospital();
		if (!canApt) {
			sb.append("and bed.id_bed in ( ");
			sb.append("select id_bed from bd_wg_bed wgbed ");
			sb.append("inner join bd_emp_wg empwg on wgbed.id_wg = empwg.id_wg ");
			sb.append("inner join bd_wg wg on wg.id_wg = empwg.id_wg ");
			sb.append(" where empwg.id_emp = '" + psnId + "' and wg.fg_active ='Y' ");
			if (StringUtils.isNotBlank(id_dep)) {
				sb.append(" and wg.id_dep = '"+id_dep+"'");// 所属病区
			}
			sb.append(")");
		}
		//待出院和正常在院，fanlq-2018-07-02
		if (StringUtils.isNotBlank(id_status) && id_status.contains(IBdResDictCodeConst.ID_BEDSU_USEDBYPATIENT)) {
			if(FBoolean.TRUE.equals(qrySchmDTO.getFg_ip_will()) && FBoolean.TRUE.equals(qrySchmDTO.getFg_ip())){
						sb.append("and ( bedState.FG_WILLLV = 'Y' or exists (select ip.id_bed from en_ent_ip ip "
								+ "where ip.id_bed = bed.id_bed and ip.sd_status = '25') "+this.getMorStatusSql(id_status)+") ");
			}else{
				if(qrySchmDTO.getFg_ip_will() != null && FBoolean.TRUE.equals(qrySchmDTO.getFg_ip_will())){
					sb.append("and (bedState.FG_WILLLV = 'Y' "+this.getMorStatusSql(id_status)+")");
				}
				if(qrySchmDTO.getFg_ip() != null && FBoolean.TRUE.equals(qrySchmDTO.getFg_ip())){
					sb.append(" and (exists (select ip.id_bed from en_ent_ip ip left join EN_ENT_STATE STATE ON STATE.ID_ENT = IP.ID_ENT where ip.id_bed = bed.id_bed "
							+ " and ip.sd_status = '25' and  STATE.Sd_Enstatetp <> '21') "+this.getMorStatusSql(id_status)+") AND bedState.FG_WILLLV IS NULL ");
				}
			}
		}
		sb.append("order by bed.code");
		return sb.toString();
	}

	/****
	 * 获取不包含有人状态的SQL
	 * @param id_status
	 * @return
	 */
	private String getMorStatusSql(String id_status){
		if (StringUtils.isNotBlank(id_status) && id_status.contains(IBdResDictCodeConst.ID_BEDSU_USEDBYPATIENT)) {
			String status = getSplitString(id_status);
			String sql = " or (bed.id_bedsu in ( " + status + ") and bed.id_bedsu not in ('"+IBdResDictCodeConst.ID_BEDSU_USEDBYPATIENT+"') )";
			return sql;
		}
		return "";
	}
	/**
	 * 分割字符串
	 * 
	 * @param str
	 * @return
	 */
	public String getSplitString(String str) {
		if (str == null) {
			return null;
		}
		String strSplit = "";
		String[] strs = str.split(",");
		for (int i = 0; i < strs.length; i++) {
			strSplit += (i == 0 ? "" : ",") + "'" + strs[i] + "'";
		}
		return strSplit;
	}

	/***
	 * 获取床位费用，fanlq-2018.02.27
	 * 
	 * @param pageBedDTO
	 * @return
	 * @throws BizException
	 */
	public void getBedPric(PagingRtnData<BedDTO> pageBedDTO) throws BizException {
		FArrayList flist = pageBedDTO.getPageData();
		List<String> list = new ArrayList<String>();
		if (flist.isEmpty())
			return;
		for (Object obj : flist) {
			BedDTO item = (BedDTO) obj;
			if (!StringUtil.isEmptyWithTrim(item.getId_bed())) {
				list.add(item.getId_bed());
			}
		}
		IBedExtRService service = ServiceFinder.find(IBedExtRService.class);
		String[] id_beds = list.toArray(new String[0]);
		FMap2 bedPriMap = service.findBedPriMapByIds(id_beds);
		if (bedPriMap == null || bedPriMap.size() <= 0)
			return;
		else {
			for (Object obj : flist) {
				BedDTO item = (BedDTO) obj;
				if (!StringUtil.isEmptyWithTrim(item.getId_bed())) {
					item.setBed_pric(bedPriMap.get(item.getId_bed()).toString());
				}
			}
		}
	}

}
