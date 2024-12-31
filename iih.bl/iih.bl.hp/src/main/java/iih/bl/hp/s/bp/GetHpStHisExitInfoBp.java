package iih.bl.hp.s.bp;
/** 获取医保结算HIS有医保无的数据
 * @author shaokx
 * @date 2018-10-17
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.hpmedkindah.d.HpMedKindAhDO;
import iih.bd.pp.hpmedkindah.i.IHpmedkindahRService;
import iih.bl.hp.dto.d.BlStBalanceDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetHpStHisExitInfoBp {

	public BlStBalanceDTO[] exec(BlStBalanceDTO[] miInfoList, String dt_b, String dt_e, String enttp)
			throws BizException {

		if (ArrayUtil.isEmpty(miInfoList)) {
			throw new BizException("请先下载数据或者调整开始结束时间");
		}

		// 1、根据enttp和医保类别对下载的数据进行分类
		List<BlStBalanceDTO> classMiInfoList = GetClassMiInfoList(miInfoList, enttp);

		if(ListUtil.isEmpty(classMiInfoList)){
			return null;
		}
		
		List<String> hpinfoList = new ArrayList();
		// 2.下载的医保集合分类后提取出单据号并且拼接sql的in格式
		for (BlStBalanceDTO itm : classMiInfoList) {
			hpinfoList.add(itm.getRcpt_no());
		}

		// not in查询条件
		String inQry = SqlUtils.getNotInSqlByBigIds("Code_st", hpinfoList.toArray(new String[] {}));

		// 3.拼sql获得HiS区别于医保独有的数据-单据号字段
		List<BlStBalanceDTO> sqlQryList = this.GetSqlQryInfo(inQry, dt_b, dt_e);

		// 4.根据第二步的单据号查出查出所对应的BlStBalanceDTO其余字段
		List<BlStBalanceDTO> hisExitList = this.GetHisExitInfo(sqlQryList);

		return hisExitList.toArray(new BlStBalanceDTO[] {});
	}

	/**
	 * 根据enttp和医保类别对下载的数据进行分类
	 * 
	 * @return
	 * @throws BizException
	 */
	private List<BlStBalanceDTO> GetClassMiInfoList(BlStBalanceDTO[] miInfoList, String enttp) throws BizException {
		// 下载后的数据分类后的集合
		List<BlStBalanceDTO> classMiInfoList = new ArrayList();
		IHpmedkindahRService iHpMedKindRService = ServiceFinder.find(IHpmedkindahRService.class);
		HpMedKindAhDO[] hpMedKindDOs = iHpMedKindRService.find(" 1=1 ", null, FBoolean.FALSE);

		if (ArrayUtil.isEmpty(hpMedKindDOs)) {
			throw new BizException("请联系管理员维护医疗类别");
		}
		// 分类核心逻辑
		if ("11".equals(enttp)) {
			classMiInfoList.addAll(Arrays.asList(miInfoList));
		} else if ("00".equals(enttp)) {
			for (BlStBalanceDTO itm : miInfoList) {
				for (HpMedKindAhDO childItm : hpMedKindDOs) {
					if (itm.getCode_medkind().equals(childItm.getCode())) {
						if (childItm.getFg_op() != null && childItm.getFg_op().booleanValue()) {
							classMiInfoList.add(itm);
							break;
						} else {
							continue;
						}
					} else {
						continue;
					}
				}
			}
		} else if ("10".equals(enttp)) {
			for (BlStBalanceDTO itm : miInfoList) {
				for (HpMedKindAhDO childItm : hpMedKindDOs) {
					if (itm.getCode_medkind().equals(childItm.getCode())) {
						if (childItm.getFg_ip() != null && childItm.getFg_ip().booleanValue()) {
							classMiInfoList.add(itm);
							break;
						} else {
							continue;
						}
					} else {
						continue;
					}
				}
			}
		}

//		if (ListUtil.isEmpty(classMiInfoList)) {
//			throw new BizException("医保类别表维护错误，请联系管理员正确维护");
//		}

		return classMiInfoList;
	}

	/**
	 * sql查询获得最终His有的所有字段
	 * 
	 * @return
	 * @throws BizException
	 */
	public List<BlStBalanceDTO> GetSqlQryInfo(String inQry, String dt_b, String dt_e) throws BizException {
		StringBuffer sb = new StringBuffer();
		sb.append(" select ");
		sb.append(" code_st Rcpt_no");
		sb.append(" from ");
		sb.append(" bl_st_oep ");
		sb.append(" where 1=1 and eu_direct <> -1 ");
		if (inQry != null) {
			sb.append("and " + inQry + " ");
		}
		if (dt_b != null) {
			sb.append("and dt_st >= ?");
		}
		if (dt_e != null) {
			sb.append(" and dt_st <= ? ");
		}
		sb.append(" union all ");
		sb.append(" select ");
		sb.append(" code_st Rcpt_no");
		sb.append(" from ");
		sb.append(" bl_st_ip ");
		sb.append(" where 1=1 and eu_direct <> -1 ");
		if (inQry != null) {
			sb.append(" and " + inQry + " ");
		}
		if (dt_b != null) {
			sb.append("and dt_st >= ?");
		}
		if (dt_e != null) {
			sb.append(" and dt_st <= ? ");
		}

		// 对占位符的赋值
		SqlParam sp = new SqlParam();
		if (dt_b != null) {
			sp.addParam(dt_b);
		}
		if (dt_e != null) {
			sp.addParam(dt_e);
		}
		if (dt_b != null) {
			sp.addParam(dt_b);
		}
		if (dt_e != null) {
			sp.addParam(dt_e);
		}

		// 执行sql语句
		@SuppressWarnings("unchecked")
		List<BlStBalanceDTO> list = (List<BlStBalanceDTO>) new DAFacade().execQuery(sb.toString(), sp,
				new BeanListHandler(BlStBalanceDTO.class));

		if (ListUtil.isEmpty(list)) {
			list = new ArrayList<BlStBalanceDTO>();
		}

		return list;
	}

	/**
	 * 根据第二步的单据号查出查出所对应的BlStBalanceDTO其余字段
	 * 
	 * @param sqlQryList
	 * @return
	 * @throws BizException
	 */
	public List<BlStBalanceDTO> GetHisExitInfo(List<BlStBalanceDTO> sqlQryList) throws BizException {
		List<String> list = new ArrayList();
		for (BlStBalanceDTO itm : sqlQryList) {
			list.add(itm.getRcpt_no());
		}

		// 1.获得in查询条件
		String inOepQry = SqlUtils.getInSqlByIds("stoep.code_st", list);
		String inIpQry = SqlUtils.getInSqlByIds("stip.code_st", list);
		// 2.通过sql查出最后的结果
		StringBuffer sb = new StringBuffer();
		sb.append(" select ");
		sb.append(" llmioep.code_hosp hoscode, ");
		sb.append(" llmioep.code_ent regno, ");
		sb.append(" stoep.code_st rcpt_no,  ");
		sb.append(" llmioep.personcode,  ");
		sb.append(" llmioep.code_medkind code_medkind, ");
		sb.append(" llmioep.code_hppatca name_hppatca, ");
		sb.append(" llmioep.amt_all, ");
		sb.append(" llmioep.amt_hp, ");
		sb.append(" llmioep.amt_psn, ");
		sb.append(" llmioep.amt_cash, ");
		sb.append(" llmioep.amt_seriousill, ");
		sb.append(" llmioep.amt_civilservice, ");
		sb.append(" psn.name id_emp_opr, ");
		sb.append(" stoep.dt_st ");
		sb.append(" from bl_st_oep stoep ");
		sb.append(" inner join bl_prop_oep propoep on propoep.id_stoep = stoep.id_stoep ");
		sb.append(" inner join bl_prop_ar_oep proparoep on proparoep.id_propoep = propoep.id_propoep ");
		sb.append(" inner join mi_prop_aroep_lyneusoft llmioep on llmioep.id_proparoep = proparoep.id_proparoep ");
		sb.append(" inner join bd_hp hp on hp.id_hp = proparoep.id_hp ");
		sb.append(" left join bd_psndoc psn on psn.id_psndoc = stoep.id_emp_st ");
		sb.append(" where 1=1 ");
		if (inOepQry != null) {
			sb.append(" and " + inOepQry + " ");
		}
		sb.append(" union all ");
		sb.append(" select ");
		sb.append(" llmiip.code_hosp hoscode, ");
		sb.append(" llmiip.code_ent regno, ");
		sb.append(" stip.code_st rcpt_no, ");
		sb.append(" llmiip.personcode, ");
		sb.append(" llmiip.code_medkind code_medkind, ");
		sb.append(" llmiip.code_hppatca name_hppatca, ");
		sb.append(" llmiip.amt_all,");
		sb.append(" llmiip.amt_hp, ");
		sb.append(" llmiip.amt_psn, ");
		sb.append(" llmiip.amt_cash, ");
		sb.append(" llmiip.amt_seriousill, ");
		sb.append(" llmiip.amt_civilservice,  ");
		sb.append(" psn.name id_emp_opr,  ");
		sb.append(" stip.dt_st ");
		sb.append(" from bl_st_ip stip ");
		sb.append(" inner join bl_prop_ip propip on propip.id_stip = stip.id_stip ");
		sb.append(" inner join bl_prop_ar_ip proparip on proparip.id_propip = propip.id_propip ");
		sb.append(" inner join mi_prop_arip_lyneusoft llmiip on llmiip.id_proparip = proparip.id_proparip ");
		sb.append(" inner join bd_hp hp on hp.id_hp = proparip.id_hp ");
		sb.append(" left join bd_psndoc psn on psn.id_psndoc = stip.id_emp_st ");
		sb.append(" where 1=1 ");
		if (inIpQry != null) {
			sb.append(" and " + inIpQry + " ");
		}

		SqlParam sp = new SqlParam();

		List<BlStBalanceDTO> finalList = (List<BlStBalanceDTO>) new DAFacade().execQuery(sb.toString(), sp,
				new BeanListHandler(BlStBalanceDTO.class));
		if (ListUtil.isEmpty(list)) {
			finalList = new ArrayList<BlStBalanceDTO>();
		}
		return finalList;
	}
}
