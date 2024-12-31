package iih.bd.mm.materialnames.s.bp.savebp;

import java.util.ArrayList;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.mm.materialnames.d.MaterialNamesDO;
import iih.bd.mm.materialnames.d.MaterialnamesAggDO;
import iih.bd.pp.accountsrv.i.IAccountsrvExtCudService;
import iih.bd.pp.accountsrvrel.d.MedsrvAccountRelDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 更新通用名与核算项目关系业务逻辑
 * 
 * @author hao_wu 2018-10-27
 *
 */
public class UpdateSrvAccRelBp {

	public void exec(MaterialnamesAggDO[] materialNameAggs) throws BizException {
		if (ArrayUtils.isEmpty(materialNameAggs)) {
			return;
		}

		updateSrvAccRel(materialNameAggs);
	}

	/**
	 * 更新通用名与核算项目关系
	 * 
	 * @param materialNameAggs
	 * @throws BizException
	 */
	private void updateSrvAccRel(MaterialnamesAggDO[] materialNameAggs) throws BizException {
		ArrayList<MedsrvAccountRelDTO> srvAccRelDtoList = new ArrayList<MedsrvAccountRelDTO>();
		for (MaterialnamesAggDO materialnamesAggDO : materialNameAggs) {
			MedsrvAccountRelDTO srvAccRelDto = getSrvAccRelDto(materialnamesAggDO);
			if (srvAccRelDto != null) {
				srvAccRelDtoList.add(srvAccRelDto);
			}
		}

		IAccountsrvExtCudService accountsrvExtCudService = ServiceFinder.find(IAccountsrvExtCudService.class);
		accountsrvExtCudService.updateMedsrvAccountRel(srvAccRelDtoList.toArray(new MedsrvAccountRelDTO[0]));
	}

	/**
	 * 根据药品通用名构建关系DTO
	 * 
	 * @param materialnamesAggDO
	 * @return
	 */
	private MedsrvAccountRelDTO getSrvAccRelDto(MaterialnamesAggDO materialnamesAggDO) {
		if (materialnamesAggDO == null) {
			return null;
		}

		MaterialNamesDO materialNamesDO = materialnamesAggDO.getParentDO();
		if (materialNamesDO == null) {
			return null;
		}

		MedsrvAccountRelDTO srvAccRelDto = new MedsrvAccountRelDTO();
		srvAccRelDto.setId_srv(materialNamesDO.getId_materialname());
		srvAccRelDto.setId_account(materialNamesDO.getId_account_gy());
		srvAccRelDto.setId_account_op(materialNamesDO.getId_account_mz());
		srvAccRelDto.setId_account_ip(materialNamesDO.getId_account_zy());
		return srvAccRelDto;
	}
}
