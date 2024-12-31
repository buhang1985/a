package iih.ci.event.ord.bps.sign.op.logicbp;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;

import iih.ci.event.ord.bps.sign.op.query.OpDrugSignWcInfoQuery;
import iih.ci.event.ord.bps.sign.op.query.OpDrugSignWcRefundInfoQuery;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEOpPharmWcOrDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.sys.appfw.orm.utils.AppFwUtil;
/**
 * 门诊签署 处方西药 处理逻辑BS302
 * @author F
 *
 * @date 2019年8月27日下午3:51:55
 *
 * @classpath iih.ci.event.ord.bps.sign.op.logicbp.OpDrugSignWcLogicDealWithBP
 */
public class OpDrugSignWcLogicDealWithBP {

	/**
	 * 生成集成平台西成医嘱服务数据信息
	 * （门诊）
	 * @param id_preses  处方id串
	 * @return
	 * @throws BizException
	 */
	public Hashtable<String,FArrayList2> exec(String id_preses) throws BizException{
		//有效性校验
		if(OrdEventUtil.isEmpty(id_preses))return null;
		
		// 获得西成药处方明细信息
		OpDrugSignWcInfoQuery qry = new OpDrugSignWcInfoQuery(id_preses);
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
	 * 生成集成平台西成医嘱服务数据信息
	 * （门诊）
	 * @param id_preses  处方id串
	 * @return
	 * @throws BizException
	 */
	public Hashtable<String,FArrayList2> exec(String id_preses,String id_orsrvs) throws BizException{
		//有效性校验
		if(OrdEventUtil.isEmpty(id_preses))return null;
		
		// 获得西成药处方明细信息
		OpDrugSignWcRefundInfoQuery qry = new OpDrugSignWcRefundInfoQuery(id_preses,id_orsrvs);
		IEOpPharmWcOrDTO[] predtos=(IEOpPharmWcOrDTO[]) AppFwUtil.getDORstWithDao(qry, IEOpPharmWcOrDTO.class);
		if(OrdEventUtil.isEmpty(predtos))return null;

		//返回分组的西成药明细信息
		return getHtInfoByIdpres(predtos);
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
