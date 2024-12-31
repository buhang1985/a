package iih.bd.fc.quesite.s.rule;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.fc.quesite.d.QueSiteDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 药房窗口唯一性规则
 * 
 * @author hao_wu 2019-2-26
 *
 */
public class PharmacyUniqueRule implements IRule<QueSiteDO> {

	@Override
	public void process(QueSiteDO... sites) throws BizException {
		QueSiteDO[] pharmacySiteList = getPharmacys(sites);
		if (ArrayUtils.isEmpty(pharmacySiteList)) {
			return;
		}

		checkCodeUnique(pharmacySiteList);
	}

	/**
	 * 检查编码唯一性
	 * 
	 * @param pharmacySiteList 药房站点列表
	 * @throws BizException
	 */
	private void checkCodeUnique(QueSiteDO[] pharmacySiteList) throws BizException {
		HashMap<String, QueSiteDO> siteMap = new HashMap<String, QueSiteDO>();
		for (QueSiteDO queSiteDO : pharmacySiteList) {
			if (siteMap.containsKey(queSiteDO.getCode())) {
				String msg = String.format("药房窗口编码不允许重复，编码【%s】已存在。", queSiteDO.getCode());
				throw new BizException(msg);
			}
			siteMap.put(queSiteDO.getCode(), queSiteDO);
		}

		checkCodeUniqueInDb(pharmacySiteList);
	}

	/**
	 * 在数据库中校验编码唯一性
	 * 
	 * @param pharmacySiteList 药房站点列表
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void checkCodeUniqueInDb(QueSiteDO[] pharmacySiteList) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder();

		ArrayList<String> wherePartList = new ArrayList<String>();
		for (QueSiteDO queSiteDO : pharmacySiteList) {
			String wherePart;
			if (StringUtils.isNotBlank(queSiteDO.getId_quesite())) {
				wherePart = String.format("(code = '%s' and id_dep = '%s' and Id_quesite <> '%s')", queSiteDO.getCode(),
						queSiteDO.getId_dep(), queSiteDO.getId_quesite());
			} else {
				wherePart = String.format("(code = '%s' and id_dep = '%s')", queSiteDO.getCode(),
						queSiteDO.getId_dep());
			}
			wherePartList.add(wherePart);
		}

		String wherePart = String.format("sd_quesitetp = '%s' and (%s)", IBdFcDictCodeConst.SD_QUESITETP_SENDM,
				StringUtils.join(wherePartList, " or "));
		wherePartBuilder.append(wherePart);

		DAFacade daFacade = new DAFacade();
		ArrayList<QueSiteDO> siteList = (ArrayList<QueSiteDO>) daFacade.findByCond(QueSiteDO.class, wherePart);
		if (siteList == null || siteList.size() <= 0) {
			return;
		}

		ArrayList<String> codeList = new ArrayList<String>();
		for (QueSiteDO site : siteList) {
			codeList.add(site.getCode());
		}

		String msg = String.format("药房窗口编码不允许重复，编码【%s】已存在。", StringUtils.join(codeList, ","));
		throw new BizException(msg);
	}

	/**
	 * 获取药房站点
	 * 
	 * @param sites
	 * @return
	 */
	private QueSiteDO[] getPharmacys(QueSiteDO[] sites) {
		if (ArrayUtils.isEmpty(sites)) {
			return null;
		}

		ArrayList<QueSiteDO> siteList = new ArrayList<QueSiteDO>();
		for (QueSiteDO queSiteDO : sites) {
			if (IBdFcDictCodeConst.SD_QUESITETP_SENDM.equals(queSiteDO.getSd_quesitetp())) {
				siteList.add(queSiteDO);
			}
		}
		return siteList.toArray(new QueSiteDO[0]);
	}

}
