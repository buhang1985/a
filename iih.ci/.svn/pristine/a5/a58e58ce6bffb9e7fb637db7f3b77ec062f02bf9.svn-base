package iih.ci.ord.s.bp;

import java.util.HashMap;
import java.util.Map;

import iih.bl.cg.dto.d.BLCgIpOutInfoDTO;
import iih.bl.cg.dto.d.BLCgIpOutQryDTO;
import iih.bl.cg.i.IBlOutQryService;
import iih.ci.ord.ciordqry.d.CiOrdQryItemDTO;
import iih.ci.ord.ordfilter.d.CiOrderFilterDTO;
import iih.ci.ord.s.bp.qry.GetOrdItem4BlBpQry;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class GetOrdItem4BlBp {
	
	public CiOrdQryItemDTO[] exe(CiOrderFilterDTO filterdto) throws BizException {
		GetOrdItem4BlBpQry qry=new GetOrdItem4BlBpQry(filterdto);
		CiOrdQryItemDTO[] rnt =(CiOrdQryItemDTO[])AppFwUtil.getDORstWithDao(qry, CiOrdQryItemDTO.class);
		if(rnt==null||rnt.length==0)return rnt;
		BLCgIpOutQryDTO qryDto=new BLCgIpOutQryDTO();
		qryDto.setId_ent(filterdto.getId_en());
		FArrayList fa=new FArrayList();
		Map<String,CiOrdQryItemDTO> map=new HashMap<>();
		for (CiOrdQryItemDTO c : rnt) {
			if(c.getId_or()!=null) {
				c.setAcount_amount(new FDouble("0"));
				fa.add(c.getId_or());
				map.put(c.getId_or(), c);
			}
		}
		qryDto.setId_ors(fa);
		IBlOutQryService service=ServiceFinder.find(IBlOutQryService.class);
		BLCgIpOutInfoDTO[] cglist= service.getCgIpTotalInfo( qryDto);
		if(cglist!=null&&cglist.length>0) {
			for (BLCgIpOutInfoDTO b : cglist) {
				FDouble amt=b.getAmt();
				CiOrdQryItemDTO c=map.get(b.getId_or());
				if(c!=null) {
					c.setAcount_amount(amt);
				}
			}
		}
		return rnt;
	}

}
