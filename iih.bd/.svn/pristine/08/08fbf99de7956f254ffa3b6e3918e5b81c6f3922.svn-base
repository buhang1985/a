package iih.bd.pp.bp;

import java.util.List;
import java.util.Map.Entry;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.CollectionUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.srvspecround.d.SrvSpecRoundDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 特殊取整
 * 
 * @author yankan
 * @since 2017-10-31
 *
 */
public class BatchSpecRoundBP {
	/**
	 * 计算特殊取整数量
	 * 
	 * @param srvQuanMap，[key:服务ID，value:数量]
	 * @return map[key:服务ID，value:数量]
	 * @throws BizException
	 */
	public FMap exec(FMap srvQuanMap) throws BizException {
		if (CollectionUtils.isEmpty(srvQuanMap)) {
			return srvQuanMap;
		}

		// 1、获取特殊取整设置
		FMap roundMap = this.getSrvSpecRoundList(srvQuanMap.keySet().toArray(new String[0]));

		// 2、取整计算
		for (Entry entry : srvQuanMap.entrySet()) {
			SrvSpecRoundDO roundDO = (SrvSpecRoundDO) roundMap.get(entry.getKey());
			if (roundDO != null) {
				FDouble quan = this.calcSpecRoundQuan((FDouble) entry.getValue(), roundDO);
				entry.setValue(quan);
			}
		}

		return srvQuanMap;
	}

	/**
	 * 获取服务取整配置集合
	 * 
	 * @param srvIds 服务ID集合
	 * @return
	 * @throws BizException
	 */
	private FMap getSrvSpecRoundList(String[] srvIds) throws BizException {
		FMap map = new FMap();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ID_SRV,ROUND_NUMERATOR,ROUND_DENOMINATOR ");
		sqlBuilder.append(" FROM BD_SRV_SPEC_ROUND ");
		sqlBuilder.append(" WHERE DT_B<=?");
		sqlBuilder.append(" AND " + SqlUtils.getInSqlByIds(SrvSpecRoundDO.ID_SRV, srvIds));

		FDateTime currentTime = AppUtils.getServerDateTime();
		SqlParam param = new SqlParam();
		param.addParam(currentTime);

		List<SrvSpecRoundDO> roundDOList = (List<SrvSpecRoundDO>) new DAFacade().execQuery(sqlBuilder.toString(), param,
				new BeanListHandler(SrvSpecRoundDO.class));
		if (!ListUtil.isEmpty(roundDOList)) {
			for (SrvSpecRoundDO roundDO : roundDOList) {
				map.put(roundDO.getId_srv(), roundDO);
			}
		}
		return map;
	}

	/**
	 * 特殊取整
	 * 
	 * @param quan
	 * @param specRoundDO
	 * @return
	 */
	private FDouble calcSpecRoundQuan(FDouble quan, SrvSpecRoundDO specRoundDO) {
		if (specRoundDO == null) {
			return quan;
		}
		FDouble max_quan = new FDouble(Math.ceil((quan.multiply(specRoundDO.getRound_denominator())).doubleValue()));
		max_quan = max_quan.multiply(specRoundDO.getRound_numerator());// 分子设计时，恒为1
		FDouble ret_quan = max_quan.div(specRoundDO.getRound_denominator());
		return ret_quan;
	}
}
