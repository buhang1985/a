package iih.bd.pp.bp.pri;

import iih.bd.base.validator.ParamValidator;
import iih.bd.pp.pripat.d.PriPatDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 获取价格分类的系数
 * @author yankan
 * @since 2017-07-26
 *
 */
public class GetPriPatRateBP {
	/**
	 * 获取价格分类的系数
	 * @param pripatAgg
	 * @return
	 * @throws BizException
	 */
	public FDouble exec(String priPatId) throws BizException{
		//参数校验
		ParamValidator.validateNotNull("患者价格分类ID", priPatId);
		
		//获取价格分类对象
		String[] selectedFields = new String[]{PriPatDO.ID_PRIPAT,PriPatDO.RATE};
		PriPatDO priPatDO = (PriPatDO) new DAFacade().findByPK(PriPatDO.class, priPatId, selectedFields);
		if(priPatDO==null){
			throw new BizException("患者价格分类不存在！");
		}
		
		FDouble priCaRate = priPatDO.getRate();
//		if (PriCaMdEnum.PRIPATCA.equals(priPatDO.getEu_pi_pricamd())) {
//			if (PriRateMdEnum.PRIRATIOMODEL.equals(priPatDO.getEu_pi_priratemd())) {
//				return priCaRate;// 比例模式
//			}
//			return priPatDO.getRate();//价格模式暂不支持
//		}
		// 默认患者价格分类系数
		return priCaRate;
	}
}
