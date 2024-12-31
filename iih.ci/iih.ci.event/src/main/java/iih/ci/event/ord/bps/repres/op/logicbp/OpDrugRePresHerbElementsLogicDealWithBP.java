package iih.ci.event.ord.bps.repres.op.logicbp;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;

import iih.ci.event.ord.bps.repres.op.query.OpDrugRePresHerbElementsInfoQuery;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEOpPharmOrMmDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.sys.appfw.orm.utils.AppFwUtil;
/**
 * BS302 门诊重新分方 草药明细逻辑处理
 * @author F
 *
 * @date 2019年9月11日上午11:11:49
 *
 * @classpath iih.ci.event.ord.bps.repres.op.logicbp.OpDrugRePresHerbElementsLogicDealWithBP
 */
public class OpDrugRePresHerbElementsLogicDealWithBP {
	/**
	 * 生成集成平台草药医嘱物品数据信息
	 * （门诊）
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public Hashtable<String,FArrayList2> exec(String id_preses) throws BizException{
		//有效性校验
		if(OrdEventUtil.isEmpty(id_preses))return null;
		
		// 获得草药处方明细信息
		OpDrugRePresHerbElementsInfoQuery qry = new OpDrugRePresHerbElementsInfoQuery(id_preses);
		IEOpPharmOrMmDTO[] predtos=(IEOpPharmOrMmDTO[]) AppFwUtil.getDORstWithDao(qry, IEOpPharmOrMmDTO.class);
		if(OrdEventUtil.isEmpty(predtos))return null;
		
		HashMap<String, IEOpPharmOrMmDTO> map = new HashMap<String, IEOpPharmOrMmDTO>();
		for (IEOpPharmOrMmDTO ieOpPharmWcOrDTO : predtos) {
			String key = ieOpPharmWcOrDTO.getId_iepharmor();
			if (!map.containsKey(key)) {
				map.put(key, ieOpPharmWcOrDTO);
			}
		}
		IEOpPharmOrMmDTO[] results = new IEOpPharmOrMmDTO[map.size()];
		int index = 0;
		Iterator<Entry<String, IEOpPharmOrMmDTO>> iterator=map.entrySet().iterator();  
	    while(iterator.hasNext()){//使用迭代器迭代  
	        Entry< String, IEOpPharmOrMmDTO> entry=iterator.next();  
	        results[index] = entry.getValue();
	        index ++;
	    } 
		//返回分组的成药明细成分数据信息
		return getHtInfoByIdpres(predtos);
	}
	
	/**
	 * 对草药处方明细成分信息按id_pres分组
	 * @param predtos
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Hashtable<String,FArrayList2> getHtInfoByIdpres(IEOpPharmOrMmDTO[] predtos){
		//参数
		Hashtable<String,FArrayList2> ht=new Hashtable<String,FArrayList2>();
		String key=null;
		
		//遍历
		for(IEOpPharmOrMmDTO o:predtos){
			key=o.getId_iepharmor();
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
