package iih.ei.std.s.v1;

import iih.ei.std.d.v1.mr.deletemrmfile.d.DeletemrmfileParamDTO;
import iih.ei.std.d.v1.mr.deletemrmfile.d.DeletemrmfileResultDTO;
import iih.ei.std.d.v1.mr.downloadmrmfileinfo.d.DownLoadMrmFileInfoParamDTO;
import iih.ei.std.d.v1.mr.downloadmrmfileinfo.d.DownLoadMrmFileInfoResultDTO;
import iih.ei.std.d.v1.mr.thirdpartypdfdto.d.ThirdPartyPDFParamDTO;
import iih.ei.std.d.v1.mr.thirdpartypdfdto.d.ThirdPartyPDFResultDTO;
import iih.ei.std.i.v1.IMrApiService;
import iih.ei.std.s.v1.bp.mr.DeletemrmfileBp;
import iih.ei.std.s.v1.bp.mr.DownLoadMrmFileInfoBp;
import iih.ei.std.s.v1.bp.mr.MrGetThirdPartyPDFBp;
import xap.mw.core.data.BizException;

/***
 * IIH基础数据域标准对外接口（XML格式）
 * 
 * @author 病历
 * @date: 2019-10-29
 */
public class MrApiServiceImpl implements IMrApiService{

	@Override
	public ThirdPartyPDFResultDTO getThirdPartyPDF(ThirdPartyPDFParamDTO param) throws BizException {
		return new MrGetThirdPartyPDFBp().exec(param);
	}

	@Override
	public DownLoadMrmFileInfoResultDTO DownLoadMrmFileInfo(DownLoadMrmFileInfoParamDTO param) throws BizException {
		return new DownLoadMrmFileInfoBp().exec(param);
	}

	@Override
	public DeletemrmfileResultDTO DeleteMrmFile(DeletemrmfileParamDTO param) throws BizException {
		return new DeletemrmfileBp().exec(param);
	}

}
