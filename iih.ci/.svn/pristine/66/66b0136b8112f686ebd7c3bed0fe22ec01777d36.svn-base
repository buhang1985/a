package iih.ci.event.ord.bps.sign.ip.logicbp;

import java.util.Hashtable;

import iih.ci.event.ord.bps.sign.ip.query.IpDrugSignHerbInfoQuery;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEPharmHerbOrDTO;
import iih.ci.ord.iemsg.d.IEPharmOrMmDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.sys.appfw.orm.utils.AppFwUtil;
/**
 * 住院签署 用药 草药逻辑处理BS311
 * @author F
 *
 * @date 2019年8月29日下午5:02:47
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.logicbp.IpDrugSignHerbLogicDealWithBP
 */
public class IpDrugSignHerbLogicDealWithBP {

	/**
	 * 生成集成平台草药医嘱服务数据信息
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEPharmHerbOrDTO[] exec(String id_ors) throws BizException{
		//有效性校验
		if(OrdEventUtil.isEmpty(id_ors))return null;
		
		//查询并获得返回值
		IpDrugSignHerbInfoQuery qry=new IpDrugSignHerbInfoQuery(id_ors);
		IEPharmHerbOrDTO[] rtn = (IEPharmHerbOrDTO[])AppFwUtil.getDORstWithDao(qry, IEPharmHerbOrDTO.class);

		//获得草药医嘱对应的药品
		IEPharmOrMmDTO[] ormms=GetIEMsgInfo4DrugHerbMmBP(id_ors);
		
		//合并处理
		mergeHandle(rtn,ormms);
		
		//返回
		return rtn;
	}
	
	/**
	 * 合并处理
	 */
	private void mergeHandle(IEPharmHerbOrDTO[] rtn,IEPharmOrMmDTO[] ormms){
		//有效性校验
		if(OrdEventUtil.isEmpty(rtn) || OrdEventUtil.isEmpty(ormms)) return;
		
		//分组处理
		Hashtable<String,FArrayList2> ht=grpHandle(ormms);
		String id_or="";
		
		//遍历
		for(int i=0;i<rtn.length;i++){
			id_or=rtn[i].getId_iepharmor();
			rtn[i].setId_iepharmormms(ht.get(id_or));
		}
		
	}
	
	/**
	 * 分组处理
	 * @param ormms
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Hashtable<String,FArrayList2> grpHandle(IEPharmOrMmDTO[] ormms){
		Hashtable<String,FArrayList2> ht=new Hashtable<String,FArrayList2>();
		String id_or="";
		
		//遍历
		for(int i=0;i<ormms.length;i++){
			id_or=ormms[i].getId_iepharmor();
			if(ht.containsKey(id_or)){
				(ht.get(id_or)).add(ormms[i]);
			}else{
				FArrayList2 list=new FArrayList2();
				list.add(ormms[i]);
				ht.put(id_or, list);
			}
		}
		
		return ht;
	}
	
	/**
	 * 获得草药医嘱对应的药品
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEPharmOrMmDTO[] GetIEMsgInfo4DrugHerbMmBP(String id_ors) throws BizException{
		IpDrugSignHerbElementLogicDealWithBP bp=new IpDrugSignHerbElementLogicDealWithBP();
		return bp.exec(id_ors);
	}
}
