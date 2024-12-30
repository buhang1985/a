package iih.sc.apt.s.bp.oral;

import iih.bd.bc.udi.pub.IScDictCodeTypeConst;
import iih.sc.apt.dto.d.OralAptMgrDTO;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.comm.ScValidator;
import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scp.scplan.d.EuEditTp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

/**
 * 获取口腔预约列表
 * 
 * @author Administrator
 * @modifier zhengcm 增加集团管控
 *
 */
public class GetOralAptListBP {

	private static Map<String, String> map = new HashMap<>();

	/**
	 * 获取口腔预约列表
	 * 
	 * @param pg 分页对象
	 * @param qryDTO 查询方案
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<OralAptMgrDTO> exec(PaginationInfo pg, QryRootNodeDTO qryDTO) throws BizException {
		if (pg == null) {
			return new PagingRtnData<OralAptMgrDTO>();
		}
		StringBuilder sb = new StringBuilder();
		SqlParam param = new SqlParam();
		this.initSql(qryDTO, sb, param);
		Logger.info(sb.toString());
		PagingRtnData<OralAptMgrDTO> rtnData = this.getRtnData(pg, sb.toString(), param);
		this.proccessRtnData(rtnData);
		return rtnData;
	}

	/**
	 * 获取OralAptMgrDTO
	 * 
	 * @param aptId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public OralAptMgrDTO exec(String aptId) throws BizException {
		StringBuilder sb = new StringBuilder(getBaseSql());
		sb.append("WHERE SC_APT.ID_APT = ? ");
		SqlParam param = new SqlParam();
		param.addParam(aptId);
		List<OralAptMgrDTO> list = (List<OralAptMgrDTO>) new DAFacade().execQuery(sb.toString(), param,
				new BeanListHandler(OralAptMgrDTO.class));
		if (!ListUtil.isEmpty(list)) {
			this.proccessAptMgr(list);
			return list.get(0);
		}
		return null;
	}

	/**
	 * 查询数据
	 * 
	 * @param pg
	 * @param sql
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<OralAptMgrDTO> getRtnData(PaginationInfo pg, String sql, SqlParam param) throws BizException {
		PagingServiceImpl<OralAptMgrDTO> pageQryService = new PagingServiceImpl<OralAptMgrDTO>();
		return pageQryService.findByPageInfo(new OralAptMgrDTO(), pg, sql, "DT_B,APT_CODE", param);
	}

	/**
	 * 根据查询条件初始化SQL语句
	 * 
	 * @param qryDTO
	 * @param sb
	 * @param param
	 * @throws BizException
	 */
	private void initSql(QryRootNodeDTO qryDTO, StringBuilder sb, SqlParam param) throws BizException {
		sb.append("SELECT * FROM (");
		sb.append(this.getBaseSql());
		sb.append(") SC_APT WHERE 1 = 1 ");
		// 集团管控
		sb.append(" AND " + ScGroupControlUtils.getGroupControlFitler(new ScAptDO(), "SC_APT"));
		IQrySQLGeneratorService serv = ServiceFinder.find(IQrySQLGeneratorService.class);
		String whereSql = serv.getQueryStringWithDOName(qryDTO, OralAptMgrDTO.class.getName());
		if (!ScValidator.isEmptyIgnoreBlank(whereSql)) {
			sb.append(String.format(" AND %s", whereSql));
		}

		// 医保卡号
		FArrayList list = serv.getQueryFieldValue(qryDTO, "pat_hpnum");
		String value = this.getFArray2Str(list);
		if (!ScValidator.isEmptyIgnoreBlank(value)) {
			sb.append(" AND ID_PAT IN (SELECT DISTINCT HP.ID_PAT FROM PI_PAT_HP HP WHERE HP.NO_HP = ? ) ");
			param.addParam(value);
		}

		// //预约号
		// FArrayList list = serv.getQueryFieldValue(qryDTO, "apt_code");
		// String value = this.getFArray2Str(list);
		// if(!ScValidator.isEmptyIgnoreBlank(value)){
		// sb.append("AND SC_APT.CODE = ? ");
		// param.addParam(value);
		// }
		// //患者
		// list = serv.getQueryFieldValue(qryDTO, "id_pat");
		// value = this.getFArray2Str(list);
		// if(!ScValidator.isEmptyIgnoreBlank(value)){
		// sb.append("AND SC_APT.ID_PAT = ? ");
		// param.addParam(value);
		// }
		// //患者电话
		// list = serv.getQueryFieldValue(qryDTO, "pat_tel");
		// value = this.getFArray2Str(list);
		// if(!ScValidator.isEmptyIgnoreBlank(value)){
		// sb.append("AND NVL(PI_PAT.MOB, PI_PAT.TEL) = ? ");
		// param.addParam(value);
		// }
		// //证件号码
		// list = serv.getQueryFieldValue(qryDTO, "pat_documentnum");
		// value = this.getFArray2Str(list);
		// if(!ScValidator.isEmptyIgnoreBlank(value)){
		// sb.append("AND PI_PAT.ID_CODE = ? ");
		// param.addParam(value);
		// }
		// //医保卡号
		// list = serv.getQueryFieldValue(qryDTO, "pat_hpnum");
		// value = this.getFArray2Str(list);
		// if(!ScValidator.isEmptyIgnoreBlank(value)){
		// sb.append("AND SC_APT.ID_PAT IN (SELECT DISTINCT HP.ID_PAT FROM PI_PAT_HP HP WHERE HP.NO_HP = ? ) ");
		// param.addParam(value);
		// }
	}

	private String getFArray2Str(FArrayList list) {
		String res = null;
		if (list != null && !list.isEmpty()) {
			if (list.get(0) instanceof String) {
				res = (String) list.get(0);
			}
		}
		return res;
	}

	/**
	 * 处理查询结果
	 * 
	 * @param rtnData
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void proccessRtnData(PagingRtnData<OralAptMgrDTO> rtnData) throws BizException {
		if (rtnData == null)
			return;
		FArrayList list = rtnData.getPageData();
		if (ListUtil.isEmpty(list)) {
			return;
		}
		// if(map.isEmpty()){
		// IUdidocServiceExt serv = ServiceFinder.find(IUdidocServiceExt.class);
		// UdidocDO[] docs =
		// serv.findByUdidoclistCode(IScDictCodeTypeConst.SD_STATUS_TP);
		// if(!ScValidator.isNullOrEmpty(docs)){
		// for(UdidocDO doc : docs)
		// map.put(doc.getCode(), doc.getName());
		// }
		// }
		for (Object obj : list) {
			if (!(obj instanceof OralAptMgrDTO))
				continue;
			OralAptMgrDTO apt = (OralAptMgrDTO) obj;
			apt.setPat_age(AgeCalcUtil.getAge(apt.getPat_birth()));
			// if(!ScValidator.isEmptyIgnoreBlank(apt.getSd_status()) &&
			// !map.isEmpty())
			// apt.setStatus_name(map.get(apt.getSd_status()));
			// 如果取消预约人员名称为tokenX，则显示对应渠道的名称 add by zhengcm 2018-01-03
			if (!StringUtil.isEmptyWithTrim(apt.getName_emp_canc())
					&& apt.getName_emp_canc().toUpperCase().startsWith("TOKEN")) {
				apt.setName_emp_canc(apt.getName_scchl());
			}
		}
	}

	/**
	 * 处理查询结果
	 * 
	 * @param rtnData
	 * @throws BizException
	 */
	private void proccessAptMgr(List<OralAptMgrDTO> aptList) throws BizException {
		if (ListUtil.isEmpty(aptList))
			return;
		if (map.isEmpty()) {
			IUdidocServiceExt serv = ServiceFinder.find(IUdidocServiceExt.class);
			UdidocDO[] docs = serv.findByUdidoclistCode(IScDictCodeTypeConst.SD_STATUS_TP);
			if (!ScValidator.isNullOrEmpty(docs)) {
				for (UdidocDO doc : docs)
					map.put(doc.getCode(), doc.getName());
			}
		}
		for (OralAptMgrDTO apt : aptList) {
			apt.setPat_age(AgeCalcUtil.getAge(apt.getPat_birth()));
			if (!ScValidator.isEmptyIgnoreBlank(apt.getSd_status()) && !map.isEmpty())
				apt.setStatus_name(map.get(apt.getSd_status()));
		}
	}

	/**
	 * 得到基础的Sql语句
	 * 
	 * @return
	 */
	private String getBaseSql() {
		StringBuilder sb = new StringBuilder();
		// sb.append("SELECT SC_APT.ID_APT AS ID_APT,");
		// sb.append("SC_APT.CODE AS APT_CODE,");
		// sb.append("SC_APT.ID_STATUS AS ID_STATUS,");
		// sb.append("SC_APT.SD_STATUS AS SD_STATUS,");
		// sb.append("SC_APT.DT_B AS DT_B,");
		// sb.append("SC_APT.DT_B AS DT_APT,");
		// sb.append("SC_APT.DT_E AS DT_E,");
		// sb.append("SC_APT_OP_ORAL.ID_PROC_ORAL AS ID_PROC_ORAL,");
		// sb.append("SC_APT_OP_ORAL.SD_PROC_ORAL AS SD_PROC_ORAL,");
		// sb.append("SC_APT_OP_ORAL.NAME_PROC_ORAL AS NAME_PROC_ORAL,");
		// sb.append("SC_APT_OP_ORAL.D_NEXT_APPT AS D_NEXT_APPT,");
		// sb.append("SC_APT_OP_ORAL.NOTE_NEXT AS NOTE_NEXT,");
		// sb.append("SC_APT_OP_ORAL.ID_STATUSTAG AS ID_STATUSTAG,");
		// sb.append("SC_APT_OP_ORAL.SD_STATUSTAG AS SD_STATUSTAG,");
		// sb.append("TAG.NAME AS STATUSTAG_NAME,");
		// sb.append("PI_PAT.ID_PAT AS PI_PAT,");
		// sb.append("PI_PAT.CODE AS PAT_CODE,");
		// sb.append("PI_PAT.NAME AS PAT_NAME,");
		// sb.append("SEX.NAME AS PAT_SEX,");
		// sb.append("PI_PAT.DT_BIRTH AS PAT_BIRTH,");
		// sb.append("NVL(PI_PAT.MOB, PI_PAT.TEL) AS PAT_TEL,");
		// sb.append("PI_PAT.ID_CODE AS PAT_DOCUMENTNUM,");
		// sb.append("SC_APT.ID_SCRES AS ID_RES,");
		// sb.append("SC_RES.NAME AS RES_NAME  ");
		// sb.append("FROM SC_APT SC_APT ");
		// sb.append("INNER JOIN SC_APT_OP SC_APT_OP ON SC_APT.ID_APT = SC_APT_OP.ID_APT ");
		// sb.append("INNER JOIN SC_APT_OP_ORAL SC_APT_OP_ORAL ON SC_APT.ID_APT = SC_APT_OP_ORAL.ID_APT ");
		// sb.append("INNER JOIN PI_PAT PI_PAT ON SC_APT.ID_PAT = PI_PAT.ID_PAT ");
		// sb.append("LEFT JOIN SC_RES SC_RES ON SC_APT.ID_SCRES = SC_RES.ID_SCRES ");
		// sb.append("LEFT JOIN BD_UDIDOC SEX ON PI_PAT.ID_SEX = SEX.ID_UDIDOC ");
		// sb.append("LEFT JOIN BD_UDIDOC TAG ON SC_APT_OP_ORAL.ID_STATUSTAG = TAG.ID_UDIDOC ");
		sb.append("SELECT SC_APT.ID_APT AS ID_APT,");
		sb.append("SC_APT.ID_ORG,");
		sb.append("SC_APT.ID_GRP,");
		sb.append("pl.id_scpl,");
		sb.append("pl.name as name_scpl,");
		sb.append("pl.id_dep as id_dept,");// add by zhengcm 2018-01-29
		sb.append("SC_APT.CODE AS APT_CODE,");
		sb.append("SC_APT.ID_PAT AS ID_PAT,");
		sb.append("PI_PAT.BARCODE_CHIS AS PAT_CODE,");// 患者条码
		sb.append("PI_PAT.NAME AS PAT_NAME,");
		sb.append("U_SEX.NAME AS PAT_SEX,");
		sb.append("PI_PAT.MOB AS PAT_TEL,");
		sb.append("PI_PAT.ID_CODE AS PAT_DOCUMENTNUM,");
		sb.append("PI_PAT.DT_BIRTH AS PAT_BIRTH,");
		sb.append("U_PROC.ID_UDIDOC AS ID_PROC_ORAL,");
		sb.append("U_PROC.CODE AS SD_PROC_ORAL,");
		// sb.append("U_PROC.NAME AS NAME_PROC_ORAL,");
		sb.append("CASE WHEN U_PROC.CODE IS NULL THEN SC_APT_OP_ORAL.NAME_PROC_ORAL ELSE U_PROC.NAME END AS NAME_PROC_ORAL,");
		sb.append("SC_APT.DT_APPT AS DT_APT,");
		sb.append("SUBSTR(SC_APT.DT_B,0,10) AS D_B,");// 预约就诊日期
		sb.append("SC_APT.DT_B AS DT_B,");
		sb.append("SC_APT.DT_E AS DT_E,");
		sb.append("SC_RES.ID_SCRES AS ID_RES,");
		sb.append("SC_RES.NAME AS RES_NAME,");
		sb.append("SC_APT.ID_EMP_CANC,");// 取消人员
		sb.append("PSN.NAME AS NAME_EMP_CANC,");// 取消人员
		sb.append("SC_APT.DT_CANC,");// 取消时间
		sb.append("SC_APT_OP_ORAL.D_NEXT_APPT AS D_NEXT_APPT,");
		sb.append("SC_APT_OP_ORAL.NOTE_NEXT AS NOTE_NEXT,");
		sb.append("U_STATUS.ID_UDIDOC AS ID_STATUS,");
		sb.append("U_STATUS.CODE AS SD_STATUS,");
		sb.append("U_STATUS.NAME AS STATUS_NAME,");
		sb.append("U_STATUSTAG.ID_UDIDOC AS ID_STATUSTAG,");
		sb.append("U_STATUSTAG.CODE AS SD_STATUSTAG,");
		sb.append("U_STATUSTAG.NAME AS STATUSTAG_NAME,");
		sb.append("chl.name as name_scchl ");
		sb.append(" FROM SC_APT  ");
		sb.append(" inner join sc_sch sch on sch.id_sch = sc_apt.id_sch ");
		sb.append(" inner join sc_pl pl on pl.id_scpl = sch.id_scpl and pl.eu_edit_tp = '" + EuEditTp.ORALSPEC + "' ");
		sb.append("inner join sc_chl chl on chl.id_scchl = sc_apt.id_scchl ");
		sb.append(" INNER JOIN PI_PAT ");
		sb.append(" ON PI_PAT.ID_PAT = SC_APT.ID_PAT ");
		sb.append(" LEFT JOIN SC_APT_OP_ORAL ");
		sb.append(" ON SC_APT.ID_APT = SC_APT_OP_ORAL.ID_APT");
		sb.append(" LEFT JOIN BD_UDIDOC U_SEX ");
		sb.append(" ON U_SEX.ID_UDIDOC = PI_PAT.ID_SEX ");
		sb.append(" LEFT JOIN BD_UDIDOC U_PROC ");
		sb.append(" ON U_PROC.ID_UDIDOC = SC_APT_OP_ORAL.ID_PROC_ORAL ");
		sb.append(" LEFT JOIN SC_RES ");
		sb.append(" ON SC_RES.ID_SCRES = SC_APT.ID_SCRES ");
		sb.append(" LEFT JOIN BD_UDIDOC U_STATUS ");
		sb.append(" ON U_STATUS.ID_UDIDOC = SC_APT.ID_STATUS ");
		sb.append(" LEFT JOIN BD_UDIDOC U_STATUSTAG ");
		sb.append(" ON U_STATUSTAG.ID_UDIDOC = SC_APT_OP_ORAL.ID_STATUSTAG ");
		sb.append(" LEFT JOIN BD_PSNDOC PSN ON PSN.ID_PSNDOC = SC_APT.ID_EMP_CANC ");// 人员档案
		return sb.toString();
	}
}
