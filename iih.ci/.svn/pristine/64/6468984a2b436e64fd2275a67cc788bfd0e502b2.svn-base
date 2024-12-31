package iih.ci.ord.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dto.blexorder.d.OrSplitOrderDTO;
import iih.ci.ord.dto.blexorder.d.OrSrvSplitParamDTO;
import iih.ci.ord.dto.blexorder.d.SrvSplitOrderDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.s.bp.orsrvsplit.GetOrAndSrvSplitSqlRsBP;
import iih.ci.ord.s.bp.orsrvsplit.SplitOrAndSrvSplitSqlRsBP;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

public class splitOrSplitSqlRsBP {
	
	public OrSplitOrderDTO[] exec(OrSrvSplitParamDTO param)throws BizException{
		
//		IUdidocServiceExt udiext=ServiceFinder.find(IUdidocServiceExt.class);
//		 UdidocDO[] Udis=udiext.findByUdidoclistCode("BD.SRV.0505");
//		 String str="";
//		 for (UdidocDO udidocDO : Udis) {
//			 String code=udidocDO.getCode();
//			if((code.startsWith("0101")||code.startsWith("0102"))&&!code.equals("010104")&&!code.equals("010105")){
//				str+=udidocDO.getCode()+",";
//			}
//		}
//		 param.setSd_srvtps(str.substring(0, str.length()-1));
//		GetOrAndSrvSplitSqlRsBP getsrvbp=new GetOrAndSrvSplitSqlRsBP();
		getMpSplitDataBP getsrvbp=new getMpSplitDataBP();
        BaseDTO[] splitDTO=getsrvbp.exec(param);
//        SplitOrAndSrvSplitSqlRsBP bp=new SplitOrAndSrvSplitSqlRsBP();
//        BaseDTO[] srvsplitDTO=bp.exec(splitDTO, param.getDt_split_start(), param.getDt_split_end(), param.getEu_orgensplittp());
//        return (OrSplitOrderDTO[])srvsplitDTO;
        return srv2Ord(splitDTO);
		
	}
	
	private OrSplitOrderDTO[] srv2Ord(BaseDTO[] splitDTO) {
		if(splitDTO==null)return null;
		List<OrSplitOrderDTO> result=new ArrayList<>();
		for (BaseDTO o : splitDTO) {
			SrvSplitOrderDTO d=(SrvSplitOrderDTO)o;
			OrSplitOrderDTO ord=new OrSplitOrderDTO();
			ord.setId_or(d.getId_or());
			ord.setName_or(d.getName_or());
			ord.setDt_effe(d.getDt_effe());
			ord.setDt_mp_plan(d.getDt_mp_plan());
			ord.setOr_mp_status(d.getOr_mp_status());
			ord.setSd_frequnit(d.getSd_frequnit());
			ord.setId_orsrvtp(d.getId_orsrv());;
			ord.setSd_orsrvtp(d.getSd_orsrvtp());
			result.add(ord);
		}
		return result.toArray(new OrSplitOrderDTO[0]);
	}

}
