package iih.bd.pp.hpsrvorca.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.bdhpsrvctr.d.BdHpSrvctrDO;
import iih.bd.pp.bdhpsrvctr.i.IBdhpsrvctrRService;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.i.IHpsrvorcaRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.measdoc.i.IMeasdocRService;

/**
 * 使用对照主键获取对照信息业务逻辑_补全计算字段
 * 
 * @author hao_wu
 *
 */
public class FindSrvOrCaByIdBp {

	public HPSrvorcaDO exec(String srvOrCaId) throws BizException {
		HPSrvorcaDO hpSrvorcaDO = findById(srvOrCaId);
		if (hpSrvorcaDO == null) {
			return null;
		}
		setMiInfo(hpSrvorcaDO);
		setMmBasepkgName(hpSrvorcaDO);
		setSrvCtr(hpSrvorcaDO);
		return hpSrvorcaDO;
	}

	/**
	 * 设置医保信息
	 * 
	 * @author hao_wu
	 * @param hpSrvorcaDO
	 * @throws BizException
	 */
	private void setMiInfo(HPSrvorcaDO hpSrvorcaDO) throws BizException {
		SetMiInfoBp bp = new SetMiInfoBp();
		bp.exec(new HPSrvorcaDO[] { hpSrvorcaDO });
	}

	/**
	 * 根据主键查找医保目录对照信息
	 * 
	 * @author hao_wu
	 * @param srvOrCaId
	 * @return
	 * @throws BizException
	 */
	private HPSrvorcaDO findById(String srvOrCaId) throws BizException {
		IHpsrvorcaRService hpsrvorcaRService = ServiceFinder.find(IHpsrvorcaRService.class);
		HPSrvorcaDO result = hpsrvorcaRService.findById(srvOrCaId);
		return result;
	}

	/**
	 * 设置医保目录对照控制策略
	 * 
	 * @author hao_wu
	 * @param result
	 * @throws BizException
	 */
	private void setSrvCtr(HPSrvorcaDO hpSrvorcaDO) throws BizException {
		if (StringUtils.isEmpty(hpSrvorcaDO.getCode())) {
			return;
		}
		String wherePart = String.format("ID_HP = '%s' AND ID_SRV = '%s' AND EU_HPSRVTP = '%s'", hpSrvorcaDO.getId_hp(),
				hpSrvorcaDO.getId_srv(), hpSrvorcaDO.getEu_hpsrvtp());
		IBdhpsrvctrRService bdhpsrvctrRService = ServiceFinder.find(IBdhpsrvctrRService.class);
		BdHpSrvctrDO[] result = bdhpsrvctrRService.find(wherePart, "", FBoolean.FALSE);
		if (result == null || result.length <= 0) {
			return;
		}
		BdHpSrvctrDO hpSrvctrDO = result[0];
		hpSrvorcaDO.setEu_hpsrvctrtp(hpSrvctrDO.getEu_hpsrvctrtp());
		hpSrvorcaDO.setHis_des(hpSrvctrDO.getHis_des());
	}

	/**
	 * 设置物品基本包装单位名称
	 * 
	 * @author hao_wu
	 * @param result
	 * @throws BizException
	 */
	private void setMmBasepkgName(HPSrvorcaDO hpSrvorcaDO) throws BizException {
		String basePkgId = hpSrvorcaDO.getMm_unit_pkgbase();
		if (StringUtils.isEmpty(basePkgId)) {
			return;
		}

		IMeasdocRService measdocRService = ServiceFinder.find(IMeasdocRService.class);
		MeasDocDO measDocDO = measdocRService.findById(basePkgId);
		if (measDocDO != null) {
			hpSrvorcaDO.setName_unit_pkgbase(measDocDO.getName());
		}
	}
}
