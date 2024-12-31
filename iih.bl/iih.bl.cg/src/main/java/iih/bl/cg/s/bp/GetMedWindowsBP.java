package iih.bl.cg.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang3.StringUtils;

import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.inc.blincquerydto.d.BlInvoiceDetailsDTO;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
/**
 * 获取发药窗口
 * @author LIM
 *
 */
public class GetMedWindowsBP {
	/**
	 * 获取发药窗口字符串
	 * @param blInc
	 * @return
	 */
	public String getWindows(BlIncItmVsTypeDTO[] blInc){
		// 发药窗口
		String disWindow = "";
		//药品分类
		String med="";
		//药品发药窗口map
		Map<String,String> medwinMap = new HashMap<String,String>();
		//窗口集合
		List<String> windowList = new ArrayList<String>();
		if (blInc != null && blInc.length > 0) {
			for (BlIncItmVsTypeDTO blIncItmVsTypeDTO : blInc) {
				for (Object initem : blIncItmVsTypeDTO.getBlInvoiceDetailsDTO()) {
					BlInvoiceDetailsDTO itmdto = (BlInvoiceDetailsDTO) initem;
					//保存药和窗口
					if((FBoolean.TRUE).equals(itmdto.getFg_mm()) ){
						if(!medwinMap.containsKey(itmdto.getName_inccaitm())){
							medwinMap.put(itmdto.getName_inccaitm().replace("费", ""),itmdto.getWindowinfo());
						}
						//将窗口保存成一个list
						if(StringUtils.isEmpty(itmdto.getWindowinfo() )&&!windowList.contains(itmdto.getWindowinfo())){
							windowList.add(itmdto.getWindowinfo());
						}
					}
				}
			}
			//
			if(medwinMap.size()>0 && windowList.size()>0){
				//循环窗口列表
				for(String wi:windowList){
					med="";
					//循环窗口药品的map，找出对应的药
					for(String key:medwinMap.keySet()){
						if(medwinMap.get(key).equals(wi)){
							med+=key+"、";
						}
					}	
					disWindow += med.substring(0, med.length()-1) + "请到" + wi + "取药\t\n";
				}
			}
		}
		return disWindow;
	}
}
