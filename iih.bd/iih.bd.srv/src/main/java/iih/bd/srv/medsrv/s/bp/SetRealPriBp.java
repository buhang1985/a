package iih.bd.srv.medsrv.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.medsrvrealpriceqry.i.IMedSrvRealPriceQryService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 设置定价模式为本服务定价的服务价格业务逻辑
 * 
 * @author hao_wu
 *
 */
public class SetRealPriBp {

	public void exec(MedSrvDO[] medSrvArr) throws BizException {
		if (medSrvArr == null || medSrvArr.length <= 0) {
			return;
		}

		SetRealPri(medSrvArr);
	}

	/**
	 * 设置价格
	 * 
	 * @param medSrvArr
	 * @throws BizException
	 */
	private void SetRealPri(MedSrvDO[] medSrvArr) throws BizException {
		FMap2 priMap = GetRealPriMap(medSrvArr);
		SetRealPri(medSrvArr, priMap);
	}

	/**
	 * 获取价格字典
	 * 
	 * @param calPriParam
	 * @return
	 * @throws BizException
	 */
	private FMap2 GetRealPriMap(MedSrvDO[] medSrvArr) throws BizException {
		String[] medSrvIds = GetMedSrvIds(medSrvArr);

		IMedSrvRealPriceQryService medSrvRealPriceQryService = ServiceFinder.find(IMedSrvRealPriceQryService.class);
		FMap2 realPriMap = medSrvRealPriceQryService.FindMedSrvRealPriMapByIds(medSrvIds);
		return realPriMap;
	}

	/**
	 * 获取医疗服务最主键集合
	 * 
	 * @param medSrvArr
	 * @return
	 */
	private String[] GetMedSrvIds(MedSrvDO[] medSrvArr) {
		ArrayList<String> medSrvIdList = new ArrayList<String>();
		if (medSrvArr != null && medSrvArr.length > 0) {
			for (MedSrvDO medSrvDO : medSrvArr) {
				if (medSrvDO != null && StringUtils.isNotEmpty(medSrvDO.getId_srv())) {
					medSrvIdList.add(medSrvDO.getId_srv());
				}
			}
		}
		return medSrvIdList.toArray(new String[0]);
	}

	/**
	 * 设置价格
	 * 
	 * @param medSrvArr
	 * @param priMap
	 */
	private void SetRealPri(MedSrvDO[] medSrvArr, FMap2 priMap) {
		for (MedSrvDO medSrvDO : medSrvArr) {
			String idSrv = medSrvDO.getId_srv();
			if (priMap.containsKey(idSrv)) {
				medSrvDO.setPri_real((FDouble) priMap.get(idSrv));
			} else {
				medSrvDO.setPri_real(null);
			}
		}
	}

}
