package iih.ci.event.ord.bps.refund.logicbp;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;

import iih.ci.event.ord.bps.refund.query.OpDrugRefundWcInfoQuery;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEOpPharmWcOrDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.sys.appfw.orm.utils.AppFwUtil;
/**
 * 门诊退费 BS302 西药未退费信息
 * @author F
 *
 * @date 2019年11月19日上午11:36:48
 *
 * @classpath iih.ci.event.ord.bps.refund.logicbp.OpDrugRefundWcLogicDealWithBP
 */
public class OpDrugRefundWcLogicDealWithBP {

	public Hashtable<String,FArrayList2> exec(String id_preses) throws BizException{
		//有效性校验
		if(OrdEventUtil.isEmpty(id_preses))return null;
		
		// 获得西成药处方明细信息
		OpDrugRefundWcInfoQuery qry = new OpDrugRefundWcInfoQuery(id_preses);
		IEOpPharmWcOrDTO[] predtos=(IEOpPharmWcOrDTO[]) AppFwUtil.getDORstWithDao(qry, IEOpPharmWcOrDTO.class);
		
		if(OrdEventUtil.isEmpty(predtos))return null;
		HashMap<String, IEOpPharmWcOrDTO> map = new HashMap<String, IEOpPharmWcOrDTO>();
		for (IEOpPharmWcOrDTO ieOpPharmWcOrDTO : predtos) {
			String key = ieOpPharmWcOrDTO.getYzno()+ieOpPharmWcOrDTO.getId_iepharmpres();
			if (!map.containsKey(key)) {
				map.put(key, ieOpPharmWcOrDTO);
			}
		}
		IEOpPharmWcOrDTO[] results = new IEOpPharmWcOrDTO[map.size()];
		int index = 0;
		Iterator<Entry<String, IEOpPharmWcOrDTO>> iterator=map.entrySet().iterator();  
	    while(iterator.hasNext()){//使用迭代器迭代  
	        Entry< String, IEOpPharmWcOrDTO> entry=iterator.next();  
	        results[index] = entry.getValue();
	        index ++;
	    } 
		//返回分组的西成药明细信息
		return getHtInfoByIdpres(results);
	}
	/**
	 * 对西成药处方明细信息按id_pres分组
	 * @param predtos
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Hashtable<String,FArrayList2> getHtInfoByIdpres(IEOpPharmWcOrDTO[] predtos){
		//参数
		Hashtable<String,FArrayList2> ht=new Hashtable<String,FArrayList2>();
		String key=null;
		
		//遍历
		for(IEOpPharmWcOrDTO o:predtos){
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
}
