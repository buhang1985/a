package iih.pmp.pay.s.bp;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;

import org.apache.commons.lang.StringUtils;

import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ord.d.OrdStatusEnum;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.trade.d.BillChekRst;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.PmpPayAppUtils;

public class CreateOrderBP {
	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();

	public OrdDO createOrd(OrdReqDTO dto) throws BizException {
		if (dto == null || pmputils.isStrEmpty(dto.getOrd_no()))
			return null;
		if (StringUtils.isBlank(dto.getId_user_req())) {
			throw new BizException("请求用户不允许为空");
		}
		OrdDO ord = new OrdDO();
		String code = PmpPayAppUtils.getOrderCode();
		if (code == null)
			return null;
		ord.setCode(code);
		ord.setBody(dto.getBody());
		ord.setSubject(dto.getSubject());
		ord.setAmount(dto.getAmount());
		ord.setAmount_bk(dto.getAmount());
		ord.setOrd_no(dto.getOrd_no());
		ord.setDt_ord(pmputils.getServerDateTime());
		ord.setOrd_status(OrdStatusEnum.UNKNOWN);
		ord.setId_chl(PmpPayConst.getUdiID(dto.getSd_chl(), PmpPayConst.CHANNEL_DOCLIST_ID));
		ord.setSd_chl(dto.getSd_chl());
		ord.setSd_scene(dto.getSd_scene());
		ord.setId_scene(PmpPayConst.getUdiID(dto.getSd_scene(), PmpPayConst.SCENE_DOCLIST_ID));
		ord.setSpbill_create_ip(dto.getSpbill_create_ip());
		ord.setId_emp_op(dto.getId_user_req());
//		ord.setId_emp_op(pmputils.getId_Stuff(null));// ????自助机或his是否也能获取
		ord.setId_org(pmputils.getEnvContext().getOrgId());// ????自助机或his是否也能获取
		ord.setId_grp(pmputils.getEnvContext().getGroupId());
		ord.setStatus(DOStatus.NEW);
		ord.setId_pat(dto.getId_pat());
		ord.setCheck_rst(BillChekRst.UNCHECK);
		ord.setDeviceinfo(dto.getDeviceinfo());
		ord.setTradetype(dto.getTradetype());
		ord.setSd_bizscene(dto.getBiz_scene());
		ord.setId_bizscene(PmpPayConst.getUdiID(dto.getBiz_scene(), PmpPayConst.BIZ_SCENE_DOCLIST_ID));
		ord.setId_pri_pm(dto.getId_pri_pm());
		OrdDO[] ordarr = pmputils.getOrdCudService().save(new OrdDO[] { ord });
		if (ordarr != null && ordarr.length > 0)
			return ordarr[0];
		return null;
	}

}
