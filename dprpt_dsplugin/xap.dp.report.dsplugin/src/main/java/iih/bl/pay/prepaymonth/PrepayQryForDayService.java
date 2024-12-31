package iih.bl.pay.prepaymonth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.software.comm.util.ListUtil;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/***
 * 患者预交金账户期初期末查询（以天为单位）（门诊预交金）
 * 
 * @author shaokx 2019.09.23
 */
public class PrepayQryForDayService {

	public List<PrepayQryForDayDTO> assemPrepayForDayInfo(String patId, String beginDt, String endDt)
			throws BizException {

		// 校验
		if (StringUtil.isEmpty(patId)) {
			throw new BizException("患者id为空");
		}

		// 1、查询数据库获取单个患者的门诊预交金序号，充值金额，退款金额，消费金额,门诊收费使用预交金,门诊退费返回预交金
		List<PrepayQryForDayDTO> prepayList = this.getPrepayForDayInfo(patId);

		// 2、获取这个患者的已记账未结算金额
		List<PrepayQryForDayDTO> lockAmtList = this.getLockAmt(patId);
		Map<String, PrepayQryForDayDTO> map = new HashMap<String, PrepayQryForDayDTO>();
		for (PrepayQryForDayDTO itm : lockAmtList) {
			map.put(itm.getPayDt(), itm);
		}

		// 3、给数据源的已记账未结算金额赋值
		for (PrepayQryForDayDTO itm : prepayList) {
			itm.setLockAmt(map.get(itm.getPayDt()) == null ?  new FDouble().ZERO_DBL : map.get(itm.getPayDt()).getLockAmt());
			if(map.containsKey(itm.getPayDt())){
				map.remove(itm.getPayDt());
			}
		}

		if(map.size() > 0){
			for (PrepayQryForDayDTO itm : map.values()) {
				itm.setSortNo(String.valueOf(prepayList.size() + 1));
				prepayList.add(itm);
			}
		}
		
		//因为最后给数据源add了冻结数据，所以还得给数据源进行一次排序（排序根据日起进行升序，不考虑序号，后面会再次给序号赋值）
		Collections.sort(prepayList,new Comparator<PrepayQryForDayDTO>(){
			
			public int compare(PrepayQryForDayDTO o1,PrepayQryForDayDTO o2){
				return o1.getPayDt().compareTo(o2.getPayDt());
			}
			
		});
		
		
		// 4、给查询出来的预交金信息赋值期初金额和期末金额
		// 期初金额为 上一条记录的期末金额 期末金额 = 期初值 + 充值金额 + 门诊退费返回预交金 - 退款金额 - 门诊收费使用预交金 -
		// 已记账未结算金额
		if (!ListUtil.IsEmpty(prepayList)) {
			for (int i = 0; i < prepayList.size(); i++) {
				prepayList.get(i).setSortNo(String.valueOf(i+1));//由于上一步的排序，导致序号会有错乱，所以这里再次进行序号的赋值
				if (i == 0) {
					prepayList.get(0).setBeginAmt(new FDouble().ZERO_DBL);
					prepayList.get(0).setEndAmt(prepayList.get(0).getBeginAmt().add(prepayList.get(0).getReChargeAmt())
									.add(prepayList.get(0).getBackAmt()).sub(prepayList.get(0).getReFundAmt())
									.sub(prepayList.get(0).getUseAmt()).sub(prepayList.get(0).getLockAmt() == null ? new FDouble().ZERO_DBL : prepayList.get(0).getLockAmt()));

				} else {
					prepayList.get(i).setBeginAmt(prepayList.get(i - 1).getEndAmt());
					prepayList.get(i).setEndAmt(prepayList.get(i).getBeginAmt().add(prepayList.get(i).getReChargeAmt())
									.add(prepayList.get(i).getBackAmt()).sub(prepayList.get(i).getReFundAmt())
									.sub(prepayList.get(i).getUseAmt()).sub(prepayList.get(i).getLockAmt() == null ? new FDouble().ZERO_DBL : prepayList.get(i).getLockAmt()));
				}
			}
		}

		// 5、如果查询条件有开始时间或者结束时间的话，要进行过滤，过滤时sortno要重新赋值
		if (!StringUtil.isEmpty(beginDt) || !StringUtil.isEmpty(endDt)) {
			List<PrepayQryForDayDTO> filterList = new ArrayList<PrepayQryForDayDTO>();
			if (!ListUtil.IsEmpty(prepayList)) {
				int j = 0;
				for (PrepayQryForDayDTO itm : prepayList) {
					if (!StringUtil.isEmpty(beginDt) && !StringUtil.isEmpty(endDt)) {
						if ((new FDate(itm.getPayDt()).equals(new FDate(beginDt))
								|| new FDate(itm.getPayDt()).after(new FDate(beginDt)))
								&& (new FDate(itm.getPayDt()).equals(new FDate(endDt))
										|| new FDate(itm.getPayDt()).before(new FDate(endDt)))) {
							j = j + 1;
							itm.setSortNo(String.valueOf(j));
							filterList.add(itm);
						}
					} else if (!StringUtil.isEmpty(beginDt)) {
						if (new FDate(itm.getPayDt()).equals(new FDate(beginDt))
								|| new FDate(itm.getPayDt()).after(new FDate(beginDt))) {
							j = j + 1;
							itm.setSortNo(String.valueOf(j));
							filterList.add(itm);
						}
					} else if (!StringUtil.isEmpty(endDt)) {
						if (new FDate(itm.getPayDt()).equals(new FDate(endDt))
								|| new FDate(itm.getPayDt()).before(new FDate(endDt))) {
							j = j + 1;
							itm.setSortNo(String.valueOf(j));
							filterList.add(itm);
						}
					}
				}
			}

			return filterList;
		}

		return prepayList;
	}

	/**
	 * 获取这个患者的已记账未结算金额
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private List<PrepayQryForDayDTO> getLockAmt(String patId) throws BizException {
		StringBuffer sql = new StringBuffer();
		sql.append(" select TO_CHAR(TO_DATE(cg.dt_cg, 'yyyy-mm-dd hh24:mi:ss'), 'yyyy-mm-dd') payDt, ");
		sql.append(" sum(cgitm.amt_ratio * cgitm.eu_direct) lockAmt, ");
		sql.append(" '0.00' reChargeAmt, ");
		sql.append(" '0.00' reFundAmt, ");
		sql.append(" '0.00' useAmt, ");
		sql.append(" '0.00' backAmt ");
		sql.append(" from bl_cg_itm_oep cgitm ");
		sql.append(" inner join bl_cg_oep cg on cg.id_cgoep = cgitm.id_cgoep ");
		sql.append(" where cgitm.id_pat = ? ");
		sql.append(" and fg_acc = 'Y' ");
		sql.append(" and fg_st = 'N' ");
		sql.append(" group by TO_CHAR(TO_DATE(cg.dt_cg, 'yyyy-mm-dd hh24:mi:ss'), 'yyyy-mm-dd') ");
		sql.append(" order by TO_CHAR(TO_DATE(cg.dt_cg, 'yyyy-mm-dd hh24:mi:ss'), 'yyyy-mm-dd') ");

		SqlParam param = new SqlParam();
		param.addParam(patId);

		List<PrepayQryForDayDTO> list = (List<PrepayQryForDayDTO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(PrepayQryForDayDTO.class));

		return list;
	}

	/**
	 * 查询数据库获取单个患者的门诊预交金序号，充值金额，退款金额，消费金额,门诊收费使用预交金,门诊退费返回预交金
	 * 
	 * @param patId
	 * @param beginDt
	 * @param endDt
	 * @param patCode
	 * @return
	 * @throws BizException
	 */
	private List<PrepayQryForDayDTO> getPrepayForDayInfo(String patId) throws BizException {
		StringBuffer sql = new StringBuffer();
		sql.append(" select rownum sortNo, ");
		sql.append(" tab.* ");
		sql.append(" from (select TO_CHAR(TO_DATE(pre.dt_pay, 'yyyy-mm-dd hh24:mi:ss'),'yyyy-mm-dd') payDt, ");
		sql.append(
				" sum(case when pre.eu_direct = 1 and pre.sd_paytp = '11' then pre.amt else 0.00 end) reChargeAmt, ");
		sql.append(" sum(case when pre.eu_direct = -1 and pre.sd_paytp = '11' then pre.amt else 0.00 end) reFundAmt, ");
		sql.append(" abs(sum(case when pre.sd_paytp = '21' then pre.amt * pre.eu_direct else 0.00 end)) consumeAmt, ");
		sql.append(" sum(case when pre.sd_paytp = '21' and pre.eu_direct = -1 then pre.amt else 0.00 end) useAmt, ");
		sql.append(" sum(case when pre.sd_paytp = '21' and pre.eu_direct = 1 then pre.amt else 0.00 end) backAmt ");
		sql.append(" from bl_prepay_pat pre ");
		sql.append(" where 1=1 ");
		sql.append(" and pre.id_pat = ? ");
		sql.append(" group by TO_CHAR(TO_DATE(pre.dt_pay, 'yyyy-mm-dd hh24:mi:ss'),'yyyy-mm-dd') ");
		sql.append(" order by TO_CHAR(TO_DATE(pre.dt_pay, 'yyyy-mm-dd hh24:mi:ss'),'yyyy-mm-dd')) tab ");

		SqlParam param = new SqlParam();
		param.addParam(patId);

		List<PrepayQryForDayDTO> list = (List<PrepayQryForDayDTO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(PrepayQryForDayDTO.class));

		return list;
	}
}
