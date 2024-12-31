package iih.bl.hp.bp;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import iih.bl.hp.dto.d.DiDependDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;

/**
 * 检查诊断依赖
 * @author
 *
 */
public class CheckDiDependBP {
	/**
	 * 检查诊断依赖
	 * 
	 * @param endId 就诊ID
	 * @param diIds 删除诊断ID集合
	 * @param diIdsAll 剩余全部诊断ID集合
	 * @return 诊断依赖结果
	 * @throws BizException
	 */
	public DiDependDTO[] exec(String endId,String[] diIds,String[] diIdsAll) throws BizException{
		DiDependDTO[] diDependDTO=new DiDependDTO[]{};
		if(endId==null || endId=="")
		{
			//throw new BizException("就诊ID不能为空！");
			return diDependDTO;
		}
		if(ArrayUtil.isEmpty(diIds))
		{
			//throw new BizException("诊断ID不能为空！");
			return diDependDTO;
		}	
		if(ArrayUtil.isEmpty(diIdsAll))
		{
			//throw new BizException("诊断ID不能为空！");
			return diDependDTO;
		}		
		//diIdsAll中是全部诊断，筛选出删除后剩余的诊断
		String[] idDisAll =new String[]{};
		for(int i=0;i<diIdsAll.length;i++){
			if(!ArrayUtils.contains(diIds,diIdsAll[i])){
				idDisAll=insertArray(idDisAll,diIdsAll[i]);
			}
		}
		List<DiDependDTO> list  = new ArrayList<DiDependDTO>() ;		
		//1.适应症依赖判断
		CheckInDicDiDependBP checkInDicDiDependBP = new CheckInDicDiDependBP();
		diDependDTO= checkInDicDiDependBP.exec(endId, diIds,idDisAll);
		for (DiDependDTO diDependDTO2 : diDependDTO) {
			list.add(diDependDTO2);
		}
		//2.特殊病依赖
		CheckSpecillDiDependBP  checkSpecillDiDependBP = new CheckSpecillDiDependBP();
		diDependDTO=checkSpecillDiDependBP.exec(endId, diIds,idDisAll);

		for (DiDependDTO diDependDTO2 : diDependDTO) {
			list.add(diDependDTO2);
		}
		//3.超量开药依赖
		CheckExcessDiDependBP checkExcessDiDependBP =new CheckExcessDiDependBP();
		diDependDTO=checkExcessDiDependBP.exec(endId, diIds,idDisAll);

		for (DiDependDTO diDependDTO2 : diDependDTO) {
			list.add(diDependDTO2);
		}
		return list.toArray(new DiDependDTO[list.size()]);
	}
	/**
	 * 数组追加元素
	 * @param arr
	 * @param str
	 * @return
	 */
	private static String[] insertArray(String[] arr, String str)
	{
		int size = arr.length;
		String[] tmp = new String[size + 1];
		System.arraycopy(arr, 0, tmp, 0, size);	
		tmp[size] = str;	
		return tmp;
	}
}
