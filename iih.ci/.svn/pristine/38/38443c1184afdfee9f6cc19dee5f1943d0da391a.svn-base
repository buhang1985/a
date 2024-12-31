package iih.ci.event.ord.bps.sign.ip.logicbp;

import iih.ci.event.ord.bps.sign.ip.query.IpDrugSignWcInfoQuery;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEPharmWcOrDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
/**
 *  住院签署 用药 西药逻辑处理BS311
 * @author F
 *
 * @date 2019年8月29日下午5:00:45
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.logicbp.IpDrugSignWcLogicDealWithBP
 */
public class IpDrugSignWcLogicDealWithBP {

	/**
	 * 生成集成平台西成医嘱服务数据信息
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEPharmWcOrDTO[] exec(String id_ors) throws BizException{
		//有效性校验
		if(OrdEventUtil.isEmpty(id_ors))return null;
		
		//查询并获得返回值
		IpDrugSignWcInfoQuery qry=new IpDrugSignWcInfoQuery(id_ors);
		IEPharmWcOrDTO[] rtn = (IEPharmWcOrDTO[])AppFwUtil.getDORstWithDao(qry, IEPharmWcOrDTO.class);
		//返回值处理
		//RtnHandle(rtn);//暂时先不做处理
		//返回
		return rtn;
	}
	
	/**
	 * 返回值处理
	 * @param rtn
	 */
	@SuppressWarnings("unused")
	private void RtnHandle(IEPharmWcOrDTO[] rtn){
		if(OrdEventUtil.isEmpty(rtn))return;
		String id_or="";
		String id_or_parent="";
		for(int i=0;i<rtn.length;i++){
			id_or_parent=rtn[i].getXy_zcy_f_order_no();
			if(!id_or.equals(id_or_parent)){
				rtn[i].setXy_zcy_order_code(id_or_parent);
				rtn[i].setXy_zcy_f_order_no(null);
				id_or=id_or_parent;
			}
		}

	}
}
