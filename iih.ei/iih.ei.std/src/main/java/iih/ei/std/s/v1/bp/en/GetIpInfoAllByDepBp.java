package iih.ei.std.s.v1.bp.en;

import java.util.List;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import iih.ei.std.d.v1.en.ipinfo.d.IpInfoAllResultDTO;
import iih.ei.std.d.v1.en.ipinfo.d.IpInfoByDepParamDTO;
import iih.ei.std.d.v1.en.ipinfo.d.IpInfoListDTO;
import iih.ei.std.d.v1.en.ipinfo.d.IpInfoParamDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.kernel.SqlParam;

public class GetIpInfoAllByDepBp extends IIHServiceBaseBP<IpInfoByDepParamDTO, IpInfoAllResultDTO> {
	
	public static final Integer CHECK_STATUS = 4; //住院的几种状态
	
	@Override
	protected void checkParam(IpInfoByDepParamDTO param) throws BizException {
		if (StringUtil.isEmpty(param.getSd_status())) {
			throw new BizException("查询状态不能为空");
		}
		//查询状态必须在  22入院 25入科 28出院 2a退院
		Integer count = 0;//计数
		if(!IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN.equals(param.getSd_status()))
			count++;
		if(!IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN.equals(param.getSd_status()))
		    count++; 		
		if(!IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT.equals(param.getSd_status()))
			count++;
		if(!IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALQUIT.equals(param.getSd_status()))
			count++;
		if(CHECK_STATUS==count){
			throw new BizException("查询状态必须在 22入院 25入科 28出院 2a退院");	
		}
	}

	@Override
	protected IpInfoAllResultDTO process(IpInfoByDepParamDTO param) throws BizException {
		GetIpInfoUtilsBP getIpInfoUtilsBP = new GetIpInfoUtilsBP();
		//1.取sql 和 sql参数，按分页查id_ent
		StringBuilder sqlSb = new StringBuilder();
		SqlParam sqlparam = new SqlParam(); 
		IpInfoParamDTO infoParamDTO = setValue(param);
		getIpInfoUtilsBP.getSqlAndParam(infoParamDTO,sqlSb,sqlparam);
		PageInfoDTO pageInfoDto = (PageInfoDTO) param.getPageinfo().get(0);
		List<IpInfoListDTO> list = this.findPagingData(pageInfoDto,sqlSb.toString(), sqlparam, IpInfoListDTO.class);
		//2.查具体字段
		return getIpInfoUtilsBP.getResultsAll(list.toArray(new IpInfoListDTO[list.size()]), infoParamDTO);
	}

	private IpInfoParamDTO setValue(IpInfoByDepParamDTO param) {
		IpInfoParamDTO dto = new IpInfoParamDTO();
		dto.setCode_dep(param.getCode_dep());
		dto.setCode_nur(param.getCode_nur());
		dto.setDate_b_in(param.getDate_b_in());
		dto.setDate_b_out(param.getDate_b_out());
		dto.setDate_e_in(param.getDate_e_in());
		dto.setDate_e_out(param.getDate_e_out());
		dto.setSd_status(param.getSd_status());
		dto.setDate_b_update(param.getDate_b_update());
		dto.setDate_e_update(param.getDate_e_update());
		return dto;
	}

}
