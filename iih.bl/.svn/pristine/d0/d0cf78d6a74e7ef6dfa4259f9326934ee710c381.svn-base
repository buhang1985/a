package iih.bl.cc.s.bp;

import iih.bl.cc.blccdto.d.BlPayPatIpDTO;
import iih.bl.cc.blccdto.d.BlpayOepPatDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 获取住院收付款总额
 * @author yangyang
 */
public class GatherIpPayFeeBp {
	
	public FDouble exec(FMap map) throws BizException{
		BlPayPatIpDTO[] paypatIpDtoArr=null;
		if(map.isEmpty()){
			return new FDouble();
		}
		IpCcPayPatDetailQry qry=new IpCcPayPatDetailQry(map);
		paypatIpDtoArr=(BlPayPatIpDTO[])AppFwUtil.getDORstWithDao(qry, BlPayPatIpDTO.class) ;
		FDouble amt=FDouble.ZERO_DBL;
		for(BlPayPatIpDTO dto:paypatIpDtoArr){
			if(!StringUtil.isEmpty(dto.getAmt_payitm().toString()) && !StringUtil.isEmpty(dto.getPayitem_eudirect().toString()) )
			{
				amt=amt.add(dto.getAmt_payitm().multiply(dto.getPayitem_eudirect()));
			}
		}
		return amt;
	}
}
