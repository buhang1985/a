package iih.ei.std.s.v1.bp.mp.pivas;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.base.utils.ArrayListUtil;
import iih.ei.std.d.v1.mp.pivasdata.d.PivasIpOrderParamDTO;
import iih.ei.std.d.v1.mp.pivasdata.d.PivasIpOrderRstDTO;
import iih.ei.std.d.v1.mp.pivasdata.d.PivasOrderListDTO;
import iih.ei.std.d.v1.mp.pivasdata.d.PivasOrderResultBeanDTO;
import iih.ei.std.s.v1.bp.mp.pivas.qry.GetIpOrdersQry;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class QueryPivasOrPrBp {

	/**
	 * 主入口
	 * 
	 * @param statusParam
	 * @throws BizException
	 */
	public PivasOrderListDTO exec(PivasIpOrderParamDTO param) throws BizException {

		// 初始化参数条件
		PivasIpOrderParamDTO paramDTO = this.initParamDTO(param);

		// 获取在院有效医嘱
		PivasIpOrderRstDTO[] rstDTOs = this.getOrderList(paramDTO);

		// 数据转换
		return this.initResult(rstDTOs);
	}

	/**
	 * 初始化入参
	 * @param param
	 * @return
	 */
	private PivasIpOrderParamDTO initParamDTO(PivasIpOrderParamDTO param) {

		param.setFg_ip("Y");
		param.setFg_sign("Y");
		param.setFg_chk("Y");
		return param;
	}

	/**
	 * 获取在院有效医嘱
	 * @param paramDTO
	 * @return
	 * @throws BizException
	 */
	private PivasIpOrderRstDTO[] getOrderList(PivasIpOrderParamDTO paramDTO) throws BizException {
		GetIpOrdersQry seqQry = new GetIpOrdersQry(paramDTO);
		PivasIpOrderRstDTO[] rstDTOs = (PivasIpOrderRstDTO[]) AppFwUtil.getDORstWithDao(seqQry,PivasIpOrderRstDTO.class);
		return rstDTOs;
	}

	/**
	 * 数据转换
	 * @param rstDTOs
	 * @return
	 */
	private PivasOrderListDTO initResult(PivasIpOrderRstDTO[] rstDTOs) {
		PivasOrderListDTO resultBean = new PivasOrderListDTO();
		List<PivasOrderResultBeanDTO> orderList = new ArrayList<PivasOrderResultBeanDTO>();
		if (rstDTOs == null || rstDTOs.length <= 0) {
			return resultBean;
		}
		for (PivasIpOrderRstDTO rstDTO : rstDTOs) {
			PivasOrderResultBeanDTO orderBean = new PivasOrderResultBeanDTO();
			orderBean.setGroupno(rstDTO.getCode_or());
			orderBean.setRecipeno(rstDTO.getCode_or_itm());
			orderBean.setWardcode(rstDTO.getCode_dep_nur_or());
			orderBean.setBedno(rstDTO.getName_bed());
			orderBean.setPatientcode(rstDTO.getCode_pat());
			orderBean.setCaseid(rstDTO.getCode_amr_ip());
			orderBean.setDoctorcode(rstDTO.getCode_emp_or());
			orderBean.setDoctorname(rstDTO.getName_emp_or());
			orderBean.setDrawercode(rstDTO.getCode_emp_chk());
			orderBean.setDrawername(rstDTO.getName_emp_chk());
			orderBean.setFreqcode(rstDTO.getCode_freq());
			orderBean.setFreqname(rstDTO.getName_freq());
			orderBean.setUsagecode(rstDTO.getName_route());
			orderBean.setDrugcode(rstDTO.getCode_or_srv());
			orderBean.setDrugname(rstDTO.getName_or());
			orderBean.setSpec(rstDTO.getSpec());
			orderBean.setDosage(rstDTO.getQuan_medu());
			orderBean.setDosageunit(rstDTO.getName_medu());
			FDouble quantity = (new FDouble(rstDTO.getQuan_num_base()).div(new FDouble(rstDTO.getQuan_den_base()))).setScale(4, FDouble.ROUND_HALF_UP);
			orderBean.setQuantity(quantity.toString());
			orderBean.setQuantityunit(rstDTO.getName_pgku_base());
			orderBean.setSd_su_or(rstDTO.getSd_su_or());
			orderBean.setStartdt(rstDTO.getDt_effe());
			String dt_end = StringUtils.isBlank(rstDTO.getDt_end()) ? " " : rstDTO.getDt_end();
			orderBean.setEnddt(dt_end);
			orderBean.setRemark(" ");
			orderBean.setTpn(" ");
			orderList.add(orderBean);
		}
		resultBean.setOrderitems(ArrayListUtil.ConvertToFArrayList(orderList));
		return resultBean;
	}
}
