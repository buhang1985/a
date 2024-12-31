package iih.bl.hp.s.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.hpmedkindah.d.HpMedKindAhDO;
import iih.bd.pp.hpmedkindah.i.IHpmedkindahRService;
import iih.bl.hp.dto.d.BlStBalanceDTO;
import iih.bl.hp.dto.d.CostSettlementQueryDTO;

/**
 * 获取医保有HIS无的信息
 * 
 * @author shaokx
 */
public class GetHpExitInfoBp {

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
		
		// 2.sql查询出医保和HIS都有的数据
		List<BlStBalanceDTO> exitList = this.getExitInfo(classMiInfoList.toArray(new BlStBalanceDTO[]{}), dt_b, dt_e);
		
		// 3.医保下载的数据排除第2步的数据就是医保有HIS无的数据
		List<BlStBalanceDTO> finalList = new ArrayList();
		
		// 4.判断医保和his没有相同的情况
		if (exitList.size() == 0) {
			finalList.addAll(classMiInfoList);
		} else {
			for (BlStBalanceDTO itm : classMiInfoList) {
				for (int i = 0; i < exitList.size(); i++) {
					if (itm.getRcpt_no().equals(exitList.get(i).getRcpt_no())) {
						break;
					}
					if (!itm.getRcpt_no().equals(exitList.get(i).getRcpt_no()) && i == exitList.size() - 1) {
						finalList.add(itm);
					}
				}
			}
		}
		
		return finalList.toArray(new BlStBalanceDTO[] {});
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
	 * sql查询出医保和HIS都有的数据
	 * 
	 * @return
	 * @throws BizException
	 */
	public List<BlStBalanceDTO> getExitInfo(BlStBalanceDTO[] miInfoList, String dt_b, String dt_e) throws BizException {
		// 1.获得in查询条件
		List<String> inList = new ArrayList();
		for (BlStBalanceDTO itm : miInfoList) {
			inList.add(itm.getRcpt_no());
		}
		String inQry = SqlUtils.getInSqlByIds("Code_st", inList.toArray(new String[] {}));
		// 开始sql
		StringBuffer sb = new StringBuffer();
		sb.append(" select ");
		sb.append(" code_st Rcpt_no");
		sb.append(" from ");
		sb.append(" bl_st_oep ");
		sb.append(" where 1=1 and eu_direct <> -1 ");
		if (inQry != null) {
			sb.append(" and " + inQry + " ");
		}
		if (dt_b != null) {
			sb.append(" and dt_st >= ? ");
		}
		if (dt_e != null) {
			sb.append(" and dt_st <= ?");
		}
		sb.append(" union all ");
		sb.append(" select ");
		sb.append(" code_st Rcpt_no ");
		sb.append(" from ");
		sb.append(" bl_st_ip ");
		sb.append(" where 1=1 and eu_direct <> -1 ");
		if (inQry != null) {
			sb.append(" and " + inQry + " ");
		}
		if (dt_b != null) {
			sb.append(" and dt_st >= ? ");
		}
		if (dt_e != null) {
			sb.append(" and dt_st <= ?");
		}

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

		List<BlStBalanceDTO> list = (List<BlStBalanceDTO>) new DAFacade().execQuery(sb.toString(), sp,
				new BeanListHandler(BlStBalanceDTO.class));

		if (ListUtil.isEmpty(list)) {
			list = new ArrayList<BlStBalanceDTO>();
		}
		return list;
	}
}
