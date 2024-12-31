package iih.ci.event.ord.bps.refund.logicbp;

import java.util.Hashtable;

import iih.ci.event.ord.bps.refund.query.OpDrugRefundHerbInfoQuery;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEOpPharmHerbOrDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.sys.appfw.orm.utils.AppFwUtil;
/**
 * BS302 门诊退费 草药未退费处理逻辑
 * @author F
 *
 * @date 2019年11月19日下午1:52:50
 *
 * @classpath iih.ci.event.ord.bps.refund.logicbp.OpDrugRefundHerbDealWithBP
 */
public class OpDrugRefundHerbDealWithBP {

	/**
	 * 生成集成平台草药医嘱服务数据信息
	 * （门诊）
	 * @param id_preses  处方id串
	 * @return
	 * @throws BizException
	 */
	public Hashtable<String,FArrayList2> exec(String id_preses) throws BizException{
		//有效性校验
		if(OrdEventUtil.isEmpty(id_preses))return null;
		
		// 获得草药信息
		OpDrugRefundHerbInfoQuery qry = new OpDrugRefundHerbInfoQuery(id_preses);
		IEOpPharmHerbOrDTO[] predtos=(IEOpPharmHerbOrDTO[]) AppFwUtil.getDORstWithDao(qry, IEOpPharmHerbOrDTO.class);
		if(OrdEventUtil.isEmpty(predtos))return null;
		
		//获得草药成分信息
		Hashtable<String,FArrayList2> herbcomht=getHerbComposition(id_preses);
		herbCompositionHandle(predtos,herbcomht);
		
		//返回分组的草药明细信息
		return getHtInfoByIdpres(predtos);
	}
	/**
	 * 对草药处方明细信息按id_pres分组
	 * @param predtos
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Hashtable<String,FArrayList2> getHtInfoByIdpres(IEOpPharmHerbOrDTO[] predtos){
		//参数
		Hashtable<String,FArrayList2> ht=new Hashtable<String,FArrayList2>();
		String key=null;
		
		//遍历
		for(IEOpPharmHerbOrDTO o:predtos){
			key=o.getId_iepharmpres();
			if(ht.containsKey(key)){
				(ht.get(key)).add(o);
			}else{
				FArrayList2 list=new FArrayList2();
				list.add(o);
				ht.put(key, list);
			}
			
		}
		
		return ht;
	}
	/**
	 * 草药成分信息域草药关联处理
	 * @param predtos
	 * @param herbcomht
	 */
	private void herbCompositionHandle(IEOpPharmHerbOrDTO[] predtos,Hashtable<String,FArrayList2> herbcomht){
		//参数
		String key=null;
		
		for(int i=0;i<predtos.length;i++){
			key=predtos[i].getId_iepharmor();
			if(herbcomht.containsKey(key)){
				predtos[i].setId_iepharmormms(herbcomht.get(key));
			}else{
				//理论角度讲不存在这种情况
			}
		}
	}
	/**
	 * 获得草药成分信息
	 * @param id_preses
	 * @return
	 * @throws BizException
	 */
	private Hashtable<String,FArrayList2> getHerbComposition(String id_preses) throws BizException{
		OpDrugRefundHerbElementsDealWithBP bp=new OpDrugRefundHerbElementsDealWithBP();
		return bp.exec(id_preses);
	}
}