package iih.mi.bd.s.bp;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.i.IHpMDORService;
import iih.mi.bd.d.HpDTO;
import iih.mi.bd.s.dp.ConvertHpDoToHpDTODp;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据医保产品主键集合查询医保产品集合业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindHpDtosByIdsBp {

	public HpDTO[] exec(String[] hpIds) throws BizException {
		if (hpIds == null || hpIds.length <= 0) {
			return null;
		}
		HpDTO[] result = findHpDtosByIds(hpIds);
		return result;
	}

	/**
	 * 根据医保产品主键集合查询医保产品集合
	 * 
	 * @param hpIds
	 * @return
	 * @throws BizException
	 */
	private HpDTO[] findHpDtosByIds(String[] hpIds) throws BizException {
		HPDO[] hpDos = findHpsByIds(hpIds);
		HpDTO[] result = convertToHpDTO(hpDos);
		if (result == null) {
			return null;
		}
		fillInstParam(result);
		return result;
	}

	/**
	 * 根据主键集合查询医保产品集合
	 * 
	 * @param hpIds
	 * @return
	 * @throws BizException
	 */
	private HPDO[] findHpsByIds(String[] hpIds) throws BizException {
		IHpMDORService hpMDORService = ServiceFinder.find(IHpMDORService.class);
		HPDO[] result = hpMDORService.findByIds(hpIds, FBoolean.FALSE);
		return result;
	}

	/**
	 * 转换HpDo为HpDto
	 * 
	 * @param hpDos
	 * @return
	 */
	private HpDTO[] convertToHpDTO(HPDO[] hpDos) {
		ConvertHpDoToHpDTODp dp = new ConvertHpDoToHpDTODp();
		HpDTO[] result = dp.exec(hpDos);
		return result;
	}

	/**
	 * 填充工厂实例全类名
	 * 
	 * @param hpDtos
	 * @throws BizException
	 */
	private void fillInstParam(HpDTO[] hpDtos) throws BizException {
		FillHpInstParamsBp bp = new FillHpInstParamsBp();
		bp.exec(hpDtos);
	}
}
