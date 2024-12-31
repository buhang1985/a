package iih.ci.mrm.s.param;


import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import iih.ci.mrm.bp.common.CiMrMParamUtils;
import iih.ci.mrm.i.param.ICiMrMParamService;

@Service(serviceInterfaces = {ICiMrMParamService.class }, binding = Binding.JSONRPC)
public class CiMrMParamServiceImpl implements ICiMrMParamService{

	
	@Override
	public Boolean getSysParamComPleteGenerateEle(String id_org) {
		// TODO Auto-generated method stub
		return CiMrMParamUtils.getSysParamComPleteGenerateEle(id_org);
	}

	@Override
	public Boolean getSysParamPrintFirstFree(String id_org) {
		// TODO Auto-generated method stub
		return CiMrMParamUtils.getSysParamPrintFirstFree(id_org);
	}

	@Override
	public String getSysParamPrintCharge(String id_org) {
		// TODO Auto-generated method stub
		return CiMrMParamUtils.getSysParamPrintCharge(id_org);
	}
	
	@Override
	public Boolean getSysParamStorageAddInfo(String id_org) {
		// TODO Auto-generated method stub
		return CiMrMParamUtils.getSysParamStorageAddInfo(id_org);
	}

	@Override
	public String getSysParamSaveFormat(String id_org) {
		// TODO Auto-generated method stub
		return CiMrMParamUtils.getSysParamSaveFormat(id_org);
	}

	@Override
	public String getSysParamFilePrefix(String id_org) {
		// TODO Auto-generated method stub
		return CiMrMParamUtils.getSysParamFilePrefix(id_org);
	}

	@Override
	public String getSysParamNumLength(String id_org) {
		// TODO Auto-generated method stub
		return CiMrMParamUtils.getSysParamNumLength(id_org);
	}

	@Override
	public String getSysParamWaterMark(String id_org) {
		// TODO Auto-generated method stub
		return CiMrMParamUtils.getSysParamWaterMark(id_org);
	}

	@Override
	public Boolean getSysParamCheckAdvancePay(String id_org) {
		// TODO Auto-generated method stub
		return CiMrMParamUtils.getSysParamCheckAdvancePay(id_org);
	}

	@Override
	public Boolean getSysParamCheckUnprinted(String id_org) {
		// TODO Auto-generated method stub
		return CiMrMParamUtils.getSysParamCheckUnprinted(id_org);
		
	}
}
