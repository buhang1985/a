package iih.pi.reg.s.external.provide.bp;

import org.apache.commons.lang.StringUtils;

import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 入院登记(儿童)根据母亲名称、证件类型、证件号查询母亲的患者主键业务逻辑
 * 
 * @author hao_wu 2018-8-5
 *
 */
public class FindMomIdByNameAndIdNum4RegChildBp {

	/**
	 * 入院登记(儿童)根据母亲名称、证件类型、证件号查询母亲的患者主键
	 * 
	 * @param patName
	 *            母亲姓名
	 * @param idTpCode
	 *            证件类型编码
	 * @param idNum
	 *            证件号
	 * @return 母亲患者主键
	 * @throws BizException
	 */
	public String exec(String patName, String idTpCode, String idNum) throws BizException {
		if (StringUtils.isEmpty(patName) && StringUtils.isEmpty(idTpCode) && StringUtils.isEmpty(idNum)) {
			throw new BizException("母亲姓名、证件类型编码、证件号不允许同时为空。");
		}

		String wherePart = getWherePart(patName, idTpCode, idNum);

		IPatiMDORService patiMDORService = ServiceFinder.find(IPatiMDORService.class);
		PatDO[] patDOs = patiMDORService.find(wherePart, "", FBoolean.FALSE);

		if (patDOs != null && patDOs.length > 0) {
			return patDOs[0].getId_pat();
		}

		return null;
	}

	/**
	 * 构建条件语句
	 * 
	 * @param patName
	 * @param idTpCode
	 * @param idNum
	 * @return
	 */
	private String getWherePart(String patName, String idTpCode, String idNum) {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		if (StringUtils.isNotEmpty(patName)) {
			String wherePart = String.format(" and name = '%s'", patName);
			wherePartBuilder.append(wherePart);
		}

		if (StringUtils.isNotEmpty(idTpCode)) {
			String wherePart = String.format(" and sd_idtp = '%s'", idTpCode);
			wherePartBuilder.append(wherePart);
		}

		if (StringUtils.isNotEmpty(idNum)) {
			String wherePart = String.format(" and id_code = '%s'", idNum);
			wherePartBuilder.append(wherePart);
		}

		return wherePartBuilder.toString();
	}

}
