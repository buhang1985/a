package iih.ci.ord.s.bp.ordprn;

import iih.ci.ord.dto.ordprintdto.d.OrdPrintDataDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.perm.scvi.d.MyScviDO;
import xap.sys.perm.scvi.i.IScviRService;

/**
 * 获取电子签名
 * @author zhangwq
 *
 */
public class GetEmpPicSignBP {
	public FMap exec(String[] id_emps) throws BizException{
		FMap map = new FMap();
		if(id_emps==null||id_emps.length==0)
		{
			return null;
		}
		IScviRService scviService = ServiceFinder.find(IScviRService.class);
		MyScviDO[] scviDOs = scviService.findByAttrValStrings(MyScviDO.ID_USER, id_emps);
		//前台没有MyScViDO对象，取出来放入OrdPrintDataDTO.框架不支持在map中直接放入byte[],所以先放入OrdPrintDataDTO的Pic_emp_sign字段中
		if(scviDOs!=null&&scviDOs.length>0)
		{
			for(MyScviDO scvi : scviDOs)
			{
				if(!map.containsKey(scvi.getId_user()))
				{
					OrdPrintDataDTO printDTO = new OrdPrintDataDTO();
					printDTO.setPic_emp_sign(scvi.getPic());
					map.put(scvi.getId_user(), printDTO);
				}
			}
		}
		return map;
	}
}
