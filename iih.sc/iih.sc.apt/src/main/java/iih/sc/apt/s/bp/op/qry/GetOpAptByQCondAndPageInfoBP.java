package iih.sc.apt.s.bp.op.qry;

import iih.sc.apt.dto.d.OpAptDetailDTO;
import iih.sc.apt.dto.d.OpAptQryDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * 门诊预约查询
 * 
 * @author
 * @modifier zhengcm 2017-09-08 按照需求文档重新调整界面和数据
 */
public class GetOpAptByQCondAndPageInfoBP {

	/**
	 * 门诊预约查询
	 * 
	 * @param qryRootNodeDTO
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<OpAptDetailDTO> exec(OpAptQryDTO opAptQryDTO, PaginationInfo pg) throws BizException {

		PagingServiceImpl<OpAptDetailDTO> pageQryService = new PagingServiceImpl<OpAptDetailDTO>();
		SelopAptDetailSql selsql = new SelopAptDetailSql(opAptQryDTO);
		PagingRtnData<OpAptDetailDTO> datas = pageQryService.findByPageInfo(new OpAptDetailDTO(), pg,
				selsql.getQrySQLStr(), "APT.DT_B DESC ", selsql.getQryParameter(null));
		this.processDatas(datas);
		return datas;
	}

	/**
	 * 处理数据
	 *
	 * @author zhengcm
	 * 
	 * @param datas
	 * @throws BizException
	 */
	private void processDatas(PagingRtnData<OpAptDetailDTO> datas) throws BizException {
		if (datas == null || datas.getPageData() == null) {
			return;
		}
		FArrayList list = datas.getPageData();
		for (Object obj : list) {
			OpAptDetailDTO dto = (OpAptDetailDTO) obj;
			if (dto.getDt_birth() != null) {
				dto.setAge_pat(AgeCalcUtil.getAge(dto.getDt_birth()));
			}
			if (dto.getDt_b() != null) {
				dto.setD_b(dto.getDt_b());
			}
			if (dto.getDt_appt() != null) {
				dto.setD_b_appt(dto.getDt_appt());
			}
			// 登记人为token时显示对应的渠道名称 changed by zhengcm 2018-03-13
			if (!StringUtil.isEmptyWithTrim(dto.getName_emp_appt())
					&& dto.getName_emp_appt().toUpperCase().startsWith("TOKEN")) {
				dto.setName_emp_appt(dto.getName_scchl());
			}
		}
	}
}
