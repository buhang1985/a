package iih.ei.std.i.v1;

import iih.ei.std.d.v1.mr.deletemrmfile.d.DeletemrmfileParamDTO;
import iih.ei.std.d.v1.mr.deletemrmfile.d.DeletemrmfileResultDTO;
import iih.ei.std.d.v1.mr.downloadmrmfileinfo.d.DownLoadMrmFileInfoParamDTO;
import iih.ei.std.d.v1.mr.downloadmrmfileinfo.d.DownLoadMrmFileInfoResultDTO;
import iih.ei.std.d.v1.mr.thirdpartypdfdto.d.ThirdPartyPDFParamDTO;
import iih.ei.std.d.v1.mr.thirdpartypdfdto.d.ThirdPartyPDFResultDTO;
import xap.mw.core.data.BizException;

/***
 * IIH基础数据域标准对外接口（XML格式）
 * 
 * @author 病历
 * @date: 2019-10-29
 */
public interface IMrApiService {

	/**
	 * 接收第三方pdf（病案系统）
	 * 
	 * @param param
	 * @return 
	 */
	public ThirdPartyPDFResultDTO getThirdPartyPDF(ThirdPartyPDFParamDTO param) throws BizException;
	
	/**
	 * 服务端通用文件下载
	 * 
	 * @param param
	 * @return 
	 */
	public DownLoadMrmFileInfoResultDTO DownLoadMrmFileInfo(DownLoadMrmFileInfoParamDTO param) throws BizException;
	
	/**
	 * 第三方删除病案文件
	 * 
	 * @param param
	 * @return 
	 */
	public DeletemrmfileResultDTO DeleteMrmFile(DeletemrmfileParamDTO param) throws BizException;
}
