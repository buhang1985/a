package iih.pe.papi.i.his;


import java.util.List;

import iih.pe.papt.dto.peitfchargedto.d.PeItfChargeDTO;
import iih.pe.papt.dto.peitfchargedto.d.PeItfChargeGroupDTO;
import iih.pe.papt.dto.peitfchargedto.d.PeItfPatDTO;
import iih.pe.papt.dto.peitfrefunddto.d.PeItfRefundDTO;
import iih.pe.papt.dto.peitfsvrsdto.d.PeItfSvrsDTO;
import iih.pi.reg.dto.pipeqry.d.PiPeQryCondDTO;
import iih.pi.reg.dto.pipeqry.d.PiPeQryRltDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public interface IChargeService {
	//入参接口
	public abstract PeItfChargeDTO[] peChargeConnectBl (PeItfPatDTO peItfPatDTO) throws BizException;
	//出参接口 Pi回传PE
	public abstract FBoolean piBackpassPe (PeItfChargeDTO[] peItfPatDTO) throws BizException;
	
	//团体Id返回预约单号
	public abstract PeItfChargeGroupDTO[] peChargeConnectBlGroup (PeItfChargeGroupDTO peItfChargeGroupDTO) throws BizException;
	//预约单返回相应费用
	public abstract PeItfChargeDTO[] piBackpassPeGroup (PeItfChargeGroupDTO[] peItfChargeGroupDTO) throws BizException;
	//回传
	public abstract FBoolean piBackpassPeGroupFgpaid (PeItfChargeDTO[] peItfPatDTO) throws BizException;
	//体检个人退费接口
	public abstract PeItfRefundDTO[] peRefund(PeItfSvrsDTO[] peItfSvrsDTO) throws BizException ;
	//查询接口
	public abstract PiPeQryRltDTO piFindPe(PiPeQryCondDTO piPeQryCondDTO) throws BizException ;
}
