package iih.ei.std.s.v1.bp.sc;

import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.ei.std.d.v1.commdto.d.NoParamDTO;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import iih.ei.std.d.v1.en.ipinfo.d.IpInfoListDTO;
import iih.ei.std.d.v1.sc.mtscca.d.MtScCaDTO;
import iih.ei.std.d.v1.sc.mtscca.d.MtScCaParamDTO;
import iih.ei.std.d.v1.sc.mtscca.d.MtScCaResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetMtScCaListBP extends IIHServiceBaseBP<MtScCaParamDTO, MtScCaResultDTO> {

	@Override
	protected void checkParam(MtScCaParamDTO mtScCaParamDTO) throws BizException {
	}

	@Override
	protected MtScCaResultDTO process(MtScCaParamDTO param) throws BizException {
		return getResult(param);
	}
	
	/**
	 * 获取医技项目分类字典
	 * 
	 * @author yzh
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private MtScCaResultDTO getResult(MtScCaParamDTO inparam) throws BizException {
		SqlParam param = new SqlParam();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("select id_scca as id_scca,code,name,wbcode,pycode from sc_ca where sd_sctp =? and fg_active=? ");
		param.addParam(IScDictCodeConst.SD_SCTP_MT);
		param.addParam("Y");
		sqlBuilder.append("ORDER BY CODE ");
		PageInfoDTO pageInfoDto = (PageInfoDTO) inparam.getPageinfo().get(0);
		List<MtScCaDTO> list = this.findPagingData(pageInfoDto,sqlBuilder.toString(), param, MtScCaDTO.class);
		MtScCaResultDTO mtScCaResultDTO = new MtScCaResultDTO();
		mtScCaResultDTO.setMtsccadto(ArrayListUtil.ConvertToFArrayList(list));
		return mtScCaResultDTO;
	}

}
