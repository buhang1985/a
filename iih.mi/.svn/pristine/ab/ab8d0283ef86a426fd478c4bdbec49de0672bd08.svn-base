package iih.mi.bd.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.mi.bd.miudidoccomp.d.MiUdidocCompDO;
import iih.mi.bd.miudidoccomp.i.IMiudidoccompCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存医保档案对照信息
 * @author wq.li
 *
 */
public class SaveMIudidocCompBP {

	public MiUdidocCompDO[] exec(MiUdidocCompDO[] compArr)throws BizException{
		if(ArrayUtil.isEmpty(compArr)){
			return null;
		}
		
		List<MiUdidocCompDO> compList=new ArrayList<MiUdidocCompDO>();
		
		for (MiUdidocCompDO miUdidocCompDO : compArr) {
			if(StringUtil.isEmpty(miUdidocCompDO.getId_miudidoc_comp())){
				if(!StringUtil.isEmpty(miUdidocCompDO.getCode_hp())){
					miUdidocCompDO.setStatus(DOStatus.NEW);
					compList.add(miUdidocCompDO);
				}
			}else{
				if(!StringUtil.isEmpty(miUdidocCompDO.getCode_hp())){
					miUdidocCompDO.setStatus(DOStatus.UPDATED);
					compList.add(miUdidocCompDO);
				}else{
					miUdidocCompDO.setStatus(DOStatus.DELETED);
					compList.add(miUdidocCompDO);
				}
			}
		}
		
		IMiudidoccompCudService compService=ServiceFinder.find(IMiudidoccompCudService.class);
		MiUdidocCompDO[] result= compService.save(compList.toArray(new MiUdidocCompDO[0]));
		return result;
	}
}
