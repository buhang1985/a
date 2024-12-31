package iih.bl.hp.s.bp;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.DateTimeUtils;
import iih.bl.cg.i.IBlOutQryService;
import iih.bl.hp.Service.s.Bp.BlHpInteractiveWithCHISBp;
import iih.bl.hp.cihpcheckdto.d.CiHpCheckDTO;
import iih.ci.ord.i.ICiOrdQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取历史医嘱数据
 * 含IIH和CHIS的数据
 * 
 * @author yankan
 * @since 2017-09-12
 */
public class GetHisOrderListBP {
	/**
	 * 查询历史医嘱信息
	 * 
	 * @param ciHpCheckDTO
	 * @param fg_cg 是否记账 true:只提取记账医嘱；false：提取所有医嘱（已签署，未作废）
	 * @return
	 * @throws BizException
	 */
	public FArrayList2 exec(CiHpCheckDTO ciHpCheckDTO, boolean fg_cg) throws BizException {
		// 获取当前日期
		FDateTime endTime = AppUtils.getServerDateTime();
		FDateTime startTime = DateTimeUtils.getDateTimeBefore(endTime, ciHpCheckDTO.getQuerydays());

		// 1、查询IIH的医嘱数据
		// 当前医嘱返回数据 全是 已签署 与已记账的信息，医保只能收72小时内的药品处方
		ICiOrdQryService ICiOrdQryService = ServiceFinder.find(ICiOrdQryService.class);
		IBlOutQryService oqService=ServiceFinder.find(IBlOutQryService.class);
		FArrayList2 ciOrderList = oqService.getRuleEffeData(ICiOrdQryService.getCiorderDTOs(ciHpCheckDTO.getId_pat(), startTime, endTime));
		// 2、加入老CHIS的数据
		String patCode = this.getPatCode(ciHpCheckDTO.getId_pat());
		BlHpInteractiveWithCHISBp chisQryBp = new BlHpInteractiveWithCHISBp();
		CiHpCheckDTO ciChkChisDTO = chisQryBp.getCiHpCheckDTOFromCHIS(patCode);
		if (ciChkChisDTO != null && ciChkChisDTO.getHistorycidto() != null) {
			if (ciOrderList == null) {
				ciOrderList = new FArrayList2();
			}
			ciOrderList.addAll(ciChkChisDTO.getHistorycidto());
		}
		return ciOrderList;
	}

	/**
	 * 获取患者code
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private String getPatCode(String patId) throws BizException {
		String sql = "SELECT CODE FROM PI_PAT WHERE ID_PAT=?";
		SqlParam param = new SqlParam();
		param.addParam(patId);

		String patCode = (String) new DAFacade().execQuery(sql, param, new ColumnHandler());
		return patCode;
	}
}
