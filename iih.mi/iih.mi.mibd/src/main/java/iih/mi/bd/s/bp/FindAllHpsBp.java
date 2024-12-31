package iih.mi.bd.s.bp;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.i.IHpMDORService;
import iih.mi.bd.d.HpDTO;
import iih.mi.bd.s.dp.ConvertHpDoToHpDTODp;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 查询所有医保产品集合业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindAllHpsBp {

	public HpDTO[] exec() throws BizException {
		HPDO[] hpDos = findAllHpDos();
		if (hpDos == null || hpDos.length <= 0) {
			return null;
		}
		HpDTO[] result = convertToHpDTO(hpDos);
		if (result == null || result.length <= 0) {
			return null;
		}
		fillInstParam(result);
		return result;
	}

	/**
	 * 获取所有医保DO
	 * 
	 * @return
	 * @throws BizException
	 */
	private HPDO[] findAllHpDos() throws BizException {
		IHpMDORService hpMDORService = ServiceFinder.find(IHpMDORService.class);
		HPDO[] result = hpMDORService.find("1 = 1", "code", FBoolean.FALSE);
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
	 * 填充实体参数
	 * 
	 * @param hpDtos
	 * @throws BizException
	 */
	private void fillInstParam(HpDTO[] hpDtos) throws BizException {
		FillHpInstParamsBp bp = new FillHpInstParamsBp();
		bp.exec(hpDtos);
	}
}
