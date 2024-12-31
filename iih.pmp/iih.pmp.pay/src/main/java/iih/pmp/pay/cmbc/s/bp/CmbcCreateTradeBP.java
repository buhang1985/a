package iih.pmp.pay.cmbc.s.bp;

import java.util.Map;

import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordqryrstdto.d.OrdQryRstDTO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.BizStatusEnum;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.s.bp.CreateOrderBP;
import iih.pmp.pay.trade.d.TradeDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;


public class CmbcCreateTradeBP {
	
	public OrdRstDTO exec(OrdReqDTO dto) throws BizException {
		if (dto == null || dto.getOrd_no() == null)
			return null;
	
		CmbcPayUtils utils=new CmbcPayUtils();
		OrdRstDTO rnt = null;
		CmbcPayValidator validatebp=new CmbcPayValidator();
		OrdQryRstDTO rst = new OrdQryRstDTO();
		rst.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
		Map<String, Object> resultmap = validatebp.isOrdcanPay(dto, rst);
		boolean flag = (boolean) resultmap.get("flag");
		if (flag) {
			// todo
			// 如果订单不存在,则创建订单
			OrdDO ord = null;
			if (resultmap.containsKey("orddo")) {
				ord = (OrdDO) resultmap.get("orddo");
			} else {
				ord = new CreateOrderBP().createOrd(dto);
			}
			TradeDO tra = null;
			if (ord != null) {
				FBoolean fg = FBoolean.FALSE;
				tra = utils.createPayTradeDo(ord, fg, dto);
			}

			if (tra == null) {
				rnt = getFailRst(dto, rst);
				rnt.setMsg("订单创建失败");
				return rnt;
			}

			if (rnt == null)
				rnt = new OrdRstDTO();
			rnt.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
			rnt.setTrade_no(tra.getTrade_no());
			rnt.setTradetime(tra.getDt_req());
			rnt.setSv(tra.getSv());
		} else {
			String err = rst.getErr_code_des();
			// throw new BizException(err);
			if (rnt == null)
				rnt = getFailRst(dto, rst);

			rnt.setMsg(err);
		}
		return rnt;
	}
	
	private OrdRstDTO getFailRst(OrdReqDTO dto, OrdQryRstDTO rst) {

		OrdRstDTO rnt = new OrdRstDTO();
		rnt.setTrade_no(rst.getTrade_no());
		rnt.setTradetime(rst.getTradetime());
		rnt.setAmount(rst.getAmount());
		rnt.setSv(dto.getSv());
		rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
		return rnt;
	}


}
