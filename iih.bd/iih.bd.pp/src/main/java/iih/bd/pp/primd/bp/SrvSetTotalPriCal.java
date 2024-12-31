package iih.bd.pp.primd.bp;

import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.coreitf.d.FDouble;

/**
 * 服务套成员合计价计算
 * @author yankan
 * @since 2015-08-04
 *
 */
public class SrvSetTotalPriCal implements IPriCal{

	/**
	 * 计算服务套成员合计价
	 * @param srvSetId
	 */
	@Override
	public FDouble Calculate(String srvSetId) {
		FDouble totalPrice = new FDouble();
		MedSrvDO[] doArray = GetSrvSetMembers(srvSetId);
		if(doArray!=null){
			for(MedSrvDO srvDO : doArray){
				totalPrice.add(srvDO.getPri());
			}
		}
		
		return totalPrice;
	}
	/**
	 * 获取服务套成员
	 * @param srvSetId 服务套ID
	 * @return 服务套成员集合
	 */
	private MedSrvDO[] GetSrvSetMembers(String srvSetId){
		return null;
	}

}
