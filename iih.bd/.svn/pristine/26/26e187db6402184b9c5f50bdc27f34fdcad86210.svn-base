package iih.bd.srv.s.bp;

import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

/**
 * 临床医嘱选择服务，服务价格计算操作BP
 */
public class BdSrvPriceCalBP extends BaseSrvPriceCalBP {
	/**
	 * 临床医嘱选择服务，服务价格计算
	 * @param id_srv  医疗服务id
	 * @param id_primd 付款策略
	 * @param num      套时，的个数定价 或个数加收的个数数量
	 * @param srvsetitms      套合计价时，套内项目信息 BdSrvPriCalParamDTO
	 * @return
	 * @throws BizException 
	 */
	@Override
	public FDouble exec(BdSrvPriCalParamDTO param)  throws BizException{
		FDouble price = super.exec(param);
		price = price==null?new FDouble(0):price;
		MedSrvSetItemDO[] srvSetArray= BdAppUtils.getIMedSrvSetItemDOCrudService().find(String.format("a8.fg_clinical='N' and a8.id_srv='%s'", param.getId_srv()), "", FBoolean.FALSE);
		String[] id_srvs = new String[srvSetArray.length];
		int i=0;
		for (MedSrvSetItemDO medSrvSetItem :srvSetArray)
        {
			id_srvs[i] = medSrvSetItem.getId_srv_itm();
            i++;
        }
		MedsrvAggDO[] srvaggarray = BdAppUtils.getMedsrvRService().findByIds(id_srvs, FBoolean.FALSE);
		if (null == srvaggarray || 0 == srvaggarray.length)
			return price;
			
		BaseSrvPriceCalBP capprice = new BaseSrvPriceCalBP();
		for(MedsrvAggDO srvAgg : srvaggarray)
		{
			BdSrvPriCalParamDTO calparam = new BdSrvPriCalParamDTO();
			calparam.setId_srv(srvAgg.getParentDO().getId_srv());
			calparam.setId_primd(srvAgg.getParentDO().getId_primd());
			calparam.setName_srv(srvAgg.getParentDO().getName());
			calparam.setNum(1);
			FDouble fd = capprice.exec(calparam);
			price = fd==null?price:price.add(fd);
		}
		return price;
	}
}
