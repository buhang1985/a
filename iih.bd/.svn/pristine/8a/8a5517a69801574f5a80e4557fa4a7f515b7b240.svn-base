package iih.bd.pp.service.s;

import java.util.ArrayList;
import java.util.List;

import iih.bd.pp.bdpriboil.d.BdPriBoilDO;
import iih.bd.pp.bdpriboil.i.IBdpriboilRService;
import iih.bd.pp.bdprisamp.bp.BdPriSampBp;
import iih.bd.pp.bdprisamp.d.BdPriSampDO;
import iih.bd.pp.dto.bltpl.d.BlTplDTO;
import iih.bd.pp.dto.d.PriStdSrvDTO;
import iih.bd.pp.dto.d.PricelistqrySrvDTO;
import iih.bd.pp.pricelistqry.bp.PricelistqryBp;
import iih.bd.pp.primd.i.IPriCalService;
import iih.bd.pp.service.bp.GetBlTplInfoBP;
import iih.bd.pp.service.i.IPriQueService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

@Service(serviceInterfaces={IPriQueService.class}, binding=Binding.JSONRPC)
public class PriQueServiceImpl implements IPriQueService {

	/**
	 * 根据标本类型查询标本采集费用对照
	 * @param sd_samptp 标本类型
	 * @return 标本采集费用对照
	 * @throws BizException
	 */
	@Override
	public BdPriSampDO[] getBdPriSampDOBySampTp(String sd_samptp)
			throws BizException {
		BdPriSampBp bp=new BdPriSampBp();
		return bp.getBdPriSampDOBySampTp(sd_samptp);
	}
	
	/**
	 * 取得费用模板信息
	 * @param deptId 责任科室
	 * @param empId 责任人
	 * @param containHos 包含院级模板
	 * @return 费用模板信息
	 * @throws BizException
	 * @author ly 2016/08/02
	 */
	@Override
	public BlTplDTO[] getBlTplInfo(String deptId,String empId,FBoolean containHos) throws BizException{
		GetBlTplInfoBP bp = new GetBlTplInfoBP();
		return bp.exec(deptId, empId, containHos);
	}
	/**
	 * 计算煎法的标准费用
	 * @param Id_priboil 煎法
	 * @return 费用PriStdSrvDTO
	 * @throws BizException
	 */
	public PriStdSrvDTO[] getPriStdSrvDTOByBoil(String Id_priboil) throws BizException
	{
		IPriCalService IPriCalService=ServiceFinder.find(IPriCalService.class);
		IBdpriboilRService iBdpriboilRService=ServiceFinder.find(IBdpriboilRService.class);
		BdPriBoilDO[] bdPriBoilDOArr=iBdpriboilRService.find(" Id_boil='"+Id_priboil+"'", "", FBoolean.FALSE);
		List<PriStdSrvDTO> priStdSrvDTOLst=new ArrayList<PriStdSrvDTO>();
		for(BdPriBoilDO bdPriBoilDO: bdPriBoilDOArr)
		{
			PriStdSrvDTO priStdSrvDTO=new PriStdSrvDTO();
			priStdSrvDTO.setId_srv(bdPriBoilDO.getId_srv());
			priStdSrvDTO.setQuan(bdPriBoilDO.getQuan_medu());
			priStdSrvDTOLst.add(priStdSrvDTO);
		}
		PriStdSrvDTO[] PriStdSrvDTOArr=IPriCalService.CalManySrvsStdPrices(priStdSrvDTOLst.toArray(new PriStdSrvDTO[0]));
		return PriStdSrvDTOArr;
	}

	/**
	 * 通过服务的主键获得服务的本服务定价的价格列表
	 * @param 服务主键
	 * @return
	 * @throws BizException
	 */
	@Override
	public PricelistqrySrvDTO[] getPricelistqrySrvDTOByIdsrv(String id_srv)
			throws BizException {
		// TODO Auto-generated method stub
		PricelistqryBp bp = new PricelistqryBp();
		return  bp.getPricelistqrySrvDTOByIdsrv(id_srv);
	}
	
	/**
	 * 通过字符串获得服务列表
	 * @param 搜索字符串
	 * @return
	 * @throws BizException
	 */
	@Override
	public PricelistqrySrvDTO[] getSrvlistByQrynamesrv(String qryNamesrv) throws BizException {
		PricelistqryBp bp = new PricelistqryBp();
		return  bp.getSrvlistByQrynamesrv(qryNamesrv);
	}

	@Override
	public PagingRtnData<PricelistqrySrvDTO> findByQCondAndPageInfo(
			QryRootNodeDTO qryRootNodeDTO, String orderStr, PaginationInfo pg)
			throws BizException {
		// TODO Auto-generated method stub
		PricelistqryBp bp = new PricelistqryBp();
		return  bp.findByQCondAndPageInfo(qryRootNodeDTO,orderStr,pg);
	}

}
