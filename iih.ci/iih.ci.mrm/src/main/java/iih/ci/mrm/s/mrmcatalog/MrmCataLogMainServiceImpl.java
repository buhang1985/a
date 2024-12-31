package iih.ci.mrm.s.mrmcatalog;


import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import iih.ci.mrm.dto.mrmcatalog.d.MrmCatalogCheckResultDTO;
import iih.ci.mrm.i.mrmcatalog.IMrmCataLogMainService;
import iih.ci.mrm.s.mrmcatalog.bp.MrmCataListMainSubmitBP;
import iih.ci.mrm.s.mrmcatalog.bp.MrmCataMainCopyDataBP;
import iih.ci.mrm.s.mrmcatalog.bp.MrmCatalogMainCheckDataBP;

/**
 * 扼要说明：病案编目的主要逻辑
 * @author 张静波
 * @date 2018年8月31日 下午7:59:26
 */
@Service(serviceInterfaces={IMrmCataLogMainService.class}, binding=Binding.JSONRPC)
public class MrmCataLogMainServiceImpl implements IMrmCataLogMainService {

	@Override
	public FBoolean saveMrmfpByMrfp(String id_ent) throws BizException {
		// TODO Auto-generated method stub
		MrmCataMainCopyDataBP bp = new MrmCataMainCopyDataBP(); 
		return bp.saveMrmfpByMrfp(id_ent);

	}	
	@Override
	public FBoolean reSetMrmfp(String id_ent) throws BizException {
		// TODO Auto-generated method stub
		MrmCataMainCopyDataBP bp = new MrmCataMainCopyDataBP(); 
		bp.deleteMrmCataData(id_ent);
		return bp.saveMrmfpByMrfp(id_ent);

	}
	@Override
	public MrmCatalogCheckResultDTO[] checkCatalongData(String sqlFixWhere) throws BizException
	{
		MrmCatalogMainCheckDataBP bp = new MrmCatalogMainCheckDataBP();
		return bp.checkCatalongData(sqlFixWhere);
	}
	@Override
	public FBoolean cataLogSubmit(String id_ent,String id_cata_user,String id_cata_dep) throws BizException
	{
		MrmCataListMainSubmitBP bp = new MrmCataListMainSubmitBP();
		return bp.cataLogSubmit(id_ent, id_cata_user, id_cata_dep);
	}
	
	

	
	
}
